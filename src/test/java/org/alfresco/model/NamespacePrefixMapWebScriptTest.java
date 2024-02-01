package org.alfresco.model;

import org.apache.hc.client5.http.auth.AuthenticationException;
import org.apache.hc.client5.http.auth.UsernamePasswordCredentials;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.auth.BasicScheme;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.DockerComposeContainer;
import org.testcontainers.containers.wait.strategy.Wait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

/**
 * Test class for NamespacePrefixMapWebScript. This class tests the mapping of
 * namespace prefixes used within Alfresco.
 */
public class NamespacePrefixMapWebScriptTest {

    // Constants for Alfresco configurations
    static final int ALFRESCO_PORT = 8080;
    static final String ALFRESCO_SERVICE_NAME = "alfresco";
    static final String ALFRESCO_API_URL = "http://localhost:8080/alfresco/s/model/ns-prefix-map";

    // Docker Compose container setup
    static final DockerComposeContainer<?> DOCKER_COMPOSE_CONTAINER;
    static {
        DOCKER_COMPOSE_CONTAINER = new DockerComposeContainer<>(new File("target/test-classes/compose.yaml"))
                .withOptions("--compatibility")
                .withExposedService(ALFRESCO_SERVICE_NAME, ALFRESCO_PORT, Wait.forHttp("/alfresco")
                        .forStatusCode(200)
                        .forPort(ALFRESCO_PORT)
                        .withStartupTimeout(Duration.ofMinutes(5)))
                .withLocalCompose(true);
        DOCKER_COMPOSE_CONTAINER.start();
    }

    /**
     * Test method to verify the model mapping.
     *
     * @throws AuthenticationException if authentication fails
     * @throws IOException            if an I/O error occurs
     */
    @Test
    public void testModelMapping() throws AuthenticationException, IOException {
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            client.execute(getHttpClient(), response -> {
                // Verify HTTP status code
                Assertions.assertEquals(200, response.getCode());
                // Verify JSON response
                Assertions.assertTrue(isValid(new String(response.getEntity().getContent().readAllBytes())));
                return null;
            });
        }
    }

    /**
     * Constructs an HTTP GET request with authentication headers.
     *
     * @return HttpGet request object
     * @throws AuthenticationException if authentication fails
     */
    private HttpGet getHttpClient() throws AuthenticationException {
        HttpGet httpGet = new HttpGet(ALFRESCO_API_URL);
        httpGet.setHeader("Accept", "application/json");
        UsernamePasswordCredentials credentials = new UsernamePasswordCredentials("admin", "admin".toCharArray());
        BasicScheme basicScheme = new BasicScheme();
        basicScheme.initPreemptive(credentials);
        httpGet.addHeader("Authorization", basicScheme.generateAuthResponse(null, null, null));
        return httpGet;
    }

    /**
     * Checks if the provided JSON string is valid.
     *
     * @param json JSON string to validate
     * @return true if JSON is valid, false otherwise
     */
    private boolean isValid(String json) {
        try {
            new JSONObject(json);
        } catch (JSONException e) {
            // Log invalid JSON and stack trace
            System.err.println("Invalid JSON: " + json);
            e.printStackTrace(System.err);
            return false;
        }
        System.out.println(json);
        return true;
    }
}

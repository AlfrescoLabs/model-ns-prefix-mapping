# Alfresco Model Namespace-Prefix Mapping

This project includes a Repository WebScript to get a map of (namespace,prefix) for every deployed content model.

## Deploying from Source Code

To package this Alfresco Repository addon using Maven, follow these steps:

1. **Navigate to the Project Directory:**
   Open a terminal or command prompt and navigate to the root directory of the project containing the `pom.xml` file.

2. **Execute the Maven Package Command:**
   Run the following Maven command to package the project:

   ```bash
   mvn clean package
   ```

   This command compiles the source code, executes any tests (if not skipped), and packages the project into a JAR file.

3. **Locate the Packaged JAR File:**
   Once the packaging process completes successfully, you can find the packaged JAR file in the `target` directory within the project's root directory. The JAR file will be named `model-ns-prefix-mapping-1.1.0.jar`.

4. **Deploy the Addon to Alfresco Repository:**
   To deploy the addon to your Alfresco Repository instance, follow these steps:

    - **Stop Alfresco Repository:**
      If your Alfresco instance is running, stop it before deploying the addon.

    - **Copy the JAR File:**
      Copy the packaged JAR file (`model-ns-prefix-mapping-1.1.0.jar`) to the `tomcat/webapps/alfresco/WEB-INF/lib` directory within your Alfresco installation directory.

    - **Start Alfresco Repository:**
      Once the JAR file is copied, start your Alfresco instance.

   Your addon should now be deployed and available within your Alfresco Repository instance.

## Deploying from Releases

To deploy the Alfresco Repository addon to your Alfresco Repository instance, follow these steps:

1. **Download the Packaged JAR File:**
   Download the packaged JAR file (`model-ns-prefix-mapping-1.1.0.jar`) from the GitHub Releases section of the project repository.

2. **Deploy the Addon to Alfresco Repository:**
   To deploy the addon to your Alfresco Repository instance, follow these steps:

    - **Stop Alfresco Repository:**
      If your Alfresco instance is running, stop it before deploying the addon.

    - **Copy the JAR File:**
      Copy the downloaded JAR file (`model-ns-prefix-mapping-1.1.0.jar`) to the `tomcat/webapps/alfresco/WEB-INF/lib` directory within your Alfresco installation directory.

    - **Start Alfresco Repository:**
      Once the JAR file is copied, start your Alfresco instance.

   Your addon should now be deployed and available within your Alfresco Repository instance.

## Testing the Project

To test the project, you'll need Docker installed and running on your system.

**Using TestContainers**

This project uses [TestContainers](https://testcontainers.com), a Java library that provides throwaway instances of Docker containers for integration testing. TestContainers allows to define and manage Docker containers directly from within the tests.

**Running the Tests**

Follow these steps to run the tests:

1. **Ensure Docker is Installed:** Make sure Docker is installed on your system and is running.

2. **Run Maven Test Command:**
   Open a terminal or command prompt and navigate to the root directory of the project.

   Run the following Maven command to execute the tests:

   ```bash
   mvn test -DskipTests=false
   ```

   This command will execute the project's tests, including the `NamespacePrefixMapWebScriptTest` class.

**Contents of `compose.yaml`**

The `compose.yaml` file located in the `target/test-classes` directory contains the Docker Compose configuration for setting up the required Docker services for testing and applies the JAR addon as an external mount.


# Using from Browser

Once installed, following URL is available:

http://localhost:8080/alfresco/s/model/ns-prefix-map

>> You need to use Administrator credentials to access this endpoint

Sample response:

```
{
  "prefixUriMap": {
    "":"",
    "http://www.alfresco.org/model/aos/1.0":"aos",
    "http://www.alfresco.org/model/workflow/invite/nominated/1.0":"inwf",
    "http://www.alfresco.org/model/solrfacetcustomproperty/1.0":"srftcustom",
    "http://www.alfresco.org/model/datalist/1.0":"dl",
    "http://www.alfresco.org/model/webdav/1.0":"webdav",
    "http://www.alfresco.org/model/cmis/1.0/cs01ext":"cmisext",
    "http://www.alfresco.org/model/distributionpolicies/1.0/model":"dp",
    "http://www.alfresco.org/view/repository/1.0":"view",
    "http://www.alfresco.org/model/download/1.0":"download",
    "http://www.alfresco.org/model/publishing/twitter/1.0":"twitter",
    "http://www.alfresco.org/model/action/1.0":"act",
    "http://www.alfresco.org/system/registry/1.0":"reg",
    "http://www.alfresco.org/model/user/1.0":"usr",
    "http://www.alfresco.org/model/calendar":"ia",
    "http://www.alfresco.org":"alf",
    "http://www.alfresco.org/model/content/metadata/IPTCXMP/1.0":"iptcxmp",
    "http://www.alfresco.org/model/application/1.0":"app",
    "http://www.alfresco.org/model/surf/1.0":"surf",
    "http://www.alfresco.org/model/versionstore/1.0":"ver",
    "http://www.alfresco.org/system/modules/1.0":"module",
    "http://www.alfresco.org/model/linksmodel/1.0":"lnk",
    "http://iptc.org/std/Iptc4xmpExt/2008-02-29/":"Iptc4xmpExt",
    "http://ns.adobe.com/photoshop/1.0/":"photoshop",
    "http://ns.useplus.org/ldf/xmp/1.0/":"plus",
    "http://www.alfresco.org/model/remotecredentials/1.0":"rc",
    "http://www.alfresco.org/model/emailserver/1.0":"emailserver",
    "http://www.alfresco.org/model/sitecustomproperty/1.0":"stcp",
    "http://www.alfresco.org/model/cmis/1.0/cs01":"cmis",
    "http://www.alfresco.org/model/transfer/1.0":"trx",
    "http://www.alfresco.org/model/rendition/1.0":"rn",
    "http://www.alfresco.org/model/exif/1.0":"exif",
    "http://www.alfresco.org/model/publishing/youtube/1.0":"youtube",
    "http://ns.adobe.com/xap/1.0/rights/":"xmpRights",
    "http://www.alfresco.org/model/custommodelmanagement/1.0":"cmm",
    "http://www.alfresco.org/model/workflow/invite/moderated/1.0":"imwf",
    "http://www.alfresco.org/model/forum/1.0":"fm",
    "http://www.alfresco.org/model/rule/1.0":"rule",
    "http://www.alfresco.org/model/publishing/linkedin/1.0":"linkedin",
    "http://www.alfresco.org/model/publishing/slideshare/1.0":"slideshare",
    "http://www.alfresco.org/model/system/1.0":"sys",
    "http://www.alfresco.org/model/content/smartfolder/1.0":"smf",
    "http://www.alfresco.org/model/workflow/1.0":"wf",
    "http://www.alfresco.org/model/qshare/1.0":"qshare",
    "http://www.alfresco.org/model/versionstore/2.0":"ver2",
    "http://www.alfresco.org/model/solrfacet/1.0":"srft",
    "http://www.alfresco.org/model/audio/1.0":"audio",
    "http://www.alfresco.org/model/blogintegration/1.0":"blg",
    "http://www.alfresco.org/model/bpm/1.0":"bpm",
    "http://www.alfresco.org/model/site/1.0":"st",
    "http://www.alfresco.org/model/imap/1.0":"imap",
    "http://www.alfresco.org/model/dictionary/1.0":"d",
    "custom.model":"custom",
    "http://www.alfresco.org/model/publishing/facebook/1.0":"facebook",
    "http://www.alfresco.org/model/content/1.0":"cm",
    "http://www.alfresco.org/model/cmis/custom":"cmiscustom",
    "http://iptc.org/std/Iptc4xmpCore/1.0/xmlns/":"Iptc4xmpCore",
    "http://www.alfresco.org/model/googledocs/2.0":"gd2",
    "http://www.alfresco.org/model/publishing/flickr/1.0":"flickr",
    "http://www.alfresco.org/model/workflow/resetpassword/1.0":"resetpasswordwf",
    "http://www.alfresco.org/model/cmis/1.0/alfcmis":"alfcmis",
    "http://www.alfresco.org/model/publishing/1.0":"pub",
    "http://purl.org/dc/elements/1.1/":"dc"
  }
}
```

>> This project is compatible with Alfresco Content Services (ACS) version 7.0 and later.

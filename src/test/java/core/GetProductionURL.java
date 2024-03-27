package core;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import utilities.PropertiesLoader;
import java.io.*;
import java.util.Properties;

public class GetProductionURL {

    public String app_url;

    public  void setup() {
        String requestUrl = "https://amrhossam.com/vois.php?platform=android";
        String path = "config/capabilities/AndroidBrowserStack.properties";
        Properties browserStack = PropertiesLoader.readPropertyFile(path);
        Properties platform = PropertiesLoader.readPropertyFile("config/platform.properties");
        if (System.getProperty("PLATFORM", platform.getProperty("PLATFORM")).equalsIgnoreCase("ios")) {
            requestUrl = "https://amrhossam.com/vois.php?platform=ios";
            path = "config/capabilities/IOSBrowserStack.properties";
            browserStack = PropertiesLoader.readPropertyFile(path);
        }
        try {
            Response response = RestAssured.get(requestUrl);

            if (response.getStatusCode() != 200 || response.getBody().asString().isEmpty() || response.jsonPath().getString("app_url") == null) {
                app_url = System.getProperty(path, browserStack.getProperty(path));
            } else {
                app_url = response.jsonPath().getString("app_url");
            }
        } catch (Exception e) {
            app_url = System.getProperty("appUrl", browserStack.getProperty("appUrl"));
        }

        updatePropertyValue(path,"appUrl", app_url);
    }
    public void updatePropertyValue(String propertiesFilePath, String propertyKey, String newValue) {
        File configFile = new File(propertiesFilePath);
        Properties properties = new Properties();

        try (InputStream inputStream = new FileInputStream(configFile)) {
            properties.load(inputStream);
        } catch (IOException e) {
            System.err.println("Error loading the properties file: " + e.getMessage());
            return;
        }

        properties.setProperty(propertyKey, newValue);

        try (OutputStream outputStream = new FileOutputStream(configFile)) {
            properties.store(outputStream, null);
        } catch (IOException e) {
            System.err.println("Error updating the property value: " + e.getMessage());
        }
    }








}

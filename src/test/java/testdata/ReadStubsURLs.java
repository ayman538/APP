package testdata;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadStubsURLs {

    public static Properties properties;
    private static String StubsURLsPath;

    public static void readTestDataProperityFile() {

        StubsURLsPath = "Configurations//StubsURLs.properties";

        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(StubsURLsPath));
            properties = new Properties();

            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + StubsURLsPath);
        }
    }

    public static String getURL(String ApiName) {
        return properties.getProperty(ApiName);
    }
}

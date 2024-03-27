package testdata;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import static utilities.PropertiesLoader.readPropertyFile;

public class ReadTestData {

    public static Properties properties;
    private static String configFilePath;

    /*
    public static void readTestDataProperityFile() {
        String TilEnv = getTilEnvironment();

        if (TilEnv.equalsIgnoreCase("SUP02"))
            configFilePath = "Configurations//TestData//SUP02TestData.properties";
        else if (TilEnv.equals("E7"))
            configFilePath = "Configurations//TestData//E7TestData.properties";
        else if (TilEnv.equals("E4"))
            configFilePath = "Configurations//TestData//E4TestData.properties";

        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(configFilePath));
            properties = new Properties();

            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + configFilePath);
        }
    }*/

    public static String getMSISDN() {
        Properties envFile = readPropertyFile("config/env.properties");
        String MSISDN = System.getProperty("MSISDN", envFile.getProperty("MSISDN"));
        return MSISDN;
    }

    public static String getUsername() {
        Properties envFile = readPropertyFile("config/env.properties");
        String username = System.getProperty("username", envFile.getProperty("username"));
        return username;
    }

    public static String getFirstName() {
        Properties envFile = readPropertyFile("config/env.properties");
        String FirstName = envFile.getProperty("FirstName");
        return FirstName;
    }


    public static String getLastName() {
        Properties envFile = readPropertyFile("config/env.properties");
        String LastName = envFile.getProperty("LastName");
        return LastName;
    }
}

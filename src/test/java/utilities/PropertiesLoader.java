package utilities;

import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.util.Properties;

public class PropertiesLoader {
    public static Properties properties;

    public static Properties readPropertyFile(String configFilePath) {
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
        return properties;
    }
    public static String readConfig(String key) {
        File file = new File("config/config.properties");
        return getPropValue(key, file);
    }
    public static String readEnv(String key) {
        File file = new File("config/env.properties");
        return getPropValue(key, file);
    }
    public static String readPlatform(String key){
        File file = new File("config/platform.properties");
        return getPropValue(key, file);
    }
    public static String readAndroid(String key){
        File file = new File("config/capabilities/Android.properties");
        return getPropValue(key, file);
    }
    public static String readIOS(String key){
        File file = new File("config/capabilities/iOS.properties");
        return getPropValue(key, file);
    }
    public static String readApiURL(String key){
        File file = new File("config/api-url.properties");
        return getPropValue(key, file);
    }
    public static String readBrowserStackIOS(String key){
        File file = new File("config/capabilities/IOSBrowserStack.properties");
        return getPropValue(key, file);
    }
    public static String readBrowserStackAndroid(String key){
        File file = new File("config/capabilities/AndroidBrowserStack.properties");
        return getPropValue(key, file);
    }

    @NotNull
    private static String getPropValue(String key, File file) {

        Properties properties = new Properties();
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            properties.load(bufferedReader);

        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return properties.getProperty(key);
    }


}

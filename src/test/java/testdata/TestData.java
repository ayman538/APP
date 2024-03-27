package testdata;

import java.io.IOException;
import java.util.Properties;

import static core.Config.getServer;
import static utilities.PropertiesLoader.readPropertyFile;

public class TestData {

    private static String MSISDN;
    private static String username;

    public static void SetTestData() throws InterruptedException, IOException {
        MSISDN = ReadTestData.getMSISDN();
        username = ReadTestData.getUsername();
        String Server = getServer();
        //MVA10APIs_Suite.runApis(Server.toLowerCase(),MSISDN,username);
        ReadResponse.ReadFile();
    }

    public static String GetMSISDN() {
        Properties envFile = readPropertyFile("config/env.properties");
        String MSISDN = System.getProperty("MSISDN", envFile.getProperty("MSISDN"));
        return MSISDN;
    }

    public static String GetUserName() {
        Properties envFile = readPropertyFile("config/env.properties");
        String username = System.getProperty("username", envFile.getProperty("username"));
        return username;
    }

}

package core;

import utilities.PropertiesLoader;

import java.util.logging.Level;
import java.util.logging.Logger;

import static java.lang.System.getProperty;

public class Config {
    public static final String WORKSPACE = getProperty("user.dir");
    public static String LoginStatus, server, Stubs, DeviceName, PlatformVersion, PlatformType, UFL_satus, CleanStatus, UDID, APP, REMOTE, UnknownUser, NeedAPIHooks, SEGMENT, TCC, Need_Tcc , FirstName , LastName = "";
    private final String platform;
    static String tutorialClosedStatus = "False";
    static boolean fullFailureError = false;
    private boolean isAndroid;
    private boolean isIos;



    public Config() {
        Logger.getLogger("org.openqa.core.remote").setLevel(Level.OFF);
        setProperties();
        platform = System.getProperty("PLATFORM", PropertiesLoader.readPlatform("PLATFORM"));
        SelectPlatform(platform);
    }


    public static void setProperties() {

        LoginStatus = System.getProperty("LOGINSTATUS", PropertiesLoader.readEnv("LOGINSTATUS"));
        server = System.getProperty("SERVER", PropertiesLoader.readEnv("SERVER")).toUpperCase();
        PlatformType = System.getProperty("PLATFORM", PropertiesLoader.readPlatform("PLATFORM"));
        REMOTE = System.getProperty("REMOTE", PropertiesLoader.readEnv("REMOTE"));
        CleanStatus = PropertiesLoader.readEnv("CLEAN");
        UFL_satus = System.getProperty("UFL", PropertiesLoader.readEnv("UFL"));
        SEGMENT = System.getProperty("Segment", PropertiesLoader.readEnv("Segment"));
        LoginStatus =  PropertiesLoader.readEnv("LOGINSTATUS");
        Stubs =  PropertiesLoader.readEnv("STUBS");
        UnknownUser = System.getProperty("UnknownUser",  PropertiesLoader.readEnv("UnknownUser"));
        NeedAPIHooks =  PropertiesLoader.readEnv("NeedAPIHooks");
        LastName = System.getProperty("LastName", PropertiesLoader.readEnv("LastName"));
        FirstName = System.getProperty("FirstName", PropertiesLoader.readEnv("FirstName"));



        if (System.getProperty("PLATFORM", PropertiesLoader.readPlatform("PLATFORM")).equalsIgnoreCase("Android")) {
            DeviceName = System.getProperty("DEVICE_NAME", PropertiesLoader.readBrowserStackAndroid("DEVICE_NAME"));
            PlatformVersion = System.getProperty("PLATFORM_VERSION", PropertiesLoader.readBrowserStackAndroid("PLATFORM_VERSION"));
            //APP = System.getProperty("APP", androidFile.getProperty("APP"));

        } else if (System.getProperty("PLATFORM", PropertiesLoader.readPlatform("PLATFORM")).equalsIgnoreCase("ios")) {
            DeviceName = System.getProperty("DEVICE_NAME", PropertiesLoader.readBrowserStackIOS("DEVICE_NAME"));
            PlatformVersion = System.getProperty("PLATFORM_VERSION", PropertiesLoader.readBrowserStackIOS("PLATFORM_VERSION"));
            //APP = System.getProperty("APP", iosFile.getProperty("APP"));
            UDID = System.getProperty("UDID", PropertiesLoader.readIOS("udid"));
        }
    }


    // Getters and Setters


    public boolean isAndroid() {
        return isAndroid;
    }

    public boolean isIos() {
        return isIos;
    }

    public static String getServer() {
        return server;
    }


    public static String getPlatformType() {
        return PlatformType;
    }

    public static String getPlatformVersion() {
        return PlatformVersion;
    }

    public static String getCleanStatus() {
        return CleanStatus;
    }

    public static String getUnknownUser() {
        return UnknownUser;
    }

    public static String getNeedAPIHooks() {
        return NeedAPIHooks;
    }

    public static String getApp() {
        return APP;
    }

    public static String getLoginStatus() {
        return LoginStatus;
    }

    public static String getSegment() {
        return SEGMENT;
    }
    public static String getDeviceName() {
        return DeviceName;
    }

    public static void setLoginStatusStatus(String status) {
//        Properties envFile = readPropertyFile("config/env.properties");
//        envFile.setProperty("LOGINSTATUS", status);
//        LoginStatus = status;
        LoginStatus = System.getProperty("LOGINSTATUS", PropertiesLoader.readEnv("LOGINSTATUS"));
    }

    public static void setTutorialsClosedStatus() {
        tutorialClosedStatus = "True";
    }

    public static void setFullFailure() {
        fullFailureError = true;
    }

    public static String getUFLStatus() {
        return UFL_satus;
    }
    private void SelectPlatform(String platform) {
        isAndroid = platform.equalsIgnoreCase("Android");
        isIos = platform.equalsIgnoreCase("iOS");
    }
}

package utils.element_helpers;

import core.Hooks;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.SupportsContextSwitching;
import org.openqa.selenium.By;
import utilities.PropertiesLoader;

import java.time.Duration;
import java.util.Set;

import static core.drivers_initializer.drivers.AppiumMobileDriver.*;

public class DriverHelps {
    public static AppiumDriver driver;
    static {driver = Hooks.getDriver();}

    public static void navigateToMobileHomeScreen(){
        if (System.getProperty("PLATFORM", PropertiesLoader.readPlatform("PLATFORM")).equalsIgnoreCase("android")) {
            getAndroidDriver().pressKey(new KeyEvent(AndroidKey.HOME));
        }else
            getIosDriver().runAppInBackground(Duration.ofSeconds(-1));
    }

    public static void startActivity(){
        if (System.getProperty("PLATFORM", PropertiesLoader.readPlatform("PLATFORM")).equalsIgnoreCase("android")) {
            getAndroidDriver().activateApp("com.myvodafoneapp");
        }else if(System.getProperty("isLiveTest", PropertiesLoader.readEnv("isLiveTest")).equalsIgnoreCase("true"))
            getIosDriver().activateApp("com.vodafone.myvodafoneuk");
        else
            getIosDriver().activateApp("com.VIS.myvodafoneUK");
    }

    public static void runAppInBackground(){
        if (System.getProperty("PLATFORM", PropertiesLoader.readPlatform("PLATFORM")).equalsIgnoreCase("android")) {
            getAndroidDriver().runAppInBackground(Duration.ofSeconds(5));
        }else
            getIosDriver().runAppInBackground(Duration.ofSeconds(5));
    }

    public static void hideKeyboard(){
        if (System.getProperty("PLATFORM", PropertiesLoader.readPlatform("PLATFORM")).equalsIgnoreCase("android")) {
            getAndroidDriver().hideKeyboard();
        }else
            getIosDriver().hideKeyboard();
    }

    public static void killApp(){
        if (System.getProperty("PLATFORM", PropertiesLoader.readPlatform("PLATFORM")).equalsIgnoreCase("android")) {
            getAndroidDriver().terminateApp("com.myvodafoneapp");
        }else
            getIosDriver().terminateApp("com.VIS.myvodafoneUK");
    }

    public static String getContextHandles() {
        //we can use AndroidDriver and iOSDriver instead of casting as they implement these interfaces
        Set<String> contextNames = ((SupportsContextSwitching) getDriver()).getContextHandles();
        String CurrentURL = null;
        for (String contextName : contextNames) {
            if (contextName.contains("WEBVIEW")) {
                ((SupportsContextSwitching) getDriver()).context("WEBVIEW");
                CurrentURL = ((SupportsContextSwitching) getDriver()).getCurrentUrl();
                break;
            }
        }
        return CurrentURL;
    }

}

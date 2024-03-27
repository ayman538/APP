package core.drivers_initializer.drivers;

import core.GetProductionURL;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.SupportsContextSwitching;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import utilities.PropertiesLoader;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import static core.drivers_initializer.drivers.DriverConstants.APPIUM_URL;
import static core.drivers_initializer.drivers.DriverConstants.BROWSERSTACK_URL;
import static org.junit.jupiter.api.Assertions.fail;
import static utilities.PropertiesLoader.readPropertyFile;
import static utils.readers.TxtReader.readTxtFile;


/**
 * The type Mobile driver.
 */
public abstract class AppiumMobileDriver<D extends AppiumDriver> {


    private static final ThreadLocal<AppiumDriver> driverThreadLocal = new ThreadLocal<>();
    private static final DesiredCapabilities capss = new DesiredCapabilities();




    /**
     * This method initialize capabilities values and return Capabilities object
     * <p>
     * Instantiates a new Mobile driver.
     */

    @NotNull
    static DesiredCapabilities init(String capabilitiesFile) {
        Properties env = readPropertyFile("config/env.properties");

        if (isNotValid(capabilitiesFile))
            fail("Please provide a capabilitiesFile for mobile.");
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        List<String> lines = readTxtFile(capabilitiesFile);
        if (isNullLines(lines))
            fail("Please provide capabilities file for mobile");

        for (String line : lines) {
            System.out.println("lines"+ line);
            @NonNls String key = line.split("=").length > 0 ? line.split("=")[0] : "";
            String value = line.split("=").length > 1 ? line.split("=")[1] : "";
            if (!key.isEmpty() && !value.isEmpty())
                desiredCapabilities.setCapability(key, value.replace("\\", ""));
        }
        if (System.getProperty("browserStackRun", env.getProperty("browserStackRun")).equalsIgnoreCase("true")) {
            setCommonBrowserStackCaps(desiredCapabilities);
        }if (System.getProperty("isLiveTest", env.getProperty("isLiveTest")).equalsIgnoreCase("true")) {
             GetProductionURL production = new GetProductionURL();
             production.setup();
             desiredCapabilities.setCapability("app",production.app_url);
             System.out.println("  production app url====> " + production.app_url);
        }
        return desiredCapabilities;
    }
    static String[] selectCapsAndURL(String localCaps, String browserstackCaps) {
        Properties env = readPropertyFile("config/env.properties");
        String[] URLANdCaps = new String[2];

        if (System.getProperty("browserStackRun", env.getProperty("browserStackRun")).equalsIgnoreCase("true")){
            System.out.println("Running on Browserstack");
            URLANdCaps[0] = PropertiesLoader.readConfig(BROWSERSTACK_URL);
            URLANdCaps[1] = PropertiesLoader.readConfig(browserstackCaps);

        } else {
            System.out.println("Running using local Appium server");
            URLANdCaps[0] = PropertiesLoader.readConfig(APPIUM_URL);
            URLANdCaps[1] = PropertiesLoader.readConfig(localCaps);
        }



            return URLANdCaps;
    }
    private static DesiredCapabilities commonCapsBrowserStack(DesiredCapabilities desiredCapabilities , Properties prop ){
        HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
        browserstackOptions.put("userName", System.getProperty("browserStackUserName", prop.getProperty("browserStackUserName")));
        browserstackOptions.put("accessKey", System.getProperty("browserStackAccessKey", prop.getProperty("browserStackAccessKey")));
        browserstackOptions.put("deviceName", System.getProperty("DEVICE_NAME", prop.getProperty("DEVICE_NAME")));
        desiredCapabilities.setCapability("build", System.getProperty("buildNumber", prop.getProperty("buildNumber")));
        desiredCapabilities.setCapability("name", System.getProperty("buildName", prop.getProperty("buildName")));
        desiredCapabilities.setCapability("app", System.getProperty("appUrl", prop.getProperty("appUrl")));
        browserstackOptions.put("platformVersion", System.getProperty("PLATFORM_VERSION", prop.getProperty("PLATFORM_VERSION")));
        desiredCapabilities.setCapability("bstack:options", browserstackOptions);
        return desiredCapabilities;
    }
    private static void setCommonBrowserStackCaps(DesiredCapabilities caps) {
        if (System.getProperty("PLATFORM", PropertiesLoader.readPlatform("PLATFORM")).equalsIgnoreCase("android")) {
            Properties prop = readPropertyFile("config/capabilities/AndroidBrowserStack.properties");
            commonCapsBrowserStack(caps , prop);
        }
        else if (System.getProperty("PLATFORM", PropertiesLoader.readPlatform("PLATFORM")).equalsIgnoreCase("ios")) {
            Properties prop = readPropertyFile("config/capabilities/IOSBrowserStack.properties");
            commonCapsBrowserStack(caps , prop);
        }
    }


    private static boolean isNullLines(List<String> lines) {
        return lines == null;
    }

    private static boolean isNotFound(String capabilitiesFile) {
        File file = new File(capabilitiesFile);
        return !file.exists();
    }

    private static boolean isNotValid(String capabilitiesFile) {
        return isNull(capabilitiesFile) || capabilitiesFile.isEmpty() || isNotFound(capabilitiesFile);
    }

    private static boolean isNull(String capabilitiesFile) {
        return capabilitiesFile == null;
    }

    abstract D createDriver();

    public abstract void resetApp();

    public static AppiumDriver getDriver() {
        return driverThreadLocal.get();
    }

    public static AndroidDriver getAndroidDriver() {
        return (AndroidDriver) driverThreadLocal.get();
    }

    public static IOSDriver getIosDriver() {
        return (IOSDriver) driverThreadLocal.get();
    }

    public void setup() {
            driverThreadLocal.set(createDriver());
    }

    public WebElement findElement(By by) {
        return getDriver().findElement(by);
    }

    public List<WebElement> findElements(By by) {
        return getDriver().findElements(by);
    }
}

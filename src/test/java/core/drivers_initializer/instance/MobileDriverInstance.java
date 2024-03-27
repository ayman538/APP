package core.drivers_initializer.instance;

import utilities.PropertiesLoader;
import core.drivers_initializer.drivers.AppiumMobileDriver;
import core.drivers_initializer.enums.AppiumMobilePlatforms;

import java.util.HashMap;
import java.util.Map;

import static core.drivers_initializer.drivers.DriverConstants.*;


public class MobileDriverInstance {

    private static final Map<String, AppiumMobilePlatforms> mobilePlatformsMap = new HashMap<>();

    static {
        mobilePlatformsMap.put(ANDROID, AppiumMobilePlatforms.ANDROID_DRIVER);
        mobilePlatformsMap.put(IOS, AppiumMobilePlatforms.IOS_DRIVER);
    }


    /**
     * EnumMap implementation of the Strategy design pattern. to get the MobileDriver instance.
     *
     * @return the mobile driver
     */
    public static AppiumMobileDriver getAppiumMobileDriver() {
        String driverType = System.getProperty("PLATFORM", PropertiesLoader.readPlatform(PLATFORM));
        if(System.getenv("MOBILE_PLATFORM") != null) driverType = System.getenv("MOBILE_PLATFORM");
        System.out.println(driverType);
        return mobilePlatformsMap.get(driverType).getAppiumMobileDriver();
    }
}
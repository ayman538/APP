package core.drivers_initializer.drivers;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import utilities.PropertiesLoader;

import java.net.MalformedURLException;
import java.net.URL;

import static core.drivers_initializer.drivers.DriverConstants.ANDROIDBROWSERSTACK_CAPABILITIES;
import static core.drivers_initializer.drivers.DriverConstants.ANDROID_CAPABILITIES;
import static core.error_handlers.CustomErrorMessages.INVALID_APPIUM_URL_MESSAGE;

public class BaseAndroidDriver extends AppiumMobileDriver<AndroidDriver> {

    String browserStackRun = System.getProperty("browserStackRun", PropertiesLoader.readEnv("browserStackRun"));

    @Override
    public AndroidDriver createDriver() {
        try {
                String[] URLAndCaps = selectCapsAndURL(ANDROID_CAPABILITIES,ANDROIDBROWSERSTACK_CAPABILITIES);
                return new AndroidDriver(new URL(URLAndCaps[0]), init(URLAndCaps[1]));

        } catch (MalformedURLException e) {
            throw new RuntimeException(INVALID_APPIUM_URL_MESSAGE, e);
        }
    }

    @Override
    public void resetApp() {
        if (!browserStackRun.equalsIgnoreCase("true"))
            getAndroidDriver().executeScript("mobile: clearApp", ImmutableMap.of("appId", "com.myvodafoneapp"));
    }
}

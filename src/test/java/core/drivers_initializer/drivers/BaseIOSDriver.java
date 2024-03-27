package core.drivers_initializer.drivers;

import io.appium.java_client.ios.IOSDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static core.drivers_initializer.drivers.DriverConstants.IOSBROWSERSTACK_CAPABILITIES;
import static core.drivers_initializer.drivers.DriverConstants.IOS_CAPABILITIES;
import static core.error_handlers.CustomErrorMessages.INVALID_APPIUM_URL_MESSAGE;

public class BaseIOSDriver extends AppiumMobileDriver<IOSDriver> {

    @Override
    public IOSDriver createDriver() {
        try {
            String[] URLAndCaps  = selectCapsAndURL(IOS_CAPABILITIES,IOSBROWSERSTACK_CAPABILITIES);
            return new IOSDriver(new URL(URLAndCaps[0]), init(URLAndCaps[1]));

        } catch (MalformedURLException e) {
            throw new RuntimeException(INVALID_APPIUM_URL_MESSAGE, e);
        }
    }

    @Override
    public void resetApp() {
        // there's no clear data for ios
        getIosDriver().terminateApp("com.VIS.myvodafoneUK"); // Specify your app's package
    }
}

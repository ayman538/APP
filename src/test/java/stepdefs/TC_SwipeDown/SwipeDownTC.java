/*package stepdefs.TC_SwipeDown;

import core.Config;
import org.testng.SkipException;
import pages.Login.Login_Abstract;
import pages.Login.Login_Logic_Android;
import pages.Login.Login_Logic_IOS;
import pages.SubsctionOverlay.SubscriptionOverlayHeader.SubscriptionOverlayLogic;
import pages.Tray.DashboardTray.DashboardTrayAbstract;
import pages.Tray.DashboardTray.DashboardTrayAndroid;
import pages.Tray.DashboardTray.DashboardTrayIOS;
import pages.Tray.Settings.AppSetting.AppSettingsLogic;

import static core.Config.getPlatformType;
import static core.Config.getPlatformVersion;

@Deprecated
public class SwipeDownTC {

    private final Config config = new Config();
    private Login_Abstract login;
    DashboardTrayAbstract DashboardTrayObject;
    public void BeforeClass() {
        if (getPlatformType().equals("Android") && Integer.parseInt(getPlatformVersion()) >= 13) {
            throw new SkipException("The running device is not eligible ");
        }
    }

    public void TC01_validateSubsOverlaySwipeDown() {
        SubscriptionOverlayLogic subsOverLay = new SubscriptionOverlayLogic();
        subsOverLay.navigateToSubsOverLay();
        subsOverLay.ValidatesSwipeDown();
    }

    public void TC02_validateAppSettingSwipeDown()  {
        AppSettingsLogic appSettings = new AppSettingsLogic();
        appSettings.navigateToAppSettings();
        appSettings.validateSwipeDown();
    }

    public void TC03_validatePrivacySettingSwipeDown()  {
        AppSettingsLogic appSettings = new AppSettingsLogic();
        appSettings.navigateToPrivacySettings();
        appSettings.validateSwipeDown();
    }


    public void TC04_validateLoginSwipeDown()  {
        if (config.isAndroid()) login = new Login_Logic_Android();
        if (config.isIos()) login = new Login_Logic_IOS();
        login.validateLoginSwipeDown();
    }

    public void TC05_validateTobiSwipeDown() {
        if (config.isAndroid()) DashboardTrayObject = new DashboardTrayAndroid();
        if (config.isIos()) DashboardTrayObject = new DashboardTrayIOS();
        DashboardTrayObject.validateTobiSwipeDown();
    }
}

 */
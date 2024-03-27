package pages.DX_IDM.SSO_SubscriptionsSwitching;

import core.Config;
import org.json.simple.parser.ParseException;
import pages.DX_IDM.FullLogin.DX_IDM_FullLoginLogic_Abstract;
import pages.DX_IDM.FullLogin.DX_IDM_FullLoginLogic_IOS;
import pages.Dashboard.ControlTiles.ControlTilesAbstract;
import pages.Dashboard.ControlTiles.ControlTilesAndroid;
import pages.Dashboard.ControlTiles.ControlTilesIOS;
import pages.SSOs.SSOabstract;
import pages.SSOs.SSOandroid;
import pages.SSOs.SSOios;
import pages.SubsctionOverlay.ExtrasTab.ExtrasPO;
import pages.Tray.Billing.BillingLogic;
import pages.Tray.MyAccount.MyAccountIOS;
import pages.Tray.Settings.AccountSetting.SettingsDrawerAndAccountSettingsIOS;
import pages.Tray.Settings.AppSetting.AppSettingsIOS;

import java.io.IOException;
import java.util.Properties;

public class SSO_SubscriptionsSwitching_IOS extends SSO_SubscriptionsSwitchingAbstract {

    private DX_IDM_FullLoginLogic_Abstract dX_IDM_FullLoginAbstract;
    private final Config config =new Config();
    private SSOabstract ssoLogic;
    private final MyAccountIOS myAccountLogic;
    private ControlTilesAbstract controlTilesLogic;
    private BillingLogic billingLogic;
    private AppSettingsIOS appSettingsLogic;
    private ExtrasPO extrasPO;
    private SettingsDrawerAndAccountSettingsIOS settingsDrawerAndAccountSettingsLogic;
    public static Properties properties;

    public SSO_SubscriptionsSwitching_IOS() throws IOException {
        myAccountLogic = new MyAccountIOS();
        dX_IDM_FullLoginAbstract = new DX_IDM_FullLoginLogic_IOS();

    }

    @Override
    public void InitControlTilesLogic_ssoLogicObject() {
        if (config.isAndroid()) {
            ssoLogic= new SSOandroid();
            controlTilesLogic = new ControlTilesAndroid();

        }
        if(config.isIos()){
            ssoLogic= new SSOios();
            controlTilesLogic = new ControlTilesIOS();
        }
    }

    @Override
    public void LoginAndSwitchToSubscription(String userType) throws InterruptedException, ParseException {
        if (properties.getProperty("LoginStatus").equals("False")) {
            myAccountLogic.clickOnMyAccount();
            dX_IDM_FullLoginAbstract.fullLoginWithPIN();
            myAccountLogic.SwitchToSubscription(userType);
        } else if (properties.getProperty("LoginStatus").equals("True")) {
            myAccountLogic.clickOnMyAccount();
            myAccountLogic.SwitchToSubscription(userType);
        }

    }

    @Override
    public void clickOnControlTileAndValidateUpgradeNow() throws InterruptedException {
        controlTilesLogic.firstControlTileCTA();
        ssoLogic.validateUpgradeNowSSO();
    }

    @Override
    public void InitControlTilesLogic_extrasLogic_ssoLogic() {
        if (config.isAndroid()) {
            ssoLogic= new SSOandroid();
            controlTilesLogic = new ControlTilesAndroid();
        }
        if(config.isIos()){
            ssoLogic= new SSOios();
            controlTilesLogic = new ControlTilesIOS();
        }
    }

    @Override
    public void ClickOnControlTileAndNavigateToExtrasAndClickOnSpendManagerSSO() throws InterruptedException {
        controlTilesLogic.firstControlTileCTA();
        ssoLogic.ClickOnSpendManagerSSO();
    }

    @Override
    public void InitBillingLogicObject() {
        billingLogic = new BillingLogic();
    }
    @Override
    public void navigateToBilling() {
        billingLogic.navigateToBilling();
    }


//    public void SSO_SubscribtionSwitchingwithPayG_MPS(String userType) throws InterruptedException, ParseException {
//        myAccountLogic = new MyAccountLogic();
//        extrasLogic =new ExtrasLogic();

//        myAccountLogic.clickOnMyAccount();
//        extrasLogic.navigateToExtras();
//        Click on "Activate voucher"
//    }

    @Override
    public void InitAppSettingsLogic_settingsDrawer_AccountSettingsLogic() throws IOException {
        appSettingsLogic = new AppSettingsIOS();
        settingsDrawerAndAccountSettingsLogic = new SettingsDrawerAndAccountSettingsIOS();
    }
    @Override
    public void clickOnSettingsThenClickOnAccountSettingsThenClickonAccountControls() {
        appSettingsLogic.clickOnSettingsInTray();
        settingsDrawerAndAccountSettingsLogic.clickOnAccountSettings();
        settingsDrawerAndAccountSettingsLogic.clickonAccountControls();
    }

    @Override
    public void InitControlTilesLogic_extrasLogic_extrasPO() {
        if (config.isAndroid()) {
            controlTilesLogic = new ControlTilesAndroid();
        }
        if(config.isIos()){
            controlTilesLogic = new ControlTilesIOS();
        }
        extrasPO = new ExtrasPO();
    }

    @Override
    public void ClickOnControlTileThenNavigateToExtrasThenClickOnExtras_BuyManageExtrasCTA() throws InterruptedException {
        controlTilesLogic.firstControlTileCTA();
        extrasPO.Extras_BuyManageExtrasCTA.click();
    }

    @Override
    public void clickOnSettingsInTrayThenClickOnAccountSettingsThenClickOnAccountManagment() {
        appSettingsLogic.clickOnSettingsInTray();
        settingsDrawerAndAccountSettingsLogic.clickOnAccountSettings();
        settingsDrawerAndAccountSettingsLogic.clickOnAccountManagment();
    }



}

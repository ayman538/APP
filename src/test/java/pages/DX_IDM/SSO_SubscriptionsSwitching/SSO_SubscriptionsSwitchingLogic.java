//package pages.DX_IDM.SSO_SubscriptionsSwitching;
//
//import org.json.simple.parser.ParseException;
//import pages.DX_IDM.FullLogin.DX_IDM_FullLoginLogic;
//import pages.Dashboard.ControlTilesLogic;
//import pages.SSOs.SsoLogic;
//import pages.SubsctionOverlay.ExtrasTab.ExtrasLogic;
//import pages.SubsctionOverlay.ExtrasTab.ExtrasPO;
//import pages.Tray.Billing.BillingLogic;
//import pages.Tray.MyAccount.MyAccountLogic;
//import pages.Tray.Settings.AppSetting.AppSettingsLogic;
//import pages.Tray.Settings.AccountSetting.SettingsDrawerAndAccountSettingsLogic;
//
//import java.io.IOException;
//import java.util.Properties;
//@Deprecated
//public class SSO_SubscriptionsSwitchingLogic {
//
//    private final DX_IDM_FullLoginLogic dX_IDM_FullLoginLogic;
//    private SsoLogic ssoLogic;
//    private final MyAccountLogic myAccountLogic;
//    private ControlTilesLogic controlTilesLogic;
//    private BillingLogic billingLogic;
//    private ExtrasLogic extrasLogic;
//    private AppSettingsLogic appSettingsLogic;
//    private ExtrasPO extrasPO;
//    private SettingsDrawerAndAccountSettingsLogic settingsDrawerAndAccountSettingsLogic;
//    public static Properties properties;
//
//    public SSO_SubscriptionsSwitchingLogic() throws IOException {
//        myAccountLogic = new MyAccountLogic();
//        dX_IDM_FullLoginLogic = new DX_IDM_FullLoginLogic();
//    }
//
//    public void InitControlTilesLogic_ssoLogicObject() {
//        controlTilesLogic = new ControlTilesLogic();
//        ssoLogic = new SsoLogic();
//    }
//
//    public void LoginAndSwitchToSubscription(String userType) throws InterruptedException, ParseException {
//        if (properties.getProperty("LoginStatus").equals("False")) {
//            myAccountLogic.clickOnMyAccount();
//            dX_IDM_FullLoginLogic.fullLoginWithPIN();
//            myAccountLogic.SwitchToSubscription(userType);
//        } else if (properties.getProperty("LoginStatus").equals("True")) {
//            myAccountLogic.clickOnMyAccount();
//            myAccountLogic.SwitchToSubscription(userType);
//        }
//
//    }
//
//
//    public void clickOnControlTileAndValidateUpgradeNow() throws InterruptedException {
//        controlTilesLogic.ClickOnControlTileCTA();
//        ssoLogic.validateUpgradeNowSSO();
//    }
//
//
//    public void InitControlTilesLogic_extrasLogic_ssoLogic() {
//        controlTilesLogic = new ControlTilesLogic();
//        extrasLogic = new ExtrasLogic();
//        ssoLogic = new SsoLogic();
//    }
//
//    public void ClickOnControlTileAndNavigateToExtrasAndClickOnSpendManagerSSO() throws InterruptedException {
//        controlTilesLogic.ClickOnControlTileCTA();
//        extrasLogic.navigateToExtras();
//        ssoLogic.ClickOnSpendManagerSSO();
//    }
//
//
//    public void InitBillingLogicObject() {
//        billingLogic = new BillingLogic();
//    }
//
//    public void navigateToBilling() {
//        billingLogic.navigateToBilling();
//    }
//
//
////    public void SSO_SubscribtionSwitchingwithPayG_MPS(String userType) throws InterruptedException, ParseException {
////        myAccountLogic = new MyAccountLogic();
////        extrasLogic =new ExtrasLogic();
//
////        myAccountLogic.clickOnMyAccount();
////        extrasLogic.navigateToExtras();
////        Click on "Activate voucher"
////    }
//
//
//    public void InitAppSettingsLogic_settingsDrawer_AccountSettingsLogic() throws IOException {
//        appSettingsLogic = new AppSettingsLogic();
//        settingsDrawerAndAccountSettingsLogic = new SettingsDrawerAndAccountSettingsLogic();
//    }
//
//    public void clickOnSettingsThenClickOnAccountSettingsThenClickonAccountControls() {
//        appSettingsLogic.clickOnSettingsInTray();
//        settingsDrawerAndAccountSettingsLogic.clickOnAccountSettings();
//        settingsDrawerAndAccountSettingsLogic.clickonAccountControls();
//    }
//
//
//    public void InitControlTilesLogic_extrasLogic_extrasPO() {
//        controlTilesLogic = new ControlTilesLogic();
//        extrasLogic = new ExtrasLogic();
//        extrasPO = new ExtrasPO();
//    }
//
//    public void ClickOnControlTileThenNavigateToExtrasThenClickOnExtras_BuyManageExtrasCTA() throws InterruptedException {
//        controlTilesLogic.ClickOnControlTileCTA();
//        extrasLogic.navigateToExtras();
//        extrasPO.Extras_BuyManageExtrasCTA.click();
//    }
//
//    public void clickOnSettingsInTrayThenClickOnAccountSettingsThenClickOnAccountManagment() {
//        appSettingsLogic.clickOnSettingsInTray();
//        settingsDrawerAndAccountSettingsLogic.clickOnAccountSettings();
//        settingsDrawerAndAccountSettingsLogic.clickOnAccountManagment();
//    }
//
//
//
//
//}

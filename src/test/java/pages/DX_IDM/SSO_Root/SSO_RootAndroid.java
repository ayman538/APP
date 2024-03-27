package pages.DX_IDM.SSO_Root;

import core.Config;
import org.json.simple.parser.ParseException;
import pages.DX_IDM.FullLogin.DX_IDM_FullLoginLogic_Abstract;
import pages.DX_IDM.FullLogin.DX_IDM_FullLoginLogic_Android;
import pages.DX_IDM.WelcomeFlow.DX_IDM_WelcomeFlowLogicAbstract;
import pages.DX_IDM.WelcomeFlow.DX_IDM_WelcomeFlowLogicAndroid;
import pages.SubsctionOverlay.ExtrasTab.ExtrasPO;
import pages.Tray.MyAccount.MyAccountAndroid;
import pages.Tray.Settings.AccountSetting.SettingsDrawerAndAccountSettingsAndroid;
import pages.Tray.Settings.AppSetting.AppSettingsAndroid;

import java.io.IOException;
import java.util.Properties;

public class SSO_RootAndroid extends SSO_RootAbstract {
    public static Properties properties;
    private final Config config = new Config();
    private DX_IDM_FullLoginLogic_Abstract dX_IDM_FullLoginAbstract;
    private DX_IDM_WelcomeFlowLogicAbstract dx_idm_welcomeFlowLogicAbstract;
    private MyAccountAndroid myAccountLogic;
    private AppSettingsAndroid appSettingsLogic;
    private ExtrasPO extrasPO;
    private SettingsDrawerAndAccountSettingsAndroid settingsDrawerAndAccountSettingsLogic;

    public SSO_RootAndroid() throws IOException {
        myAccountLogic = new MyAccountAndroid();
        dX_IDM_FullLoginAbstract = new DX_IDM_FullLoginLogic_Android();
        dx_idm_welcomeFlowLogicAbstract = new DX_IDM_WelcomeFlowLogicAndroid();
    }

    @Override
    public void validateUserHasLoggedIn_FullLogin() throws InterruptedException {
        dX_IDM_FullLoginAbstract.fullLoginWithPIN();
    }

    @Override
    public void validateUserHasLoggedIn_UFL() throws ParseException, InterruptedException {
        dx_idm_welcomeFlowLogicAbstract.UFLJourneyIsTriggeredTillReachDashboard();
    }

    @Override
    public void navigateToAccountSettings() throws IOException {
        appSettingsLogic = new AppSettingsAndroid();
        settingsDrawerAndAccountSettingsLogic = new SettingsDrawerAndAccountSettingsAndroid();

        appSettingsLogic.clickOnSettingsInTray();
        settingsDrawerAndAccountSettingsLogic.clickOnAccountSettings();
    }

    @Override
    public void clickOnManageAssountSSO() {

    }

    @Override
    public void navigateToExtras() {

    }

    @Override
    public void clickOnManageBarsAndExtrasSSO() {

    }

    @Override
    public void navigateToCurrentCharges() {

    }

    @Override
    public void clickOnViewDetailsSSO() {

    }

    @Override
    public void clickOnDirectDebitSSO() {

    }

    @Override
    public void clickOnSimSwapSSO() {

    }

    @Override
    public void clickOnSpendManagerSSO() {

    }
}

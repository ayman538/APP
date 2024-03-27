package stepdefs.DX_IDM;

import core.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.DX_IDM.SoftLogin.DX_IDM_SoftLoginLogicAndroid;
import pages.DX_IDM.SoftLogin.DX_IDM_SoftLoginLogic_Abstract;
import pages.DX_IDM.SoftLogin.DX_IDM_SoftLoginLogic_IOS;
import pages.Login.Login_Abstract;
import pages.Login.Login_Logic_Android;
import pages.Login.Login_Logic_IOS;


public class SoftLogin {

    private DX_IDM_SoftLoginLogic_Abstract dx_idm_softLoginLogic;
    private Login_Abstract login;


    public SoftLogin(Config config) {
        if (config.isAndroid()) {
            login = new Login_Logic_Android();
            dx_idm_softLoginLogic = new DX_IDM_SoftLoginLogicAndroid();
        }
        if (config.isIos()) {
            login = new Login_Logic_IOS();
            dx_idm_softLoginLogic = new DX_IDM_SoftLoginLogic_IOS();
        }

    }

    @Given("Click Continue in Welcome screen")
    public void navigateWelcomeScreen() {
        dx_idm_softLoginLogic.navigateWelcomeScreen();
    }

    @And("Click Continue in privacy screen")
    public void navigatePrivacyAndTermsScreen() {
        dx_idm_softLoginLogic.navigatePrivacyAndTermsScreen();
    }

    @And("Click Continue in permission screen")
    public void navigatePermissionScreen() {
        dx_idm_softLoginLogic.navigatePermissionScreen();
    }

    @And("Click Continue in permission screen without dismissing usage popup")
    public void navigatePermissionScreenWithoutDismissingUsagePopup() {
        dx_idm_softLoginLogic.navigatePermissionScreenWithoutDismissingUsagePopup();
    }

    @Then("Validate Dashboard appears")
    public void validateDashboardAfterSoftLogin() {
        dx_idm_softLoginLogic.validateDashboardAfterSoftLogin();
    }
}
package stepdefs.DX_IDM;

import core.Config;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DX_IDM.FullLogin.DX_IDM_FullLoginLogic_Abstract;
import pages.DX_IDM.FullLogin.DX_IDM_FullLoginLogic_Android;
import pages.DX_IDM.FullLogin.DX_IDM_FullLoginLogic_IOS;
import pages.Login.Login_Abstract;
import pages.Login.Login_Logic_Android;
import pages.Login.Login_Logic_IOS;
import static core.Config.getLoginStatus;

public class FullLoginWithPW {

    private DX_IDM_FullLoginLogic_Abstract dx_idm_fullLoginLogic;


    private Login_Abstract login;

    public FullLoginWithPW(Config config) {
        if (config.isAndroid()) {
            login = new Login_Logic_Android();
            dx_idm_fullLoginLogic = new DX_IDM_FullLoginLogic_Android();
        }
        if (config.isIos()){
            login = new Login_Logic_IOS();
            dx_idm_fullLoginLogic = new DX_IDM_FullLoginLogic_IOS();
        }
    }


    @Given("FULL Login with Username And Password Journey")
    public void fullLoginWithUsernameAndPasswordJourney() throws InterruptedException {
        dx_idm_fullLoginLogic.fullLoginWithUNandPW();
    }

    /*@Given("I am MVA user and logged in using full login with user name and password")
    public void theUserLoginsToTheApp() {
        if(!getLoginStatus().equalsIgnoreCase("true")){
            try {
                dx_idm_fullLoginLogic.fullLoginWithUserNameAndPwdAndAcceptCookies();
            } catch (Exception e) {
                System.out.println("User already logged in");
            }
        }
    }*/

    @Then("Validate Password Screen")
    public void validatePasswordScreen() throws InterruptedException {
        dx_idm_fullLoginLogic.validatePasswordScreenDisplayedAfterHardCloseAndOpenMyAccount();
    }

    @When("Enter invalid password more than six times")
    public void enterInvalidPasswordMoreThanSixTimes() throws InterruptedException {
        dx_idm_fullLoginLogic.enterInvalidPasswordMoreThanSixTimes();
    }

    @Then("Validate Locked your account screen")
    public void validateLockedYourAccountScreen() throws InterruptedException {
        dx_idm_fullLoginLogic.validateLockedAccountScreen();
    }

    @Given("Locked Password Screen displayed")
    public void lockedPasswordScreenDisplayed() throws InterruptedException {
        dx_idm_fullLoginLogic.validateLockedScreenDisplayedAfterEnterInvalidPasswordMoreThanSixTrial();
    }

    @When("Click on Reset Password On Locked Screen")
    public void clickOnResetPasswordOnLockedScreen() throws InterruptedException {
        dx_idm_fullLoginLogic.validateResetJourneyDisplayedAfterClickOnResetPasswordOnLockedScreen();
    }

    @Then("Validate Dashboard displayed after hard close")
    public void validateDashboardDisplayedAfterHardClose() throws InterruptedException {
        dx_idm_fullLoginLogic.validateDashboardDisplayedAfterFullLoginWithPassword();
    }

    @When("HardClose the App and Relaunch")
    public void hardcloseTheAppAndRelaunch() {
        dx_idm_fullLoginLogic.hardClose();
    }

    @When("Click on My Account from dashboard tray")
    public void clickOnMyAccountFromDashboardTray() throws InterruptedException {
        dx_idm_fullLoginLogic.navigateToMyAccount();
    }

}

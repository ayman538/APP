package stepdefs.DX_IDM;

import core.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DX_IDM.FullLogin.DX_IDM_FullLoginLogic_Abstract;
import pages.DX_IDM.FullLogin.DX_IDM_FullLoginLogic_Android;
import pages.DX_IDM.FullLogin.DX_IDM_FullLoginLogic_IOS;
import pages.Login.Login_Abstract;
import pages.Login.Login_Logic_Android;
import pages.Login.Login_Logic_IOS;

public class FullLoginWithPIN {
    private DX_IDM_FullLoginLogic_Abstract dx_idm_fullLoginLogic;
    private Login_Abstract login;

    public FullLoginWithPIN(Config config) {
        if (config.isAndroid()) {
            login = new Login_Logic_Android();
            dx_idm_fullLoginLogic = new DX_IDM_FullLoginLogic_Android();
        }
        if (config.isIos()) {
            login = new Login_Logic_IOS();
            dx_idm_fullLoginLogic = new DX_IDM_FullLoginLogic_IOS();
        }
    }

    @Given("I am MVA user and logged in using full login with PIN")
    public void fullLoginWithPINJourney() throws InterruptedException {
        dx_idm_fullLoginLogic.fullLoginWithPIN();
    }
    @Given("I am MVA user and logged in using full login with Biometrics")
    public void fullLoginWithBiometrics() {
        try {
            dx_idm_fullLoginLogic.fullLoginWithBiometrics();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @When("HardClose the App")
    public void hardCloseTheApp() {
        dx_idm_fullLoginLogic.hardClose();
    }

    @Then("Validate Dashboard displayed")
    public void validateDashboardDisplayed() throws InterruptedException {
        dx_idm_fullLoginLogic.validateDashboardDisplayedAfterFullLoginWithPIN();
    }

    @When("Click on My Account")
    public void clickOnMyAccount() throws InterruptedException {
        dx_idm_fullLoginLogic.navigateToMyAccount();
    }

    @When("Click on My Account Close CTA")
    public void clickOnCloseMyAccountDrawer() {
        dx_idm_fullLoginLogic.closeMyAccountDrawer();
    }

    @Then("Validate PIN Screen")
    public void validatePINScreen() throws InterruptedException {
        dx_idm_fullLoginLogic.validatePINScreenDisplayedAfterHardCloseAndOpenMyAccount();
    }

    @When("Enter Valid PIN and Click on Continue")
    public void enterValidPINAndClickOnContinue() throws InterruptedException {
        dx_idm_fullLoginLogic.enterPINAndClickOnContinue();
    }

    @Then("User should see my account tray")
    public void userShouldSeeMyAccountTray() throws InterruptedException {
        dx_idm_fullLoginLogic.validateMYAccountOpenedAfterEnterValidPIN();
    }

    @When("Enter inValid PIN and Click on Continue")
    public void enterInValidPINAndClickOnContinue() throws InterruptedException {
        dx_idm_fullLoginLogic.enterInValidPINAndClickOnContinue();

    }

    @Then("User should see an error screen with OK CTA")
    public void userShouldSeeAnErrorScreenWithTwoCTASRetryAndNeverMind() throws InterruptedException {
        dx_idm_fullLoginLogic.validateErrorScreenDisplayedAfterEnterInvalidPIN();

    }


    @Then("Click on OK CTA and validate the PIN Screen should be displayed")
    public void clickOnRetryCTAAndValidateThePINScreenShouldBeDisplayed() {
        dx_idm_fullLoginLogic.validatePINScreenDisplayedAfterClickOnOKCTA();
    }

    @And("Enter inValid PIN for 5 Times and Continue")
    public void enterInValidPINForFiveTimesandContinue() throws InterruptedException {
        dx_idm_fullLoginLogic.enterInValidPINForFiveTimesandContinue();
    }
    @Then("User should be blocked")
    public void userShouldBeBlocked() throws InterruptedException {
        dx_idm_fullLoginLogic.validateBlockedScreenShouldBeDisplayedAfterEnterInvalidPINFor5Times();
    }

    @When("Click on Reset Password and validate")
    public void clickOnResetPasswordAndValidate() {
        dx_idm_fullLoginLogic.validateResetJourneyDisplayedAfterClickOnResetPassword();
    }

    @When("Click on Close CTA The Blocked screen should be closed")
    public void clickOnCloseCTATheBlockedScreenShouldBeClosed() {
        dx_idm_fullLoginLogic.validateCloseCTAWillDismissTheBlockedErrorScreen();
    }

    @Given("PIN Screen Displayed")
    public void pinScreenDisplayed() throws InterruptedException {
        dx_idm_fullLoginLogic.validatePINScreenDisplayedAfterHardCloseAndOpenMyAccount();
    }

    @Given("user logged with PIN and HardClose the app")
    public void userLoggedWithPINAndHardCloseTheApp() {
        dx_idm_fullLoginLogic.hardClose();
    }
}

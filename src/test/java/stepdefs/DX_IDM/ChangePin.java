package stepdefs.DX_IDM;


import core.Config;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DX_IDM.ChangePin.DX_IDM_ChangePinAbstract;
import pages.DX_IDM.ChangePin.DX_IDM_ChangePinAndroid;
import pages.DX_IDM.ChangePin.DX_IDM_ChangePinIOS;
import pages.DX_IDM.FullLogin.DX_IDM_FullLoginLogic_Abstract;
import pages.DX_IDM.FullLogin.DX_IDM_FullLoginLogic_Android;
import pages.DX_IDM.FullLogin.DX_IDM_FullLoginLogic_IOS;
import pages.Login.Login_Abstract;
import pages.Login.Login_Logic_Android;
import pages.Login.Login_Logic_IOS;

import java.io.IOException;


public class ChangePin {

    private DX_IDM_ChangePinAbstract DX_IDM_ChangePin;
    private final Config config = new Config();
    private Login_Abstract login;
    private DX_IDM_FullLoginLogic_Abstract DX_IDM_FullLogin;


    public ChangePin(Config config){
        if (config.isAndroid()){
            DX_IDM_ChangePin = new DX_IDM_ChangePinAndroid();
            DX_IDM_FullLogin = new DX_IDM_FullLoginLogic_Android();
        }
        if (config.isIos()){
            DX_IDM_ChangePin = new DX_IDM_ChangePinIOS();
            DX_IDM_FullLogin = new DX_IDM_FullLoginLogic_IOS();
        }

    }

    @Given("Account settings screen is displayed")
    public void AccountSettingsScreenIsDisplayed() {
        DX_IDM_ChangePin.AccountSettingsScreenIsDisplayed();
    }

    @Then("Validate Change pin option is displayed")
    public void ValidateChangePinOptionIsDisplayed() {
        DX_IDM_ChangePin.ValidateChangePinOptionIsDisplayed();
    }

    @Given("Change pin is displayed in account settings")
    public void ChangePinIsDisplayedInAccountSettings() {
        DX_IDM_ChangePin.ChangePinIsDisplayedInAccountSettings();
    }

    @Then("Validate Enter pin screen is displayed")
    public void ValidateEnterPinScreenIsDisplayed() {
        DX_IDM_ChangePin.ValidateEnterPinScreenIsDisplayed();
    }

    @Given("Enter pin screen is displayed")
    public void EnterPinScreenIsDisplayed() {
        DX_IDM_ChangePin.EnterPinScreenIsDisplayed();
    }

    @Then("Validate Enter pin screen four fields")
    public void ValidateEnterPinScreenFourFields() {
        DX_IDM_ChangePin.ValidateEnterPinScreenFourFields();
    }

    @Given("Re-Enter pin screen is displayed")
    public void ReEnterPinScreenIsDisplayed() {
        DX_IDM_ChangePin.ReEnterPinScreenIsDisplayed();
    }

    @Then("Validate Re-Enter pin screen four fields")
    public void ValidateReEnterPinScreenFourFields() {
        DX_IDM_ChangePin.ValidateEnterPinScreenFourFields();
    }

    @Given("pin successfully updated screen is displayed")
    public void PinSuccessfullyUpdatedScreenIsDisplayed() {
        DX_IDM_ChangePin.PinSuccessfullyUpdatedScreenIsDisplayed();
    }

    @Then("Validate pin successfully updated screen Content")
    public void ValidatePinSuccessfullyUpdatedScreenFourFields() {
        DX_IDM_ChangePin.ValidatePinSuccessfullyUpdatedScreenFourFields();
    }


    @Given("HardClose the app after set preference as username and password")
    public void hardcloseTheAppAfterSetPreferenceAsUsernameAndPassword() {
        DX_IDM_ChangePin.hardClose();
    }

    @When("Click on setting from tray then click on account settings then click on change pin")
    public void clickOnSettingFromTrayThenClickOnAccountSettingsThenClickOnChangePin() {
        DX_IDM_ChangePin.AccountSettingsScreenIsDisplayed();
        DX_IDM_ChangePin.ValidateChangePinOptionIsDisplayed();
        DX_IDM_ChangePin.ChangePinIsDisplayedInAccountSettings();
    }


    @Then("Enter pin screen is displayed and enter the four fields then click on continue")
    public void enterPinScreenIsDisplayedAndEnterTheFourFieldsThenClickOnContinue() throws IOException, InterruptedException {
        if (config.isAndroid()) login = new Login_Logic_Android();
        if (config.isIos()) login = new Login_Logic_IOS();

//        if (config.isAndroid()) DX_IDM_ChangePin = new DX_IDM_ChangePinAndroid();
//        if (config.isIos()) DX_IDM_ChangePin = new DX_IDM_ChangePinIOS();
        login.enterPin();
        DX_IDM_ChangePin.tapOnNextCTA();
    }

    @Then("Validate thanks for verifying screen")
    public void ValidateThanksForVerifyingScreen() throws InterruptedException {
        DX_IDM_ChangePin.ValidateThanksForVerifyingScreen();
    }

    @Then("Re-Enter pin screen is displayed and enter the four fields then click on continue")
    public void reEnterPinScreenIsDisplayedAndEnterTheFourFieldsThenClickOnContinue() throws InterruptedException {
        DX_IDM_ChangePin.ReEnterPinScreenIsDisplayed();
        DX_IDM_FullLogin.enterPINAndClickOnContinue();
    }

    @Then("Password screen is display and insert valid password then click on continue")
    public void passwordScreenIsDisplayAndInsertValidPasswordThenClickOnContinue() throws InterruptedException {
        DX_IDM_FullLogin.validatePasswordScreenContent();
    }

    @Then("Click on X icon on Enter pin screen")
    public void clickOnXIconOnEnterPinScreen() {
        DX_IDM_ChangePin.ClickOnXiconOnEnterPinScreen();
        DX_IDM_ChangePin.ValidateChangePinOptionIsDisplayed();
    }
}

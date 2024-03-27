package stepdefs.DX_IDM;

import core.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DX_IDM.ForgotUsername.DXIDM_ForgotUsernameAbstract;
import pages.DX_IDM.ForgotUsername.DXIDM_ForgotUsername_Android;
import pages.DX_IDM.ForgotUsername.DXIDM_ForgotUsername_IOS;

import java.io.IOException;

public class ForgotUsername {
    DXIDM_ForgotUsernameAbstract DXIDM_ForgotUsername;

    public ForgotUsername(Config config) throws IOException {
        if (config.isAndroid()) DXIDM_ForgotUsername = new DXIDM_ForgotUsername_Android();
        if (config.isIos()) DXIDM_ForgotUsername = new DXIDM_ForgotUsername_IOS();
    }

    @And("Tap on forgot username")
    public void TapOnForgotUsername() {
        DXIDM_ForgotUsername.ClickOnForgotUsername();
    }

    @And("Click on back")
    public void clickOnBack() {
        DXIDM_ForgotUsername.clickOnBack();
    }

    @When("Accept cookies")
    public void acceptCookies() {
        try {
            DXIDM_ForgotUsername.acceptCookies();
        }catch (Exception e){
            System.out.println("cookies're not displayed");
        }

    }

    @Then("Validate thanks for Verifying Screen")
    public void ValidateThanksForVerifyingScreen() throws InterruptedException {
        DXIDM_ForgotUsername.ValidateThanksForVerifyingScreen();
    }


    @Then("Validate username is Auto Populated")
    public void ValidateUsernameIsAutoPopulated() {
        DXIDM_ForgotUsername.ValidateUsernameIsAutoPopulated();
    }


    @And("enter first and second name")
    public void EnterFirstAndSecondName() {
        DXIDM_ForgotUsername.enterFirstAndSecondName();
    }


    @Then("app opens forgot username in external webview")
    public void appOpensForgotUsernameInExternalWebview() {
        DXIDM_ForgotUsername.ValidateExternalWebView();
    }
}

package stepdefs.DX_IDM;

import core.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DX_IDM.HandlingNewCookies.HandlingNewCookiesAbstract;
import pages.DX_IDM.HandlingNewCookies.HandlingNewCookiesAndroid;
import pages.DX_IDM.HandlingNewCookies.HandlingNewCookiesIOS;
import pages.DX_IDM.SoftLogin.DX_IDM_SoftLoginLogicAndroid;
import pages.DX_IDM.SoftLogin.DX_IDM_SoftLoginLogic_Abstract;
import pages.DX_IDM.SoftLogin.DX_IDM_SoftLoginLogic_IOS;
import pages.DX_IDM.UFL.DX_IDM_UFL_Abstract;
import pages.DX_IDM.UFL.DX_IDM_UFL_Android;
import pages.DX_IDM.UFL.DX_IDM_UFL_IOS;



public class HandlingNewCookiesBehaviorForSSO {

    private HandlingNewCookiesAbstract handlingNewCookies ;
    private DX_IDM_UFL_Abstract DX_IDM_UFL;
    private DX_IDM_SoftLoginLogic_Abstract dx_idm_softLoginLogic;



    public HandlingNewCookiesBehaviorForSSO(Config config){
        if (config.isAndroid()) {
            handlingNewCookies = new HandlingNewCookiesAndroid();
            dx_idm_softLoginLogic = new DX_IDM_SoftLoginLogicAndroid();
            DX_IDM_UFL = new DX_IDM_UFL_Android();

        }
        if (config.isIos()) {
            handlingNewCookies = new HandlingNewCookiesIOS();
            DX_IDM_UFL = new DX_IDM_UFL_IOS();
            dx_idm_softLoginLogic = new DX_IDM_SoftLoginLogic_IOS();
        }
    }

    @When("Click on my account")
    public void ClickOnMyAccount() {
        handlingNewCookies.clickOn_MyAccount();
    }

    @And("click on accept it in The Cookie permission message")
    public void clickOnAcceptItInTheCookiePermissionMessage() {

        handlingNewCookies.acceptCookies();
    }



    @Then("assert that enter user name screen  is display without the cookie permission")
    public void assertThatEnterUserNameScreenIsDisplayWithoutTheCookiePermission() {
        handlingNewCookies.assertLoginUsernameIsDisplayed();

    }

    @And("click on X icon on user name screen")
    public void clickOnXIconOnUserNameScreen() {
        handlingNewCookies.ClickXButton();
    }

    @And("hard close the app")
    public void hardCloseTheApp() {
        handlingNewCookies.hardClose();
    }

    @Then("assert that enter password screen is display without the cookie permission")
    public void assertThatEnterPasswordScreenIsDisplayWithoutTheCookiePermission() {
        handlingNewCookies.ValidatePasswordScreenContent();
    }

    @Given("login Till Reach Username Screen")
    public void LoginTillReachUsernameScreen() {
        handlingNewCookies.relogin();
        handlingNewCookies.clickOnLoginCTA();

    }

    @Given("login Till Reach Password Screen")
    public void LoginTillReachPasswordScreen() throws InterruptedException {
        DX_IDM_UFL.LoginTillReachPasswordScreen();
    }

    @Given("soft login")
    public void softLogin() {
        handlingNewCookies.navigateWelcomeScreen();
    }

    @And("login again")
    public void loginAgain() {
        handlingNewCookies.relogin();
    }
}


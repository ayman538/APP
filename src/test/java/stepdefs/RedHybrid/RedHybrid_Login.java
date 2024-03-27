package stepdefs.RedHybrid;

import core.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.simple.parser.ParseException;
import pages.DX_IDM.FullLogin.DX_IDM_FullLoginLogic_Abstract;
import pages.DX_IDM.FullLogin.DX_IDM_FullLoginLogic_Android;
import pages.DX_IDM.FullLogin.DX_IDM_FullLoginLogic_IOS;
import pages.RedHybrid.LoginFlow.RedHybrid_LoginLogic_Abstract;
import pages.RedHybrid.LoginFlow.RedHybrid_LoginLogic_Android;
import pages.RedHybrid.LoginFlow.RedHybrid_LoginLogic_iOS;

import static utils.element_helpers.GenericHelpers.clickOnRetryButton;

public class RedHybrid_Login {
    private RedHybrid_LoginLogic_Abstract redHybrid_LoginLogic;
    private DX_IDM_FullLoginLogic_Abstract dx_idm_fullLoginLogic ;
    private static boolean skipLogin = false;

    public RedHybrid_Login(Config config) {
        if (config.isAndroid())
        {   redHybrid_LoginLogic = new RedHybrid_LoginLogic_Android();
            dx_idm_fullLoginLogic = new DX_IDM_FullLoginLogic_Android();
        }
        if (config.isIos()) {
            redHybrid_LoginLogic = new RedHybrid_LoginLogic_iOS();
           dx_idm_fullLoginLogic = new DX_IDM_FullLoginLogic_IOS();}
    }


    @Given("Login To My Vodafone Screen Is Displayed")
    public void loginToMyVodafoneScreenIsDisplayed() {
        redHybrid_LoginLogic.loginToMyVodafoneScreenIsDisplayed();
    }

    @When("I am MVA user and logged in using Soft Login")
    public void clickOnSkipLoginButton() {
        if(!skipLogin){
            try {
                clickOnRetryButton();
                redHybrid_LoginLogic.clickOnSkipLoginButton();
                System.out.println("User clicked on Skip login");
                clickOnRetryButton();
            }catch (Exception e) {
                System.out.println("Skip login screen not displayed");
            }
            skipLogin = true;
        }
    }

    @And("Disconnect WiFi And Click Continue")
    public void disconnectWiFiAndClickContinue() {
        redHybrid_LoginLogic.disconnectWiFiAndClickContinue();
    }


    @Then("I should be navigated to dashboard")
    public void dashboardIsDisplayed() {
        redHybrid_LoginLogic.dashboardIsDisplayed();
    }

    @When("Click On Login CTA")
    public void clickOnLoginCTA() throws InterruptedException {
        dx_idm_fullLoginLogic.beforeLoginUsernameAndPasswordScreen();
        try{        dx_idm_fullLoginLogic.acceptCookies();
        }catch(Exception e){
            System.out.println("No cookies");
        }


    }

    @And("Enter Username And Password")
    public void enterUsernameAndPassword() {
        redHybrid_LoginLogic.enterUsernameAndPassword();

    }

    @And("Select Account And Enter Security Code")
    public void selectAccountAndEnterSecurityCode() throws ParseException {
        redHybrid_LoginLogic.selectAccountAndEnterSecurityCode();
    }

    @And("Chose Login Preference And Click Ok All Done")
    public void ChoseLoginPreferenceAndClickOkAllDone() {
        redHybrid_LoginLogic.ChoseLoginPreferenceAndClickOkAllDone();
    }


}

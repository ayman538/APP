package stepdefs.DX_IDM;

import core.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DX_IDM.ForgetPassword.DX_IDM_ForgetPasswordAbstract;
import pages.DX_IDM.ForgetPassword.DX_IDM_ForgetPassword_Android;
import pages.DX_IDM.ForgetPassword.DX_IDM_ForgetPassword_IOS;


public class ForgetPassword {
    private DX_IDM_ForgetPasswordAbstract dx_idm_forgetPasswordLogic;

    @Given("Init DX IDM Forget Password")
    public void beforeFeature(Config config){
        if (config.isAndroid()) dx_idm_forgetPasswordLogic = new DX_IDM_ForgetPassword_Android();
        if (config.isIos()) dx_idm_forgetPasswordLogic = new DX_IDM_ForgetPassword_IOS();
        dx_idm_forgetPasswordLogic.softLoginForForgetPass();
    }

    /*
    @Given("Soft login for reset password")
    public void softLoginForForgetPass(){
        dx_idm_forgetPasswordLogic.softLoginForForgetPass();
    }

     */

    @And("Click My Account")
    public void clickMyAccount(){
        dx_idm_forgetPasswordLogic.clickMyAccount();
    }

    @When("Enter Username for reset password")
    public void enterUsernameForForgetPass() throws InterruptedException {
        dx_idm_forgetPasswordLogic.enterUsernameForForgetPass();
    }

    @And("Click forget password")
    public void clickForgetPassCTA(){
        dx_idm_forgetPasswordLogic.clickForgetPassCTA();
    }

    @And("Add username for forget password")
    public void addUsernameForForgetPass(){
        dx_idm_forgetPasswordLogic.addUsernameForForgetPass();
    }

    @Then("Click reset password")
    public void clickResetPass(){
        dx_idm_forgetPasswordLogic.clickResetPass();
    }

    @And("Click continue after reset password")
    public void clickResetPassContinueCTA(){
        dx_idm_forgetPasswordLogic.clickResetPassContinueCTA();
    }

    @Then("Enter temp password and login")
    public void enterTempPass(){
        dx_idm_forgetPasswordLogic.enterTempPass();
    }

    @When("Enter Security Code")
    public void enterOTAC() throws InterruptedException {
        dx_idm_forgetPasswordLogic.enterOTAC();
    }

    @Then("Enter new password")
    public void enterNewPass(){
        dx_idm_forgetPasswordLogic.enterNewPass();
    }

    @Then("Check Login preferences screen appears")
    public void checkLoginPrefScreen(){
        dx_idm_forgetPasswordLogic.checkLoginPrefScreen();
    }
}

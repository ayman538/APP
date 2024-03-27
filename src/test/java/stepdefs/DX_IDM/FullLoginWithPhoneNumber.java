package stepdefs.DX_IDM;

import core.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.DX_IDM.FullLogin.DX_IDM_FullLoginLogic_Abstract;
import pages.DX_IDM.FullLogin.DX_IDM_FullLoginLogic_Android;
import pages.DX_IDM.FullLogin.DX_IDM_FullLoginLogic_IOS;
import pages.Login.Login_Logic_Android;
import pages.Login.Login_Logic_IOS;

public class FullLoginWithPhoneNumber {
    private DX_IDM_FullLoginLogic_Abstract dx_idm_fullLoginLogic;


    public FullLoginWithPhoneNumber(Config config) {
        if (config.isAndroid()) {
            dx_idm_fullLoginLogic = new DX_IDM_FullLoginLogic_Android();
        }
        if (config.isIos()){
            dx_idm_fullLoginLogic = new DX_IDM_FullLoginLogic_IOS();
        }
    }

    @Then("I validate username or phone number screen and Insert phone number")
    @Then("I validate username or phone number screen and Insert invalid phone number")
    public void validateUsernameOrPhoneNumberScreenAndInsertPhoneNumber() throws InterruptedException {
        dx_idm_fullLoginLogic.enterMSISDN();
    }

    @And("I validate DOB screen and Insert DOB")
    @And("I validate DOB screen and Insert invalid DOB")
    public void validateDOBScreenAndInsertDOB() throws InterruptedException {
        dx_idm_fullLoginLogic.fullLoginWithPhoneNumberUsingMultipleContactAccount();
    }

    @And("I validate first and last name screen and Insert first and last name")
    @And("I validate first and last name screen and Insert invalid first and last name")
    public void validateFirstAndLastNameScreenAndInsertFirstAndLastName() throws InterruptedException {
        dx_idm_fullLoginLogic.fullLoginWithPhoneNumberUsingMultipleContactAccountSameDOB();
    }

    @Then("I validate invalid phone number or password error massage is displayed")
    public void iValidateInvalidPhoneNumberOrPasswordErrorMassage() {
        dx_idm_fullLoginLogic.validateInvalidPhoneNumberOrPasswordErrorMessage();
    }

    @Then("I validate invalid DOB instant error massage is displayed")
    public void iValidateInvalidDOBInstantErrorMassageIsDisplayed() {
        dx_idm_fullLoginLogic.validateInvalidDOBErrorMessage();
    }

    @Then("I validate incorrect personal details error massage is displayed")
    public void iValidateIncorrectPersonalDetailsErrorMassageIsDisplayed() {
        dx_idm_fullLoginLogic.validateInvalidPersonalDetailsErrorMessage();
    }
}

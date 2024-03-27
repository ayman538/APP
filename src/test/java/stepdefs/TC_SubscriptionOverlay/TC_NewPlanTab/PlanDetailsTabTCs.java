package stepdefs.TC_SubscriptionOverlay.TC_NewPlanTab;

import core.Config;
import io.cucumber.java.en.Then;
import org.json.simple.parser.ParseException;
import pages.DX_IDM.FullLogin.DX_IDM_FullLoginLogic_Abstract;
import pages.DX_IDM.FullLogin.DX_IDM_FullLoginLogic_Android;
import pages.DX_IDM.FullLogin.DX_IDM_FullLoginLogic_IOS;
import pages.SubsctionOverlay.NewPlanDesign.NewPlanDesignAbstract;
import pages.SubsctionOverlay.NewPlanDesign.NewPlanDesignAndroid;
import pages.SubsctionOverlay.NewPlanDesign.NewPlanDesignIOS;
import pages.Tray.MyAccount.MyAccountAbstract;
import pages.Tray.MyAccount.MyAccountAndroid;
import pages.Tray.MyAccount.MyAccountIOS;

import java.io.IOException;

public class PlanDetailsTabTCs {

    NewPlanDesignAbstract newPlanDesignLogic;
    private DX_IDM_FullLoginLogic_Abstract dx_idm_fullLoginLogic;
    MyAccountAbstract MA;

    public PlanDetailsTabTCs(Config config) throws IOException {
        if (config.isAndroid()) {
            newPlanDesignLogic = new NewPlanDesignAndroid();
            dx_idm_fullLoginLogic = new DX_IDM_FullLoginLogic_Android();
            MA = new MyAccountAndroid();
        }
        if (config.isIos()) {
            newPlanDesignLogic = new NewPlanDesignIOS();
            dx_idm_fullLoginLogic = new DX_IDM_FullLoginLogic_IOS();
            MA = new MyAccountIOS();
        }
    }

    @Then("Validate Plan Details Main Title")
    public void TC01_ValidatePlanMainTitle() {
        newPlanDesignLogic.ValidatePlanMainTitle();
    }

    @Then("I validate plan tab is opened and titles of each sections")
    public void TC02_ValidatePlanSectionTitles() {
        newPlanDesignLogic.ValidatePlanSectionTitles();
    }

    @Then("Validate Plan Details Includes Items")
    public void TC03_ValidateIncludes() {
        newPlanDesignLogic.ValidateIncludes();
    }

    @Then("Validate Plan Details Includes Items Opening detailed screen")
    public void TC04_ValidateIncludesCTA() throws InterruptedException {
        newPlanDesignLogic.ValidateIncludesCTA();
    }

    @Then("Validate upgrade value in contract section")
    public void ValidateUpgradeValue() {
        newPlanDesignLogic.ValidateUpgradeValue();
    }

    @Then("Validate Includes more than 5 items")
    public void ValidateIncludesMoreThan5Items() {
        newPlanDesignLogic.ValidateIncludesMoreThan5Items();
    }

    @Then("Validate Includes less than 5 items")
    public void ValidateIncludesLessThan5Items() {
        newPlanDesignLogic.ValidateIncludesLessThan5Items();
    }

    @Then("Click on My account tray")
    public void ClickOnMyAccount() {
        newPlanDesignLogic.ClickOnMyAccount();
    }

    @Then("Proceed in login flow")
    public void ProceedInLoginFlow() throws InterruptedException {
        dx_idm_fullLoginLogic.fullLoginWithUserNameAndPwdAndAcceptCookies();
    }
    @Then("Validate Plan Details Allowance Items")
    public void TC05_ValidateNewPlanDetailsAllowances() {
        newPlanDesignLogic.ValidateNewPlanDetailsAllowances();
    }

    @Then("Validate Plan Details CTA text for BVB users")
    public void TC06_ValidatePlanDetailsCTATextForBVB() {
        newPlanDesignLogic.ValidatePlanDetailsCTATextForBVB();
    }

    @Then("Validate Plan Details CTA open for BVB users")
    public void TC07_ValidatePlanDetailsCTAForBVB() {
        newPlanDesignLogic.ValidatePlanDetailsCTAForBVB();
    }


    @Then("I should navigate to plan tab for PayG user")
    public void iShouldNavigateToPlanTabForPayGUser() {
        newPlanDesignLogic.ClickOnMyAccount();
        newPlanDesignLogic.assertPlanTitleText();
    }


    @Then("User should see his Vodafone together Discount")
    public void checkVodafoneTogetherDiscount() throws InterruptedException {
        newPlanDesignLogic.checkVodafoneTogetherDiscount();
    }
}

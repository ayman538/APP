package stepdefs.TC_SubscriptionOverlay;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.SubsctionOverlay.GroupData.GroupDataLogic;

import static core.Hooks.testAfterLastScenario;

@Deprecated
public class ManageGroupDataTCs {

    GroupDataLogic groupDataLogic;
    static boolean run = false;
    static boolean navigatedToDashboard = false;

    @Given("Init Manage Group data for red users")
    public void ManageGroupDataSetup() {
        if (!navigatedToDashboard) {
            testAfterLastScenario();
            navigatedToDashboard = true;
        }
        groupDataLogic = new GroupDataLogic();
        if (!run) {
            groupDataLogic.setupMGD();
            run = true;
        }
    }

    @Then("Validate Header In Manage Group Data")
    public void TC1_checkManageGroupDataHeaderInMGD() {
        groupDataLogic.checkManageGroupDataHeaderInMGD();
    }

    @Then("Validate Subscription ID In Manage Group Data")
    public void TC2_checkSubscriptionIDInMGD() {
        groupDataLogic.checkSubscriptionIDInMGD();
    }

    @Then("Validate Limit Indicator In Manage Group Data")
    public void TC3_checkLimitIndicatorInMGD() {
        groupDataLogic.checkLimitIndicatorInMGD();
    }

    @Then("Validate Send CTA In Manage Group Data")
    public void TC4_checkSendBtnInMGD() {
        groupDataLogic.checkSendBtnInMGD();
    }

    @Then("Validate Limit Bar In Manage Group Data")
    public void TC5_checkLimitBarInMGD() {
        groupDataLogic.checkLimitBarInMGD();
    }

    @Then("Validate Footer In Manage Group Data")
    public void TC6_checkFooterInMGD() {
        groupDataLogic.checkFooterInMGD();
    }

    @Then("Validate Press Back Btn Header")
    public void TC7_checkPressBackBtnHeader() {
        groupDataLogic.checkPressBackBtnHeader();
    }
}

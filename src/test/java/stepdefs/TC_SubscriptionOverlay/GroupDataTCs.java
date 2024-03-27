package stepdefs.TC_SubscriptionOverlay;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.SubsctionOverlay.GroupData.GroupDataLogic;

@Deprecated
public class GroupDataTCs {
    GroupDataLogic groupDataLogic;
    static boolean run = false;
    static boolean navigatedToDashboard = false;

    @Given("Init Group data for red users")
    public void GroupDataSetup() {
        if (!navigatedToDashboard) {
//            testAfterLastScenario();
            navigatedToDashboard = true;
        }
        groupDataLogic = new GroupDataLogic();
        if (!run) {
            groupDataLogic.setupGD();
            run = true;
        }
    }

    @Then("Validate Group Data Header")
    public void TC1_checkGroupDataHeader() {
        groupDataLogic.checkGroupDataHeader();
    }

    @Then("Validate Current data")
    public void TC2_checkCurrentData() {
        groupDataLogic.checkCurrentData();
    }

    @Then("Validate Group Data Icon")
    public void TC3_checkDataIcon() {
        groupDataLogic.checkDataIcon();
    }

    @Then("Validate Group Data Text")
    public void TC4_checkCurrentDataText() {
        groupDataLogic.checkCurrentDataText();
    }

    @Then("Validate Group Data Bar")
    public void TC5_checkDataBar() {
        groupDataLogic.checkDataBar();
    }

    @Then("Validate Manage Group Data Header")
    public void TC6_checkManageGroupDataHeaderInGD() {
        groupDataLogic.checkManageGroupDataHeaderInGD();
    }

    @Then("Validate Manage Group Data Subscription ID")
    public void TC7_checkSubscriptionIDInGD() {
        groupDataLogic.checkSubscriptionIDInGD();
    }

}

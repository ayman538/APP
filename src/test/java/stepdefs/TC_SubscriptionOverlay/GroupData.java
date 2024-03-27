package stepdefs.TC_SubscriptionOverlay;

import core.Config;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SubsctionOverlay.GroupData.GroupDataAbstract;
import pages.SubsctionOverlay.GroupData.GroupDataAndroid;
import pages.SubsctionOverlay.GroupData.GroupDataIOS;

public class GroupData {

    GroupDataAbstract groupDataLogic;

    public GroupData(Config config){
        if(config.isAndroid()) groupDataLogic = new GroupDataAndroid();
        if(config.isIos()) groupDataLogic = new GroupDataIOS();
    }

    @Then("Check Dashboard tiles for Red Leader user")
    public void checkDashboardTilesRedLeader(){
        groupDataLogic.checkDashboardTilesRedLeader();
    }

    @Given("Navigate to Group Data tab in subsoverlay")
    public void navigateToGroupDataTab(){
        groupDataLogic.navigateToGroupDataTab();
    }

    @Then("Check Group Data card in Group Data tab")
    public void checkDataGroupCard(){
        groupDataLogic.checkDataGroupCard();
    }

    @When("Navigate to Manage Group data for sharer")
    public void navigateToManageGroupData(){
        groupDataLogic.navigateToManageGroupData();
    }

    @Then("Check Send SMS CTA is dimmed when limit is off and enabled after changing the limit")
    public void checkLimitSharerInManageGroupData(){
        groupDataLogic.checkLimitSharerInManageGroupData();
    }

    @Then("Check Send SMS CTA redirects to SMS screen")
    public void checkManageGroupDataCTA() throws InterruptedException {
        groupDataLogic.checkManageGroupDataCTA();
    }
}

package stepdefs.TC_UniversalLinks;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.SubsctionOverlay.DevicePlanTab.DevicePlanLogic;
import pages.UniversalLinks.UniversalLinksLogic;

import static core.Hooks.testAfterLastScenario;

public class UniversalLinks_Bingo {

    DevicePlanLogic devicePlan;
    UniversalLinksLogic UniversalLinksLogic;
    static boolean navigatedToDashboard = false;

    @Given("Init Universal Links for Bingo")
    public void beforeClass() {
        if (!navigatedToDashboard) {
            testAfterLastScenario();
            navigatedToDashboard = true;
        }
        devicePlan = new DevicePlanLogic();
        UniversalLinksLogic= new UniversalLinksLogic();
    }


    @Then("Validate Device Plan To be Opened")
    public void checkDevicePlanTabOpened() {
        devicePlan.checkDevicePlanTabOpened();
    }

    @Then("Validate Device Plan To be Opened While in Background")
    public void checkDevicePlanTabOpenedwhileAppInBackground() {
        devicePlan.checkDevicePlanTabOpenedwhileAppInBackground();
    }

    @Then("Validate Device Plan To be Opened for Non Bingo")
    public void checkDevicePlanTabOpenedNonBINGO() {
        devicePlan.checkDevicePlanTabOpened();
    }
}

package stepdefs.RedHybrid;

import core.Config;
import core.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.RedHybrid.DashboardUniversalLink.RedHybrid_DashboardUniversalLink_Abstract;
import pages.RedHybrid.DashboardUniversalLink.RedHybrid_DashboardUniversalLink_Android;
import pages.RedHybrid.DashboardUniversalLink.RedHybrid_DashboardUniversalLink_IOS;


public class DashboardUniversalLink {
    private RedHybrid_DashboardUniversalLink_Abstract redHybrid_DashboardUniversalLink;

    public DashboardUniversalLink(Config config) {
        if (config.isAndroid()) redHybrid_DashboardUniversalLink = new RedHybrid_DashboardUniversalLink_Android();
        if (config.isIos()) redHybrid_DashboardUniversalLink = new RedHybrid_DashboardUniversalLink_IOS();
    }

    @Given("User Has Accessed The Universal Link")
    public void theUserClicksOnDashBoardLink() {
        redHybrid_DashboardUniversalLink.theUserClicksOnDashBoardLink();
    }

    @Then("User Should Navigate To Dashboard and has active plan")
    public void assertThatUserNavigatesToDashBoardWithActivePlan() {
        redHybrid_DashboardUniversalLink.assertThatUserNavigatesToDashBoardWithActivePlan();
    }

    @Then("User Should Navigate To Dashboard and has no active plan")
    public void assertThatUserNavigatesToDashBoardWithNoActivePlan() {
        redHybrid_DashboardUniversalLink.assertThatUserNavigatesToDashBoardWithNoActivePlan();
    }


    @And("Soft Close App")
    public void softCloseApp() {
        redHybrid_DashboardUniversalLink.SoftCloseApp();
    }


    @And("I navigate back to the main dashboard")
    public void iNavigateBackToTheMainDashboard() {
        Hooks.returnToDashboard();
    }
}

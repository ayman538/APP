package stepdefs.RedHybrid;

import core.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.RedHybrid.NoActivePlan.RedHybrid_NoActivePlan_Abstract;
import pages.RedHybrid.NoActivePlan.RedHybrid_NoActivePlan_Logic_Android;
import pages.RedHybrid.NoActivePlan.RedHybrid_NoActivePlan_Logic_iOS;

public class RedHybrid_NoActivePlan {

    private RedHybrid_NoActivePlan_Abstract noActivePlan_abstract;
    public RedHybrid_NoActivePlan(Config config) {
        if (config.isAndroid()) noActivePlan_abstract = new RedHybrid_NoActivePlan_Logic_Android();
        if (config.isIos()) noActivePlan_abstract = new RedHybrid_NoActivePlan_Logic_iOS();
    }

    @When("User Lands On Dashboard")
    public void UserLandsOnDashboard() {
        noActivePlan_abstract.UserLandsOnDashboard();
    }

    @Then("Validate Dashboard Cards")
    public void validateDashboardCards() {
        noActivePlan_abstract.validateDashboardCards();
    }

    @And("Validate Dashboard Tray Icons")
    public void validateDashboardTrayIcons() {
        noActivePlan_abstract.validateDashboardTrayIcons();
    }
}
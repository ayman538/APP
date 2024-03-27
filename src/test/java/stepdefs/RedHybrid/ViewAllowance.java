package stepdefs.RedHybrid;

import core.Config;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.response.DashboardV4ResponseModel;
import org.testng.Assert;
import pages.RedHybrid.ViewAllowance.RedHybrid_ViewAllowance_Abstract;
import pages.RedHybrid.ViewAllowance.RedHybrid_ViewAllowance_Android;
import pages.RedHybrid.ViewAllowance.RedHybrid_ViewAllowance_PO;
import pages.RedHybrid.ViewAllowance.RedHybrid_ViewAllowance_iOS;
import utils.DashboardUtils;

import static core.Hooks.testAfterLastScenario;

public class ViewAllowance {

    RedHybrid_ViewAllowance_PO PO = new RedHybrid_ViewAllowance_PO();
    RedHybrid_ViewAllowance_Abstract RedHybridLogic;
    static boolean navigatedToDashboard = false;

    public ViewAllowance(Config config)
    {
        if (config.isAndroid()){
            RedHybridLogic = new RedHybrid_ViewAllowance_Android();
            RedHybridLogic.setBeforeClass();
        }
        if (config.isIos()) {
            RedHybridLogic = new RedHybrid_ViewAllowance_iOS();
            RedHybridLogic.setBeforeClass();
        }
    }

    @Given("Init Allowance Card")
        public void initAllowanceCard() {

      //  if (!navigatedToDashboard) {
            testAfterLastScenario();
        //    navigatedToDashboard = true;
     //   }



    }


    @Then("Validate Allowances Card")
    public void validateAllowancesCard() {
        RedHybridLogic.checkAllowanceTile();
    }

    @When("I Should see usage card")
    public void seeUsageCard() {
        RedHybridLogic.assertOnTotalGBForPromotedPlan();
    }


}

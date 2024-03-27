package stepdefs.TC_Dashboard;

import core.Config;
import io.cucumber.java.en.Then;
import io.qameta.allure.Description;
import pages.Dashboard.AllowanceTile.AllowanceTileAbstract;
import pages.Dashboard.AllowanceTile.AllowanceTileAndroid;
import pages.Dashboard.AllowanceTile.AllowanceTileIOS;


public class AllowanceTile {

    AllowanceTileAbstract allowanceTile;
    //static boolean navigatedToDashboard = false;

    public AllowanceTile(Config config){
        if (config.isAndroid()) allowanceTile = new AllowanceTileAndroid();
        if (config.isIos()) allowanceTile = new AllowanceTileIOS();
    }

    /*
    @Given("Init Allowance Tile")
    public void BeforeClass() {
        if (!navigatedToDashboard) {
            testAfterLastScenario();
            navigatedToDashboard = true;
        }
        allowanceTile.setBeforeClass();
    }

     */

    @Then("Validate Allowance Tile")
    @Description("Dashboard for different Users / Allowance Tile  \n\n" +
            "TC: Test Case 91591: P1 - Check view all allowances card using user has one allowance card _Functional")
    public void checkAllowanceTile() throws Exception {
        allowanceTile.checkAllowanceTile();
    }
}

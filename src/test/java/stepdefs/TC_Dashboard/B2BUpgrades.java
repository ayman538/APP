package stepdefs.TC_Dashboard;

import core.Config;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.Dashboard.B2BRemoveBlockingUpgradeCard.B2BUpgradesAbstract;
import pages.Dashboard.B2BRemoveBlockingUpgradeCard.B2BUpgradesAndroid;
import pages.Dashboard.B2BRemoveBlockingUpgradeCard.B2BUpgradesIOS;

public class B2BUpgrades {
    B2BUpgradesAbstract B2BUpgrades;
    public B2BUpgrades(Config config) {
        if (config.isAndroid()) B2BUpgrades = new B2BUpgradesAndroid();
        if (config.isIos()) B2BUpgrades = new B2BUpgradesIOS();

        }



    @Then("Validate Upgrade Card displayed")
    public void validateUpgradeCardDisplayedIncludeUpgradeNowCTA() {
        B2BUpgrades.ValidateAirTimeTabDisplayed();
        B2BUpgrades.ValidateUpgradeNowCard();
        Assert.assertEquals(B2BUpgrades.UpgradenowCTA.getText(),"Upgrade now");
        Assert.assertEquals(B2BUpgrades.VerifyTextINCard.getText(),"View our latest offers");
    }




}


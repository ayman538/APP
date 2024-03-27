package stepdefs.TC_SubscriptionOverlay.TC_NewPlanTab;

import core.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.RedHybrid.PaymentReminderOverlay.RedHybrid_PaymentReminderOverlay_Android;
import pages.RedHybrid.PaymentReminderOverlay.RedHybrid_PaymentReminderOverlay_IOS;
import pages.RedHybrid.ViewPlanTile.RedHybrid_ViewPlanTile_Android;
import pages.RedHybrid.ViewPlanTile.RedHybrid_ViewPlanTile_IOS;
import pages.SubsctionOverlay.NewPlanDesign.UnlimitedDataBoosterAbstract;
import pages.SubsctionOverlay.NewPlanDesign.UnlimitedDataBoosterAndroid;
import pages.SubsctionOverlay.NewPlanDesign.UnlimitedDataBoosterIOS;
import pages.SubsctionOverlay.NewPlanDesign.UnlimitedDataBoosterLogic;

import static core.Hooks.testAfterLastScenario;

public class UnlimitedDataBooster{
    static boolean navigatedToDashboard = false;
     UnlimitedDataBoosterAbstract unlimitedDataBoosterAbstract;

    public UnlimitedDataBooster(Config config) {
        if (config.isAndroid()) {
            unlimitedDataBoosterAbstract = new UnlimitedDataBoosterAndroid();
        }

        if (config.isIos()) {
            unlimitedDataBoosterAbstract = new UnlimitedDataBoosterIOS();
        }
    }
    @Given("Initialize Your Plans")
    public void beforeClass() {
            unlimitedDataBoosterAbstract.navigateToYourPlans();
    }

    @When("User Selects Unlimited Data Booster")
    public void selectUnlimitedData() {
        unlimitedDataBoosterAbstract.clickUnlimitedDataBooster();
    }

    @When("Clicks on Change your Airtime Plan")
    public void clickChangeYourAirtimePlan() {
        unlimitedDataBoosterAbstract.clickChangeYourAirtimePlan();
    }

    @Then("Assert That Login Screen Is Opened")
    public void assertLoginScreenIsOpened() {
        unlimitedDataBoosterAbstract.assertLoginScreenIsOpened();
    }

    @Then("Assert That Available and Used Counters Are Displayed")
    public void assertCountersAreDisplayed() {
        unlimitedDataBoosterAbstract.assertCountersAreDisplayed();
    }

   @When("I should see Unlimited data booster screen with \"Activate by text\" CTA")
   public void assertActivateByTextDisplayed() {
       unlimitedDataBoosterAbstract.assertActivateByTextDisplayed();
   }

    @Then("I should see Unlimited data booster screen with \"Chat now\" CTA")
    public void assertChatNowCTADisplayed() {
        unlimitedDataBoosterAbstract.assertChatNowCTADisplayed();
    }

    @And("I click on \"Chat Now\" CTA")
    public void clickChatNowCTA() {
        unlimitedDataBoosterAbstract.clickChatNowCTA();
    }


    @And("Assert That Active Counter Is Not Displayed")
    public void assertActiveCounterNotDisplayed() {
        unlimitedDataBoosterAbstract.assertActiveCounterNotDisplayed();
    }
}
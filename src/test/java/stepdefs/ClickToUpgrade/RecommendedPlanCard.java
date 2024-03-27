package stepdefs.ClickToUpgrade;

import core.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.ClickToUpgrade.RecommendedPlans.RecommendedPlansAbstract;
import pages.ClickToUpgrade.RecommendedPlans.RecommendedPlansAndroid;
import pages.ClickToUpgrade.RecommendedPlans.RecommendedPlansIOS;
import pages.DevSettings.DevSettings;
import pages.DevSettings.DevSettingsAndroid;
import pages.DevSettings.DevSettingsiOS;
import pages.TestJourney.TestJourneyAbstract;
import pages.TestJourney.TestJourneyAndroid;
import pages.TestJourney.TestJourneyIOS;
import static utils.element_helpers.GenericHelpers.navigateToURL;


public class RecommendedPlanCard {
    DevSettings devSettingsPage;
    TestJourneyAbstract testJourneyPage;
    RecommendedPlansAbstract recommendedPlansPage;

    public RecommendedPlanCard(Config config) {
        if (config.isAndroid()) {
            devSettingsPage = new DevSettingsAndroid();
            testJourneyPage = new TestJourneyAndroid();
            recommendedPlansPage = new RecommendedPlansAndroid();
        }
        if (config.isIos()) {
            devSettingsPage = new DevSettingsiOS();
            testJourneyPage = new TestJourneyIOS();
            recommendedPlansPage = new RecommendedPlansIOS();
        }
    }

    @Given("the user navigates to the recommended plans page")
    public void navigateToRecommendedPlansPage() {
        devSettingsPage.goToTestJourneyPage();
        testJourneyPage.testUpgradePlanJourney();
    }

    @Then("the recommended plan card contains the correct details")
    public void recommendedPlanCardContainsCorrectData() {
        recommendedPlansPage.verifyRecommendedPlanCardDetails();
    }

    @Then("Validate Clicking On Check Upgrade Eligibility Redirect To Subsoverlay")
    public void ValidateClickingOnCheckUpgradeEligibilityRedirectToSubsoverlay()
    {
        recommendedPlansPage.ValidateClickingOnCheckUpgradeEligibilityRedirectToSubsoverlay();
    }
    @Then("The User is not eligible To upgrade")
    public void ValidateTheErrorScreenWhenUserIsnotEligible()
    {
        recommendedPlansPage.ValidateTheErrorScreenWhenUserIsnotEligible();
    }

    @Then("I Click on Back to Dashboard")
    public void ValidateTheFunctionalityofBacktoDashboardCTA()
    {
        recommendedPlansPage.ClickonBacktoDashboardCTA();
    }


    @Then("I close the error screen")
    public void ClickonXcloseCTA()
    {
        recommendedPlansPage.ClickonXcloseCTA();
    }

    @Given("the user navigates to the recommended plans page using deep link")
    public void theUserNavigatesToTheRecommendedPlansPageUsingDeepLink() {
        navigateToURL("myvodafone://CLICK2UPGRADE_RECOMMENDED_PLANS");
    }

    @Then("scroll to find simx plan")
    public void scrollToFindSimxPlan() {
        recommendedPlansPage.scrollToFindSimxPlan() ;
    }

    @And("Validate the black banner UI")
    public void validateTheBlackBannerUI() {
        recommendedPlansPage.validateTheBlackBanner() ;
    }

    @Then("Validate simx tray")
    public void validateSimxTray() {
        recommendedPlansPage.validateSimxTray();
    }

    @And("click X close Icon")
    public void clickXCloseIcon() {
        recommendedPlansPage.ClickonXcloseCTA();
    }

    @And("I Click on See all SIMO plans CTA")
    public void iClickOnSeeAllSIMOPlansCTA() {
        recommendedPlansPage.iClickOnSeeAllSIMOPlansCTA();
    }

    @And("I click on Dismissal X CTA")
    public void iClickOnDismissalXCTA() {
        recommendedPlansPage.iClickOnDismissalXCTA();
    }

    @And("I click on Find out more banner")
    public void iClickOnFindOutMoreBanner() {
        recommendedPlansPage.iClickOnFindOutMoreBanner();
    }

    @Then("I should see the price increase copies for the recommended plans & more plans sections")
    public void iShouldSeeThePriceIncreaseCopiesForTheRecommendedPlansMorePlansSections() {
        recommendedPlansPage.ValidatePriceIncreaseCopy();
    }

    @And("I Click on View Recommended plans CTA")
    public void iClickOnViewRecommendedPlansCTA() {
        recommendedPlansPage.ClickOnRecommendedPlansCTA();
    }

    @And("compare roaming details")
    public void compareRoamingDetails() {
        recommendedPlansPage.compareRoamingDetails();
    }
}

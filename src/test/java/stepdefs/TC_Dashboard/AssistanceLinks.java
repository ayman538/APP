package stepdefs.TC_Dashboard;

import core.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Dashboard.AssistanceLinks.AssistanceLinksAbstract;
import pages.Dashboard.AssistanceLinks.AssistanceLinksAndroid;
import pages.Dashboard.AssistanceLinks.AssistanceLinksIOS;


public class AssistanceLinks {

    AssistanceLinksAbstract assistanceLinksLogic;

    public AssistanceLinks(Config config){
        if(config.isAndroid()) assistanceLinksLogic = new AssistanceLinksAndroid();
        if(config.isIos()) assistanceLinksLogic = new AssistanceLinksIOS();
    }

    @Given("Dashboard loaded and assistance links retrieved successfully")
    public void AssistanceLinksStatus(){
        assistanceLinksLogic.AssistanceLinksStatus();
    }

    @Then("Check Assistance title text")
    public void assertAssistanceTitleText() {
        assistanceLinksLogic.assertAssistanceTitleText();
    }

    @When("Press show more button")
    public void assistanceLinkSeeMoreCTA(){
        assistanceLinksLogic.assistanceLinkSeeMoreCTA();
    }

    @Then("Check Assistance links ordering and texts")
    public void ValidateAssistanceLinksOrderAndText(){
        assistanceLinksLogic.ValidateAssistanceLinksOrderAndText();
    }

    @And("Press show less button")
    public void assistanceLinkSeeLessCTA(){
        assistanceLinksLogic.assistanceLinkSeeLessCTA();
    }

    @Then("Check Assistance links CTAs")
    public void ValidateAssistanceLinksCTA() throws InterruptedException {
        assistanceLinksLogic.ValidateAssistanceLinksCTA();
    }

    @Then("Check only {int} links are displayed")
    public void assertOnlyFourLinksDisplayed(int count){
        assistanceLinksLogic.assertOnlyFourLinksDisplayed(count);
    }


    @Then("Check Notifications is removed from Assistance links")
    public void checkNotificationsIsRemovedFromAssistanceLinks() {
        assistanceLinksLogic.assertNotificationsIsRemoved();
    }

    @Then("Check Assistance links ordering After Notification is removed")
    public void checkAssistanceLinksOrderingAfterNotificationIsRemoved() {
        assistanceLinksLogic.ValidateAssistanceLinksOrderAndTextAfterNotificationIsRemoved();
    }

    @And("I Scroll Down to Assistance links")
    public void scrollDownToAssistanceLinks() {
        assistanceLinksLogic.scrollDownToAssistanceLinks();
    }

    @Then("I should see the Assistance Links for Child User")
    public void CheckChildAssistanceLinks() {
        assistanceLinksLogic.CheckChildAssistanceLinks();
    }

    @When("I click on Battery Refresh Item")
    public void iClickOnBatteryRefreshItem() {
        assistanceLinksLogic.ClickOnBatteryRefresh();
    }

    @Then("I Should See the Battery Refresh Tool Page")
    public void iShouldSeeTheCorrectLandingPageOfTheTool() {
        assistanceLinksLogic.ValidateBatteryRefreshPage();
    }

    @Then("I Should See Battery Refresh in Assistance menu")
    public void CheckBatteryRefreshExistence() {
        assistanceLinksLogic.CheckBatteryRefreshExistence();

    }

    @Then("I click on Free Business Support")
    public void iClickOnFreeBusinessSupport() {
        assistanceLinksLogic.checkFreeBuisnessSupport();
    }

    @Then("I should NOT see Battery Refresh for PayG user")
    public void iShouldNOTSeeBatteryRefreshForPAYGUser() {
        assistanceLinksLogic.checkBatteryRefreshForPAYG();
    }

    @Then("Validate Trade in and Connect another device links is removed from assistance link")
    public void connectAnotherDeviceLinkIsAndTradeinLinksIsRemoved() {
        assistanceLinksLogic.validateConnectedAnotherDeviceAndTradeinLinksIsRemoved();
    }



/*
    @Given("User clicks on See more CTA")
    public void TC01_ValidateOrdering(){
        assistanceLinksLogic.assistanceLinkSeeMoreCTA();
    }

    @Then("Assert on links status")
    public void ValidateOrdering(){
        assistanceLinksLogic.assertStatus();
    }




    @Then("Assert Notification link text")
    public void TC03_ValidateNotificationLinkIsDisplayed(){
        assistanceLinksLogic.assertNotificationLinkText();
    }

    @Given("User clicks on notification link")
    public void TC04_ValidateNotificationLinkFunctionality() {
        assistanceLinksLogic.notificationsLinkCTA();
    }

    @Then("Assert on Notification title text")
    public void assertNotificationTitleText(){
        assistanceLinksLogic.assertNotificationTitleText();
    }

    @And("User clicks on notification X-icon CTA")
    public void notificationXIconCTA(){
        assistanceLinksLogic.notificationXIconCTA();
    }

    @Then("Assert FAQs Text")
    public void TC05_ValidateFAQsLinkIsDisplayed() {
        assistanceLinksLogic.assertFAQsText();
    }

    @Given("User clicks on FAQs CTA")
    public void TC06_ValidateFAQsLinkFunctionality() {
        assistanceLinksLogic.FAQCTA();
    }

    @Then("Assert Done CTA is displayed in custom tab")
    public void assertDoneCTADisplayedFAQs() {
        assistanceLinksLogic.assertDoneCTADisplayedFAQs();
    }

    @And("Assert dashboard is displayed on clicking Done CTA")
    public void DoneCTAAfterFAQs() {
        assistanceLinksLogic.DoneCTAAfterFAQs();
    }

    @Then("Assert Trade in text")
    public void TC07_ValidateTradeInLinkIsDisplayed() {
        assistanceLinksLogic.assertTradInText();
    }

    @Given("User clicks on TradeIn CTA")
    public void TC08_ValidateTradeInLinkFunctionality() {
        assistanceLinksLogic.TradeInCTA();
    }

    @Then("Assert TradeIn X-icon is displayed")
    public void assertTradInXIconDisplayed() {
        assistanceLinksLogic.assertTradInXIconDisplayed();
    }

    @And("Assert dashboard is displayed on clicking X-icon CTA")
    public void TradeInXIconCTA() {
        assistanceLinksLogic.TradeInXIconCTA();
    }

    @Then("Assert Find store link Text")
    public void TC09_ValidateStoreLocatorLinkIsDisplayed() {
        assistanceLinksLogic.assertFindStoreLinkText();
    }

    @Given("User clicks on Find store CTA")
    public void TC10_ValidateStoreLocatorLinkFunctionality() {
        assistanceLinksLogic.findStoreCTA();
    }

    @Then("Assert Done CTA is displayed")
    public void assertDoneCTADisplayed() {
        assistanceLinksLogic.assertDoneCTADisplayed();
    }

    @And("Assert dashboard is displayed after clicking done CTA")
    public void doneCTA() {
        assistanceLinksLogic.doneCTA();
    }

    @Then("Assert Track order text")
    public void TC11_ValidateTrackAnOrderLinkIsDisplayed() {
        assistanceLinksLogic.assertTrackOrderText();
    }

    @Given("User clicks on Track an order link")
    public void TC12_ValidateTrackAnOrderFunctionality() {
        assistanceLinksLogic.trackOrderCTA();

    }

    @Then("Assert Track an order title text")
    public void assertTrackOrderTitleText() {
        assistanceLinksLogic.assertTrackOrderTitleText();

    }

    @And("Click on track an order X-icon")
    public void trackOrderXIconCTA() {
        assistanceLinksLogic.trackOrderXIconCTA();

    }

    @Then("Validate one Number link is displayed")
    public void TC13_ValidateOneNumberLinkIsDisplayed() {
        assistanceLinksLogic.ValidateOneNumberLink();

    }

    @Then("Validate one Number link functionality")
    public void TC14_ValidateOneNumberLinkFunctionality(){
        assistanceLinksLogic.ValidateOneNumberLinkFunc();

    }

    @After("@AS")
    public void checkAssistanceLinksExpanded() {
        assistanceLinksLogic.expandAssistanceLink();
    }

    @Then("Assert Battery Refresh Tool Text")
    public void TC15_ValidateBatteryRefreshToolIsDisplayed(){
        assistanceLinksLogic.assertBatteryRefreshText();
    }

    @Given("User clicks on Battery Refresh link")
    public void userClicksOnBatteryRefreshLink() {
        assistanceLinksLogic.BatteryRefreshCTA();
    }

    @Then("Click on Battery Refresh X-icon")
    public void clickOnBatteryRefreshXIcon() {
        assistanceLinksLogic.BatteryRefreshXIconCTA();

    }

    @Then("Assert Free Business Text")
    public void assertFreeBusinessText() {
        assistanceLinksLogic.ValidateFreeBusinessLink();
    }

    @Given("User clicks on Free Business link")
    public void userClicksOnFreeBusinessLink() {
        assistanceLinksLogic.FreeBusinessCTA();
    }

    @Then("Assert external link is displayed")
    public void assertExternalLinkIsDisplayed() {
        assistanceLinksLogic.assertDoneCTADisplayedFreeBusiness();
    }

    @And("Assert dashboard is displayed after clicking on X icon")
    public void assertDashboardIsDisplayedAfterClickingOnXIcon() {
        assistanceLinksLogic.DoneCTAAfterFreeBusiness();
    }

 */
}


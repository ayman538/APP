package stepdefs.TC_SubscriptionOverlay.TC_PlanTab;

import core.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SubsctionOverlay.NewPlanDesign.OneNumberCard.OneNumberCard_Abstract;
import pages.SubsctionOverlay.NewPlanDesign.OneNumberCard.OneNumberCard_Android;
import pages.SubsctionOverlay.NewPlanDesign.OneNumberCard.OneNumberCard_IOS;

public class OneNumberCard {

    private OneNumberCard_Abstract oneNumberCard_Abstract;

    public OneNumberCard(Config config) {
        if (config.isAndroid()) oneNumberCard_Abstract = new OneNumberCard_Android();
        if (config.isIos()) oneNumberCard_Abstract = new OneNumberCard_IOS();
    }


    @Then("Validate OneNumber card image")
    public void TC01_Validate_OneCardImage() {
        oneNumberCard_Abstract.validateImage();
    }

    @Then("Validate OneNumber card title")
    public void TC02_Validate_OneCardTitle() {
        oneNumberCard_Abstract.validateTitle();
    }

    @Then("Validate OneNumber card description")
    public void TC03_Validate_OneCardDescription() {
        oneNumberCard_Abstract.validateDescription();
    }

    @Then("Validate OneNumber card button is displayed")
    public void TC04_Validate_OneCardCTAsDisplayed() {
        oneNumberCard_Abstract.validateCTAsDisplayed();
    }

    @Then("Validate OneNumber card button working successfully")
    public void TC05_Validate_OneCardCTAsFunctional() throws InterruptedException {
        oneNumberCard_Abstract.validateCTAsFunctional();
    }

    @Given("Click on Your Plan and Navigate to OneNumber Card")
    public void clickOnYourPlanAndNavigateToOneNumberCard() {
        oneNumberCard_Abstract.clickOnYourPlanAndNavigateToOneNumberCard();
    }

    @When("Click on Get Connected CTA")
    public void clickOnGetConnectedCTA() {
        oneNumberCard_Abstract.clickOnGetConnectedCTA();
    }

    @When("Click on Find out more CTA")
    public void clickOnFindOutMoreCTA() {
        oneNumberCard_Abstract.clickOnFindOutMoreCTA();
    }


    @Then("Assert that Get Connected WebView is Displayed Successfully")
    public void assertThatGetConnectedWebViewIsDisplayedSuccessfully() {
        oneNumberCard_Abstract.assertThatGetConnectedWebViewIsDisplayedSuccessfully();
    }

    @Then("Assert that Find Out More WebView is Displayed Successfully")
    public void assertThatFindOutMoreWebViewIsDisplayedSuccessfully() {
        oneNumberCard_Abstract.assertThatFindOutMoreWebViewIsDisplayedSuccessfully();
    }

    @And("Click on Your Plan and Navigate to the new OneNumber Card" )
    public void clickOnYourPlanAndNavigateToTheNewOneNumberCard() {
        oneNumberCard_Abstract.ClickOnYourPlanAndNavigateToTheNewOneNumber();
    }

    @Then("I should see title, body & number of connections for this user" )
    public void iShouldSeeTitleBodyNumberOfConnectionsForThisUser() {
        oneNumberCard_Abstract.AssertOneNumberTitleAndBody();
    }

    @Then("I should be redirected to OneNumber Portal")
    public void iShouldBeRedirectedToOneNumberPortal() {
        oneNumberCard_Abstract.AssertOneNumberPortalWeb();
    }

    @When("I click on Add a connection CTA if the user has less than {int} connections")
    public void iClickOnAddAConnectionCTAIfTheUserHasLessThanConnections(int No) {
        oneNumberCard_Abstract.ClickOnAddaConnectionCTA(No);
    }

    @Then("Closing the portal should redirect to plan tab with subscription state tray")
    public void closingThePortalShouldRedirectToPlanTabWithSubscriptionStateTray() {
        oneNumberCard_Abstract.AssertSubscriptionTray();
    }

    @When("I click on View details CTA for first subscription card")
    public void iClickOnViewDetailsCTAForFirstSubscriptionCard() {
        oneNumberCard_Abstract.ClickOnViewDetailsCTA();
    }

    @Then("I should be navigated to Manage subscription bottom sheet")
    public void iShouldBeNavigatedToManageSubscriptionBottomSheet() {
        oneNumberCard_Abstract.AssertMangeSubsctionTray();
    }

    @And("I should see agreement section and Manage connection CTA")
    public void iShouldSeeAgreementSectionAndManageConnectionCTA() {
        oneNumberCard_Abstract.assertOneNumberAgreementSectionAndManageConnectionCTA();
    }

    @When("I click on tooltip icon")
    public void iClickOnTooltipIcon() {
        oneNumberCard_Abstract.clickOnTooltipIcon();
    }

    @Then("Validate tooltip content")
    public void validateTooltipContent() {
        oneNumberCard_Abstract.validateTooltipContent();
    }

    @When("I click on toolTip thanks CTA")
    public void iClickOnToolTipThanksCTA() {
        oneNumberCard_Abstract.clickOnToolTipThanksCTA();
    }

    @And("I click on Manage connection CTA")
    public void iClickOnManageConnectionCTA() {
        oneNumberCard_Abstract.clickOnManageConnectionCTA();
    }

    @Then("I should see video player in OneNumber card")
    public void iShouldSeeVideoPlayerInOneNumberCard() {
        oneNumberCard_Abstract.validateTheExistenceOfVideoPlayer();
    }

    @When("I click on video player in OneNumber card")
    public void iClickOnVideoPlayerInOneNumberCard() {
        oneNumberCard_Abstract.clickOnVideoPlayerInOneNumberCard();
    }

    @Then("I should still be on the same screen")
    public void iShouldStillBeOnTheSameScreen() {
        oneNumberCard_Abstract.validateTheExistenceOfVideoPlayer();
    }


}

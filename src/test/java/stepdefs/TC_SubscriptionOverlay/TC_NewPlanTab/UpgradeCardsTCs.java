package stepdefs.TC_SubscriptionOverlay.TC_NewPlanTab;

import core.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SubsctionOverlay.NewPlanDesign.UpgradeCardsLogicAbstract;

import static core.Hooks.testAfterLastScenario;

public class UpgradeCardsTCs {
    
    private UpgradeCardsLogicAbstract upgradeCardsLogic;
    public UpgradeCardsTCs(Config config) {
        if (config.isAndroid()) upgradeCardsLogic = new pages.SubsctionOverlay.NewPlanDesign.UpgradeCardsLogicAndroid();
        if (config.isIos()) upgradeCardsLogic = new pages.SubsctionOverlay.NewPlanDesign.UpgradeCardsLogicIOS();
    }

    @Then("Validate Eligible For Upgrade Plan Card")
    public void TC01_ValidateEligibleForUpgradeCard() throws InterruptedException {
        upgradeCardsLogic.ValidateEligibleForUpgradeCard();
    }

    @Then("Validate Eligible For Upgrade Plan Card CTA")
    public void TC02_ValidateEligibleForUpgradeCardCTA() {
        upgradeCardsLogic.ValidateEligibleForUpgradeCardCTA();
    }

    @Then("Validate Not Eligible For Upgrade Plan Card")
    public void TC03_ValidateNotEligibleForUpgradeCard() throws InterruptedException {
      upgradeCardsLogic.ValidateNotEligibleForUpgradeCard();
    }

    @Then("Validate Fancy Plan Card")
    public void TC04_ValidateFancyCard() throws InterruptedException {
      upgradeCardsLogic.ValidateFancyCard();
    }

    @Then("Validate Fancy Plan Card CTA")
    public void TC05_ValidateFancyCardCTA() {
        upgradeCardsLogic.ValidateFancyCardCTA();
    }

    @Then("Validate Change Plan Card")
    public void TC06_ValidateChangePlanCard() throws InterruptedException {
       upgradeCardsLogic.ValidateChangePlanCard();
    }

    @Then("Validate Change Plan Card CTA")
    public void TC07_ValidateChangePlanCardCTA() {
        upgradeCardsLogic.ValidateChangePlanCardCTA();
    }

    @Then("Validate Call Us CTA Call CTA")
    public void ValidateCallUsCTACallCTA() throws InterruptedException {
        upgradeCardsLogic.ValidateEligibleForUpgradeCardMBB();
        upgradeCardsLogic.ValidateEligibleForCallUsCardCTA();
    }
    @When("click on upgrade now CTA")
    public void clickOnUpgradeNowCTA()
    {
        upgradeCardsLogic.clickOnUpgradeNowCTA();
    }
    
    @Then("upgrade PoP up is displayed")
    public void upgradePoPUpIsDisplayed() {
        upgradeCardsLogic.AssertUpgradePoPupIsDisplayed();
    }

    @When("click on Choose a phone plan CTA")
    public void clickOnChooseAPhonePlanCTA() {
        upgradeCardsLogic.clickOnCChoosePhonePlanCTA();
    }

    @Then("redirected to eShop and upgrade journey will be opened in internal web view")
    public void redirectedToEShopAndUpgradeJourneyWillBeOpenedInInternalWebView() throws InterruptedException {
        upgradeCardsLogic.AssertRedirectToEshopAndUpgradeJourney();
    }

    @Then("I validate on upgrade and trade-in popup")
    public void checkPopupUi() {
        upgradeCardsLogic.AssertPOPUI();
    }

    @And("click on x button")
    public void clickOnXButton() {
        upgradeCardsLogic.ClosePopup();
    }

    @Then("X close should dismiss the new overlay and user will still in plan tab screen")
    public void xCloseShouldDismissTheNewOverlayAndUserWillStillInPlanTabScreen() {
        upgradeCardsLogic.AssertUserInPlanTab();
    }

    @And("click on Yes ,Please CTA")
    public void clickOnYesPleaseCTA() {
        upgradeCardsLogic.YesPleaseTradeInUpgradePoPUP_CTA.click();
    }

    @Then("user will be redirected to trade-in SDK to run the diagnostic")
    public void userWillBeRedirectedToTradeInSDKToRunTheDiagnostic() {
        upgradeCardsLogic.AssertRedirectToTradeInSDK();
    }

    @And("I click on Upgrade only CTA in popup")
    public void clickOnNoThanksCTA() {
        upgradeCardsLogic.UpgradeOnlyCTA.click();
    }

    @Then("user will be redirected to eShop in internal web view")
    public void userWillBeRedirectedToEShopInInternalWebView() throws InterruptedException {
        upgradeCardsLogic.AssertRedirectToEshopAndUpgradeJourney();
    }

    @Then("I validate upgrade card with two CTAs")
    public void iValidateUpgradeCardWithTwoCTAs() {
        upgradeCardsLogic.validateUpgradeCardHasSIMOAndHandsetUpgrades();
    }
    @Then("I click on Browse Phones CTA")
    public void iClickOnBrowsePhones() {
        upgradeCardsLogic.clickOnBrowsePhone();
    }

    @Then("Validate the AoM recommendation reason")
    public void ValidateTheAoMRecommendationReason() {
        upgradeCardsLogic.validateAomRecommendationReason();
    }

    @Then("Validate the discount card on the phone plan content")

    public void validateTheDiscountCardOnThePhonePlancontent() {

        upgradeCardsLogic.ValidateDiscountCardContent();

    }
    @Then("Validate the brands icons carousel")
    public void ValidateTheBrandsIconsCarousel() throws InterruptedException {

        upgradeCardsLogic.ValidateBrandsIconsCarousel();

    }


    @Then("Validate the discount card on the phone plan appearance")

    public void validateTheDiscountCardOnThePhonePlanAppearance(){

        upgradeCardsLogic.ValidateDiscountCardAppearance();

    }


    @Then("Validate View full offer CTA")

    public void ValidateGoToViewFullOffersCTA() {

        upgradeCardsLogic.GoToViewFullOffersCTA();

    }

    @Then("Validate See more device plans CTA")

    public void ValidateGoToSeeMoreDevicePlanCTA() {

        upgradeCardsLogic.GoToSeeMoreDevicePlanCTA();

    }

    @Then("Validate Plan Upgrade Card for different user types")

    public void validatePlanUpgradeCardForDifferentUserTypes() {

        upgradeCardsLogic.validateUpgradeTypes();}

    @Then("Validate ASA regularity copy")
    public void validateASARegularityCopy() {

        upgradeCardsLogic.validateASACopy();
    }
}

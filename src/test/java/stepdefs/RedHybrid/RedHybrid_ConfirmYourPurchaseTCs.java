package stepdefs.RedHybrid;
import com.fasterxml.jackson.core.JsonProcessingException;
import core.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.RedHybrid.ConfirmYourPurchase.RedHybrid_ConfirmYourPurchase;

public class RedHybrid_ConfirmYourPurchaseTCs {

    RedHybrid_ConfirmYourPurchase ConfirmYourPurchase;

    public RedHybrid_ConfirmYourPurchaseTCs(Config config) {
        if (config.isAndroid()) {
            ConfirmYourPurchase = new pages.RedHybrid.ConfirmYourPurchase.RedHybrid_ConfirmYourPurchase_Android();
        }
        if (config.isIos()) {
            ConfirmYourPurchase = new pages.RedHybrid.ConfirmYourPurchase.RedHybrid_ConfirmYourPurchase_iOS();
        }

    }

    @Then("I should be navigated to Confirm Purchase Screen")
    public void RedHybrid_ConfirmYourPurchase() throws JsonProcessingException, InterruptedException {
        ConfirmYourPurchase.confirmPurchaseScreenIsDisplayed();
        ConfirmYourPurchase.validateConfirmPurchaseUIScreen();

    }


    @When("Barclays Saved card screen is displayed")
    public void barclaysSavedCardScreenIsDisplayed() {

        ConfirmYourPurchase.barclaysScreenIsDisplayed();
    }

    @Then("I should see that Pay Securely CTA is enabled")
    public void validateThatPaySecurelyCTAIsEnabled() throws InterruptedException {

        ConfirmYourPurchase.validateEnablingTermsAndConditionsToggle();
    }



    @When("Click on PAY Now CTA in Barcalys Screen")
    public void clickOnPAYNowCTAInBarcalysScreen() {
        ConfirmYourPurchase.clickOnPayNowInBarcalysScreen();
    }

    @When("I clicks on Pay Securely CTA")
    public void iClicksOnPaySecurelyCTA() {
        ConfirmYourPurchase.clickOnPaySecurelyCTA();
    }

    @Then("I should be navigated to new plan has been added screen")
    public void iShouldBeNavigatedToNewPlanHasBeenAddedScreen() throws JsonProcessingException {
        ConfirmYourPurchase.validateUIOfNewPlanAddedScreen();
    }

    @And("I should see the Mask over the Dashboard tile")
    public void iShouldSeeTheMaskOverTheDashboardTile() {
        ConfirmYourPurchase.maskOverDashboardTile();
    }

    @Then("I should be navigated to Confirm Purchase Screen With {string} orderType")
    public void iShouldBeNavigatedToConfirmPurchaseScreenWithOrderType(String OrderType) throws JsonProcessingException {
        ConfirmYourPurchase.validateConfirmPurchaseUIScreen(OrderType);
    }
}

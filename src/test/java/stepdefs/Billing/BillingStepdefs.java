package stepdefs.Billing;

import core.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.NewBilling.Billing_Abstract;
import pages.NewBilling.Billing_Logic_Android;
import pages.NewBilling.Billing_Logic_iOS;

public class BillingStepdefs {
    private Billing_Abstract billing;
    private static boolean tutFlag = false;

    public BillingStepdefs(Config config) {
        if (config.isAndroid()) {
            billing = new Billing_Logic_Android();
        }
        if (config.isIos()) {
            billing = new Billing_Logic_iOS();
        }

    }

    @Then("The billing Title Card should be existed with X CTA")
    public void theBillingTitleCardShouldBeExistedWithXCTA() {
        billing.ValidateTheBillingTitleCardExistence();
    }

    @When("Clicking on X CTA from the billing title card")
    public void clickingOnXCTAFromTheBillingTitleCard() {
        billing.clickOnBilligTitleCardXCTA();
    }

    @Then("The user should land on the dashboard")
    public void theUserShouldLandOnTheDashboard() {
        billing.validateDashboardAppearance();
    }

    @When("I navigate to the new billing dashboard")
    public void navigateToTheNewBillingScreen() {
        billing.navigateToNewBilling();
    }

    @And("I close the tutorial if displayed")
    public void clickOnCloseTutorial() {
        //if (!tutFlag) {
            billing.closeTheTutorial();
        //}
        //tutFlag = true;
    }

    @When("I should see the new billing dashboard")
    public void theBillingDashboardIsOpen() {
        billing.waitForTheBillingDashboard();
    }

    @Then("I should see the {string} bill card")
    public void theFutureBillCardShouldBeExist(String cardType) {
        billing.validateTheBillCardExistence(cardType);
    }

    @And("I should see The month of the {string} bill")
    public void theFutureBillCardShouldContainTheMonthOfTheBill(String cardType) {
        billing.validateTheBillCradContainsTheMonthOfTheBillExistence(cardType);
    }


    @And("I click on the > icon of the {string} bill card")
    public void clickOnTheArrowIcon(String cardType) {
        billing.clickOnTheArrowIcon(cardType);
    }

    @Then("I should see the Future Bill Reinvent journey is open")
    public void validateTheFutureBillReinventJourneyIsOpen() {
        try {
            billing.validateTheFutureBillReinventJourenyIsOpen();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("I should see the i icon with a statement of when the {string} bill will be created")
    public void iIconWithAStatementOfWhenTheBillWillBeCreatedExistence(String cardType) {
        billing.validateiIconExistence(cardType);
    }


    @And("I should see the {string} bill Estimated Total text")
    public void futureBillEstimatedTotalTextExistence(String cardType) {
        billing.validateEstimatedTotalTextExistence(cardType);
    }

    @And("I should see the {string} the total Amount of charges")
    public void totalAmountOfChargesExistence(String cardType) {
        billing.validateAmountOfChargesExistence(cardType);
    }

    @And("I should see the {string} bill status info")
    public void futureBillStatusInfoExistence(String cardType) {
        billing.validateBillStatusInfoExistence(cardType);
    }


    @Then("I should see the first Bill Reinvent journey is open")
    public void iShouldSeeTheFirstBillReinventJourneyIsOpen() {
        try {
            billing.validateTheFirstBillReinventJourneyIsOpen();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("I should see The month cycle of the first bill")
    public void iShouldSeeTheMonthCycleOfTheBill() {
        billing.validateMonthCycleExistence();
    }

    @Then("I should see the latest Bill Reinvent journey is open")
    public void iShouldSeeTheLatestBillReinventJourneyIsOpen() {
        billing.validateTheLatestBillReinventJourenyIsOpen();
    }

    @And("I should see The month cycle of the latest bill")
    public void iShouldSeeTheMonthCycleOfTheLatestBill() {
        billing.validateMonthCycleExistence();
    }

    @Then("I should see the Payment Overdue Card")
    public void iShouldSeeThePaymentOverdueCard() {
        billing.validatePaymentOverDueCardExistence();
    }


    @And("I should see the Payment Overdue Card Icon")
    public void iShouldSeeThePaymentOverdueCardIcon() {
        billing.validatePaymentOverDueCardIconExistence();
    }

    @And("I should see the Payment Overdue Card Subtitle")
    public void iShouldSeeThePaymentOverdueCardSubtitle() {
        billing.validatePaymentOverDueCardSubtitleExistence();
    }

    @And("I should see the Pay bill now CTA")
    public void iShouldSeeThePayBillNowCTA() {
        billing.validatePayBillNowCTAExistence();
    }

    @And("I click on the Pay bill now CTA")
    public void iClickOnThePayBillNowCTA() {
        billing.clickOnThePayBillCTA();
    }

    @Then("I should be navigated to the Payment Reinvent journey")
    public void iShouldBeNavigatedToThePaymentReinventJourney() {
        billing.validateThePaymentReinventJourneyIsOpened();
    }

    @And("I close the billing tutorial if displayed")
    public void iCloseTheBillingTutorialIfDisplayed() {
        billing.closeTheBillingTutorial();
    }

    @And("I should see the new View Billing FAQs Card")
    public void iShouldSeeTheNewViewBillingFAQsCard() {
        billing.validateViewBilingFAQsCardExistence();
    }

    @When("I tab on View Billing FAQs Card")
    public void iTabOnViewBillingFAQsCard() {
        billing.clickOnViewBilingFAQsCard();
    }

    @Then("I should be directed to Billing FAQs Webview")
    public void iShouldBeDirectedToBillingFAQsWebview() {
        billing.validateBillingFAQsWebView();
    }

    @Given("I should see Manage cards and payments card")
    public void checkManageCardsAndPaymentsCard() {
        billing.checkManageCardsAndPaymentsCard();
    }

    @When("I click on Manage cards and payments chevron")
    public void clickOnManageCardsAndPaymentsChevron() {
        billing.clickOnMangeCardsAndPaymentsChevron();
    }

    @Then("I should be navigated to manage payments webview")
    public void checkNavigationToManagePayments() throws InterruptedException {
        billing.checkNavigationToManagePayments();
    }

    @Then("I validate the login screen appears")
    public void ValidateTheLoginScreenForSMB() {
        billing.ValidateLoginScreenAppearsSuccessfullyForSMB();
    }


    @When("I navigate to normal billing")
    public void navigateToBillingScreen() {
        billing.navigateToBilling();
    }

    @And("I should see the VAT text beside the {string} bill card")
    public void iShouldSeeTheVATTextBesideTheBillCard(String cardType) {
        billing.validateTheExistenceOfVATTextBesideTheBillCard(cardType);
    }

    @Then("I should NOT see Bill graph as a service user")
    public void iShouldNOTSeeBillGraphAsAServiceUser() {
        billing.validateBillGraphForServiceUser();
    }

    @Then("I should NOT see Manage cards & payments card as a service user")
    public void iShouldNOTSeeManageCardsPaymentsCardAsAServiceUser() {
        billing.validateManageCardsPaymentsCardForServiceUser();
    }
}

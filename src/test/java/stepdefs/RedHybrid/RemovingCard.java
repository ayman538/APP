package stepdefs.RedHybrid;

import core.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.RedHybrid.RemovePaymentCard.RedHybrid_RemovePaymentCard;
import pages.RedHybrid.RemovePaymentCard.RedHybrid_RemovePaymentCardLogic_Android;
import pages.RedHybrid.RemovePaymentCard.RedHybrid_RemovePaymentCardLogic_IOS;

public class RemovingCard {
    RedHybrid_RemovePaymentCard redHybrid_RemovePaymentCard;

    public RemovingCard(Config config) {
        if (config.isAndroid())
            redHybrid_RemovePaymentCard = new RedHybrid_RemovePaymentCardLogic_Android();
        if (config.isIos())
            redHybrid_RemovePaymentCard = new RedHybrid_RemovePaymentCardLogic_IOS();
    }


    @Then("I should be navigated to payment method")
    public void checkAddedPaymentCardUI() {
        redHybrid_RemovePaymentCard.checkAddedPaymentCardUI();
    }

    @When("I click on edit CTA in payment method")
    public void clickEditCTA() {
        redHybrid_RemovePaymentCard.clickEditCancelCTA();
    }

    @When("Cancel CTA is pressed")
    public void clickCancelCTA() {
        redHybrid_RemovePaymentCard.clickCancelCTA();
    }

    @Then("I should be navigated to edit payment method")
    public void checkUIAfterPressingEditCTA() {
        redHybrid_RemovePaymentCard.checkUIAfterPressingEditCTA();
    }

    @When("I click on remove CTA in payment method")
    public void clickRemoveCTA() {
        redHybrid_RemovePaymentCard.clickRemoveCTA();
    }

    @Then("I should be navigated to remove payment method pop up")
    public void checkRemovePopUp() throws InterruptedException {
        redHybrid_RemovePaymentCard.checkRemovePopUp();
    }

    @And("I click on confirm remove CTA in pop up")
    public void clickRemoveInConfirmationPopUp() throws InterruptedException {
        redHybrid_RemovePaymentCard.clickRemoveInConfirmationPopUp();
    }

    @Then("I should be navigated to add payment method")
    public void checkAddPaymentAppearAfterRemovingCard() {
        redHybrid_RemovePaymentCard.checkAddPaymentAppearAfterRemovingCard();
    }

    @And("I click on cancel CTA in confirmation popup in payment method")
    public void clickCancelInConfirmationPopUp() throws InterruptedException {
        redHybrid_RemovePaymentCard.clickCancelInConfirmationPopUp();
    }

    @And("I click on x CTA")
    public void pressXBtnRemoveCard() {
        redHybrid_RemovePaymentCard.pressXBtn();
    }

    @Then("Dashboard appears for Remove Card")
    public void checkDashboardAppearsRemoveCard() {
        redHybrid_RemovePaymentCard.checkDashboardAppears();
    }


    @When("I click on cancel CTA in payment method")
    public void iClickOnCancelCTAInPaymentMethod() {
        redHybrid_RemovePaymentCard.clickEditCancelCTA();
    }

    @When("I navigate to plantab through deep link")
    public void iNavigateToPlantabThroughDeepLink() {
        redHybrid_RemovePaymentCard.openDeepLinkForPlanTab();
    }
}

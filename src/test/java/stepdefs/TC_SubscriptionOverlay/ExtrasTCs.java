package stepdefs.TC_SubscriptionOverlay;

import core.Config;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SubsctionOverlay.ExtrasTab.ExtrasTabAbstract;
import pages.SubsctionOverlay.ExtrasTab.ExtrasTabAndroid;
import pages.SubsctionOverlay.ExtrasTab.ExtrasTabIOS;


public class ExtrasTCs {
    ExtrasTabAbstract extrasLogic;

    public ExtrasTCs(Config config){
        if (config.isAndroid()) extrasLogic = new ExtrasTabAndroid();
        if (config.isIos()) extrasLogic = new ExtrasTabIOS();
    }

    @Given("Navigate to Extras")
    public void navigateToExtras(){
        extrasLogic.navigateToExtras();
    }

    @Then("Validate Extras Bars and Caps Card")
    public void checkExtraBarsCapsCard() throws InterruptedException {
        extrasLogic.checkExtraBarsCapsCard();
    }

    @When("Press Extras Bars and Caps CTA")
    public void checkManageBarsExtrasCTA() {
        extrasLogic.checkManageBarsExtrasCTA();
    }

    @Then("Validate Login screen appears")
    public void checkLoginScreenAppear(){
        extrasLogic.checkLoginScreenAppear();
    }

    @Then("Validate Extra Allowances Card")
    public void checkExtraAllowancesCard() throws InterruptedException {
        extrasLogic.checkExtraAllowancesCard();
    }



    @Then("Validate Extra Allowances items details")
    public void checkExtraAllowancesCTADetails() throws InterruptedException {
        extrasLogic.checkExtraAllowancesCTADetails();
    }

    @Then("User should see his Affiliate or Promo Discount")
    public void checkAffiliateDiscount() throws InterruptedException {
        extrasLogic.checkAffiliateOrPromoDiscount();
    }

    @Then("Validate Manage Controls and Limits copy")
    public void ValidateManageControlsLimitsCopy() throws InterruptedException {
        extrasLogic.ValidateManageControlsLimitsCopy();
    }
    @Then("Validate the redirection of Manage controls and Limits")
    public void ValidateRedirectionOfManageControlsLimits() throws InterruptedException {
        extrasLogic.ValidateRedirectionOfManageControlsLimits();
    }

        /*
    @Then("Validate tapping on Allowance item")
    public void TC03_checkClickingAllowance() {
        if (ReadResponse.checkReturnedExtraAllowance()) {
            System.out.println("If the Read the response and Return the Extras in Response ");
            extrasLogic.checkClickingAllowance();
        } else
            throw new SkipException("Item not exist in the response");
    }





    @Then("Validate Extras Bars and Caps items")
    public void TC06_checkExtras() {
        extrasLogic.checkExtras();
    }

    @Then("Validate Extras CTA")
    public void TC07_checkClickingExtras() {
        extrasLogic.checkClickingExtras();
    }

    @Then("Validate Swipe Back In Extras")
    public void TC08_ValidateSwipeBack() {
        extrasLogic.ValidateSwipeBack();
    }

         */

}

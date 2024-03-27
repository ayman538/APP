package stepdefs.RedHybrid;

import com.fasterxml.jackson.core.JsonProcessingException;
import core.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.RedHybrid.ManageyourPlanCard_ToggleAutoRenewOff.ManageyourPlanCard_ToggleAutoRenewOffAbstract;
import pages.RedHybrid.ManageyourPlanCard_ToggleAutoRenewOff.ManageyourPlanCard_ToggleAutoRenewOffAndroid;
import pages.RedHybrid.ManageyourPlanCard_ToggleAutoRenewOff.ManageyourPlanCard_ToggleAutoRenewOff_IOS;


public class ManageyourPlanCard_ToggleAutoRenewOff {

    private ManageyourPlanCard_ToggleAutoRenewOffAbstract ToggleAutoRenewOff;

    public ManageyourPlanCard_ToggleAutoRenewOff(Config config) {
        if (config.isAndroid()) ToggleAutoRenewOff = new ManageyourPlanCard_ToggleAutoRenewOffAndroid();
        if (config.isIos()) ToggleAutoRenewOff = new ManageyourPlanCard_ToggleAutoRenewOff_IOS();
    }


    @And("I scroll down to the manage your plan card")
    public void scrollDownToManageYourPlanCard() {
        // waitForVisibility();
        ToggleAutoRenewOff.scrollDownToMangeYourPlanCard();
    }


    @Then("I should be able to see manage your plan card for RedHybrid user")
    public void checkTheUIOfManageYourPlanCard() {
        ToggleAutoRenewOff.CheckUIOfManageYourPlanCard();
    }

    @When("I click on auto renew plan toggle")
    public void clickOnToggle() {
        ToggleAutoRenewOff.SwitchToggle();
    }

    @Then("I should be able to see disclaimer Mask card")
    public void checkThatDisclaimerMaskCardAppeares() throws JsonProcessingException {
        ToggleAutoRenewOff.checkThatDisclaimerMaskCard();
    }

    @When("I Open Deep Link for Change plan for next Month")
    public void openDeepLinkForChangePlanForNextMonth() {
        ToggleAutoRenewOff.openDeepLinkForChangePlanForNextMonth();
    }

    @And("I should see Your auto-renewal has been updated confirmation screen")
    public void iShouldSeeYourAutoRenewalHasBeenUpdatedConfirmationScreen() {ToggleAutoRenewOff.CheckAutoRenewConfirmationScreen();
    }
}

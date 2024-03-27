package stepdefs.TC_SubscriptionOverlay;

import core.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import models.response.AdditionalChargesDetailsModel;
import models.response.ChargesResponseModel;
import pages.SubsctionOverlay.ChargesTab.ChargesTabAbstract;
import pages.SubsctionOverlay.ChargesTab.ChargesTabAndroid;
import pages.SubsctionOverlay.ChargesTab.ChargesTabIOS;
import utils.AdditionalChargesDetailsUtils;
import utils.ChargesUtils;

import static utilities.PropertiesLoader.readEnv;

public class ChargesTab {

    ChargesTabAbstract ChargesTab;
    ChargesResponseModel chargesResponseModel;
    AdditionalChargesDetailsModel additionalChargesDetailsModel;
    Boolean live = System.getProperty("isLiveTest", readEnv("isLiveTest")).equalsIgnoreCase("true");

    public ChargesTab(Config config) {
        if (config.isAndroid()) ChargesTab = new ChargesTabAndroid();
        if (config.isIos()) ChargesTab = new ChargesTabIOS();
        if(!live) {
            chargesResponseModel = ChargesUtils.GetCharges();
            additionalChargesDetailsModel = AdditionalChargesDetailsUtils.getAdditionalChargesDetails();
        }
    }

    @Given("Init Charges tab")
    public void InitChargesTab() {
            ChargesTab.setBeforeClass();
    }

    @Then("Validate Additional Charges")
    public void CheckAdditionalCharges() {
        if (chargesResponseModel.additionalChargesCard.header.quantity.contains("0.0")) {
            ChargesTab.noAdditionalCard();
        } else
            ChargesTab.validateAllowanceChargesDisplayed();
    }

    @Then("Validate Required Login in Itemized Journey")
    public void TC05_validateItemizedJourney(){
        if (!chargesResponseModel.additionalChargesCard.header.quantity.equals("0.00")) {
            ChargesTab.ItemizedJourney();
        } else
            System.out.println("User has no additional charges :( ");
    }

    @Then("Validate Charges SSO")
    public void TC02_validateChargesSSO() {
        ChargesTab.chargesSSOJourney();
    }

    @Then("Validate Total Estimated Charges")
    public void TC04_validateTotalEstimatedCharges() {
        ChargesTab.validateTotalEstimatedCharges();
    }

    @Then("Validate UnBills More Than Six")
    public void TC06_validateUnBillsMoreThanSix(){
      if ((!chargesResponseModel.additionalChargesCard.header.quantity.equals(0.0)) &&
                ((additionalChargesDetailsModel.lineItems.size()) >= 6)) {
            ChargesTab.unBilledChargesListMoreThanSix();
        } else
            System.out.println("User has less than 6 unbills");
    }

    @Then("Click on Chevron of additional charges")
    public void clickOnChevronOfAdditionalCharges() {
        ChargesTab.additionalChargesChevronCTA();

    }

    @Then("Click on Chevron of details item")
    public void clickOnChevronOfDetailsItem() {
        ChargesTab.detailsChevronCTA();
    }

    @Then("Validate Itemized screen")
    public void validateItemizedScreen() {
        ChargesTab.assertDetailChevronText();
    }

    @Then("Click on View Details CTA")
    public void clickOnViewDetailsCTA() { ChargesTab.ClickOnViewDetailsCTA(); }

    @And("I validate Monthly Charges")
    public void iValidateMonthlyCharges() {
        ChargesTab.validateMonthlyCharges();
    }

    @And("Navigate to Charges")
    public void navigateToCharges() { ChargesTab.navigateToChargesOverlay();}
}


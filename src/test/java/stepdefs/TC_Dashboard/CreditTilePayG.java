package stepdefs.TC_Dashboard;

import core.Config;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import models.response.SegmentResponseModel;
import pages.Dashboard.CreditTilePayG.CreditTilePayGAbstract;
import pages.Dashboard.CreditTilePayG.CreditTilePayGAndroid;
import pages.Dashboard.CreditTilePayG.CreditTilePayGiOS;
import utils.SegmentUtils;

public class CreditTilePayG {


    CreditTilePayGAbstract creditTile;
    //static boolean navigatedToDashboard = false;


    public CreditTilePayG(Config config){
        if (config.isAndroid()) creditTile = new CreditTilePayGAndroid();
        if (config.isIos()) creditTile = new CreditTilePayGiOS();
    }


    @Given("Dashboard is initialized")
    public void dashboardIsInitialized() {
        creditTile.creditTileIsDisplayed();

    }
    @Then("Validate credit card header")
    public void assertCreditTitleHeader() {creditTile.assertCreditHeaderTextPREPAY();}
    @Then("Validate low credit card title")
    public void assertCreditTitleTitle(){
        creditTile.assertCreditTitleTextPrePayIsLow();
    }
    @Then("Validate credit card amount is less than 5 Pounds")
    public void assertCreditTitleAmount(){
        creditTile.assertCreditAmountTextPREPAYIsLow();
    }
    @Then("Validate credit card footer")
    public void assertCreditTitleFooter(){
        creditTile.assertCreditFooterTextPREPAY();
    }

    @Then("Validate Charges Credit Tile")
    public void ValidateChargesTile(){
        creditTile.ValidateChargesTile();
    }
    @Then("Validate charges API response")
    public void assertChargesAPIResponse() throws Exception { creditTile.assertCreditTile();
    }

    @Then("Validate credit card amount is greater than or equal five pounds")
    public void validateCreditCardAmountIsGreaterThanOrEqualFivePounds() {
        creditTile.assertCreditAmountTextPREPAY();
    }

    @Then("Validate credit card title")
    public void validateCreditCardTitle() {
        creditTile.assertCreditTitleTextPrePay();
    }

    @Then("I Validate Dashboard Tiles For Hbb User")
    public void validateChargesCreditTileForHbbUser() {
        creditTile.ValidateTilesForHbbUser();
    }

    @Then("I Validate Vesta Journeys for PayG users")
    public void ValidateVestaJoruneys() {
        creditTile.ValidateVestaJoruneys();
    }
    @Then("I Validate Vesta Journeys for PayG child")
    public void ValidateVestaJoruneysforPayGChild() {
        creditTile.ValidateVestaJoruneysforPayGChild();
    }

    @Given("I navigate to plan tab for payg")
    public void iNavigateToPlanTabForPayg() {
        creditTile.navigateToPlanPayg();
    }

    @Given("I navigate to Bug a Big Value Bundle")
    public void iNavigateTobig(){
        creditTile.navigateToBugBigValue();
    }

    @Then("I validate Bug a Big Value Bundle screen")
    public void iValidateBugABigValueBundleScreen() {
        creditTile.validateBigValueBundleScreen();
    }

    @Then("I validate usage tab for payg is opened")
    public void iValidateUsageTabForPaygIsOpened() {
        creditTile.validateUsageForPayg();
    }

    @Then("I validate plan tab for payg is opened")
    public void iValidatePlanTabForPaygIsOpened() {
        creditTile.validatePlanForPayg();
    }
}

package stepdefs.DX_IDM;

import core.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_scouse.An;
import pages.DX_IDM.ForgottenPIN.DX_IDM_ForgottenPINAbstract;
import pages.DX_IDM.ForgottenPIN.DX_IDM_ForgottenPINAndroid;
import pages.DX_IDM.ForgottenPIN.DX_IDM_ForgottenPINIOS;

import java.io.IOException;

public class ForgottenPIN {
    DX_IDM_ForgottenPINAbstract forgottenPIN_logic;

    public ForgottenPIN(Config config){
        if (config.isAndroid()) forgottenPIN_logic = new DX_IDM_ForgottenPINAndroid();
        if (config.isIos()) forgottenPIN_logic = new DX_IDM_ForgottenPINIOS();

    }

    @When("Click My Account for forget PIN")
    public void ClickOnMyAccountForForgottenPIN() throws InterruptedException {
        forgottenPIN_logic.ClickOnMyAccountForForgottenPIN();
    }

    @And("Click on Forgotten PIN CTA")
    public void ClickOnForgottenPINCTA(){
        forgottenPIN_logic.ClickOnForgottenPINCTA();
    }

    @And("Enter password for forget PIN")
    public void EnterPasswordForForgottenPIN() throws InterruptedException {
        forgottenPIN_logic.EnterPasswordForForgottenPIN();
    }

    @And("Enter and confirm PIN {string}")
    public void EnterAndConfirmNewPIN(String PIN){
        forgottenPIN_logic.EnterAndConfirmNewPIN(PIN);
        forgottenPIN_logic.ClickOkDone();
    }

    @Then("Check Accounts appears successfully")
    public void CheckMyAccountOpenSuccessfully(){
        forgottenPIN_logic.CheckMyAccountOpenSuccessfully();
    }

    @And("Enter valid PIN {string}")
    public void EnterPIN(String validPIN){
        forgottenPIN_logic.EnterPIN(validPIN);
    }

    @And("Enter Invalid PIN {string}")
    public void EnterInvalidPIN(String InValidPIN){
        forgottenPIN_logic.EnterPIN(InValidPIN);
    }

    @And("Confirm with invalid PIN {string}")
    public void ConfirmInvalidPIN(String invalidPIN){
        forgottenPIN_logic.ConfirmPIN(invalidPIN);
    }

    @And("Confirm with valid PIN {string}")
    public void ConfirmPIN(String invalidPIN){
        forgottenPIN_logic.ConfirmPIN(invalidPIN);
        forgottenPIN_logic.ClickOkDone();
    }

    @When("Click Back CTA")
    public void ClickBackCTA(){
        forgottenPIN_logic.ClickBackCTA();
    }

    @Then("Check entered PIN still exists")
    public void checkPINExistsAfterBackCTA(){
        forgottenPIN_logic.checkPINExistsAfterBackCTA();
    }

    @Then("PIN Mismatch error appears")
    public void checkPINErrorAppears(){
        forgottenPIN_logic.checkPINErrorAppears();
    }

    /*
    @Given("Init DX IDM Forgotten PIN")
    public void InitDXIDMForgottenPIN() throws IOException {
        forgottenPIN_logic = new DX_IDM_ForgottenPIN_Logic();
    }

    @Given("Trigger Journey Requires Login")
    public void triggerJourneyRequiresLogin() throws InterruptedException {
        forgottenPIN_logic.triggerJourneyRequiresLogin();
    }

    @When("Enter Your PIN Screen Is Displayed")
    public void enterYourPINScreenIsDisplayed() throws  InterruptedException {
        forgottenPIN_logic.enterYourPINScreenIsDisplayed();
    }

    @And("Click On Forgot Your PIN Link")
    public void clickOnForgotYourPINLink() {
        forgottenPIN_logic.clickOnForgotYourPINLink();
    }

    @Then("Password Screen Is Displayed")
    public void passwordScreenIsDisplayed() throws InterruptedException {
        forgottenPIN_logic.passwordScreenIsDisplayed();
    }

    @When("Click X Button")
    public void clickXButton() {
        forgottenPIN_logic.clickXButton();
    }

    @When("Trigger Forgot PIN Journey Till Enter New PIN Screen")
    public void triggerForgotPINJourneyTillEnterNewPINScreen() throws InterruptedException {
        forgottenPIN_logic.triggerForgotPINJourneyTillEnterNewPINScreen();
    }

    @Then("Validate Enter New PIN Screen Content")
    public void validateEnterNewPINScreenContent() {
        forgottenPIN_logic.validateEnterNewPINScreenContent();
    }

    @When("Trigger Forgot PIN Journey Till Re-Enter New PIN Screen")
    public void triggerForgotPINJourneyTillReEnterNewPINScreen() throws InterruptedException {
        forgottenPIN_logic.triggerForgotPINJourneyTillReEnterNewPINScreen();
    }

    @Then("Validate Re-Enter New PIN Screen Content")
    public void validateReEnterNewPINScreenContent() {
        forgottenPIN_logic.validateReEnterNewPINScreenContent();
    }

    @When("Click Back CTA")
    public void clickBackCTA() {
        forgottenPIN_logic.clickBackCTA();
    }

    @Then("Enter Your New PIN Screen IS Displayed")
    public void enterYourNewPINScreenISDisplayed() {
        forgottenPIN_logic.enterYourNewPINScreenISDisplayed();
    }

    @When("Re-Enter PIN Screen IS Displayed")
    public void reEnterPINScreenISDisplayed() {
        forgottenPIN_logic.reEnterPINScreenISDisplayed();
    }

    @When("Enter Not Matched PIN")
    public void enterNotMatchedPIN() {
        forgottenPIN_logic.enterNotMatchedPIN();
    }

    @Then("Validate Continue CTA Is Disabled")
    public void validateContinueCTAIsDisabled() {
        forgottenPIN_logic.validateContinueCTAIsDisabled();
    }

    @And("Entering Matched PIN")
    public void enteringMatchedPIN() {
        forgottenPIN_logic.enteringMatchedPIN();
    }

    @Then("Validate PIN Successfully Updated Screen Is Displayed")
    public void validatePINSuccessfullyUpdatedScreenIsDisplayed() {
        forgottenPIN_logic.validatePINSuccessfullyUpdatedScreenIsDisplayed();
    }

    @And("HardClose The App Then Relaunch")
    public void hardCloseTheAppThenRelaunch() throws InterruptedException {
        forgottenPIN_logic.hardCloseTheAppThenRelaunch();
    }

    @And("Trigger Any Journey Require Login Then Enter New Set PIN")
    public void triggerAnyJourneyRequireLoginThenEnterNewSetPIN() throws InterruptedException {
        forgottenPIN_logic.triggerAnyJourneyRequireLoginThenEnterNewSetPIN();
    }

    @Then("Journey Should Be Opened")
    public void journeyShouldBeOpened() throws InterruptedException {
        forgottenPIN_logic.journeyShouldBeOpened();
    }

    @When("Click On OK All Done CTA")
    public void clickOnOKAllDoneCTA() {
        forgottenPIN_logic.clickOnOKAllDoneCTA();
    }

    @When("Trigger Forgot PIN Journey Till PIN Successfully Updated Screen")
    public void triggerForgotPINJourneyTillPINSuccessfullyUpdatedScreen() throws InterruptedException {
        forgottenPIN_logic.triggerForgotPINJourneyTillPINSuccessfullyUpdatedScreen();
    }

    @When("Enter Valid PIN")
    public void enterValidPIN() {
        forgottenPIN_logic.enterValidPIN();
    }

    /*@Then("I should be navigated to dashboard ")
    public void dashboardIsDisplayed() throws InterruptedException {
        forgottenPIN_logic.dashboardIsDisplayed();
    }

    @And("PIN Is Not Reset")
    public void pinIsNotReset() throws InterruptedException {
        forgottenPIN_logic.pinIsNotReset();
    }
    */
}
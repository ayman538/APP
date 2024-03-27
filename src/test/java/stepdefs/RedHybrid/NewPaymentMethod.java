package stepdefs.RedHybrid;

import core.Config;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.RedHybrid.PaymentMethod.RedHybrid_AddNewPayment;
import pages.RedHybrid.PaymentMethod.RedHybrid_AddNewPayment_Android;
import pages.RedHybrid.PaymentMethod.RedHybrid_AddNewPayment_IOS;


public class NewPaymentMethod {
    RedHybrid_AddNewPayment redHybrid_AddNewPayment;


    public NewPaymentMethod(Config config) {
        if (config.isAndroid())
            redHybrid_AddNewPayment = new RedHybrid_AddNewPayment_Android();
        if (config.isIos()) redHybrid_AddNewPayment = new RedHybrid_AddNewPayment_IOS();
    }


/*
    @Given("Initialize Add New Payment Method")
    public void beforeFeature() throws IOException {
        redHybrid_AddNewPayment = new RedHybrid_AddNewPaymentLogic();
    }

 */

    @When("I click on payment on dashboard tray")
    public void TapOnPayment() {
        redHybrid_AddNewPayment.TapOnPayment();
    }

    @Then("Login screen should be displayed")
    public void ValidateLoginScreenIsDisplayed() {
        redHybrid_AddNewPayment.ValidateLoginScreenIsDisplayed();
    }

    @Then("I should Validate Add new payment method is displayed successfully")
    public void ValidateAddNewPaymentMethod() {
        redHybrid_AddNewPayment.ValidateAddNewPaymentMethod();
    }

    @When("I click on Add a new card CTA")
    public void TapOnAddNewCard() throws InterruptedException {
        redHybrid_AddNewPayment.TapOnAddNewCard();
    }

    @Then("I should Validate Add Payment method screen is displayed successfully")
    public void ValidateAddPaymentMethodScreen() {
        redHybrid_AddNewPayment.ValidateAddPaymentMethodScreen();
    }

    @Then("I should Validate Add Payment method screen content")
    public void ValidateAddPaymentMethodScreenContent() {
        redHybrid_AddNewPayment.ValidateAddPaymentMethodScreenContent();
    }

    @When("I click on X icon")
    public void TapOnXIcon() {
        redHybrid_AddNewPayment.TapOnXIcon();
    }

    @When("I click on Android physical back")
    public void TapOnAndroidPhysicalBack() {
        redHybrid_AddNewPayment.TapOnAndroidPhysicalBack();
    }

    @Then("Validate Dashboard should be displayed")
    public void ValidateDashboardIsDisplayed() {
        redHybrid_AddNewPayment.ValidateDashboardIsDisplayed();
    }

    @When("Turn on the toggles")
    public void TurnOnTheToggles() {
        redHybrid_AddNewPayment.TurnOnTheToggles();
    }

    @Then("I should Validate Continue CTA is clickable")
    public void ValidateContinueCTAIsClickable() {
        redHybrid_AddNewPayment.ValidateContinueCTAIsClickable();
    }

    @When("Tap on back icon")
    public void tapOnBackIcon() {
        redHybrid_AddNewPayment.ClickOnBackIcon();
    }

    @Then("I should Validate X icon is not displayed")
    public void validateXIconIsNotDisplayed() {
        redHybrid_AddNewPayment.XiconIsNotDisplayed();
    }

    @Given("User on Enter Valid UK Postcode screen")
    public void userOnEnterValidUKPostcodeScreen() throws InterruptedException {
        TapOnAddNewCard();
        TurnOnTheToggles();
        ValidateContinueCTAIsClickable();
    }
}

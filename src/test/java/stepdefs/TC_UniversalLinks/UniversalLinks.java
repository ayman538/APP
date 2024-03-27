package stepdefs.TC_UniversalLinks;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.simple.parser.ParseException;
import pages.UniversalLinks.UniversalLinksLogic;

import java.io.IOException;

public class UniversalLinks {

    UniversalLinksLogic universalLinksLogic;

    @Given("Init Universal Links")
    public void setBeforeClass() {
        universalLinksLogic = new UniversalLinksLogic();
    }

    //TODO
    @Given("App Soft Close")
    public void softCloseApp() {
        universalLinksLogic.softCloseApp(5);
    }

    @Then("Validate Usage Universal Link")
    public void UsageFlow() throws ParseException, InterruptedException, IOException {
        System.out.println("============= Start TC01 Validate the usage page universal link PAYG==========");
        universalLinksLogic.UsageFlow();
        System.out.println("============= End TC01 Validate the usage page universal link PAYG ==========");

    }

    @Then("Validate FAQs Universal Link")
    public void faqsFlow() throws ParseException, InterruptedException, IOException {
        System.out.println("============= Start TC02 Validate the FAQs universal link PAYG==========");

        universalLinksLogic.faqsFlow();
        System.out.println("============= End TC02 Validate the FAQs universal link PAYG==========");

    }

    @Then("Validate TopUp Universal Link")
    public void topUpFlow() throws ParseException, InterruptedException, IOException {
        System.out.println("============= Start TC03 Validate the TopUp universal link PAYG==========");
        universalLinksLogic.topUpFlow();
        System.out.println("============= End TC03 Validate the TopUp universal link PAYG==========");

    }

    @When("Click on Broad band service Universal Link")
    public void ClickingOnBroadBandServiceUniversalLink()
    {
        universalLinksLogic.ValidateBroadBandServiceUniversalLink();
    }
    @When("Click on Spend Manager Universal Link")
    public void ClickingOnSpendManagerUniversalLink()
    {
        universalLinksLogic.ValidateSpendManagerUniversalLink();
    }

    @When("Click on Device plan Universal Link")
    public void ClickOnDevicePlan()
    {
        universalLinksLogic.ValidateDevicePlanUniversalLink();
    }

    @Then("Validate Extras Universal Link")
    public void extrasFlow() throws ParseException, InterruptedException, IOException {
        System.out.println("============= Start TC04 Validate the Extras universal link PAYG==========");
        universalLinksLogic.extrasFlow();
        System.out.println("============= Start TC04 Validate the Extras universal link PAYG==========");

    }

    @Then("Validate TradeIn is open while the app in foreground")
    public void TradeInOpened() {
        universalLinksLogic.TradeInOpened();
    }

    @Then("Validate TradeIn is open after hard close")
    public void TradeInOpenedAfterHardClose() {
        universalLinksLogic.TradeInAfterHardClose();
    }

    @Then("Validate TradeIn is open while app in background")
    public void TradeInWhileAppInBackground() {
        universalLinksLogic.TradeInWhileAppInBackground();
    }

    //TODO
    @When("Navigate to Payments")
    public void navigateToPaymentFlow() {
        universalLinksLogic.navigateToPaymentFlow();
    }

    //TODO
    @Then("Validate payments is open after pressing deeplink")
    public void checkPaymentFlow() {
        universalLinksLogic.checkPaymentFlow();
    }

    //TODO
    @Given("Login for RedHybrid universal link")
    public void fullLogin() throws InterruptedException {
        universalLinksLogic.fullLogin();
    }

    //TODO
    @When("Login with PIN for RedHybrid universal link")
    public void loginWithPin() throws InterruptedException {
        universalLinksLogic.loginWithPin();
    }

    //TODO
    @When("Hardclose app")
    public void hardClose() {
        universalLinksLogic.hardClose();
    }

    @Then("Validate Billing is displayed after tapping on universal link")
    public void validateBillingIsDisplayedAfterTappingOnUniversalLink() {universalLinksLogic.ValidateBillingUniversalLink();}

    @When("Click on Your plan Universal Link")
    public void ClickingOnYourPlanUniversalLink()
    {
        universalLinksLogic.ValidateYourPlanUniversalLink();
    }

    @Then("Click on Account Settings Universal link")
    public void clickOnAccountSettingsUniversalLink() {
        universalLinksLogic.ValidateAccountSettingsUniversalLink();

    }

    @Then("Click on Cards And Payments Universal Link")
    public void clickOnCardsAndPaymentsUniversalLink() {
        universalLinksLogic.validateCardsAndPaymentsUniversalLink();
    }

    @And("Click on Controls and Limits Universal link")
    public void clickOnControlsAndLimitsUniversalLink() {
        universalLinksLogic.clickOnControlsAndLimitsUniversalLink();
    }

    @Then("validate Native Controls tab is opened")
    public void validateNativeControlsTabIsOpened() {
        universalLinksLogic.validateExtrasControlsTabIsOpened();
    }

    @Then("validate Extras tab is opened with old experience")
    public void validateExtrasTabIsOpenedWithOldExperience() {
        universalLinksLogic.validateExtrasControlsTabIsOpened();
    }


    @And("Click on Extras Universal link")
    public void clickOnExtrasUniversalLink() {
        universalLinksLogic.clickOnExtrasUniversalLink();
    }

    @Then("Validate new Native Extras tab is opened")
    public void validateNewExtrasTabIsOpened() {
        universalLinksLogic.validateNewExtrasTabIsOpened();
    }



}





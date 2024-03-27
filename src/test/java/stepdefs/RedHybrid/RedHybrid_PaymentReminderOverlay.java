package stepdefs.RedHybrid;
import core.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.RedHybrid.LoginFlow.RedHybrid_LoginLogic_Android;
import pages.RedHybrid.PaymentReminderOverlay.RedHybrid_PaymentReminderOverlay_Abstract;
import pages.RedHybrid.PaymentReminderOverlay.RedHybrid_PaymentReminderOverlay_Android;
import pages.RedHybrid.PaymentReminderOverlay.RedHybrid_PaymentReminderOverlay_IOS;

public class RedHybrid_PaymentReminderOverlay {

    private RedHybrid_PaymentReminderOverlay_Abstract paymentReminderOverlay_abstract;
    RedHybrid_LoginLogic_Android redHybridLogin= new RedHybrid_LoginLogic_Android();


    public RedHybrid_PaymentReminderOverlay(Config config) {
          if (config.isAndroid()) paymentReminderOverlay_abstract = new RedHybrid_PaymentReminderOverlay_Android();
          if (config.isIos()) paymentReminderOverlay_abstract = new RedHybrid_PaymentReminderOverlay_IOS();
    }


    @Then("check Reminder Overlay UI")
    public void checkReminderOverlayUI() throws InterruptedException {
        paymentReminderOverlay_abstract.checkReminderOverlayUI();
    }

    @When("I close the app and relaunch it again")
    public void hardCloseAppAndLaunchIt() throws InterruptedException {
        paymentReminderOverlay_abstract.hardCloseAppAndLaunchIt();
        //paymentReminderOverlay_abstract.ClickOnSkipSoftLoginPrompt();

    }

    @And("click On Close Button")
    public void clickOnCloseButton(){
        paymentReminderOverlay_abstract.clickOnCloseButton();
    }

    @And("click On Add Payment CTA")
    public void clickOnPaymentCTA(){
        paymentReminderOverlay_abstract.clickOnAddPaymentCTA();
    }

    @Then("Add Payment drawer is displayed")
    public void validateAddPaymentScreen() throws InterruptedException {
    paymentReminderOverlay_abstract.validateAddPaymentScreen();
    }

    @And("Dismiss add payment")
    public void dissmissAddPayment(){
     paymentReminderOverlay_abstract.dissmissAddPayment();
    }

    @And("Click on back to my vodafone CTA")
    public void clickOnReturnToVfButton(){
        paymentReminderOverlay_abstract.clickOnBackToVodafoneCTA();
    }



    @When("Delete Payment Card")
    public void clickRemoveCTA()
    {
        paymentReminderOverlay_abstract.clickOnRemovePaymentCTA();
    }


    @Then("Payment Overlay Is Displayed")
    public void PaymentOverlayIsDisplayed()

    {
        paymentReminderOverlay_abstract.ValidatePaymentOverlay();
    }
}

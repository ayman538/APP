package stepdefs.RedHybrid;

import core.Config;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.SkipException;
import pages.RedHybrid.ProcessingPaymentCard.RedHybrid_ValidateCardAdding;
import pages.RedHybrid.ProcessingPaymentCard.RedHybrid_ValidateCardAddingPO;

public class ValidateCardAdding {

    //RedHybrid_ValidateCardAddingLogic RedHybrid_ValidateCardAdding;
    RedHybrid_ValidateCardAddingPO RedHybrid_ValidateCardAddingPO;
    RedHybrid_ValidateCardAdding redHybrid_ValidateCardAdding;

    @Given("Initialize Validate Card Method")
    public void ValidateCardAdding(Config config) {
        if (config.isAndroid())
            redHybrid_ValidateCardAdding = new pages.RedHybrid.ProcessingPaymentCard.RedHybrid_ValidateCardAddingLogic_Android();
        if (config.isIos())
            redHybrid_ValidateCardAdding = new pages.RedHybrid.ProcessingPaymentCard.RedHybrid_ValidateCardAddingLogic_IOS();
    }
/*
    @Given("Initialize Validate Card Method")
    public void beforeFeature() throws IOException {
        RedHybrid_ValidateCardAdding = new RedHybrid_ValidateCardAddingLogic();
        RedHybrid_ValidateCardAddingPO = new RedHybrid_ValidateCardAddingPO();
    }

 */


    @When("Click on Continue CTA")
    public void clickOnContinueCTA() {
        redHybrid_ValidateCardAdding.ClickOnContinue();
    }

    @Then("Validate Verified Card Screen")
    public void validateVerifiedCardScreen() {
        if (RedHybrid_ValidateCardAddingPO.RedHybrid_SuccessBody.isDisplayed()) {
            redHybrid_ValidateCardAdding.ValidateProcessingScreen();
            redHybrid_ValidateCardAdding.ValidateVerifiedCardScreen();
        } else {
            throw new SkipException("Card isn't verified");
        }
    }

    @Then("Validate Failed Card Screen")
    public void validateFailedCardScreen() {
        if (RedHybrid_ValidateCardAddingPO.RedHybrid_FailedBody.isDisplayed()) {
            redHybrid_ValidateCardAdding.ValidateProcessingScreen();
            redHybrid_ValidateCardAdding.ValidateFailedCardScreen();
        } else {
            throw new SkipException("Card is verified");
        }
    }

    @When("Click on X icon on Verified Card screen")
    public void clickOnXIconOnVerifiedCardScreen() {
        redHybrid_ValidateCardAdding.ClickOnXicon();
    }

    @When("Click on physical back on success screen")
    public void clickOnPhysicalBackOnSuccessScreen() {
        redHybrid_ValidateCardAdding.TapOnAndroidPhysicalBackOnSuccessScreen();
    }

    @When("Click on Cancel CTA")
    public void clickOnCancelCTA() {
        redHybrid_ValidateCardAdding.ClickOnCancel();
    }

    @When("Click on try again CTA in failed screen")
    public void clickOnTryAgainCTAInFailedScreen() {
        redHybrid_ValidateCardAdding.ClickOnTryAgain();
    }

    @Then("Click on physical back on processing screen")
    public void clickOnPhysicalBackOnProcessingScreen() {
        redHybrid_ValidateCardAdding.TapOnAndroidPhysicalBackOnProcessingScreen();
    }
}

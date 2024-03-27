package stepdefs.RedHybrid;

import com.fasterxml.jackson.core.JsonProcessingException;
import core.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.RedHybrid.ConfirmExtrasPurchase_BeforeAuthorizationStatus.ConfirmExtrasPurchase_BeforeAuthorizationStatus_Abstract;
import pages.RedHybrid.ConfirmExtrasPurchase_BeforeAuthorizationStatus.ConfirmExtrasPurchase_BeforeAuthorizationStatus_Android;
import pages.RedHybrid.ConfirmExtrasPurchase_BeforeAuthorizationStatus.ConfirmExtrasPurchase_BeforeAuthorizationStatus_IOS;

public class ConfirmExtrasPurchase_BeforeAuthorizationStatus {

    private ConfirmExtrasPurchase_BeforeAuthorizationStatus_Abstract confirmExtrasPurchase;


    public ConfirmExtrasPurchase_BeforeAuthorizationStatus(Config config) {
        if (config.isAndroid())
            confirmExtrasPurchase = new ConfirmExtrasPurchase_BeforeAuthorizationStatus_Android();
        if (config.isIos())
            confirmExtrasPurchase = new ConfirmExtrasPurchase_BeforeAuthorizationStatus_IOS();

    }

    @Then("Assert that PAY Securely CTA should be displayed")
    public void assertThatConfirmYourPurchaseOverlayDisplayed() {
        confirmExtrasPurchase.assertThatConfirmYourPurchaseOverlayDisplayed();
    }

    @Then("Assert that Confirm your purchase overlay displayed Successfully For Extra Category {string} and extra name {string} and order type {string}")
    public void assertThatConfirmYourPurchaseOverlayUI_Displayed(String ExtraGroup,String ExtraName, String orderType) throws JsonProcessingException {
        confirmExtrasPurchase.screenUIAPIResponseCombatability( ExtraGroup ,ExtraName, orderType);
    }

    @And("User choose an extra from add extra list")
    public void userChooseAnExtraFromAddExtraList()  {
        confirmExtrasPurchase.userChooseAnExtraFromAddExtraList();
    }

    @And("I enter {string} CVV and payment passcode if needed")
    public void userEntersCVVAndPaymentPasscodeIfNeeded(String CVV) throws InterruptedException {
        confirmExtrasPurchase.userEntersCVVAndPaymentPasscodeIfNeeded(CVV);
    }


    @When("user clicks on addExtras tile on dashboard")
    public void userClicksOnAddExtrasTileOnDahboard() {
        confirmExtrasPurchase.clickExtraTile();
    }

    @When("I Select {string} from Extras List")
    public void iSelectFromExtrasList(String Extra) {
        confirmExtrasPurchase.SelectExtra(Extra);
    }

    @And("I scroll Down to continue CTA")
    public void iScrollToContinueCTA() {
        confirmExtrasPurchase.ScrollDownToContinueBtn();
    }
}

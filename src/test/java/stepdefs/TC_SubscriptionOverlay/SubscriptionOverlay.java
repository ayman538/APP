package stepdefs.TC_SubscriptionOverlay;

import core.Config;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.SubsctionOverlay.SubscriptionOverlayHeader.SubscriptionOverlayAbstract;
import pages.SubsctionOverlay.SubscriptionOverlayHeader.SubscriptionOverlayAndroid;
import pages.SubsctionOverlay.SubscriptionOverlayHeader.SubscriptionOverlayIOS;

public class SubscriptionOverlay {
    SubscriptionOverlayAbstract subsOver;

    public SubscriptionOverlay(Config config){
        if(config.isAndroid()) subsOver = new SubscriptionOverlayAndroid();
        if(config.isIos()) subsOver = new SubscriptionOverlayIOS();
    }

    @Given("Navigate to SubsOverlay")
    public void navigateToSubsOverlay(){
        subsOver.navigateToSubsOverlay();
    }

    @Then("Validate SubsOverlay header")
    public void checkSubsOverlayHeader(){
        subsOver.checkSubsOverlayHeader();
    }

    /*
    @Then("Validate Subscription Overlay Icon is displayed")
    public void TC01_ValidateSubscriptionOverlayIcon() {
        subsOver.ValidateSubscriptionIcon();
    }

    @Then("Validate Subscription Overlay MSISDN is displayed")
    public void TC02_ValidateSubscriptionOverlayMSISDN() {
        subsOver.ValidateMSISDN();
    }

    @Then("Validate Subscription Overlay Type is displayed")
    public void TC03_ValidateSubscriptionOverlayType() {
        subsOver.ValidateSubscriptionType();
    }

    @Then("Validate Subscription Overlay Amount is displayed")
    public void TC04_ValidateSubscriptionOverlayAmount() {
        subsOver.ValidatesAmount();
    }

    @Then("Validate Subscription Overlay Upgrade CTA is not displayed")
    public void TC05_ValidateSubscriptionOverlayUpgradeCTA() {
        subsOver.ValidatesUpgradeCTA();
    }

    @Then("Validate Subscription Overlay X Icon is displayed")
    public void TC06_ValidateSubscriptionOverlayXIconIsDisplayed() {
        subsOver.ValidateXIconDisplayed();
    }

    @Then("Validate Subscription Overlay X Icon Closed and navigated to dashboard")
    public void TC07_ValidateSubscriptionOverlayXIconFunctionality() {
        subsOver.ValidateXIconFunctionality();
    }

     */

}

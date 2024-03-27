package stepdefs.TC_Dashboard;

import core.Config;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.Dashboard.VeryMe.VeryMeAbstract;
import pages.Dashboard.VeryMe.VeryMeAndroid;
import pages.Dashboard.VeryMe.VeryMeIOS;

public class VeryMeOffers {

    VeryMeAbstract veryMeOffersLogic;

    public VeryMeOffers(Config config){
        if(config.isAndroid()) veryMeOffersLogic = new VeryMeAndroid();
        if(config.isIos()) veryMeOffersLogic = new VeryMeIOS();
    }

    @Given("Dashboard loaded and scroll to VeryMe offers")
    public void scrollDownToVeryMe(){
        veryMeOffersLogic.scrollDownToVeryMe();
    }

    @Then("Check VeryMe title")
    public void checkVeryMeTitle(){
        veryMeOffersLogic.checkVeryMeTitle();
    }

    @Then("Check VeryMe View All CTA")
    public void checkVeryMeViewAllCTA() throws InterruptedException {
        veryMeOffersLogic.checkVeryMeViewAllCTA();
    }

    @Then("Check VeryMe UI")
    public void checkVeryMeUI(){
        veryMeOffersLogic.checkVeryMeUI();
    }

    @Then("Scroll down and check VeryMe does not appear for child users")
    public void checkVeryMeDisappearForSpecificUsers() {
        veryMeOffersLogic.checkVeryMeDisappearForSpecificUsers();
    }

    @Then("Validate VeryMe deep link")
    public void veryMeDeepLink()
    {
        veryMeOffersLogic.validateVeryMeDeepLink();
    }

    @Then("Validate VeryMe universal link")
    public void VeryMeUniversalLink()
    {
        veryMeOffersLogic.validateVeryMeUniversalLink();
    }

    /*
    static boolean navigatedToDashboard = false;

    @Given("Init VeryMe offer")
    public void beforeClass() throws IOException, ParseException {
        if (!navigatedToDashboard) {
            testAfterLastScenario();
            navigatedToDashboard = true;
        }
        veryMeOffersLogic = new VeryMeOffersLogic();
    }

    @Then("Validate VeryMe offers image is Displayed")
    public void TC01_VeryMeOffersTC_ValidateOfferImage() throws ParseException {
        veryMeOffersLogic.ValidateOfferImage();
    }

    @Then("Validate VeryMe offers title is Displayed")
    public void TC02_VeryMeOffersTC_ValidateOfferTitle() throws ParseException {
        veryMeOffersLogic.ValidateOfferTitle();
    }

    @Then("Validate VeryMe offers logo is Displayed")
    public void TC03_VeryMeOffersTC_ValidateOfferLogo() throws ParseException {
        veryMeOffersLogic.ValidateOfferLogo();
    }

    @Then("Validate VeryMe offers is opened")
    public void TC04_VeryMeOffersTC_ValidateOfferIsOpened() throws ParseException, InterruptedException {
        veryMeOffersLogic.ValidateOfferIsOpened();
    }

     */

}

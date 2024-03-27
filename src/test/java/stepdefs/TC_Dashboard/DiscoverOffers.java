package stepdefs.TC_Dashboard;

import core.Config;
import io.cucumber.java.en.Then;
import pages.Dashboard.Discover.DiscoverAbstract;
import pages.Dashboard.Discover.DiscoverAndroid;
import pages.Dashboard.Discover.DiscoverIOS;



public class DiscoverOffers {

    DiscoverAbstract DiscoverOffers;

    public DiscoverOffers(Config config){
        if(config.isAndroid()){
            DiscoverOffers = new DiscoverAndroid();
        }
        if(config.isIos()){
            DiscoverOffers = new DiscoverIOS();
        }
    }

    /*@Given("Init Discover Offers")
    public void beforeClass() throws ParseException, IOException {
        if (!run) {
            testAfterLastScenario();
            run = true;
        }
        discoverLogic = new DiscoverLogic();
    }*/

    @Then("Validate Discover Offers Displayed")
    public void DiscoverOffersTC_ValidateDiscoverOffersDisplayed() throws InterruptedException {
        DiscoverOffers.ValidateDiscoverCardDisplayed();
    }

    @Then("Validate Discover Offers")
    public void DiscoverOffersTC_ValidateDiscoverOffers() throws InterruptedException {
        DiscoverOffers.scrollToDiscoverAndWait();
    }

    @Then("Open Default Discover offer")
    public void DiscoverOffersTC_ValidateDiscoverOffersIsOpened() throws InterruptedException {
        DiscoverOffers.ValidateOfferIsOpened();
    }
    @Then("Validate Default Discover Offers is Opened")
    public void DiscoverOffersTC_ValidateOfferIsOpened() throws InterruptedException {
        DiscoverOffers.ValidateOfferIsOpened();
    }
    @Then("Validate Default Discover Offers is Opened in the external browser successfully")
    public void DiscoverOffersTC_ValidateOfferIsOpenedExternalBrowser() throws InterruptedException {
        DiscoverOffers.ValidateOfferIsOpenedExternalBrowser();
    }

    @Then("Validate Discover Offers View All CTA")
    public void DiscoverOffersTC_availabilityOfViewAllCTA() throws InterruptedException {
        DiscoverOffers.ValidateViewAllCTA();
    }

    @Then("Validate Discover Offers View All CTA is Working Fine")
    public void DiscoverOffersTC_ViewAllCTAIsWorking() {
        DiscoverOffers.ValidateViewAllCTAIsWorkingSuccessfully();
        DiscoverOffers.DiscoverOffersTC_XIcon();
    }

    @Then("Validate Discover Offers Accept CTA")
    public void DiscoverOffersTC_AcceptCTA() {
        DiscoverOffers.DiscoverOffersTC_AcceptCTA();
    }

    @Then("Validate Discover Offers declined an offer")
    public void DiscoverOffersTC_DeclinedCTA() {
        DiscoverOffers.DiscoverOffersTC_DeclinedCTA();
        DiscoverOffers.DiscoverOffersTC_XIcon();
    }

    @Then("I should validate Discover AOM Offers")
    public void iShouldValidateDiscoverAOMOffers() {
        DiscoverOffers.ValidateAomTileFunc();
    }

    @Then("I should validate Discover Chordiant offers")
    public void iShouldValidateDiscoverChordiantOffers() {
        DiscoverOffers.ValidateChordiantTileFunc();
    }
}

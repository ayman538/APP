package stepdefs.TC_Dashboard;

import core.Config;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.Dashboard.AOMDiscoverOffersV2.AOMDiscoverOffersV2_Abstract;
import pages.Dashboard.AOMDiscoverOffersV2.AOMDiscoverOffersV2_Logic_Android;
import pages.Dashboard.AOMDiscoverOffersV2.AOMDiscoverOffersV2_Logic_iOS;

public class AOMDiscoverOffersV2 {
    private AOMDiscoverOffersV2_Abstract offersV2_logic;
    public AOMDiscoverOffersV2 (Config config){
        if (config.isAndroid()) offersV2_logic = new AOMDiscoverOffersV2_Logic_Android();
        if (config.isIos()) offersV2_logic = new AOMDiscoverOffersV2_Logic_iOS();
    }

    @Given("AOM Offers Is Displayed")
    public void AOMOffersIsDisplayed() throws InterruptedException {
        offersV2_logic.AOMOffersIsDisplayed();
    }

    @Then("Default Offer Is Displayed")
    public void defaultOfferIsDisplayed() {
        offersV2_logic.defaultOfferIsDisplayed();
    }

    @Then("Chordiant Offers Is Displayed")
    public void choridantOffersIsDisplayed() throws InterruptedException{
        offersV2_logic.ChordiantOffersIsDisplayed();
    }

    @Then("Validate Discover AOM Offers View All CTA")
    public void validateDiscoverAOMOffersViewAllCTA() {
        offersV2_logic.ValidateViewAllCTA();
    }
}
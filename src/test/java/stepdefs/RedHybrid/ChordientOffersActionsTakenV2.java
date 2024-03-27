package stepdefs.RedHybrid;

import core.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.vi.Cho;
import pages.Dashboard.ChordientOffersActionsV2.ChordientOffersActionsAbstract;
import pages.Dashboard.ChordientOffersActionsV2.ChordientOffersActionsAndroid;
import pages.Dashboard.ChordientOffersActionsV2.ChordientOffersActionsIOS;
import pages.Dashboard.NewVOV.RemoveVOVAndroid;
import pages.Dashboard.NewVOV.RemoveVOVIOS;

public class ChordientOffersActionsTakenV2 {
    ChordientOffersActionsAbstract ChordientOffers;

    public ChordientOffersActionsTakenV2(Config config) {
        if (config.isAndroid()) ChordientOffers = new ChordientOffersActionsAndroid();
        if (config.isIos()) ChordientOffers = new ChordientOffersActionsIOS();
    }

    @And("scroll down to discover section then dismiss the first offer")
    public void dismissAnChordientOffer() {
        ChordientOffers.dismissAnOffer();
    }






    @And("scroll down to discover section then accept the first offer")
    public void acceptAnChordientOffer() throws InterruptedException {
        ChordientOffers.acceptAnOffer();

    }

    @Then("offer is displayed successfully")
    public void offerIsDisplayedSuccessfully() throws InterruptedException {
        ChordientOffers.offerIsDisplayed();
    }

    @When("user has a chordiant offer")
    public void userHasAChordiantOffer() {
        ChordientOffers.userHasChordientOffer();
    }
}


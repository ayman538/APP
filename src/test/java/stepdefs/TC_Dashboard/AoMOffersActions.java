package stepdefs.TC_Dashboard;

import core.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Dashboard.AOMDiscoverOffersV2.AOMDiscoverOffersV2_Abstract;
import pages.Dashboard.AOMDiscoverOffersV2.AOMDiscoverOffersV2_Logic_Android;
import pages.Dashboard.AOMDiscoverOffersV2.AOMDiscoverOffersV2_Logic_iOS;
import pages.Dashboard.AoMOffersActions.AoMOffersActionAbstract;
import pages.Dashboard.AoMOffersActions.AoMOffersActionAndroid;
import pages.Dashboard.AoMOffersActions.AoMOffersActionsIOS;

public class AoMOffersActions {

    private AoMOffersActionAbstract offersActions;

    public AoMOffersActions(Config config) {
        if (config.isAndroid()) offersActions = new AoMOffersActionAndroid();
        if (config.isIos()) offersActions = new AoMOffersActionsIOS();
    }

    @When("user has 3 or more offers")
    public void checkNoOfReturnedOffers() {
        offersActions.checkNoOfReturnedOffers();
    }

    @And("dismiss an offer")
    public void dismissOffer() throws InterruptedException {
        offersActions.dismissAnOffer();
    }

    @Then("offer is disappeared")
    public void offerDisappeared() throws InterruptedException {
        offersActions.offerIsDisappeared();
    }

    @And("accept an offer")
    public void acceptOffer() throws InterruptedException {
        offersActions.acceptAnOffer();
    }

    @Then("offer is displayed")
    public void offerIsDisplayed() throws InterruptedException {
        offersActions.offerIsDisplayed();
    }
}

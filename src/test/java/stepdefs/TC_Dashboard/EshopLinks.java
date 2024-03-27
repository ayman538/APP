package stepdefs.TC_Dashboard;

import core.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Dashboard.EshopLinks.EshopLinksAbstract;
import pages.Dashboard.EshopLinks.EshopLinksAndroid;
import pages.Dashboard.EshopLinks.EshopLinksIOS;


import java.io.IOException;

public class EshopLinks {

    EshopLinksAbstract  EshopLinks;

    public EshopLinks(Config config) throws IOException {
        if (config.isAndroid()) EshopLinks = new EshopLinksAndroid();
        if (config.isIos()) EshopLinks = new EshopLinksIOS();
    }
    @When("I Scroll Down to Eshop Links")
    public void scrollToEshopLinks() throws InterruptedException {
        EshopLinks.scrollToEshopLinks();


    }

    @Then("I Check only {int} links are displayed in Eshop Links")
    public void checkOnlyLinksAreDisplayedInEshopLinks(int count) {
        EshopLinks.assertOnlyFourLinksDisplayed(count);
    }

    @When("I Click on show more button from Eshop Links section")
    public void pressShowMoreButtonFromEshopLinksSection() {
        EshopLinks.EshopLinkShowMoreCTA();
    }

    @Then("I Check Eshop links ordering and texts of paym user")
    public void checkEshopLinksOrderingAndTexts() throws InterruptedException {
        EshopLinks.ValidateEshopLinksOrderAndText();
    }

    @When("I Click on show less button from Eshop Links section")
    public void pressShowLessButtonFromEshopLinksSection() {
        EshopLinks.EshopLinkShowLessCTA();
    }


    @Then("Validate Shop Links New Implementation")
    public void validateShopLinksNewImplementation() throws InterruptedException {
        EshopLinks.validateEachShopLinks();
    }
}

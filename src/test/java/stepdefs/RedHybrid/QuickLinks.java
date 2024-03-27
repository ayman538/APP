package stepdefs.RedHybrid;

import core.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import io.cucumber.java.en.When;
import pages.RedHybrid.QuickLinks.QuickLinks_Abstract;
import pages.RedHybrid.QuickLinks.QuickLinks_Android;
import pages.RedHybrid.QuickLinks.QuickLinks_IOS;

public class QuickLinks {
    private QuickLinks_Abstract quickLinks_Abstract;


    public QuickLinks(Config config) {
        if (config.isAndroid()) quickLinks_Abstract = new QuickLinks_Android();
        if (config.isIos()) quickLinks_Abstract = new QuickLinks_IOS();
    }

    @Given("I am a Red Hybrid user And Skip Login")
    public void iAmARedHybridUserAndSkipLogin() {
        quickLinks_Abstract.iAmARedHybridUserAndSkipLogin();
    }


    @Then("I expect to see a new section displayed under the discover carousel as Quick Links")
    public void iExpectToSeeANewSectionDisplayedUnderTheDiscoverCarouselAs() throws InterruptedException {
        quickLinks_Abstract.iExpectToSeeANewSectionDisplayedUnderTheDiscoverCarouselAs();
    }


    @And("I click on the Manage payments item")
    public void iClickOnTheManagePaymentsItem() throws InterruptedException {

        quickLinks_Abstract.iClickOnTheManagePaymentsItem();
    }

    @Then("I expect to be redirected to the payments flow")
    public void iExpectToBeRedirectedToThePaymentsFlow() {
        quickLinks_Abstract.iExpectToBeRedirectedToThePaymentsFlow();
    }

    @Given("I am a Red Hybrid user And Logged in")
    public void iAmARedHybridUserAndLoggedIn() throws InterruptedException {
        quickLinks_Abstract.iAmARedHybridUserAndLoggedIn();
    }

    @Then("change plan quick link text should comply with the UI on figma")
    public void changePlanQuickLinkTextShouldComplyWithTheUIOnFigma() {
        quickLinks_Abstract.changePlanQuickLinkUiIsRespected();
    }

    @Then("manage Payment quick link text should comply with the UI on figma {string}")
    public void managePaymentQuickLinkTextShouldComplyWithTheUIOnFigma( String Version) {
        quickLinks_Abstract.managePaymentQuickLinkUiIsRespected(Version);
    }

    @When("scroll to quick links")
    public void scrollToQuickLinks() {
        quickLinks_Abstract.scrollToQuickLinks();
    }

    @Then("I click on Renew Early from quick links")
    public void userClicksOnRenewEarlyFromQuickLinks() {
        quickLinks_Abstract.iClickOnRenewEarlyFromQuickLinks();
    }

    @Then("Renew plan Early quick link text should comply with the UI on figma")
    public void renewPlanEarlyQuickLinkTextShouldComplyWithTheUIOnFigma() {
        quickLinks_Abstract.renewEarlyQuickLinkUiIsRespected();
    }

    @When("I click on change plan from quick links without click on Payment overlay skip CTA")
    public void iClickOnChangePlanFromQuickLinksWithoutClickOnPaymentOverlaySkipCTA() {
        quickLinks_Abstract.changeNextPlanFromQuickLinksWithoutClickOnPaymentSkipCTA();

    }
}

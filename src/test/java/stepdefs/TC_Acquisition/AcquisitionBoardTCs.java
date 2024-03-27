package stepdefs.TC_Acquisition;


import core.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.SkipException;
import pages.AcquisitionBoard.AcquisitionBoardAbstract;
import pages.AcquisitionBoard.AcquisitionBoardAndroid;
import pages.AcquisitionBoard.AcquisitionBoardIOS;

import static core.Config.getPlatformType;


public class AcquisitionBoardTCs {

    AcquisitionBoardAbstract AcqHeader;

    public AcquisitionBoardTCs(Config config) {
        if (config.isAndroid()) AcqHeader = new AcquisitionBoardAndroid();
        if (config.isIos()) AcqHeader = new AcquisitionBoardIOS();
    }

    @Then("Validate Acquisition Header")
    public void checkAcquisitionHeader() {
        AcqHeader.checkAcquisitionHeader();
    }

    @Then("Validate Acquisition Tiles")
    public void checkAcquisitionTiles() {
        AcqHeader.checkAcquisitionTiles();
    }

    @Then("Validate More To Love Section")
    public void checkMoreToLoveSections() throws InterruptedException {
        AcqHeader.checkMoreToLoveSections();
    }

    @Then("Validate Very Me Section")
    public void checkVeryMeSections() {
        AcqHeader.checkVeryMeSections();
    }

    @Then("Validate Why Vodafone header")
    public void validateWhyVodafoneHeader() {
        AcqHeader.validateWhyVodafoneHeader();
    }

    @Then("Validate Footer Section")
    public void checkFooterSection() throws InterruptedException {
        AcqHeader.checkFooterSection();
    }

    @Given("Press Acquisition Board X Icon")
    public void acqXIconCTA() {
        AcqHeader.acqXIconCTA();
    }

    @Then("Validate Pressing X Icon")
    public void checkPressingXBtn() {
        AcqHeader.checkPressingXBtn();
    }

    @Then("Validate Pressing Native Back Button")
    public void checkPressingBackBtn() {
        if (getPlatformType().equals("Android")) {
            AcqHeader.checkPressingBackBtn();
        } else {
            throw new SkipException("Item not exist in the response");
        }
    }

    @When("I click on the background image")
    public void iClickOnTheBackgroundImage() {
        AcqHeader.ClickOnAcqBackgroundImage();

    }

    @Then("the app should be directed to the offerpage")
    public void theAppShouldBeDirectedToTheOfferpage() throws InterruptedException {
        AcqHeader.assertAcqOfferPageUrl();

    }

    @When("I click on the SeeOffer CTA")
    public void iClickOnTheSeeOfferCTA() {
        AcqHeader.ClickOnAcqBackgroundCTA();
    }

    @When("I validate New Acquisition Dashboard - Header")
    public void iValidateNewAcquisitionDashboardHeader() {
        AcqHeader.validateNewBasicDBHeader();
    }

    @And("I click on the copy Already a Vodafone Customer? Log in")
    public void iClickOnTheCopyAlreadyAVodafoneCustomerLogIn() {
        AcqHeader.clickOnAlreadyVodafoneCustomer();
        
    }


    @Then("Validate Discover Header")
    public void validateDiscoverHeader() {
        AcqHeader.CheckDiscoverHeader();
    }
    @Then(": I should validate why vodafone section")
    public void iShouldValidateWhyVodafoneSection() throws InterruptedException{
        AcqHeader.validateWhyVodafoneV2();
    }
    @Then("I should see a section titled Discover Vodafone with four mini cards carousel")
    public void iShouldSeeASectionTitledDiscoverVodafoneWithFourMiniCardsCarousel() {
        AcqHeader.validateDiscoverVodafone();
    }

    @Then("I click on PayMonthly")
    public void iClickOnPayMonthly()  {
        AcqHeader.validatePayMonthly();
    }
    @Then("I click on SIM only deals")
    public void iClickOnSIMOnlyDeals()  {
        AcqHeader.validateSimOnly();
    }

    @Then("I click on Broadband")
    public void iClickOnBroadband()  {
        AcqHeader.validateBroadbandCta();
    }


    @Then("I click on Trade-in Tool")
    public void iClickOnTradeInTool() {
        AcqHeader.validateTradeInTool();
    }


    @Then("I should validate The latest offers section")
    public void iShouldValidateTheLatestOffersSection() {
        AcqHeader.validateLatestOffers();
    }



}

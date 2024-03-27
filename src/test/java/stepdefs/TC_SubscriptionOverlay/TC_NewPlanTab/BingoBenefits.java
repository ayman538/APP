package stepdefs.TC_SubscriptionOverlay.TC_NewPlanTab;


import core.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SubsctionOverlay.NewPlanDesign.NewPlanDesignAbstract;
import pages.SubsctionOverlay.NewPlanDesign.NewPlanDesignAndroid;
import pages.SubsctionOverlay.NewPlanDesign.NewPlanDesignIOS;
import testdata.ReadResponse;

import java.util.HashMap;

import static core.Config.getSegment;
import static testdata.ReadResponse.CheckListContain;

public class BingoBenefits {

    HashMap<String, String> includesChevrons;
    NewPlanDesignAbstract newPlanDesignLogic;
    Boolean includesExist;

    public BingoBenefits(Config config){
        if (config.isAndroid()) newPlanDesignLogic = new NewPlanDesignAndroid();
        if (config.isIos()) newPlanDesignLogic = new NewPlanDesignIOS();
    }

    @Given("Init Bingo Benefits")
    public void setBeforeClass() {
        includesChevrons = ReadResponse.GetNewPlanIncludesChevrons();
    }

    @Given("New plan includes chevrons are displayed")
    public void ValidateNewPlanIncludesChevrons() {
        if (CheckListContain(includesChevrons, "Unlimited picture messages") &&
                (!ReadResponse.GetSegment().equals("PREPAY"))) {
            includesChevrons = newPlanDesignLogic.NewPlanIncludeChevronsResponse();
        }
    }

    @Then("Check includes section existence")
    public void ValidateIncludesExist() {
        if (CheckListContain(includesChevrons, "Unlimited picture messages") &&
                (!ReadResponse.GetSegment().equals("PREPAY"))) {
            includesExist = newPlanDesignLogic.getIncludesExist(false);
        }
    }

    @And("Validate elements displayed in includes section")
    public void ValidateIncludesElements() {
        if (CheckListContain(includesChevrons, "Unlimited picture messages") &&
                (!ReadResponse.GetSegment().equals("PREPAY"))) {
            newPlanDesignLogic.checkIncludesElements("Unlimited picture messages", includesExist, includesChevrons);
        }
    }

    @When("Assert ProductName and ProductTitle are displayed")
    public void TC02_ValidateUnlimitedPictureMessagesProductTitle() {
            newPlanDesignLogic.IncludesCTA("Unlimited Picture Messages");
    }

    @Then("Validate Product Title is displayed {string}")
//    @Then("Validate Unlimited Picture Messages Product Title is displayed")
    public void checkProductTitleIsDisplayed(String product) {
        newPlanDesignLogic.assertUnlimitedPictureMessagesTitle(product);
    }

    @Then("Validate description of Product is displayed {string}")
//    @Then("Validate Unlimited Picture Message Product {string}")
    public void TC03_ValidateUnlimitedPictureMessagesProductDescription(String Description) {
        newPlanDesignLogic.ValidateIncludesDisplayedDescription(Description);
//        newPlanDesignLogic.assertUnlimitedPictureMessagesDescription(Description);

    }

    @Then("Validate Unlimited Picture Message CTA")
    public void TC04_ValidateUnlimitedPictureMessagesCTA() {
            newPlanDesignLogic.ValidateIncludesCTA("Unlimited Picture Messages");
    }

    @Then("Assert That 50% off Card Is Displayed")
    public void assertThat50OffCardDisplayed() {
        newPlanDesignLogic.IncludesCTA("50% off Smartwatch Connectivity");

    }

    @Then("Assert That Unlimited Data Booster Screen Is Opened Successfully")
    public void assertScreenIsOpened() {
        newPlanDesignLogic.IncludesCTA("Unlimited Data Booster");
    }

    @Then("Assert That 51 Roam Free Destinations Product Is Displayed")
    public void assertThat51RoamFreeDestinationsProductDisplayed() {
        newPlanDesignLogic.IncludesCTA("Inclusive roaming in 51 European destinations");
      //  newPlanDesignLogic.assertThat51RoamFreeDestinationsDisplayed();
    }

    @Then("Assert That 81 Roam Free Destinations Product Is Displayed")
    public void assertThat81RoamFreeDestinationsProductDisplayed() {
        newPlanDesignLogic.assertThat81RoamFreeDestinationsDisplayed();
    }

    @When("I click on Phone Buy-Back Guarantee CTA of Iphone 14 loan")
    public void iClickOnPhoneBuyBackGuaranteeCTA() {
        newPlanDesignLogic.PhoneBuyBackGuaranteeCTA();
    }

    @Then("I will be redirected to Phone Buy-Back Guarantee eligibility screen")
    public void iWillBeRedirectedToPhoneBuyBackGuaranteeEligibilityScreen() {
        newPlanDesignLogic.PhoneBuyBackGuaranteeEligibilityScreen();
    }

    @Then("I validate Buy-Back Guarantee is displayed in includes section with state Available soon")
    public void iValidateBuyBackGuaranteeIsDisplayedInIncludesSectionWithStateAvailableSoon() {
        newPlanDesignLogic.PhoneBBGEntryPointLabel();
    }

    @Then("I validate Lifetime warranty entry point in includes section")
    public void iValidateLifetimeWarrantyEntryPointInIncludesSection() {
        newPlanDesignLogic.validateLifetimeWarrantyCTA();
    }

    @When("I click on Lifetime warranty entry point")
    public void iClickOnLifetimeWarrantyEntryPoint() {
        newPlanDesignLogic.clickonLifetimeWarrantyCTA();
    }

    @Then("I will be directed to Lifetime Warranty screen")
    public void iWillBeDirectedToLifetimeWarrantyScreen() {
        newPlanDesignLogic.LifetimeWarrantyScreen();
    }

    @When("I click on Find out more CTA")
    public void iClickOnFindOutMoreCTA() {
        newPlanDesignLogic.FindOutMoreCTA();
    }

    @Then("I will be directed to Lifetime Promise Webview")
    public void iWillBeDirectedToLifetimePromiseWebview() {
        newPlanDesignLogic.LifetimePromiseWebView();
    }

    @And("I click on Total Care Warranty CTA")
    public void iClickOnTotalCareWarrantyCTA() {
        newPlanDesignLogic.TotalCareWarrantyCTA();
    }

    @And("I validate Total Care Warranty screen is displayed")
    public void iValidateTotalCareWarrantyScreenIsDisplayed() {
        newPlanDesignLogic.TotalCareWarrantyScreen();
    }

    @When("I click on Phone Buy-Back Guarantee CTA of iPhone 15 loan")
    public void iClickOnPhoneBuyBackGuaranteeCTAOfIPhoneLoan() {
        newPlanDesignLogic.PBBGiPhone15CTA();
    }

    @Then("I validate Buy-Back Guarantee iPhone 15 Entry Point in includes section with state Available soon")
    public void iValidateBuyBackGuaranteeIPhoneEntryPointInIncludesSectionWithStateAvailableSoon() {
        newPlanDesignLogic.validatePBBGiPhone15EntryPoint();
    }

    @Then("I will be redirected to Phone Buy-Back Guarantee of iPhone 15 eligibility screen")
    public void iWillBeRedirectedToPhoneBuyBackGuaranteeOfIPhoneEligibilityScreen() {
        newPlanDesignLogic.PBBGiPhone15EligibilityScreen();
    }
}
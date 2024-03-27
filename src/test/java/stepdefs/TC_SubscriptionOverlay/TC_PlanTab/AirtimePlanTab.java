package stepdefs.TC_SubscriptionOverlay.TC_PlanTab;

import core.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SubsctionOverlay.AirtimePlanTab.AirtimePlanAbstract;
import pages.SubsctionOverlay.AirtimePlanTab.AirtimePlanAndroid;
import pages.SubsctionOverlay.AirtimePlanTab.AirtimePlanIOS;
import pages.SubsctionOverlay.DevicePlanTab.DevicePlanAndroid;
import pages.SubsctionOverlay.DevicePlanTab.DevicePlanIOS;

public class AirtimePlanTab {

    AirtimePlanAbstract airtimePlanLogic;

    public AirtimePlanTab(Config config){
        if(config.isAndroid()) airtimePlanLogic = new AirtimePlanAndroid();
        if(config.isIos()) airtimePlanLogic = new AirtimePlanIOS();
    }

    @Given("Navigate to Airtime plan tab")
    public void navigateToAirtimePlanTab(){
        airtimePlanLogic.NavigateToAirtimePlanTab();
    }

    @When("User clicks on What is an Airtime Plan? link")
    public void userClicksOnWhatIsAnAirtimePlanLink() {
        airtimePlanLogic.WhatIsAirtimePlanCTA();
    }

    @And("What is a Airtime Plan? overlay should be displayed")
    public void whatIsAAirtimePlanOverlayShouldBeDislayed() {
        airtimePlanLogic.WhatIsAirtimePlanOverlay();
    }

    @And("User clicks on Ok, thanks CTA")
    public void userClicksOnOkThanksCTA() {
       airtimePlanLogic.OkThanksCTA();
    }

    @Then("User should be navigated back to Airtime Plan tab")
    public void userShouldBeNavigatedBackToAirtimePlanTab() {
        airtimePlanLogic.AirtimePlanTab();
    }

    @And("What is a Airtime Plan? new copy overlay screen should be displayed")
    public void whatIsAAirtimePlanNewCopyOverlayScreenShouldBeDisplayed() {
        airtimePlanLogic.WhatIsAirtimePlanNewCopyOverlay();
    }
}

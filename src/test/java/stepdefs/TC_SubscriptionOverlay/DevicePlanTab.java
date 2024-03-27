package stepdefs.TC_SubscriptionOverlay;

import core.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SubsctionOverlay.DevicePlanTab.DevicePlanAbstract;
import pages.SubsctionOverlay.DevicePlanTab.DevicePlanAndroid;
import pages.SubsctionOverlay.DevicePlanTab.DevicePlanIOS;
import pages.SubsctionOverlay.DevicePlanTab.DevicePlanLogic;

import static core.Hooks.testAfterLastScenario;

public class DevicePlanTab {

    DevicePlanAbstract devicePlanLogic;

    public DevicePlanTab(Config config){
        if(config.isAndroid()) devicePlanLogic = new DevicePlanAndroid();
        if(config.isIos()) devicePlanLogic = new DevicePlanIOS();
    }

    @Given("Navigate to Device plan tab")
    public void navigateToDevicePlanTab(){
        devicePlanLogic.navigateToDevicePlanTab();
    }

    @Then("check Device plan card")
    public void checkDevicePlanCard(){
        devicePlanLogic.checkDevicePlanCard();
    }

    @Then("Check Device plan CTAs")
    public void checkDevicePlanCTAs(){
        devicePlanLogic.checkDevicePlanCTAs();
    }

    @And("Check Make a Payment CTA has different color")
    public void checkMakePaymentCTAColour(){
        devicePlanLogic.checkMakePaymentCTAColour();
    }

    @Then("Check Battery Refresh in Includes section")
    public void checkBatteryRefreshAsIncludes(){
        devicePlanLogic.checkBatteryRefreshAsIncludes();
    }

    @And("Check Battery Refresh chevron")
    public void checkBatteryRefreshLink(){
        devicePlanLogic.checkBatteryRefreshLink();
    }

    @Then("Check Total Care Warranty in Includes section")
    public void checkTotalCareWarrantyAsIncludes(){
        devicePlanLogic.checkTotalCareWarrantyAsIncludes();
    }

    @And("Check Total Care Warranty chevron")
    public void checkTotalCareWarrantyLink(){
        devicePlanLogic.checkTotalCareWarrantyLink();
    }

    @Then("Check Manage Device Plan CTA")
    public void checkManageDevicePlanCTA() {
        devicePlanLogic.checkManageDevicePlanCTA();
    }

    @When("User clicks on 'What is a Device Plan?' link")
    public void WhatIsDevicePlanCTA(){
        devicePlanLogic.WhatIsDevicePlanCTA();
    }

    @And("What is a Device Plan? overlay should be displayed")
    public void whatIsADevicePlanOverlayShouldBeDislayed() {
        devicePlanLogic.WhatIsDevicePlanOverlay();
    }

    @Then("User should be navigated back to Device Plan tab")
    public void userShouldBeNavigatedBackToDevicePlanTab() {
        devicePlanLogic.DevicePlanTab();
    }

    @Then("Check New Device Plan Tray List")
    public void checkNewDevicePlanTrayList() {
        devicePlanLogic.checkTrayList();}

    @Then("I Check Manage Device Plan CTA")
    public void iCheckManageDevicePlanCTA() { devicePlanLogic.checkManageDevicePlanCTA();
    }

    @Then("I Check New Device Plan Tray List")
    public void iCheckNewDevicePlanTrayList() { devicePlanLogic.checkTrayList();
    }

    @Then("I Check {string} URL and description")
    public void iCheckManagePaymentMethodURLAndDescription(String CTAName) { devicePlanLogic.checkURL(CTAName);
    }


    @And("User clicks on Ok for device plan, thanks CTA")
    public void userClicksOnOkForDevicePlanThanksCTA() {
    }

    @And("What is a Device Plan? new copy overlay screen should be displayed")
    public void whatIsADevicePlanNewCopyOverlayScreenShouldBeDisplayed() {
    }

    @And("I Click on Cancel button")
    public void iClickOnCancelButton() {
        devicePlanLogic.clickOnCancelButton();
    }
}


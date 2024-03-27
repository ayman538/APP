package stepdefs.NativeControlsAndLimits;

import core.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.response.NativeControlsResponseModel;
import pages.NativeControlsAndLimits.NativeControlsAndLimitsAbstract;
import pages.NativeControlsAndLimits.NativeControlsAndLimitsLogicAndroid;
import pages.NativeControlsAndLimits.NativeControlsAndLimitsLogiciOS;

import java.text.ParseException;

public class NativeControlsAndLimitsStepDef {
    NativeControlsAndLimitsAbstract nativeControlsAndLimitsAbstract;


    public NativeControlsAndLimitsStepDef (Config config){
        if (config.isAndroid()){
            nativeControlsAndLimitsAbstract = new NativeControlsAndLimitsLogicAndroid();
        }
        if (config.isIos()){
            nativeControlsAndLimitsAbstract = new NativeControlsAndLimitsLogiciOS();
        }
    }

    @Then("I should see the Manage Control And Limits tile")
    public void iShouldSeeTheManageControlAndLimitsTile() {
        nativeControlsAndLimitsAbstract.validateControlsAndLimitsTileExistence();
    }

    @And("I click on the Manage Control And Limits tile")
    public void iClickOnTheManageControlAndLimitsTile() {
        nativeControlsAndLimitsAbstract.clickOnAddControlsAndLimitsTile();
    }

    @Then("I should be navigated to the Controls tab")
    public void iShouldBeNavigatedToTheControlsTab() {
        nativeControlsAndLimitsAbstract.validateControlsTabIsOpened();
    }

    @Then("I should see active Controls Details")
    public void iShouldSeeActiveExtrasDetails(){
        nativeControlsAndLimitsAbstract.validateActiveControlsCardContent();
    }

    @Then("I should see description of active Controls after clicking Find Out CTA")
    public void iShouldSeeDescriptionOfActiveExtra(){
        nativeControlsAndLimitsAbstract.validateClickingOnFindOutMoreCTAForControls();
    }

    @Then("I should see Active Controls that I have")
    public void iShouldSeeActiveExtrasOrderedWithLatestOnTop() throws ParseException {
        nativeControlsAndLimitsAbstract.validateActiveControls();
    }

    @Then("I should see {string} CTA for control under Active Controls Card")
    public void iShouldSeeCTAForControlUnderActiveControlsCard(String buttonName) {
        nativeControlsAndLimitsAbstract.validateTurnOffControlCTA(buttonName);
    }
    
    @And("I click on {string} CTA on control")
    public void iClickOnCTAOnControl(String buttonName) {
        nativeControlsAndLimitsAbstract.clickOnTurnOffControlCTA(buttonName);
    }

    @Then("I should see Spend Manager control with {string} CTA")
    public void iShouldSeeSpendManagerControlWithCTA(String buttonName) {
        nativeControlsAndLimitsAbstract.validateTurnOffControlCTA(buttonName);
    }

    @And("I should find the dimmed {string} CTA")
    public void iShouldFindTheDimmedCTA(String buttonName) {
        nativeControlsAndLimitsAbstract.validateOnTurnOffCTAStatus(buttonName);
    }

    @When("I click on the Controls tab")
    public void iClickOnTheControlsTab() {
        nativeControlsAndLimitsAbstract.clickOnControlsTabFromAdjacentTabs();
    }
}

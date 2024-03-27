package stepdefs.OnePlatform_SpeedCheckerHistory;

import core.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.OnePlatform_SpeedCheckerHistory.SpeedCheckerHistoryAbstractLogic;
import pages.OnePlatform_SpeedCheckerHistory.SpeedCheckerHistoryAndroidLogic;
import pages.OnePlatform_SpeedCheckerHistory.SpeedCheckerHistoryiOSLogic;

public class SpeedCheckerHistory {

    SpeedCheckerHistoryAbstractLogic SpeedCheckerHistory;

    public  SpeedCheckerHistory(Config config){
        if(config.isAndroid()) SpeedCheckerHistory = new SpeedCheckerHistoryAndroidLogic();
        if(config.isIos()) SpeedCheckerHistory = new SpeedCheckerHistoryiOSLogic();
    }


    @Given("I click on speedHistory tab")
    public void IClickOnSpeedHistoryTab() {
        SpeedCheckerHistory.ClickOnSpeedHistoryTab();

    }


    @Then("I shouldn't see any speed test result")
    public void IShouldnTSeeAnySpeedTestResult() {

        SpeedCheckerHistory.ValidateNospeedResultCardIsDisplayed();
    }




    @When("Click on Delete CTA button")
    public void clickOnDeleteCTAButton(){
        SpeedCheckerHistory.ClickOnDeletePreviousTestsCTA();
    }
    @And("Validate deleted appeared overlay")
    public void validateDeletedAppearedOverlay(){
        SpeedCheckerHistory.ValiateDeleteOverlay();
    }
    @Then("Click on Cancel CTA on the appeared deleted overlay")
    public void ClickOnCancelCTAOnTheAppearedDeletedOverlay(){
        SpeedCheckerHistory.ClickOnCancelCTAOnDeletedOverlay();
    }

    @And("Click on Check data and WiFi Speed")
    public void clickOnCheckDataAndWiFiSpeed() {
        SpeedCheckerHistory.clickOnCheckDataAndWiFiSpeed();

    }


    @Then("Click on Confirm CTA on the appeared deleted overlay")
    public void ClickOnConfirmCTAOnTheAppearedDeletedOverlay(){
        SpeedCheckerHistory.ClickOnConfirmCTAOnDeletedOverlay();
    }

    @Given("I click on Test network speed CTA")
    public void IClickOnTestNetworkSpeedCTA() {
        SpeedCheckerHistory.ClickOnStartTest();
    }

    @Given("Speed History Card should be displayed")
    public void SpeedHistoryCardShouldBeDisplayed() {
        SpeedCheckerHistory.StartTestAndValidateSpeedHistoryScreenIsDisplayed();
    }

    @When("I check speed history screen I shouldn't find any test history")
    public void iCheckSpeedHistoryScreenIShouldnTFindAnyTestHistory() {
        SpeedCheckerHistory.CheckToMakeSureThatThereIsNoSpeedTestHistory();
    }

    @And("I see the test done successfully")
    public void ISeeTheTestDoneSuccessfully() {
        SpeedCheckerHistory.ValidateThatTestDoneSuccessfully();
    }


    @Then("I should see speed test result card")
    public void IShouldSeeSpeedTestResultCard() {
        SpeedCheckerHistory.ValidateSpeedHistoryScreenIsDisplayed();
    }
}

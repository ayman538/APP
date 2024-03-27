package stepdefs.TC_Dashboard;

import core.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.Dashboard.ControlTiles.ControlTilesAbstract;
import pages.Dashboard.ControlTiles.ControlTilesAndroid;
import pages.Dashboard.ControlTiles.ControlTilesIOS;

public class ControlTiles {

    ControlTilesAbstract controlTilesLogic;

    public ControlTiles( Config config){
        if (config.isAndroid()) controlTilesLogic = new ControlTilesAndroid();
        if (config.isIos()) controlTilesLogic = new ControlTilesIOS();
    }

    @Given("Init Control tiles")
    public void beforeClass() {
            controlTilesLogic.SetBeforeClass();
    }

    @Then("Validate First Control Tile Text for PAYM SMB SOLETRADER REDHYBRID")
    public void TC01_ControlTilesTC_ValidateControlTileTextFor_PAYM_SMB_SOLETRADER_REDHYBRID() throws Exception {
        controlTilesLogic.ValidatePrimaryControlTileText();
    }

    /*
    @Then("Validate First Control Tile Text for Red Leader")
    public void TC02_ControlTilesTC_ValidateControlTileTextFor_Red_Leader(){
        controlTilesLogic.ValidateFirstControlTileText();
    }



    @Then("Validate First Control Tile Text for MBB")
    public void TC03_ControlTilesTC_ValidateControlTileTextFor_PAYM_MBB(){
        controlTilesLogic.ValidateFirstControlTileText();
    }

    @Then("Validate First Control Tile Text for BVB")
    public void TC04_ControlTilesTC_ValidateControlTileTextFor_PAYG1_BVB(){
        controlTilesLogic.ValidateFirstControlTileText();
    }


     */
    @Then("Validate Second Control Tile Text  for PAYM SMB SOLETRADER REDHYBRID")
    public void TC05_ControlTilesTC_ValidateSecondControlTileText() throws Exception {
        controlTilesLogic.ValidateSecondaryControlTileText();
    }

    @Then("Validate Plan tab appears after clicking primary control tile")
    public void TC06_ControlTilesTC_ValidateEntryPointForFirstControlTile() throws Exception {
        controlTilesLogic.ValidatePrimaryControlTileCTA();
    }

    @Then("Validate Extras or Group data tab appears after clicking secondary control tile")
    public void TC07_ControlTilesTC_ValidateEntryPointForSecondControlTile() throws Exception {
        controlTilesLogic.ValidateSecondaryControlTileCTA();
    }

    @Then("I validate on Eligibility Text in plan tile")
    public void ValidateOnEligibilityText()
    {
        controlTilesLogic.VerifyYourPlanTile();
    }


    @Then("I validate dashboard tiles For Bingo User")
    public void ValidateDashboardTilesForBingoUser() {
        controlTilesLogic.ValidateTilesForBingoUser();
    }

    @And("I click on device plan tile")
    public void iClickOnDevicePlanTile() {
        controlTilesLogic.clickonDevicePlanTile();
    }

    @Then("I validate device plan sub overlay screen is displayed")
    public void iNavigateToDevicePlanSuboverlayScreen() {
        controlTilesLogic.validateDevicePlanSuboverlayScreen();
    }


    @Then("I Click on X icon of Nudge")
    public void iClickOnXIconOfNudge() {
        controlTilesLogic.ClickOnNudgeXIcon();
    }

    @Then("I click on Nudge upgrade now CTA")
    public void iClickOnNudgeUpgradeNowCTA() {
        controlTilesLogic.ClickOnUpgradeNowCTA();
    }


    @And("I should Validate CRO experience")
    public void iShouldValidateCROExperience() {
        controlTilesLogic.ValidateCroExperience();
    }

    @And("I click on Manage Controls & Extras tile")
    public void iClickOnManageControlsExtrasTile() {
        controlTilesLogic.clickonManageControlsAndExtrasTile();}

    @Then("I should be navigated to the Extras tab")
    public void iShouldBeNavigatedToTheExtrasTab() {
        controlTilesLogic.ExtrasTab();
    }

}

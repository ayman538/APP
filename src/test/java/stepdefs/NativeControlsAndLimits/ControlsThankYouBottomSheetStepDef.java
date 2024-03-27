package stepdefs.NativeControlsAndLimits;

import core.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.NativeControlsAndLimits.ThankYouTurnOnControls.ControlThankYouBottomSheetAbstract;
import pages.NativeControlsAndLimits.ThankYouTurnOnControls.ControlThankYouBottomSheetAndroid;
import pages.NativeControlsAndLimits.ThankYouTurnOnControls.ControlThankYouBottomSheetIOS;
import pages.NativeControlsAndLimits.ControlsCategoryBottomSheet.ControlsCategoryBottomSheetAbstract;
import pages.NativeControlsAndLimits.ControlsCategoryBottomSheet.ControlsCategoryBottomSheetAndroid;
import pages.NativeControlsAndLimits.ControlsCategoryBottomSheet.ControlsCategoryBottomSheetIOS;
import pages.NativeControlsAndLimits.ControlsConfirmBottomSheet.ControlsConfirmBottomSheetAbstract;
import pages.NativeControlsAndLimits.ControlsConfirmBottomSheet.ControlsConfirmBottomSheetAndroid;
import pages.NativeControlsAndLimits.ControlsConfirmBottomSheet.ControlsConfirmBottomSheetIOS;

public class ControlsThankYouBottomSheetStepDef {
    ControlThankYouBottomSheetAbstract controlThankYouBottomSheetAbstract;
    ControlsConfirmBottomSheetAbstract controlsConfirmBottomSheetAbstract;
    ControlsCategoryBottomSheetAbstract controlsCategoryBottomSheetAbstract;

    public ControlsThankYouBottomSheetStepDef(Config config){
        if(config.isAndroid()){
            controlsCategoryBottomSheetAbstract = new ControlsCategoryBottomSheetAndroid();
            controlThankYouBottomSheetAbstract = new ControlThankYouBottomSheetAndroid();
            controlsConfirmBottomSheetAbstract = new ControlsConfirmBottomSheetAndroid();
        }
        if(config.isIos()){
            controlsCategoryBottomSheetAbstract = new ControlsCategoryBottomSheetIOS();
            controlThankYouBottomSheetAbstract = new ControlThankYouBottomSheetIOS();
            controlsConfirmBottomSheetAbstract = new ControlsConfirmBottomSheetIOS();
        }
    }

    @When("I add any control")
    public void AddAnyControl() throws Exception {
        try{
            controlsConfirmBottomSheetAbstract.navigateToZeroLvlControlConfirmation();
        } catch (Exception e) {
            controlsCategoryBottomSheetAbstract.navigateToFirstLevelControlSubCategory();
            controlsConfirmBottomSheetAbstract.navigateToFirstLvlControlConfirmation();
        }
    }

    @Then("I should see Controls thank you bottom sheet")
    public void CheckControlThankYouBottomSheet(){
        controlThankYouBottomSheetAbstract.CheckControlThankYouBottomSheet();
    }

    @And("I should see the added control reflected with pending status")
    public void CheckAddedControlReflectedPending(){
        controlThankYouBottomSheetAbstract.CheckAddedControlReflectedPending();
    }

    @When("I click on Turn On CTA")
    public void clickOnTurnOnCTA(){
        controlThankYouBottomSheetAbstract.clickOnTurnOnCTA();
    }
}

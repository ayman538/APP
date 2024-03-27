package stepdefs.NativeControlsAndLimits;

import core.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.NativeControlsAndLimits.ControlsConfirmBottomSheet.ControlsConfirmBottomSheetAbstract;
import pages.NativeControlsAndLimits.ControlsConfirmBottomSheet.ControlsConfirmBottomSheetAndroid;
import pages.NativeControlsAndLimits.ControlsConfirmBottomSheet.ControlsConfirmBottomSheetIOS;

public class ControlsConfirmBottomSheetStepDef {

    ControlsConfirmBottomSheetAbstract controlsConfirmBottomSheetAbstract;

    public ControlsConfirmBottomSheetStepDef(Config config){
        if(config.isAndroid()) controlsConfirmBottomSheetAbstract = new ControlsConfirmBottomSheetAndroid();
        if(config.isIos()) controlsConfirmBottomSheetAbstract = new ControlsConfirmBottomSheetIOS();
    }

    @Then("I navigate and check zero level confirm bottom sheet")
    public void goToAndCheckZeroLvlConfirmationControl() throws Exception {
        controlsConfirmBottomSheetAbstract.goToAndCheckZeroLvlConfirmationControl();
    }

    @Then("I navigate and check first level confirm bottom sheet")
    public void checkFirstControlConfirmation(){
        controlsConfirmBottomSheetAbstract.checkFirstControlConfirmation();
    }

    @Then("I navigate and check second level confirm bottom sheet")
    public void checkSecondControlConfirmation(){
        controlsConfirmBottomSheetAbstract.checkSecondControlConfirmation();
    }

    @And("I should navigate to {string} confirmation bottom sheet")
    public void iShouldNavigateToConfirmationBottomSheet(String buttonName) {
        controlsConfirmBottomSheetAbstract.validateConfirmTurnOffControlTrayIsOpened(buttonName);
    }

    @And("I click on X CTA for confirmation bottom sheet")
    public void iClickOnXCTAForConfirmationBottomSheet() {
        controlsConfirmBottomSheetAbstract.clickOnXCTAOnTurnOffConfirmationTray();
    }

    @And("I click on Turn off CTA from confirmation bottom sheet")
    public void iClickOnTurnOffCTAFromConfirmationBottomSheet() {
        controlsConfirmBottomSheetAbstract.clickOnTurnOffCTAOnConfirmationTray();
    }
}

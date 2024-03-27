package stepdefs.NativeControlsAndLimits;

import com.fasterxml.jackson.core.JsonProcessingException;
import core.Config;
import io.cucumber.java.en.And;
import pages.NativeControlsAndLimits.ThankYouTurnOffControls.ThankYouTurnOffControlsAbstract;
import pages.NativeControlsAndLimits.ThankYouTurnOffControls.ThankYouTurnOffControlsLogicAndroid;
import pages.NativeControlsAndLimits.ThankYouTurnOffControls.ThankYouTurnOffControlsLogicIOS;

public class ThankYouTurnOffControlsStepDef {

    ThankYouTurnOffControlsAbstract thankYouTurnOffControlsAbstract;

    public ThankYouTurnOffControlsStepDef(Config config) throws JsonProcessingException {
        if (config.isAndroid())
            thankYouTurnOffControlsAbstract = new ThankYouTurnOffControlsLogicAndroid();
        else
            thankYouTurnOffControlsAbstract = new ThankYouTurnOffControlsLogicIOS();
    }

    @And("I should navigate to Turn off thank you bottom sheet")
    public void iShouldNavigateToTurnOffThankYouBottomSheet() {
        thankYouTurnOffControlsAbstract.validateThankYouTurnOffControlsTray();
    }

    @And("I click on X CTA from thank you bottom sheet")
    public void iClickOnXCTAFromThankYouBottomSheet() {
        thankYouTurnOffControlsAbstract.clickOnThankYouTurnOffControlXCTA();
    }

    @And("I click on Continue CTA from thank you bottom sheet")
    public void iClickOnContinueCTAFromThankYouBottomSheet() {

    }
}

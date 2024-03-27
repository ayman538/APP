package stepdefs.NativeExtras;

import com.fasterxml.jackson.core.JsonProcessingException;
import core.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.NativeExtras.ThankYouExtraTray.ThankYouExtraTrayAbstract;
import pages.NativeExtras.ThankYouExtraTray.ThankYouExtraTrayLogicAndroid;
import pages.NativeExtras.ThankYouExtraTray.ThankYouExtraTrayLogicIOS;

public class ThankYouExtrTrayaStepDef {

    ThankYouExtraTrayAbstract thankYouExtraTrayAbstract;

    public ThankYouExtrTrayaStepDef(Config config)  {
        if (config.isAndroid())
            thankYouExtraTrayAbstract = new ThankYouExtraTrayLogicAndroid();
        else
            thankYouExtraTrayAbstract = new ThankYouExtraTrayLogicIOS();
    }


    @When("I Click on X CTA on Thank you bottom sheet")
    public void iClickOnXCTAOnThankYouBottomSheet() {
        thankYouExtraTrayAbstract.clickOnThankYouExtraTrayXCTA();
    }

//    @Then("I should be navigated to Opt Out Thank You Tray")
//    public void iShouldBeNavigatedToOptOutThankYouTray() {
//        thankYouExtraTrayAbstract.validateThankYouOptingOutExtraTrayIsOpened();
//    }

    @Then("I should see Opt Out Thank You Tray Content")
    public void iShouldSeeOptOutThankYouTrayContent() {
        thankYouExtraTrayAbstract.validateThankYouOptingOutExtraTrayContent();
    }

    @And("I click on X CTA for Opting Thank You Tray")
    public void iClickOnXCTAForOptingThankYouTray() {
        thankYouExtraTrayAbstract.clickOnThankYouExtraTrayXCTA();
    }


    @Then("I should see Re-Opt In Thank You Tray Content")
    public void iShouldSeeReOptInThankYouTrayContent() {
        thankYouExtraTrayAbstract.validateThankYouReOptingInTrayContent();
    }

    @Then("I should see the Thank you bottom sheet details")
    public void iShouldSeeTheThankYouBottomSheetDetails() {
        thankYouExtraTrayAbstract.validateThankYouBottomSheetContent();
    }
}

package stepdefs.RedHybrid;

import core.Config;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.RedHybrid.Dashboard_ExtrasList_overlay.Dashboard_ExtrasList_Overlay_Abstract;
import pages.RedHybrid.Dashboard_ExtrasList_overlay.Dashboard_ExtrasList_Overlay_Android_Logic;
import pages.RedHybrid.Dashboard_ExtrasList_overlay.Dashboard_ExtrasList_Overlay_Ios_Logic;

public class Dashboard_ExtrasList_Overlay {
    Dashboard_ExtrasList_Overlay_Abstract extrasListAbstract;

    public Dashboard_ExtrasList_Overlay(Config config) {
        if (config.isAndroid()) {
            extrasListAbstract = new Dashboard_ExtrasList_Overlay_Android_Logic();
        }
        if (config.isIos()) {
            extrasListAbstract = new Dashboard_ExtrasList_Overlay_Ios_Logic();
        }
    }


    @When("I navigate to add extras overlay")
    public void userClicksOnAddExtrasTile() throws InterruptedException {
        extrasListAbstract.addExtrasTileClick();

    }

    @Then("I should be navigated to addExtras overlay")
    public void addExtrasOverlayShouldAppearToTheUser() {
        extrasListAbstract.addExtrasOverlayAppears();
    }

    @Then("addExtras UI should comply with the response of the MVAX API listExtras")
    public void addextrasUIShouldComplyWithTheResponseOfTheMVAXAPIListExtrasAndTheResponseCodeShouldBe() {
        extrasListAbstract.addExtrasOverlayUIValidation();

    }


}

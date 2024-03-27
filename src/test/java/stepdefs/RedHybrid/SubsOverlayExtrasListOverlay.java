package stepdefs.RedHybrid;


import core.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.RedHybrid.Dashboard_ExtrasList_overlay.Dashboard_ExtrasList_Overlay_Android_Logic;
import pages.RedHybrid.Dashboard_ExtrasList_overlay.Dashboard_ExtrasList_Overlay_Ios_Logic;
import pages.RedHybrid.SubsOverlayExtrasListOverlay.SubsOverlayExtrasListOverlayAbstract;
import pages.RedHybrid.SubsOverlayExtrasListOverlay.SubsOverlayExtrasListOverlay_Android;
import pages.RedHybrid.SubsOverlayExtrasListOverlay.SubsOverlayExtrasListOverlay_IOS;


public class SubsOverlayExtrasListOverlay {

    SubsOverlayExtrasListOverlayAbstract subsOverlayExtrasListOverlayAbstract;

    public SubsOverlayExtrasListOverlay(Config config) {
        if (config.isAndroid()) {
            subsOverlayExtrasListOverlayAbstract = new SubsOverlayExtrasListOverlay_Android();
        }
        if (config.isIos()) {
            subsOverlayExtrasListOverlayAbstract = new SubsOverlayExtrasListOverlay_IOS();
        }
    }


    @And("click on Buy Extras")
    public void clickOnBuyExtras() {
        subsOverlayExtrasListOverlayAbstract.clickOnBuyExtras();
    }


    @And("user click on Extras Tab from subsOverlay")
    public void userClickOnExtrasTabFromSubsOverlay() {

        subsOverlayExtrasListOverlayAbstract.clickOnSubsOverlayExtrasTab();
    }

    @And("validate that Extras Tab opens")
    public void validateThatExtrasTabOpens() {

        subsOverlayExtrasListOverlayAbstract.ValidateThatExtrasTabOpens();
    }

    @And("validate that Add Extras Overlay Opens")
    public void validateThatAddExtrasOverlayOpens() {
        subsOverlayExtrasListOverlayAbstract.ValidateThatAddExtrasOverlayOpens();
    }
}

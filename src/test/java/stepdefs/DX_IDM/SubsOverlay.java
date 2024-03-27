package stepdefs.DX_IDM;

import core.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DX_IDM.SubsOverlay.DX_IDM_SubsOverlay_Abstract;
import pages.DX_IDM.SubsOverlay.DX_IDM_SubsOverlay_Android;
import pages.DX_IDM.SubsOverlay.DX_IDM_SubsOverlay_IOS;

import java.io.IOException;

public class SubsOverlay {

    DX_IDM_SubsOverlay_Abstract DX_IDM_SubsOverlay;

    public SubsOverlay(Config config) throws IOException {
        if (config.isAndroid()) DX_IDM_SubsOverlay = new DX_IDM_SubsOverlay_Android();
        if (config.isIos()) DX_IDM_SubsOverlay = new DX_IDM_SubsOverlay_IOS();
    }


    @Then("A Specific Overlay should be displayed for VOXI users")
    public void aSpecificOverlayShouldBeDisplayedForVOXIUsers() {
        DX_IDM_SubsOverlay.assertSpecificSubsOverlayDisplayedAfterAcquisitionScreen();
    }

    @Then("visit VOXI CTA should be displayed")
    public void visitVOXICTAShouldBeDisplayed() {
        DX_IDM_SubsOverlay.assertVOXIVisitCTADisplayed();
    }

    @When("Click on VOXI CTA")
    public void clickOnVOXICTA() {
        DX_IDM_SubsOverlay.clickOnVOXIVisitCTA();
    }

    @Then("Directs me to the VOXI users web portal")
    public void directsMeToTheVOXIUsersWebPortal() {
        DX_IDM_SubsOverlay.validateVOXIVisitCTA();
    }

    @When("Click on back button on web portal")
    public void clickOnXIconOnWebPortal() {
        DX_IDM_SubsOverlay.pressPhysicalBackonWebPortal();
    }

    @Then("takes me back to VOXI OverLay dashboard")
    public void takesMeBackToVOXIOverLayDashboard() {
        DX_IDM_SubsOverlay.assertSpecificSubsOverlayDisplayedAfterAcquisitionScreen();
    }



    @Then("A Specific Overlay should be displayed for Unknown users")
    public void aSpecificOverlayShouldBeDisplayedForUnknownUsers() {
        DX_IDM_SubsOverlay.assertSpecificSubsOverlayDisplayedAfterAcquisitionScreen();
    }


    @Then("Close ICon should be displayed")
    public void closeIConShouldBeDisplayed() {
        DX_IDM_SubsOverlay.assertSubsOverlayXICONDisplayed();
    }

    @When("Click on Close Icon")
    public void clickOnCloseIcon() {
        DX_IDM_SubsOverlay.clickOnSubsOverlayXIcon();
    }

    @Then("Return to my vodafone CTA should be displayed")
    public void returnToMyVodafoneCTAShouldBeDisplayed() {
        DX_IDM_SubsOverlay.assertReturnToMyVodafoneCTADisplayed();
    }

    @Then("Login CTA should be displayed")
    public void loginCTAShouldBeDisplayed() {
        DX_IDM_SubsOverlay.assertUnknownSubsOverlayLoginCTADisplayed();

    }

    @When("Click on Login CTA for Unknown SubsOverlay")
    public void clickOnLoginCTA() {
        DX_IDM_SubsOverlay.clickOnUnKnownSubsOverlayLoginCTA();
    }

    @Then("takes me back to Login Screen")
    public void takesMeBackToLoginScreen() {
        DX_IDM_SubsOverlay.validateUnKnownSubsOverlayLoginCTA();
    }


    @And("accept cookies")
    public void acceptCookies() {
        DX_IDM_SubsOverlay.acceptCookies();
    }


    @When("Acquisition dashboard Displayed")
    public void acquisitionDashboardDisplayed() {
        DX_IDM_SubsOverlay.validateAcquisitionDashboardDisplayed();
    }

    @Then("A Specific Overlay should be displayed for Heritage users")
    public void aSpecificOverlayShouldBeDisplayedForHeritageUsers() {
        DX_IDM_SubsOverlay.assertSpecificSubsOverlayDisplayedAfterAcquisitionScreen();
    }

    @Then("Return to acquisition dashboard")
    public void returnToAcquisitionDashboard() {
        DX_IDM_SubsOverlay.validateAcquisitionDashboardDisplayed();
    }


//    @Then("takes me back to acquisition dashboard")
//    public void takesMeBackToAcquisitionDashboard() {
//        DX_IDM_SubsOverlay.validateAcquisitionDashboardDisplayed();
//    }
}

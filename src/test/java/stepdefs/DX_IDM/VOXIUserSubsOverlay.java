//package stepdefs.DX_IDM;
//
//import core.Config;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import pages.DX_IDM.SubsOverlay.DX_IDM_SubsOverlay_Abstract;
//import pages.DX_IDM.SubsOverlay.DX_IDM_SubsOverlay_Android;
//import pages.DX_IDM.SubsOverlay.DX_IDM_SubsOverlay_IOS;
//
//import java.io.IOException;
//@Deprecated
//public class VOXIUserSubsOverlay {
//    DX_IDM_SubsOverlay_Abstract VOIXSubsOverlayLogic;
//
//    public VOXIUserSubsOverlay(Config config) throws IOException {
//        if (config.isAndroid()) VOIXSubsOverlayLogic = new DX_IDM_SubsOverlay_Android();
//        if (config.isIos()) VOIXSubsOverlayLogic = new DX_IDM_SubsOverlay_IOS();
//    }
//
//
//    @Given("VOXI User Launch the App")
//    public void voxiUserLaunchTheApp() {
//    }
//
//    @Then("A Specific Overlay should be displayed for VOXI users")
//    public void aSpecificOverlayShouldBeDisplayedForVOXIUsers() {
//        VOIXSubsOverlayLogic.assertSpecificSubsOverlayDisplayedAfterAcquisitionScreen();
//    }
//
//    @Then("visit VOXI CTA should be displayed")
//    public void visitVOXICTAShouldBeDisplayed() {
//        VOIXSubsOverlayLogic.assertVOXIVisitCTADisplayed();
//    }
//
//    @When("Click on VOXI CTA")
//    public void clickOnVOXICTA() {
//        VOIXSubsOverlayLogic.clickOnVOXIVisitCTA();
//    }
//
//    @Then("Directs me to the VOXI users web portal")
//    public void directsMeToTheVOXIUsersWebPortal() {
//        VOIXSubsOverlayLogic.validateVOXIVisitCTA();
//    }
//
//    @When("Click on back button on web portal")
//    public void clickOnXIconOnWebPortal() {
//        VOIXSubsOverlayLogic.pressPhysicalBackonWebPortal();
//    }
//
//    @Then("takes me back to VOXI OverLay dashboard")
//    public void takesMeBackToVOXIOverLayDashboard() {
//        VOIXSubsOverlayLogic.assertSpecificSubsOverlayDisplayedAfterAcquisitionScreen();
//    }
//}

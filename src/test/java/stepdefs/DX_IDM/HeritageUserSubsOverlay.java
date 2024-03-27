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
//public class HeritageUserSubsOverlay {
//    DX_IDM_SubsOverlay_Abstract HeritageUserSubsOverlay;
//
//    public HeritageUserSubsOverlay(Config config) throws IOException {
//        if (config.isAndroid()) HeritageUserSubsOverlay = new DX_IDM_SubsOverlay_Android();
//        if (config.isIos()) HeritageUserSubsOverlay = new DX_IDM_SubsOverlay_IOS();
//    }
//
//    @When("Acquisition dashboard Displayed")
//    public void acquisitionDashboardDisplayed() {
//        HeritageUserSubsOverlay.validateAcquisitionDashboardDisplayed();
//    }
//
//    @Then("A Specific Overlay should be displayed for Heritage users")
//    public void aSpecificOverlayShouldBeDisplayedForHeritageUsers() {
//        HeritageUserSubsOverlay.assertSpecificSubsOverlayDisplayedAfterAcquisitionScreen();
//    }
//
//    @Then("Return to acquisition dashboard")
//    public void returnToAcquisitionDashboard() {
//        HeritageUserSubsOverlay.validateAcquisitionDashboardDisplayed();
//    }
//
//    @When("I click on Return to my vodafone CTA")
//    public void clickOnReturnToMyVodafoneCTA() {
//        HeritageUserSubsOverlay.clickOnReturnToMyVodafoneCTA();
//    }
//
//    @Then("takes me back to acquisition dashboard")
//    public void takesMeBackToAcquisitionDashboard() {
//        HeritageUserSubsOverlay.validateAcquisitionDashboardDisplayed();
//    }
//}

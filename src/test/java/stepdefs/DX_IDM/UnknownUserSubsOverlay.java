//package stepdefs.DX_IDM;
//
//import core.Config;
//import io.cucumber.java.en.And;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import pages.DX_IDM.SubsOverlay.DX_IDM_SubsOverlay_Abstract;
//import pages.DX_IDM.SubsOverlay.DX_IDM_SubsOverlay_Android;
//import pages.DX_IDM.SubsOverlay.DX_IDM_SubsOverlay_IOS;
//
//import java.io.IOException;
//
//@Deprecated
//public class UnknownUserSubsOverlay{
//
//    DX_IDM_SubsOverlay_Abstract UnknownUserSubsOverlay;
//
//    public UnknownUserSubsOverlay(Config config) throws IOException {
//        if (config.isAndroid()) UnknownUserSubsOverlay = new DX_IDM_SubsOverlay_Android();
//        if (config.isIos()) UnknownUserSubsOverlay = new DX_IDM_SubsOverlay_IOS();
//    }
//
//    @Then("A Specific Overlay should be displayed for Unknown users")
//    public void aSpecificOverlayShouldBeDisplayedForUnknownUsers() {
//        UnknownUserSubsOverlay.assertSpecificSubsOverlayDisplayedAfterAcquisitionScreen();
//    }
//
//
//    @Then("Close ICon should be displayed")
//    public void closeIConShouldBeDisplayed() {
//        UnknownUserSubsOverlay.assertSubsOverlayXICONDisplayed();
//    }
//
//    @When("Click on Close Icon")
//    public void clickOnCloseIcon() {
//        UnknownUserSubsOverlay.clickOnSubsOverlayXIcon();
//    }
//
//    @Then("Return to my vodafone CTA should be displayed")
//    public void returnToMyVodafoneCTAShouldBeDisplayed() {
//        UnknownUserSubsOverlay.assertReturnToMyVodafoneCTADisplayed();
//    }
//
//    @Then("Login CTA should be displayed")
//    public void loginCTAShouldBeDisplayed() {
//        UnknownUserSubsOverlay.assertUnknownSubsOverlayLoginCTADisplayed();
//
//    }
//
//    @When("Click on Login CTA")
//    public void clickOnLoginCTA() {
//        UnknownUserSubsOverlay.clickOnUnKnownSubsOverlayLoginCTA();
//    }
//
//    @Then("takes me back to Login Screen")
//    public void takesMeBackToLoginScreen() {
//        UnknownUserSubsOverlay.validateUnKnownSubsOverlayLoginCTA();
//    }
//
//
//    @And("accept cookies")
//    public void acceptCookies() {
//        UnknownUserSubsOverlay.acceptCookies();
//    }
//}

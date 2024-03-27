package stepdefs.DX_IDM;

import core.Config;
import io.cucumber.java.en.*;
import pages.DX_IDM.WelcomeFlow.DX_IDM_WelcomeFlowLogicAbstract;
import pages.DX_IDM.WelcomeFlow.DX_IDM_WelcomeFlowLogicAndroid;
import pages.DX_IDM.WelcomeFlow.DX_IDM_WelcomeFlowLogic_IOS;

public class WelcomeScreens_OneTrust {
    private DX_IDM_WelcomeFlowLogicAbstract dx_idm_welcomeFlowLogic;

    public WelcomeScreens_OneTrust(Config config) {
        if (config.isAndroid()) {
            dx_idm_welcomeFlowLogic = new DX_IDM_WelcomeFlowLogicAndroid();
        }
        if (config.isIos()) {
            dx_idm_welcomeFlowLogic = new DX_IDM_WelcomeFlowLogic_IOS();
        }
    }

    @Given("I am MVA user and launches the app for the first time")
    public void validateWelcomeScreenOpened() {
        dx_idm_welcomeFlowLogic.ValidateWelcomeScreenOpened();
    }

    @And("I click on 'Continue' CTA in the Welcome flow Screens")
    public void clickOnContinueCTA() {
        dx_idm_welcomeFlowLogic.clickOnContinueCTAWelcomeScreens();
    }
    @Given("I redirected to 'Before you get started' screen")
    public void validateBeforeYouGetStartedScreenOpened() {
        dx_idm_welcomeFlowLogic.validateBeforeYouGetStartedScreenOpened();
    }
    @And("I validate 'Before you get started' screen")
    public void validateBeforeYouGetStartedScreen() {
        dx_idm_welcomeFlowLogic.validateBeforeYouGetStartedScreen();
    }
    @And("I validate that pop up 'Please agree to the terms and conditions before continuing' displayed")
    public void validateTermsandConditionsPopup() {
        dx_idm_welcomeFlowLogic.validateTermsandConditionsPopup();
    }
    @Given("I toggle on 'Ts&Cs'")
    public void toggleOnTermsandConditons() {
        dx_idm_welcomeFlowLogic.toggleOnTermsandConditions();
    }
    @Given("I redirected to 'We Value Your Privacy' screen")
    public void validateWeValueYourPrivacyScreen() {
        dx_idm_welcomeFlowLogic.weValueYourPrivacyScreen();
    }
    @Given("I click on 'Back' CTA in Welcome flow screens")
    public void clickOnBackCTA() {
        dx_idm_welcomeFlowLogic.clickOnBackCTA();
    }
    @And("I click on 'Terms and conditions' Link")
    public void iClickOnTermsAndConditionsLink() {
        dx_idm_welcomeFlowLogic.TermsAndConditionsLink();
    }
    @And("I redirected to Terms and Conditions screen")
    public void iRedirectedToTermsAndConditionsScreen() {
        dx_idm_welcomeFlowLogic.TermsAndConditionsScreen();
    }
    @And("I click on Ok CTA")
    public void iClickOnOkCTA() {
        dx_idm_welcomeFlowLogic.clickOkCtaTermsAndConditionsScreen();
    }

    @Then("I redirected to 'Cookie permission' screen")
    public void iRedirectedToCookiePermissionScreen() {
        dx_idm_welcomeFlowLogic.validateNavigationToCookiePermissions();
    }

    @When("I click on 'Manage cookies' CTA")
    public void iClickOnManageCookiesCTA() {
        dx_idm_welcomeFlowLogic.OpenCookiePermissions();
    }

    @When("I click on 'Back' CTA in Cookie permissions screen")
    public void iClickOnBackCTAInCookiePermissionsScreen() {
        dx_idm_welcomeFlowLogic.ClickOnBackInCookiePerms();
    }

    @And("I can Toggle ON&OFF all cookies in Cookie Permissions screen")
    public void iCanToggleONOFFAllCookiesInCookiePermissionsScreen() {
        dx_idm_welcomeFlowLogic.ToggleOnOffAllCookies();
    }

    @And("I can expand&collapse all cookies cards in Cookie Permissions screen")
    public void iCanExpandCollapseAllCookiesCardsInScreen() {
        dx_idm_welcomeFlowLogic.expandAndCollapseAllCookies();
    }

    @And("I validate 'Cookie permission' UI from {string}")
    public void iValidateCookiePermissionUI(String enteryPoint) {
        dx_idm_welcomeFlowLogic.validateCookiePermissionsScreen(enteryPoint);
    }

    @And("I click on App Privacy Supplement Link")
    public void iClickOnAppPrivacySupplementLink() {
        dx_idm_welcomeFlowLogic.ClickOnAppPrivacySupplementLink();
    }

    @Then("I redirected to App Privacy Supplement screen")
    public void iRedirectedToAppPrivacySupplementScreen() {
        dx_idm_welcomeFlowLogic.ValidateAppPrivacySupplementScreen();
    }

    @Given("I click on 'Accept all cookies' CTA in 'We Value Your Privacy' screen")
    public void clickonAcceptAllCookiesinWeValueYourPrivacy() {
        dx_idm_welcomeFlowLogic.clickonAcceptAllCookiesinWeValueYourPrivacy();
    }

    @Then("I redirected 'Our Network & Service' screen")
    public void redirectNetworkandService() {
        dx_idm_welcomeFlowLogic.redirectNetworkandService();
    }

    @Then("I validate 'Our Network & Service' screen with 'Enable Performance cookies' link")
    public void validateOurNetworkandServiceWithtLink() {
        dx_idm_welcomeFlowLogic.validateOurNetworkandServiceWithLink();
    }
    @Then("I validate 'Our Network & Service' screen without 'Enable Performance cookies' link")
    public void validateOurNetworkandServiceWithoutLink() {
        dx_idm_welcomeFlowLogic.validateOurNetworkandServiceWithoutLink();
    }
    @Then("I validate 'Get the best experience' screen without 'Enable Targeting cookies' link")
    public void validateGettheBestExperienceWithoutLink() {
        dx_idm_welcomeFlowLogic.validateGettheBestExperienceWithoutLink();
    }
    @Then("I validate 'Get the best experience' screen with 'Enable Targeting cookies' link")
    public void validateGettheBestExperienceWithLink() {
        dx_idm_welcomeFlowLogic.validateGettheBestExperienceWithLink();
    }

    @Then("I validate on Network Improvements toggle ON and OFF")
    public void validateOurNetworkImprovementsToggle() {
        dx_idm_welcomeFlowLogic.validateOurNetworkImprovementsToggle();
    }
    @And("I click on 'Accept all' CTA in 'Cookie Permissions' screen")
    public void clickonAcceptAllfromCookiePermissions() {
        dx_idm_welcomeFlowLogic.clickonAcceptAllfromCookiePermissions();
    }
    @And("I opt {string} cookie with the {string} state")
    public void optingPerformanceCookies(String cookie,String state) {
        dx_idm_welcomeFlowLogic.Toggle_Cookie(cookie,state);
    }
    @And("I click on 'Reject all' CTA in 'Cookie Permissions' screen")
    public void clickonRejectAllfromCookiePermissions (){
        dx_idm_welcomeFlowLogic.clickonRejectAllfromCookiePermissions();
    }
    @And("I click on 'Enable Performance Cookies' link in 'Our network and service' screen")
    public void clickOnEnablePerformanceCookiesLink (){
        dx_idm_welcomeFlowLogic.clickOnEnablePerformanceCookiesLink();
    }
    @And ("I click on 'Enable Targeting cookies' link")
    public void clickOnEnableTargetingCookiesLink (){
        dx_idm_welcomeFlowLogic.clickOnEnableTargetingCookiesLink();
    }
    @And ("I click on 'Enable All' CTA in 'Get the best experience' screen")
    public void clickOnEnableAllCTA (){
        dx_idm_welcomeFlowLogic.clickOnEnableAllCTA();
    }
    @When("I click on 'CookiePolicy' link")
    public void iClickOnCookiePolicyHyperlink() {
        dx_idm_welcomeFlowLogic.clickOnCookiePolicyLink();
    }

    @Then("I should be navigated to CookiePolicy screen with collapsed chevrons")
    public void iShouldBeNavigatedToCookiePolicyWithCollapsedChevrons() {
        dx_idm_welcomeFlowLogic.validateCookiePolicyScreen();
    }

    @When("I click on the first two policies they will expand to show their description")
    public void iClickOnTheFirstTwoPoliciesTheyWillExpandToShowTheirDescription() {
        dx_idm_welcomeFlowLogic.clickOnFirstTwoPolicies();
    }

    @Then("I click on the last two policies it will redirect the user to another screen regarding each policy")
    public void iClickOnTheLastTwoPoliciesItWillRedirectTheUserToAnotherScreenRegardingEachPolicy() {
        dx_idm_welcomeFlowLogic.clickOnLastTwoPolicies();
    }

    @When("I Toggle ON Network Improvements from welcome flow")
    public void iToggleNetworkImprovementsONFromWelcomeFlow() {dx_idm_welcomeFlowLogic.ToggleNetworkImprovementsFromWelcomeFlow();
    }
}

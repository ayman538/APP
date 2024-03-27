package stepdefs.RedHybrid;

import core.Config;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.simple.parser.ParseException;
import pages.DX_IDM.HandlingNewCookies.HandlingNewCookiesAbstract;
import pages.DX_IDM.HandlingNewCookies.HandlingNewCookiesAndroid;
import pages.DX_IDM.HandlingNewCookies.HandlingNewCookiesIOS;
import pages.RedHybrid.LoginFlow.RedHybrid_LoginLogic_Abstract;
import pages.RedHybrid.LoginFlow.RedHybrid_LoginLogic_Android;
import pages.RedHybrid.LoginFlow.RedHybrid_LoginLogic_iOS;
import pages.RedHybrid.PaymentReminderOverlay.RedHybrid_PaymentReminderOverlay_Abstract;
import pages.RedHybrid.PaymentReminderOverlay.RedHybrid_PaymentReminderOverlay_Android;
import pages.RedHybrid.PaymentReminderOverlay.RedHybrid_PaymentReminderOverlay_IOS;
import pages.RedHybrid.SubsOverlay.RedHybrid_SubsOverlay_Abstract;
import pages.RedHybrid.SubsOverlay.RedHybrid_SubsOverlay_Logic_Android;
import pages.RedHybrid.SubsOverlay.RedHybrid_SubsOverlay_Logic_iOS;


public class RedHybrid_SubsOverlay {

    private RedHybrid_SubsOverlay_Abstract subsOverlay_abstract;
    private RedHybrid_LoginLogic_Abstract redHybrid_LoginLogic;
    private HandlingNewCookiesAbstract handlingNewCookiesAbstract;
    private RedHybrid_PaymentReminderOverlay_Abstract redHybrid_paymentReminderOverlay_abstract;

    public RedHybrid_SubsOverlay (Config config) {
        if (config.isAndroid()){
            subsOverlay_abstract = new RedHybrid_SubsOverlay_Logic_Android();
            redHybrid_LoginLogic = new RedHybrid_LoginLogic_Android();
            handlingNewCookiesAbstract = new HandlingNewCookiesAndroid();
            redHybrid_paymentReminderOverlay_abstract = new RedHybrid_PaymentReminderOverlay_Android();
        }
        if (config.isIos()){
            subsOverlay_abstract = new RedHybrid_SubsOverlay_Logic_iOS();
            redHybrid_LoginLogic = new RedHybrid_LoginLogic_iOS();
            handlingNewCookiesAbstract = new HandlingNewCookiesIOS();
            redHybrid_paymentReminderOverlay_abstract = new RedHybrid_PaymentReminderOverlay_IOS();
        }
    }

    @Given("Click On Any Tile")
    public void clickOnAnyTile() {
        subsOverlay_abstract.clickOnAnyTile();
    }


    @Then("Validate SubsOverlay UI")
    public void validateSubsOverlayUI() {
        subsOverlay_abstract.validateSubsOverlayUI();
    }

    @When("App SoftClose Then Relaunch it")
    public void appSoftCloseThenRelaunchIt() {
        subsOverlay_abstract.appSoftCloseThenRelaunchIt();
    }

    @Then("Plan Usage Extras Tabs Are Displayed")
    public void planUsageExtrasTabsAreDisplayed() {
        subsOverlay_abstract.planUsageExtrasTabsAreDisplayed();
    }

    @When("Click On X Icon")
    public void clickOnXIcon() {
        subsOverlay_abstract.clickOnXIcon();
    }


    // for RedHybrid_SubsOverlay_ExtrasTab feature file

    @Given("Red Hybrid User is On Dashboard")
    public void RedHybridUserIsOnDashboard(){
        try{
            redHybrid_paymentReminderOverlay_abstract.clickOnBackToVodafoneCTA();
        }catch (Exception e){
            System.out.println("No Payment Reminder Overlay");
        }

        subsOverlay_abstract.DashboardIsDisplayed();
    }

    @Given("Red Hybrid User finish UFL Journey and Land on Dashboard")
    public void RedHybridUserIsOnDashboardUFL() throws ParseException {
        redHybrid_LoginLogic.clickOnLoginCTA();
        handlingNewCookiesAbstract.acceptCookies();
        redHybrid_LoginLogic.enterUsernameAndPassword();
        redHybrid_LoginLogic.selectAccountAndEnterSecurityCode();
        redHybrid_LoginLogic.ChoseLoginPreferenceAndClickOkAllDone();
        try{
            redHybrid_paymentReminderOverlay_abstract.clickOnBackToVodafoneCTA();
        }catch (Exception e){
            System.out.println("No Payment Reminder Overlay");
        }
        subsOverlay_abstract.DashboardIsDisplayed();
    }


    @When("Navigating to Extras Tab in Subs overlay")
    public void NavigatingToExtrasTab(){
        subsOverlay_abstract.NavigateToExtrasTab();
    }

    @Then("I should be in Extras tab")
    public void ValidateOnContentOfExtrasTab(){
        subsOverlay_abstract.ValidateOnContentOfExtrasTab();
    }

    @Then("I should not see Pay as You Go Card")
    public void ValidatePayAsYouGoCardIsNotDisplayed(){
        subsOverlay_abstract.ValidatePayAsYouGoCardIsNotDisplayed();
    }


    @Then("I should see added extras")
    public void ValidateAddingExtrasAppear()
    {
        subsOverlay_abstract.ValidateExtrasDisplayed();
    }
}
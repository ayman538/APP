package stepdefs.TC_Dashboard;

import core.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.response.SubConfigResponseModel;
import pages.Dashboard.FSP.FSPAbstract;
import pages.Dashboard.FSP.FSPAndroid;
import pages.Dashboard.FSP.FSPIOS;
import pages.RedHybrid.LoginFlow.RedHybrid_LoginLogic_Abstract;
import pages.RedHybrid.LoginFlow.RedHybrid_LoginLogic_Android;
import pages.RedHybrid.LoginFlow.RedHybrid_LoginLogic_iOS;
import stepdefs.DX_IDM.HandlingNewCookiesBehaviorForSSO;
import stepdefs.RedHybrid.RedHybrid_Login;


import java.io.IOException;

import static core.Config.getLoginStatus;

public class FSP {

    FSPAbstract FSPItem ;

    public FSP (Config config)throws IOException {
        if (config.isAndroid()) {
            FSPItem = new FSPAndroid();
        }
        if (config.isIos()) {
            FSPItem = new FSPIOS();
        }
    }

    @Then("I view FSP Overlay with Multiple CTAs")
    public void validateFSPOverlay() throws InterruptedException {FSPItem.FSPExists();}

    @And("I click on UpgradeNow CTA")
    public void validateLearnMoreCTA (){FSPItem.FSPClickOnLearnMore();}

    @Then("I should navigate to the offer webpage")
    public void validateOfferWebpage() throws InterruptedException {FSPItem.assertofferpage();}

    @And("I click on close CTA")
    public void iClickOnCloseCTA() {FSPItem.FSPClickOnClose();}

    @Then("I should not see FSP overlay")
    public void iShouldNotSeeFSPOverlay() {FSPItem.FSPDoesNotExist();}

    @Then("The FSP should be dismissed")
    public void theFSPShouldBeDismissed() {FSPItem.FSPDoesNotExist();}

    @And("I close the tutorial")
    public void iCloseTheTutorial() {FSPItem.TUTClickOnClose();}


    @When("I close the offer page and return to the app")
    public void iCloseTheOfferPageAndReturnToTheApp() {FSPItem.FSPCloseWebpage();}
}

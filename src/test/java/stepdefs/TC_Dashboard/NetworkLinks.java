package stepdefs.TC_Dashboard;

import core.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Dashboard.NetworkLinks.NetworkLinksAbstract;
import pages.Dashboard.NetworkLinks.NetworkLinksAndroid;
import pages.Dashboard.NetworkLinks.NetworkLinksIOS;

public class NetworkLinks {

    NetworkLinksAbstract networksLogic;

    public NetworkLinks(Config config) {
        if (config.isAndroid()) networksLogic = new NetworkLinksAndroid();
        if (config.isIos()) networksLogic = new NetworkLinksIOS();
    }

    @Given("Dashboard loaded and Network links retrieved successfully")
    public void NetworkLinksStatus(){
        networksLogic.NetworkLinksStatus();
    }

    @Then("Check Network title text")
    public void assertNetworkTitleText() {
        networksLogic.assertNetworkTitleText();
    }

    @Then("Check Network links ordering and texts")
    public void ValidateNetworkLinksOrderAndText() {
        networksLogic.ValidateNetworkLinksOrderAndText();
    }

    @Then("Check Network links CTAs")
    public void ValidateAssistanceLinksCTA() {
        networksLogic.ValidateNetworkLinksCTA();
    }

    @When("I Scroll Down and click on Broad Band Service Test")
    public void scrollDownToBroadBandServiceTest() {
        networksLogic.scrollDownToBroadBandServiceTest();
    }

    @And("I should see the login screen displayed in custom tab")
    public void ValidateUserName() {
        networksLogic.ValidateUserName();
    }

    @Then("Go back from internal or custom tab WebView to the App")
    public void goBackFromInternalOrCustomTabWebViewToTheApp() {
        networksLogic.navigateBack();
    }

    @Then("I validate The Broad Band Service Test Screen")
    public void ValidateBroadBandServiceTestLink()
    {
        networksLogic.ValidateBroadBandServiceTestLink();
    }

    /*
    @Then("Validate Data WIFI is opened successfully")
    public void TC04_checkDataWIFIJourney() {
        networksLogic.checkDataWIFIJourney();
    }

    @Then("Validate Speed Test")
    public void TC05_checkSpeedCheckTest() {
        networksLogic.checkSpeedTest();
    }

     */

}

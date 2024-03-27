package stepdefs.TC_Dashboard;

import core.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Dashboard.FriendlyName.FriendlyNameAbstract;
import pages.Dashboard.FriendlyName.FriendlyNameAndroid;
import pages.Dashboard.FriendlyName.FriendlyNameIOS;

import java.io.IOException;

public class FriendlyName {

    FriendlyNameAbstract friendlyName;

    public FriendlyName(Config config) throws IOException {
        if (config.isAndroid()) friendlyName = new FriendlyNameAndroid();
        if (config.isIos()) friendlyName = new FriendlyNameIOS();
    }

    @Then("I tap on Pencil icon")
    public void iValidateThatPencilIconIsDisplayed() {
        friendlyName.verifyPencilIconExist();
    }

    @Then("I validate that Pencil icon is not displayed")
    public void iValidateThatPencilIconIsNotDisplayed() {
        friendlyName.verifyPencilIconNotExist();
    }

    @And("I enter a valid friendly name")
    public void iEnterAValidFriendlyName() {
        friendlyName.enterValidFriendlyName();
    }

    @And("I tap on save CTA")
    public void iTapOnSaveCTA() {
        friendlyName.clickOnSaveCTA();
    }

    @Then("I validate friendly name updating screen displayed")
    public void iValidateFriendlyNameUpdatingScreenDisplayed() {
        friendlyName.verifyFriendlyNameUpdatedScreen();

    }

    @Then("I validate friendly name pending screen displayed")
    public void iValidateFriendlyNamePendingScreenDisplayed() {
        friendlyName.verifyFriendlyNamePendingScreen();
    }

    @When("I close updating screen")
    public void iCloseUpdatingScreen() {
        friendlyName.closeUpdatingScreen();
    }

    @And("I enter an invalid friendly name")
    public void iEnterAnInvalidFriendlyName() {
        friendlyName.enterInvalidFriendlyName();
    }

    @Then("I validate invalid friendly name error message displayed")
    public void iValidateInvalidFriendlyNameErrorMessageDisplayed() {
        friendlyName.verifyInvalidFriendlyNameMsg();
    }

    @Given("I tap on area containing the pencil-edit icon ,my MSISDN with-without Friendly Name")
    public void iTapOnAreaContainingThePencilEditIconMyMSISDNWithWithoutFriendlyName() {
        friendlyName.clickOnSubsInfoContainer();
    }

    @Then("I validate friendly name overlay is displayed")
    public void iValidateFriendlyNameOverlayIsDisplayed() {
        friendlyName.validateFriendlyNameOverlay();
    }

}

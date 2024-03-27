package stepdefs.NativeExtras;

import core.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.NativeExtras.NativeExtrasAbstract;
import pages.NativeExtras.NativeExtrasLogicAndroid;
import pages.NativeExtras.NativeExtrasLogiciOS;
import pages.NativeExtras.SecureNet.SecureNetLogicAbstract;
import pages.NativeExtras.SecureNet.SecureNetLogicAndroid;
import pages.NativeExtras.SecureNet.SecureNetLogiciOS;

public class NativeExtrasStepDef {
    NativeExtrasAbstract addExtrasTileAbstract;
    SecureNetLogicAbstract secureNetLogicAbstract;

    public NativeExtrasStepDef(Config config) {
        if (config.isAndroid()) {
            addExtrasTileAbstract = new NativeExtrasLogicAndroid();
            secureNetLogicAbstract = new SecureNetLogicAndroid();
        }
        if (config.isIos()) {
            addExtrasTileAbstract = new NativeExtrasLogiciOS();
            secureNetLogicAbstract = new SecureNetLogiciOS();
        }
    }

    @Then("I should see the Native Add Extras tile")
    public void iShouldSeeTheAddExtrasTile() {
        addExtrasTileAbstract.validateAddExtrasTileExistence();

    }

    @And("I click on the Native Add Extras tile")
    public void iClickOnTheNativeAddExtrasTile() {
        addExtrasTileAbstract.clickOnAddExtrasTile();
    }

    @Then("I should be navigated to the Native Extras tab")
    public void iShouldBeNavigatedToTheNativeExtrasTab() {
        addExtrasTileAbstract.validateExtrasTabIsOpened();

    }

//    @Then("I should see the Manage extras card")
//    public void iShouldSeeTheManageExtrasCard() {
//        addExtrasTileAbstract.validateManageExtrasCardExistence();
//    }
//
//    @Then("I should see the Manage extras title")
//    public void iShouldSeeTheManageExtrasTitle() {
//        addExtrasTileAbstract.validateManageExtrasTitleExistence();
//    }
//
//    @And("I should see the Manage extras icon")
//    public void iShouldSeeTheManageExtrasIcon() {
//        addExtrasTileAbstract.validateManageExtrasIconExistence();
//    }
//
//    @And("I should see the Manage extras arrow icon")
//    public void iShouldSeeTheManageExtrasArrowIcon() {
//        addExtrasTileAbstract.validateManageExtrasArrowIconExistence();
//    }
//
//    @And("I should see the Manage extras description")
//    public void iShouldSeeTheManageExtrasDescription() {
//        addExtrasTileAbstract.validateManageExtrasDescriptionExistence();
//    }
//
//    @When("I click on the arrow icon of the extras card")
//    public void iClickOnTheArrowIconOfTheExtrasCard() {
//        addExtrasTileAbstract.clickOnManageExtrasArrowIcon();
//    }
//
//    @Then("I should see the Manage extras Reinvent journey is open")
//    public void iShouldSeeTheManageExtrasReinventJourneyIsOpen() {
//        addExtrasTileAbstract.validateManageExtrasReinventJourneyIsOpen();
//    }

    @Then("I should see active extras Details")
    public void iShouldSeeActiveExtrasDetails() {
        addExtrasTileAbstract.validateActiveExtrasCardContent();
    }

    @Then("I should see description of active extra after clicking Find Out CTA")
    public void iShouldSeeDescriptionOfActiveExtra() {
        addExtrasTileAbstract.validateClickingOnFindOutMoreCTA();
    }


    @Then("I should see the shop extras card")
    public void iShouldSeeTheShopExtrasCard() {
        addExtrasTileAbstract.validateShopExtrasCard();
    }

    @Then("I should shop extras categories")
    public void iShouldShopExtrasCategories() {
        addExtrasTileAbstract.validateShopExtrasCategories();
    }

    @And("I click on the {string}")
    public void iClickOnThe(String categoryName) {
        addExtrasTileAbstract.clickOnCategoryCard(categoryName);
    }

    @And("I should see added extra under Active Extras with pending status")
    public void iShouldSeeAddedExtraWithPendingStatus() {
        addExtrasTileAbstract.validateAddedExtraWithPendingStatus();
    }

    @Then("I should see {string} CTA for recurring extra")
    public void iShouldSeeCTAForRecurringExtra(String buttonName) throws Exception {
        addExtrasTileAbstract.validateOnOptingCTARecurringExtra(buttonName);
    }

    @And("I click on {string} for CTA for recurring extra")
    public void iClickOnForCTAForRecurringExtra(String  buttonName) {
        addExtrasTileAbstract.clickOnOptingCTARecurringExtra(buttonName);
    }

    @And("I should see {string} CTA disabled")
    public void iShouldSeeCTADisabled(String buttonName) {
        addExtrasTileAbstract.validateOnOptingCTAStatus(buttonName);
    }

    @Then("I should the shop Extras Card Details")
    public void iShouldTheShopExtrasCardDetails() {
        addExtrasTileAbstract.validateShopExtrasDetails();
    }

    @Then("I should see Active extras card without any extras")
    public void iShouldSeeActiveExtrasCardWithoutAnyExtras() {
        addExtrasTileAbstract.validateActiveExtrasCardEmpty();
    }

    @When("I scroll down to Secure Net extra")
    public void scrollToSecureNetExtraExists(){
        secureNetLogicAbstract.scrollToSecureNetExtraExists();
    }

    @Then("I should see Secure Net updated CTA and details")
    public void checkSecureNetExtraUpdated(){
        secureNetLogicAbstract.checkSecureNetExtraUpdated();
    }

    @Then("I should see Secure Net updated description")
    public void checkSecureNetExtraUpdatedDescription(){
        secureNetLogicAbstract.checkSecureNetExtraUpdatedDescription();
    }
}
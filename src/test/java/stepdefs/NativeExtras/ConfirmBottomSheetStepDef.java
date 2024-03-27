package stepdefs.NativeExtras;

import core.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.NativeExtras.ConfirmBottomSheet.ConfirmBottomSheetAbstract;
import pages.NativeExtras.ConfirmBottomSheet.ConfirmBottomSheetLogicAndroid;
import pages.NativeExtras.ConfirmBottomSheet.ConfirmBottomSheetLogicIOS;

public class ConfirmBottomSheetStepDef {

    ConfirmBottomSheetAbstract confirmBottomSheetAbstract;
    public ConfirmBottomSheetStepDef(Config config) {
        if (config.isAndroid()) {
            confirmBottomSheetAbstract = new ConfirmBottomSheetLogicAndroid();
        }
        if (config.isIos()) {
            confirmBottomSheetAbstract = new ConfirmBottomSheetLogicIOS();
        }
    }

    @When("I click on Buy CTA")
    public void iClickOnBuyCTA() {
        confirmBottomSheetAbstract.clickOnConfirmScreenBuyCTA();

    }

    @And("I click on the back arrow icon on the Confirm Bottom Sheet")
    public void iClickOnTheBackArrowIconOnTheConfirmBottomSheet() {
        confirmBottomSheetAbstract.clickOnConfirmScreenBackArrowIcon();
    }

    @Then("I should be navigated to the {string} Confirm Bottom Sheet")
    public void iShouldBeNavigatedToTheConfirmBottomSheet(String categoryName) throws Exception {
        confirmBottomSheetAbstract.validateConfirmBottomSheetTitle(categoryName);
    }

    @Then("I should see {string} Confirm Bottom Content")
    public void iShouldSeeConfirmBottomContent(String categoryName) {
        confirmBottomSheetAbstract.validateConfirmBottomSheetContent(categoryName);
    }
}

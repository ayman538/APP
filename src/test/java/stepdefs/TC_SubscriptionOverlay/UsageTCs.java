package stepdefs.TC_SubscriptionOverlay;

import core.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_scouse.An;
import org.testng.SkipException;
import pages.SubsctionOverlay.UsagesTab.UsagesTabAbstract;
import pages.SubsctionOverlay.UsagesTab.UsagesTabAndroid;
import pages.SubsctionOverlay.UsagesTab.UsagesTabIOS;

import static core.Hooks.testAfterLastScenario;
import static testdata.ReadResponse.*;


public class UsageTCs {

    UsagesTabAbstract usagesLogic;

    public UsageTCs(Config config) {
        if (config.isAndroid()) usagesLogic = new UsagesTabAndroid();
        if (config.isIos()) usagesLogic = new UsagesTabIOS();
    }

    @When("Navigate to Usages")
    public void navigateToUsages() {
        usagesLogic.navigateToUsages();
        System.out.println("vv");
    }

    @Then("I validate usage tab is opened and plan card")
    public void checkPlanCardinUsage() {
        usagesLogic.checkPlanCardinUsage();
    }

    @And("Check View plan CTA in plan card in Usage tab")
    public void checkViewPlanCTAinUsageTab() {
        usagesLogic.checkViewPlanCTAinUsageTab();
    }

    @Then("Check Add extras CTA in Usage tab")
    public void checkAddExtraCTAinUsageTab() {
        usagesLogic.checkAddExtraCTAinUsageTab();
    }

//    @Then("I should see Tile List")
//    public void iShouldSeeAddExtraCTAOrCarouselOrList() throws InterruptedException {
//        Thread.sleep(5000);
//        usagesLogic.checkCroExperience();
//    }

    @And("Validate their functionality")
    public void validateTheirFunctionality() {usagesLogic.validateExperienceFunctionality();}

    @When("I click on the Data tile")
    public void iClickOnTheDataTile() {
        usagesLogic.clickOnDataTile();
    }

    @Then("I should be navigated to Usage tab")
    public void iShouldBeNavigatedToUsageTab() {
        usagesLogic.validateUsageTabIsOpened();
    }

    @And("Check Manage extras, caps and bars CTA in Usage tab")
    public void checkManageExtrasCapsAndBarsCTAInUsageTab() {
        usagesLogic.validateManageExtrasCapsAndBarsCTAExistence();
    }

    @And("Validate Extras CTA")
    public void validateExtrasCTA() {
        usagesLogic.ValidateExtrasCTA();
    }

    @And("Validate SMB Tiles navigation")
    public void validateSMBTilesNavigation() {
        usagesLogic.validateSMBTilesNavigation();

    }

    @Then("I should see Tiles title")
    public void iShouldSeeTilesTitle() {
        usagesLogic.iShouldSeeTilesTitle();
    }

    @Then("I should see the Tile List and validate their functionality")
    public void iShouldSeeTheTileListAndValidateTheirFunctionality() {
        usagesLogic.iShouldSeeTheTileListAndValidateTheirFunctionality();
    }


    /*
    @Given("Usage plan exist")
    public void TC01_checkUsagePlan() {
        if (checkReturnedUsageAPIPlan()) {
            usagesLogic.checkUsagePlan();
        } else {
            throw new SkipException("Item not exist in the response");
        }
    }

    @Given("View Plan BVB CTA")
    public void TC02_checkPressingViewPlanBtn() {
        if (checkReturnedUsageAPIPlan()) {
            usagesLogic.createViewPlanBVBCTAString();
        } else {
            throw new SkipException("Item not exist in the response");
        }
    }

    @When("Plan tab content is displayed")
    public void planTabContent() {
        if (checkReturnedUsageAPIPlan()) {
            usagesLogic.assertPlanTabContentDisplayed();
        } else {
            throw new SkipException("Item not exist in the response");
        }
    }

    @Then("Click on usages tab")
    public void checkPressingViewPlanBtn() {
        if (checkReturnedUsageAPIPlan()) {
            usagesLogic.clickOnUsagesTab();
        } else {
            throw new SkipException("Item not exist in the response");
        }
    }

    @Then("Validate recurring extras")
    public void TC03_checkUsageRecurringExtras() {
        if (checkReturnedUsageAPIRecurringExtras()) {
            usagesLogic.checkUsageRecurringExtras();
        } else {
            throw new SkipException("Item not exist in the response");
        }
    }

    @When("User click on Manage Extras CTA")
    public void TC04_checkPressingManageExtrasBtn() throws InterruptedException {
        if (checkReturnedUsageAPIRecurringExtras()) {
            usagesLogic.manageExtrasCTA();
        } else {
            throw new SkipException("Item not exist in the response");
        }
    }

    @Then("Assert Extras Tab container is displayed")
    public void checkPressingManageExtrasBtn() throws InterruptedException {
        if (checkReturnedUsageAPIRecurringExtras()) {
            usagesLogic.assertExtrasTabContainerDisplayed();
        } else {
            throw new SkipException("Item not exist in the response");
        }
    }


    @Then("Validate Usage One Time extras is displayed")
    public void TC05_checkUsageOneTimeExtras() {
        if (checkReturnedUsageAPIOneTimeExtras()) {
            usagesLogic.checkUsageOneTimeExtras();
        } else {
            throw new SkipException("Item not exist in the response");
        }
    }

    @Then("Validate BVB usage")
    public void TC06_checkUsageBVB() {
        if (checkReturnedUsageAPIBVB()) {
            usagesLogic.checkUsageBVB();
        } else {
            throw new SkipException("Item not exist in the response");
        }
    }

    @Given("Plan BVB CTA is displayed")
    public void TC07_checkPressingViewPlanBVBBtn() {
        if (checkReturnedUsageAPIBVB()) {
            usagesLogic.InitializePlanBVBCTA();
        } else {
            throw new SkipException("Item not exist in the response");
        }
    }

    @When("Plan BVB tab content is displayed")
    public void checkPressingViewPlanBVBBtn() {
        if (checkReturnedUsageAPIBVB()) {
            usagesLogic.assertSOPlanTabContentDisplayed();
        } else {
            throw new SkipException("Item not exist in the response");
        }
    }

    @Then("Validate Add Extra Btn")
    public void TC08_checkAddExtraBtn() {
        usagesLogic.checkAddExtraBtn();
    }

    @Given("User clicks on Add Extra CTA")
    public void TC09_checkPressingAddExtraBtn() {
        usagesLogic.addExtraCTA();
    }

    @Then("Assert additional extras are displayed")
    public void assertAdditionalExtrasDisplayed() {
        usagesLogic.assertAdditionalExtrasDisplayed();
    }


    @Then("Validate Usages for PAYG simply user")
    public void TC10_checkUsagePAYGSimply() {
        if (checkReturnedUsageAPIPAYGSimply() && getUser().toLowerCase().contains("simply")) {
            usagesLogic.checkUsagePAYGSimply();
        } else {
            throw new SkipException("Item not exist in the response");
        }
    }

    @Then("Validate Usages for PAYG1 user")
    public void TC11_checkUsagePAYG1() {
        if (checkReturnedUsageAPIPAYG1() && getUser().toLowerCase().contains("1")) {
            usagesLogic.checkUsagePAYG1();
        } else {
            throw new SkipException("Item not exist in the response");
        }
    }

     */
}



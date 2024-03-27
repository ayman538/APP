package stepdefs.TC_Tray.TC_Billing;

import core.Config;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import pages.NewBilling.Billing_Abstract;
import pages.Tray.Billing.BillingAbstract;
import pages.Tray.Billing.BillingAndroid;
import pages.Tray.Billing.BillingLogic;
import pages.Tray.Billing.BillingiOS;

import java.io.IOException;

import static core.Hooks.testAfterLastScenario;

public class BillingTCs {

    BillingLogic billingLogic;

    public BillingAbstract billing;

    public BillingTCs (Config config) {
        if (config.isAndroid())
        {
            billing=new BillingAndroid();
        }
        if (config.isIos())
        {
            billing= new BillingiOS();
        }
    }


    static Boolean run = false;

    @Given("Init Billing class")
    public void BeforeFeature() {
        billingLogic = new BillingLogic();
        if (!run) {
            testAfterLastScenario();
            billingLogic.navigateToBilling();
            run = true;
        }
    }

    @When("clicks on Billing")
    public void TC01_validateBillingScreenForConsumer() {
        billingLogic.validateBillingScreen();
    }

    @Then("Validate Account name")
    public void TC02_ValidateAccountName() {
        billingLogic.ValidateAccountName();
    }

    @Then("Validate Graph appearance")
    public void TC03_ValidateGraphAppearance() {
        billingLogic.ValidateGraphAppearance();
    }

    @Then("Validate Graph title")
    public void TC04_ValidateGraphTitle() throws InterruptedException {
        billingLogic.ValidateGraphTitle();
    }

    @Then("Validate View All CTA text")
    public void TC05_ValidateViewAllCTAText() {
        billingLogic.ValidateViewAllCTAText();
    }

    @Then("Validate View All CTA opens Login screen")
    public void TC06_ValidateViewAllCTA() throws IOException {
        billingLogic.ValidateViewAllCTA();
    }

    @Then("Validate close x-icon is displayed")
    public void TC07_ValidateCloseCTADisplayed() {
        billingLogic.ValidateCloseCTADisplayed();
    }

    @Then("Validate Billing Cards are displayed")
    public void TC08_ValidateBillingCardsDisplayed() {
        billingLogic.ValidateBillingCardsDisplayed();
    }

    @Then("Validate Billing card CTAs are displayed")
    public void TC09_ValidateBillingCardsCTA() {
        billingLogic.ValidateBillingCardsCTA();
    }

    @Then("Validate VATs displayed on cards")
    public void TC10_ValidateVatsDisplayed() {
        billingLogic.ValidateVatsDisplayed();
    }

    @Then("Validate Billing x-icon functionality")
    public void TC11_ValidateCloseCTAFunctionality() {
        billingLogic.ValidateCloseCTAFunctionality();
    }

    @Then("I should see bar chart")
    public void iShouldSeeBarChart() {billing.CheckBarChartDisplayed(); }

    @Then("I should NOT see View All CTA")
    public void iShouldNOTSeeViewAllCTA() {billing.CheckViewAllCTAExistence(); }

        @Then("I should NOT see bar chart")
        public void iShouldNOTSeeBarChart() {billing.CheckBarChartDisplayed();
        }

        @Then("I should see bills")
        public void iShouldSeeBills() {
            billing.ValidateBillsNumber();
        }
}

package stepdefs.Billing;

import core.Config;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.NewBilling.DirectDebitAbstract;
import pages.NewBilling.DirectDebitLogicAndroid;
import pages.NewBilling.DirectDebitLogicIOS;

public class DirectDebitStepDef {

    public DirectDebitAbstract directDebitAbstract;

    public DirectDebitStepDef(Config config) {
        if (config.isAndroid()) directDebitAbstract = new DirectDebitLogicAndroid();
        if (config.isIos()) directDebitAbstract = new DirectDebitLogicIOS();
    }

    @Then("Validate Direct Debit Card UI")
    public void validateDirectDebitUI(){
        directDebitAbstract.validateDirectDebitCardUI();
    }

    @When("Click on Direct Debit CTA")
    public void clickOnDirectDebit(){
       directDebitAbstract.clickOnDirectDebit();
    }

    @Then("Validate Direct Debit SSO screen is displayed")
    public void checkOnDirectDebitScreen()  {
      directDebitAbstract.checkOnDirectDebitScreen();
    }

    @Then("Validate Direct debit SSO Close btn")
    public void validateDirectDebitSSOXBtn() {
        directDebitAbstract.validateDirectDebitSSOXBtn();

    }

}

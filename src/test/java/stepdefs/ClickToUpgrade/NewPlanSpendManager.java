package stepdefs.ClickToUpgrade;

import core.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.ClickToUpgrade.NewPlanSpendManager.NewPlanSpendManagerAbstract;
import pages.ClickToUpgrade.NewPlanSpendManager.NewPlanSpendManagerAndroid;
import pages.ClickToUpgrade.NewPlanSpendManager.NewPlanSpendManagerIOS;

public class NewPlanSpendManager {
    NewPlanSpendManagerAbstract NewPlanSpendManager;

    public NewPlanSpendManager(Config config)
    {
        if ( config.isAndroid())
        {
           NewPlanSpendManager = new NewPlanSpendManagerAndroid();
        }
        if (config.isIos())
        {
            NewPlanSpendManager = new NewPlanSpendManagerIOS();
        }
    }

    @And("Scroll Down till the end of the page")
    public void ScrollDownTillTheEndOfThePage(){
        NewPlanSpendManager.scrollToSpendManager();
    }

    @Then("Verify The Title")
    public void VerifyTheTitle()
    {
        NewPlanSpendManager.VerifyTheTitle();
    }
    @And("Verify The Descriptive Text Exist")
    public void VerifyTheDescriptiveTextExist()
    {
        NewPlanSpendManager.VerifyTheDescriptiveTextExist();
    }

    @Then("Verify The Price Label Is Correct")
    public void VerifyThePriceLabelIsCorrect()
    {
        NewPlanSpendManager.VerifyThePriceLabelIsCorrect();
    }
    @And("Verify The Plan Price Exist")
    public void VerifyThePlanPriceExist()
    {
        NewPlanSpendManager.VerifyThePlanPriceExist();
    }

    @And("Verify The Plan Price Cycle Per Month")
    public void VerifyThePlanPriceCyclePerMonth()
    {
        NewPlanSpendManager.VerifyThePlanPriceCyclePerMonth();
    }
    @Then("Verify The Spend Limit Label Exist")
    public void VerifyTheSpendLimitLabelExist()
    {
        NewPlanSpendManager.VerifyTheSpendLimitLabelExist();
    }

    @And("Validate The Default Value For Spend Limit Menu")
    public void ValidateTheDefaultValueForSpendLimitMenu()
    {
        NewPlanSpendManager.ValidateTheDefaultValueForSpendLimitMenu();
    }
    @Then("Verify The Green Box Appears With Check mark After Selecting The Value")
    public void VerifyTheGreenBoxAppearsWithCheckmarkAfterSelectingTheValue()
    {
        NewPlanSpendManager.VerifyTheGreenBoxAppearsWithCheckmarkAfterSelectingTheValue();
    }

}

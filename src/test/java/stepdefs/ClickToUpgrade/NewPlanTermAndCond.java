package stepdefs.ClickToUpgrade;

import core.Config;
import io.cucumber.java.en.And;
import pages.ClickToUpgrade.NewPlan.NewPlanAbstract;
import pages.ClickToUpgrade.NewPlan.NewPlanAndroid;
import pages.ClickToUpgrade.NewPlan.NewPlanIOS;


public class NewPlanTermAndCond {
    NewPlanAbstract newPlanPage;

    public NewPlanTermAndCond(Config config) {
        if (config.isAndroid()) {
            newPlanPage = new NewPlanAndroid();
        }

        if (config.isIos()) {
            newPlanPage = new NewPlanIOS();
        }
    }


    @And("terms and conditions section has correct details")
    public void termsAndConditionsSectionHasCorrectData() {
        newPlanPage.verifyThatNewPlanTermsAndConditionsContainsCorrectData();
    }

}

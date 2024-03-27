package stepdefs.ClickToUpgrade;

import core.Config;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ClickToUpgrade.NewPlan.NewPlanAbstract;
import pages.ClickToUpgrade.NewPlan.NewPlanAndroid;
import pages.ClickToUpgrade.NewPlan.NewPlanIOS;
import pages.ClickToUpgrade.RecommendedPlans.RecommendedPlansAbstract;
import pages.ClickToUpgrade.RecommendedPlans.RecommendedPlansAndroid;
import pages.ClickToUpgrade.RecommendedPlans.RecommendedPlansIOS;
import pages.DX_IDM.FullLogin.DX_IDM_FullLoginLogic_Abstract;
import pages.DX_IDM.FullLogin.DX_IDM_FullLoginLogic_Android;
import pages.DX_IDM.FullLogin.DX_IDM_FullLoginLogic_IOS;


public class ChooseThisPlanCTA {
    DX_IDM_FullLoginLogic_Abstract dxidmFullLogin;
    RecommendedPlansAbstract recommendedPlansPage;
    NewPlanAbstract newPlanPage;

    public ChooseThisPlanCTA(Config config) {
        if (config.isAndroid()) {
            dxidmFullLogin = new DX_IDM_FullLoginLogic_Android();
           recommendedPlansPage = new RecommendedPlansAndroid();
           newPlanPage = new NewPlanAndroid();
        }
        if (config.isIos()) {
            dxidmFullLogin = new DX_IDM_FullLoginLogic_IOS();
            recommendedPlansPage = new RecommendedPlansIOS();
            newPlanPage = new NewPlanIOS();
        }
    }

    /*@Given("I am MVA user and logged in using full login with user name and password")
    public void theUserLoginsToTheApp() {
        try {
            dxidmFullLogin.fullLoginWithUNandPW();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     */

    @When("the user selects a specific plan")
    public void theUserSelectsSpecificPlan() {
        recommendedPlansPage.chooseRecommendedPlan();
    }

    @Then("the user redirected to the new plan page")
    public void theUserRedirectedToTheNewPlanPage() {
        newPlanPage.verifyThatNewPlanPageTitleIsCorrect();
    }
}

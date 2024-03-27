package stepdefs.RedHybrid;


import core.Config;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.RedHybrid.ViewAddPlanWithExtras.RedHybrid_ViewAddPlanWithExtras_Abstract;
import pages.RedHybrid.ViewAddPlanWithExtras.RedHybrid_ViewAddPlanWithExtras_Android;
import pages.RedHybrid.ViewAddPlanWithExtras.RedHybrid_ViewAddPlanWithExtras_IOS;
import pages.RedHybrid.ViewAddPlanWithExtras.RedHybrid_ViewAddPlanWithExtras_PO;


import static core.Hooks.testAfterLastScenario;

public class ViewAddPlanCardWithExtras {

    RedHybrid_ViewAddPlanWithExtras_PO PO = new RedHybrid_ViewAddPlanWithExtras_PO();
    RedHybrid_ViewAddPlanWithExtras_Abstract RedHybridLogic;


    public ViewAddPlanCardWithExtras(Config config) {
        if (config.isAndroid()){
            RedHybridLogic = new RedHybrid_ViewAddPlanWithExtras_Android();
        }
        if (config.isIos()) {
            RedHybridLogic = new RedHybrid_ViewAddPlanWithExtras_IOS();
        }
    }


    @When("View Add plan Card when there is no Active Plan")
    public void viewAddPlanCard(){
        RedHybridLogic.validateAddPlanCard();
    }

    @Then("validate that the content of card appears successfully")
    public void viewAddPlanCardContent(){
        RedHybridLogic.validateAddPlanCardContent();
    }


    @Then("validate ability to swipe to view extras cards")
    public void validateExtrasCards(){
        RedHybridLogic.validateExtrasWithNoPlan();
    }

}

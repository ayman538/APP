package stepdefs.RedHybrid;
import core.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.RedHybrid.AddNewPlan_PaymentMethodOverlay.AddNewPlan_PaymentMethodOverlayLogic_Android;
import pages.RedHybrid.AddNewPlan_PaymentMethodOverlay.AddNewPlan_PaymentMethodOverlayLogic_IOS;
import pages.RedHybrid.AddNewPlan_PaymentMethodOverlay.AddNewPlan_PaymentMethodOverlay_Abstract;
public class AddNewPlan_PaymentMethodOverlay {
    private AddNewPlan_PaymentMethodOverlay_Abstract addNewPlan_paymentMethodOverlay_abstract ;

    public AddNewPlan_PaymentMethodOverlay(Config config){
        if(config.isAndroid()){
            addNewPlan_paymentMethodOverlay_abstract = new AddNewPlan_PaymentMethodOverlayLogic_Android();
        }
        if(config.isIos()){
            addNewPlan_paymentMethodOverlay_abstract = new AddNewPlan_PaymentMethodOverlayLogic_IOS();
        }
    }


    @Then("I should be navigated to Payment Method screen")
    public void userInPaymentMethodOverlay(){
        addNewPlan_paymentMethodOverlay_abstract.paymentMethodOverlayAppears();
        //re push
    }


    



    @Then("Check the UI of cell when user has one promoted plan or more")
    public void checkTheUIOfCellWhenUserHasOnePromotedPlanOrMore() {
        addNewPlan_paymentMethodOverlay_abstract.checkTheUIOfCellWithPromotedPlan();
        addNewPlan_paymentMethodOverlay_abstract.checkTheUIOfCellWithNopromotedPlans();
    }


    @Then("Check the response of hybrid bundles API with UI of the promoted plan")
    public void checkTheResponseOfHybridBundlesAPIWithUIOfThePromotedPlan() {
        addNewPlan_paymentMethodOverlay_abstract.checkTheUIOfCellWithNopromotedPlans();
    }

    @Then("I should click on Promos terms apply hyper link")
    public void iShouldClickOnPromosTermsApplyHyperLink() {
        addNewPlan_paymentMethodOverlay_abstract.clickOnPromosTermsApplyLink();
    }

    @And("I should be navigated to Promos terms Screen")
    public void iShouldBeNavigatedToPromosTermsScreen() {
        addNewPlan_paymentMethodOverlay_abstract.promosTermsScreen();
    }

    @Then("I should be navigated to Payment Method screen with title {string}")
    public void iShouldBeNavigatedToPaymentMethodScreenWithTitle(String title) {
        addNewPlan_paymentMethodOverlay_abstract.paymentMethodOverlayAppears(title);
    }
}

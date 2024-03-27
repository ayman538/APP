package stepdefs.RedHybrid;

import core.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DX_IDM.FullLogin.DX_IDM_FullLoginLogic_Abstract;
import pages.DX_IDM.FullLogin.DX_IDM_FullLoginLogic_Android;
import pages.DX_IDM.FullLogin.DX_IDM_FullLoginLogic_IOS;
import pages.RedHybrid.PaymentMethodOverlayNoPaymentMethodAdded.RedHybrid_PaymentMethodOverlayNoPaymentMethodAddedLogic_Android;
import pages.RedHybrid.PaymentMethodOverlayNoPaymentMethodAdded.RedHybrid_PaymentMethodOverlayNoPaymentMethodAddedLogic_IOS;
import pages.RedHybrid.PaymentMethodOverlayNoPaymentMethodAdded.RedHybrid_PaymentMethodOverlayNoPaymentMethodAdded_Abstract;

public class PaymentMethodOverlayNoPaymentAdded {
    RedHybrid_PaymentMethodOverlayNoPaymentMethodAdded_Abstract redHybridPaymentMethodOverlayNoPaymentMethodAddedAbstract;
    DX_IDM_FullLoginLogic_Abstract dx_idm_fullLoginLogic_abstract;
    boolean isIos;

    public PaymentMethodOverlayNoPaymentAdded(Config config) {
        if (config.isAndroid()) {
            redHybridPaymentMethodOverlayNoPaymentMethodAddedAbstract = new RedHybrid_PaymentMethodOverlayNoPaymentMethodAddedLogic_Android();
            dx_idm_fullLoginLogic_abstract = new DX_IDM_FullLoginLogic_Android();
        }
        if (config.isIos()) {
            redHybridPaymentMethodOverlayNoPaymentMethodAddedAbstract = new RedHybrid_PaymentMethodOverlayNoPaymentMethodAddedLogic_IOS();
            dx_idm_fullLoginLogic_abstract = new DX_IDM_FullLoginLogic_IOS();
            isIos = true;

        }

    }


    @Given("User full login")
    public void userFullLogin() {
        try {
            dx_idm_fullLoginLogic_abstract.fullLoginWithUserNameAndPwdAndAcceptCookies();
        } catch (Exception e) {
            System.out.println("User already logged in");
        }
    }


    @Given("user is on dashboard")
    public void redHybridUserIsOnDashboard() {
        redHybridPaymentMethodOverlayNoPaymentMethodAddedAbstract.redHybridUserOnDashboard();
    }

    @When("I should see the no plan added card")
    public void noPlanTextAppears() {
        redHybridPaymentMethodOverlayNoPaymentMethodAddedAbstract.noPlanAddedValidation();
    }

    @And("I click on tap here to select a plan")
    public void redHybridUserClicksOnAddNewPlanCTA() {
        redHybridPaymentMethodOverlayNoPaymentMethodAddedAbstract.addNewPlan();
    }

    @And("I should be navigated to Add New Plan screen with default plan selected")
    public void addNewPlanScreenAppearsAndPlanIsSelected() {
        redHybridPaymentMethodOverlayNoPaymentMethodAddedAbstract.planChoosed();
    }

    @Given("I clicks on Add New Plan screen Continue CTA")
    public void clickOnAddNewPlanScreenContinueCTA() throws InterruptedException {
        redHybridPaymentMethodOverlayNoPaymentMethodAddedAbstract.clickContinueInAddNewPlanScreen();
        if (isIos == true) {
            try {
                dx_idm_fullLoginLogic_abstract.loginWithBioUserNameAndPwd();
            } catch (Exception e) {
                System.out.println("User not logged in");
            }
        }
    }


    @When("call beginCardPayment MVAX API")
    public void callBeginCardPaymentMVAXAPI() {
        redHybridPaymentMethodOverlayNoPaymentMethodAddedAbstract.callBeginCardPaymentAPI();
    }

    @And("No payment method overlay appears")
    public void noPaymentMethodOverlayAppears() {
        redHybridPaymentMethodOverlayNoPaymentMethodAddedAbstract.noPaymentMethodIsVisible();
    }

    @Then("UI of the noPaymentMethod screen must be compatible with the response of beginCardPayment MVAX API")
    public void uiOfTheNoPaymentMethodScreenMustBeCompatibleWithTheResponseOfBeginCardPaymentMVAXAPI() {
        redHybridPaymentMethodOverlayNoPaymentMethodAddedAbstract.noPaymentMethodOverlayUIValidation();
    }

    @Then("beginCardPayment API response check in case no payment method added")
    public void beginCardPaymentAPIResponseCheckInCaseNoPaymentMethodAdded() {
        redHybridPaymentMethodOverlayNoPaymentMethodAddedAbstract.beginCardPaymentAPIresponseCheck();
    }


}

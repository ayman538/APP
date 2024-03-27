//package stepdefs.DX_IDM;
//
//import Pages.DX_IDM.SubscriptionSwitch.DX_IDM_SubscriptionSwitchLogic;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.When;
//import org.json.simple.parser.ParseException;
//import java.io.IOException;
//
//public class SubscriptionSwitch {
//    DX_IDM_SubscriptionSwitchLogic SubsSwitchLogic;
//
//    @Given("Init DX IDM Subscription Switch")
//    public void initDXIDMSubscriptionSwitch() throws IOException {
//        SubsSwitchLogic = new DX_IDM_SubscriptionSwitchLogic();
//    }
//
//    @Given("Navigate To My Account")
//    public void navigateToMyAccount() throws InterruptedException {
//        SubsSwitchLogic.navigateToMyAccount();
//    }
//
//    @When("Tap On FLN Card And Validate Selected Subscription Dashboard")
//    public void tapOnFLNCardAndValidateSelectedSubscriptionDashboard() throws ParseException {
//        SubsSwitchLogic.SwitchSubscription("FLN");
//    }
//
//    @When("Tap On BB Card And Validate Selected Subscription Dashboard")
//    public void tapOnBBCardAndValidateSelectedSubscriptionDashboard() throws ParseException {
//        SubsSwitchLogic.SwitchSubscription("BB");
//    }
//
//    @When("Tap On PAYM Card And Validate Selected Subscription Dashboard")
//    public void tapOnPAYMCardAndValidateSelectedSubscriptionDashboard() throws ParseException {
//        SubsSwitchLogic.SwitchSubscription("PAYM");
//    }
//
//    @When("Tap On SMB Card And Validate Selected Subscription Dashboard")
//    public void tapOnSMBCardAndValidateSelectedSubscriptionDashboard() throws ParseException {
//        SubsSwitchLogic.SwitchSubscription("SMB");
//    }
//
//    @When("Tap On SoleTrader Card And Validate Selected Subscription Dashboard")
//    public void tapOnSoleTraderCardAndValidateSelectedSubscriptionDashboard() throws ParseException {
//        SubsSwitchLogic.SwitchSubscription("SoleTrader");
//    }
//
//    @When("Tap On PAYG Card And Validate Selected Subscription Dashboard")
//    public void tapOnPAYGCardAndValidateSelectedSubscriptionDashboard() throws ParseException {
//        SubsSwitchLogic.SwitchSubscription("PAYG");
//    }
//
//}
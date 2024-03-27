package stepdefs.RedHybrid;

import core.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.RedHybrid.PaymentReminderOverlay.RedHybrid_PaymentReminderOverlay_Abstract;
import pages.RedHybrid.PaymentReminderOverlay.RedHybrid_PaymentReminderOverlay_Android;
import pages.RedHybrid.PaymentReminderOverlay.RedHybrid_PaymentReminderOverlay_IOS;
import pages.RedHybrid.RedHybrid_ChangeNextPlan_AddPaymentMethod.RedHybrid_ChangeNextPlan_AddPaymentMethod_Abstract;
import pages.RedHybrid.RedHybrid_ChangeNextPlan_AddPaymentMethod.RedHybrid_ChangeNextPlan_AddPaymentMethod_Android;
import pages.RedHybrid.RedHybrid_ChangeNextPlan_AddPaymentMethod.RedHybrid_ChangeNextPlan_AddPaymentMethod_IOS;

public class RedHybrid_ChangeNextPlan_AddPaymentMethod {

    RedHybrid_ChangeNextPlan_AddPaymentMethod_Abstract abstractLogic;
    private RedHybrid_PaymentReminderOverlay_Abstract redHybrid_paymentReminderOverlay_abstract;

    public RedHybrid_ChangeNextPlan_AddPaymentMethod(Config config){
        if (config.isAndroid()){
            abstractLogic = new RedHybrid_ChangeNextPlan_AddPaymentMethod_Android();
            redHybrid_paymentReminderOverlay_abstract = new RedHybrid_PaymentReminderOverlay_Android();
        }
        if (config.isIos()){
            abstractLogic = new RedHybrid_ChangeNextPlan_AddPaymentMethod_IOS();
            redHybrid_paymentReminderOverlay_abstract = new RedHybrid_PaymentReminderOverlay_IOS();
        }
    }
    @When("User Navigate to Plan Tab")
    public void Navigate_to_Plan_Tab(){
        try{
            redHybrid_paymentReminderOverlay_abstract.clickOnBackToVodafoneCTA();
        }catch (Exception e){
            System.out.println("No Payment Reminder Overlay");
        }
        abstractLogic.NavigateToPlanTab();
    }

    @And("Clicked on Change Plan CTA")
    public void Click_on_Change_Plan_CTA(){
        abstractLogic.ClickOnChangePlanCTA();
    }


    @When("User clicked on change next plan in quick links menu")
    public void Click_on_change_plan_in_quick_links(){
        abstractLogic.ClickOnChangePlanQuickLinks();
    }


    @And("I should not see the Skip CTA")
    public void Click_on_Skip_CTA(){
        abstractLogic.SkipCTAShouldNotAppears();
    }

    @Then("user should be redirected to Change next plan overlay")
    public void Check_Content_Of_Change_Next_Plan_Overlay(){
        abstractLogic.Check_Content_Of_Change_Next_Plan_Overlay();
    }
}

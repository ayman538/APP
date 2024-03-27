package pages.RedHybrid.PaymentReminderOverlay;


import models.response.DashboardV4ResponseModel;
import utils.DashboardUtils;

import static utils.element_helpers.DriverHelps.startActivity;
import static utils.element_helpers.ActionsHelpers.tapAtt;
import java.util.Properties;

import static core.Config.getUnknownUser;
import static utilities.PropertiesLoader.readPropertyFile;
import static utils.element_helpers.VerifyHelpers.AssertDisplayed;
import static utils.element_helpers.VerifyHelpers.assertEquals;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

public class RedHybrid_PaymentReminderOverlay_IOS extends RedHybrid_PaymentReminderOverlay_Abstract{
    public RedHybrid_PaymentReminderOverlay_IOS() {super();}
    DashboardV4ResponseModel DashboardResponse ;
    public static boolean isLoginPrompt = true;
    Properties envProp = readPropertyFile("config/env.properties");

    @Override
    public void checkReminderOverlayUI() throws InterruptedException {
        Thread.sleep(2000);
        AssertDisplayed(RedHybrid_reminderCloseButton.isDisplayed());

        DashboardResponse = DashboardUtils.GetDashboard();
        // assert Reminder Title
        String ActualReminderTitle = DashboardResponse.userMessage.title ;
        String ExpectedReminderTitle=RedHybrid_reminderTitle.getText();
        assertEquals(ActualReminderTitle,ExpectedReminderTitle);


        // assert Reminder body
        String ActualReminderBody=DashboardResponse.userMessage.description;
        String ExpectedReminderBody=RedHybrid_reminderBody.getText() ;
        assertEquals(ActualReminderBody,ExpectedReminderBody);

        //assert on add paymeny card CTA
        //String ExpectedAddPaymentCardCTA=RedHybrid_AddPaymentReminderCTA.getText();
        String expectedReminderCTA = reminderCTA.getText();
        String ActualAddPaymentCardCTA=DashboardResponse.userMessage.actions.get(0).text;
        assertEquals(expectedReminderCTA,ActualAddPaymentCardCTA);

        //assert on Return to My Vodafone CTA

        //String ExpectedReturnToMyVodafoneCTA=RedHybrid_AddPaymentReminderCTAs.get(1).getText();
        String expectedReturnToMyVodafoneCTA = returnToMyVodafoneCTA.getText();
        String ActualReturnToMyVodafoneCTA=DashboardResponse.userMessage.actions.get(1).text;
        assertEquals(expectedReturnToMyVodafoneCTA,ActualReturnToMyVodafoneCTA);

    }

    @Override
    public void clickOnCloseButton() {
        waitForVisibility(RedHybrid_reminderCloseButton);
        RedHybrid_reminderCloseButton.click();

    }

    @Override
    public void clickOnAddPaymentCTA() {
        waitForVisibility(RedHybrid_reminderOverlayIcon);
        reminderCTA.click();
    }

    @Override
    public void clickOnBackToVodafoneCTA() {
        waitForVisibility(returnToMyVodafoneCTA);
        returnToMyVodafoneCTA.click();

    }

    @Override
    public void validateAddPaymentScreen() {
        waitForVisibility(RedHybrid_AddCardDrawer);
        assertEquals("Payments",RedHybrid_AddCardTitle.getText());
        assertEquals("Add a new card",RedHybrid_AddCardCTA.getText());
        assertEquals(true,RedHybrid_AddCardCTA.isEnabled());
    }

    @Override
    public void dissmissAddPayment() {
        RedHybrid_BottomSheetDismissCTA.click();
    }

    @Override
    public void clickOnRemovePaymentCTA() {
        waitForVisibility(RedHybrid_editCancelCTA);
        RedHybrid_editCancelCTA.click();
        waitForVisibility(RedHybrid_RemoveCardCTA);
        RedHybrid_RemoveCardCTA.click();
        System.out.println("RedHybrid_RemoveCTA   "+ RedHybrid_RemoveCTA.getText());

        int x_start = RedHybrid_RemoveCTA.getLocation().getX();
        int x_remove_center =x_start +  RedHybrid_RemoveCTA.getSize().getWidth();
        int x_center = (x_remove_center + x_start) /2 ;
        int y_start = RedHybrid_RemoveCTA.getLocation().getY();
        int y_remove_center = y_start +  RedHybrid_RemoveCTA.getSize().getHeight();
        int y_center  = (y_remove_center + y_start) /2 ;
        tapAtt(x_center, y_center);
        waitForVisibility(RedHybrid_PaymentAddCTA);
    }


    @Override
    public void hardCloseAppAndLaunchIt() throws InterruptedException {
        Thread.sleep(9000);
        startActivity();
        Thread.sleep(9000);
        closePrompt();
    }

    @Override
    public void ValidatePaymentOverlay() {
        DashboardResponse = DashboardUtils.GetDashboard();
        waitForVisibility(RedHybrid_reminderOverlayIcon);
        assertEquals(DashboardResponse.userMessage.actions.get(0).text,reminderCTA.getText());
        assertEquals(DashboardResponse.userMessage.title,RedHybrid_reminderTitle.getText());
        assertEquals(true,reminderCTA.isEnabled());
    }
    public void closePrompt(){
        if (!(System.getProperty("Segment", envProp.getProperty("Segment")).contains("PREPAY"))
                && (!getUnknownUser().equalsIgnoreCase("True"))){
            if(isLoginPrompt){
                    ClickOnSkipSoftLoginPrompt();
                    isLoginPrompt = false;
            }
        }
    }

    @Override
    public void ClickOnSkipSoftLoginPrompt() {
        try{
            waitForVisibility(SoftLoginPrompt_CloseCTA);
            SoftLoginPrompt_CloseCTA.click();
            System.out.println("Soft Login Prompt skipped");
        }catch (Exception e){
            System.out.println("Soft Login Prompt didn't appear");
        }
    }

}

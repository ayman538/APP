package pages.RedHybrid.PaymentReminderOverlay;

import models.response.DashboardV4ResponseModel;
import utils.DashboardUtils;

import static utils.element_helpers.DriverHelps.startActivity;
import java.util.Properties;

import static core.Config.getUnknownUser;
import static utilities.PropertiesLoader.readPropertyFile;
import static utils.element_helpers.VerifyHelpers.assertEquals;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

public class RedHybrid_PaymentReminderOverlay_Android extends RedHybrid_PaymentReminderOverlay_Abstract{
    public RedHybrid_PaymentReminderOverlay_Android() {super();}

    DashboardV4ResponseModel DashboardResponse;
    public static boolean isLoginPrompt = true;
    Properties envProp = readPropertyFile("config/env.properties");

    @Override
    public void checkReminderOverlayUI() throws InterruptedException {
        Thread.sleep(2000);

        assertEquals(true,RedHybrid_reminderCloseButton.isDisplayed());
        DashboardResponse = DashboardUtils.GetDashboard();

        // assert Reminder Title
        String ActualReminderTitle = DashboardResponse.userMessage.title;
        String ExpectedReminderTitle=RedHybrid_reminderTitle.getText();
        assertEquals(ActualReminderTitle,ExpectedReminderTitle);

        // assert Reminder Body
        String ActualReminderBody = DashboardResponse.userMessage.description ;
        String ExpectedReminderBody =RedHybrid_reminderBody.getText();
        assertEquals(ActualReminderBody,ExpectedReminderBody);

        //assert on Turn on auto renew CTA
        //String ExpectedTurnOnAutoRenewCTA=AutoRenewCTAs.get(0).getText();
        String ActualTurnOnAutoRenewCTA=DashboardResponse.userMessage.actions.get(0).text;
        String expectedReminderCTA = reminderCTAs.get(0).getText();
        assertEquals(expectedReminderCTA,ActualTurnOnAutoRenewCTA);

        //assert on Return to My Vodafone CTA
        //String ExpectedReturnToMyVodafoneCTA=AutoRenewCTAs.get(1).getText();
        String expectedReturnToMyVodafoneCTA = reminderCTAs.get(1).getText();
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
        waitForVisibility(reminderCTAs.get(0));
        reminderCTAs.get(0).click();

    }


    @Override
    public void clickOnBackToVodafoneCTA() {
        waitForVisibility(returnToMyVodafoneCTA);
        returnToMyVodafoneCTA.click();

    }

    @Override
    public void validateAddPaymentScreen() throws InterruptedException {
        Thread.sleep(3000);
        waitForVisibility(RedHybrid_AddCardDrawer);
        assertEquals("Payments",RedHybrid_AddCardTitle.getText());
        assertEquals("Add a new card",RedHybrid_AddCardCTA.getText());
        assertEquals(true,RedHybrid_AddCardCTA.isEnabled());
    }

    @Override
    public void dissmissAddPayment() {
        waitForVisibility(RedHybrid_BottomSheetDismissCTA);
        RedHybrid_BottomSheetDismissCTA.click();

    }

    @Override
    public void clickOnRemovePaymentCTA() {
        waitForVisibility(RedHybrid_editCancelCTA);
        RedHybrid_editCancelCTA.click();
        waitForVisibility(RedHybrid_RemoveCardCTA);
        RedHybrid_RemoveCardCTA.click();
        RedHybrid_RemoveCTA.click();
        waitForVisibility(RedHybrid_PaymentAddCTA);
    }


    @Override
    public void hardCloseAppAndLaunchIt() throws InterruptedException {
        Thread.sleep(3000);
        startActivity();
        Thread.sleep(3000);
        closePrompt();
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
    public void ValidatePaymentOverlay() {
        DashboardResponse = DashboardUtils.GetDashboard();
        waitForVisibility(RedHybrid_reminderOverlayIcon);
        assertEquals(DashboardResponse.userMessage.actions.get(0).text,reminderCTA.getText());
        assertEquals(DashboardResponse.userMessage.title,RedHybrid_reminderTitle.getText());
        assertEquals(true,reminderCTAs.get(0).isEnabled());

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

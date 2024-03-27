package pages.RedHybrid.AutoRenewReminder;

import models.response.DashboardV4ResponseModel;
import org.testng.Assert;
import utils.DashboardUtils;

import static utils.element_helpers.VerifyHelpers.AssertDisplayed;
import static utils.element_helpers.VerifyHelpers.assertEquals;
import static utils.element_helpers.WaitHelpers.waitForVisibility;


public class AutoRenewReminderIOS extends AutoRenewReminderOverlayAbstract {

    DashboardV4ResponseModel DashboardResponse ;
    public AutoRenewReminderIOS(){ super();}

    @Override
    public void checkAutoRenewOverlayUI() throws InterruptedException {
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

        //remaining days in the Overlay
        String remainingDays = DashboardResponse.tiles.get(1).content.get(0).footer;
        String actualRemainingDays = remainingDays.replace("Expires ","");
        Assert.assertTrue(ExpectedReminderBody.contains(actualRemainingDays));

        //assert on Turn on auto renew CTA
        String ActualTurnOnAutoRenewCTA=DashboardResponse.userMessage.actions.get(0).text;
        String expectedReminderCTA = reminderCTA.getText();
        assertEquals(expectedReminderCTA,ActualTurnOnAutoRenewCTA);

        //assert on Return to My Vodafone CTA
        String expectedReturnToMyVodafoneCTA = returnToMyVodafoneCTA.getText();
        String ActualReturnToMyVodafoneCTA=DashboardResponse.userMessage.actions.get(1).text;
        assertEquals(expectedReturnToMyVodafoneCTA,ActualReturnToMyVodafoneCTA);

    }

    @Override
    public void clickOnTurnOnCTA() {
        waitForVisibility(RedHybrid_reminderOverlayIcon);
        reminderCTA.click();
    }

    @Override
    public void planTabIsDisplayed() {
        AssertDisplayed(planTab.isDisplayed());
        waitForVisibility(planTitle);
        assertEquals("Your plan",planTitle.getText());
    }
}

package pages.RedHybrid.AddNewPlan_AddPaymentMethodBeforeJourney;

import com.fasterxml.jackson.core.JsonProcessingException;
import models.response.CalculateJourneyResponseModel;
import models.response.DashboardV4ResponseModel;
import org.testng.Assert;
import utils.CalculateJourneyUtils;
import utils.DashboardUtils;

import java.util.HashMap;

import static utils.element_helpers.ActionsHelpers.doubleClick;
import static utils.element_helpers.VerifyHelpers.AssertDisplayed;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

public class AddNewPlanAddPaymentMethodBeforeJourneyLogic_IOS extends AddNewPlan_AddPaymentMethodBeforeJourney_Abstract {

    DashboardV4ResponseModel dashboardV4ResponseModel;
    CalculateJourneyResponseModel calculateJourneyResponseModel;
    HashMap<String, String> headers = new HashMap<>();

    public AddNewPlanAddPaymentMethodBeforeJourneyLogic_IOS(){super();}

    @Override
    public void ValidateContentOfOverlay(String ProcessType, String requestedActionValue) throws JsonProcessingException {
        dashboardV4ResponseModel = DashboardUtils.GetDashboardRedHybrid();

        // calling of Calculate Journey API
        headers.put("requestedAction", requestedActionValue);
        calculateJourneyResponseModel = CalculateJourneyUtils.CalculateJourney(headers);

        if(ProcessType.equalsIgnoreCase("Add a new payment method")){
            waitForVisibility(RedHybrid_PaymentOverlayTitle);

            Assert.assertTrue(RedHybrid_PaymentOverlayTitle.isDisplayed());
            Assert.assertTrue(RedHybrid_PaymentOverlayDesc.isDisplayed());
            Assert.assertTrue(RedHybrid_PaymentOverlayAddCardCTA.isDisplayed());
            Assert.assertTrue(RedHybrid_PaymentOverlayXCTA.isDisplayed());

            Assert.assertEquals(RedHybrid_PaymentOverlayTitle.getText(),
                    calculateJourneyResponseModel.nextJourneyCard.title);
            Assert.assertEquals(RedHybrid_PaymentOverlayDesc.getText(),
                    calculateJourneyResponseModel.nextJourneyCard.description);
            Assert.assertEquals(RedHybrid_PaymentOverlayAddCardCTA.getText(),
                    calculateJourneyResponseModel.nextJourneyCard.actions.get(0).text);

        }else if (ProcessType.equalsIgnoreCase("Turn on Auto-Renew Toggle")){
            AssertDisplayed(changePlanChoosePlanHeader.isDisplayed());

            Assert.assertTrue(changePlanChoosePlanHeader.isDisplayed());
            Assert.assertTrue(traySuccessNotification.isDisplayed());
            AssertDisplayed(RedHybrid_SuccessTik.isDisplayed());
            Assert.assertTrue(traySuccessSubNotification.isDisplayed());


            Assert.assertEquals(changePlanChoosePlanHeader.getText(),
                    calculateJourneyResponseModel.nextJourneyCard.title);
            Assert.assertEquals(traySuccessNotification.getText(),
                    calculateJourneyResponseModel.nextJourneyCard.description);
            Assert.assertEquals(traySuccessSubNotification.getText(),
                    calculateJourneyResponseModel.nextJourneyCard.subDescription);
            Assert.assertEquals(RH_TurnOnToggleCTA.getText(),
                    calculateJourneyResponseModel.nextJourneyCard.actions.get(0).text);
            Assert.assertEquals(CloseCTA.getText(),
                    calculateJourneyResponseModel.nextJourneyCard.actions.get(1).text);
        }
    }



    @Override
    public void ClickOnAddNewCardCTA() {
        waitForVisibility(RedHybrid_PaymentOverlayAddCardCTA);
        RedHybrid_PaymentOverlayAddCardCTA.click();
    }

    @Override
    public void CheckFlexiPlansScreen() {
        AssertDisplayed(RedHybrid_AddPlanOverlayTitle.isDisplayed());
        Assert.assertTrue(RedHybrid_AddPlanOverlayTitle.getText().equalsIgnoreCase("Add Plus plan"));
        AssertDisplayed(RedHybrid_AddPlanOverlaySubTitle.isDisplayed());
        Assert.assertTrue(RedHybrid_AddPlanOverlaySubTitle.getText().contains("All Plus plans are valid for 30 days and come with unlimited calls and texts."));
        RedHybrid_AddPlanOverlayContinueCTA.isDisplayed();
        RedHybrid_AddPlanOverlayContinueCTA.isEnabled();
        AssertDisplayed(RedHybrid_AddPlanOverlayLink.isDisplayed());
        Assert.assertTrue(RedHybrid_AddPlanOverlayLink.getText().equalsIgnoreCase("View plan details"));
        doubleClick(RedHybrid_AddPlanOverlayLink);
        Assert.assertEquals("How our Flexi plans work",webviewTitle.getText());
        WV_Xicon.click();
    }

    @Override
    public void ClickOnXCTA() {
        waitForVisibility(RedHybrid_PaymentOverlayXCTA);
        RedHybrid_PaymentOverlayXCTA.click();
    }
}

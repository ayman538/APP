package pages.RedHybrid.StayOnMyPlanFlow;

import com.fasterxml.jackson.core.JsonProcessingException;
import models.response.CreateOrderResponseModel;
import models.response.PlanV3ResponseModel;
import org.junit.jupiter.api.Assertions;
import org.testng.Assert;
import utils.CreateOrderUtils;
import utils.PlanUtils;

import java.util.HashMap;
import java.util.Map;
import static utils.element_helpers.ActionsHelpers.*;
import static utils.element_helpers.VerifyHelpers.*;
import static utils.element_helpers.WaitHelpers.*;
import static utils.element_helpers.ScrollHelpers.*;
import static utils.element_helpers.TextHelpers.*;
import static utils.element_helpers.GenericHelpers.*;


public class StayOnMyPlan_Android extends StayOnMyPlan_Abstract {

    public PlanV3ResponseModel planV3ResponseModel;
    Map<String, String> headers;
    String orderTypeKey = "orderType";
    String contentTypeKey = "Content-Type";
    String contentTypeValue = "application/json;charset=UTF-8";
    String orderType = "cancel-nextOrder";
    CreateOrderResponseModel createOrderResponseModel;


    public StayOnMyPlan_Android() {
        super();
    }


    public void clickOnStayOnMyPlanCTAFromTealCard() {
        waitForVisibility(RedHybrid_TealCardCTA);
        RedHybrid_TealCardCTA.click();
    }

    public void validateStayOnMyPlanOrNotTrayContent() {
        waitForVisibility(changePlanChoosePlanHeader);
        CheckContentOfStaOnMyPlanTrayUI();
        CheckContentOfStaOnMyPlanTrayAPI();
    }



    public void chooseToStayOnTheCurrentPlan(){
        waitForVisibility(RedHybrid_StayOnMyPlanOrNOTTrayStayOnCurrentPlanCTA);
        RedHybrid_StayOnMyPlanOrNOTTrayStayOnCurrentPlanCTA.click();
    }

    public void ValidateStayOnCurrentPlanConfirmationTray() throws JsonProcessingException {
        createOrderResponseModel = ToGetCreateOrderResponse();
        waitForVisibility(ContinueCTA);
        AssertDisplayed(RedHybrid_CancelChangeNextPlanTrayTikIcon.isDisplayed());
        AssertDisplayed(RedHybrid_ConfirmationTrayDescription.isDisplayed());
        AssertDisplayed(RedHybrid_ConfirmationTraySubDescription.isDisplayed());
        AssertDisplayed(ContinueCTA.isDisplayed());

        // Validate Screen content retrieved form "createOrder" API
        Assert.assertEquals(createOrderResponseModel.nextJourneyCard.description,RedHybrid_ConfirmationTrayDescription.getText());
        Assert.assertEquals(createOrderResponseModel.nextJourneyCard.subDescription,RedHybrid_ConfirmationTraySubDescription.getText());
        Assert.assertEquals(createOrderResponseModel.nextJourneyCard.actions.get(0).text,ContinueCTA.getText());
        Assert.assertEquals(createOrderResponseModel.nextJourneyCard.iconId,"56");
    }


    public void clickOnNoThanks() {
        waitForVisibility(RedHybrid_StayOnMyPlanOrNOTTrayNoThanksCTA);
        RedHybrid_StayOnMyPlanOrNOTTrayNoThanksCTA.click();
    }


    public CreateOrderResponseModel ToGetCreateOrderResponse() throws JsonProcessingException {
        headers = new HashMap<String, String>() {{
            put(contentTypeKey, contentTypeValue);
            put(orderTypeKey, orderType);
        }};
        return CreateOrderUtils.getCreateOrderResponseChangeNextPlan("", headers);
    }

    public void CheckContentOfStaOnMyPlanTrayUI(){
        //to check title of overlay
        AssertDisplayed(changePlanChoosePlanHeader.isDisplayed());
        //to check x icon of overlay
        Assert.assertTrue(RedHybrid_BottomSheetDismissCTA.isDisplayed());
        //to check alert icon of overlay
        AssertDisplayed(RedHybrid_StayOnMyPlanOrNOTTrayIcon.isDisplayed());
        //to check description of overlay
        AssertDisplayed(RedHybrid_StayOnMyPlanOrNOTTrayHeader.isDisplayed());
        //to check sub description of overlay
        AssertDisplayed(RedHybrid_StayOnMyPlanOrNOTTrayDescription.isDisplayed());
        //to check text of first CTA of overlay
        AssertDisplayed(RedHybrid_StayOnMyPlanOrNOTTrayStayOnCurrentPlanCTA.isDisplayed());
        //to check text of second CTA of overlay
        Assert.assertTrue(RedHybrid_StayOnMyPlanOrNOTTrayNoThanksCTA.isDisplayed());
    }

    public void CheckContentOfStaOnMyPlanTrayAPI(){
        planV3ResponseModel = PlanUtils.GetPlanV3();

        //to check title of overlay
        Assert.assertEquals(changePlanChoosePlanHeader.getText(),
                planV3ResponseModel.cards.get(0).nextJourneysList.get(0).nextJourneyCardDto.title);

        //to check alert icon of overlay
        Assert.assertEquals(planV3ResponseModel.cards.get(0).nextJourneysList.get(0).nextJourneyCardDto.iconId,"10145");

        //to check description of overlay
        Assert.assertEquals(RedHybrid_StayOnMyPlanOrNOTTrayHeader.getText(),
                planV3ResponseModel.cards.get(0).nextJourneysList.get(0).nextJourneyCardDto.description);

        //to check sub description of overlay
        Assert.assertEquals(RedHybrid_StayOnMyPlanOrNOTTrayDescription.getText(),
                planV3ResponseModel.cards.get(0).nextJourneysList.get(0).nextJourneyCardDto.subDescription);

        //to check text of first CTA of overlay
        Assert.assertEquals(RedHybrid_StayOnMyPlanOrNOTTrayStayOnCurrentPlanCTA.getText(),
                planV3ResponseModel.cards.get(0).nextJourneysList.get(0).nextJourneyCardDto.actions.get(0).text);

        //to check text of second CTA of overlay
        Assert.assertEquals(RedHybrid_StayOnMyPlanOrNOTTrayNoThanksCTA.getText(),
                planV3ResponseModel.cards.get(0).nextJourneysList.get(0).nextJourneyCardDto.actions.get(1).text);

    }
}

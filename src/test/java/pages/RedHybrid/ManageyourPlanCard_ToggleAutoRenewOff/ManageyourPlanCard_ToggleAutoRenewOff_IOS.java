package pages.RedHybrid.ManageyourPlanCard_ToggleAutoRenewOff;

import com.fasterxml.jackson.core.JsonProcessingException;
import models.response.CreateOrderResponseModel;
import models.response.PlanV3ResponseModel;
import org.openqa.selenium.By;
import org.testng.Assert;
import utils.CreateOrderUtils;
import utils.PlanUtils;

import java.util.HashMap;
import java.util.Map;

import static utils.element_helpers.ActionsHelpers.doubleClick;
import static utils.element_helpers.GenericHelpers.openDeepLinkForiOS;
import static utils.element_helpers.ScrollHelpers.scrollDownTo;
import static utils.element_helpers.TextHelpers.GetXpath;
import static utils.element_helpers.VerifyHelpers.AssertDisplayed;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

public class ManageyourPlanCard_ToggleAutoRenewOff_IOS extends ManageyourPlanCard_ToggleAutoRenewOffAbstract {

    Map<String, String> headers;
    String autoRenewValue = "false";
    CreateOrderResponseModel createRenewOrderResponse;
    PlanV3ResponseModel planResponse;


    public ManageyourPlanCard_ToggleAutoRenewOff_IOS() {
        super();
    }

    public void scrollDownToMangeYourPlanCard() {
        scrollDownTo(ChangeYourPlanCTA);
    }

    @Override
    public void CheckUIOfManageYourPlanCard() {
        planResponse = PlanUtils.GetPlanV3();
        AssertDisplayed(ManageYourPlanTitle.isDisplayed());
        // toggle
        AssertDisplayed(ManageYourPlanToggle.isDisplayed());
        //payment card
        AssertDisplayed(ManageYourPlanPaymentCard.isDisplayed());
        //planEnds
        AssertDisplayed(ManageYourPlanAutoRenew.isDisplayed());
        String expectedManageYourPlanExpirationDate = planResponse.cards.get(1).sections.get(0).list.get(1).rightAlignedText;
        String actualManageYourPlanExpirationDate = driver.findElement(By.xpath(GetXpath(expectedManageYourPlanExpirationDate))).getText();
        System.out.println(actualManageYourPlanExpirationDate + "   date");
        Assert.assertEquals(expectedManageYourPlanExpirationDate, actualManageYourPlanExpirationDate);

        if (planResponse.cards.get(1).sections.get(0).list.get(0).rightAlignedItem.actions.get(0).journeyKey == "PLAN_RENEW_TOGGLE_ON"
                && planResponse.cards.get(1).sections.get(0).list.get(3).rightAlignedItem.actions.get(0).text != "Add card"
                && planResponse.cards.get(1).sections.get(0).list.get(2).leftAlignedText == "Amount"
        ) {
            // auto renew toggle on and card is added
            managePlanCardUIAutoRenewOn_CardAdded(planResponse);
        } else if (planResponse.cards.get(1).sections.get(0).list.get(0).rightAlignedItem.actions.get(0).journeyKey == "PLAN_RENEW_TOGGLE_OFF"
                && planResponse.cards.get(1).sections.get(0).list.get(3).rightAlignedItem.actions.get(0).text != "Add card") {
            // auto renew is off and card is added
            managePlanCardUIAutoRenewOFF_CardAdded(planResponse);
        } else if (planResponse.cards.get(1).sections.get(0).list.get(0).rightAlignedItem.actions.get(0).journeyKey == "PLAN_RENEW_TOGGLE_OFF"
                && planResponse.cards.get(1).sections.get(0).list.get(3).rightAlignedItem.actions.get(0).text == "Add card") {
            //auto renew off and card not added
            managePlanCardUIAutoRenewOFF_NoCardAdded(planResponse);
        }
        //Change plan Title
        AssertDisplayed(ChangeYourPlanTitle.isDisplayed());
        AssertDisplayed(ChangeYourPlanDescription.isDisplayed());
        AssertDisplayed(ChangeYourPlanCTA.isDisplayed());

    }


    public void managePlanCardUIAutoRenewOn_CardAdded(PlanV3ResponseModel planResponse) {
        // auto renew is on and card is added

        String expectedManageYourPlanCardNumber = planResponse.cards.get(1).sections.get(0).list.get(3).rightAlignedItem.paymentCardNumber.substring(planResponse.cards.get(1).sections.get(0).list.get(3).rightAlignedItem.paymentCardNumber.length() - 4);
        String actualManageYourPlanCardNumber = ManageYourPlanCardNumber.getText().substring(ManageYourPlanCardNumber.getText().length() - 4);
        Assert.assertEquals(expectedManageYourPlanCardNumber, actualManageYourPlanCardNumber);
        Assert.assertTrue(manageYourPlanAmount.isDisplayed());


    }

    public void managePlanCardUIAutoRenewOFF_NoCardAdded(PlanV3ResponseModel planResponse) {
        // auto renew is off and card is not added
        // check that the add card is displayed
        AssertDisplayed(addCardLink.isDisplayed());
        String expectedAddCardLink = planResponse.cards.get(1).sections.get(0).list.get(3).rightAlignedItem.actions.get(0).text;
        String actualAddCardLink = addCardLink.getText();
        Assert.assertEquals(expectedAddCardLink, actualAddCardLink);

    }

    public void managePlanCardUIAutoRenewOFF_CardAdded(PlanV3ResponseModel planResponse) {
        // auto renew is off and card is added
        AssertDisplayed(ManageYourPlanTitle.isDisplayed());
        // toggle

        //payment card
        AssertDisplayed(ManageYourPlanPaymentCard.isDisplayed());
        String expectedManageYourPlanCardNumber = planResponse.cards.get(1).sections.get(0).list.get(3).rightAlignedItem.paymentCardNumber.substring(planResponse.cards.get(1).sections.get(0).list.get(3).rightAlignedItem.paymentCardNumber.length() - 4);
        String actualManageYourPlanCardNumber = ManageYourPlanCardNumber.getText().substring(ManageYourPlanCardNumber.getText().length() - 4);
        Assert.assertEquals(expectedManageYourPlanCardNumber, actualManageYourPlanCardNumber);

    }

    @Override
    public void SwitchToggle() {
        waitForVisibility(ManageYourPlanToggle);
        doubleClick(ManageYourPlanToggle);
    }

    @Override
    public void checkThatDisclaimerMaskCard() throws JsonProcessingException {
//        scrollDownTo(DisclaimerMaskMsg);

        headers = new HashMap<String, String>() {{
            put("Content-Type", "application/json;charset=UTF-8");
        }};
        createRenewOrderResponse = CreateOrderUtils.getCreateOrderResponse(autoRenewValue, headers);

        String actualMaskDescription = DisclaimerMaskMsg.getText();
        System.out.println(" guid is :" + createRenewOrderResponse.status.analytics.guid);
        String expectedMaskDescription = createRenewOrderResponse.orderStatus.maskValue.description;
        Assert.assertEquals(actualMaskDescription, expectedMaskDescription);

    }

    @Override
    public void openDeepLinkForChangePlanForNextMonth() {
        openDeepLinkForiOS("myvodafone://CHANGE_NEXT_PLAN_RH_BUNDLES");

    }

    public void CheckAutoRenewConfirmationScreen() {
        waitForVisibility(ContinueCTA);
        AssertDisplayed(traySuccessNotification.isDisplayed());
        AssertDisplayed(thankYouTickIcon.isDisplayed());
        AssertDisplayed(traySuccessSubNotification.isDisplayed());
        AssertDisplayed(thankYouCloseIcon.isDisplayed());
        AssertDisplayed(ContinueCTA.isDisplayed());
    }


}

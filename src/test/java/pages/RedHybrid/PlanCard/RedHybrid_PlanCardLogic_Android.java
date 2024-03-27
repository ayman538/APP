package pages.RedHybrid.PlanCard;

import com.fasterxml.jackson.core.JsonProcessingException;
import models.response.CreateOrderResponseModel;
import models.response.DashboardV4ResponseModel;
import models.response.HybridBundelsResponseModel;
import models.response.PlanV3ResponseModel;
import org.openqa.selenium.By;
import org.testng.Assert;
import utils.CreateOrderUtils;
import utils.DashboardUtils;
import utils.HybridBundelsUtils;
import utils.PlanUtils;

import java.util.HashMap;
import java.util.Map;

import static utils.element_helpers.ScrollHelpers.*;
import static utils.element_helpers.VerifyHelpers.*;
import static utils.element_helpers.WaitHelpers.waitForVisibility;


public class RedHybrid_PlanCardLogic_Android extends RedHybrid_PlanCard {

    Map<String, String> headers, queryParam;
    String orderTypeKey = "orderType";
    String contentTypeKey = "Content-Type";
    String contentTypeValue = "application/json;charset=UTF-8";
    String orderType = "change-next";
    CreateOrderResponseModel createOrderResponseModel;
    HybridBundelsResponseModel hybridBundelsResponseModel;
    PlanV3ResponseModel planV3ResponseModel = new PlanV3ResponseModel();

    public RedHybrid_PlanCardLogic_Android() {
        super();
    }

    @Override
    public void navigateToPlan() throws InterruptedException {

        waitForVisibility(DB_SettingDashboardTray_icon);
        //  HideVOV(DB_VOVhideCTA);
        Thread.sleep(500);
        waitForVisibility(DBControlTile);
        scrollDownTo(DBControlTile);
        DBControlTile.click();
        waitForVisibility(SO_MSISDN);
        waitForVisibility(PlanTitle);
        AssertDisplayed(PlanTitle.isDisplayed());
    }

    @Override
    public void dashboardIsDisplayed() {
        waitForVisibility(RedHybrid_MyAccount);
    }

    @Override
    public void DismissPaymentMethodOverlay() {
        try {
            waitForVisibility(returnToMyVodafoneCTA);
            returnToMyVodafoneCTA.click();
        } catch (Exception e) {
            System.out.println("Add Payment Method overlay not appeared");

        }
    }

    @Override
    public void addCardHyperLinkValidation(String displayed) {
        if(displayed.equalsIgnoreCase("true")){
            Assert.assertTrue(add_card_link.isDisplayed());
        }
        else {
            System.out.println("The user has a payment method added");
        }
    }

    @Override
    public void ValidatePlanCardUI() {
        String RedHybridPlanTitle;
        String yourPlanTitle;
        PlanV3ResponseModel planV3ResponseModel;
        planV3ResponseModel = PlanUtils.GetPlanV3();

        RedHybridPlanTitle = planV3ResponseModel.cards.get(0).title;

        Assert.assertEquals(PlanTitle.getText(), RedHybridPlanTitle);

        try {
            yourPlanTitle = planV3ResponseModel.cards.get(0).sections.get(0).title;
            waitForVisibility(YourPlan);
            Assert.assertEquals(YourPlan.getText(), yourPlanTitle.replace("<b>", "").
                    replace("</b>", ""));
        } catch (Exception e) {
            System.out.println("User has no Includes");

        }

    }

    @Override
    public void ValidateIncludesDisplayingAfterClickingShowmore() {

        PlanV3ResponseModel Plan = PlanUtils.GetPlanV3();
        scrollUp();

        //if the user has includes on his plan
        if (Plan.cards.size() > 2) {
            Assert.assertEquals(IncludeTitle.getText(), Plan.cards.get(1).sections.get(2).title);
            if (Plan.cards.get(0).sections.get(1).list.size() <= 3) { //in cas user has 3 includes or less
                AssertDisplayed(!Includes_seeMore.isDisplayed());

            } else {
                //in cas user has more than 3 includes
                scrollDownTo(Includes_seeMore);
                Includes_seeMore.click();
                Assert.assertNotEquals(IncludesContainer.findElements(By.className("android.view.ViewGroup")).size(), 3);

            }
        }
        //if the user has no Includes on his plan
        else {
            System.out.println("User has no Includes");
        }
    }

    @Override
    public void userClosesSubsOverlay() {
        SO_Xicon.click();
    }


    // reflection and masking

    @Override
    public void validateMangeYourPlanMaskAfterChangingThePlan() throws JsonProcessingException {
        waitForVisibility(manageYourPlaneTitle);
        scrollDownTo(manageYourPlaneMaskDescription);
        Assert.assertTrue(manageYourPlaneMaskDescription.isDisplayed());


    }

    @Override
    public void uiOfScreenThatNotifyTheUserThatARequestIsBeingProcessed() {
        if(elementIsPresent(RedHybrid_PaymentOverlaySkipCTA)) {
            RedHybrid_PaymentOverlaySkipCTA.click();
            System.out.println("Add a payment method overlay appears");
        }
        waitForVisibility(processedRequestScreenDesc);
        Assert.assertTrue(processedRequestScreenDesc.isDisplayed());
        Assert.assertTrue(processedRequestScreenXCta.isDisplayed());
        AssertDisplayed(processedRequestScreenAlertIcon.isDisplayed());
    }

    public CreateOrderResponseModel ToGetCreateOrderResponse() throws JsonProcessingException {
        queryParam = new HashMap<String, String>() {{
            put(orderTypeKey, orderType);
        }};
        hybridBundelsResponseModel = HybridBundelsUtils.getHybridBundelsResponse(queryParam);
        String productId = hybridBundelsResponseModel.items.get(0).planId;

        headers = new HashMap<String, String>() {{
            put(contentTypeKey, contentTypeValue);
            put(orderTypeKey, orderType);
        }};

        return CreateOrderUtils.getCreateOrderResponseChangeNextPlan(productId, headers);
    }

    @Override
    public void checkContentOfTealCard() {
        planV3ResponseModel = PlanUtils.GetPlanV3();
        //  CTA Assertion
        String actualCTA = RedHybrid_TealCardCTA.getText();
        String expectedCTA = planV3ResponseModel.cards.get(0).actions.get(0).text;
        AssertResult(actualCTA, expectedCTA);

        //Title Assertion
        String actualTilte = RedHybrid_TealCardTitle.getText();
        String expectedTitle = planV3ResponseModel.cards.get(0).title.replace("<b>","");
        expectedTitle = expectedTitle.replace("</b>","");
        AssertResult(actualTilte, expectedTitle);

        AssertDisplayed(RedHybrid_TealCardDESC.isDisplayed());
        AssertDisplayed(RedHybrid_TealCardIcon.isDisplayed());
        AssertDisplayed(RedHybrid_TealCardCTA.isDisplayed());
        AssertDisplayed(RedHybrid_TealCardTitle.isDisplayed());


    }

    @Override
    public void iAmARedhybridUserWhoTurnsOffTheAutoRenewToggle() {

        scrollDown();
        waitForVisibility(RedHybrid_ManageYourPlanTitle);
        RedHybrid_AutoRenewToggle.click();
    }

    @Override
    public void validateContentOfPlanTab() {
        AssertDisplayed(RedHybrid_ManageYourPlanTitle.isDisplayed());
        assertElementDoesNotExist(RedHybrid_TealCardDESC);
    }
    @Override
    public void iShouldAbleToSeeThatReflectedPlanWithMessageOnThePlanTileAndTheResponceShouldBeAsPlanAPIResponse() {
        waitForVisibility(ChangeNextPlanMessage);
        DashboardV4ResponseModel dashboardV4ResponseModel;
        dashboardV4ResponseModel = DashboardUtils.GetDashboardRedHybrid();
        String expectedMessage= dashboardV4ResponseModel.tiles.get(1).content.get(0).footer;
        String actualMessage= ChangeNextPlanMessage.getText();
        AssertResult(expectedMessage,actualMessage);

    }

}


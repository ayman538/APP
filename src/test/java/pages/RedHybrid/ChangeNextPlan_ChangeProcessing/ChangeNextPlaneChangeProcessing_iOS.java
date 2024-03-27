package pages.RedHybrid.ChangeNextPlan_ChangeProcessing;

import com.fasterxml.jackson.core.JsonProcessingException;
import models.response.CreateOrderResponseModel;
import models.response.HybridBundelsResponseModel;
import org.testng.Assert;
import utils.CreateOrderUtils;
import utils.HybridBundelsUtils;

import java.util.HashMap;
import java.util.Map;

import static utils.element_helpers.ActionsHelpers.doubleClick;
import static utils.element_helpers.ScrollHelpers.scrollDownElementOverCenterScreen;
import static utils.element_helpers.VerifyHelpers.AssertDisplayed;
import static utils.element_helpers.VerifyHelpers.AssertResult;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

public class ChangeNextPlaneChangeProcessing_iOS extends ChangeNextPlaneChangeProcessing_Abstract {
    Map<String, String> headers, queryParam;
    String autoRenewValue = "false";
    String orderTypeKey = "orderType";
    String contentTypeKey = "Content-Type";
    String contentTypeValue = "application/json;charset=UTF-8";
    String orderType = "change-next";
    CreateOrderResponseModel createOrderResponseModel;
    HybridBundelsResponseModel hybridBundelsResponseModel;
    public ChangeNextPlaneChangeProcessing_iOS() {
        super();
    }

    @Override
    public void clickOnChangePlanForNextMonth() {
        waitForVisibility(quickLinkChangePlan);
        doubleClick(quickLinkChangePlan);
        try {
            waitForVisibility(changePlanChoosePlanPlanItem);
            AssertDisplayed(changePlanChoosePlanPlanItem.isDisplayed());
        }catch (Exception e){
            waitForVisibility(RedHybrid_PaymentOverlaySkipCTA);
            RedHybrid_PaymentOverlaySkipCTA.click();
            waitForVisibility(changePlanChoosePlanPlanItem);
        }
    }


    @Override
    public void clickOnConfirmNextPlanCTA() {
        waitForVisibility(confirmNextPlanButton);
        confirmNextPlanButton.click();
    }

    @Override
    public void validateChangePlaneProcessingScreenUI() {
        try {
            waitForVisibility(vodafoneLogoAnimation);
            Assert.assertTrue(vodafoneLogoAnimation.isDisplayed());
            AssertResult(processingTxt.getText(), "Processing ...");
        } catch (Exception e) {


        }

    }

    @Override
    public void validateChangePlanNotificationScreenUI() {
        waitForVisibility(RedHybrid_SuccessCTA);
        Assert.assertTrue(RedHybrid_SuccessCTA.isDisplayed());
        Assert.assertTrue(notificationDescription.isDisplayed());
        Assert.assertTrue(notificationSubDescription.isDisplayed());
        AssertDisplayed(checkMarkIcon.isDisplayed());
        Assert.assertTrue(redHybridCloseView.isDisplayed());


    }

    public void validatePlanTabIsDisplayed() {
        waitForVisibility(PlanTitleRedHybrid);
        Assert.assertTrue(PlanTitleRedHybrid.isDisplayed());
    }


    @Override
    public void redHybridDismissIconClick() {
        redHybridCloseView.click();
    }

    @Override
    public void iShouldAbleToSeeQuickLinks() {
        scrollDownElementOverCenterScreen(changeNextPlanQuickLinks);
        waitForVisibility(changeNextPlanQuickLinks);
    }


    @Override
    public void validate_UI_of_confirmation_screen_in_changePlan(String JourneyType) throws JsonProcessingException {
        String expectedTitle = null,expectedDescription = null,expectedSubDescription = null;


        switch (JourneyType) {
            case "Change plan" -> {
                expectedTitle = "Change plan";
                expectedDescription = "Your next plan will start in";
                expectedSubDescription = "Your card will be charged when your current plan ends. We’ll text you once everything is done.";
            }
            case "Add Data", "Add Extras" -> {
                expectedTitle = JourneyType;
                expectedDescription = "Thanks for adding an Extra";
                expectedSubDescription = "It may take up to 15 minutes for your Extra to display in the My Vodafone app.  We’ll text you once everything is done.";
            }
            case "Add a new plan" -> {
                expectedTitle = "Add a new plan";
                expectedDescription = "Thanks for adding a Plus plan";
                expectedSubDescription = "It may take up to 15 minutes for the My Vodafone app to display your new plan. We’ll text you once everything is done.";
            }
            case "Renew early" -> {
                expectedTitle = "Renew early";
                expectedDescription = "Thanks for renewing your Plus plan";
                expectedSubDescription = "It may take up to 15 minutes for the My Vodafone app to display your new plan. You may also briefly lose service while your renewal is processed. We’ll text you once everything is done.";
            }
            case "Auto-Renew" -> {
                expectedTitle = "Auto-Renew";
                expectedDescription = "Your auto-renewal has been updated";
                expectedSubDescription = "It may take up to 15 minutes for the My Vodafone app to display your new Auto-Renew preference. We’ll text you once everything is done.";
            }

            default -> {
                System.out.println(JourneyType+" is not recognized");
            }
        }

        waitForVisibility(ContinueCTA);
        Assert.assertTrue(notificationTitle.isDisplayed());
        Assert.assertTrue(traySuccessNotification.isDisplayed());
        Assert.assertTrue(thankYouTickIcon.isDisplayed());
        Assert.assertTrue(traySuccessSubNotification.isDisplayed());
        Assert.assertTrue(thankYouCloseIcon.isDisplayed());
        Assert.assertTrue(ContinueCTA.isDisplayed());



        // Assert on title
        String actualTitle = notificationTitle.getText();
        Assert.assertEquals(actualTitle, expectedTitle);

        // Assert on Description
        String actualDescription = traySuccessNotification.getText();
        System.out.println("actual"+actualDescription);
        System.out.println("expected"+expectedDescription);
        Assert.assertTrue(actualDescription.contains(expectedDescription));

        // Assert on SubDescription
        String actualSubDescription = traySuccessSubNotification.getText();
        Assert.assertEquals(actualSubDescription, expectedSubDescription);
    }


}
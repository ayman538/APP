package pages.RedHybrid.PaymentMethodOverlayNoPaymentMethodAdded;

import models.response.BeginCardPaymentResponseModel;
import models.response.DashboardV4ResponseModel;
import models.response.HybridBundelsResponseModel;
import org.testng.Assert;
import utils.BeginCardPaymentUtils;
import utils.DashboardUtils;
import utils.HybridBundelsUtils;

import java.util.HashMap;
import java.util.Map;

import static utils.element_helpers.VerifyHelpers.AssertDisplayed;
import static utils.element_helpers.VerifyHelpers.assertEquals;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

public class RedHybrid_PaymentMethodOverlayNoPaymentMethodAddedLogic_Android extends RedHybrid_PaymentMethodOverlayNoPaymentMethodAdded_Abstract {
    HybridBundelsResponseModel hybridBundelsResponseModel ;
    BeginCardPaymentResponseModel beginCardPaymentResponseModel ;
    DashboardV4ResponseModel DashboardResponse = DashboardUtils.GetDashboard();
    String iconId = "10150";
    Map<String, String> headers ;
    String keyOrderType = "orderType";
    String valueAddNew = "add-new";
    String contentTypeKey = "Content-Type" ;
    String contentTypeValue = "application/json;charset=UTF-8" ;
    // the auto-renewal state value
    Boolean autoRenewState = true;

    public RedHybrid_PaymentMethodOverlayNoPaymentMethodAddedLogic_Android(){
        super();
    }

    @Override
    public void redHybridUserOnDashboard() {
        waitForVisibility(RedHybrid_MyAccount);

        // assert Subscription type "pay as you go"
        String ActualSubscriptionName= DashboardResponse.subscriptionHeader.subscriptionType;
        String ExpectedSubscriptionName =DB_SubscriptionIconText.getText();
        assertEquals(ActualSubscriptionName,ExpectedSubscriptionName);
    }

    @Override
    public void noPlanAddedValidation() {
        AssertDisplayed(redHybrid_AddPlan.isDisplayed());

        // assert  "No plan state allowance title" card
        String ActualNoPlanStateAllowanceTitle= DashboardResponse.tiles.get(0).content.get(0).title;
        String ExpectedNoPlanStateAllowanceTitle =NoPlanStateAllowanceTitle.getText();
        assertEquals(ActualNoPlanStateAllowanceTitle,ExpectedNoPlanStateAllowanceTitle);

        // assert  "No plan state allowance desc" card
        String ActualNoPlanStateAllowanceSubTitle= DashboardResponse.tiles.get(0).content.get(0).subtitle;
        String ExpectedNoPlanStateAllowancSubTitle =NoPlanStateAllowanceSubTitle.getText();
        assertEquals(ActualNoPlanStateAllowanceSubTitle,ExpectedNoPlanStateAllowancSubTitle);
    }

    @Override
    public void addNewPlan() {
        redHybrid_AddPlan.click();
    }

    @Override
    public void planChoosed() {
        waitForVisibility(addFlexiPlanHeader);
        Map<String, String> queryParameters = new HashMap<String, String>() {{
            put("orderType", "add-new");
        }};
        hybridBundelsResponseModel = HybridBundelsUtils.getHybridBundelsResponse(queryParameters);

        // assert Plan Name
        String ActualPlanName= hybridBundelsResponseModel.title ;
        String ExpectedPlanName =addFlexiPlanHeader.getText();
        assertEquals(ActualPlanName,ExpectedPlanName);


        // assert Plan title
        String ActualPlanTitle= hybridBundelsResponseModel.subTitle ;
        String ExpectedPlanTitle =AddPlanTitle.getText();
        assertEquals(ActualPlanTitle,ExpectedPlanTitle);


        // assert Plan disc
        AssertDisplayed(ChoosePlanDisc.isDisplayed());

        // the choose plan screen opened
        Assert.assertTrue(plansRecyclerView.isSelected());

        // assert on auto-renew toggle
        AssertDisplayed(AutoRenewToggle_AddNewPlanScreen.isDisplayed());
        Assert.assertTrue(AutoRenewToggle_AddNewPlanScreen.isEnabled());

        // assert on auto-renew text
        AssertDisplayed(AutoRenewText_AddNewPlanScreen.isDisplayed());
        Assert.assertEquals(AutoRenewText_AddNewPlanScreen.getText(), hybridBundelsResponseModel.autoRenewText);

        // assert on auto-renew Note
        AssertDisplayed(AutoRenewNote_AddNewPlanScreen.isDisplayed());
        Assert.assertEquals(AutoRenewNote_AddNewPlanScreen.getText(), hybridBundelsResponseModel.footerText);
    }
    @Override
    public void clickContinueInAddNewPlanScreen() {
        // the choose plan screen opened
        choosePlanContinueBtn.click();

    }

    @Override
    public void callBeginCardPaymentAPI() {
        try {
            String productID = hybridBundelsResponseModel.items.get(0).planId;
            headers = new HashMap<String, String>() {{
                put(keyOrderType, valueAddNew);
                put(contentTypeKey,contentTypeValue);
            }};
            beginCardPaymentResponseModel = BeginCardPaymentUtils.getBeginCardPaymentResponse(productID,true,headers);
            System.out.println("API status" + beginCardPaymentResponseModel.status.analytics.status);
        } catch (Exception e) {
            System.out.println("MVAX API V1/beginCardPayment has not been called");
        }
    }

    @Override
    public void noPaymentMethodIsVisible() {
        waitForVisibility(NoPaymentMethodTitle);
        //AssertDisplayed(NoPaymentMethodDescription.isDisplayed());
    }

    @Override
    public void noPaymentMethodOverlayUIValidation() {

        String expectedTitle = NoPaymentMethodTitle.getText().toString() ;
        String actualTitle = beginCardPaymentResponseModel.card.title;
        Assert.assertEquals(expectedTitle ,actualTitle );
        //String expectedDescription = NoPaymentMethodDescription.getText().toString() ;
        //String actualDescription = beginCardPaymentResponseModel.card.description;
        //Assert.assertEquals(expectedDescription ,actualDescription);
        String expectedBtnName = NoPaymentMethodBtn.getText();
        if(expectedBtnName != null){
            String actualBtnName =  beginCardPaymentResponseModel.card.action.text;
            Assert.assertEquals(expectedBtnName,actualBtnName);
        }
        String expectedIconId = beginCardPaymentResponseModel.card.iconId ;
        Assert.assertEquals(expectedIconId,iconId);
        AssertDisplayed(NoPaymentMethodCloseBtn.isDisplayed());
    }

    @Override
    public void beginCardPaymentAPIresponseCheck() {
        if (beginCardPaymentResponseModel.status.analytics.status == "Success") {
            Assert.assertEquals(beginCardPaymentResponseModel.status.code, 0);
            Assert.assertNotNull(beginCardPaymentResponseModel.card);

        }

    }}

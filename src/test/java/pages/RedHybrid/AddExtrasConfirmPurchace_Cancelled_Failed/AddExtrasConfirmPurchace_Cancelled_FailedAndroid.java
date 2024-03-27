package pages.RedHybrid.AddExtrasConfirmPurchace_Cancelled_Failed;


import com.fasterxml.jackson.core.JsonProcessingException;
import models.response.BeginCardPaymentResponseModel;
import models.response.ProcessCardPaymentResponseModel;
import models.response.common.ListExtrasResponseModel;
import org.testng.Assert;
import utils.BeginCardPaymentUtils;
import utils.ListExtrasUtils;
import utils.ProcessCardPaymentUtils;

import java.util.HashMap;
import java.util.Map;

import static utils.element_helpers.DriverHelps.hideKeyboard;
import static utils.element_helpers.ScrollHelpers.androidScrollToElement;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

public class AddExtrasConfirmPurchace_Cancelled_FailedAndroid extends AddExtrasConfirmPurchace_Cancelled_FailedAbstract {
    String apiStatus = "Success";
    String transRef;
    String expectedProcessStatus;
    String actualProcessStatus;
    String expectedNextJourney;
    String actualNextJourney;
    Map<String, String> headers;
    Map<String, String> queryParameters;
    String keyOrderType = "orderType";
    String contentTypeKey = "Content-Type";
    String contentTypeValue = "application/json;charset=UTF-8";
    ListExtrasResponseModel listExtrasResponseModel;
    ProcessCardPaymentResponseModel process;
    BeginCardPaymentResponseModel begin;
    int extraId;
    int planId;
    String valueAddExtra = "add-extra";


    @Override
    public void paymentMethodScreenInsertCVV(String cvv) throws InterruptedException {
        Thread.sleep(2000);
        try {
            androidScrollToElement(paymentMethodOverlayContinueCTA, "down");
        } catch (Exception e) {
            System.out.println("Continue");
        }
        NewCardSecurityCode.sendKeys(cvv);
        hideKeyboard();
    }

    @Override
    public void ClickOnContinueAddExtra() {
        waitForVisibility(AddExtracontinueCTA);
        AddExtracontinueCTA.click();
    }

    @Override
    public void AddExtraPaymentMethodOverlayAppears() {
        waitForVisibility(AddExtraBarcalysHeader);

    }

    @Override
    public void paymentErrorOverlayFailedStatusValidation() throws JsonProcessingException {
        callListExtras();
        callBeginCardAndRetrieveTransRef(planId, extraId);
        process = callProcessCardPayment(planId, extraId, transRef);
        assertOnScreenContentsFailed(process);
    }


    public void assertOnScreenContentsFailed(ProcessCardPaymentResponseModel process) {
        expectedProcessStatus = "FAILED_BEFORE_AUTHORIZE";
        actualProcessStatus = process.processStatus;
        Assert.assertEquals(expectedProcessStatus, actualProcessStatus);
        expectedNextJourney = "PAYMENT_CARD_FAILED";
        actualNextJourney = process.nextJourney;
        Assert.assertEquals(expectedNextJourney, actualNextJourney);
        String expectedDescription = paymentFailedScreenDescription.getText();
        String actualDescription = process.nextJourneyCard.description;
        Assert.assertEquals(expectedDescription, actualDescription);
    }


    public void callListExtras() {
        queryParameters = new HashMap<String, String>() {{
        }};
        headers = new HashMap<String, String>() {{
        }};
        listExtrasResponseModel = ListExtrasUtils.getListExtras(headers, queryParameters);
        planId = listExtrasResponseModel.planId;
        extraId = listExtrasResponseModel.categories.get(0).addonCategoryInfo.addonList.get(0).id;
    }


    public void callBeginCardAndRetrieveTransRef(int plan_id, int extra_id) throws JsonProcessingException, JsonProcessingException {
        headers = new HashMap<String, String>() {{
            put(keyOrderType, valueAddExtra);
            put(contentTypeKey, contentTypeValue);

        }};
        begin = BeginCardPaymentUtils.getBeginCardPaymentResponse(Integer.toString(plan_id), Integer.toString(extra_id), headers);
        System.out.println(begin.status.analytics.guid + "  guid ");
        Assert.assertEquals(apiStatus, begin.status.analytics.status);
        transRef = BeginCardPaymentUtils.retrieveTransactionRef(begin);
    }

    public ProcessCardPaymentResponseModel callProcessCardPayment(int plan_id, int extra_id, String TransactionRef) throws JsonProcessingException {
        headers = new HashMap<String, String>() {{
            put(keyOrderType, valueAddExtra);
            put(contentTypeKey, contentTypeValue);
        }};
        process = ProcessCardPaymentUtils.getProcessCardPaymentResponse(Integer.toString(plan_id), Integer.toString(extra_id), TransactionRef, headers);
        System.out.println(process.status.analytics.guid + "  guid of process ");
        Assert.assertEquals(apiStatus, process.status.analytics.status);
        return process;
    }
    //    public void assertOnScreenContentsCancelled(ProcessCardPaymentResponseModel process) {
//        expectedProcessStatus = "FAILED_BEFORE_AUTHORIZE";
//        actualProcessStatus = process.processStatus;
//        Assert.assertEquals(expectedProcessStatus, actualProcessStatus);
//        expectedNextJourney = "PAYMENT_CARD_FAILED";
//        actualNextJourney = process.nextJourney;
//        Assert.assertEquals(expectedNextJourney, actualNextJourney);
//    }


}

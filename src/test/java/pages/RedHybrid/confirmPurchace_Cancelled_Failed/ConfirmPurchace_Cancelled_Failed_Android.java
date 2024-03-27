package pages.RedHybrid.confirmPurchace_Cancelled_Failed;

import com.fasterxml.jackson.core.JsonProcessingException;
import models.response.BeginCardPaymentResponseModel;
import models.response.HybridBundelsResponseModel;
import models.response.ProcessCardPaymentResponseModel;
import org.testng.Assert;
import utils.BeginCardPaymentUtils;
import utils.HybridBundelsUtils;
import utils.ProcessCardPaymentUtils;

import java.util.HashMap;
import java.util.Map;

import static utils.element_helpers.DriverHelps.hideKeyboard;
import static utils.element_helpers.ScrollHelpers.androidScrollToElement;
import static utils.element_helpers.ScrollHelpers.scrollDownTo;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

public class ConfirmPurchace_Cancelled_Failed_Android extends ConfirmPurchace_Cancelled_Failed_Abstract {

    String apiStatus = "Success";
    String planId;
    String transRef;
    String expectedProcessStatus;
    String actualProcessStatus;
    String expectedNextJourney;
    String actualNextJourney;
    ProcessCardPaymentResponseModel processResponse;
    Map<String, String> headers ;
    Map<String, String> queryParameters ;
    String keyOrderType = "orderType";
    String valueAddNew = "add-new";
    String contentTypeKey = "Content-Type" ;
    String contentTypeValue = "application/json;charset=UTF-8" ;

    public ConfirmPurchace_Cancelled_Failed_Android() {
        super();
    }

    @Override
    public void paymentMethodOverlayAppears() {
        waitForVisibility(paymentMethodOverlayHeader);
        Assert.assertEquals(paymentMethodOverlayHeader.getText(), "Add a new plan");
    }

    @Override
    public void paymentMethodScreenInsertNameAndCVV(String name, String cvv) throws InterruptedException {
        Thread.sleep(2000);
        try {
            androidScrollToElement(paymentMethodOverlayContinueCTA, "down");
        } catch (Exception e) {
            System.out.println("Pay Now is visible");
        }
        paymentMethodOverlayName.sendKeys(name);
        hideKeyboard();
        paymentMethodOverlayCVV.sendKeys(cvv);
        hideKeyboard();
    }

    @Override
    public void clickOnPayNow() {
        paymentMethodOverlayContinueCTA.click();
    }

    @Override
    public void pwdScreenIsVisible() {
        waitForVisibility(barclaysScreenSubmitCTA);
    }

    @Override
    public void paymentMethodInsertPassword(String pwd) {

        waitForVisibility(barclaysScreenCardPassword);
        barclaysScreenCardPassword.clear();
        barclaysScreenCardPassword.sendKeys(pwd);
    }

    @Override
    public void clickSubmitPassword() {
        barclaysScreenSubmitCTA.click();
    }

    @Override
    public void validateIncorrectPwd() {
        barclaysScreenInvalidPasswordText.isDisplayed();
    }

    @Override
    public void paymentErrorScreenIsVisible() throws InterruptedException {
        waitForVisibility(paymentFailedScreenTitle);
        Thread.sleep(2000);
    }

    @Override
    public void paymentErrorTryAgainCTAClick() {
        paymentFailedScreenTryAgain.click();
    }

    @Override
    public void paymentErrorDismissButtonClick() {
        NoPaymentMethodCloseBtn.click();
    }

    @Override
    public void paymentScreenCancelCTAClick() {
        if (paymentMethodOverlayCancelCTA.isDisplayed()) {
            paymentMethodOverlayCancelCTA.click();
        } else {
            scrollDownTo(paymentMethodOverlayCancelCTA);
            paymentMethodOverlayCancelCTA.click();
        }
    }

    @Override
    public void
    paymentErrorScreenUIValidationFailedStatus(HybridBundelsResponseModel hybrid, BeginCardPaymentResponseModel begin, ProcessCardPaymentResponseModel process) throws JsonProcessingException {


        planId = callHybriBundlesAndRetrievePlanId(hybrid,queryParameters);
        transRef = callBeginCardAndRetrieveTransRef(begin, planId ,headers);
        processResponse = callProcessCardPayment(process, planId, transRef, headers);
        expectedProcessStatus = "FAILED_BEFORE_AUTHORIZE";
        actualProcessStatus = processResponse.processStatus;
        Assert.assertEquals(expectedProcessStatus, actualProcessStatus);
        expectedNextJourney = "PAYMENT_CARD_FAILED";
        actualNextJourney = processResponse.nextJourney;
        Assert.assertEquals(expectedNextJourney, actualNextJourney);
        Assert.assertTrue(paymentFailedIcon.isDisplayed());
        String expectedTitle = paymentFailedScreenTitle.getText();
        String actualTitle = processResponse.title;
        Assert.assertEquals(expectedTitle, actualTitle);
        String expectedDescription = paymentFailedScreenDescription.getText();
        String actualDescription = processResponse.nextJourneyCard.title;
        Assert.assertEquals(expectedDescription, actualDescription);
    }

    @Override
    public void paymentErrorCancelledStatus(HybridBundelsResponseModel hybrid, BeginCardPaymentResponseModel begin, ProcessCardPaymentResponseModel process) throws JsonProcessingException {

        planId = callHybriBundlesAndRetrievePlanId(hybrid,queryParameters);
        transRef = callBeginCardAndRetrieveTransRef(begin, planId,headers);

        processResponse = callProcessCardPayment(process, planId, transRef, headers);
        expectedProcessStatus = "FAILED_BEFORE_AUTHORIZE";
        actualProcessStatus = processResponse.processStatus;
        Assert.assertEquals(expectedProcessStatus, actualProcessStatus);
        expectedNextJourney = "PAYMENT_CARD_FAILED";
        actualNextJourney = processResponse.nextJourney;
        Assert.assertEquals(expectedNextJourney, actualNextJourney);
    }

    public String callHybriBundlesAndRetrievePlanId(HybridBundelsResponseModel hybridBundles ,Map<String, String> queryParameters) {
        queryParameters = new HashMap<String, String>() {{
            put(keyOrderType, valueAddNew);
        }};
        hybridBundles = HybridBundelsUtils.getHybridBundelsResponse(queryParameters);
        Assert.assertEquals(apiStatus, hybridBundles.status.analytics.status);
        return hybridBundles.items.get(0).planId;
    }

    public String callBeginCardAndRetrieveTransRef(BeginCardPaymentResponseModel beginCard, String plan_id, Map<String, String> headers) throws JsonProcessingException {
        headers = new HashMap<String, String>() {{
            put(keyOrderType, valueAddNew);
            put(contentTypeKey,contentTypeValue);
        }};
        beginCard = BeginCardPaymentUtils.getBeginCardPaymentResponse(plan_id,true,headers);
        Assert.assertEquals(apiStatus, beginCard.status.analytics.status);
        return BeginCardPaymentUtils.retrieveTransactionRef(beginCard);
    }

    public ProcessCardPaymentResponseModel callProcessCardPayment(ProcessCardPaymentResponseModel processResponseModel, String productId, String TransactionRef , Map<String, String> headers) throws JsonProcessingException {
        headers = new HashMap<String, String>() {{
            put(keyOrderType, valueAddNew);
            put(contentTypeKey,contentTypeValue);
        }};
        processResponseModel = ProcessCardPaymentUtils.getProcessCardPaymentResponse(productId, TransactionRef, headers);
        return processResponseModel;
    }
}


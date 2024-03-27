package pages.RedHybrid.confirmPurchace_Cancelled_Failed;

import com.fasterxml.jackson.core.JsonProcessingException;
import models.response.BeginCardPaymentResponseModel;
import models.response.HybridBundelsResponseModel;
import models.response.ProcessCardPaymentResponseModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.BeginCardPaymentUtils;
import utils.HybridBundelsUtils;
import utils.ProcessCardPaymentUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static utils.element_helpers.ScrollHelpers.iosScrollToElement;
import static utils.element_helpers.ScrollHelpers.scrollDownTo;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

public class ConfirmPurchace_Cancelled_Failed_Ios extends ConfirmPurchace_Cancelled_Failed_Abstract {
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

    public ConfirmPurchace_Cancelled_Failed_Ios() {
        super();
    }

    @Override
    public void paymentMethodOverlayAppears() {
        waitForVisibility(paymentMethodOverlayHeader);
        Assert.assertEquals(paymentMethodOverlayHeader.getText(), "Add a new plan");
    }

    @Override
    public void paymentMethodScreenInsertNameAndCVV(String name, String cvv) {
        try {
            iosScrollToElement(paymentMethodOverlayContinueCTA, "down");
        } catch (Exception e) {
            System.out.println("Pay Now is visible");
        }

        ArrayList<WebElement> list = (ArrayList<WebElement>) paymentMethodOverlayName.findElements(By.xpath("//*[@type='XCUIElementTypeTextField']"));

        list.get(0).click();
        list.get(0).sendKeys(name);
        list.get(1).sendKeys(cvv);

    }

    @Override
    public void clickOnPayNow() {
        if (paymentMethodOverlayContinueCTA.isDisplayed()) {
            paymentMethodOverlayContinueCTA.click();
        } else {
            scrollDownTo(paymentMethodOverlayContinueCTA);
            paymentMethodOverlayContinueCTA.click();
        }
    }

    @Override
    public void pwdScreenIsVisible() {
        waitForVisibility(barclaysScreenSubmitCTA);
    }

    @Override
    public void paymentMethodInsertPassword(String pwd) {
        waitForVisibility(barclaysPWDScreenDescription);
        barclaysScreenCardPassword.clear();
        barclaysScreenCardPassword.sendKeys(pwd);
        if(keyBoardDoneCta.isDisplayed() != false){
            keyBoardDoneCta.click();
        }
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
    public void paymentScreenCancelCTAClick() throws InterruptedException {
            paymentMethodOverlayCancelCTA.click();
    }

    @Override
    public void
    paymentErrorScreenUIValidationFailedStatus(HybridBundelsResponseModel hybrid, BeginCardPaymentResponseModel begin, ProcessCardPaymentResponseModel process) throws JsonProcessingException {
        planId = callHybriBundlesAndRetrievePlanId(hybrid,queryParameters);
        transRef = callBeginCardAndRetrieveTransRef(begin, planId,headers);
        processResponse = callProcessCardPayment(process, planId, transRef, headers);
        expectedProcessStatus = "FAILED_BEFORE_AUTHORIZE";
        actualProcessStatus = processResponse.processStatus;
        Assert.assertEquals(expectedProcessStatus, actualProcessStatus);
        expectedNextJourney = "PAYMENT_CARD_FAILED";
        actualNextJourney = processResponse.nextJourney;
        Assert.assertEquals(expectedNextJourney, actualNextJourney);
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

    public String callHybriBundlesAndRetrievePlanId(HybridBundelsResponseModel hybridBundles,Map<String, String> queryParameters) {
        queryParameters = new HashMap<String, String>() {{
            put(keyOrderType, valueAddNew);
        }};
        hybridBundles = HybridBundelsUtils.getHybridBundelsResponse(queryParameters);
        Assert.assertEquals(apiStatus, hybridBundles.status.analytics.status);
        return  hybridBundles.items.get(0).planId;
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

    public ProcessCardPaymentResponseModel callProcessCardPayment(ProcessCardPaymentResponseModel processResponseModel, String productId, String TransactionRef, Map<String, String> headers) throws JsonProcessingException {
        headers = new HashMap<String, String>() {{
            put(keyOrderType, valueAddNew);
            put(contentTypeKey,contentTypeValue);
        }};
        processResponseModel = ProcessCardPaymentUtils.getProcessCardPaymentResponse(productId, TransactionRef, headers);
        return processResponseModel;
    }
}
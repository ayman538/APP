package pages.RedHybrid.ConfirmYourPurchase;

import com.fasterxml.jackson.core.JsonProcessingException;
import models.response.BeginCardPaymentResponseModel;
import models.response.CreateOrderResponseModel;
import models.response.HybridBundelsResponseModel;
import models.response.ProcessCardPaymentResponseModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.*;

import java.util.HashMap;
import java.util.Map;

import static utils.element_helpers.ScrollHelpers.androidScrollToElement;
import static utils.element_helpers.ScrollHelpers.scrollDownTo;
import static utils.element_helpers.VerifyHelpers.AssertDisplayed;
import static utils.element_helpers.VerifyHelpers.assertDisplayed;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

public class RedHybrid_ConfirmYourPurchase_Android extends RedHybrid_ConfirmYourPurchase {

    ProcessCardPaymentResponseModel process;
    HybridBundelsResponseModel plan;
    BeginCardPaymentResponseModel begin;
    Map<String, String> queryParameters;
    Map<String, String> headers;
    String keyOrderType = "orderType";
    String valueAddNew = "add-new";
    String valueChangeNow = "change-now";
    String contentTypeKey = "Content-Type";
    String contentTypeValue = "application/json;charset=UTF-8";
    By confirmCardHolderName = By.id("confirmCardholderName");
    By confirmCsc = By.id("confirmCsc");
    By submitBtn = By.id("btnSubmit");
    By passCode = By.xpath("//input[@type='password' and @id='passcode']");
    By authSubmitBtn = By.xpath("//input[@type='submit' and @value='Submit']");

    @Override
    public void barclaysScreenIsDisplayed() {
        androidScrollToElement(CardSecurityCode, "down");
        assertDisplayed(CardSecurityCode, 20);
    }

    @Override
    public void confirmPurchaseScreenIsDisplayed() {
        waitForVisibility(confirmPlanPurchaseTitle);
        assertDisplayed(confirmPlanPurchaseTitle, 20);

    }

    @Override
    public void validateConfirmPurchaseUIScreen() throws JsonProcessingException {
        queryParameters = new HashMap<String, String>() {{
            put(keyOrderType, valueAddNew);
        }};
        headers = new HashMap<String, String>() {{
            put(keyOrderType, valueAddNew);
            put(contentTypeKey, contentTypeValue);
        }};
        //Get Plan Id from HybridBundles APi
        plan = HybridBundelsUtils.getHybridBundelsResponse(queryParameters);
        String planId = plan.items.get(0).planId;
        //Get transaction reference for BeginCard Api
        begin = BeginCardPaymentUtils.getBeginCardPaymentResponse(planId,true, headers);
        String TransReference = BeginCardPaymentUtils.retrieveTransactionRef(begin);
        String URL = BeginCardPaymentUtils.retrieveURL(begin);
        BeginCardPaymentUtils.submitCvvWithTransRef(URL, "234");
//      submitCvvAndHolderName(URL, "234");

        process = ProcessCardPaymentUtils.getProcessCardPaymentResponse(planId, TransReference, headers);
        System.out.println("guid is : " + process.status.analytics.guid);
        System.out.println("code is : " + process.status.code);

        Assert.assertEquals(process.card.title, confirmPlanPurchaseTitle.getText());
        Assert.assertEquals(process.card.productName, confirmPlanPurchaseProductName.getText());

    }

    @Override
    public void clickOnTermsAndConditionsToggle() {

        confirmPlanPurchaseTermAndConditionToggle.click();
    }

    @Override
    public void validateEnablingTermsAndConditionsToggle() throws InterruptedException {
        clickOnTermsAndConditionsToggle();
        Thread.sleep(500);
        Assert.assertTrue(confirmPlanPurchasePaySecurelyButton.isEnabled());
    }

    @Override
    public void clickOnPayNowInBarcalysScreen() {
        if (paymentMethodOverlayContinueCTA.isDisplayed()) {
            paymentMethodOverlayContinueCTA.click();
        } else {
            scrollDownTo(paymentMethodOverlayContinueCTA);
            paymentMethodOverlayContinueCTA.click();
        }

    }

    @Override
    public void clickOnPaySecurelyCTA() {
        paySecurelyCTA.click();
    }

    @Override
    public void maskOverDashboardTile() {
        AssertDisplayed(manageYourPlaneMaskDescription.isDisplayed());
        Assert.assertTrue(manageYourPlaneMaskDescription.isDisplayed());
    }

    @Override
    public void validateUIOfNewPlanAddedScreen() throws JsonProcessingException {

        CreateOrderResponseModel createOrderResponseModel = CreateOrderUtils.callCreateOrder_AddNewPlan();
        String expectedTitle = paymentMethodOverlayHeader.getText();
        String actualTitle = createOrderResponseModel.nextJourneyCard.title;
        Assert.assertEquals(actualTitle, expectedTitle);


        String expectedSuccessNotification = traySuccessNotification.getText();
        String actualSuccessNotification = createOrderResponseModel.nextJourneyCard.description;
        Assert.assertEquals(actualSuccessNotification, expectedSuccessNotification);


        String expectedSuccessSubNotification = traySuccessSubNotification.getText();
        String actualSuccessSubNotification = createOrderResponseModel.nextJourneyCard.subDescription;
        Assert.assertEquals(actualSuccessSubNotification, expectedSuccessSubNotification);


        String expectedContinueCTA = RedHybrid_ContinuePaymentCTA.getText();
        String actualContinueCTA = createOrderResponseModel.nextJourneyCard.actions.get(0).text;
        Assert.assertEquals(actualContinueCTA, expectedContinueCTA);

        Assert.assertEquals(createOrderResponseModel.orderStatus.maskValue.description, "Your plan purchase is currently being processed. Please check back shortly.");
        Assert.assertEquals(createOrderResponseModel.orderStatus.maskValue.iconId, "10143");
    }

    @Override
    public void validateConfirmPurchaseUIScreen(String orderType) throws JsonProcessingException {
        queryParameters = new HashMap<String, String>() {{
            put(keyOrderType, orderType);
        }};
        headers = new HashMap<String, String>() {{
            put(keyOrderType, orderType);
            put(contentTypeKey, contentTypeValue);
        }};
        //Get Plan Id from HybridBundles APi
        plan = HybridBundelsUtils.getHybridBundelsResponse(queryParameters);
        System.out.println(plan);
        String planId = plan.items.get(0).planId;
        //Get transaction reference for BeginCard Api
        begin = BeginCardPaymentUtils.getBeginCardPaymentResponse(planId,true, headers);
        String TransReference = BeginCardPaymentUtils.retrieveTransactionRef(begin);
        String URL = BeginCardPaymentUtils.retrieveURL(begin);
        BeginCardPaymentUtils.submitCvvWithTransRef(URL, "234");
//      submitCvvAndHolderName(URL, "234");

        process = ProcessCardPaymentUtils.getProcessCardPaymentResponse(planId, TransReference, headers);
        System.out.println("guid is : " + process.status.analytics.guid);
        System.out.println("code is : " + process.status.code);

        Assert.assertEquals(process.card.title, confirmPlanPurchaseTitle.getText());
        Assert.assertEquals(process.card.productName, confirmPlanPurchaseProductName.getText());

    }

    public void submitCvvAndHolderName(String URL, String cvv) {
        WebDriver driver = WebDriverFactory.createChromeWebDriver();
        driver.get(URL);
        driver.findElement(confirmCsc).sendKeys(cvv);
        driver.findElement(submitBtn).click();
        try {
            WebUtils.waitForVisible(driver, driver.findElement(authSubmitBtn));
            WebUtils.waitForVisible(driver, driver.findElement(authSubmitBtn));
            driver.findElement(passCode).sendKeys("Pa55w0rd");
            driver.findElement(authSubmitBtn).click();
        } catch (Exception e) {
            System.out.println("no auth needed");
        }
        WebUtils.implicitWait(driver, 10);
        driver.quit();
    }


}

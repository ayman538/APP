package pages.RedHybrid.ConfirmExtrasPurchase_BeforeAuthorizationStatus;

import com.fasterxml.jackson.core.JsonProcessingException;
import models.response.BeginCardPaymentResponseModel;
import models.response.ProcessCardPaymentResponseModel;
import models.response.common.ListExtrasResponseModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.BeginCardPaymentUtils;
import utils.ListExtrasUtils;
import utils.ProcessCardPaymentUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static utils.element_helpers.ScrollHelpers.scrollDownTo;
import static utils.element_helpers.VerifyHelpers.AssertDisplayed;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

public class ConfirmExtrasPurchase_BeforeAuthorizationStatus_IOS extends ConfirmExtrasPurchase_BeforeAuthorizationStatus_Abstract {
    String transactionRef;
    String redirectURL;
    Map<String, String> headers;
    Map<String, String> queryParameters;
    String keyOrderType = "orderType";
    String contentTypeKey = "Content-Type";
    String contentTypeValue = "application/json;charset=UTF-8";
    String paymentMethodOverlayElements= "//*[@type='XCUIElementTypeTextField']";
    String dataType = "extraType";
    String valueDataExtra = "Data";
    String valueAddExtra = "add-extra";
    public int planId;
    public int extraId;

    ProcessCardPaymentResponseModel processCardPaymentResponseModel;
    ListExtrasResponseModel listExtrasResponseModel;
    BeginCardPaymentResponseModel beginCardPaymentResponseModel;

    public ConfirmExtrasPurchase_BeforeAuthorizationStatus_IOS() {
        super();
    }

    @Override
    public void assertThatConfirmYourPurchaseOverlayDisplayed() {
        AssertDisplayed(paySecurelyCTA.isDisplayed());
    }

    @Override
    public void assertThatConfirmYourPurchaseOverlayUIDisplayed()  {

        //Assert that title name is correct
        String expectedTitleName = processCardPaymentResponseModel.title;
        String actualTitleName = RedHybridTitle.getText();
        Assert.assertEquals(actualTitleName, expectedTitleName);


        //Assert that prodcut name is correct
        String expectedProductName = processCardPaymentResponseModel.card.productName;
        String actualProductName = productName.getText();
        Assert.assertEquals(actualProductName, expectedProductName);

        //Assert that prodcut price is correct
        String expectedProductPrice = processCardPaymentResponseModel.card.productPrice;
        String actualProductPrice = productPrice.getText();
        Assert.assertEquals(actualProductPrice, expectedProductPrice);

        //  Assert that prodcut description is correct
        String expextedProductDesc = processCardPaymentResponseModel.card.productDesc;
        String actualProductDesc = productDesc.getText();
        Assert.assertEquals(actualProductDesc, expextedProductDesc);

        AssertDisplayed(confirmPlanHeader.isDisplayed());
        AssertDisplayed(xCTA.isDisplayed());
        AssertDisplayed(confirmPlanChangeNote.isDisplayed());
    }

    @Override
    public void screenUIAPIResponseCombatability(String ExtraGroup ,String ExtraName, String orderType) throws JsonProcessingException {
        getPlanIdAndExtraId(ExtraGroup ,ExtraName);
        getTransRefAndURL();
        BeginCardPaymentUtils.submitCvvWithTransRef(redirectURL, "234");
        processCardPaymentResponseModel = callProcessCardPayment(orderType);
        assertThatConfirmYourPurchaseOverlayUIDisplayed();
    }
    public void getPlanIdAndExtraId(String ExtraGroup,String ExtraName) {
        queryParameters = new HashMap<String, String>() {{
            put(dataType, valueDataExtra);
        }};
        headers = new HashMap<String, String>() {{
        }};
        listExtrasResponseModel = ListExtrasUtils.getListExtras(headers);
        planId = listExtrasResponseModel.planId;
        boolean GetExtra= false;
        for (int i = 0; i < listExtrasResponseModel.categories.size(); i++) {
            if(listExtrasResponseModel.categories.get(i).text.equalsIgnoreCase(ExtraGroup)){
                for (int j = 0; j <listExtrasResponseModel.categories.get(i).addonCategoryInfo.addonList.size(); j++) {
                    if(listExtrasResponseModel.categories.get(i).addonCategoryInfo.addonList.get(j).name.equalsIgnoreCase(ExtraName)){
                        extraId=listExtrasResponseModel.categories.get(i).addonCategoryInfo.addonList.get(j).id;
                        GetExtra=true;
                        break;

                    }
                }
            }
            if(GetExtra== true)break;
        }
    }


    @Override
    public void SelectExtra(String extra) {
        driver.findElement(By.xpath("//*[@label='" + extra + "']")).click();
    }

    @Override
    public void ScrollDownToContinueBtn() {
        scrollDownTo(ContinueCTA);
        waitForVisibility(ContinueCTA);
    }

    @Override
    public void userChooseAnExtraFromAddExtraList() {
        waitForVisibility(addExtrasContinueCTA);
        addExtrasContinueCTA.click();

    }

    @Override
    public void userEntersCVVAndPaymentPasscodeIfNeeded(String CVV) throws InterruptedException {
        waitForVisibility(continueCTA);
        ArrayList<WebElement> list = (ArrayList<WebElement>) paymentMethodOverlayName.findElements(By.xpath(paymentMethodOverlayElements));
        list.get(0).click();
        list.get(0).sendKeys(CVV);
        continueCTA.click();
        Thread.sleep(6000);

    }

    @Override
    public void clickExtraTile() {
        waitForVisibility(addExtrasTile);
        addExtrasTile.click();
        waitForVisibility(addExtrasOverlayTitle);
    }

    public void getPlanIdAndExtraId() {
        queryParameters = new HashMap<String, String>() {{
            put(dataType, valueDataExtra);
        }};
        headers = new HashMap<String, String>() {{
        }};
        listExtrasResponseModel = ListExtrasUtils.getListExtras(headers, queryParameters);
        planId = listExtrasResponseModel.planId;
        extraId = listExtrasResponseModel.categories.get(0).addonCategoryInfo.addonList.get(0).id;
        System.out.println("planId   " + planId + "   extraId   " + extraId);
    }

    public void getTransRefAndURL() throws JsonProcessingException {
        headers = new HashMap<String, String>() {{
            put(keyOrderType, valueAddExtra);
            put(contentTypeKey, contentTypeValue);

        }};
        beginCardPaymentResponseModel = BeginCardPaymentUtils.getBeginCardPaymentResponse(Integer.toString(planId), Integer.toString(extraId), headers);
        transactionRef = beginCardPaymentResponseModel.transactionReference;
        redirectURL = beginCardPaymentResponseModel.redirectUrl;
        System.out.println("redirectURL   " + redirectURL);

    }


    public ProcessCardPaymentResponseModel callProcessCardPayment(String orderType) throws JsonProcessingException {
        ProcessCardPaymentResponseModel processCardPaymentResponseModel;
        headers = new HashMap<String, String>() {{
            put(keyOrderType, orderType);
            put(contentTypeKey, contentTypeValue);

        }};
        processCardPaymentResponseModel = ProcessCardPaymentUtils.getProcessCardPaymentResponse(Integer.toString(planId), Integer.toString(extraId), transactionRef, headers);
        return processCardPaymentResponseModel;

    }


}
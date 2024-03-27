package pages.RedHybrid.ConfirmExtrasPurchase_BeforeAuthorizationStatus;

import com.fasterxml.jackson.core.JsonProcessingException;
import models.response.BeginCardPaymentResponseModel;
import models.response.ProcessCardPaymentResponseModel;
import models.response.common.ListExtrasResponseModel;
import org.openqa.selenium.By;
import org.testng.Assert;
import utils.BeginCardPaymentUtils;
import utils.ListExtrasUtils;
import utils.ProcessCardPaymentUtils;

import java.util.HashMap;
import java.util.Map;

import static utils.element_helpers.ScrollHelpers.scrollDownTo;
import static utils.element_helpers.VerifyHelpers.AssertDisplayed;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

public class ConfirmExtrasPurchase_BeforeAuthorizationStatus_Android extends ConfirmExtrasPurchase_BeforeAuthorizationStatus_Abstract {

    String transactionRef;
    String redirectURL;
    Map<String, String> headers;
    Map<String, String> queryParameters;
    String keyOrderType = "orderType";
    String contentTypeKey = "Content-Type";
    String contentTypeValue = "application/json;charset=UTF-8";
    String dataType = "extraType";
    String valueDataExtra = "Data";
    String valueAddExtra = "add-extra";
    public int planId;
    public int extraId;

    ProcessCardPaymentResponseModel processCardPaymentResponseModel;
    ListExtrasResponseModel listExtrasResponseModel;
    BeginCardPaymentResponseModel beginCardPaymentResponseModel;

    public ConfirmExtrasPurchase_BeforeAuthorizationStatus_Android() {
        super();
    }

    @Override
    public void assertThatConfirmYourPurchaseOverlayDisplayed() {
        waitForVisibility(paySecurelyCTA);
    }

    @Override
    public void assertThatConfirmYourPurchaseOverlayUIDisplayed(){
        //Assert that title name is correct
        String expectedTitleName =RedHybridTitle.getText();
        String actualTitleName = processCardPaymentResponseModel.title;
        Assert.assertEquals(actualTitleName, expectedTitleName);


        //Assert that prodcut name is correct
        String expectedProductName =productName.getText();
        String actualProductName =processCardPaymentResponseModel.card.productName;
        Assert.assertEquals(actualProductName, expectedProductName);

        //Assert that prodcut price is correct
        String expectedProductPrice =productPrice.getText();
        String actualProductPrice = processCardPaymentResponseModel.card.productPrice;
        Assert.assertEquals(actualProductPrice, expectedProductPrice);

        //  Assert that prodcut description is correct
        String expextedProductDesc = productDesc.getText();
        String actualProductDesc = processCardPaymentResponseModel.card.productDesc;
        Assert.assertEquals(actualProductDesc, expextedProductDesc);

        AssertDisplayed(confirmPlanHeader.isDisplayed());
        AssertDisplayed(xCTA.isDisplayed());
        AssertDisplayed(confirmPlanChangeNote.isDisplayed());
    }


    @Override
    public void screenUIAPIResponseCombatability(String ExtraGroup,String ExtraName, String orderType) throws JsonProcessingException {
        getPlanIdAndExtraId(ExtraGroup ,ExtraName);
        getTransRefAndURL();
        BeginCardPaymentUtils.submitCvvWithTransRef(redirectURL, "234");
        processCardPaymentResponseModel = callProcessCardPayment(orderType);
        assertThatConfirmYourPurchaseOverlayUIDisplayed();
    }

    @Override
    public void SelectExtra(String extra) {
        driver.findElement(By.xpath("//*[@text='" + extra + "']")).click();

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
    public void userEntersCVVAndPaymentPasscodeIfNeeded(String CVV)  {
        waitForVisibility(continueCTA);
        CardSecurityCode.sendKeys(CVV);
        continueCTA.click();
    }

    @Override
    public void clickExtraTile() {
        waitForVisibility(addExtrasTile);
        addExtrasTile.click();
        waitForVisibility(addExtrasOverlayTitle);
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

    public void getTransRefAndURL() throws JsonProcessingException {
        headers = new HashMap<String, String>() {{
            put(keyOrderType, valueAddExtra);
            put(contentTypeKey, contentTypeValue);

        }};
        beginCardPaymentResponseModel = BeginCardPaymentUtils.getBeginCardPaymentResponse(Integer.toString(planId), Integer.toString(extraId), headers);
        transactionRef = beginCardPaymentResponseModel.transactionReference;
        redirectURL = beginCardPaymentResponseModel.redirectUrl;
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




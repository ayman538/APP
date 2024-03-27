package pages.RedHybrid.ConfirmChangePlanOverlay;

import com.fasterxml.jackson.core.JsonProcessingException;
import models.response.HybridBundelsResponseModel;
import models.response.ProcessCardPaymentResponseModel;
import org.testng.Assert;
import utils.HybridBundelsUtils;
import utils.ProcessCardPaymentUtils;

import java.util.HashMap;
import java.util.Map;

import static utils.element_helpers.ScrollHelpers.scrollDownTo;
import static utils.element_helpers.VerifyHelpers.AssertDisplayed;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

public class ConfirmChangePlanOverlay_iOSLogic extends ConfirmChangePlanOverlay_Abstract {
    ProcessCardPaymentResponseModel processCardPaymentResponseModel;
    Map<String, String> queryParameters;
    String orderType = "change-next";
    String keyOrderType = "orderType";
    String valueChangeNext = "change-next";
    String contentTypeKey = "Content-Type" ;
    String contentTypeValue = "application/json;charset=UTF-8" ;
    Map<String, String> headers ;

    public ConfirmChangePlanOverlay_iOSLogic() {
        super();
    }

    @Override
    public void clickContinueCTA() {
        scrollDownTo(ContinueCTA);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        ContinueCTA.click();    }

    @Override
    public void changePlanOverlayAppears() {
        waitForVisibility(confirmChangePlanOverlayHeader);
        AssertDisplayed(confirmChangePlanOverlayTitle.isDisplayed());
    }

    @Override
    public void changePlanOverlayUiIsCorrect() throws JsonProcessingException, InterruptedException {
        String planId = callHybridBundlesAPI();
        headers = new HashMap<String, String>() {{
            put(keyOrderType, valueChangeNext);
            put(contentTypeKey, contentTypeValue);
        }};
        processCardPaymentResponseModel = callProcessCardPaymentAPI(planId, orderType,headers);
        String expectedConfirmChangePlanHeader = confirmChangePlanOverlayHeader.getText();
        String actualConfirmChangePlanHeader = processCardPaymentResponseModel.title;
        Assert.assertEquals(expectedConfirmChangePlanHeader, actualConfirmChangePlanHeader);

        String expectedConfirmChangePlanTitle = confirmChangePlanOverlayTitle.getText();
        String actualConfirmChangePlanTitle = processCardPaymentResponseModel.card.title;
        Assert.assertEquals(expectedConfirmChangePlanTitle, actualConfirmChangePlanTitle);

        String expectedProductName = confirmPlanChangePlanDeatils.getText();
        String actualProductName = processCardPaymentResponseModel.card.productName;
        Assert.assertEquals(expectedProductName, actualProductName);

        String expectedProductDesc = confirmPlanChangePlanDesc.getText();
        String actualProductDesc = processCardPaymentResponseModel.card.productDesc;
        Assert.assertEquals(expectedProductDesc, actualProductDesc);


        String expectedProductPrice = confirmPlanChangePlanPrice.getText();
        String actualProductPrice = processCardPaymentResponseModel.card.productPrice;
        Assert.assertEquals(expectedProductPrice, actualProductPrice);

        String expectedChangeNotesDesc = confirmPlanChangenotesDescription.getText();
        String actualChangeNotesDesc = processCardPaymentResponseModel.card.note1;
        Assert.assertEquals(expectedChangeNotesDesc, actualChangeNotesDesc);

        String expectedconfirmNextPlanCTAName = confirmNextPlanCTA.getText();
        String actualconfirmNextPlanCTAName = processCardPaymentResponseModel.card.action.text;
        Assert.assertEquals(expectedconfirmNextPlanCTAName, actualconfirmNextPlanCTAName);

    }

    public String callHybridBundlesAPI() throws InterruptedException {
        queryParameters = new HashMap<String, String>() {{
            put("orderType", "change-next");
        }};
        HybridBundelsResponseModel hybridBundles;
        hybridBundles = HybridBundelsUtils.getHybridBundelsResponse(queryParameters);
        Thread.sleep(1000);
        Assert.assertNotEquals(hybridBundles.items.get(0).planId, null);
        return hybridBundles.items.get(0).planId;
    }

    public ProcessCardPaymentResponseModel callProcessCardPaymentAPI(String planId, String TransReference ,Map<String, String> headers) throws JsonProcessingException {
        ProcessCardPaymentResponseModel processCardPayment;
        processCardPayment = ProcessCardPaymentUtils.getProcessCardPaymentResponse(planId, TransReference, headers);
        return processCardPayment;
    }

    @Override
    public void clickOnTurnOnCTA() {
        waitForVisibility(RH_TurnOnToggleCTA);
        RH_TurnOnToggleCTA.click();
    }
}

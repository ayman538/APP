package pages.RedHybrid.confirmPurchace_Cancelled_Failed;

import com.fasterxml.jackson.core.JsonProcessingException;
import models.response.BeginCardPaymentResponseModel;
import models.response.HybridBundelsResponseModel;
import models.response.ProcessCardPaymentResponseModel;

public abstract class ConfirmPurchace_Cancelled_Failed_Abstract extends ConfirmPurchace_Cancelled_Failed_PO{

    public ConfirmPurchace_Cancelled_Failed_Abstract(){
        super();
    }
    public abstract void paymentMethodOverlayAppears();
    public abstract void paymentMethodScreenInsertNameAndCVV(String name, String cvv) throws InterruptedException;
    public abstract void clickOnPayNow();
    public abstract void pwdScreenIsVisible();
    public abstract void paymentMethodInsertPassword(String pwd);
    public abstract void clickSubmitPassword();
    public abstract void validateIncorrectPwd();
    public abstract void paymentErrorScreenIsVisible() throws InterruptedException;
    public abstract void paymentErrorTryAgainCTAClick();
    public abstract void paymentErrorDismissButtonClick();
    public abstract void paymentScreenCancelCTAClick() throws InterruptedException;
    public abstract void
    paymentErrorScreenUIValidationFailedStatus(HybridBundelsResponseModel hybrid, BeginCardPaymentResponseModel begin, ProcessCardPaymentResponseModel process) throws  JsonProcessingException;
    public abstract void paymentErrorCancelledStatus(HybridBundelsResponseModel hybrid, BeginCardPaymentResponseModel begin, ProcessCardPaymentResponseModel process) throws JsonProcessingException;
}

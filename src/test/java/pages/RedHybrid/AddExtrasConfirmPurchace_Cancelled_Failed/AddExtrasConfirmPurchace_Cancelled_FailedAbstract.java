package pages.RedHybrid.AddExtrasConfirmPurchace_Cancelled_Failed;

import com.fasterxml.jackson.core.JsonProcessingException;

public abstract class AddExtrasConfirmPurchace_Cancelled_FailedAbstract extends AddExtrasConfirmPurchace_Cancelled_FailedPo {

    public AddExtrasConfirmPurchace_Cancelled_FailedAbstract() {
        super();
    }

    public abstract void paymentMethodScreenInsertCVV(String cvv) throws InterruptedException;

    public abstract void ClickOnContinueAddExtra();

    public abstract void AddExtraPaymentMethodOverlayAppears();

    public abstract void paymentErrorOverlayFailedStatusValidation() throws JsonProcessingException;

}

package pages.RedHybrid.ConfirmExtrasPurchase_BeforeAuthorizationStatus;

import com.fasterxml.jackson.core.JsonProcessingException;

public abstract class ConfirmExtrasPurchase_BeforeAuthorizationStatus_Abstract extends ConfirmExtrasPurchase_BeforeAuthorizationStatus_PO {
    public ConfirmExtrasPurchase_BeforeAuthorizationStatus_Abstract() {
        super();
    }


    public abstract void assertThatConfirmYourPurchaseOverlayDisplayed();

    public abstract void assertThatConfirmYourPurchaseOverlayUIDisplayed() throws JsonProcessingException;

    public abstract void userChooseAnExtraFromAddExtraList();

    public abstract void userEntersCVVAndPaymentPasscodeIfNeeded(String CVV) throws InterruptedException;

    public abstract void clickExtraTile();

    public abstract void screenUIAPIResponseCombatability(String ExtraGroup,String ExtraName, String orderType) throws JsonProcessingException;

    public abstract void  SelectExtra(String extra);

    public abstract void  ScrollDownToContinueBtn();
}

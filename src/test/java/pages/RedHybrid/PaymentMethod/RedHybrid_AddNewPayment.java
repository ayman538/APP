package pages.RedHybrid.PaymentMethod;

import pages.DX_IDM.FullLogin.DX_IDM_FullLoginLogic;
import testdata.ReadResponse;

public abstract class RedHybrid_AddNewPayment extends RedHybrid_AddNewPaymentPO {
    //private final String Card;

    public RedHybrid_AddNewPayment() {
        super();
        //Card = ReadResponse.GetPaymentCardList();
    }

    public abstract void TapOnPayment();

    public abstract void TapOnVerifyCTA();

    public abstract void PaymentDrawerIsOpened();

    public abstract void ValidateLoginScreenIsDisplayed();

    public abstract void ValidateAddNewPaymentMethod();

    public abstract void TapOnAddNewCard();

    public abstract void ValidateAddPaymentMethodScreen();

    public abstract void ValidateAddPaymentMethodScreenContent();

    public abstract void TurnOnTheToggles();

    public abstract void TapOnXIcon();

    public abstract void TapOnAndroidPhysicalBack();

    public abstract void ValidateDashboardIsDisplayed();

    public abstract void ValidateContinueCTAIsClickable();

    public abstract void ValidatePaymentCardIsAdded();

    public abstract void ValidateXIconCloseTheFlow();

    public abstract void ValidateSoftCloseTheApp();

    public abstract void ClickOnBackIcon();

    public abstract void XiconIsNotDisplayed();



}


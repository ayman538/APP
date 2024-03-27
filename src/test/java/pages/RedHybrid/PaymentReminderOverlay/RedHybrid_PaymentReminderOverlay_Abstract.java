package pages.RedHybrid.PaymentReminderOverlay;

public abstract class RedHybrid_PaymentReminderOverlay_Abstract extends RedHybrid_PaymentReminderOverlay_PO {
    public RedHybrid_PaymentReminderOverlay_Abstract() {super();}

    public abstract void checkReminderOverlayUI() throws InterruptedException;

    public abstract void clickOnCloseButton();

    public abstract void clickOnAddPaymentCTA();

    public abstract void validateAddPaymentScreen() throws InterruptedException;

    public abstract void dissmissAddPayment();

    public abstract void clickOnRemovePaymentCTA();

    public abstract void clickOnBackToVodafoneCTA();

    public abstract void hardCloseAppAndLaunchIt() throws InterruptedException;
    public abstract void ValidatePaymentOverlay();

    public abstract void ClickOnSkipSoftLoginPrompt();

}

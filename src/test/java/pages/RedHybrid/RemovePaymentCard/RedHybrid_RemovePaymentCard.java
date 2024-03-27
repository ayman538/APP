package pages.RedHybrid.RemovePaymentCard;

public abstract class RedHybrid_RemovePaymentCard extends RedHybrid_RemovePaymentCardPO {


    public RedHybrid_RemovePaymentCard() {
        super();
    }

    public abstract void beforeRemovingCard();

    public abstract void initializePayment() throws InterruptedException;

    public abstract void processingCard();

    public abstract void addCardDetails(String cardName, String cardNo, String cardExpiryMonth, String cardExpiryYear, String cardCVV) throws InterruptedException;


    public abstract void addCardAddress();

    public abstract void addPaymentCard();

    public abstract void checkAddedPaymentCardUI();

    public abstract void clickEditCancelCTA();

    public abstract void clickCancelCTA();

    public abstract void checkUIAfterPressingEditCTA();

    public abstract void clickRemoveCTA();

    public abstract void checkRemovePopUp() throws InterruptedException;

    public abstract void clickRemoveInConfirmationPopUp() throws InterruptedException;

    public abstract void clickCancelInConfirmationPopUp() throws InterruptedException;

    public abstract void checkAddPaymentAppearAfterRemovingCard();

    public abstract void pressXBtn();

    public abstract void checkDashboardAppears();

    public abstract void openDeepLinkForPlanTab();
}


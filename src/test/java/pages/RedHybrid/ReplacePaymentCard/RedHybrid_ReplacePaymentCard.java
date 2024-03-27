package pages.RedHybrid.ReplacePaymentCard;

public abstract class RedHybrid_ReplacePaymentCard extends RedHybrid_ReplacePaymentCardPO {


    public RedHybrid_ReplacePaymentCard() {
        super();
    }

    public abstract void beforeReplacingCard();

    public abstract void processingCard();

    public abstract void addCardDetails(String cardName, String cardNo, String cardExpiryMonth, String cardExpiryYear, String cardCVV) throws InterruptedException;

    public abstract void addCardAddress();

    public abstract void addPaymentCard();

    public abstract void replaceCard();

    public abstract void checkAddPaymentAppearsAfterReplaceCard();

    public abstract void pressPhysicalBack();

    public abstract void checkDashboardAppears();

    public abstract void addDifferentCardDetails() throws InterruptedException;

    public abstract void addSameCardDetails() throws InterruptedException;

    public abstract void checkAddDone();

    public abstract void checkReplaceCardScreen();

    public abstract void pressXBtn();

    public abstract void agreeOnTermsAndConditions();

    public abstract void clickOnContinueCTA();

    public abstract void enterPostCodeAndSearch(String postCode);

    public abstract void selectPostCodeFirstAddress();

    public abstract void scrollDownToBillingBottom();

    public abstract void insertUserPaymentDerails(String name, String cardNumber, String expiryDate, String expiryYear, String cvv) throws InterruptedException;

    public abstract void processingScreenValidation();
}


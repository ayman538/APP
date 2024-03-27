package pages.NewBilling;

public abstract class Billing_Abstract extends BillingPO {


    public Billing_Abstract(){
        super();

    }
    public abstract void validateDashboardAppearance();

    public abstract void closeTheTutorial();

    public abstract void waitForTheBillingDashboard();

    /*Getting the index of the Future bill card*/
    public abstract int getTheIndexOfTheBillCard(String cardType);



    /*The Billing Title Card*/
    public abstract void navigateToNewBilling();
    public abstract void assertBillTitleIsDisplayed();
    public abstract void assertBillTitleCardXiconIsDisplayed();
    public abstract void ValidateTheBillingTitleCardExistence();
    public abstract void clickOnBilligTitleCardXCTA();
    /*FutureBillCard*/
    public abstract void validateTheBillCardExistence(String cardType);

    public abstract void validateTheBillCradContainsTheMonthOfTheBillExistence(String cardType);

    public abstract void validateiIconExistence(String cardType);

    public abstract void validateEstimatedTotalTextExistence(String cardType);

    public abstract void clickOnTheArrowIcon(String cardType);

    public abstract void validateTheFutureBillReinventJourenyIsOpen() throws InterruptedException;

    public abstract void validateAmountOfChargesExistence(String cardType);

    public abstract void validateBillStatusInfoExistence(String cardType);

    public abstract void validateTheFirstBillReinventJourneyIsOpen();

    public abstract void validateMonthCycleExistence();

    public abstract void validateTheLatestBillReinventJourenyIsOpen();

    public abstract void validatePaymentOverDueCardExistence();


    public abstract void validatePaymentOverDueCardIconExistence();

    public abstract void validatePaymentOverDueCardSubtitleExistence();

    public abstract void validatePayBillNowCTAExistence();

    public abstract void clickOnThePayBillCTA();

    public abstract void validateThePaymentReinventJourneyIsOpened();

    public abstract void validateBillingTutorialTitleExistence();

    public abstract void validateBillingTutorialDescriptionExistence();

    public abstract void validateTutorialContinueCTAExistence();

    public abstract void clickOnTutorialContinueCTA();

    public abstract void closeTheBillingTutorial();

    public abstract void validateViewBilingFAQsCardExistence();

    public abstract void clickOnViewBilingFAQsCard();

    public abstract void validateBillingFAQsWebView();

    public abstract void checkManageCardsAndPaymentsCard();

    public abstract void clickOnMangeCardsAndPaymentsChevron();

    public abstract void checkNavigationToManagePayments() throws InterruptedException;

    public abstract void ValidateLoginScreenAppearsSuccessfullyForSMB();

    public void navigateToBilling() {
    }

    public abstract void validateTheExistenceOfVATTextBesideTheBillCard(String cardType);

    public abstract void validateBillGraphForServiceUser();
    public abstract void validateManageCardsPaymentsCardForServiceUser();
}


package pages.ClickToUpgrade.NewPlan;


public abstract class NewPlanAbstract extends NewPlanPO {
    public NewPlanAbstract() {
        super();
    }

    public abstract void verifyThatNewPlanPageTitleIsCorrect();
    public abstract void verifyThatNewPlanCardContainsCorrectDetails();
    public abstract void verifyThatNewPlanPaymentSummaryContainsCorrectDetails();
    public abstract void verifyThatNewPlanTermsAndConditionsContainsCorrectData ();
    public abstract void toggleTermsAndConditionsConfirmation();
    public abstract void clickOnContinueCTA();
    public abstract void verifyThatCheckoutModalIsDisplayed();
    public abstract void verifyThatApiFailureErrorScreenIsDisplayed();
    public abstract void clickOnConfirmThisChangeCTA();
    public abstract void verifyThatTheConfirmationScreenAppears();
    public abstract void verifyThatNewPlanCardSubscriptionsDisplayed();
    public abstract void verifyThatNewPlanCardHighlightsDisplayed();


    public abstract void clickOnSeeAllPlansCTA();
}
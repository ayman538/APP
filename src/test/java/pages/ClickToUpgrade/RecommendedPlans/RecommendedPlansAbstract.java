package pages.ClickToUpgrade.RecommendedPlans;


public abstract class RecommendedPlansAbstract extends RecommendedPlansPO {
    public RecommendedPlansAbstract() {
        super();
    }

    public abstract void verifyThatRecommendedPlansPageIsDisplayed();

    public abstract void verifyRecommendedPlanCardDetails();

    public abstract void chooseRecommendedPlan();

    public abstract void clickOnSeeAllPlansOnOurWebsite();

    public abstract void verifyThatTheUserIsAtAllPlansWebsite();

    public abstract void verifyThatTheChildUserGetsFullScreenError();

    public abstract void verifyThatFreeSubscriptionsDisplayed();

    public abstract void clickOnSeePlanDetailsButton();

    public abstract void verifyThatTheUserIsAtSeePlanDetailsWebview();

    public abstract void verifyThatTheRecommendedPlanHighlightsDisplayed();

    public abstract void verifyTheCurrentPlanCardDetails();

    public abstract void ValidateTheErrorScreenWhenUserIsnotEligible();

    public abstract void ValidateClickingOnCheckUpgradeEligibilityRedirectToSubsoverlay();

    public abstract void ClickonBacktoDashboardCTA();

    public abstract void ClickonXcloseCTA();

    public abstract void verifyThatShowMorePlansCTADisplayed();

    public abstract void clickOnShowMorePlansCTA();

    public abstract void verifyThatShowMorePlansCTADimmed();

    public abstract void verifyThatFiltersCTADisplayed();

    public abstract void clickOnFiltersCTA();

    public abstract void ClickOnFilterCTA(String FilterCTA);

    public abstract void setMinPrice(String minPrice);

    public abstract void setMaxPrice(String maxPrice);

    public abstract void validatePriceFilterResult();

    public abstract void verifyThatTheFilterCounterAndClearAllCTANotExist();

    public abstract void changeFilters(String planLength, String minPrice, String maxPrice, String data, String features);

    public abstract void verifyThatTheFilterCounterAndClearAllCTADisplayed();

    public abstract void clickOnClearAllCTA();

    public abstract void verifyThatTheFilterCounterAndClearAllCTANotDisplayedAndTheFiltersBackToDefault();

    public abstract void validateTheBlackBanner();

    public abstract void validateSimxTray();

    public abstract void scrollToFindSimxPlan();

    public abstract void iClickOnSeeAllSIMOPlansCTA();

    public abstract void iClickOnDismissalXCTA();

    public abstract void iClickOnFindOutMoreBanner();

    public abstract void ValidatePriceIncreaseCopy();

    public abstract void ClickOnRecommendedPlansCTA();

    public abstract void compareRoamingDetails();
}

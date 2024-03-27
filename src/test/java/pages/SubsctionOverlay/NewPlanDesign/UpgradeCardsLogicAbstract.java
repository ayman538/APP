package pages.SubsctionOverlay.NewPlanDesign;

public abstract class UpgradeCardsLogicAbstract extends  UpgradeCardsPO{
    static boolean eligibleFlag = false;
    static boolean notEligibleFlag = false;
    static boolean fancyFlag = false;
    static boolean changePlanFlag = false;
    static boolean callUsFlag = false;

    public UpgradeCardsLogicAbstract() {
        super();
    }

    public abstract void ValidateEligibleForUpgradeCard() throws InterruptedException;

    public abstract void assertEligibleForUpgradeCardText() throws InterruptedException ;

    public abstract void ValidateEligibleForUpgradeCardCTA() ;

    public abstract void assertEligibleForUpgradeCardCTA() ;

    public abstract void assertLoginXIconDisplayed() ;

    public abstract void ValidateNotEligibleForUpgradeCard() throws InterruptedException ;

    public abstract void assertNotEligibleForUpgradeCardText() throws InterruptedException ;

    public abstract void ValidateFancyCard() throws InterruptedException;

    public abstract void assertFancyCardText() throws InterruptedException;

    public abstract void ValidateFancyCardCTA();

    public abstract void LoginXIconCTA() ;
    public abstract void assertFancyCardCTA() ;

    public abstract void ValidateChangePlanCard() throws InterruptedException;

    public abstract void assertChangePlanCardText() throws InterruptedException ;

    public abstract void ValidateChangePlanCardCTA() ;
    public abstract void assertChangePlanCardCTA();

    public abstract void ValidateEligibleForUpgradeCardMBB() throws InterruptedException;
    public abstract void ValidateEligibleForCallUsCardCTA();

    public abstract void assertEligibleForCallUsCTA() ;

    public abstract void clickOnUpgradeNowCTA() ;

    public abstract void clickOnCChoosePhonePlanCTA() ;

    public abstract void AssertUpgradePoPupIsDisplayed() ;

    public abstract void AssertRedirectToEshopAndUpgradeJourney() throws InterruptedException;

    public abstract void AssertPOPUI() ;
    public abstract void ClosePopup() ;

    public abstract void AssertUserInPlanTab() ;

    public abstract void AssertRedirectToTradeInSDK() ;

    public abstract void validateUpgradeCardHasSIMOAndHandsetUpgrades() ;
    public abstract void clickOnBrowsePhone() ;
    public abstract void ValidateDiscountCardAppearance();

    public abstract void ValidateDiscountCardContent();
    public abstract void validateAomRecommendationReason();
    public abstract void ValidateBrandsIconsCarousel() throws InterruptedException;

    public abstract void validateUpgradeTypes();

    public abstract void GoToViewFullOffersCTA();

    public abstract void GoToSeeMoreDevicePlanCTA();
    public abstract void validateASACopy();
}

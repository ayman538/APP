package pages.SubsctionOverlay.NewPlanDesign;

public abstract class UnlimitedDataBoosterAbstract extends UnlimitedDataBoosterPO {

    public UnlimitedDataBoosterAbstract() {
        super();
    }
    public abstract void assertActivateByTextDisplayed();

    public abstract void assertChatNowCTADisplayed();

    public abstract void clickChatNowCTA();

    public abstract void navigateToYourPlans();

    public abstract void clickUnlimitedDataBooster();

    public abstract void clickChangeYourAirtimePlan();

    public abstract void assertLoginScreenIsOpened();

    public abstract void assertCountersAreDisplayed();

    public abstract void assertActiveCounterNotDisplayed();
}

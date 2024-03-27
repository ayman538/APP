package pages.Tray.Rewards;

public abstract class RewardsAbstract extends RewardsPO{
    public abstract void checkVeryMeInRewardsTrayForPAYGMPS();
    public abstract void checkOffersForYouInRewardsTray();
    public abstract void assertDBLassie() throws InterruptedException;
    public abstract void clickVeryMeInDBTray();
    public abstract void checkClickingOffersForYou();
    public abstract void assertPontisOffer();
    public abstract void clickOnOffersForYou();
    public abstract void assertLoginScreen();
    public abstract void goToRewardsTray();
    public abstract void checkVeryMeInRewards() throws InterruptedException;
}

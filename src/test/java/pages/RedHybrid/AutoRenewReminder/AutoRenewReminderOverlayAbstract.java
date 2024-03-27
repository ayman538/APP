package pages.RedHybrid.AutoRenewReminder;

public abstract class AutoRenewReminderOverlayAbstract extends AutoRenewReminderPO{

    public abstract void checkAutoRenewOverlayUI() throws InterruptedException;
    public abstract void clickOnTurnOnCTA();
    public abstract void planTabIsDisplayed();
}

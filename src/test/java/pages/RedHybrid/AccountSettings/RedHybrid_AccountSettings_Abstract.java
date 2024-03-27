package pages.RedHybrid.AccountSettings;

public abstract class RedHybrid_AccountSettings_Abstract extends RedHybrid_AccountSettings_PO{

    public RedHybrid_AccountSettings_Abstract() {super();}

    public abstract void clickOnAccount();

    public abstract void validateAccountSettingsTitlesAndArrangement();

    public abstract void validateDataNotificationsNotAppearInAccountSettings();

    public abstract void validateAccessibilityAppearInAccountSettings();

    public abstract void closeMyAccountSheet();

    public abstract void iClickOnLink(String linkName);
    public abstract void iNavigateToThePage(String PageTitle) throws InterruptedException;
}

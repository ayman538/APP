package pages.RedHybrid.DashboardTray;

public abstract class RedHybrid_DashboardTray_Abstract extends RedHybrid_DashboardTray_PO {

    public RedHybrid_DashboardTray_Abstract() {
        super();
    }

    public abstract void validateTrayItems();

    public abstract void checkTargetOfMyAccount() throws InterruptedException;

    public abstract void checkTargetOfVeryMe() throws InterruptedException;

    public abstract void checkTargetOfTOBi() throws InterruptedException;
    public abstract void CloseTobi() throws InterruptedException;
    public abstract void checkTargetOfPayments() throws InterruptedException;

    public abstract void checkTargetOfSettings() throws InterruptedException;

    public abstract void DismissSkipLoginScreen();

    public abstract void acceptCookies();


    public abstract void clickOnPaymentTray() throws InterruptedException;
    public abstract void clickOnMyAccount() throws InterruptedException;
    public abstract void clickOnMyAccountTray() throws InterruptedException;


    public abstract void clickOnSettings();

    public abstract  void clickOnPayment () throws InterruptedException;
    public abstract void validateThatTheDashboardTrayHiddenUnderMyAccount();
    public abstract void validateThatTheDashboardTrayHiddenUnderSettings();
    public abstract void  validateThatTheDashboardTrayHiddenUnderPayments();
    public abstract void OpenTobiAndSendMessage(String Message) throws InterruptedException;
    public abstract void CheckTobiResponse(String message);
}

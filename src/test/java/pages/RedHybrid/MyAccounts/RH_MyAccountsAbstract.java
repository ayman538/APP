package pages.RedHybrid.MyAccounts;

public abstract class RH_MyAccountsAbstract extends RH_MyAccountsPO {
    public abstract void validateMyAccountTrayTitle();
    public abstract void validateMyAccountSelectAnAccount();
    public abstract void verifyRedhybridAccountHasOnlyOneSubscription(int numOFSubs);
    public abstract void verifyMyAccountTrayWhenPAYMAccountLoggedIN();
    public abstract void  validateSelectOneTitle();
    public abstract void clickOnMyAccountsDropDown();
    public abstract void selectRedHybridAccount(String RedHybridMSISDN);
    public abstract void clickOnFlexiSubscriptionFromMyAccountsTray();
    public abstract void verifyFlexiSubscriptionTypeInDB();
    public abstract void switchToRootAccountSubsription(int subsIndex);
    public abstract void verifyRootAccountDashboardDisplayed() throws InterruptedException;
}

package stepdefs.RedHybrid;

import core.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.RedHybrid.MyAccounts.RH_MyAccountsAbstract;
import pages.RedHybrid.MyAccounts.RH_MyAccountsAndroid;
import pages.RedHybrid.MyAccounts.RH_MyAccountsiOS;

public class RH_MyAccounts {

    private RH_MyAccountsAbstract redHypridMyAccountsPage;

    public RH_MyAccounts(Config config)
    {
        if (config.isAndroid()){
            redHypridMyAccountsPage = new RH_MyAccountsAndroid();
        }
        else if (config.isIos())
        {
            redHypridMyAccountsPage = new RH_MyAccountsiOS();
        }
    }


    @Then("The logged In user see my accounts dropdown and list of subscriptions")
    public void Validate_RedHybrid_MyAccountsDrawer_Content()
    {

        redHypridMyAccountsPage.validateMyAccountTrayTitle();
        redHypridMyAccountsPage.validateMyAccountSelectAnAccount();
        redHypridMyAccountsPage.verifyMyAccountTrayWhenPAYMAccountLoggedIN();

    }
    @Then("The Flexi user should see my accounts dropdown and {int} Flexi subscription")
    public void  validateRedhybridNumberOfSubscription(int SubscriptionsNum) {
        redHypridMyAccountsPage.validateMyAccountTrayTitle();
        redHypridMyAccountsPage.validateMyAccountSelectAnAccount();
        redHypridMyAccountsPage.verifyRedhybridAccountHasOnlyOneSubscription(SubscriptionsNum);
    }

    @Then("RedHybrid user susbcription appears in My account")
    public void redhybridUserSusbcriptionAppearsInMyAccount() {
        redHypridMyAccountsPage.validateMyAccountTrayTitle();
    }



    @And("Click on my Accounts dropdown and choose {string} account")
    public void SwitchToRedHybridAccount(String RedHybridAccountID)
    {
        redHypridMyAccountsPage.clickOnMyAccountsDropDown();
        redHypridMyAccountsPage.selectRedHybridAccount(RedHybridAccountID);
    }

    @And("Click on Flexi subscription")
    public void switchToFlexiSubscription()
    {
        redHypridMyAccountsPage.clickOnFlexiSubscriptionFromMyAccountsTray();
    }
    @Then("Flexi account Dashboard Displayed")
    public void verifyFlexiAccountDashboardDisplayed()
    {
        redHypridMyAccountsPage.verifyFlexiSubscriptionTypeInDB();
    }
    @And("Click on subscription")
    public void SwitchToRootAccountSubscription()
    {
        redHypridMyAccountsPage.switchToRootAccountSubsription(1);
    }
    @Then("Root account Dashboard displayed")
    public void verifyRootAccountDashboardDisplayed() throws InterruptedException {
        redHypridMyAccountsPage.verifyRootAccountDashboardDisplayed();
    }



}

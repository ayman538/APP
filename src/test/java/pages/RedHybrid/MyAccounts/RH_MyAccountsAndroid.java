package pages.RedHybrid.MyAccounts;

import models.response.AccountsResponseModel;
import models.response.SubscriptionsResponseModel;
import org.testng.Assert;
import utils.AccountsUtils;
import utils.SubscriptionsUtils;

import java.util.Properties;

import static utilities.PropertiesLoader.readPropertyFile;
import static utils.element_helpers.VerifyHelpers.assertDisplayed;
import static utils.element_helpers.VerifyHelpers.assertEquals;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

public class RH_MyAccountsAndroid extends RH_MyAccountsAbstract {
    AccountsResponseModel accountsResponseModel;
    SubscriptionsResponseModel subscriptionsResponseModel;

    @Override
    public void validateMyAccountTrayTitle() {
        waitForVisibility(RedHybridMyAccountTitle);
        assertDisplayed(RedHybridMyAccountTitle, 100);
        Assert.assertEquals(RedHybridMyAccountTitle.getText(), "My account");
        String actualSusbcriptionType = getAccountSubscriptions();
        String expectedSusbcriptionType = myAccSubscriptionType.getText();
        Assert.assertEquals(actualSusbcriptionType, expectedSusbcriptionType);
    }

    public String getAccountSubscriptions() {
        Properties envProp = readPropertyFile("config/env.properties");
        //String msisdn = System.getProperty("MSISDN", envProp.getProperty("MSISDN"));
        String segment = System.getProperty("Segment", envProp.getProperty("Segment"));
        String subscriptionType = System.getProperty("SubscriptionType",envProp.getProperty("SubscriptionType"));
        accountsResponseModel = AccountsUtils.getAccounts(segment, subscriptionType);
        String accountId = accountsResponseModel.accounts.get(0).accountId;
        String accountIdHash = accountsResponseModel.accounts.get(0).accountIdHash;
        String accountType = accountsResponseModel.accounts.get(0).accountType;
        subscriptionsResponseModel = SubscriptionsUtils.getSubscriptions(segment, subscriptionType, accountId, accountIdHash, accountType);
        return subscriptionsResponseModel.subscriptions.get(0).subscriptionType.riderText;
    }


    @Override
    public void validateMyAccountSelectAnAccount() {
        waitForVisibility(RedHybridMyAccountSelectAccountTitle);
        assertDisplayed(RedHybridMyAccountSelectAccountTitle, 100);
        Assert.assertEquals(RedHybridMyAccountSelectAccountTitle.getText(), "Select an account");
    }


    @Override
    public void verifyRedhybridAccountHasOnlyOneSubscription(int numOFSubs) {
        Assert.assertTrue(AccountSubscriptionsList.size() == numOFSubs);

    }

    @Override
    public void verifyMyAccountTrayWhenPAYMAccountLoggedIN() {
        validateSelectOneTitle();
        waitForVisibility(RedHybrid_MyAccountSelectAccountDropDown);
        assertDisplayed(RedHybrid_MyAccountSelectAccountDropDown, 100);
        Assert.assertTrue(AccountSubscriptionsList.size() > 1);
        System.out.println("Account with No Childs");

    }

    @Override
    public void validateSelectOneTitle() {
        waitForVisibility(RedHybridSelectOneTitle);
        assertDisplayed(RedHybridSelectOneTitle, 100);
        assertEquals(RedHybridSelectOneTitle.getText(), "Select one");
    }

    @Override
    public void clickOnMyAccountsDropDown() {

        waitForVisibility(RedHybrid_MyAccountSelectAccountDropDown);
        RedHybrid_MyAccountSelectAccountDropDown.click();
    }

    @Override
    public void selectRedHybridAccount(String selectRedHybridAccount) {
        for (int i = 0; i < MyAccountsList.size(); i++) {
            if (MyAccountsList.get(i).getText().equalsIgnoreCase(selectRedHybridAccount))
                MyAccountsList.get(i).click();
        }
    }

    @Override
    public void clickOnFlexiSubscriptionFromMyAccountsTray() {
        if (AccountSubscriptionsList.size() == 1)
            AccountSubscriptionsList.get(0).click();
    }

    @Override
    public void verifyFlexiSubscriptionTypeInDB() {
        waitForVisibility(DB_SubscriptionIconText);
        Assert.assertTrue(DB_SubscriptionIconText.getText().contains("Pay as you go Plus"));
    }

    @Override
    public void switchToRootAccountSubsription(int subsIndex) {
        AccountSubscriptionsList.get(subsIndex).click();
    }

    @Override
    public void verifyRootAccountDashboardDisplayed() throws InterruptedException {
        waitForVisibility(DB_SubscriptionIconText);
        Properties envFile = readPropertyFile("config/env.properties");
        String MSISDN;
        MSISDN = System.getProperty("MSISDN",envFile.getProperty("MSISDN"));
        MSISDN = "0" + MSISDN.substring(2);
        Assert.assertEquals(DB_SubscriptionMSISDNText.getText(),MSISDN);
    }


}

package stepdefs.TC_Tray.TC_MyAccount;

import core.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.simple.parser.ParseException;
import pages.Tray.MyAccount.MyAccountAbstract;
import pages.Tray.MyAccount.MyAccountAndroid;
import pages.Tray.MyAccount.MyAccountIOS;

import java.io.IOException;


public class MyAccount {
    MyAccountAbstract myAccountObj;

    public MyAccount(Config config) throws IOException {
        if (config.isAndroid()) myAccountObj = new MyAccountAndroid();
        if (config.isIos()) myAccountObj = new MyAccountIOS();
    }

    @Then("Validate MyAccount Drawer")
    public void TC01_ValidateMyAccountDrawer() throws ParseException {
        myAccountObj.ValidateMyAccountDrawer();
    }

    @Then("Validate MyAccount for Multiple Accounts Users")
    public void TC02_ValidateMultipleAccountsUsers() throws ParseException {
        myAccountObj.ValidateMultipleAccountsUsers();
    }


    @Then("Validate Switching to another Subscription")
    public void TC03_SwitchToSubscription() throws ParseException {
        myAccountObj.SwitchToSubscription("PayG");
    }

    @Then("Sub Switch to consumer or smb Subscription")
    public void subSwitchToConsumerOrSMBsubscription() throws ParseException {
        try {
            myAccountObj.SwitchToSubscription("MPS");
        } catch (Exception e) {
            e.printStackTrace();
            myAccountObj.SwitchToSubscription("MBB");
        }
    }

    @Then("I navigate to sub switch to {string} Subscription")
    public void subSwitchToSubscription(String SubscriptionType) throws ParseException {
        myAccountObj.SwitchToSubscription(SubscriptionType);
    }

    @Then("I navigate to sub switch to SubscriptionType {string} and Segment {string}")
    public void SwitchToSubscription(String SubscriptionType, String Segment) throws ParseException {
        myAccountObj.SwitchToSubscription(SubscriptionType, Segment);
    }

    @Then("I navigate to sub switch to Child")
    public void SwitchToSubscriptionWithoutTokens() {
        myAccountObj.SwitchToSubscriptionWithoutTokens();
    }

    @Then("Validate child dashboard appears")
    public void validateChildDashboardAppearsWithoutToken() {
        myAccountObj.validateChildDashboardAppearsWithoutToken();
    }

    @Then("I navigate to child")
    public void SwitchToChild() throws ParseException {
        myAccountObj.SwitchToChild();
    }

    @Then("I validate root account subscriptions")
    public void iValidateRootAccountSubscriptions() {

        myAccountObj.ValidateDefaultAccountSubscriptions();

    }

    @When("I login using multiple accounts user")
    public void iLoginUsingMultipleAccountsUser() {

        myAccountObj.getAccountsNumberForUser();
    }

    @Then("I Should validate all accounts and their Subscriptions")
    public void iShouldValidateAllAccountsAndTheirSubscriptions() {

        myAccountObj.ValidateAllMultipleAccountsUsers();
    }

    @Given("Click on My Account2")
    public void click_on_my_account2() {
        myAccountObj.clickOnMyAccount();
    }


    @Then("I Validate MyAccount Drawer")
    public void iValidateMyAccountDrawer() {
        myAccountObj.validateMyAccountDrawer();
    }

    @When("I Validate Data Usage tile is displayed")
    public void iValidateDataUsageTileIsDisplayed() {
        myAccountObj.validateDataUsageTile();
    }

    @And("I validate Charges tile is displayed")
    public void iValidateChargesTileIsDisplayed()
    {myAccountObj.validateChargesTile();}

    @Then("I validate secondary subscription not exist on subscriptions sub-overlay screen")
    public void iValidateSecondarySubscriptionNotExistOnSubscriptionsSubOverlayScreen() {
        myAccountObj.validateSecondarySubscriptionNotExist();
    }

}
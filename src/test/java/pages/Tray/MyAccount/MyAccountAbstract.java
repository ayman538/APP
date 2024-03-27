package pages.Tray.MyAccount;

import core.Config;
import models.response.SubscriptionsResponseModel;
import org.json.simple.parser.ParseException;
import pages.Login.Login_Abstract;
import pages.Login.Login_Logic_Android;
import pages.Login.Login_Logic_IOS;

import java.io.IOException;
import java.util.List;


public abstract class MyAccountAbstract extends MyAccountPO {

    private final Config config = new Config();
    private Login_Abstract login;


    public MyAccountAbstract() throws IOException {
        super();
        if (config.isAndroid()) login = new Login_Logic_Android();
        if (config.isIos()) login = new Login_Logic_IOS();
    }

    public abstract void checkLoginStatus() throws IOException, InterruptedException;

    public abstract void checkPinLoginForUserWithoutBiometrics() throws InterruptedException;

    public abstract void checkPinLoginForUserWithBiometrics() throws InterruptedException;

    public abstract void ValidateMyAccountDrawer() throws ParseException;

    public abstract void assertSubscriptionCardIsDisplayed(String MSISDN);

    public abstract void clickOnMyAccount();

    public abstract void ValidateMultipleAccountsUsers();

    public abstract void MultiAccountsValidation() throws ParseException;

    public abstract void SwitchToSubscription(String userType) throws ParseException;
    public abstract void SwitchToSubscription(String userType, String Segment);
    public abstract void SwitchToSubscriptionWithoutTokens();
    public abstract void validateChildDashboardAppearsWithoutToken();
    public abstract void SwitchingToAnotherSubscription(List<SubscriptionsResponseModel.Subscription> subscriptions, String userType);

    public abstract void SwitchingToAnotherSubscription(String userType) throws ParseException;

    public abstract void assertSubscriptionDashboardIsDisplayed(String MSISDN) throws ParseException;

    public abstract void ValidateMyAccountScreenUI();
    public abstract void ValidateDefaultAccountSubscriptions();

    public abstract void ValidateAllMultipleAccountsUsers();

    public abstract void validateSwitchAccountUI();

    public abstract void navigateToSwitchAccounts ();

    public abstract void getAccountsNumberForUser();

    public abstract void assertSubscriptionCardIsDisplayedIntoCarousel(String MSISDN) throws ParseException;

    public abstract void validateMyAccountDrawer();

    public abstract void validateDataUsageTile();

    public abstract void validateChargesTile();

    public abstract void validateSecondarySubscriptionNotExist();

    public void SwitchToChild() {
    }
}




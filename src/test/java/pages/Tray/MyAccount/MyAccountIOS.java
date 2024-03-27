package pages.Tray.MyAccount;

import core.Config;
import models.response.AccountsResponseModel;
import models.response.DashboardV4ResponseModel;
import models.response.SegmentResponseModel;
import models.response.SubscriptionsResponseModel;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.SkipException;
import pages.Login.Login_Abstract;
import pages.Login.Login_Logic_Android;
import pages.Login.Login_Logic_IOS;
import testdata.ReadResponse;
import utils.AccountsUtils;
import utils.DashboardUtils;
import utils.SegmentUtils;
import utils.SubscriptionsUtils;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import static core.Config.getLoginStatus;
import static core.Config.setLoginStatusStatus;
import static utilities.PropertiesLoader.readEnv;
import static utilities.PropertiesLoader.readPropertyFile;
import static utils.element_helpers.ScrollHelpers.SwipeToElement;
import static utils.element_helpers.TextHelpers.GetXpath;
import static utils.element_helpers.VerifyHelpers.AssertDisplayed;
import static utils.element_helpers.VerifyHelpers.elementIsPresent;
import static utils.element_helpers.WaitHelpers.waitForVisibility;
import static utils.element_helpers.WaitHelpers.waitForVisibilityForReinvent;

public class MyAccountIOS extends MyAccountAbstract {

    private final Config config = new Config();
    private Login_Abstract login;
    AccountsResponseModel accounts ;

    private static DashboardV4ResponseModel DashboardResponse ;
    Properties envProp = readPropertyFile("config/env.properties");
    By childSubCard = By.xpath("(//*[@name='wdgSubSwitchChildCard'])[2]");
    By childFriendlynameDrawer = By.xpath("(//*[@name='txtSubSwitchChildMSISDN'])[2]");
    By childFriendlynameDashboard = By.xpath("(//*[@name='txtSubscriptionMSISDN'])[1]");
    Boolean live = System.getProperty("isLiveTest", readEnv("isLiveTest")).equalsIgnoreCase("true");

    String FriendlyName;

    public MyAccountIOS() throws IOException {
        super();
        if (config.isAndroid()) login = new Login_Logic_Android();
        if (config.isIos()) login = new Login_Logic_IOS();
        if(!live) {
            DashboardResponse = DashboardUtils.GetDashboard();
            accounts = AccountsUtils.getAccounts();
        }

    }

    public void checkLoginStatus() throws IOException, InterruptedException {
        if (getLoginStatus().equalsIgnoreCase("False")) {
            login.LoginFlow();
        } else {
            checkPinLoginForUserWithoutBiometrics();
            checkPinLoginForUserWithBiometrics();
        }
    }

    public void checkPinLoginForUserWithoutBiometrics() throws  InterruptedException {
        boolean exist = true;
        boolean displayed = true;
        try {
            exist = Pin_Field.isDisplayed();
        } catch (Exception e) {
            exist = false;
        }
        try {
            displayed = CancelFingerPrintCTA.isDisplayed();
        } catch (Exception e) {
            displayed = false;
        }
        if (exist) {
            login.enterPin();
            Pin_ContinueCTA.click();
            setLoginStatusStatus("LoggedIn");
        } else if (displayed) {
            CancelFingerPrintCTA.click();
            waitForVisibility(Pin_Field);
        }
    }

    public void checkPinLoginForUserWithBiometrics() throws  InterruptedException {
        boolean displayed = true;
        try {
            displayed = login.CancelFingerPrintCTA.isDisplayed();
        } catch (Exception e) {
            displayed = false;
        }
        if (displayed) {
            login.CancelFingerPrintCTA.click();
            System.out.println("Wait till pin field");
            login.enterPin();
            System.out.println("Send the Pin key");
            Pin_ContinueCTA.click();
            setLoginStatusStatus("LoggedIn");
        }
    }

    public void ValidateMyAccountDrawer() throws ParseException {
        waitForVisibility(MyAccTitle);
        String MSISDN = "";
        if (ReadResponse.getSubsList().size() <= 1) {
            System.out.println("user has no subscriptions");
        } else {
            MSISDN = ReadResponse.getSubsList().get(0).get("msisdn");
            if (!ReadResponse.getSubsType(0).equalsIgnoreCase("BB")) {
                MSISDN = "0" + MSISDN.substring(2);
            }
            AssertDisplayed(driver.findElement(By.xpath("//*[@label='" + MSISDN + "']")).isDisplayed());
            for (int i = 1; i < ReadResponse.getSubsList().size() - 1; i++) {
                MSISDN = ReadResponse.getSubsList().get(i).get("msisdn");
                if (!ReadResponse.getSubsType(i).equalsIgnoreCase("BB")) {
                    MSISDN = "0" + MSISDN.substring(2);
                }
                assertSubscriptionCardIsDisplayed(MSISDN);
            }
        }
    }

    public void assertSubscriptionCardIsDisplayed(String MSISDN) {
        try {
            AssertDisplayed(driver.findElement(By.xpath("//*[@text='" + MSISDN + "']")).isDisplayed());
        }
        catch(Exception e){
            SwipeToElement(driver.findElement(By.xpath("//*[@text='" + MSISDN + "']")), "Right");
            AssertDisplayed(driver.findElement(By.xpath("//*[@text='" + MSISDN + "']")).isDisplayed());
        }
    }

    public void clickOnMyAccount() {
        waitForVisibility(DB_MyAccountTray_icon);
        DB_MyAccountTray_icon.click();
    }

    public void ValidateMultipleAccountsUsers() {
        waitForVisibility(MyAccTitle);
        AssertDisplayed(MyAccSelectAccountTitle.isDisplayed());
        if (accounts.accounts.size() > 1)
            MultiAccountsValidation();
        else throw new SkipException("The user has single account");
    }

    public void MultiAccountsValidation() {
        String MSISDN;
        String AccountID;
        for (int i = 0; i < accounts.accounts.size(); i++) {
            MyAccSelectAccountField.click();
            AccountID = accounts.accounts.get(i).accountId;
            driver.findElement(By.xpath("//*[@label='" + AccountID + "']")).click();
            SegmentResponseModel segmentAPI = SegmentUtils.GetSegment();
            SubscriptionsResponseModel subscriptions = SubscriptionsUtils.getSubscriptions(segmentAPI.segment,
                    segmentAPI.subscriptionType.name,
                    AccountID,
                    accounts.accounts.get(i).accountIdHash,
                    accounts.accounts.get(i).accountType);
            for (int j = 0; j < subscriptions.subscriptions.size(); j++) {
                MSISDN = subscriptions.subscriptions.get(j).msisdn;
                if (!subscriptions.subscriptions.get(j).subscriptionType.name.equalsIgnoreCase("BB")) {
                    MSISDN = "0" + MSISDN.substring(2);
                }
                assertSubscriptionCardIsDisplayed(MSISDN);
            }
        }
    }

    public void SwitchToSubscription(String userType) throws ParseException {
        waitForVisibility(MyAccTitle);
        SegmentResponseModel segmentResponseModel = SegmentUtils.GetSegment();
        AccountsResponseModel accountsResponseModel = AccountsUtils.getAccounts(segmentResponseModel.segment, segmentResponseModel.subscriptionType.name);

        SubscriptionsResponseModel subscriptionsResponseModel = SubscriptionsUtils.getSubscriptions(segmentResponseModel.segment,
                segmentResponseModel.subscriptionType.name,
                System.getProperty("LOA3AccountId"),
                accountsResponseModel.accounts.get(0).accountIdHash,
                accountsResponseModel.accounts.get(0).accountType);

        if (subscriptionsResponseModel.subscriptions.size() > 1)
            SwitchingToAnotherSubscription(subscriptionsResponseModel.subscriptions,userType);
        else throw new SkipException("The user has single account");
    }

    @Override
    public void SwitchToSubscription(String userType, String Segment) {
        SubscriptionsResponseModel subscriptions;
        SegmentResponseModel segment = SegmentUtils.GetSegment();
        subscriptions = SubscriptionsUtils.getSubscriptions(segment.segment,
                segment.subscriptionType.name,
                envProp.getProperty("accountId"),
                accounts.accounts.get(0).accountIdHash,
                accounts.accounts.get(0).accountType);
        waitForVisibilityForReinvent(MyAccTitle,100);
        if (subscriptions.subscriptions.size() > 1)
            SwitchingToAnotherSubscription(subscriptions.subscriptions, userType, Segment);
        else throw new SkipException("The user has single account");
    }

    @Override
    public void SwitchToSubscriptionWithoutTokens() {
        waitForVisibility(driver.findElement(childSubCard));
        FriendlyName = driver.findElement(childFriendlynameDrawer).getText();
        driver.findElement(childSubCard).click();
    }

    @Override
    public void validateChildDashboardAppearsWithoutToken() {
        waitForVisibility(DB_SettingDashboardTray_icon);
        Assertions.assertEquals(driver.findElement(childFriendlynameDashboard).getText(),FriendlyName);
    }

    public void SwitchingToAnotherSubscription(List<SubscriptionsResponseModel.Subscription> subscriptions, String userType,String RequiredSegment) {
        String FullMSISDN;
        String MSISDN;
        String SubType;
        String Segment;
        String AccountID;

        for (int i = 1; i < subscriptions.size(); i++) {
            FullMSISDN = subscriptions.get(i).msisdn;
            MSISDN = subscriptions.get(i).msisdn;
            SubType = subscriptions.get(i).subscriptionType.name;
            Segment=subscriptions.get(i).segment;
            AccountID=subscriptions.get(i).accountId;
            if (!SubType.equalsIgnoreCase("BB")) {
                MSISDN = "0" + MSISDN.substring(2);
            }
            SwipeToElement(driver.findElement(By.xpath(GetXpath(MSISDN))), "Right");
            AssertDisplayed(driver.findElement(By.xpath(GetXpath(MSISDN))).isDisplayed());
            if (SubType.equalsIgnoreCase(userType) && Segment.equalsIgnoreCase(RequiredSegment)) {
                System.setProperty("SwitchedMSISDN",FullMSISDN);
                System.setProperty("SwitchedSubsType",userType);
                System.setProperty("SwitchedSegment",Segment);
                System.setProperty("SwitchedAccount",AccountID);
                assertSubscriptionDashboardIsDisplayed(MSISDN);
                break;
            }
        }
    }

    public void SwitchingToAnotherSubscription(List<SubscriptionsResponseModel.Subscription> subscriptions, String userType) {
        String FullMSISDN;
        String MSISDN;
        String SubType;
        String Segment;
        String AccountID;

        for (int i = 1; i < subscriptions.size(); i++) {
            FullMSISDN = subscriptions.get(i).msisdn;
            MSISDN = subscriptions.get(i).msisdn;
            SubType = subscriptions.get(i).subscriptionType.name;
            Segment=subscriptions.get(i).segment;
            AccountID=subscriptions.get(i).accountId;
            if (!SubType.equalsIgnoreCase("BB")) {
                MSISDN = "0" + MSISDN.substring(2);
            }
            SwipeToElement(driver.findElement(By.xpath(GetXpath(MSISDN))), "Right");
            AssertDisplayed(driver.findElement(By.xpath(GetXpath(MSISDN))).isDisplayed());
            if (SubType.equalsIgnoreCase(userType)) {
                System.setProperty("SwitchedMSISDN",FullMSISDN);
                System.setProperty("SwitchedSubsType",userType);
                System.setProperty("SwitchedSegment",Segment);
                System.setProperty("SwitchedAccount",AccountID);
                assertSubscriptionDashboardIsDisplayed(MSISDN);
                break;
            }
            //need to throw an exception if the user has no this userType
            else throw new SkipException("the user has not this userType");
        }
    }

    public void SwitchingToAnotherSubscription(String userType) throws ParseException {
        String Segment;
        String MSISDN;
        for (int i = 1; i < ReadResponse.getSubsList().size(); i++) {
            Segment = ReadResponse.getSubsType(i);
            MSISDN = ReadResponse.getSubsList().get(i).get("msisdn");
            if (!ReadResponse.getSubsType(i).equalsIgnoreCase("BB")) {
                MSISDN = "0" + MSISDN.substring(2);
            }
            SwipeToElement(driver.findElement(By.xpath(GetXpath(MSISDN))), "Right");
            AssertDisplayed(driver.findElement(By.xpath(GetXpath(MSISDN))).isDisplayed());
            if (Segment.equalsIgnoreCase(userType)) {
                assertSubscriptionDashboardIsDisplayed(MSISDN);
                break;
            }
        }
    }

    public void assertSubscriptionDashboardIsDisplayed(String MSISDN) {
        driver.findElement(By.xpath(GetXpath(MSISDN))).click();
        waitForVisibilityForReinvent(DB_SettingDashboardTray_icon,100);
        waitForVisibilityForReinvent(driver.findElement(By.xpath(GetXpath(MSISDN))),100);
        AssertDisplayed(driver.findElement(By.xpath(GetXpath(MSISDN))).isDisplayed());
    }

    /**
     * validate my account screen Design for default account of a multi accounts user
     */
    public void ValidateMyAccountScreenUI(){
        ValidateMyAccountScreenUIForSingleUser();
        AssertDisplayed(SwitchAccountCTA.isEnabled());
    }
    public void navigateToSwitchAccounts(){
        waitForVisibility(SwitchAccountCTA);
        SwitchAccountCTA.click();
    }

    /**
     * Validate switch account screen
     */
    public void validateSwitchAccountUI(){
        waitForVisibility(SwitAccountsTitle);
        AssertDisplayed(SwitAccountsTitle.isDisplayed());
        AssertDisplayed(CancelCTA.isDisplayed());

    }

    /**
     * click on selected account by Passing account_id key from Accounts aPI
     * @param id  which is the account_id
     */
    public void selectAccount(String id) {
        waitForVisibility(driver.findElement(By.xpath("//*[@value='" + id + "']")));
        driver.findElement(By.xpath("//*[@value='" + id + "']")).click();
    }


    /**
     * validate My account screen  Design of single account user
     */
    public void ValidateMyAccountScreenUIForSingleUser(){

            waitForVisibility(MyAccTitle);
            AssertDisplayed(MyAccTitle.isDisplayed());
            AssertDisplayed(SelectOne.isDisplayed());
            AssertDisplayed(XCloseCTA.isEnabled());
    }

    /**
     * validate all subscriptions of default account and of single account
     * and then validate Screen Design
     */
    public void ValidateDefaultAccountSubscriptions() {
        try {
            System.out.println("Number of accounts: " + accounts.accounts.size());
        }
        catch (Exception e){
            System.out.println(accounts.accounts.get(0));
        }
        if (accounts.accounts.size() > 1) {
            ValidateMyAccountScreenUI();
        }
        else {
            ValidateMyAccountScreenUIForSingleUser();
        }
        MultiAccountsValidations(1);
    }

    /**
     * Validate all subscriptions of all  accounts but not the default
     */
    public void ValidateAllMultipleAccountsUsers() {
        if (accounts.accounts.size() == 1){
            System.out.println("user has only one account");
        }
        else {
            MultiAccountsValidations(accounts.accounts.size());
            System.out.println("number of accounts : " + accounts.accounts.size());
        }
    }


    /**
     * implement the logic to get subscriptions and accounts from API response
     * iterate onto all other accounts and click on them [Not the default account]
     * validate the subscriptions of each other account
     * @param accountsNumber
     */
    public void MultiAccountsValidations(int accountsNumber) {
        String MSISDN;
        String AccountID;
        int i =0;


        if (accountsNumber > 1 )
        {
            i = 1;
            navigateToSwitchAccounts();
            validateSwitchAccountUI();
            selectAccount(accounts.accounts.get(i).accountId); // click on first account of others

        }
        while (i < accountsNumber) {
            AccountID = accounts.accounts.get(i).accountId;
            SegmentResponseModel segmentAPI = SegmentUtils.GetSegment();
            SubscriptionsResponseModel subscriptions = SubscriptionsUtils.getSubscriptions(segmentAPI.segment,
                    segmentAPI.subscriptionType.name,
                    AccountID,
                    accounts.accounts.get(i).accountIdHash,
                    accounts.accounts.get(i).accountType); // to get subscriptions of each account
            for (int j = 0; j < subscriptions.subscriptions.size(); j++) {
                MSISDN = subscriptions.subscriptions.get(j).msisdn;
                if (!subscriptions.subscriptions.get(j).subscriptionType.name.equalsIgnoreCase("BB")) {
                    MSISDN = "0" + MSISDN.substring(2);

                }
                System.out.println("MSISDN: " + MSISDN);
                assertSubscriptionCardIsDisplayedIntoCarousel(MSISDN);
            }
            if (accountsNumber > i+1 ){ // if there are any other accounts we can proceed to select accounts
                navigateToSwitchAccounts();
                selectAccount(accounts.accounts.get(i+1).accountId);
            }
            i++;
        }

    }

    public void getAccountsNumberForUser () {
        int accountsNum = accounts.accounts.size();

        try {
            Assert.assertTrue( (accountsNum > 1));
        }catch (Error e){
            System.out.println("we are using single account user!");

        }
    }


    /**
     * swipe into subscription carousel to validate each subscription MSISDN
     * @param MSISDN
     */
    public void assertSubscriptionCardIsDisplayedIntoCarousel(String MSISDN) {
        try {
            AssertDisplayed(driver.findElement(By.xpath("//*[@label='" + MSISDN + "']")).isDisplayed());
        }
        catch(Exception e){
            SwipeToElement(driver.findElement(By.xpath("//*[@label='" + MSISDN + "']")), "Right");
            AssertDisplayed(driver.findElement(By.xpath("//*[@label='" + MSISDN + "']")).isDisplayed());
        }
    }


    @Override
    public void validateMyAccountDrawer() {

        AssertDisplayed(GetSubscription_List.isDisplayed());
    }

    @Override
    public void validateDataUsageTile() {

        AssertDisplayed(DataUsage_Tile.isDisplayed());
    }

    @Override
    public void validateChargesTile() {
        AssertDisplayed(Charges_Tile.isDisplayed());
        Assert.assertEquals(Charges_Tile.getText(),DashboardResponse.tiles.get(1).content.get(0).header.replace("<b>","").replace("</b>",""));

    }

    @Override
    public void validateSecondarySubscriptionNotExist() {

        validateMyAccountDrawer();
        Properties envFile = readPropertyFile("config/env.properties");
        String MSISDN = System.getProperty("MSISDN", envFile.getProperty("MSISDN"));
        MSISDN = MSISDN.replaceFirst("447","07");
        System.out.println("Searching for Secondary Subscription of MSISDN: "+ MSISDN);

        try {
            WebElement SecondarySubscription = driver.findElement(By.xpath("//*[@label='" + MSISDN + "']"));
            Assert.assertFalse(elementIsPresent(SecondarySubscription));
        } catch (NoSuchElementException exception){
            Assert.assertTrue(true);
        }
    }

    @Override
    public void SwitchToChild(){
        waitForVisibility(By.xpath("(//XCUIElementTypeOther[@name='wdgSubSwitchChildCard'])[2]/XCUIElementTypeOther"));
        driver.findElement(By.xpath("(//XCUIElementTypeOther[@name='wdgSubSwitchChildCard'])[2]/XCUIElementTypeOther")).click();
        waitForVisibilityForReinvent(By.id("txtSubscriptionMSISDN"),90);
    }
}
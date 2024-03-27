package pages.DX_IDM.UFL;


import core.drivers_initializer.drivers.AppiumMobileDriver;
import models.response.AccountsResponseModel;
import models.response.SegmentResponseModel;
import models.response.SubscriptionsResponseModel;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.SkipException;
import pages.DX_IDM.FullLogin.DX_IDM_FullLoginLogic_Android;
import testdata.ReadResponse;
import utilities.PropertiesLoader;
import utils.AccountsUtils;
import utils.SegmentUtils;
import utils.SubscriptionsUtils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static utilities.PropertiesLoader.readEnv;
import static utils.element_helpers.DriverHelps.*;
import static utilities.PropertiesLoader.readPropertyFile;
import static utils.element_helpers.ActionsHelpers.doubleClick;
import static utils.element_helpers.GenericHelpers.hashMSISDIN;
import static utils.element_helpers.ScrollHelpers.*;
import static utils.element_helpers.TextHelpers.GetXpath;
import static utils.element_helpers.TextHelpers.getElementByText;
import static utils.element_helpers.VerifyHelpers.*;
import static utils.element_helpers.WaitHelpers.waitForVisibility;


public class DX_IDM_UFL_Android extends DX_IDM_UFL_Abstract {

    String username;
    String password;
    String msisdn;
    SegmentResponseModel segmentResponseModel;
    AccountsResponseModel accounts ;
    DX_IDM_FullLoginLogic_Android dX_IDM_FullLoginLogic_Android;
    Boolean live = System.getProperty("isLiveTest", readEnv("isLiveTest")).equalsIgnoreCase("true");
    Properties envProp = readPropertyFile("config/env.properties");
    String firstName;
    String lastName;
    By loginButton = By.xpath("//*[@text='Log in']");
    By cookieButton = By.xpath("//*[@text='Accept all cookies']");
    By usernameBox = By.xpath("//*[@resource-id='username-or-phone-number-field']");
    By continueB = By.xpath("//*[@text='Continue']");
    By passwordBox = By.xpath("//*[@resource-id='pass']");
    By requestSecurityCode = By.xpath("//*[@resource-id='choosePhone']");
    By chooseCodeMsisdn = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View");
    By choosePlan = By.xpath("//*[@text='Choose plan']");
    By preferenceScreen = By.id("com.myvodafoneapp:id/tvSuccessHeader");
    By allDone = By.id("com.myvodafoneapp:id/btnConfirm");
    By pereferncePIN = By.xpath("//*[@text='PIN']");
    By perefernceUN = By.xpath("//*[@text='Username and password']");
    By accountTrayIcon = By.xpath("//*[@text='My Account']");
    By PromptLabel = By.id("bio_Login_Description_Label");
    By PromptBiometricCta = By.id("useBiometricsCTA");
    By PromptNotNowCta = By.id("notNowCTA");

    public DX_IDM_UFL_Android() {
        super();
        if(!live){
            segmentResponseModel = SegmentUtils.GetSegment();
            accounts = AccountsUtils.getAccounts();
        }
    }

    public void cancelBiometricPrompt() {
        waitForVisibility(PromptLabel);
        driver.findElement(PromptNotNowCta).click();
    }

    public void acceptBiometricPrompt() {
        waitForVisibility(PromptLabel);
        driver.findElement(PromptBiometricCta).click();
    }

    public void SkipLoginCTA() {
        if (!segmentResponseModel.segment.equalsIgnoreCase("PREPAY")) {
            waitForVisibility(DX_IDM_SkipLoginCTA);
            DX_IDM_SkipLoginCTA.click();
        } else {
            System.out.println("User is not eligible to see this screen SKIP LOGIN");
        }
    }

    public void ValidateSkipLogin() {
        waitForVisibility(DX_IDM_DisconnectWiFi);
        AssertDisplayed(DX_IDM_DisconnectWiFi.isDisplayed());
    }

    public void DisconnectWiFiCloseCTA() {
        waitForVisibility(DX_IDM_DisconnectWiFiCloseCTA);
        DX_IDM_DisconnectWiFiCloseCTA.click();
    }

    public void validateSelectingAccount() {
        try {
            waitForVisibility(DX_IDM_SelectSecurityAccount);
            DX_IDM_SelectSecurityAccount.click();
            Thread.sleep(5000);
            Properties envProp = readPropertyFile("config/env.properties");
            msisdn = System.getProperty("MSISDN", System.getProperty("MSISDN", envProp.getProperty("MSISDN")));
            String hashedMSISDN = hashMSISDIN(msisdn);
            getElementByText(hashedMSISDN).click();
        } catch (Exception e) {
            System.out.println("The user has one number only");
        }
        DX_IDM_ContinueCTA.click();
    }

    public void EnterSecurityCode() {
        Properties envProp = readPropertyFile("config/env.properties");
        if (System.getProperty("isLiveTest", envProp.getProperty("isLiveTest")).equalsIgnoreCase("true")) {
            DX_IDM_EnterSecurityCodeField1.sendKeys("4");
            DX_IDM_EnterSecurityCodeField2.sendKeys("U");
            DX_IDM_EnterSecurityCodeField3.sendKeys("7");
            DX_IDM_EnterSecurityCodeField4.sendKeys("F");
            DX_IDM_EnterSecurityCodeField5.sendKeys("1");
        } else {
            DX_IDM_EnterSecurityCodeField1.sendKeys("1");
            DX_IDM_EnterSecurityCodeField2.sendKeys("2");
            DX_IDM_EnterSecurityCodeField3.sendKeys("3");
            DX_IDM_EnterSecurityCodeField4.sendKeys("4");
            DX_IDM_EnterSecurityCodeField5.sendKeys("5");
        }
    }

    public void ValidateMSISDNs() throws ParseException {
        String MSISDN;
        MSISDN = ReadResponse.getSubsList().get(0).get("msisdn");
        if (!ReadResponse.getSubsType(0).equalsIgnoreCase("BB")) {
            MSISDN = "0" + MSISDN.substring(2);
        }
        AssertDisplayed(driver.findElement(By.xpath("//*[@text='" + MSISDN + "']")).isDisplayed());
        for (int i = 1; i < ReadResponse.getSubsList().size() - 1; i++) {
            MSISDN = ReadResponse.getSubsList().get(i).get("msisdn");
            if (!ReadResponse.getSubsType(i).equalsIgnoreCase("BB")) {
                MSISDN = "0" + MSISDN.substring(2);
                assertSubscriptionCardIsDisplayed(MSISDN);
            }
            assertSubscriptionCardIsDisplayed(MSISDN);
        }
    }

    public void assertSubscriptionCardIsDisplayed(String MSISDN) {
        scrollDownTo(driver.findElement(By.xpath("//*[@text='" + MSISDN + "']")));
        AssertDisplayed(driver.findElement(By.xpath("//*[@text='" + MSISDN + "']")).isDisplayed());
    }

    public void LoginTillReachUsernameScreen() {
        waitForVisibility(DX_IDM_LoginCTA);
        if (elementIsPresent(DX_IDM_LoginCTA)) {
            DX_IDM_LoginCTA.click();
        }
        try {
            waitForVisibility(AcceptCookies);
            AcceptCookies.click();
        } catch (Exception e) {
            System.out.println("Cookie not displayed");
        }
        waitForVisibility(DX_IDM_Username);
    }

    public void LoginTillReachPasswordScreen() throws InterruptedException {
        waitForVisibility(DX_IDM_Username);
        Properties envProp = readPropertyFile("config/env.properties");
        username = System.getProperty("username", envProp.getProperty("username"));
        DX_IDM_Username.sendKeys(username);
        Thread.sleep(1000);
        DX_IDM_ContinueCTA.click();
        waitForVisibility(DX_IDM_Password);
    }

    public void LoginTillReachRequestSecurityCodeScreen() throws InterruptedException {
        Properties envProp = readPropertyFile("config/env.properties");
        password = System.getProperty("password", envProp.getProperty("password"));
        DX_IDM_Password.sendKeys(password);
        Thread.sleep(1000);
        DX_IDM_Password_LoginCTA.click();
        Thread.sleep(1000);
    }

    public void LoginTillReachChooseAccountScreen() {
        waitForVisibility(DX_IDM_EnterSecurityCodeTitle);
        EnterSecurityCode();
        DX_IDM_ContinueCTA.click();
    }

    public void LoginTillReachChoosePlanScreen() throws ParseException {
        try {
            Properties envProp = readPropertyFile("config/env.properties");
            String isLiveTest = System.getProperty("isLiveTest", envProp.getProperty("isLiveTest"));
            String MSISDN = System.getProperty("MSISDN", envProp.getProperty("MSISDN"));
            //waitForVisibility(DX_IDM_ChoosePlanTitle);
            System.out.println(isLiveTest);
            System.out.println(MSISDN);
            if (isLiveTest.equalsIgnoreCase("true")) {
                Assert.assertTrue(driver.findElement(By.xpath(GetXpath(MSISDN))).isDisplayed());
                System.out.println(MSISDN);
                driver.findElement(By.xpath(GetXpath(MSISDN))).click();
            }
            scrollDownTo(DX_IDM_ContinueCTA);
            DX_IDM_ContinueCTA.click();
        } catch (Exception e) {
            System.out.println("Not have multiple accounts");
        }
    }


    public void LoginTillReachLoginPreferenceScreen() throws ParseException {
        try {
            waitForVisibility(DX_IDM_ChoosePlanTitle);
            Properties envFile = readPropertyFile("config/env.properties");
            String MSISDN = System.getProperty("MSISDN", envFile.getProperty("MSISDN"));
            MSISDN = MSISDN.replaceFirst("447", "07");
            driver.findElement(By.xpath("*//android.view.View/android.widget.TextView[4][@text='" + MSISDN + "']")).click();
            DX_IDM_ContinueCTA.click();
        } catch (Exception e) {
            System.out.println("Not have multiple plans");
        }
    }

    public void chooseFLN() {
        try {
            waitForVisibility(DX_IDM_ChoosePlanTitle);
            driver.findElement(By.xpath("//*[@text='Landline']")).click();
            DX_IDM_ContinueCTA.click();
        } catch (Exception e) {
            System.out.println("Not have multiple plans");
        }
    }

    public void chooseBB() {
        try {
            waitForVisibility(DX_IDM_ChoosePlanTitle);
            driver.findElement(By.xpath("//*[@text='Broadband']")).click();
            DX_IDM_ContinueCTA.click();
        } catch (Exception e) {
            System.out.println("Not have multiple plans");
        }
    }

    public void validateUsernameScreenContent() {
        waitForVisibility(DX_IDM_Username);
        AssertDisplayed(DX_IDM_ForgotUsername.isDisplayed());
        AssertDisplayed(DX_IDM_RegisterLink.isDisplayed());
        AssertDisplayed(DX_IDM_CreateAccountLink.isDisplayed());
    }

    public void validatePasswordScreenContent() {
        waitForVisibility(DX_IDM_Password);
        AssertDisplayed(DX_IDM_ForgotPassword.isDisplayed());
        AssertDisplayed(DX_IDM_RegisterLink.isDisplayed());
        AssertDisplayed(DX_IDM_CreateAccountLink.isDisplayed());
    }

    public void ValidateRequestSecurityCodeScreenContent() {
        AssertDisplayed(DX_IDM_RequestSecurityTitle.isDisplayed());
        AssertDisplayed(DX_IDM_RequestSecuritySubTitle.isDisplayed());
//        AssertDisplayed(DX_IDM_SelectSecurityAccount.isDisplayed());
    }

    public void ValidateEnterSecurityCodeScreenContent() {
        AssertDisplayed(DX_IDM_EnterSecurityCodeTitle.isDisplayed());
    }

    public List<String> getAccountIDs() {
        List<String> accountIDs = new ArrayList<>();
        List<AccountsResponseModel.Account> accounts = AccountsUtils.getAccounts().accounts;
        for (int i = 0; i < accounts.size(); i++) {
            accountIDs.add(accounts.get(i).accountId);
        }
        return accountIDs;
    }

    public void ValidateChooseYourAccountScreenContent() throws ParseException {
        if (getAccountIDs().size() > 1) {
            waitForVisibility(DX_IDM_ChooseAccountTitle);
            AssertDisplayed(DX_IDM_ChooseAccountTitle.isDisplayed());
        } else throw new SkipException("Item not exist in the response");
    }

    public void ValidateChooseYourPlanScreenContent() throws ParseException {
        if (ReadResponse.getSubsList().size() > 1) {
            waitForVisibility(DX_IDM_ChoosePlanTitle);
            AssertDisplayed(DX_IDM_ChoosePlanTitle.isDisplayed());
            AssertDisplayed(DX_IDM_ChoosePlanSubTitle.isDisplayed());
            ValidateMSISDNs();
        } else throw new SkipException("Item not exist in the response");
    }

    public void ValidateLoginPreferencesScreenContent() throws InterruptedException {
        Thread.sleep(1000);
        AssertResult(DX_IDM_LoginPreferencesTitle.getText(), "Login successful");
        AssertResult(DX_IDM_LoginPreferencesSubTitle.getText(), "Speed up your log in process by setting a default method");
        AssertResult(DX_IDM_LoginPreferencesOkCTA.getText(), "OK, all done");
        AssertResult(DX_IDM_LoginPreferencesFooter.getText(), "You can manage your Login details in the app settings.");
    }

    public void ValidateLoginToMyVodafoneScreenIsDisplayed() {
        DX_IDM_X_LoginToMyVodafoneScreen.isDisplayed();
    }

    public void UsernameScreenIsDisplayed() {
        DX_IDM_Username.isDisplayed();
    }

    public void PasswordScreenIsDisplayed() {
        DX_IDM_Password.isDisplayed();
    }

    public void RequestSecurityCodeScreenIsDisplayed() {
        waitForVisibility(DX_IDM_RequestSecurityTitle);
    }

    public void ValidateTobiJourneyIsTriggered() throws InterruptedException {
        Thread.sleep(2000);
        waitForVisibility(TobiXIcon);
        TobiXIcon.click();
        waitForVisibility(TOBi_EndChat);
        TOBi_EndChat.click();
    }

    public void AppSoftClose() {
        runAppInBackground();
    }

    public void AppHardCloseThenRelaunch() {
        killApp();
        startActivity();
    }

    public void ClickXButton() {
        DX_IDM_X_Button.click();
    }

    public void ClickOnChatToUs() {
        DX_IDM_ChatToUs.click();
    }

    public void ClickOnPhysicalBackButton() throws InterruptedException {
        Thread.sleep(5000);
        driver.navigate().back();
    }

    public void AssertOnPinFieldInVerifyYourAccount() {
        waitForVisibility(Pin_Field);
        AssertDisplayed(Pin_Field.isDisplayed());
    }


    public void ValidateCheckOnPhysicalBackButtonBehaviorOnUsername() throws InterruptedException {
        ClickOnPhysicalBackButton();
        UsernameScreenIsDisplayed();
    }

    public void ValidateCheckOnPhysicalBackButtonBehaviorOnPassword() throws InterruptedException {
        ClickOnPhysicalBackButton();
        PasswordScreenIsDisplayed();
    }

    public void ValidateCheckOnPhysicalBackButtonBehaviorOnRequestedSecurityCode() throws InterruptedException {
        ClickOnPhysicalBackButton();
        RequestSecurityCodeScreenIsDisplayed();
    }

    public void ValidateCheckOnPhysicalBackButtonBehaviorOnEnterSecurityCode() throws InterruptedException {
        ClickOnPhysicalBackButton();
        ValidateEnterSecurityCodeScreenContent();
    }


    public void ValidateCheckOnPhysicalBackButtonBehaviorOnChooseAccount() throws InterruptedException, ParseException {
        ClickOnPhysicalBackButton();
        ValidateChooseYourAccountScreenContent();

    }

    public void ValidateCheckOnPhysicalBackButtonBehaviorOnChoosePlan() throws InterruptedException, ParseException {
        ClickOnPhysicalBackButton();
        ValidateChooseYourPlanScreenContent();
    }

    public void ValidateCheckOnPhysicalBackButtonBehaviorOnLoginPreference() throws InterruptedException {
        ClickOnPhysicalBackButton();
        ValidateLoginPreferencesScreenContent();
    }


    public void ValidateClickOnThePhysicalBackButtonOnForgottenUsernameScreen() throws InterruptedException {
        ClickOnPhysicalBackButton();
        AssertOnPinFieldInVerifyYourAccount();

    }

    public void ValidateClickOnThePhysicalBackButtonOnForgottenPasswordScreen() throws InterruptedException {
        dX_IDM_FullLoginLogic_Android = new DX_IDM_FullLoginLogic_Android();
        ClickOnPhysicalBackButton();
        dX_IDM_FullLoginLogic_Android.ValidateResetPasswordScreenContent();
    }

    @Override
    public void closeTheExternalWebview() {
        try {
            waitForVisibility(CustomeTabBar);
        } catch (Exception e) {
            driver.navigate().back();
        }
    }

    @Override
    public void clickOnRegisterForMyVodafone() {
        try {
            AcceptCookies.click();
        } catch (Exception e) {
            System.out.println("Cookies didn't display");
        }
        waitForVisibility(registerForMyVodafone);
        registerForMyVodafone.click();
    }

    @Override
    public void navigateToACustomTab() {
        try {
            waitForVisibility(CustomeTabBar);
        } catch (Exception e) {
            driver.navigate().back();
        }
    }

    @Override
    public void closeTheCustomTab() {
        try {
            waitForVisibility(DoneCtaInExternalbrowser);
            DoneCtaInExternalbrowser.click();
            waitForVisibility(DX_IDM_Username);
        } catch (Exception e) {
            driver.navigate().back();
        }
    }

    @Override
    public void navigateToForgottenPasswordExternalWebview() {
        waitForVisibility(forgottenPasswordWebview);
        AssertDisplayed(forgottenPasswordWebview.isDisplayed());
    }

    @Override
    public void iClickOnIhavenotReceivedMySecurityCodeLink() {
        waitForVisibility(Ihaventreceivedmysecuritycode);
        Ihaventreceivedmysecuritycode.click();
    }

    @Override
    public void chooseAsubscription(String planNum) {
        waitForVisibility(DX_IDM_ChoosePlanTitle);
        int num = Integer.parseInt(planNum);
        if (num > 1) {
            num = (2 * num) - 1;
        }
        driver.findElement(By.xpath(String.format("//*[@resource-id='root']/android.view.View/android.view.View)[%d]", num))).click();
        try {
            Assert.assertTrue(DX_IDM_ContinueCTA.isDisplayed());
            DX_IDM_ContinueCTA.click();
        } catch (Exception e) {
            scrollDownElementOverCenterScreen(DX_IDM_ContinueCTA);
            DX_IDM_ContinueCTA.click();
        }

    }

    @Override
    public void chooseAccount(String accNum) {
        int num = Integer.parseInt(accNum);
        if (num > 1) {
            num = (2 * num) - 1;
        }
        driver.findElement(By.xpath(String.format("(//*[@resource-id='root']/android.view.View/android.view.View)[%d]", num))).click();
        try {
            Assert.assertTrue(DX_IDM_ContinueCTA.isDisplayed());
            DX_IDM_ContinueCTA.click();
        } catch (Exception e) {
            scrollDownElementOverCenterScreen(DX_IDM_ContinueCTA);
            DX_IDM_ContinueCTA.click();
        }

    }

    public void UFLogin() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        Properties envProp = readPropertyFile("config/env.properties");
        username = System.getProperty("username", envProp.getProperty("username"));
        password = System.getProperty("password", envProp.getProperty("password"));
        msisdn = System.getProperty("MSISDN", System.getProperty("MSISDN", envProp.getProperty("MSISDN")));
        String hashedMSISDN = hashMSISDIN(msisdn);
        System.out.println(hashedMSISDN);
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));
        //waitForVisibility(driver.findElement(loginButton));
        driver.findElement(loginButton).click();
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(cookieButton));
        //waitForVisibility(driver.findElement(cookieButton));
        doubleClick(driver.findElement(cookieButton));
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameBox));
        //waitForVisibility(driver.findElement(usernameBox));
        driver.findElement(usernameBox).sendKeys(username);
        driver.findElement(continueB).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordBox));
        //waitForVisibility(driver.findElement(passwordBox));
        driver.findElement(passwordBox).sendKeys(password);
        driver.findElement(loginButton).click();
        Thread.sleep(4000);
        if (checkElementPresence(chooseCodeMsisdn)) {
            driver.findElement(chooseCodeMsisdn).click();
            getElementByText(hashedMSISDN).click();
        }
        driver.findElement(continueB).click();
        EnterSecurityCode();
        /*Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@type= 'XCUIElementTypeSecureTextField'])[1]")));
        driver.findElement(By.xpath("(//*[@type= 'XCUIElementTypeSecureTextField'])[1]")).sendKeys("4");
        driver.findElement(By.xpath("(//*[@type= 'XCUIElementTypeSecureTextField'])[2]")).sendKeys("U");
        driver.findElement(By.xpath("(//*[@type= 'XCUIElementTypeSecureTextField'])[3]")).sendKeys("7");
        driver.findElement(By.xpath("(//*[@type= 'XCUIElementTypeSecureTextField'])[4]")).sendKeys("F");
        driver.findElement(By.xpath("(//*[@type= 'XCUIElementTypeSecureTextField'])[5]")).sendKeys("1");*/
        driver.findElement(continueB).click();
        if (checkElementPresence(By.xpath("//*[@text='Choose plan']"))) {
            try {
                waitForVisibility(By.xpath(GetXpath(msisdn)));
            } catch (Exception e) {
                scrollDownTo(driver.findElement(By.xpath(GetXpath(msisdn))));
            }
            driver.findElement(By.xpath(GetXpath(msisdn))).click();
            try {
                waitForVisibility(continueB);
            } catch (Exception e) {
                scrollTillFindElement(continueB);
            }
            driver.findElement(continueB).click();

            //scrollDownTo(driver.findElement(By.xpath("//*[@resource-id='submit-button']")));
            //doubleClick(driver.findElement(continueB));
        }
        Thread.sleep(20000);
        if (!(System.getProperty("buildName", PropertiesLoader.readBrowserStackAndroid("buildName")).contains("Synthetics Top-up"))) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(preferenceScreen));
            //waitForVisibility(driver.findElement(preferenceScreen));
            driver.findElement(allDone).click();
        }
        Thread.sleep(10000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='My Account']")));
        //waitForVisibility(driver.findElement(By.name("My Account")));
    }

    public void scrollTillFindElement(By by) {
        if (checkElementPresence(by)) {
            driver.findElement(by).click();
        } else {
            scrollDownAndroid();
            scrollTillFindElement(by);
        }
    }

    @Override
    public void clickOnLoginCTA() {
        waitForVisibility(DX_IDM_Login_Android);
        DX_IDM_Login_Android.click();
        waitForVisibility(cookieButton);
    }

    public void insertUsername() {
        Properties envProp = readPropertyFile("config/env.properties");
        username = System.getProperty("username", envProp.getProperty("username"));
        waitForVisibility(DX_IDM_Username);
        DX_IDM_Username.sendKeys(username);
        waitForVisibility(continueB);
        System.out.println("Cookies has been displayed");
        driver.findElement(continueB).click();
        waitForVisibility(passwordBox);
    }

    public void acceptCookies() {
        if (elementIsPresent(AcceptCookies)) {
            AcceptCookies.click();
        } else {
            System.out.println("Cookies are not displayed");
        }
    }

    public void insertPassword() {
        Properties envProp = readPropertyFile("config/env.properties");
        password = System.getProperty("password", envProp.getProperty("password"));
        waitForVisibility(passwordBox);
        driver.findElement(passwordBox).sendKeys(password);
        waitForVisibility(loginButton);
        System.out.println("Username has inserted successfully");
        driver.findElement(loginButton).click();
    }

    public void choosePhone() {
        // waitForVisibility(continueB);
        if (!driver.findElement(continueB).isEnabled()) {
            System.out.println("User has more than one number");
            selectNumberToSendOTAC();
        }
        waitForVisibility(continueB);
        System.out.println("Password has inserted successfully");
        driver.findElement(continueB).click();
    }

    public void selectNumberToSendOTAC() {
        waitForVisibility(requestSecurityCode);
        driver.findElement(requestSecurityCode).click();
        Properties envProp = readPropertyFile("config/env.properties");
        msisdn = System.getProperty("MSISDN", System.getProperty("MSISDN", envProp.getProperty("MSISDN")));
        String hashedMSISDN = hashMSISDIN(msisdn);
        driver.findElement(By.xpath(GetXpath(hashedMSISDN))).click();
    }

    public void insertSecurityCode() {
        EnterSecurityCode();
        waitForVisibility(continueB);
        driver.findElement(continueB).click();
        System.out.println("Security Code has inserted");
    }

    public void selectAccount() {
        System.out.println("Account IDs equal to " + accounts.accounts.size());
        if ((accounts.accounts.size() > 1)) {
            System.out.println("User has multiple accounts");
            firstName = System.getProperty("FirstName", System.getProperty("FirstName", envProp.getProperty("FirstName")));
            lastName = System.getProperty("LastName", System.getProperty("LastName", envProp.getProperty("LastName")));
            String accountName = firstName + lastName;
            System.out.println(accountName);
            driver.findElement(By.xpath(GetXpath(accountName))).click();
            scrollTillFindElement(continueB);
        } else {
            System.out.println("User has only one account");
        }
    }

    public void selectPlan() {
        SubscriptionsResponseModel subscriptions;
        SegmentResponseModel segment = SegmentUtils.GetSegment();
        subscriptions = SubscriptionsUtils.getSubscriptions(segment.segment,
                segment.subscriptionType.name,
                envProp.getProperty("accountId"),
                accounts.accounts.get(0).accountIdHash,
                accounts.accounts.get(0).accountType);
        System.out.println("******" + accounts.accounts.get(0).accountType + "******");
        if (subscriptions.subscriptions.size() > 1) {
            waitForVisibility(choosePlan);
            Properties envProp = readPropertyFile("config/env.properties");
            msisdn = System.getProperty("MSISDN", System.getProperty("MSISDN", envProp.getProperty("MSISDN")));
            if (elementIsPresent(getElementByText(msisdn))) {
                getElementByText(msisdn).click();
            } else {
                System.out.println("Missdin found at the bottom of the page");
                scrollDownTo(getElementByText(msisdn));
                getElementByText(msisdn).click();
            }
            scrollTillFindElement(continueB);
        } else {
            System.out.println("User has only 1 subscription");
        }
    }

    public void selectLogPref(String logPrefChoice) {
        if (logPrefChoice.equalsIgnoreCase("PIN")) {
            waitForVisibility(pereferncePIN);
            driver.findElement(pereferncePIN).click();
        } else {
            waitForVisibility(perefernceUN);
            driver.findElement(perefernceUN).click();
        }
        waitForVisibility(allDone);
        driver.findElement(allDone).click();
        waitForVisibility(accountTrayIcon);
    }

    public void UFL(String logPrefChoice) {
        clickOnLoginCTA();
        acceptCookies();
        insertUsername();
        insertPassword();
        choosePhone();
        insertSecurityCode();
        selectAccount();
        selectPlan();
        //cro biometric prompt
        try {
            waitForVisibility(PromptLabel);
                cancelBiometricPrompt();
                selectLogPref(logPrefChoice);

        } catch (Exception e) {
            selectLogPref(logPrefChoice);
        }
    }
}
        /*Properties envProp = readPropertyFile("config/env.properties");
        
        username=System.getProperty("username",envProp.getProperty("username"));
        password=System.getProperty("password",envProp.getProperty("password"));
        msisdn = System.getProperty("MSISDN", System.getProperty("MSISDN", envProp.getProperty("MSISDN")));
        String hashedMSISDN = hashMSISDIN(msisdn);
        By loginButton= By.xpath("//*[@text='Log in']");
        By cookieButton= By.xpath("//*[@text='Accept all cookies']");
        By usernameBox= By.id("user");
        By continueB= By.id("submit-button");
        By passwordBox= By.id("pass");
        By chooseCodeMsisdn= By.id("choosePhone");
        By preferenceScreen= By.id("com.myvodafoneapp:id/tvSuccessHeader");
        By allDone= By.id("com.myvodafoneapp:id/btnConfirm");
        Thread.sleep(2000);
        waitForVisibility(driver.findElement(loginButton));
        driver.findElement(loginButton).click();
        Thread.sleep(3000);
        waitForVisibility(driver.findElement(cookieButton));
        driver.findElement(cookieButton).click();
        waitForVisibility(driver.findElement(usernameBox));
        driver.findElement(usernameBox).sendKeys(username);
        driver.findElement(continueB).click();
        waitForVisibility(driver.findElement(passwordBox));
        driver.findElement(passwordBox).sendKeys(password);
        driver.findElement(continueB).click();
        Thread.sleep(4000);
        if(checkElementPresence(chooseCodeMsisdn)) {
            driver.findElement(chooseCodeMsisdn).click();
            driver.findElementByXPath(GetXpath(hashedMSISDN)).click();
        }
        driver.findElement(continueB).click();
        EnterSecurityCode();
        driver.findElement(continueB).click();
        if (checkElementPresence(By.xpath("//*[@text ='Choose plan']"))){
            scrollDownTo(driver.findElement(By.xpath(GetXpath(msisdn))));
            driver.findElement(By.xpath(GetXpath(msisdn))).click();
            scrollDownTo(driver.findElement(continueB));
            driver.findElement(continueB).click();
        }
        Thread.sleep(20000);
        if (!(System.getProperty("buildName", browserStackProp.getProperty("buildName")).contains("Synthetics Top-up"))) {
            waitForVisibility(driver.findElement(preferenceScreen));
            //waitForVisibility(driver.findElement(preferenceScreen));
            driver.findElement(allDone).click();
        }
        Thread.sleep(10000);
        waitForVisibility(driver.findElement(By.xpath("//*[@text ='My Account']")));
    }*/


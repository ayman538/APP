package pages.DX_IDM.UFL;

import models.response.AccountsResponseModel;
import models.response.SegmentResponseModel;
import models.response.SubscriptionsResponseModel;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.SkipException;
import testdata.ReadResponse;
import testdata.TestData;
import utilities.PropertiesLoader;
import utils.AccountsUtils;
import utils.SegmentUtils;
import utils.SubscriptionsUtils;

import java.time.Duration;
import java.util.Properties;

import static core.Hooks.returnToDashboard;
import static utils.element_helpers.DriverHelps.*;
import static utilities.PropertiesLoader.readPropertyFile;
import static utils.element_helpers.ActionsHelpers.doubleClick;
import static utils.element_helpers.ActionsHelpers.tapAttScreenBottom;
import static utils.element_helpers.GenericHelpers.hashMSISDIN;
import static utils.element_helpers.GenericHelpers.navigateBackForiOS;
import static utils.element_helpers.ScrollHelpers.*;
import static utils.element_helpers.TextHelpers.GetXpath;
import static utils.element_helpers.TextHelpers.getElementByText;
import static utils.element_helpers.VerifyHelpers.*;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

public class DX_IDM_UFL_IOS extends DX_IDM_UFL_Abstract {

    String username;
    String password;
    String msisdn;
    private static SegmentResponseModel segmentResponseModel = SegmentUtils.GetSegment();
    AccountsResponseModel accounts = AccountsUtils.getAccounts();
    ;
    Properties envProp = readPropertyFile("config/env.properties");

    String firstName;
    String lastName;
    public WebElement subscription;
    By loginCTA = By.name("Log in");
    By loginButton = By.xpath("(//*[@name='Log in'])[2]");
    By cookieButton = By.name("Accept all cookies");
    By usernameBox = By.xpath("//*[@type='XCUIElementTypeTextField']");
    By continueB = By.xpath("//*[@label ='Continue']");
    By passwordBox = By.xpath("//*[@type='XCUIElementTypeSecureTextField']");
    By chooseCodeMsisdn = By.xpath("//*[@value ='Choose a phone from the list']");
    By choosePlan = By.name("Choose plan");
    By preferenceScreen = By.name("Login successful");
    By allDone = By.name("OK, all done");
    By pereferncePIN = By.xpath("//*[@label ='PIN']");
    By perefernceUN = By.xpath("//*[@label ='Username and password']");
    By accountTrayIcon = By.xpath("//*[@label='My Account']");
    By PromptLabel = By.id("bio_Login_Description_Label");
    By PromptBiometricCta = By.id("useBiometricsCTA");
    By PromptNotNowCta = By.id("notNowCTA");
    private final By securityCode = By.xpath("//XCUIElementTypeOther[1]");

    public DX_IDM_UFL_IOS() {
        super();
    }

    public void SkipLoginCTA() {
        if (!segmentResponseModel.segment.equalsIgnoreCase("PREPAY")) {
            waitForVisibility(DX_IDM_SkipLoginCTA);
            DX_IDM_SkipLoginCTA.click();
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
            System.out.println(hashedMSISDN);
            driver.findElement(By.xpath("//XCUIElementTypeButton[@name='" + hashedMSISDN + "']")).click();
            tapAttScreenBottom();
        } catch (Exception e) {
            System.out.println("The user has one number only");
        }
        DX_IDM_ContinueCTA.click();
    }

    public void EnterSecurityCode() throws InterruptedException {
        Thread.sleep(4000);
        waitForVisibility(DX_IDM_EnterSecurityCodeField1);
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

    public void LoginTillReachChooseAccountScreen() throws InterruptedException {
        waitForVisibility(DX_IDM_EnterSecurityCodeTitle);
        AssertDisplayed(DX_IDM_EnterSecurityCodeTitle.isDisplayed());
        EnterSecurityCode();
        IOSDoneCTAKeyBoard.click();
        DX_IDM_ContinueCTA.click();
    }

    public void LoginTillReachChoosePlanScreen() {
        try {
            waitForVisibility(DX_IDM_ChooseAccountTitle);
            DX_IDM_ContinueCTA.click();
            Properties envProp = readPropertyFile("config/env.properties");
            String isLiveTest = System.getProperty("isLiveTest", envProp.getProperty("isLiveTest"));
            String MSISDN = System.getProperty("MSISDN", envProp.getProperty("MSISDN"));
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

    public void LoginTillReachLoginPreferenceScreen() {
        try {
            waitForVisibility(DX_IDM_ChoosePlanTitle);
            Properties envFile = readPropertyFile("config/env.properties");
            String MSISDN = System.getProperty("MSISDN", envFile.getProperty("MSISDN"));
            MSISDN = MSISDN.replaceFirst("447", "07");
            driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='" + MSISDN + "']")).click();
            DX_IDM_ContinueCTA.click();
        } catch (Exception e) {
            System.out.println("Not have multiple plans");
        }
    }

    public void chooseFLN() {
        try {
            waitForVisibility(DX_IDM_ChoosePlanTitle);
            driver.findElement(By.id("Landline")).click();
            DX_IDM_ContinueCTA.click();
        } catch (Exception e) {
            System.out.println("Not have multiple plans");
        }
    }

    public void chooseBB() {
        try {
            waitForVisibility(DX_IDM_ChoosePlanTitle);
            driver.findElement(By.id("Broadband")).click();
            DX_IDM_ContinueCTA.click();
        } catch (Exception e) {
            System.out.println("Not have multiple plans");
        }
    }

    @Override
    public void closeTheExternalWebview() {
        returnToDashboard();
    }

    @Override
    public void clickOnRegisterForMyVodafone() {
        try {
            AcceptCookies.click();
        } catch (Exception e) {
            System.out.println("Cookies didn't display");
        }
        waitForVisibility(registerForMyVodafone); // THE PO
        registerForMyVodafone.click();
    }

    @Override
    public void navigateToACustomTab() {
        waitForVisibility(CustomeTabBar);
        AssertDisplayed(CustomeTabBar.isDisplayed());
    }

    @Override
    public void closeTheCustomTab() {
        waitForVisibility(DoneCtaInExternalbrowser);
        DoneCtaInExternalbrowser.click();
        waitForVisibility(DX_IDM_Username);
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
        driver.findElement(By.xpath(String.format("(//XCUIElementTypeOther[@name='A container radio item'])[%s]", planNum))).click();
        DX_IDM_ContinueCTA.click();

    }

    @Override
    public void chooseAccount(String accNum) {

        driver.findElement(By.xpath(String.format("(//XCUIElementTypeOther[@name='A container radio item'])[%s]", accNum))).click();
        try {
            Assert.assertTrue(DX_IDM_ContinueCTA.isDisplayed());
            DX_IDM_ContinueCTA.click();
        } catch (Exception e) {
            scrollDownElementOverCenterScreen(DX_IDM_ContinueCTA);
            DX_IDM_ContinueCTA.click();
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

    public void ValidateChooseYourAccountScreenContent() throws ParseException {
        if (ReadResponse.getAccountIds().size() > 1) {
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
        AssertDisplayed(DX_IDM_LoginCTA.isDisplayed());
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
        navigateBackForiOS();
    }

    public void UFLogin() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        Properties envProp = readPropertyFile("config/env.properties");

        username = System.getProperty("username", envProp.getProperty("username"));
        password = System.getProperty("password", envProp.getProperty("password"));
        msisdn = System.getProperty("MSISDN", System.getProperty("MSISDN", envProp.getProperty("MSISDN")));
        String hashedMSISDN = hashMSISDIN(msisdn);
        System.out.println(hashedMSISDN);
        waitForVisibility(driver.findElement(loginCTA));
        driver.findElement(loginCTA).click();
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(cookieButton));
        waitForVisibility(driver.findElement(cookieButton));
        doubleClick(driver.findElement(cookieButton));
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameBox));
        //waitForVisibility(driver.findElement(usernameBox));
        driver.findElement(usernameBox).sendKeys(username);
        driver.findElement(continueB).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordBox));
        waitForVisibility(driver.findElement(passwordBox));
        driver.findElement(passwordBox).sendKeys(password);
        //if(System.getProperty("isLiveTest", PropertiesLoader.readEnv("isLiveTest")).equalsIgnoreCase("true"))
        //    driver.findElement(loginCTA).click();
        //else
            driver.findElement(loginButton).click();
        Thread.sleep(5000);
        if (checkElementPresence(chooseCodeMsisdn)) {
            driver.findElement(chooseCodeMsisdn).click();
            waitForVisibility(getElementByText((hashedMSISDN)));
            getElementByText((hashedMSISDN)).click();
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
        if (checkElementPresence(By.name("Choose plan"))) {
            try {
                waitForVisibility(By.xpath(GetXpath(msisdn)));
            } catch (Exception e) {
                scrollDownTo(driver.findElement(By.xpath(GetXpath(msisdn))));
            }
            driver.findElement(By.xpath(GetXpath(msisdn))).click();
            try {
                waitForVisibility(continueB);
            } catch (Exception e) {
                scrollDownTo(driver.findElement(continueB));
            }
            doubleClick(driver.findElement(continueB));
        }
        Thread.sleep(20000);
        if (!(System.getProperty("Segment", envProp.getProperty("Segment")).contains("PREPAY"))) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(preferenceScreen));
            //waitForVisibility(driver.findElement(preferenceScreen));
            driver.findElement(allDone).click();
        }
        Thread.sleep(10000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("My Account")));
        //waitForVisibility(driver.findElement(By.name("My Account")));
    }

    @Override
    public void clickOnLoginCTA() {
        waitForVisibility(DX_IDM_Login_IOS);
        DX_IDM_Login_IOS.click();
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
        //waitForVisibility(continueB);
        if (!driver.findElement(continueB).isEnabled()) {
            System.out.println("User has more than one number");
            selectNumberToSendOTAC();
        }
        waitForVisibility(continueB);
        System.out.println("Password has inserted successfully");
        driver.findElement(continueB).click();
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
            scrollDownTo(DX_IDM_ContinueCTA);
            DX_IDM_ContinueCTA.click();
        } else {
            System.out.println("User has only one account");
        }
    }

    public void selectNumberToSendOTAC() {
        waitForVisibility(chooseCodeMsisdn);
        driver.findElement(chooseCodeMsisdn).click();
        Properties envProp = readPropertyFile("config/env.properties");
        msisdn = System.getProperty("MSISDN", System.getProperty("MSISDN", envProp.getProperty("MSISDN")));
        String hashedMSISDN = hashMSISDIN(msisdn);
        driver.findElement(By.xpath(GetXpath(hashedMSISDN))).click();
    }

    public void insertSecurityCode() throws InterruptedException {
        EnterSecurityCode();
        waitForVisibility(continueB);
        driver.findElement(continueB).click();
    }

    public void selectPlan() throws InterruptedException {
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
            if (elementIsPresent(getElementByText(GetXpath(msisdn)))) {
                System.out.println("Missdin didn't find at the bottom of the page");
                getElementByText(GetXpath(msisdn)).click();
            } else {
                System.out.println("Missdin found at the bottom of the page");
                scrollDownTo(getElementByText(GetXpath(msisdn)));
                getElementByText(GetXpath(msisdn)).click();
            }
            if (driver.findElement(continueB).isDisplayed()) {
                driver.findElement(continueB).click();
            } else {
                scrollDownTo(driver.findElement(continueB));
                driver.findElement(continueB).click();
            }
        } else {
            System.out.println("User has only 1 subscription");
        }
//        SubscriptionsResponseModel subscriptions;
//        SegmentResponseModel segment = SegmentUtils.GetSegment();
//        subscriptions = SubscriptionsUtils.getSubscriptions(segment.segment,
//                segment.subscriptionType.name,
//                envProp.getProperty("accountId"),
//                accounts.accounts.get(0).accountIdHash,
//                accounts.accounts.get(0).accountType);
//        System.out.println("******"+ accounts.accounts.get(0).accountType+"******");
//        if (subscriptions.subscriptions.size() > 1) {
//            //waitForVisibilityForReinvent(DX_IDM_ChoosePlanTitle,200);
//            Properties envProp = readPropertyFile("config/env.properties");
//            msisdn = System.getProperty("MSISDN", System.getProperty("MSISDN", envProp.getProperty("MSISDN")));
//            WebElement subscription = (WebElement) By.xpath("//XCUIElementTypeStaticText[@name='" + msisdn + "']");
//            if (subscription.isDisplayed()) {
//                subscription.click();
//            }
//            else {
//                System.out.println("User has more than 2 subscriptions");
//                scrollDownTo(subscription);
//                subscription.click();
//            }
//            if(DX_IDM_ContinueCTA.isDisplayed()){
//                DX_IDM_ContinueCTA.click();
//            }
//            else {
//                scrollDownTo(DX_IDM_ContinueCTA);
//                DX_IDM_ContinueCTA.click();
//            }
//        }
//        else {
//            System.out.println("User has only 1 subscription");
//        }
//        waitForVisibilityForReinvent(SuccessfullLogin_DoneCTA,100);

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

    public void acceptCookies() {
        if (elementIsPresent(AcceptCookies)) {
            AcceptCookies.click();
        } else {
            System.out.println("Cookies are not displayed");
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

    public void UFL(String logPrefChoice) throws InterruptedException {
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
 
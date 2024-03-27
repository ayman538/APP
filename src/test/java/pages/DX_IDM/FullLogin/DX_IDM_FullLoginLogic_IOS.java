package pages.DX_IDM.FullLogin;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.SkipException;
import pages.DX_IDM.WelcomeFlow.DX_IDM_WelcomeFlowLogicAbstract;
import pages.DX_IDM.WelcomeFlow.DX_IDM_WelcomeFlowLogic_IOS;
import pages.Login.LoginPO;
import pages.Tray.DashboardTray.DashboardTrayPO;
//import pages.Tutorials.TutorialPo;
import testdata.ReadResponse;
import testdata.ReadTestData;
import testdata.TestData;
import java.util.Properties;

import static core.Config.setLoginStatusStatus;
import static utilities.PropertiesLoader.readPropertyFile;
import static utils.element_helpers.DriverHelps.killApp;
import static utils.element_helpers.DriverHelps.startActivity;
import static utils.element_helpers.GenericHelpers.openDeepLinkForiOS;
import static utils.element_helpers.VerifyHelpers.*;
import static utils.element_helpers.WaitHelpers.waitForVisibility;
import static utils.element_helpers.WaitHelpers.waitForVisibilityForReinvent;

public class DX_IDM_FullLoginLogic_IOS extends DX_IDM_FullLoginLogic_Abstract {

    private final DX_IDM_WelcomeFlowLogicAbstract DX_IDM_WelcomeFlowLogic;
    String username;
    String MSISDN;
    Properties envProp = readPropertyFile("config/env.properties");
    String password = System.getProperty("password", envProp.getProperty("password"));
    String DOB = System.getProperty("DOB", envProp.getProperty("DOB"));
    String firstName = System.getProperty("FirstName", envProp.getProperty("FirstName"));
    String lastName = System.getProperty("LastName", envProp.getProperty("LastName"));
    private DashboardTrayPO DB_object;
    private LoginPO loginObject;
    //private TutorialPo Tut;
    By loginButton = By.name("Log In");
    By loginButtonPassword = By.name("Log in");
    By cookieButton = By.name("Accept all cookies");
    By continueB = By.xpath("//*[@label ='Continue']");
    By passwordBox = By.xpath("//*[@type='XCUIElementTypeSecureTextField']");
    By allDone = By.name("OK, all done");
    By pereferncePIN = By.xpath("//*[@label ='PIN']");
    By perefernceUN = By.xpath("//*[@label ='Username and password']");
    By accountTrayIcon = By.xpath("//*[@label='My Account']");
    By PromptLabel = By.id("PromptLabel");

    By PromptBiometricCta = By.id("PromptAcceptCta");
    By PromptNotNowCta = By.id("PromptNotNowCta");

    public DX_IDM_FullLoginLogic_IOS() {
        super();
        DX_IDM_WelcomeFlowLogic = new DX_IDM_WelcomeFlowLogic_IOS();
        username = TestData.GetUserName();
        MSISDN = TestData.GetMSISDN();
    }

    public void beforeLoginUsernameAndPasswordScreen() throws InterruptedException {
        //DX_IDM_WelcomeFlowLogic.dxIDMWelcomeFlow();
        waitForVisibility(DX_IDM_LoginCTA);
        DX_IDM_LoginCTA.click();
        waitForVisibility(cookieButton);
    }

    public void validateUsernameScreenContent() throws InterruptedException {
        //AssertDisplayed(DX_IDM_ForgotUsername.isDisplayed());
        AssertDisplayed(DX_IDM_RegisterLink.isDisplayed());
        AssertDisplayed(DX_IDM_CreateAccountLink.isDisplayed());
        DX_IDM_Username.sendKeys(username);
        Thread.sleep(1000);
        DX_IDM_ContinueCTA.click();
    }

    public void validatePasswordScreenContent() throws InterruptedException {
        waitForVisibility(DX_IDM_Password);
        AssertDisplayed(DX_IDM_ForgotPassword.isDisplayed());
        AssertDisplayed(DX_IDM_RegisterLink.isDisplayed());
        AssertDisplayed(DX_IDM_CreateAccountLink.isDisplayed());
        DX_IDM_Password.sendKeys(password);
        Thread.sleep(1000);
//        DX_IDM_ContinueCTA.click();
        DX_IDM_PasswordLoginCTA.click();
        //doubleClick(DX_IDM_PasswordLoginCTA);
        Thread.sleep(1000);
    }

    public void validateLoginPrefScreenContent() {
        waitForVisibility(DX_IDM_LoginPreferencesTitle);
        AssertDisplayed(DX_IDM_LogPrefPIN.isDisplayed());
        AssertDisplayed(DX_IDM_LogPrefPassword.isDisplayed());

        AssertDisplayed(DX_IDM_LoginPreferencesOkCTA.isDisplayed());
    }

    public void enterPassword() {
        DX_IDM_Password.sendKeys(password);
    }

    public void showPassword() throws InterruptedException {
        DX_IDM_ShowPassword.click();
        Thread.sleep(500);
    }


    @Override
    public void enterMSISDN() throws InterruptedException {
        try {
            waitForVisibility(DX_IDM_ContinueCTA);
            DX_IDM_Username.sendKeys(MSISDN);
            Thread.sleep(1000);
            DX_IDM_ContinueCTA.click();
        } catch (Exception e) {
            System.out.println("Returning User");
        }
    }

    @Override
    public void proceedLoginFromPasswordScreen() throws InterruptedException {
        waitForVisibility(DX_IDM_Password);
        DX_IDM_Password.sendKeys(password);
        Thread.sleep(1000);
        DX_IDM_PasswordLoginCTA.click();
        Thread.sleep(5000);
        selectPassword();
        pressAllDoneCTA();
        Thread.sleep(5000);
    }


    @Override
    public void fullLoginWithPhoneNumberUsingMultipleContactAccount() throws InterruptedException {
        waitForVisibility(DX_IDM_DOB_Day);
        System.out.println("Account has multiple contacts");
        DX_IDM_DOB_Day.sendKeys(DOB);
        DX_IDM_ContinueCTA.click();
    }

    @Override
    public void fullLoginWithPhoneNumberUsingMultipleContactAccountSameDOB() throws InterruptedException {
        waitForVisibility(DX_IDM_firstName);
        System.out.println("Account has multiple contacts with same DOB");
        DX_IDM_firstName.sendKeys(firstName);
        DX_IDM_lastName.sendKeys(lastName);
        DX_IDM_ContinueCTA.click();
    }

    @Override
    public void validateInvalidPhoneNumberOrPasswordErrorMessage() {
        waitForVisibility(DX_IDM_InvalidPhoneNumberOrPassword_ErrorMSG);
        Assert.assertTrue(DX_IDM_InvalidPhoneNumberOrPassword_ErrorMSG.getText().contains("phone numbers must contain numbers only and no spaces."));
    }

    @Override
    public void validateInvalidDOBErrorMessage() {
        waitForVisibility(DX_IDM_DOB_Instant_ErrorMSG);
        Assert.assertTrue(DX_IDM_DOB_Instant_ErrorMSG.getText().contains(" "));
    }

    @Override
    public void validateInvalidPersonalDetailsErrorMessage() {
        waitForVisibility(DX_IDM_PersonalDetails_ErrorMSG);
        Assert.assertTrue(DX_IDM_PersonalDetails_ErrorMSG.getText().contains("We couldn't match your details"));
    }


    public void validatePasswordShown() {
        Assert.assertEquals(DX_IDM_Password.getText(), password);
    }

    public void validatePasswordHidden() {
        Assert.assertEquals(DX_IDM_Password.getText(), "••••••••");

    }

    public void selectPIN() {
        //cro biometric prompt
        try {
            waitForVisibility(PromptLabel);
                cancelBiometricPrompt();
                waitForVisibility(DX_IDM_LogPrefPIN);
                DX_IDM_LogPrefPIN.click();

        } catch (Exception e) {
            waitForVisibility(DX_IDM_LogPrefPIN);
            DX_IDM_LogPrefPIN.click();
        }
    }
    public void selectPassword() {
        //cro biometric prompt
        try {
            waitForVisibility(PromptLabel);
                cancelBiometricPrompt();
                waitForVisibility(DX_IDM_LogPrefPassword);
                DX_IDM_LogPrefPassword.click();

        } catch (Exception e) {
            waitForVisibility(DX_IDM_LogPrefPassword);
            DX_IDM_LogPrefPassword.click();
        }
    }

    public void selectBiometric() {
        //cro biometric prompt
        try {
            waitForVisibility(PromptLabel);
                cancelBiometricPrompt();
                waitForVisibility(DX_IDM_LogPrefBiometrics);
                DX_IDM_LogPrefBiometrics.click();

        } catch (Exception e) {
            waitForVisibility(DX_IDM_LogPrefBiometrics);
            DX_IDM_LogPrefBiometrics.click();
        }
    }

    public void pressAllDoneCTA() {
        waitForVisibility(DX_IDM_LoginPreferencesOkCTA);
        DX_IDM_LoginPreferencesOkCTA.click();
        //  waitForVisibility(DB_SettingDashboardTray_icon);
        //  AssertDisplayed(DB_SettingDashboardTray_icon.isDisplayed());
        setLoginStatusStatus("true");
    }

    @Override
    public void closeMyAccountScreenIfDisplayed() {
        try {
            waitForVisibility(MyAccountXIcon);
            MyAccountXIcon.click();
        } catch (Exception e) {
            System.out.println("login not triggered from my account in the dashboard tray");
        }
        waitForVisibility(DB_SettingDashboardTray_icon);
        AssertDisplayed(DB_SettingDashboardTray_icon.isDisplayed());
    }

    public void fullLoginWithBiometrics() throws InterruptedException {
        username = ReadTestData.getUsername();
        beforeLoginUsernameAndPasswordScreen();
        acceptCookies();
        username = ReadTestData.getUsername();
        DX_IDM_Username.sendKeys(username);
        Thread.sleep(1000);
        DX_IDM_ContinueCTA.click();
        waitForVisibility(DX_IDM_Password);
        DX_IDM_Password.sendKeys(password);
        Thread.sleep(1000);
        DX_IDM_PasswordLoginCTA.click();
        Thread.sleep(5000);
        //cro biometric prompt
        try {
            waitForVisibility(PromptLabel);
                cancelBiometricPrompt();
                selectBiometric();
                DX_IDM_LoginPreferencesOkCTA.click();
                Thread.sleep(5000);

        } catch (Exception e) {
            selectBiometric();
            DX_IDM_LoginPreferencesOkCTA.click();
            Thread.sleep(5000);
        }
    }


    public void fullLoginWithPIN() throws InterruptedException {
        beforeLoginUsernameAndPasswordScreen();
        try {
            waitForVisibility(DX_IDM_AcceptCookiesCTA);
            DX_IDM_AcceptCookiesCTA.click();
        } catch (Exception e) {
            System.out.println("Cookie is not displayed");
        }
        DX_IDM_Username.sendKeys(username);
        Thread.sleep(1000);
        DX_IDM_ContinueCTA.click();
        waitForVisibility(DX_IDM_Password);
        DX_IDM_Password.sendKeys(password);
        Thread.sleep(1000);
        DX_IDM_PasswordLoginCTA.click();
        Thread.sleep(1000);
        //cro biometric prompt
        try {
            waitForVisibility(PromptLabel);
                cancelBiometricPrompt();
                selectPIN();
                DX_IDM_LoginPreferencesOkCTA.click();
                waitForVisibility(DB_SettingDashboardTray_icon);
                AssertDisplayed(DB_SettingDashboardTray_icon.isDisplayed());

        } catch (Exception e) {
            selectPIN();
            DX_IDM_LoginPreferencesOkCTA.click();
            waitForVisibility(DB_SettingDashboardTray_icon);
            AssertDisplayed(DB_SettingDashboardTray_icon.isDisplayed());
        }
    }

    public void fullLoginWithUNandPW() throws InterruptedException {
        try {
            beforeLoginUsernameAndPasswordScreen();
        } catch (Exception e) {
            System.out.println("login after skip login");
        }
        try {
            acceptCookies();
        } catch (Exception e) {
            System.out.println("cookies already accepted");
        }
        DX_IDM_Username.sendKeys(username);
        Thread.sleep(1000);
        DX_IDM_ContinueCTA.click();
        waitForVisibility(DX_IDM_Password);
        DX_IDM_Password.sendKeys("testing1");
        Thread.sleep(1000);
        DX_IDM_PasswordLoginCTA.click();
        Thread.sleep(5000);
        selectPassword();
        pressAllDoneCTA();
        Thread.sleep(5000);
    }

    @Override
    public void fullLoginWithUserNameAndPwdAndAcceptCookies() throws InterruptedException {
        try {
            beforeLoginUsernameAndPasswordScreen();
        } catch (Exception e) {
            System.out.println("login after skip login");
        }
        try {
            waitForVisibility(DX_IDM_MyAccountTray);
            DX_IDM_MyAccountTray.click();
        } catch (Exception e) {
            System.out.println("Login without clicking on My account in Tray");
        }
        try {
            acceptCookies();
        } catch (Exception e) {
            System.out.println("cookies already accepted");
        }
        try {
            waitForVisibility(DX_IDM_Username);
            DX_IDM_Username.clear();
            DX_IDM_Username.sendKeys(username);
            waitForVisibility(DX_IDM_ContinueCTA);
            DX_IDM_ContinueCTA.click();
            waitForVisibility(DX_IDM_Password);
            DX_IDM_Password.sendKeys(password);
            DX_IDM_PasswordLoginCTA.click();
            //cro biometric prompt
            try {
                waitForVisibility(PromptLabel);
                    cancelBiometricPrompt();
                    selectPassword();
                    pressAllDoneCTA();
                }
            catch (Exception e){

            selectPassword();
            pressAllDoneCTA();
            }
        } catch (Exception e) {
            //returning case
            waitForVisibility(DX_IDM_Password);
            DX_IDM_Password.sendKeys(password);
            waitForVisibility(DX_IDM_PasswordLoginCTA);
            DX_IDM_PasswordLoginCTA.click();
        }
        try {
            waitForVisibility(Login_Prompt_CloseCTA);
            Login_Prompt_CloseCTA.click();
        } catch (Exception e) {
            System.out.println("Login Preference Prompt didn't appear");
        }
        setLoginStatusStatus("true");
    }

    @Override
    public void userNavigateToLoginScreen() {
        try {
            beforeLoginUsernameAndPasswordScreen();
        } catch (Exception e) {
            System.out.println("login after skip login");
        }
        try {
            waitForVisibility(DX_IDM_MyAccountTray);
            DX_IDM_MyAccountTray.click();
        } catch (Exception e) {
            System.out.println("Login without clicking on My account in Tray");
        }
        try {
            acceptCookies();
        } catch (Exception e) {
            System.out.println("cookies already accepted");
        }
    }

    @Override
    public void acceptCookies() {
        if (elementIsPresent(AcceptCookies)) {
            AcceptCookies.click();
        } else {
            System.out.println("Cookies are not displayed");
        }
    }

    @Override
    public void loginWithBioUserNameAndPwd() throws InterruptedException {
        try {
            waitForVisibility(DX_IDM_Password);
            DX_IDM_Password.sendKeys("testing1");
            Thread.sleep(1000);
            DX_IDM_PasswordLoginCTA.click();
            Thread.sleep(5000);
        } catch (Exception e) {
            System.out.println("password screen not displayed");
        }
    }

    public void hardClose() {
        killApp();
        startActivity();
    }

    public void validateDashboardDisplayedAfterFullLoginWithPIN() throws InterruptedException {
        Thread.sleep(5000);
        System.out.println("validateDashboardDisplayedAfterFullLoginWithPIN");
        if (elementIsPresent(DX_IDM_MyAccountDrawerXIcon)) {
            System.out.println("User logged in from My Account");
        } else {
            waitForVisibility(DB_MyAccountTray_icon);
            System.out.println("User didn't login from My Account");
        }
    }

    public void validateDashboardDisplayedAfterFullLoginWithPassword() throws InterruptedException {
        Thread.sleep(5000);
        //Tut.WF_TUT_closeCTA.click();
        //  System.out.println("validateDashboardDisplayedAfterFullLoginWithPassword");
        Thread.sleep(5000);
        DX_IDM_MyAccountTray.isDisplayed();
    }

    public void loginJourney() throws InterruptedException {
        Thread.sleep(4000);
        waitForVisibility(DX_IDM_Username);
        DX_IDM_Username.sendKeys(username);
        Thread.sleep(1000);
        waitForVisibility(DX_IDM_ContinueCTA);
        DX_IDM_ContinueCTA.click();
        waitForVisibility(DX_IDM_Password);
        DX_IDM_Password.sendKeys("testing1");
        Thread.sleep(1000);
        DX_IDM_PasswordLoginCTA.click();
        //Thread.sleep(1000);
        selectPIN();
        DX_IDM_LoginPreferencesOkCTA.click();
    }


    /*   public void validateDashboardDisplayedAfterFullLoginWithPassword() throws InterruptedException {
           Thread.sleep(5000);
           System.out.println("validateDashboardDisplayedAfterFullLoginWithPassword");
           DX_IDM_MyAccountTray.isDisplayed();
       }
   */
    public void navigateToMyAccount() throws InterruptedException {
        waitForVisibility(DX_IDM_MyAccountTray);
        //Thread.sleep(5000);
        DX_IDM_MyAccountTray.click();

    }

    @Override
    public void closeMyAccountDrawer() {
        DX_IDM_MyAccountDrawerXIcon.click();
    }

    public void validatePINScreenDisplayedAfterHardCloseAndOpenMyAccount() throws InterruptedException {
        waitForVisibility(DX_IDM_PINScreenAfterLogin);
        AssertDisplayed(DX_IDM_PINScreenAfterLogin.isDisplayed());
    }

    public void validatePasswordScreenDisplayedAfterHardCloseAndOpenMyAccount() throws InterruptedException {
        Thread.sleep(5000);
        AssertDisplayed(DX_IDM_PasswordLoginCTA.isDisplayed());
    }

    @Override
    public void enterInValidPINForFiveTimesandContinue() throws InterruptedException {
        for (int i = 0; i < 6; i++) {
            enterInValidPINAndClickOnContinue();
            Thread.sleep(5000);
            if (elementIsPresent(DX_IDM_BlockedScreenMessage))
                break;
            waitForVisibility(DX_IDM_OKCTA);
            DX_IDM_OKCTA.click();
        }
    }

    public void enterInvalidPasswordMoreThanSixTimes() throws InterruptedException {
        waitForVisibility(DX_IDM_PasswordLoginCTA);
        for (int i = 0; i <= 6; i++) {
            DX_IDM_Password.sendKeys("testing111");
            DX_IDM_PasswordLoginCTA.click();
            Thread.sleep(1000);
            DX_IDM_Password.clear();
            Thread.sleep(1000);
        }
        waitForVisibility(DX_IDM_LockedTitle);
    }

    public void validateLockedAccountScreen() throws InterruptedException {
        AssertDisplayed(DX_IDM_LockedTitle.isDisplayed());
        AssertDisplayed(DX_IDM_LockedBody.isDisplayed());
        AssertDisplayed(DX_IDM_ResetLinkInLockedScreen.isDisplayed());
        AssertDisplayed(DX_IDM_Password.isDisplayed());
        AssertDisplayed(DX_IDM_ForgotPassword.isDisplayed());
    }

    public void validateLockedScreenDisplayedAfterEnterInvalidPasswordMoreThanSixTrial() throws InterruptedException {
        Thread.sleep(2000);
        AssertDisplayed(DX_IDM_PasswordLoginCTA.isDisplayed());
        AssertDisplayed(DX_IDM_LockedBody.isDisplayed());
    }

    public void validateResetJourneyDisplayedAfterClickOnResetPasswordOnLockedScreen() throws InterruptedException {
        DX_IDM_ResetLinkInLockedScreen.click();
        Thread.sleep(5000);
        AssertDisplayed(DX_IDM_ResetPasswordTitle.isDisplayed());
    }


    public void enterPINAndClickOnContinue() throws InterruptedException {
        Thread.sleep(1000);
        waitForVisibility(DX_IDM_PINEditTxt);
        DX_IDM_PINEditTxt.sendKeys("2580");
        DX_IDM_ContinueCTA.click();
    }

    public void enterInValidPINAndClickOnContinue() throws InterruptedException {
        waitForVisibility(DX_IDM_PINEditTxt);
        DX_IDM_PINEditTxt.sendKeys("2222");
        DX_IDM_ContinueCTA.click();
    }

    public void validateMYAccountOpenedAfterEnterValidPIN() throws InterruptedException {
        Thread.sleep(6000);
        AssertDisplayed(DX_IDM_MyAccountTrayTitle.isDisplayed());
    }

    public void validateErrorScreenDisplayedAfterEnterInvalidPIN() throws InterruptedException {
        Thread.sleep(2000);
        AssertDisplayed(DX_IDM_OKCTA.isDisplayed());
        //AssertDisplayed(DX_IDM_MessageInvalidPIN.isDisplayed());
    }


    public void validatePINScreenDisplayedAfterClickOnOKCTA() {
        DX_IDM_OKCTA.click();
        AssertDisplayed(DX_IDM_PINScreenAfterLogin.isDisplayed());
    }

    public void validateBlockedScreenShouldBeDisplayedAfterEnterInvalidPINFor5Times() throws InterruptedException {
        //waitForVisibility(DX_IDM_BlockedScreenMessage);
        AssertDisplayed(DX_IDM_BlockedScreenTitle.isDisplayed());
        System.out.println(DX_IDM_BlockedScreenMessage.getText());
        AssertDisplayed(DX_IDM_BlockedScreenMessage.isDisplayed());
        Assert.assertTrue(DX_IDM_BlockedScreenMessage.getText().contains("The incorrect login details were entered several"));
        AssertDisplayed(DX_IDM_BlockedScreenResetPasswordCTA.isDisplayed());
        AssertDisplayed(DX_IDM_BlockedScreenCloseCTA.isDisplayed());
    }

    public void validateResetJourneyDisplayedAfterClickOnResetPassword() {
        DX_IDM_BlockedScreenResetPasswordCTA.click();
        waitForVisibility(DX_IDM_ResetPasswordTitle);
        AssertDisplayed(DX_IDM_ResetPasswordTitle.isDisplayed());
    }

    public void validateCloseCTAWillDismissTheBlockedErrorScreen() {
        DX_IDM_BlockedScreenCloseCTA.click();
    }

    public void TapOnMyAccount() {
        waitForVisibility(DB_MyAccountTray_icon);
        DB_MyAccountTray_icon.click();
    }

    public void ValidateUsernameIsAutoPopulated() {
        waitForVisibility(DX_IDM_Password);
        AssertResult(DX_IDM_UsernameInPasswordScreen.getText(), username);
        DX_IDM_XCTA.click();
    }

    public void assertPinFieldInForgottenUsernameScreen() {
        waitForVisibility(DX_IDM_ForgotUsername);
        DX_IDM_ForgotUsername.click();
        if (ReadResponse.GetHintCode().equalsIgnoreCase("4125"))
            throw new SkipException("Item not exist in the response");
        else {
            loginObject = new LoginPO();
            waitForVisibility(loginObject.Pin_Field);
            AssertDisplayed(loginObject.Pin_Field.isDisplayed());
        }
    }

    public void assertComplexInForgottenUsernameScreen() {
        waitForVisibility(DX_IDM_ForgotUsername);
        DX_IDM_ForgotUsername.click();
        if (ReadResponse.GetHintCode().equalsIgnoreCase("4125")) {
//            waitForVisibility(loginPO.First_name);
//            AssertDisplayed(loginPO.First_name.isDisplayed());
        } else {
            DX_IDM_XCTA.click();
            throw new SkipException("Item not exist in the response");
        }
    }

    public void TapOnUniversalLink() {
        openDeepLinkForiOS("myvodafone://FORGOT_USERNAME");
    }

    public void clickOnLoginCTA() {
        try {
            elementIsPresent(driver.findElement(loginButton));
            driver.findElement(loginButton).click();
            waitForVisibilityForReinvent(cookieButton, 100);
        } catch (Exception e) {
            System.out.println("Login without Click on Login screen");
        }
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
        waitForVisibility(loginButtonPassword);
        System.out.println("Username has inserted successfully");
        driver.findElement(loginButtonPassword).click();
        //waitForVisibility(allDone);
        System.out.println("Password has inserted successfully");
    }

    public void selectLogPref(String LogPrefChoice) {
        if (LogPrefChoice.equalsIgnoreCase("PIN")) {
            waitForVisibility(pereferncePIN);
            driver.findElement(pereferncePIN).click();
        } else {
            waitForVisibility(perefernceUN);
            driver.findElement(perefernceUN).click();
        }
        waitForVisibility(allDone);
        driver.findElement(allDone).click();
        waitForVisibilityForReinvent(MyAccountTray_icon_IOS, 100);
        System.out.println("User logged in successfully");
    }

    public void cancelBiometricPrompt() {
        waitForVisibility(PromptLabel);
        driver.findElement(PromptNotNowCta).click();
    }

    public void acceptBiometricPrompt() {
        waitForVisibility(PromptLabel);
        driver.findElement(PromptBiometricCta).click();
    }

    public void FL(String LogPrefChoice) throws InterruptedException {
        acceptCookies();
        insertUsername();
        insertPassword();
        //cro biometric prompt
        try {
            waitForVisibility(PromptLabel);
                cancelBiometricPrompt();
                selectLogPref(LogPrefChoice);

        }
        catch (Exception e) {

            selectLogPref(LogPrefChoice);
        }
    }

    public void returnigUserUsingUN() {
        try {
            insertPassword();
            System.out.println("Returning user using UN and Password as Login Pref");
            waitForVisibility(MyAccountXIcon);
            MyAccountXIcon.click();
        } catch (Exception e) {
            System.out.println("User didn't land on Password Screen");
        }
    }


    @Override
    public void validateBiometricsPrompt() {
        waitForVisibility(DX_IDM_LoginPreferencesTitle);
        System.out.println("text" + DX_IDM_LogPrefBiometricsPrompt.getText());
        Assert.assertTrue(DX_IDM_LogPrefBiometricsPrompt.getText().contains("Fastest way to login"));
    }
}

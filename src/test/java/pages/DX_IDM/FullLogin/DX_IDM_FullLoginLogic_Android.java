package pages.DX_IDM.FullLogin;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.SkipException;
import pages.DX_IDM.UFL.DX_IDM_UFL_Android;
import pages.DX_IDM.WelcomeFlow.DX_IDM_WelcomeFlowLogicAbstract;
import pages.DX_IDM.WelcomeFlow.DX_IDM_WelcomeFlowLogicAndroid;
import pages.Login.LoginPO;
//import pages.Tutorials.TutorialPo;
import testdata.ReadResponse;
import testdata.ReadTestData;
import testdata.TestData;

import java.util.Properties;

import static core.Config.setLoginStatusStatus;
import static utilities.PropertiesLoader.readEnv;
import static utilities.PropertiesLoader.readPropertyFile;
import static utils.element_helpers.ActionsHelpers.tapAtScreenCenter;
import static utils.element_helpers.DriverHelps.killApp;
import static utils.element_helpers.DriverHelps.startActivity;
import static utils.element_helpers.VerifyHelpers.*;
import static utils.element_helpers.WaitHelpers.waitForVisibility;
import static utils.element_helpers.WaitHelpers.waitForVisibilityForReinvent;

public class DX_IDM_FullLoginLogic_Android extends DX_IDM_FullLoginLogic_Abstract {

    String username;
    String MSISDN;
    Properties envProp = readPropertyFile("config/env.properties");
    String password = System.getProperty("password", envProp.getProperty("password"));
    String DOB = System.getProperty("DOB", envProp.getProperty("DOB"));
    String firstName = System.getProperty("FirstName", envProp.getProperty("FirstName"));
    String lastName = System.getProperty("LastName", envProp.getProperty("LastName"));
    private DX_IDM_WelcomeFlowLogicAbstract dx_idm_welcomeFlowLogic;
    private DX_IDM_UFL_Android dX_IDM_UFL_Android;
    private LoginPO loginObject;
    Boolean live = System.getProperty("isLiveTest", readEnv("isLiveTest")).equalsIgnoreCase("true");
    private final By App_settings = By.xpath("//android.widget.TextView[contains(@resource-id, 'com.myvodafoneapp:id/txtPlanListItemTitle') and @text='My Account']");

    //private TutorialPo Tut;
    By loginButton = By.xpath("//*[@text='Log In']");
    By loginButtonPassword = By.xpath("//*[@text='Log in']");
    By cookieButton = By.xpath("//*[@text='Accept all cookies']");
    By continueB = By.xpath("//*[@text='Continue']");
    By passwordBox = By.xpath("//*[@resource-id='pass']");
    By allDone = By.id("com.myvodafoneapp:id/btnConfirm");
    By pereferncePIN = By.xpath("//*[@text='PIN']");
    By perefernceUN = By.xpath("//*[@text='Username and password']");
    By accountTrayIcon = By.xpath("//*[@text='My Account']");

    By PromptLabel = By.id("bio_Login_Description_Label");
    By PromptBiometricCta = By.id("useBiometricsCTA");
    By PromptNotNowCta = By.id("notNowCTA");


    public DX_IDM_FullLoginLogic_Android() {
        super();
        dx_idm_welcomeFlowLogic = new DX_IDM_WelcomeFlowLogicAndroid();
        dX_IDM_UFL_Android = new DX_IDM_UFL_Android();
        MSISDN = TestData.GetMSISDN();
    }

    @Override
    public void beforeLoginUsernameAndPasswordScreen() throws InterruptedException {
        //dx_idm_welcomeFlowLogic.dxIDMWelcomeFlow();
        username = TestData.GetUserName();
        waitForVisibility(DX_IDM_LoginCTA);
        try {
            DX_IDM_LoginCTA.click();
        } catch (Exception e) {
            navigateToMyAccount();
        }
        // waitForVisibility(DX_IDM_Username);
    }

    @Override
    public void validateUsernameScreenContent() throws InterruptedException {
        username = ReadTestData.getUsername();
        waitForVisibility(DX_IDM_ForgotUsername);
        AssertDisplayed(DX_IDM_RegisterLink.isDisplayed());
        AssertDisplayed(DX_IDM_CreateAccountLink.isDisplayed());
        DX_IDM_Username.sendKeys(username);
        Thread.sleep(1000);
        DX_IDM_ContinueCTA.click();
    }

    @Override
    public void validatePasswordScreenContent() throws InterruptedException {
        waitForVisibility(DX_IDM_Password);
        AssertDisplayed(DX_IDM_ForgotPassword.isDisplayed());
        AssertDisplayed(DX_IDM_RegisterLink.isDisplayed());
        AssertDisplayed(DX_IDM_CreateAccountLink.isDisplayed());
        DX_IDM_Password.sendKeys(password);
        Thread.sleep(3000);
        DX_IDM_PasswordLoginCTA.click();
        Thread.sleep(2000);
    }


    @Override
    public void validateLoginPrefScreenContent() {
        waitForVisibility(DX_IDM_LoginPreferencesTitle);
        AssertDisplayed(DX_IDM_LogPrefPIN.isDisplayed());
        AssertDisplayed(DX_IDM_LogPrefPassword.isDisplayed());

        AssertDisplayed(DX_IDM_LoginPreferencesOkCTA.isDisplayed());
    }

    @Override
    public void enterPassword() {
        DX_IDM_Password.sendKeys(password);
    }

    @Override
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
        DX_IDM_DOB_Day.sendKeys(DOB.substring(0, 2));
        DX_IDM_DOB_Month.sendKeys(DOB.substring(2, 4));
        DX_IDM_DOB_Year.sendKeys(DOB.substring(4, 8));
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

    @Override
    public void validatePasswordShown() {
        Assert.assertEquals(DX_IDM_Password.getText(), password);
    }

    @Override
    public void validatePasswordHidden() {
        Assert.assertEquals(DX_IDM_Password.getText(), "••••••••");

    }

    @Override
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

    @Override
    public void selectPassword() {
        //cro biometric prompt
        try {
            waitForVisibility(PromptLabel);
                cancelBiometricPrompt();
                waitForVisibility(DX_IDM_LogPrefPassword);
                DX_IDM_LogPrefPassword.click();
                DX_IDM_LogPrefPassword.click();

        } catch (Exception e) {
            waitForVisibility(DX_IDM_LogPrefPassword);
            DX_IDM_LogPrefPassword.click();
            DX_IDM_LogPrefPassword.click();
        }
    }

    @Override
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

    @Override
    public void pressAllDoneCTA() {
        waitForVisibility(DX_IDM_LoginPreferencesOkCTA);
        DX_IDM_LoginPreferencesOkCTA.click();
        //DX_IDM_LoginPreferencesOkCTA.click();
        //waitForVisibility(DB_AllowanceTileHeader);
        //AssertDisplayed(DB_AllowanceTileHeader.isDisplayed());
        //setLoginStatusStatus("true");
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

    @Override
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

        } catch (Exception e) {
            selectPIN();
            DX_IDM_LoginPreferencesOkCTA.click();
        }
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
        DX_IDM_Password.sendKeys("testing1");
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


    @Override
    public void fullLoginWithUNandPW() throws InterruptedException {
        username = ReadTestData.getUsername();
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
        username = ReadTestData.getUsername();
        DX_IDM_Username.sendKeys(username);
        Thread.sleep(1000);
        DX_IDM_ContinueCTA.click();
        waitForVisibility(DX_IDM_Password);
        DX_IDM_Password.sendKeys(password);
        Thread.sleep(1000);
        DX_IDM_PasswordLoginCTA.click();
        Thread.sleep(5000);
        selectPassword();
        pressAllDoneCTA();
        Thread.sleep(5000);
    }

    public void cancelBiometricPrompt() {
        waitForVisibility(PromptLabel);
        driver.findElement(PromptNotNowCta).click();
    }

    public void acceptBiometricPrompt() {
        waitForVisibility(PromptLabel);
        driver.findElement(PromptBiometricCta).click();
    }

    //duplicate to the above and needs to be reviseted and removed
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

            } catch (Exception e) {
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
        waitForVisibility(DX_IDM_Password);
        DX_IDM_Password.sendKeys("testing1");
        Thread.sleep(1000);
        DX_IDM_PasswordLoginCTA.click();
        Thread.sleep(5000);
    }

    @Override
    public void hardClose() {
        killApp();
        startActivity();
    }

    @Override
    public void validateDashboardDisplayedAfterFullLoginWithPIN() throws InterruptedException {
        if(live){
          waitForVisibility(App_settings);
        }else {
            Thread.sleep(5000);
            System.out.println("validateDashboardDisplayedAfterFullLoginWithPIN");
            if (elementIsPresent(DX_IDM_MyAccountDrawerXIcon)) {
                System.out.println("User logged in from My Account");
            } else {
                waitForVisibility(DB_MyAccountTray_icon);
                System.out.println("User didn't login from My Account");
            }
        }
    }

    @Override
    public void validateDashboardDisplayedAfterFullLoginWithPassword() throws InterruptedException {
        Thread.sleep(5000);
        WF_TUT_closeCTA.click();
        //  System.out.println("validateDashboardDisplayedAfterFullLoginWithPassword");
        Thread.sleep(5000);
        DX_IDM_MyAccountTray.isDisplayed();
    }

    @Override
    public void loginJourney() throws InterruptedException {
        username = TestData.GetUserName();
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

    @Override
    public void navigateToMyAccount() throws InterruptedException {
        //Thread.sleep(5000);
        waitForVisibilityForReinvent(DX_IDM_MyAccountTray, 200);
        DX_IDM_MyAccountTray.click();
    }

    @Override
    public void closeMyAccountDrawer() {
        DX_IDM_MyAccountDrawerXIcon.click();
    }

    @Override
    public void validatePINScreenDisplayedAfterHardCloseAndOpenMyAccount() throws InterruptedException {
        // waitForVisibility(DX_IDM_PINScreenAfterLogin);
        Thread.sleep(2000);
        waitForVisibility(DX_IDM_PINScreenAfterLogin);
        AssertDisplayed(DX_IDM_PINScreenAfterLogin.isDisplayed());
    }

    @Override
    public void validatePasswordScreenDisplayedAfterHardCloseAndOpenMyAccount() throws InterruptedException {
        Thread.sleep(5000);
        AssertDisplayed(DX_IDM_PasswordLoginCTA.isDisplayed());
    }

    @Override
    public void enterInValidPINForFiveTimesandContinue() throws InterruptedException {
        for (int i = 0; i <= 5; i++) {
            enterInValidPINAndClickOnContinue();
            if (driver.findElements(By.xpath("//*[@text='My Vodafone']")).size() > 0) {
                break;
            }

            waitForVisibility(DX_IDM_OKCTA);
            DX_IDM_OKCTA.click();
        }
    }

    @Override
    public void enterInvalidPasswordMoreThanSixTimes() throws InterruptedException {
        waitForVisibility(DX_IDM_PasswordLoginCTA);
        for (int i = 0; i <= 5; i++) {
            DX_IDM_Password.sendKeys("testing111");
            DX_IDM_PasswordLoginCTA.click();
            Thread.sleep(1000);
            DX_IDM_Password.clear();
            Thread.sleep(1000);
        }
        waitForVisibility(DX_IDM_LockedTitle);
    }

    @Override
    public void validateLockedAccountScreen() throws InterruptedException {
        AssertDisplayed(DX_IDM_LockedTitle.isDisplayed());
        AssertDisplayed(DX_IDM_LockedBody.isDisplayed());
        AssertDisplayed(DX_IDM_ResetLinkInLockedScreen.isDisplayed());
        AssertDisplayed(DX_IDM_Password.isDisplayed());
        AssertDisplayed(DX_IDM_ForgotPassword.isDisplayed());
    }

    @Override
    public void validateLockedScreenDisplayedAfterEnterInvalidPasswordMoreThanSixTrial() throws InterruptedException {
        Thread.sleep(2000);
        AssertDisplayed(DX_IDM_PasswordLoginCTA.isDisplayed());
        AssertDisplayed(DX_IDM_LockedBody.isDisplayed());
    }

    @Override
    public void validateResetJourneyDisplayedAfterClickOnResetPasswordOnLockedScreen() throws InterruptedException {
        DX_IDM_ResetLinkInLockedScreen.click();
        Thread.sleep(5000);
        AssertDisplayed(DX_IDM_ResetPasswordTitle.isDisplayed());
    }

    @Override
    public void enterPINAndClickOnContinue() throws InterruptedException {
        tapAtScreenCenter();
        waitForVisibility(DX_IDM_PINEditTxt);
        DX_IDM_PINEditTxt.sendKeys("2");
        DX_IDM_PINEditTxt1.sendKeys("5");
        DX_IDM_PINEditTxt2.sendKeys("8");
        DX_IDM_PINEditTx3.sendKeys("0");
        DX_IDM_ContinueCTA.click();
    }

    @Override
    public void enterInValidPINAndClickOnContinue() throws InterruptedException {
        Thread.sleep(1000);
        DX_IDM_PINEditTxt.sendKeys("2");
        DX_IDM_PINEditTxt1.sendKeys("2");
        DX_IDM_PINEditTxt2.sendKeys("2");
        DX_IDM_PINEditTx3.sendKeys("2");
        DX_IDM_ContinueCTA.click();
    }

    @Override
    public void validateMYAccountOpenedAfterEnterValidPIN() throws InterruptedException {
        Thread.sleep(6000);
        AssertDisplayed(DX_IDM_MyAccountTrayTitle.isDisplayed());
    }

    @Override
    public void validateErrorScreenDisplayedAfterEnterInvalidPIN() throws InterruptedException {
        Thread.sleep(2000);
        AssertDisplayed(DX_IDM_OKCTA.isDisplayed());
        AssertDisplayed(DX_IDM_MessageInvalidPIN.isDisplayed());
    }

    @Override
    public void validatePINScreenDisplayedAfterClickOnOKCTA() {
        DX_IDM_OKCTA.click();
        AssertDisplayed(DX_IDM_PINScreenAfterLogin.isDisplayed());
    }

    @Override
    public void validateBlockedScreenShouldBeDisplayedAfterEnterInvalidPINFor5Times() {
        AssertDisplayed(DX_IDM_BlockedScreenTitle.isDisplayed());
        System.out.println(DX_IDM_BlockedScreenMessage.getText());
        AssertDisplayed(DX_IDM_BlockedScreenMessage.isDisplayed());
        Assert.assertTrue(DX_IDM_BlockedScreenMessage.getText().contains("The incorrect login details were entered several time"));
        AssertDisplayed(DX_IDM_BlockedScreenResetPasswordCTA.isDisplayed());
        AssertDisplayed(DX_IDM_BlockedScreenCloseCTA.isDisplayed());
    }

    @Override
    public void validateResetJourneyDisplayedAfterClickOnResetPassword() {
        DX_IDM_BlockedScreenResetPasswordCTA.click();
        waitForVisibility(DX_IDM_ResetPasswordTitle);
        AssertDisplayed(DX_IDM_ResetPasswordTitle.isDisplayed());
    }

    @Override
    public void validateCloseCTAWillDismissTheBlockedErrorScreen() {
        waitForVisibility(DX_IDM_BlockedScreenCloseCTA);
        DX_IDM_BlockedScreenCloseCTA.click();
    }

    public void ValidateResetPasswordScreenContent() throws InterruptedException {
        Thread.sleep(1000);
        AssertDisplayed(DX_IDM_ResetPasswordTitle.isDisplayed());
    }

    @Override
    public void TapOnMyAccount() {
        waitForVisibility(DB_MyAccountTray_icon);
        DB_MyAccountTray_icon.click();
    }

    @Override
    public void ValidateUsernameIsAutoPopulated() {
        username = TestData.GetUserName();
        waitForVisibility(DX_IDM_Password);
        AssertResult(DX_IDM_UsernameInPasswordScreen.getText(), username);
        DX_IDM_XCTA.click();
    }

    @Override
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

    @Override
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

    @Override
    public void TapOnUniversalLink() {
        driver.navigate().to("myvodafone://FORGOT_USERNAME");
    }

    public void validateCheckOnPhysicalBackButtonBehavior_Username() throws InterruptedException {
        dX_IDM_UFL_Android.ClickOnPhysicalBackButton();
        AssertDisplayed(DX_IDM_ForgotUsername.isDisplayed());
        AssertDisplayed(DX_IDM_RegisterLink.isDisplayed());
        AssertDisplayed(DX_IDM_CreateAccountLink.isDisplayed());
    }

    public void validateCheckOnPhysicalBackButtonBehavior_Password() throws InterruptedException {
        dX_IDM_UFL_Android.ClickOnPhysicalBackButton();
        AssertDisplayed(DX_IDM_ForgotPassword.isDisplayed());
        AssertDisplayed(DX_IDM_RegisterLink.isDisplayed());
        AssertDisplayed(DX_IDM_CreateAccountLink.isDisplayed());


    }

    public void validateCheckOnPhysicalBackButtonBehavior_LoginPreference() throws InterruptedException {
        dX_IDM_UFL_Android.ClickOnPhysicalBackButton();
        validateLoginPrefScreenContent();
    }

    public void clickOnLoginCTA() throws InterruptedException {
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
        waitForVisibilityForReinvent(MyAccountTray_icon_Android, 100);
        System.out.println("User logged in successfully");
    }

    public void FL(String LogPrefChoice) {
        acceptCookies();
        insertUsername();
        insertPassword();
        //cro biometric prompt
        try {
            waitForVisibility(PromptLabel);
            cancelBiometricPrompt();
            selectLogPref(LogPrefChoice);

        } catch (Exception e) {
            selectLogPref(LogPrefChoice);
        }
    }

    public void returnigUserUsingUN() {
        try {
            acceptCookies();
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
        Assert.assertTrue(DX_IDM_LogPrefBiometricsPrompt.getText().contains("Fastest way to login"));
    }

}

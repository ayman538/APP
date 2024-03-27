package pages.DX_IDM.FullLogin;


import core.Config;
import org.testng.Assert;
import org.testng.SkipException;
import pages.DX_IDM.WelcomeFlow.DX_IDM_WelcomeFlowLogicAbstract;
import pages.DX_IDM.WelcomeFlow.DX_IDM_WelcomeFlowLogicAndroid;
import pages.DX_IDM.WelcomeFlow.DX_IDM_WelcomeFlowLogic_IOS;
import pages.Login.LoginPO;
import pages.Tray.DashboardTray.DashboardTrayPO;
import testdata.ReadResponse;
import testdata.TestData;

import static utils.element_helpers.DriverHelps.killApp;
import static utils.element_helpers.DriverHelps.startActivity;
import static utils.element_helpers.VerifyHelpers.AssertDisplayed;
import static utils.element_helpers.VerifyHelpers.AssertResult;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

public class DX_IDM_FullLoginLogic extends DX_IDM_FullLoginPO {
    private DX_IDM_WelcomeFlowLogicAbstract DX_IDM_WelcomeFlowLogic;
    private final Config config =new Config();
    String username;
    String password = "testing1";
    private DashboardTrayPO DB_object;
    private LoginPO loginObject;

    public DX_IDM_FullLoginLogic() {
        super();
        if (config.isAndroid()) DX_IDM_WelcomeFlowLogic = new DX_IDM_WelcomeFlowLogicAndroid();
        if (config.isIos()) DX_IDM_WelcomeFlowLogic = new DX_IDM_WelcomeFlowLogic_IOS();
    }

    public void beforeLoginUsernameAndPasswordScreen() throws InterruptedException {
        username = TestData.GetUserName();
        DX_IDM_WelcomeFlowLogic.dxIDMWelcomeFlow();
        Thread.sleep(5000);
        DX_IDM_LoginCTA.click();
        waitForVisibility(DX_IDM_Username);
    }

    public void validateUsernameScreenContent() throws InterruptedException {
        AssertDisplayed(DX_IDM_ForgotUsername.isDisplayed());
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
        DX_IDM_Password.sendKeys("testing1");
        Thread.sleep(1000);
        DX_IDM_ContinueCTA.click();
        Thread.sleep(1000);
    }

    public void validateLoginPrefScreenContent() {
        waitForVisibility(DX_IDM_LoginPreferencesTitle);
        AssertDisplayed(DX_IDM_LogPrefPIN.isDisplayed());
        AssertDisplayed(DX_IDM_LogPrefPassword.isDisplayed());
        //todo: check biometrics
        //AssertDisplayed(DX_IDM_LogPrefBiometrics.isDisplayed());
        AssertDisplayed(DX_IDM_LoginPreferencesOkCTA.isDisplayed());
    }

    public void enterPassword() {
        DX_IDM_Password.sendKeys(password);
    }

    public void showPassword() throws InterruptedException {
        DX_IDM_ShowPassword.click();
        Thread.sleep(500);
    }


    public void validatePasswordShown() {
        Assert.assertEquals(DX_IDM_Password.getText(), password);
    }

    public void validatePasswordHidden() {
        Assert.assertEquals(DX_IDM_Password.getText(), "••••••••");

    }

    public void selectPIN() {
        DX_IDM_LogPrefPIN.click();
    }

    public void selectPassword() {
        DX_IDM_LogPrefPassword.click();
    }

    public void selectBiometric() {
        DX_IDM_LogPrefBiometrics.click();
    }

    public void pressAllDoneCTA() {
        DX_IDM_LoginPreferencesOkCTA.click();
        waitForVisibility(DB_AllowanceTileHeader);
        AssertDisplayed(DB_AllowanceTileHeader.isDisplayed());
    }

    public void fullLoginWithPIN() throws InterruptedException {
        beforeLoginUsernameAndPasswordScreen();
        DX_IDM_Username.sendKeys(username);
        Thread.sleep(1000);
        DX_IDM_ContinueCTA.click();
        waitForVisibility(DX_IDM_Password);
        DX_IDM_Password.sendKeys("testing1");
        Thread.sleep(1000);
        DX_IDM_PasswordLoginCTA.click();
        Thread.sleep(1000);
        selectPIN();
        DX_IDM_LoginPreferencesOkCTA.click();
    }

    public void fullLoginWithUNandPW() throws InterruptedException {
        beforeLoginUsernameAndPasswordScreen();
        DX_IDM_Username.sendKeys(username);
        Thread.sleep(1000);
        DX_IDM_ContinueCTA.click();
        waitForVisibility(DX_IDM_Password);
        DX_IDM_Password.sendKeys("testing1");
        Thread.sleep(1000);
        DX_IDM_PasswordLoginCTA.click();
        Thread.sleep(5000);
        selectPassword();
        DX_IDM_LoginPreferencesOkCTA.click();
        Thread.sleep(5000);
    }

    public void hardClose() {
        killApp();
        startActivity();
    }

    public void validateDashboardDisplayedAfterFullLoginWithPIN() throws InterruptedException {
        Thread.sleep(5000);
        System.out.println("validateDashboardDisplayedAfterFullLoginWithPIN");
        //DX_IDM_MyAccountTray.isDisplayed();
    }

    public void validateDashboardDisplayedAfterFullLoginWithPassword() throws InterruptedException {
        DX_IDM_MyAccountTray.isDisplayed();
    }

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


    /*   public void validateDashboardDisplayedAfterFullLoginWithPassword() throws InterruptedException {
           Thread.sleep(5000);
           System.out.println("validateDashboardDisplayedAfterFullLoginWithPassword");
           DX_IDM_MyAccountTray.isDisplayed();
       }
   */
    public void navigateToMyAccount() throws InterruptedException {
        Thread.sleep(5000);
        // waitForVisibility(DX_IDM_MyAccountTray);
        DX_IDM_MyAccountTray.click();
    }

    public void validatePINScreenDisplayedAfterHardCloseAndOpenMyAccount() throws InterruptedException {
        // waitForVisibility(DX_IDM_PINScreenAfterLogin);
        Thread.sleep(2000);
        AssertDisplayed(DX_IDM_PINScreenAfterLogin.isDisplayed());
    }

    public void validatePasswordScreenDisplayedAfterHardCloseAndOpenMyAccount() throws InterruptedException {
        Thread.sleep(5000);
        AssertDisplayed(DX_IDM_PasswordLoginCTA.isDisplayed());
    }

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

    public void validateLockedAccountScreen()  {
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
        DX_IDM_PINEditTxt.sendKeys("2");
        DX_IDM_PINEditTxt1.sendKeys("3");
        DX_IDM_PINEditTxt2.sendKeys("4");
        DX_IDM_PINEditTx3.sendKeys("5");
        DX_IDM_ContinueCTA.click();
    }

    public void enterInValidPINAndClickOnContinue() throws InterruptedException {
        Thread.sleep(1000);
        DX_IDM_PINEditTxt.sendKeys("2");
        DX_IDM_PINEditTxt1.sendKeys("2");
        DX_IDM_PINEditTxt2.sendKeys("2");
        DX_IDM_PINEditTx3.sendKeys("2");
        DX_IDM_ContinueCTA.click();
    }

    public void validateMYAccountOpenedAfterEnterValidPIN() throws InterruptedException {
        Thread.sleep(6000);
        AssertDisplayed(DX_IDM_MyAccountTrayTitle.isDisplayed());
    }

    public void validateErrorScreenDisplayedAfterEnterInvalidPIN() throws InterruptedException {
        Thread.sleep(2000);
        AssertDisplayed(DX_IDM_OKCTA.isDisplayed());
        AssertDisplayed(DX_IDM_MessageInvalidPIN.isDisplayed());
    }


    public void validatePINScreenDisplayedAfterClickOnOKCTA() {
        DX_IDM_OKCTA.click();
        AssertDisplayed(DX_IDM_PINScreenAfterLogin.isDisplayed());
    }

    public void validateShouldBeBlockedAfterEnterInvalidPINFor100Times() throws InterruptedException {
        enterInValidPINAndClickOnContinue();
        for (int i = 0; i < 4; i++) {
            waitForVisibility(DX_IDM_OKCTA);
            DX_IDM_OKCTA.click();
            DX_IDM_ContinueCTA.click();
        }
        waitForVisibility(DX_IDM_BlockedScreenTitle);
    }

    public void validateBlockedScreenShouldBeDisplayedAfterEnterInvalidPINFor100Times()   {
        AssertDisplayed(DX_IDM_BlockedScreenTitle.isDisplayed());
        AssertDisplayed(DX_IDM_BlockedScreenMessage.isDisplayed());
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
        Assert.assertFalse(DX_IDM_BlockedScreenCloseCTA.isDisplayed());
    }

    public void TapOnMyAccount() {
        waitForVisibility(DB_object.DB_MyAccountTray_icon);
        DB_object.DB_MyAccountTray_icon.click();
    }

    public void ValidateUsernameIsAutoPopulated() {
        username = TestData.GetUserName();
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
        driver.navigate().to("myvodafone://FORGOT_USERNAME");
    }
}

/*package pages.Tray.Settings.AppSetting;

import core.Config;
import org.testng.SkipException;
import pages.Login.Login_Abstract;
import pages.Login.Login_Logic_Android;
import pages.Login.Login_Logic_IOS;
import pages.Tutorials.TutorialLogic;
import pages.Welcome.WelcomeLogicAbstract;
import pages.Welcome.WelcomeLogicAndroid;
import pages.Welcome.WelcomeLogic_IOS;
import testdata.ReadResponse;

import java.io.IOException;

import static core.Config.getLoginStatus;
import static utils.element_helpers.ScrollHelpers.*;
import static utils.element_helpers.VerifyHelpers.*;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

@Deprecated
public class AppSettingsLogic extends AppSettingsPO {

    private Login_Abstract login;
   private WelcomeLogicAbstract WelcLogic;
    private static boolean run = false;
    private static boolean resetPin = false;
    private final Config config=new Config();

    public AppSettingsLogic()  {
        if (config.isAndroid()) login = new Login_Logic_Android();
        if (config.isIos()) login = new Login_Logic_IOS();

        if (config.isAndroid()) WelcLogic = new WelcomeLogicAndroid();
        if (config.isIos()) WelcLogic = new WelcomeLogic_IOS();
    }


    public void navigateToAppSettingsScreen() {
        clickOnSettingsInTray();
        clickOnAppSettings();
    }

    public void clickOnAppSettings() {
        waitForVisibility(DB_AppSetting);
        DB_AppSetting.click();
    }

    public void clickOnSettingsInTray() {
        waitForVisibility(DB_SettingDashboardTray_icon);
        DB_SettingDashboardTray_icon.click();
    }

    public void assertOnItemsDisplayed() {
        if (ReadResponse.GetSegment().equalsIgnoreCase("PREPAY")) {
            AssertDisplayed(IsElementDisplayed(AS_LoginOption));
        } else {
            AssertResult(AS_LoginOption.getText(), "Login options");
        }
        AppSettingCommanItems();
    }

    public void assertOnItemsDisplayedForAcq() {
        AppSettingCommanItems();
        AS_XIcon.click();
    }

    private void AppSettingCommanItems() {
        assertResetAppText();
        AssertResult(AS_DevicePermission.getText(), "Device permissions");
        AssertResult(AS_TermsAndConditions.getText(), "Terms and Conditions");
        AssertDisplayed(AS_AppVersionfooter.isDisplayed());
        AssertDisplayed(AS_HardwareIdfooter.isDisplayed());
        AssertDisplayed(AS_CopyHardwareId.isDisplayed());
    }

    public void assertCopiedMsg() {
        AS_CopyHardwareId.click();
        AssertDisplayed(AS_CopiedToClipboardMsg.isDisplayed());
    }

    public void assertResetAppText() {
        waitForVisibility(AS_ScreenTitle);
        AssertResult(AS_ResetAPP.getText(), "Reset the app");
    }

    public void assertOnResetCardCTAandDescription() {
        AssertResult(AS_ResetCTA.getText(), "Reset");
        AssertDisplayed(AS_ResetAppDescription.isDisplayed());
        AS_BackButton.click();
    }

    public void assertTitleOfResetAppScreen() {
        AS_ResetAPP.click();
        waitForVisibility(AS_ResetAppTitle);
        AssertResult(AS_ResetAppTitle.getText(), "Reset the app");
    }

    public void UserNavigatedToAppSettingsScreen() {
        if (getLoginStatus().equalsIgnoreCase("False")) {
            Login_Xicon.click();
            AS_BackButton.click();
        }
    }


    public void assertResetAppJourney() throws IOException {
        AS_ResetCTA.click();
        waitForVisibility(AS_PopUpResetCTA);
        AS_PopUpResetCTA.click();
        WelcLogic.WelcomeBackFlow();
        TutorialLogic tutorialLogic = new TutorialLogic();
        tutorialLogic.Close();
    }

    public void assertElementsOfUsageCard() {
        AssertDisplayed(AS_DP_UsageStatus.isDisplayed());
        AssertDisplayed(AS_DP_UsageDescription.isDisplayed());
        AssertResult(AS_DP_UsageCTA.getText(), "Configure permission");
        AS_BackButton.click();
    }

    public void assertElementsOfMediaCard() {
        AssertDisplayed(AS_DP_photoMediaStatus.isDisplayed());
        AssertDisplayed(AS_DP_photoMediaDescription.isDisplayed());
        AssertResult(AS_DP_photoMediaCTA.getText(), "Configure permission");
    }

    public void assertElementsOfLocationCard() {
        AssertDisplayed(AS_DP_locationStatus.isDisplayed());
        AssertDisplayed(AS_DP_locationDescription.isDisplayed());
        AssertResult(AS_DP_locationCTA.getText(), "Configure permission");
    }

    public void assertElementsForPhoneCard() {
        AssertResult(AS_DP_phoneTitle.getText(), "Make and manage phone calls");
        AssertDisplayed(AS_DP_phoneStatus.isDisplayed());
        AssertDisplayed(AS_DP_phoneDescription.isDisplayed());
        AssertResult(AS_DP_phoneCTA.getText(), "Configure permission");
    }

    public void assertUsageText() {
        scrollDown();
        scrollDown();
        AssertResult(AS_DP_UsageTitle.getText(), "Usage access");
    }

    public void assertMediaTitle() {
        scrollDown();
        AssertResult(AS_DP_photoMediaTitle.getText(), "Photos, media and files");
    }

    public void assertDeviceLocationTitle() {
        scrollDownTo(AS_DP_locationTitle);
        AssertResult(AS_DP_locationTitle.getText(), "Device location");
    }

    public void assertDevicePermissionsTitle() {
        waitForVisibility(AS_DPTitle);
        AssertResult(AS_DPTitle.getText(), "Device permissions");
    }

    public void clickOnDevicePermissionElement() {
        waitForVisibility(AS_DevicePermission);
        AS_DevicePermission.click();
    }

    public void assertTandCDescriptionAndVersion() {
        AssertDisplayed(AS_TAndCDescription.isDisplayed());
        AssertDisplayed(AS_TAndCVersion.isDisplayed());
        AS_BackButton.click();
    }

    public void assertTandCTitle() {
        waitForVisibility(AS_TAndCTitle);
        AssertResult(AS_TAndCTitle.getText(), "Terms and conditions");
    }

    public void clickOnTandCElement() {
        waitForVisibility(AS_TermsAndConditions);
        AS_TermsAndConditions.click();
    }

    public void assertOnLoginOptionsScreenElements() {
        AssertResult(AS_LO_title.getText(), "Login options");
        AssertResult(AS_LO_SetUpYourPinCTA.getText(), "Set up your PIN");
    }

    public void clickOnSetUpYourPinCTA() {
        waitForVisibility(AS_LO_SetUpYourPinCTA);
        AS_LO_SetUpYourPinCTA.click();
        AssertDisplayed(Login_username.isDisplayed());
    }

    public void clickOnLoginOptionsElement() {
        waitForVisibility(AS_LoginOption);
        AS_LoginOption.click();
        run = true;
    }

    public void validateLoginOptionsLoginFunctionality() throws InterruptedException, IOException {
        if (!run)
            clickOnLoginOptionsElement();
        if (!getLoginStatus().equalsIgnoreCase("LoggedIn")) {
//            clickOnSetUpYourPinCTA();
            waitForVisibility(AS_LO_ResetYourPINCTA);
            AS_LO_ResetYourPINCTA.click();
            login.LoginFlow();
        } else throw new SkipException("The user already logged in");
    }

    public void assertOnLoginOptionsScreenElementsAfterLogin() {
        if (!run)
            clickOnLoginOptionsElement();
        waitForVisibility(AS_LO_ResetYourPINCTA);
        AssertResult(AS_LO_ResetYourPINCTA.getText(), "Reset your PIN");
        if (login.HasFaceID) {
            AssertResult(AS_LO_FingerPrintCardTitle.getText(), "Turn off Fingerprint authentication");
            AssertResult(AS_LO_FingerPrintCardToggle.getText(), "ON");
        }
    }

    public void clickOnResetYourPinCTA() {
        if (!resetPin) {
            if (getLoginStatus().equalsIgnoreCase("LoggedIn")) {
                waitForVisibility(AS_LO_ResetYourPINCTA);
                AS_LO_ResetYourPINCTA.click();
                AssertDisplayed(Login_username.isDisplayed());
                resetPin = true;
            }
        }
    }

    public void assertMemorableWordFieldDisplayed() {
        if (!ReadResponse.GetHintCode().equalsIgnoreCase("4125")) {
            driver.hideKeyboard();
            scrollDown();
            AssertDisplayed(MemorableWordField.isDisplayed());
        }
        Login_BackButton.click();
    }

    public void assertPinFieldInForgottenUsernameScreen() {
        ForgottenUsername_Hyperlink.click();
        if (ReadResponse.GetHintCode().equalsIgnoreCase("4125")) {
            waitForVisibility(First_name);
            AssertDisplayed(First_name.isDisplayed());
        } else
            AssertDisplayed(Pin_Field.isDisplayed());
    }

    public void assertResetPasswordScreenElements() {
        AssertDisplayed(EnterUsernameField.isDisplayed());
        scrollDown();
        AssertDisplayed(ResetPasswordCTA.isDisplayed());
        Login_BackButton.click();
    }

    public void clickOnForgottenPasswordHyperlink() {
        waitForVisibility(ForgottenPassword_Hyperlink);
        ForgottenPassword_Hyperlink.click();
        AssertResult(ResetYourPasswordTitle.getText(), "Reset your password");
    }

    public void assertFingerPrintStatus() {
        if (login.HasFaceID) {
//            Login_BackButton.click();
            Login_Xicon.click();
            AssertResult(AS_LO_FingerPrintCardTitle.getText(), "Turn off Fingerprint authentication");
            resetPin = false;
        }
    }

    public void assertTextAfterPinLoginToTurnToggleOFF() {
        if (login.HasFaceID) {
            AS_LO_FingerPrintCardToggle.click();
            AssertDisplayed(Pin_Field.isDisplayed());
            Pin_Field.sendKeys("2345");
            Pin_ContinueCTA.click();
            AssertResult(AS_LO_FingerPrintCardTitle.getText(), "Turn off Fingerprint authentication");
        }
    }

    public void assertFingerPrintToggleONStatus() {
        if (login.HasFaceID) {
            AS_LO_FingerPrintCardToggle.click();
            AssertResult(AS_LO_FingerPrintCardTitle.getText(), "Turn on Fingerprint authentication");
        }
    }

    public void loginWithNewPin() throws InterruptedException, IOException {
        login.LoginFlow("9", "8", "7", "6");
        if (login.HasFaceID) {
            waitForVisibility(AS_LO_FingerPrintCardToggle);
            AS_LO_FingerPrintCardToggle.click();
            AS_LO_FingerPrintCardToggle.click();
        }
    }

    public void assertInvalidPinErrorMessageIsDisplayed() {
        waitForVisibility(InvalidPinErrorMessage);
        AssertDisplayed(InvalidPinErrorMessage.isDisplayed());
        InvalidPinOkCTA.click();
        Login_BackButton.click();
        Login_Xicon.click();
        AS_BackButton.click();
    }

    public void pinLoginWithInvalidPin() {
        waitForVisibility(AS_LO_ResetYourPINCTA);
        AS_LO_ResetYourPINCTA.click();
        waitForVisibility(ForgottenUsername_Hyperlink);
        ForgottenUsername_Hyperlink.click();
        waitForVisibility(Pin_Field);
        Pin_Field.sendKeys("2345");
        Pin_Field1.sendKeys("2");
        Pin_Field2.sendKeys("3");
        Pin_Field3.sendKeys("4");
        Pin_Field4.sendKeys("5");
        Pin_NextCTA.click();
    }

    public void ValidateSwipeBack() {
        Login_Xicon.click();
        SwipeBackForIOS();
        AssertDisplayed(AS_TermsAndConditions.isDisplayed());
    }

    public void navigateToAppSettings() {
        clickOnSettingsInTray();
        clickOnAppSettings();
        waitForVisibility(AS_ScreenTitle);
    }

    public void navigateToPrivacySettings() {
        clickOnSettingsInTray();
        clickOnPrivacySettings();
    }

    public void clickOnPrivacySettings() {
        waitForVisibility(DB_PrivacySetting);
        DB_PrivacySetting.click();
    }

    public void validateSwipeDown() {
        SwipeDownForIOS();
        waitForVisibility(DB_SettingDashboardTray_icon);
        AssertDisplayed(DB_SettingDashboardTray_icon.isDisplayed());
    }
}

 */
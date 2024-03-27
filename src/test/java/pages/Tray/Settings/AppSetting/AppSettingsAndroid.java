package pages.Tray.Settings.AppSetting;
import models.response.ContentV2ResponseModel;
import models.response.SegmentResponseModel;
import models.response.SubscriptionsResponseModel;
import org.openqa.selenium.By;
import org.testng.SkipException;
import pages.Login.Login_Abstract;
import pages.Login.Login_Logic_Android;
import pages.Welcome.WelcomeLogicAbstract;
import pages.Welcome.WelcomeLogicAndroid;
import testdata.ReadResponse;
import utils.SegmentUtils;

import java.io.IOException;
import java.util.Properties;

import static core.Config.getLoginStatus;
import static core.Config.getSegment;
import static utilities.PropertiesLoader.readEnv;
import static utilities.PropertiesLoader.readPropertyFile;
import static utils.element_helpers.DriverHelps.hideKeyboard;
import static utils.element_helpers.ScrollHelpers.*;
import static utils.element_helpers.VerifyHelpers.*;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

public class AppSettingsAndroid extends AppSettingsAbstract {

    private Login_Abstract login;
    private WelcomeLogicAbstract WelcLogic;
    private static boolean run = false;
    private static boolean resetPin = false;
    SegmentResponseModel segmetResponseModel ;
    Properties envProp = readPropertyFile("config/env.properties");
    Boolean live = System.getProperty("isLiveTest", readEnv("isLiveTest")).equalsIgnoreCase("true");
    private final By app_settings_title = By.xpath("//android.widget.TextView[contains(@resource-id, 'com.myvodafoneapp:id/settingsSectionTitle') and @text='App Settings']");


    public AppSettingsAndroid()  {
        login = new Login_Logic_Android();
        WelcLogic = new WelcomeLogicAndroid();
        if(!live){
            segmetResponseModel = SegmentUtils.GetSegment();
        }
    }


    public void navigateToAppSettingsScreen() {
        clickOnSettingsInTray();
        clickOnAppSettings();
    }

    public void clickOnAppSettings() {
        waitForVisibility(DB_AppSetting);
        DB_AppSetting.click();
        AssertDisplayed(AS_ResetAppTitle.isDisplayed());
        AssertDisplayed(AS_TermsAndConditions.isDisplayed());
    }

    public void clickOnSettingsInTray() {
        waitForVisibility(DB_SettingDashboardTray_icon);
        DB_SettingDashboardTray_icon.click();
    }

    public void assertOnItemsDisplayed() {
        if (getSegment().equalsIgnoreCase("PREPAY")) {
            AssertDisplayed(!elementIsPresent(AS_LoginOption));
        } else {
            waitForVisibility(AS_LoginOption);
            AssertResult(AS_LoginOption.getText(), "Login options");
        }
        AppSettingCommanItems();
    }

    public void assertOnItemsDisplayedForAcq() {
        AppSettingCommanItems();
        AS_XIcon.click();
    }

    public void AppSettingCommanItems() {
        assertResetAppText();
        if (envProp.getProperty("Segment").equalsIgnoreCase("PREPAY")){
            assertElementDoesNotExist(AS_LoginOption);
        }
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
        waitForVisibility(app_settings_title);
        AssertResult(AS_ResetAPP.getText(), "Reset the app");
    }

    public void assertOnResetCardCTAandDescription() {
        AssertResult(AS_ResetCTA.getText(), "Reset");
        AssertDisplayed(AS_ResetAppDescription.isDisplayed());
        driver.findElement(By.id("com.myvodafoneapp:id/dismissImageView")).click();
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
        waitForVisibility(accountSettingsResetTehAppButton);
        accountSettingsResetTehAppButton.click();
        waitForVisibility(AS_ResetCTA);
        AS_ResetCTA.click();
        waitForVisibility(AS_PopUpResetCTA);
        AS_PopUpResetCTA.click();
        WelcLogic.WelcomeBackFlow();
//        if(elementIsPresent(RedHybrid_SkipLoginCTA)){
//            RedHybrid_SkipLoginCTA.click();
//        }
    }

    public void resetAppFromDashboard() throws IOException {
        navigateToAppSettingsScreen();
        waitForVisibility(DB_AppICON);
        DB_AppICON.click();
        waitForVisibility(ResetTheApp);
        ResetTheApp.click();
        waitForVisibility(AS_ResetCTA);
        AS_ResetCTA.click();
        waitForVisibility(AS_PopUpResetCTA);
        AS_PopUpResetCTA.click();
        WelcLogic.WelcomeBackFlow();
        if(elementIsPresent(RedHybrid_SkipLoginCTA)){
            RedHybrid_SkipLoginCTA.click();
        }
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
//        AssertDisplayed(AS_DP_phoneStatus.isDisplayed());
        AssertDisplayed(AS_DP_phoneDescription.isDisplayed());
        AssertResult(AS_DP_phoneCTA.getText(), "Configure permission");
    }

    public void assertUsageText() {
        scrollDown();
        scrollDown();
        AssertResult(AS_DP_UsageTitle.getText(), "Network and App Usage access");
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
//        AssertResult(AS_LO_title.getText(), "Login options");
        waitForVisibility(DX_IDM_X_Button);
        AssertDisplayed(DX_IDM_X_Button.isDisplayed());
//        AssertResult(AS_LO_SetUpYourPinCTA.getText(), "Set up your PIN");
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
    public void choosePinLoginOption() {
        waitForVisibility(DX_IDM_LogPrefPIN);
        DX_IDM_LogPrefPIN.click();
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

    public void ValidateSwipeBack() {
        Login_Xicon.click();
        SwipeBackForIOS();
        AssertDisplayed(AS_TermsAndConditions.isDisplayed());
    }

    public void navigateToAppSettings() {
        clickOnSettingsInTray();
        clickOnAppSettings();
        //waitForVisibility(AS_ScreenTitle);
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

    @Override
    public void assertDevicePermissionContent() {
        assertElementsForPhoneCard();
        assertDeviceLocationTitle();
        assertElementsOfLocationCard();
        assertMediaTitle();
        assertElementsOfMediaCard();
        assertUsageText();
        assertElementsOfUsageCard();
    }
    public void validateAppSettings(){
        if (envProp.getProperty("UnknownUser").equalsIgnoreCase("true") || (segmetResponseModel.segment.equalsIgnoreCase("PREPAY") && !(segmetResponseModel.subscriptionType.name.equalsIgnoreCase("HYBRID")))){
            AssertDisplayed(!IsElementDisplayed(AS_LoginOption));
        } else {
            AssertDisplayed(AS_LoginOption.isDisplayed());
        }
        waitForVisibility(AS_ResetAppTitle);
        AssertResult(DX_IDM_termsAndConditionsScreenTitle.getText(),"Settings");
        AssertResult(AS_AppSettingsTiitle.getText(),"App Settings");
        AssertDisplayed(AS_BackButton.isDisplayed());
        AssertDisplayed(AS_ResetAppTitle.isDisplayed());
        AssertDisplayed(AS_TermsAndConditions.isDisplayed());
        AssertDisplayed(!IsElementDisplayed(AS_DevicePermission));
        AssertDisplayed(AS_AppVersionfooter.isDisplayed());
        AssertDisplayed(AS_HardwareIdfooter.isDisplayed());
        AssertDisplayed(AS_CopyHardwareId.isDisplayed());
        AS_BackButton.click();
        waitForVisibility(DB_SettingDashboardTray_icon);
        AssertDisplayed(DB_SettingDashboardTray_icon.isDisplayed());
    }
    public void validateAppSettingsDeeplink() {
        driver.navigate().to("myvodafone://APP_SETTINGS");
    }

    public void resetAppFromNewSettingsTray() {
        navigateToAppSettings();
        AS_ResetAppTitle.click();
        waitForVisibility(ResetCTA);
        ResetCTA.click();
        waitForVisibility(ResetPopup_ResetCTA);
        ResetPopup_ResetCTA.click();
    }
}

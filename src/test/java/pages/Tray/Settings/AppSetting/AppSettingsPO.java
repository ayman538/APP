package pages.Tray.Settings.AppSetting;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.Commons.CommonPo;


public class AppSettingsPO extends CommonPo {

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Device permissions']"),
            @FindBy(how = How.XPATH, using = "//*[@label='Device permissions']")
    })
    public WebElement AS_DevicePermission;
    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Terms and Conditions']"),
            @FindBy(how = How.XPATH, using = "//*[@label='Terms and Conditions']")
    })
    public WebElement AS_TermsAndConditions;
    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[contains(@name,'App Version:')]"),
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/appVersionTextView"),
            @FindBy(how = How.ID, using = "txtAppSettingsAppVersion")
    })
    public WebElement AS_AppVersionfooter;
    @FindAll({
            @FindBy(how = How.ID, using = "Hardware ID:"),
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/hardwareIdTextView"),
            @FindBy(how = How.ID, using = "txtAppSettingsHardwareID")
    })
    public WebElement AS_HardwareIdfooter;
    @FindAll({
            @FindBy(how = How.ID, using = "copy_button"),
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/copyImageView"),
            @FindBy(how = How.ID, using = "txtAppSettingsHardwareID"),
    })
    public WebElement AS_CopyHardwareId;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/snackbar_text"),
            @FindBy(how = How.ID, using = "txtAppSettingsAppVersion")
    })
    public WebElement AS_CopiedToClipboardMsg;
    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Login options']"),
            @FindBy(how = How.XPATH, using = "//*[@label='Login options']")
    })
    public WebElement AS_LoginOption;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/txtLoginOptionTitle"),
            @FindBy(how = How.ID, using = "txtLoginOptionTitle")
    })
    public WebElement AS_LOTitle;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/txtDevicePermissionTitle"),
            @FindBy(how = How.ID, using = "txtDevicePermissionTitle")
    })
    public WebElement AS_DPTitle;
    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Terms and conditions']"),
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/Settings_TACView_TAC_Label"),
            @FindBy(how = How.ID, using = "txtTermsAndConditionTitle")
    })
    public WebElement AS_TAndCTitle;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/txtTermsAndConditionDescription"),
            @FindBy(how = How.ID, using = "txtTermsAndConditionTitle")
    })
    public WebElement AS_TAndCDescription;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/copyrightAndVersion"),
            @FindBy(how = How.ID, using = "Settings_TACView_TACCopyright_Label")
    })
    public WebElement AS_TAndCVersion;
    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Reset the app']"),
            @FindBy(how = How.XPATH, using = "//*[@label='Reset the app']"),
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/txtResetAppTitle"),
            @FindBy(how = How.ID, using = "txtResetAppTitle")
    })
    public WebElement AS_ResetAppTitle;

    @FindBy(how = How.XPATH, using = "//*[@text='Reset the app']")
    public WebElement accountSettingsResetTehAppButton;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/btmResetAppCTA"),
            @FindBy(how = How.ID, using = "txtAppSettingsSubitems_0"),
            @FindBy(how = How.ID_OR_NAME, using = "resetBtn"),
//            @FindBy(how = How.XPATH, using = "//*[@text='Reset the app']"),
            @FindBy(how = How.XPATH, using = "//XCUIElementTypeStaticText[@name='Reset']")
    })
    public WebElement AS_ResetCTA;
    @FindAll({
            @FindBy(how = How.ID, using = "android:id/button1"),
            @FindBy(how = How.XPATH, using = "//XCUIElementTypeButton[@name='Reset']")
//            @FindBy(how = How.ID_OR_NAME, using = "Reset")
//            @FindBy(how = How.XPATH, using = "//XCUIElementTypeOther[@name=\"Horizontal scroll bar, 1 page\"])[2]")

    })
    public WebElement AS_PopUpResetCTA;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/txtResetAppDescription"),
            @FindBy(how = How.ID, using = "Settings_ResetAppView_ResetAppDescription_Label")
    })
    public WebElement AS_ResetAppDescription;
    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Device location']"),
            @FindBy(how = How.XPATH, using = "//*[@label='Device location']")
    })
    public WebElement AS_DP_locationTitle;
    @FindAll({
            @FindBy(how = How.XPATH,using = "//androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.widget.TextView[2]"),
            @FindBy(how = How.XPATH, using = "((//*[@text='Device location']/following::*[@resource-id='" + "com.myvodafoneapp:id/txtPermissionStatus']))[1]"),
            @FindBy(how = How.XPATH, using = "((//*[@label='Device location']/following::*[@name='txtPermissionStatus']))[1]")
    })
    public WebElement AS_DP_locationStatus;
    @FindAll({
            @FindBy(how = How.XPATH,using = "//androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.widget.TextView[3]"),
            @FindBy(how = How.XPATH, using = "((//*[@text='Device location']/following::*[@resource-id='" + "com.myvodafoneapp:id/txtPermissionDescription']))[1]"),
            @FindBy(how = How.XPATH, using = "((//*[@text='Device location']/following::*[@resource-id='Capabilities.App_package:id/txtPermissionDescription']))[1]")
    })
    public WebElement AS_DP_locationDescription;
    @FindAll({
            @FindBy(how = How.XPATH,using = "//androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.widget.LinearLayout/android.widget.Button"),
            @FindBy(how = How.XPATH, using = "((//*[@text='Device location']/following::*[@resource-id='" + "com.myvodafoneapp:id/btmPermissionCTA']))[1]"),
            @FindBy(how = How.XPATH, using = "((//*[@label='Device location']/following::*[@name='btmPermissionCTA']))[1]")
    })
    public WebElement AS_DP_locationCTA;
    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Make and manage phone calls']"),
            //     @FindBy(how = How.XPATH, using = "//*[@label='Device location']") not inspected
    })
    public WebElement AS_DP_phoneTitle;
    @FindAll({
            @FindBy(how = How.XPATH, using = "((//*[@text='Make and manage phone calls']/following::*[@resource-id='" + "com.myvodafoneapp:id/txtPermissionStatus']))[1]"),
            //  @FindBy(how = How.XPATH, using = "(//*[@label='Device location']") not inspected
    })
    public WebElement AS_DP_phoneStatus;
    @FindAll({
            @FindBy(how = How.XPATH,using = "//androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.TextView[3]"),
            @FindBy(how = How.XPATH, using = "((//*[@text='Make and manage phone calls']/following::*[@resource-id='" + "com.myvodafoneapp:id/txtPermissionDescription']))[1]"),
            //     @FindBy(how = How.XPATH, using = "(//*[@label='Device location']") not inspected
    })
    public WebElement AS_DP_phoneDescription;
    @FindAll({
            @FindBy(how = How.XPATH,using = "//androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.LinearLayout/android.widget.Button"),
            @FindBy(how = How.XPATH, using = "((//*[@text='Make and manage phone calls']/following::*[@resource-id='" + "com.myvodafoneapp:id/btmPermissionCTA']))[1]"),
            //     @FindBy(how = How.XPATH, using = "(//*[@label='Device location']") not inspected
    })
    public WebElement AS_DP_phoneCTA;
    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Photos, media and files']"),
            //  @FindBy(how = How.XPATH, using = "//*[@label='Device location']")
    })
    public WebElement AS_DP_photoMediaTitle;
    @FindAll({
            @FindBy(how = How.XPATH,using = "//androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]/android.widget.TextView[2]"),
            @FindBy(how = How.XPATH, using = "((//*[@text='Photos, media and files']/following::*[@resource-id='" + "com.myvodafoneapp:id/txtPermissionStatus']))[1]"),
            // @FindBy(how = How.XPATH, using = "//*[@label='Device location']")
    })
    public WebElement AS_DP_photoMediaStatus;
    @FindAll({
            @FindBy(how = How.XPATH,using = "//androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.widget.TextView[3]"),
            @FindBy(how = How.XPATH, using = "((//*[@text='Photos, media and files']/following::*[@resource-id='" + "com.myvodafoneapp:id/txtPermissionDescription']))[1]"),
            //     @FindBy(how = How.XPATH, using = "(//*[@label='Device location']")
    })
    public WebElement AS_DP_photoMediaDescription;
    @FindAll({
            @FindBy(how = How.XPATH,using = "//androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.widget.LinearLayout/android.widget.Button"),
            @FindBy(how = How.XPATH, using = "((//*[@text='Photos, media and files']/following::*[@resource-id='" + "com.myvodafoneapp:id/btmPermissionCTA']))[1]"),
            //  @FindBy(how = How.XPATH, using = "//*[@label='Device location']")
    })
    public WebElement AS_DP_photoMediaCTA;
    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Network and App Usage access']"),
            //  @FindBy(how = How.XPATH, using = "//*[@label='Device location']")
    })
    public WebElement AS_DP_UsageTitle;
    @FindAll({
            @FindBy(how = How.XPATH,using = "//androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]/android.widget.TextView[2]"),
            @FindBy(how = How.XPATH, using = "((//*[@text='Network and App Usage access']/following::*[@resource-id='" + "com.myvodafoneapp:id/txtPermissionStatus']))[1]"),
            //  @FindBy(how = How.XPATH, using = "//*[@label='Device location']")
    })
    public WebElement AS_DP_UsageStatus;
    @FindAll({
            @FindBy(how = How.XPATH,using = "//androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]/android.widget.TextView[3]"),
            @FindBy(how = How.XPATH, using = "((//*[@text='Network and App Usage access']/following::*[@resource-id='" + "com.myvodafoneapp:id/txtPermissionDescription']))[1]"),
            //  @FindBy(how = How.XPATH, using = "//*[@label='Device location']")
    })
    public WebElement AS_DP_UsageDescription;
    @FindAll({
            @FindBy(how = How.XPATH,using = "//androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]/android.widget.LinearLayout/android.widget.Button"),
            @FindBy(how = How.XPATH, using = "((//*[@text='Network and App Usage access']/following::*[@resource-id='" + "com.myvodafoneapp:id/btmPermissionCTA']))[1]"),
            //  @FindBy(how = How.XPATH, using = "//*[@label='Device location']")
    })
    public WebElement AS_DP_UsageCTA;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/btmSetPinCTA"),
            @FindBy(how = How.ID, using = "setUpYourPinBtn")
    })
    public WebElement AS_LO_SetUpYourPinCTA;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/LoginOptionsView_PINManagementReset_CTA"),
            @FindBy(how = How.ID, using = "setUpYourPinBtn")
    })
    public WebElement AS_LO_ResetYourPINCTA;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/LoginOptionsView_EnableFingerprint_Label"),
            @FindBy(how = How.ID, using = "Disable Face ID?")
    })
    public WebElement AS_LO_FingerPrintCardTitle;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/LoginOptionsView_FingerprintToggle_Toggle"),
            @FindBy(how = How.ID, using = "Disable Face ID?")
    })
    public WebElement AS_LO_FingerPrintCardToggle;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/txtLoginOptionTitle"),
            @FindBy(how = How.ID, using = "txtLoginOptionTitle")
    })
    public WebElement AS_LO_title;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/rhombus_back_button"),
            //     @FindBy(how = How.ID, using = "txtLoginOptionTitle")
    })
    public WebElement Login_BackButton;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/btn_dialog_cancel"),
            //   @FindBy(how = How.ID, using = "txtLoginOptionTitle")
    })
    public WebElement CancelFingerPrintID;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/messageTextView"),
            @FindBy(how = How.ID, using = "txtLoginOptionTitle")
    })
    public WebElement InvalidPinErrorMessage;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/buttonsContainer"),
            @FindBy(how = How.ID, using = "txtLoginOptionTitle")
    })
    public WebElement InvalidPinOkCTA;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/backImageView"),
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/welcomeHeaderBackBtn"),
            @FindBy(how = How.ID, using = "backIcon")
    })
    public WebElement AS_BackButton;
    @FindAll({
            @FindBy(how = How.XPATH,using = "//*[@name='txtDrawerSettingsSubTitle_App settings']"),
            @FindBy(how = How.XPATH, using = "//*[@text='App settings']"),
            @FindBy(how = How.XPATH,using = "//*[@name='txtDrawerSettingsSubTitle_App']"),
            @FindBy(how = How.ID, using = "Settings"),
            @FindBy(how = How.XPATH, using = "//*[@label='App']"),
            @FindBy(how = How.XPATH, using = "//*[@label='App settings']"),
            @FindBy(how = How.XPATH, using = "//*[@text='App']"),
    })

    public WebElement DB_AppSetting;

    @FindBy(how = How.XPATH, using = "//*[@text='App']")

    public WebElement DB_AppICON;

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Settings']"),
            @FindBy(how = How.XPATH, using = "//*[@label='Settings']")

    })
    public WebElement DX_IDM_VOXISettingDrawer;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/dismissImageView"),
            @FindBy(how = How.ID, using = "closeIcon"),
            @FindBy(how = How.XPATH, using = "//XCUIElementTypeButton[@name='Reset']"),
            @FindBy(how = How.ID, using = "backIcon")
    })
    public WebElement AS_XIcon;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/settingsSectionTitle"),
            @FindBy(how = How.ID, using = "App Settings")
    })
    public WebElement AS_AppSettingsTiitle;


    public AppSettingsPO() {
        super();
    }


}

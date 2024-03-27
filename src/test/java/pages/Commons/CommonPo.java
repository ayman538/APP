package pages.Commons;

import core.Hooks;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import java.time.Duration;
import java.util.List;

public class CommonPo {
    public static AppiumDriver driver;

    public CommonPo() {
        driver = Hooks.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        /**
         * those 2 lines to be deleted once all find all locators finished
         */
        AppiumFieldDecorator appiumFieldDecorator = new AppiumFieldDecorator(driver, Duration.ofSeconds(3));
        PageFactory.initElements(appiumFieldDecorator, this);
    }

    @iOSXCUITFindBy(id = "DashboardLinksMenuCellLeftIcon_Check Data and Wi-Fi Speed")
    @iOSXCUITFindBy(xpath = "//*[@label='Check Data and Wi-Fi Speed']")
    @AndroidFindBy(xpath = "//*[@text='Check Data and Wi-Fi Speed']")
    public WebElement CheckDataAndWiFiSpeed;

    @iOSXCUITFindBy(xpath = "//*[@label='Network Status Checker']")
    @AndroidFindBy(xpath = "//*[@text='Network Status Checker']")
    public WebElement DB_NetworkStatusCheckerIcon;

    @AndroidFindBy(xpath = "//*[@text='Frequently Asked Questions']")
    @iOSXCUITFindBy(xpath = "//*[@label='Frequently Asked Questions']")
    public WebElement FrequentlyAskedQuestions;

    @AndroidFindBy(xpath = "//*[@text='Digital Parenting']")
    @iOSXCUITFindBy(xpath = "//*[@label='Digital Parenting']")
    public WebElement DigitalParenting;

    @AndroidFindBy(xpath = "//*[@text='Track An Order']")
    @iOSXCUITFindBy(xpath = "//*[@label='Track An Order']")
    public WebElement DB_TrackAnOrder;

    @AndroidFindBy(xpath = "//*[@text='Store Locator']")
    @iOSXCUITFindBy(xpath = "//*[@label='Store Locator']")
    public WebElement StoreLocator;

    @AndroidFindBy(xpath = "//*[@text='Shop']")
    @iOSXCUITFindBy(xpath = "//*[@label='Shop']")
    public WebElement DB_EshopTitle;

    @AndroidFindAll({
            @AndroidBy(id = "com.myvodafoneapp:id/iv_vodafone_icon"),
            @AndroidBy(id = "com.myvodafoneapp:id/vodafoneLogoImageView"),
            @AndroidBy(id = "com.myvodafoneapp:id/icon"),
    })
    @iOSXCUITFindAll({
            @iOSXCUITBy(id = "vodafoneLogo"),
            @iOSXCUITBy(id = "vodafone_logo_white"),
            @iOSXCUITBy(id = "DXIDMSubsOverlayXIcon"),
            @iOSXCUITBy(id = "imgVodafoneLogo"),
    })
    public WebElement DevSett_VodafoneLogoIcon;


    @AndroidFindAll({
            @AndroidBy(xpath = "//android.view.ViewGroup[@content-desc='NPspeedTestText']"),
            @AndroidBy(xpath = "//android.widget.TextView[@content-desc='NPspeedTestText']"),
            @AndroidBy(id = "NPspeedTestText")
    })

    @iOSXCUITFindBy(xpath = "//*[@name='NPspeedTestText']")
    protected WebElement speedChecker_SpeedTestTab;


    @AndroidFindBy(id = "com.myvodafoneapp:id/DXIDMSkipLogin_Button")
    @iOSXCUITFindAll({
            @iOSXCUITBy(id = "action_1"),
            @iOSXCUITBy(xpath = "//XCUIElementTypeButton[@name=\"action_1\"]"),
    })
    public WebElement RedHybrid_SkipLoginCTA;


    @AndroidFindBy(xpath = "//*[@text='Vodafone Secure Net']")
    @iOSXCUITFindBy(xpath = "//*[@label='Vodafone Secure Net']")
    public WebElement DB_VodafoneSecureNet;


    @AndroidFindBy(xpath = "//*[@text='End chat']")
    @iOSXCUITFindBy(xpath = "//*[@label='End chat']")
    public WebElement TOBi_EndChat;


    @AndroidFindAll({
            @AndroidBy(xpath = "//*[@text='Extras']"),
            @AndroidBy(xpath = "//android.widget.LinearLayout[@content-desc=\"Extras\"]/android.widget.TextView"),
    })
    @iOSXCUITFindBy(id = "Extras")
    public WebElement SO_ExtrasTab;


    @AndroidFindAll({
            @AndroidBy(id = "com.myvodafoneapp:id/btnCloseCTA"),
            @AndroidBy(id = "com.myvodafoneapp:id/PrimaryTutorialButton"),
    })
    @iOSXCUITFindAll({
            @iOSXCUITBy(id = "tutorialPrimaryButton"),
            @iOSXCUITBy(id = "btnCloseCTAtutorialPrimaryButton"),
            @iOSXCUITBy(id = "btnCloseCTA"),
            @iOSXCUITBy(id = "PrimaryTutorialButton"),
            @iOSXCUITBy(xpath = "//*[@name='Close']"),
    })
    public WebElement WF_TUT_closeCTA;


    @AndroidFindBy(id = "com.myvodafoneapp:id/addExtraTitle")
    @iOSXCUITFindBy(id = "addExtraTitle")
    public WebElement addExtrasOverlaySubtitle;


    @AndroidFindBy(xpath = "//*[@text='My Account']")
    @iOSXCUITFindBy(xpath = "//*[@label='My Account']")
    public WebElement DX_IDM_MyAccountTray;


    @AndroidFindBy(id = "com.myvodafoneapp:id/closePartialImageView")
    @iOSXCUITFindBy(xpath = "//*[@name='My closeIcon']")
    public WebElement DX_IDM_MyAccountDrawerXIcon;


    @AndroidFindBy(id = "com.myvodafoneapp:id/planRecyclerView")
    @iOSXCUITFindAll({
            @iOSXCUITBy(id = "wdgTabContent_Plan"),
            @iOSXCUITBy(id = "txtDashboardChargesCardHeader")
    })
    public static WebElement Plan_TabContent;


    @AndroidFindBy(id = "com.myvodafoneapp:id/Login_LoginView_UsernameField_Text")
    @iOSXCUITFindBy(id = "Enter username")
    protected static WebElement Login_username;


    @AndroidFindBy(id = "com.myvodafoneapp:id/DXIDLogin_Button")
    @iOSXCUITFindBy(id = "Log In")
    protected static WebElement Login_Button;


    @AndroidFindBy(id = "com.myvodafoneapp:id/Login_EnterPINView_Login_CTA")
    @iOSXCUITFindBy(id = "Login_SetupPINView_Continue_CTA")
    protected static WebElement Pin_ContinueCTA;


    @AndroidFindBy(xpath = "//*[@text='Login options']")
    @iOSXCUITFindBy(id = "My Account")
    protected static WebElement loginOptionsCTA;


    @AndroidFindAll({
            @AndroidBy(id = "com.android.chrome:id/close_button"),
            @AndroidBy(xpath = "//*[@resource-id='com.android.chrome:id/close_button']"),
            @AndroidBy(id = "com.sec.android.app.sbrowser:id/customtab_close"),
            @AndroidBy(id = "com.sec.android.app.sbrowser:id/customtab_close"),
    })
    @iOSXCUITFindBy(id = "Done")
    protected static WebElement DoneCtaInExternalbrowser;


    @iOSXCUITFindBy(xpath = "//*[@label='Enter desired phone number for the Top Up']")
    protected static WebElement topUpInternalWebviewTitle;


    @AndroidFindAll({
            @AndroidBy(id = "com.sec.android.app.sbrowser:id/location_bar_edit_text"),
            @AndroidBy(xpath = "//*[@text='Forgotten username']")
    })
    @iOSXCUITFindBy(xpath = "//*[@label='Forgotten username']")
    protected static WebElement DXIDM_ExternalBrowser;


    @AndroidFindBy(xpath = "//*[contains(@text,'received my security code')]")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'received my security code')]")
    protected static WebElement Ihaventreceivedmysecuritycode;


    @AndroidFindBy(xpath = "//*[contains(@text,'remember your password')]")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'remember your password')]")
    protected static WebElement forgottenPasswordWebview;


    @AndroidFindBy(id = "com.myvodafoneapp:id/tvTitle")
    @iOSXCUITFindAll({
            @iOSXCUITBy(id = "txtScreenTitleLabel"),
            @iOSXCUITBy(xpath = "(//XCUIElementTypeOther/following::*[@type='XCUIElementTypeStaticText'])[1]")
    })
    protected static WebElement WV_Title;


    @AndroidFindBy(xpath = "//*[@text='tab 2 of 2 Additional Plan']")
    @iOSXCUITFindBy(id = "tab 2 of 2 Additional Plan")
    protected static WebElement Additional_Plan;


    @AndroidFindAll({
            @AndroidBy(id = "com.myvodafoneapp:id/img_back"),
            @AndroidBy(id = "com.myvodafoneapp:id/btnBack")
    })
    @iOSXCUITFindBy(id = "icArrowLeft")
    protected static WebElement WV_TitleBackCTA;


    @AndroidFindBy(id = "com.myvodafoneapp:id/btnClose']")
    @iOSXCUITFindBy(id = "VFGwebCloseButton")
    protected static WebElement WV_Xicon;


    @AndroidFindBy(id = "com.myvodafoneapp:id/closeButton")
    @iOSXCUITFindBy(id = "btnVOVHideCTA")
    protected static WebElement DB_VOVhideCTA;


    @AndroidFindAll({
            @AndroidBy(id = "com.myvodafoneapp:id/backImageView"),
            @AndroidBy(id = "com.myvodafoneapp:id/rhombus_back_button"),
            @AndroidBy(id = "com.myvodafoneapp:id/welcomeHeaderBackBtn")
    })
    @iOSXCUITFindAll({
            @iOSXCUITBy(id = "backIcon"),
            @iOSXCUITBy(id = "back icon")
    })
    protected static WebElement GeneralBackIcon;


    @AndroidFindBy(id = "com.myvodafoneapp:id/vodafoneLogoImageView")
    @iOSXCUITFindBy(id = "imgVodafoneLogo")
    protected static WebElement DB_VFLogo;


    @AndroidFindBy(xpath = "//*[@text='Accept all cookies']")
    @iOSXCUITFindBy(xpath = "//*[@label='Accept all cookies']")
    protected static WebElement AcceptCookies;


    @AndroidFindBy(id = "trayView")
    @iOSXCUITFindBy(id = "trayView")
    protected static WebElement DB_Tray_view;


    @AndroidFindBy(xpath = "//*[@text='PIN']")
    @iOSXCUITFindBy(xpath = "//*[@label='PIN']")
    public WebElement DX_IDM_LogPrefPIN;


    @AndroidFindBy(xpath = "//*[@resource-id='com.myvodafoneapp:id/closeImg']")
    @iOSXCUITFindAll({
            @iOSXCUITBy(id = "closeIcon"),
            @iOSXCUITBy(xpath = "XCUIElementTypeApplication/XCUIElementTypeWindow[1]/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeWebView/XCUIElementTypeWebView/XCUIElementTypeWebView/XCUIElementTypeOther/XCUIElementTypeOther")
    })
    public WebElement DX_IDM_X_Button;


    @AndroidFindBy(xpath = "//*[@text='Forgotten username?']")
    @iOSXCUITFindBy(xpath = "//*[@label='Forgotten username?']")
    public WebElement DX_IDM_ForgotUsername;


    @AndroidFindBy(id = "com.myvodafoneapp:id/rhombus_title")
    @iOSXCUITFindBy(id = "Overlay_Title_Label")
    public WebElement DX_IDM_ThanksForVerify;


    @AndroidFindBy(id = "com.myvodafoneapp:id/btn_login")
    @iOSXCUITFindBy(xpath = "(//*[@name='Log in now'])[1]")
    public WebElement DX_IDM_BtnLoginCTAThanksForVerify;


    @AndroidFindBy(xpath = "(//*[@class='android.widget.Button'])[1]")
    @iOSXCUITFindAll({
            @iOSXCUITBy(id = "return to username screen button"),
            @iOSXCUITBy(xpath = "((//*[@name='Log in to My Vodafone'])[1]/following::*[@type='XCUIElementTypeButton'])[1]")
    })
    public WebElement DX_IDM_UsernameInPasswordScreen;


    @AndroidFindBy(xpath = "//*[@resource-id='pass']")
    @iOSXCUITFindBy(xpath = "//*[@type='XCUIElementTypeSecureTextField']")
    public WebElement DX_IDM_Password;


    @AndroidFindBy(xpath = "//*[@class='android.widget.EditText']")
    @iOSXCUITFindBy(xpath = "//*[@type='XCUIElementTypeTextField']")
    public WebElement DX_IDM_Username;


    @AndroidFindAll({
            @AndroidBy(xpath = "//*[@resource-id='submit-button']"),
            @AndroidBy(xpath = "//*[@text='Continue']")
    })
    @iOSXCUITFindBy(xpath = "//*[@name='Continue']")
    public WebElement DX_IDM_ContinueCTA;


    @AndroidFindBy(xpath = "*//android.widget.EditText[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"personDOB\"]/XCUIElementTypeTextField[1]")
    public WebElement DX_IDM_DOB_Day;


    @AndroidFindBy(xpath = "*//android.widget.EditText[2]")
    public WebElement DX_IDM_DOB_Month;


    @AndroidFindBy(xpath = "*//android.widget.EditText[3]")
    public WebElement DX_IDM_DOB_Year;


    @AndroidFindBy(xpath = "*//android.view.View/android.view.View/android.view.View/android.view.View[1]")
    @iOSXCUITFindBy(xpath = "*//XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeStaticText")
    public WebElement DX_IDM_InvalidPhoneNumberOrPassword_ErrorMSG;


    @AndroidFindBy(xpath = "*//android.view.View/android.widget.TextView[2]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Please enter the date in the format DD/MM/YYYY\"]")
    public WebElement DX_IDM_DOB_Instant_ErrorMSG;


    @AndroidFindBy(xpath = "*//android.view.View[1]/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.TextView[2]")
    @iOSXCUITFindBy(xpath = "*//XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeStaticText")
    public WebElement DX_IDM_PersonalDetails_ErrorMSG;


    @AndroidFindBy(xpath = "*//android.view.View[1]/android.view.View[2]/android.view.View/android.widget.EditText")
    @iOSXCUITFindAll({
            @iOSXCUITBy(id = "firstName"),
            @iOSXCUITBy(xpath = "//*/XCUIElementTypeTextField[@value='E.g. John']")
    })
    public WebElement DX_IDM_firstName;


    @AndroidFindBy(xpath = "*//android.view.View[2]/android.view.View[2]/android.view.View/android.widget.EditText")
    @iOSXCUITFindAll({
            @iOSXCUITBy(id = "lastName"),
            @iOSXCUITBy(xpath = "//*/XCUIElementTypeTextField[@value='E.g. Smith']")
    })
    public WebElement DX_IDM_lastName;


    @AndroidFindBy(xpath = "//*[@class='android.widget.EditText']")
    @iOSXCUITFindAll({
            @iOSXCUITBy(xpath = "//*[@type='XCUIElementTypeTextField'][3]"),
            @iOSXCUITBy(xpath = "//*[@label='Type here to talk to TOBi'][2]")
    })
    public WebElement TobiChatBox;


    @AndroidFindBy(id = "Type here to talk to TOBi")
    @iOSXCUITFindBy(id = "Type here to talk to TOBi")
    public WebElement TobiChatBoxAfterClickIOS;


    @AndroidFindBy(xpath = "//*[contains(@text,'Just tell me in a few words what you need help with')]")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'Just tell me in a few words what you need help with')]")
    public WebElement TobiMessageResponse;


    @AndroidFindBy(xpath = "//*[@text='Log in']")
    @iOSXCUITFindBy(xpath = "//*[@label='Log in']")
    public WebElement DX_IDM_PasswordLoginCTA;


    @AndroidFindBy(xpath = "//*[@resource-id='com.myvodafoneapp:id/btnConfirm']")
    @iOSXCUITFindBy(xpath = "//*[@name='OK, all done']")
    public WebElement DX_IDM_LoginPreferencesOkCTA;


    @AndroidFindAll({
            @AndroidBy(xpath = "//*[@text='Privacy']"),
            @AndroidBy(xpath = "//*[@text='Privacy settings']")
    })
    @iOSXCUITFindAll({
            @iOSXCUITBy(xpath = "//*[@label='Privacy']"),
            @iOSXCUITBy(xpath = "//*[@label='Privacy settings']")
    })
    public WebElement DB_PrivacySetting;


    @AndroidFindBy(xpath = "//*[@text='Account']")
    @iOSXCUITFindBy(xpath = "//*[@label='Account']")
    public WebElement DB_Account;


    @AndroidFindBy(id = "closePartialImageView")
    @iOSXCUITFindAll({
            @iOSXCUITBy(id = "bottomSheetDismissButtonIdentifier"),
            @iOSXCUITBy(id = "closeIcon")
    })
    public WebElement MyAccountXIcon;


    @AndroidFindBy(id = "com.myvodafoneapp:id/ForgetUserName_pin_Next_CTA")
    @iOSXCUITFindBy(id = "Login_SetupPINView_Continue_CTA")
    public WebElement Pin_NextCTA;


    @AndroidFindBy(id = "com.myvodafoneapp:id/txtExistingCustomerLink")
    @iOSXCUITFindBy(id = "txtExistingCustomerLink_1")
    public WebElement Acquisition_Link;


    @AndroidFindBy(id = "com.myvodafoneapp:id/btnNewCustomerCTA")
    @iOSXCUITFindBy(id = "btnNewCustomerCTA_0")
    public WebElement Acquisition_CTA;


    @AndroidFindBy(id = "com.myvodafoneapp:id/txtAppSettingsTitle")
    @iOSXCUITFindBy(id = "txtScreenTitle")
    public WebElement AS_ScreenTitle;


    @AndroidFindBy(id = "com.myvodafoneapp:id/dismissImageView")
    @iOSXCUITFindBy(id = "closeIcon")
    public WebElement SO_Xicon;


    @AndroidFindBy(xpath = "//*[@text='Pay monthly phones']")
    @iOSXCUITFindBy(id = "txtAcquisitionNewDBTile_Pay monthly phones")
    public WebElement Acquisition_NewDB_PAYM_Title;


    @AndroidFindBy(id = "com.myvodafoneapp:id/closeIcon")
    @iOSXCUITFindBy(id = "closeIcon")
    public WebElement Acquisition_NewDB_Xicon;


    @AndroidFindBy(xpath = "//*[@text='Top up']")
    @iOSXCUITFindBy(xpath = "//*[@label='Top up']")
    public WebElement SO_TopUpTab;


    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc='Usage']/android.widget.TextView")
    @iOSXCUITFindBy(id = "Usage")
    public WebElement SO_UsageTab;


    @AndroidFindBy(xpath = "//*[@text='Settings']")
    @iOSXCUITFindAll({
            @iOSXCUITBy(xpath = "//*[@label='Settings']"),
            @iOSXCUITBy(id = "Settings")

    })
    public WebElement DB_SettingDashboardTray_icon;


    @AndroidFindBy(xpath = "//*[@text='arrow_back']")
    @iOSXCUITFindBy(xpath = "//*[@name='arrow_back']")
    public WebElement DB_BatteryRefreshXIcon;


    @AndroidFindBy(xpath = "//*[@text='Battery Refresh Tool']")
    @iOSXCUITFindBy(xpath = "//*[@label='Battery Refresh Tool']")
    public WebElement DB_BatteryRefresh;


    @AndroidFindAll({
            @AndroidBy(xpath = "//*[@text='My Vodafone']"),
            @AndroidBy(id = "com.myvodafoneapp:id/action_bar_root")
    })
    @iOSXCUITFindBy(id = "Navigate back")
    public WebElement DB_Lassie;


    @AndroidFindAll({
            @AndroidBy(xpath = "//*[@text='Account']"),
            @AndroidBy(xpath = "//*[@text='Account settings']"),
    })
    @iOSXCUITFindAll({
            @iOSXCUITBy(xpath = "//*[@label='Account settings']"),
            @iOSXCUITBy(id = "txtDrawerSettingsSubTitle_Account"),
    })
    public WebElement DB_AccountSetting;


    @AndroidFindBy(xpath = "//*[@text='App Settings']")
    @iOSXCUITFindBy(id = "VeryMe")
    public WebElement appSettingsTray;


    @AndroidFindBy(xpath = "//*[@text='My Account']")
    @iOSXCUITFindBy(xpath = "//*[@name='My Account']")
    public WebElement DB_MyAccountTray_icon;


    @AndroidFindAll({
            @AndroidBy(xpath = "//*[@text='My Account']"),
            @AndroidBy(xpath = "//*[@text='My account']"),
    })
    public WebElement MyAccountTray_icon_Android;

    @iOSXCUITFindAll({
            @iOSXCUITBy(xpath = "//*[@text='My Account']"),
            @iOSXCUITBy(xpath = "//*[@text='My account']"),
    })
    public WebElement MyAccountTray_icon_IOS;


    @AndroidFindAll({
            @AndroidBy(xpath = "//*[@text='Free Business Support']"),
            @AndroidBy(xpath = "//*[@text='My account']"),
    })
    @iOSXCUITFindAll({
            @iOSXCUITBy(xpath = "//*[@label='Free Business Support']"),
            @iOSXCUITBy(xpath = "//*[@name='DashboardLinksMenuCellLeftIcon_Free Business Support']"),
            @iOSXCUITBy(id = "DashboardLinksMenuCellLeftIcon_Free Business Support")
    })
    public WebElement DB_FreeBusinessSupportCTA;


    @AndroidFindBy(id = "com.android.chrome:id/close_button")
    @iOSXCUITFindBy(id = "close_button")
    public WebElement DB_FreeBusinessSupportXCTA;


    @AndroidFindBy(id = "com.android.chrome:id/url_bar_text")
    @iOSXCUITFindBy(id = "TopBrowserBar")
    public WebElement CustomeTabBar;


    @AndroidFindAll({
            @AndroidBy(id = "com.myvodafoneapp:id/headerTextView"),
            @AndroidBy(id = "com.myvodafoneapp:id/partialHeaderTextView")
    })
    @iOSXCUITFindBy(id = "txtDashboardAllowencesTitle")
    public WebElement DB_AllowanceTileHeader;


    @AndroidFindBy(id = "com.myvodafoneapp:id/totalAmountTextView")
    @iOSXCUITFindBy(id = "txtDashboardAllowencesCurrentConsumption")
    public WebElement DB_AllowanceTileTotalAmount;


    @AndroidFindBy(id = "com.myvodafoneapp:id/unitTextView")
    @iOSXCUITFindBy(xpath = "(//*[@name='txtDashboardAllowencesCurrentConsumption']/following::*[@type='XCUIElementTypeStaticText'])[1]")
    public WebElement DB_AllowanceTileUnit;


    @AndroidFindBy(id = "com.myvodafoneapp:id/seekBar")
    @iOSXCUITFindBy(id = "imgDashboardAllowencesConsumptionBar")
    public WebElement DB_AllowanceTileProgressBar;


    @AndroidFindBy(xpath = "((//*[@resource-id='\" + \"com.myvodafoneapp:id/txtPlanListItemTitle']))[1]")
    @iOSXCUITFindBy(id = "txtDashboardAllowencesRemaining")
    public WebElement DB_AllowanceTileConsumedAmount;


    @AndroidFindBy(id = "com.myvodafoneapp:id/contentView")
    @iOSXCUITFindBy(id = "wdgDashboardAllowences")
    public WebElement DB_AllowanceTileView;


    @AndroidFindBy(id = "com.myvodafoneapp:id/btn_continue")
    @iOSXCUITFindBy(xpath = "//*[@type='XCUIElementTypeButton' and @label='Continue']")
    public WebElement DX_IDM_WelcomeContinueCTA;


    @AndroidFindBy(id = "com.myvodafoneapp:id/tv_terms_message")
    @iOSXCUITFindBy(xpath = "//*[@label='Please agree to the Terms and \u2028Conditions before continuing']")
    public WebElement DX_IDM_PrivacyAndTermsToggleMessage;


    @AndroidFindBy(id = "com.myvodafoneapp:id/toggle_terms")
    @iOSXCUITFindAll({
            @iOSXCUITBy(xpath = "//XCUIElementTypeScrollView[@name=\"scrollView\"]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeImage"),
            @iOSXCUITBy(xpath = "//XCUIElementTypeScrollView[@name=\"scrollView\"]/XCUIElementTypeOther[2]/XCUIElementTypeOther"),
            @iOSXCUITBy(xpath = "//*[@type='XCUIElementTypeSwitch']"),
            @iOSXCUITBy(xpath = "(//*[@type='XCUIElementTypeOther'])[20]"),
    })
    public WebElement DX_IDM_PrivacyAndTermsToggle;


    @AndroidFindBy(id = "com.myvodafoneapp:id/btn_continue")
    @iOSXCUITFindBy(xpath = "//*[@type='XCUIElementTypeButton' and @label='Continue']")
    public WebElement DX_IDM_PrivacyScreenContinueCTA;


    @AndroidFindBy(id = "com.myvodafoneapp:id/btn_continue")
    @iOSXCUITFindBy(xpath = "//*[@type='XCUIElementTypeButton' and @label='Continue']")
    public WebElement DX_IDM_PermissionScreenContinueCTA;


    @AndroidFindBy(xpath = "//*[@text='NO THANKS']")
    @iOSXCUITFindBy(xpath = "//*[@label='NO THANKS']")
    public WebElement DX_IDM_NoThanksPermission;


    @AndroidFindBy(id = "com.myvodafoneapp:id/DXIDMSkipLogin_Button")
    @iOSXCUITFindAll({
            @iOSXCUITBy(id = "action_1"),
            @iOSXCUITBy(xpath = "//*[@label='Skip Login']")
    })
    public WebElement DX_IDM_SkipLoginCTA;


    @AndroidFindBy(id = "com.myvodafoneapp:id/subscriptionType")
    @iOSXCUITFindBy(id = "txtSubscriptionAccountType")
    public WebElement DB_SubscriptionIconText;


    @AndroidFindBy(id = "com.myvodafoneapp:id/subscriptionMisdn")
    @iOSXCUITFindBy(id = "txtSubscriptionAccountType")
    public WebElement DB_SubscriptionMSISDNText;


    @AndroidFindAll({
            @AndroidBy(xpath = "//*[@resource-id='tcChat_btnCloseChat_img']"),
            @AndroidBy(xpath = "//*[@text='Close Tobi chat']")
    })
    @iOSXCUITFindAll({
            @iOSXCUITBy(xpath = "(//XCUIElementTypeButton[@name='Close chat'])"),
            @iOSXCUITBy(xpath = "//*[@label='Close Tobi chat']"),
            @iOSXCUITBy(xpath = "//*[@name='Send message']")
    })
    public WebElement TobiXIcon;


    @AndroidFindBy(xpath = "//*[@text='TOBi Chat']")
    @iOSXCUITFindAll({
            @iOSXCUITBy(id = "TOBi Chat"),
            @iOSXCUITBy(xpath = "//*[@label='TOBi Chat']")
    })
    public WebElement TobiChatTitle;


    @iOSXCUITFindBy(xpath = "//*[@name='TOBi Chat']")
    public WebElement TobiChatHeader;


    @AndroidFindBy(xpath = "//*[@text='Send message']")
    @iOSXCUITFindBy(xpath = "//*[@label='Send message']")
    public WebElement TobiSendButton;


    @AndroidFindAll({
            @AndroidBy(xpath = "//*[@text='Yes']"),
            @AndroidBy(xpath = "//*[@text='Yes, end chat']")
    })
    @iOSXCUITFindAll({
            @iOSXCUITBy(xpath = "//*[@label='Yes']"),
            @iOSXCUITBy(xpath = "//*[@label='Yes, end chat']")
    })
    public WebElement Confirm_TobiXIcon;


    @AndroidFindBy(xpath = "//*[@text='Payments']")
    @iOSXCUITFindBy(xpath = "//*[@label='Payments']")
    public WebElement DB_PaymentIcon;


    @AndroidFindBy(id = "com.myvodafoneapp:id/headerTextView")
    @iOSXCUITFindBy(id = "wdgUsageProductSection")
    public WebElement SO_UsageTabRHExpiryOrRenewalDate;


    @AndroidFindBy(id = "com.myvodafoneapp:id/btnActionCTA")
    @iOSXCUITFindAll({
            @iOSXCUITBy(id = "action_0"),
            @iOSXCUITBy(id = "Add a new card"),
            @iOSXCUITBy(id = "traySuccessAction"),
    })
    public WebElement RedHybrid_PaymentAddCTA;


    @AndroidFindBy(id = "com.myvodafoneapp:id/imgPrivacyToggleView")
    @iOSXCUITFindAll({
            @iOSXCUITBy(id = "imgPrivacyToggleView"),
            @iOSXCUITBy(xpath = "//XCUIElementTypeScrollView//XCUIElementTypeSwitch[1]"),
            @iOSXCUITBy(xpath = "(//*[@name='scrollView']/XCUIElementTypeOther[1])[2]"),
    })
    public WebElement RedHybrid_PaymentConfirmationToggle1;


    @AndroidFindBy(id = "com.myvodafoneapp:id/imgTermsToggleView")
    @iOSXCUITFindAll({
            @iOSXCUITBy(id = "imgPrivacyToggleView"),
            @iOSXCUITBy(xpath = "//XCUIElementTypeScrollView//XCUIElementTypeSwitch[2]"),
            @iOSXCUITBy(xpath = "(//*[@name='scrollView']/XCUIElementTypeOther[2])[2]"),
    })
    public WebElement RedHybrid_PaymentConfirmationToggle2;


    @AndroidFindAll({
            @AndroidBy(id = "com.myvodafoneapp:id/btnActionCTA"),
            @AndroidBy(xpath = "//*[@text='Continue']")
    })
    @iOSXCUITFindBy(xpath = "//*[@text='Continue']")
    public WebElement RedHybrid_ContinuePaymentCTA;


    @AndroidFindBy(id = "com.myvodafoneapp:id/BillingAddressHeader")
    @iOSXCUITFindBy(id = "Billing address")
    public WebElement RedHybrid_BillingAddressHeader;


    @AndroidFindBy(xpath = "//*[@class='android.widget.Button' and @resource-id='btnSubmit']")
    @iOSXCUITFindBy(id = "Continue")
    public WebElement RedHybrid_CardPayNowCTA;


    @AndroidFindBy(xpath = "//*[@class='android.widget.Button' and @resource-id='btnCancel']")
    @iOSXCUITFindBy(id = "Cancel")
    public WebElement RedHybrid_CancelPaymentCTA;


    @AndroidFindBy(id = "com.myvodafoneapp:id/imgRedHybridCloseView")
    @iOSXCUITFindBy(id = "imgRedHybridCloseView")
    public WebElement RedHybrid_PaymentXIcon;


    @AndroidFindBy(id = "com.myvodafoneapp:id/imgProcessingRedHybrid")
    @iOSXCUITFindBy(id = "imgProcessingRedHybrid")
    public WebElement RedHybrid_ProcessingIcon;


    @AndroidFindAll({
            @AndroidBy(id = "com.myvodafoneapp:id/imgRedHybridTickIcon"),
            @AndroidBy(id = "com.myvodafoneapp:id/imgSuccessRedHybridTik")
    })
    @iOSXCUITFindAll({
            @iOSXCUITBy(id = "imgRedHybridTickIcon"),
            @iOSXCUITBy(id = "imgSuccessRedHybridTik"),
            @iOSXCUITBy(id = "traySuccessIcon")
    })
    public WebElement RedHybrid_SuccessTik;


    @AndroidFindBy(id = "com.myvodafoneapp:id/btnContinueSuccessCTA")
    @iOSXCUITFindAll({
            @iOSXCUITBy(id = "btnContinueSuccessCTA"),
            @iOSXCUITBy(xpath = "//*[@label='Continue']")
    })
    public WebElement RedHybrid_SuccessCTA;


    @AndroidFindBy(xpath = "//*[@class='android.widget.EditText' and @resource-id='cardholderName']")
    @iOSXCUITFindBy(xpath = "//*[@value='Enter your Name']")
    public WebElement RedHybrid_CardNameField;


    @AndroidFindBy(xpath = "//*[@class='android.widget.EditText' and @resource-id='cardNumber']")
    @iOSXCUITFindBy(xpath = "//*[@value='Enter your Card Number']")
    public WebElement RedHybrid_CardNumberField;


    @AndroidFindBy(xpath = "//*[@class='android.widget.EditText' and @resource-id='csc']")
    @iOSXCUITFindAll({
            @iOSXCUITBy(xpath = "//XCUIElementTypeTextField[@value='CCV']"),
            @iOSXCUITBy(xpath = "(//*[@name='Complete your order - Barclaycard Checkout']/XCUIElementTypeOther/XCUIElementTypeTextField)[3]")
    })
    public WebElement RedHybrid_CardSecurityCodeField;


    @AndroidFindBy(id = "com.myvodafoneapp:id/txtUKPostcode")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField")
    public WebElement RedHybrid_UKPostcodeText;


    @AndroidFindBy(id = "com.myvodafoneapp:id/searchAddressCTA")
    @iOSXCUITFindBy(xpath = "//*[@label='Search address']")
    public WebElement RedHybrid_searchAddressCTA;


    @AndroidFindBy(id = "com.myvodafoneapp:id/currentCard")
    @iOSXCUITFindBy(id = "currentCard")
    public WebElement RedHybrid_currentCard;


    @AndroidFindBy(id = "com.myvodafoneapp:id/txtEditPaymentCardLabel")
    @iOSXCUITFindBy(id = "txtEditPaymentCardLabel")
    public WebElement RedHybrid_editCancelCTAtxt;


    @AndroidFindBy(id = "com.myvodafoneapp:id/replaceCardCTA")
    @iOSXCUITFindBy(id = "Replace my card")
    public WebElement RedHybrid_replaceCardCTA;


    @AndroidFindBy(id = "com.myvodafoneapp:id/btnActionCTA")
    @iOSXCUITFindBy(id = "btnActionCTA")
    public WebElement RedHybrid_replaceCardCTAtxt;


    @AndroidFindBy(id = "com.myvodafoneapp:id/editCancelCTA")
    @iOSXCUITFindAll({
            @iOSXCUITBy(id = "Edit"),
            @iOSXCUITBy(id = "Cancel")
    })
    public WebElement RedHybrid_editCancelCTA;


    @AndroidFindBy(xpath = "(//*[@class='android.widget.CheckedTextView'][2])")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypePicker//XCUIElementTypePickerWheel")
    public WebElement RedHybrid_selectAddressDropdownFirstElement;


    @AndroidFindBy(xpath = "//*[@text='Billing']")
    @iOSXCUITFindAll({
            @iOSXCUITBy(id = "ic_billing"),
            @iOSXCUITBy(id = "Billing")
    })
    public WebElement DB_BillingTray_icon;


    @AndroidFindAll({
            @AndroidBy(xpath = "//*[@text='Direct debit']"),
            @AndroidBy(id = "com.myvodafoneapp:id/btnActionCTA")
    })
    @iOSXCUITFindAll({
            @iOSXCUITBy(id = "action_0"),
            @iOSXCUITBy(xpath = "//*[@label='Direct debit']")
    })
    public WebElement Bill_DirectDebitCTA;


    @AndroidFindBy(id = "com.myvodafoneapp:id/dismissImageView")
    @iOSXCUITFindAll({
            @iOSXCUITBy(id = "dismiss icon"),
            @iOSXCUITBy(id = "closeIcon")
    })
    public WebElement Bill_Xicon;


    @AndroidFindBy(id = "com.myvodafoneapp:id/btnMyBillsViewAllCTA")
    @iOSXCUITFindBy(id = "View all")
    public WebElement Bill_viewAllCTA;


    @AndroidFindBy(xpath = "(//*[@resource-id='com.myvodafoneapp:id/wdgMyBillCard'])[1]")
    @iOSXCUITFindBy(xpath = "//*/XCUIElementTypeCell[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther")
    public WebElement Bill_latestBill;


    @AndroidFindBy(id = "com.myvodafoneapp:id/btnViewPreviousCharges")
    @iOSXCUITFindBy(id = "View details")
    public WebElement chargesViewDetails;


    @AndroidFindAll({
            @AndroidBy(id = "com.myvodafoneapp:id/btnViewPreviousCharges"),
            @AndroidBy(id = "com.myvodafoneapp:id/btnTopUpCTA"),
            @AndroidBy(id = "com.myvodafoneapp:id/btnPayAsYouGoExtrasCTA"),
    })
    @iOSXCUITFindBy(xpath = "//*[@label='Manage Controls and Extras']")
    public WebElement Extras_BuyManageExtrasCTA;


    @AndroidFindBy(xpath = "//*[@text='Spend Manager']")
    @iOSXCUITFindBy(xpath = "//*[@label='Spend Manager']")
    public WebElement AS_SpendManager;


    @AndroidFindBy(xpath = "(//*[@resource-id='\" + \"com.myvodafoneapp:id/controlText'])[2]")
    @iOSXCUITFindAll({
            @iOSXCUITBy(xpath = "(//XCUIElementTypeStaticText[@name=\"txtDashboardControlTileCardTitle\"])[2]"),
            @iOSXCUITBy(xpath = "//XCUIElementTypeCell[@name=\"wdgControlTile_2\"]/XCUIElementTypeOther")
    })
    public WebElement DB_ControlTileSecondryCard;


    @AndroidFindAll({
            @AndroidBy(xpath = "(//android.widget.TextView[@resource-id='com.myvodafoneapp:id/controlText'])[1]"),
            @AndroidBy(id = "com.myvodafoneapp:id/controlText"),
            @AndroidBy(id = "com.myvodafoneapp:id/txtPlanListItemTitle"),
            @AndroidBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.view.ViewGroup)")
    })
    @iOSXCUITFindAll({
            @iOSXCUITBy(xpath = "//*[@label='Your Plan']"),
            @iOSXCUITBy(xpath = "(//XCUIElementTypeStaticText[@name=\"txtPlanListItemTitle\"])[1]")
    })
    public WebElement SO_PlanTab;


    @AndroidFindBy(id = "com.myvodafoneapp:id/txtPlanTitle")
    @iOSXCUITFindBy(id = "planCardTitle_0")
    public WebElement PlanTitle;


    @AndroidFindBy(id = "com.myvodafoneapp:id/btn_continue")
    @iOSXCUITFindBy(id = "ContinueCTA")
    public WebElement newPlanTermAndCondContinueBtn;


    @AndroidFindAll({
            @AndroidBy(xpath = "//*[@text='Airtime Plan']"),
            @AndroidBy(xpath = "//*[@text='Your Plan']")
    })
    @iOSXCUITFindAll({
            @iOSXCUITBy(xpath = "//*[@label='Your Plan']"),
            @iOSXCUITBy(xpath = "//*[@name='txtDashboardControlTileCardTitle']"),
            @iOSXCUITBy(xpath = "//*[@label='Airtime Plan']"),
            @iOSXCUITBy(id = "Dashboard_CurrentSpends_Section")
    })
    public WebElement DB_ControlTile;


    @AndroidFindAll({
            @AndroidBy(xpath = "//*[@text='Charges']"),
            @AndroidBy(id = "com.myvodafoneapp:id/currentChargesContainer"),
            @AndroidBy(id = "com.myvodafoneapp:id/cardHeaderTextView"),
    })
    @iOSXCUITFindAll({
            @iOSXCUITBy(id = "txtDashboardChargesCardHeader"),
            @iOSXCUITBy(xpath = "//XCUIElementTypeStaticText[@name=\"txtDashboardChargesCardHeader\"]"),
            @iOSXCUITBy(id = "cardHeaderTextView")
    })
    public WebElement DB_billingTileHeader;


    @AndroidFindAll({
            @AndroidBy(xpath = "(//*[@resource-id='com.myvodafoneapp:id/footerTextView'])[2]"),
            @AndroidBy(xpath = "(//*[@resource-id='com.myvodafoneapp:id/footerTextView'])[1]"),
    })
    @iOSXCUITFindBy(xpath = "//*[@name='txtDashboardCurrentSpendsAdditionalLabel']")
        public WebElement DB_creditTileFooter;


    @AndroidFindBy(id = "com.myvodafoneapp:id/cardHeaderTextView")
    @iOSXCUITFindBy(id = "txtDashboardChargesCardHeader")
    public WebElement DBControlTile;


    @AndroidFindBy(xpath = "//*[@text='App privacy']")
    @iOSXCUITFindBy(xpath = "//*[@label='App privacy']")
    public WebElement PS_AppPrivacyOption;


    @AndroidFindBy(xpath = "//*[@text='Network optimisation']")
    @iOSXCUITFindBy(xpath = "//*[@label='Network optimisation']")
    public WebElement PS_NetworkOptimisationTitle;


    @AndroidFindAll({
            @AndroidBy(id = "(//*[@resource-id='com.myvodafoneapp:id/vf_clickcell_toggle"),
            @AndroidBy(xpath = "(//*[@resource-id='com.myvodafoneapp:id/footerTextView'])[1]"),
    })
    @iOSXCUITFindBy(xpath = "(//*[@type='XCUIElementTypeSwitch'])[2]")
    public WebElement PS_AppPrivacyNetworkOptimisationToggle;


    @AndroidFindBy(xpath = "//*[@text='Turn off']")
    @iOSXCUITFindBy(xpath = "//*[@label='Turn off']")
    public WebElement PS_AppPrivacyNetworkOptimisationConfirmOFFBtn;


    @AndroidFindBy(id = "com.myvodafoneapp:id/ed_first_name")
    @iOSXCUITFindBy(id = "First name")
    public WebElement First_name;


    @AndroidFindBy(id = "com.myvodafoneapp:id/Login_EnterPINView_BOX1_TextField")
    @iOSXCUITFindBy(id = "PIN_BOX1_TextField")
    public WebElement Pin_Field;


    @AndroidFindAll({
            @AndroidBy(id = "com.myvodafoneapp:id/Login_EnterPINView_BOX1_TextField"),
            @AndroidBy(xpath = "(*//android.widget.EditText)[1]")
    })
    @iOSXCUITFindBy(id = "PIN_BOX1_TextField")
    public WebElement Pin_Field1;


    @AndroidFindAll({
            @AndroidBy(id = "com.myvodafoneapp:id/Login_EnterPINView_BOX2_TextField"),
            @AndroidBy(xpath = "(*//android.widget.EditText)[2]")
    })
    @iOSXCUITFindBy(id = "PIN_BOX2_TextField")
    public WebElement Pin_Field2;


    @AndroidFindAll({
            @AndroidBy(id = "com.myvodafoneapp:id/Login_EnterPINView_BOX3_TextField"),
            @AndroidBy(xpath = "(*//android.widget.EditText)[3]")
    })
    @iOSXCUITFindBy(id = "PIN_BOX3_TextField")
    public WebElement Pin_Field3;


    @AndroidFindAll({
            @AndroidBy(id = "com.myvodafoneapp:id/Login_EnterPINView_BOX4_TextField"),
            @AndroidBy(xpath = "(*//android.widget.EditText)[4]")
    })
    @iOSXCUITFindBy(id = "PIN_BOX4_TextField")
    public WebElement Pin_Field4;


    @AndroidFindAll({
            @AndroidBy(xpath = "//*[@text='App']"),
            @AndroidBy(xpath = "//*[@text='App settings']"),
    })
    @iOSXCUITFindAll({
            @iOSXCUITBy(xpath = "//*[@label='App settings']"),
            @iOSXCUITBy(id = "txtDrawerSettingsSubTitle_App")
    })
    public WebElement DB_AppSetting;


    @AndroidFindAll({
            @AndroidBy(id = "com.myvodafoneapp:id/settingsCloseImg"),
            @AndroidBy(id = "com.myvodafoneapp:id/closePartialImageView"),
    })
    @iOSXCUITFindAll({
            @iOSXCUITBy(xpath = "//*[@name='closeIcon']"),
            @iOSXCUITBy(id = "bottomSheetDismissButtonIdentifier")
    })
    public WebElement DB_SettingsDrawerCloseButton;


    @AndroidFindBy(id = "com.myvodafoneapp:id/btn_dialog_cancel")
    public WebElement CancelFingerPrintCTA;


    @AndroidFindBy(xpath = "//*[@text='Rewards']")
    @iOSXCUITFindBy(id = "Rewards")
    public WebElement DB_RewardsDrawer_icon;


    @AndroidFindAll({
            @AndroidBy(id = "com.myvodafoneapp:id/manageExtrasCard"),
            @AndroidBy(id = "com.myvodafoneapp:id/extrasRecyclerView"),
            @AndroidBy(xpath = "//*[@resource-id='com.myvodafoneapp:id/txtMyExtraTitle']"),
            @AndroidBy(xpath = "//*[@text='Extras']")
    })
    @iOSXCUITFindBy(id = "wdgTabContent_Extras")
    public WebElement Extras_TabContainer;


    @AndroidFindAll({
            @AndroidBy(id = "com.myvodafoneapp:id/rhombus_close_button"),
            @AndroidBy(id = "com.myvodafoneapp:id/closeImg"),
    })
    @iOSXCUITFindAll({
            @iOSXCUITBy(id = "closeIcon"),
            @iOSXCUITBy(id = "dismiss icon")
    })
    public WebElement Login_Xicon;


    @AndroidFindBy(xpath = "//*[@text='Top Up']")
    @iOSXCUITFindAll({
            @iOSXCUITBy(xpath = "//*[@label='Top Up']"),
            @iOSXCUITBy(id = "Top Up")
    })
    public WebElement DB_TopUpTray_icon;


    @AndroidFindBy(xpath = "//*[@text='Reset the app']")
    @iOSXCUITFindBy(xpath = "//*[@label='Reset the app']")
    public WebElement AS_ResetAPP;


    @AndroidFindBy(id = "com.myvodafoneapp:id/btmResetAppCTA")
    @iOSXCUITFindBy(id = "resetBtn")
    public WebElement ResetApp_CTA;


    @AndroidFindBy(id = "com.myvodafoneapp:id/button1")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Reset']")
    public WebElement Reset_CTA;


    @AndroidFindBy(xpath = "//*[@text='Forgotten password?']")
    @iOSXCUITFindBy(xpath = "//*[@label='Forgotten password?']")
    public WebElement DX_IDM_ForgotPassword;


    @AndroidFindBy(id = "com.myvodafoneapp:id/DXIDLogin_Button")
    @iOSXCUITFindAll({
            @iOSXCUITBy(id = "DXIDMSubsOverlay_Button_0"),
            @iOSXCUITBy(id = "action_0")
    })
    public WebElement DX_IDM_LoginCTA;


    @AndroidFindBy(xpath = "//*[@text='Register for My Vodafone']")
    @iOSXCUITFindAll({
            @iOSXCUITBy(id = "Register for My Vodafone"),
            @iOSXCUITBy(xpath = "//*[@label='Register for My Vodafone']")
    })
    public WebElement registerForMyVodafone;


    @AndroidFindBy(id = "com.myvodafoneapp:id/vftobi_button")
    @iOSXCUITFindBy(xpath = "//*[@name='wdgDashboardTrayContainer']/XCUIElementTypeOther[1]")
    public WebElement TobiButton;


    @AndroidFindBy(id = "shopExtrasCard")
    @iOSXCUITFindBy(id = "shopExtrasCard")
    public WebElement shopExtrasCard;


    @AndroidFindBy(id = "com.myvodafoneapp:id/cardsRecyclerView")
    @iOSXCUITFindBy(id = "wdgTabContent_Usage")
    public WebElement SO_UsageTabContainer;


    @AndroidFindBy(id = "com.myvodafoneapp:id/ed_last_name")
    @iOSXCUITFindBy(id = "Last name")
    public WebElement Last_name;


    @AndroidFindBy(id = "com.myvodafoneapp:id/ForgetUserName_Next_CTA")
    @iOSXCUITFindBy(id = "Login_LoginView_Login_CTA")
    public WebElement NextCTA;


    @AndroidFindBy(xpath = "//*[@text='Assistance']")
    @iOSXCUITFindAll({
            @iOSXCUITBy(id = "txtDashboardLinksMenuSectionTitle_Assistance"),
            @iOSXCUITBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.TextView[1]")
    })
    public WebElement DB_AssistanceTitle;


    @AndroidFindBy(xpath = "//*[@text='Your Network']")
    @iOSXCUITFindBy(id = "txtDashboardLinksMenuSectionTitle_Your Network")
    public WebElement DB_NetworkTitle;


    @AndroidFindBy(xpath = "//*[@text='My Account']")
    @iOSXCUITFindBy(id = "My Account")
    public WebElement RedHybrid_MyAccount;


    @AndroidFindBy(id = "com.myvodafoneapp:id/txtAddPlanNoActivePlanTitle")
    @iOSXCUITFindBy(id = "Tap here to add Plus plan")
    public static WebElement redHybrid_AddPlan;


    @AndroidFindBy(id = "com.myvodafoneapp:id/txtRedHybridTitle")
    @iOSXCUITFindBy(id = "bottomSheetTitleIdentifier")
    public static WebElement addFlexiPlanHeader;


    @AndroidFindBy(id = "com.myvodafoneapp:id/changePlanTitle")
    @iOSXCUITFindBy(id = "choosePlanTitle")
    public WebElement changePlanChoosePlanTitle;


    @AndroidFindBy(id = "com.myvodafoneapp:id/changePlanDescription")
    @iOSXCUITFindBy(id = "choosePlanDescription")
    public WebElement changePlanChoosePlanDescription;


    @AndroidFindBy(id = "com.myvodafoneapp:id/currentPlanTitle")
    @iOSXCUITFindBy(id = "changePlanChoosePlanCurrentPlanTitle")
    public WebElement changePlanChoosePlanCurrentPlanTitle;


    @AndroidFindBy(id = "com.myvodafoneapp:id/currentPlanName")
    @iOSXCUITFindBy(id = "changePlanChoosePlanCurrentPlanDescription")
    public WebElement changePlanChoosePlanCurrentPlanDescription;


    @AndroidFindBy(id = "com.myvodafoneapp:id/currentPlanPrice")
    @iOSXCUITFindBy(id = "changePlanChoosePlanCurrentPlanAmount")
    public WebElement changePlanChoosePlanCurrentPlanAmount;


    @AndroidFindBy(id = "com.myvodafoneapp:id/planItem")
    @iOSXCUITFindBy(id = "choosePlanRecyclerView_0")
    public static WebElement plansRecyclerView;


    @AndroidFindBy(id = "com.myvodafoneapp:id/choosePlanContinueCTA")
    @iOSXCUITFindBy(id = "Continue")
    public static WebElement choosePlanContinueBtn;


    @AndroidFindBy(id = "com.myvodafoneapp:id/txtPlanListItemTitle")
    @iOSXCUITFindAll({
            @iOSXCUITBy(xpath = "//*[@label='Your plan']"),
            @iOSXCUITBy(xpath = "(//XCUIElementTypeStaticText[@name=\"txtPlanListItemTitle\"])[2]")
    })
    public static WebElement PlanTitleRedHybrid;

    @AndroidFindBy(id = "com.myvodafoneapp:id/imgRedHybridCloseView")
    @iOSXCUITFindBy(id = "bottomSheetDismissButtonIdentifier")
    public static WebElement NoPaymentMethodCloseBtn;


    @AndroidFindBy(id = "com.myvodafoneapp:id/imgRedHybridBackView")
    @iOSXCUITFindBy(id = "bottomSheetBackButtonIdentifier")
    public static WebElement imgRedHybridBackView;


    @AndroidFindBy(xpath = "//*[@class='android.widget.Button' and @resource-id='btnSubmit']")
    @iOSXCUITFindAll({
            @iOSXCUITBy(id = "Continue"),
            @iOSXCUITBy(xpath = "//*[@type='XCUIElementTypeButton' and @label='Continue']")
    })
    public WebElement paymentMethodOverlayContinueCTA;


    @AndroidFindBy(xpath = "//*[@class='android.widget.Button' and @resource-id='btnCancel']")
    @iOSXCUITFindBy(xpath = "//*[@type='XCUIElementTypeButton' and @label='Cancel']")
    public WebElement paymentMethodOverlayCancelCTA;


    @AndroidFindBy(xpath = "//*[@class='android.widget.EditText' and @resource-id='confirmCardholderName']")
    @iOSXCUITFindAll({
            @iOSXCUITBy(xpath = "//*[@type='XCUIElementTypeTextField']"),
            @iOSXCUITBy(xpath = "//*[@type='XCUIElementTypeOther']")
    })
    public WebElement paymentMethodOverlayName;


    @AndroidFindBy(xpath = "//*[@class='android.widget.EditText' and @resource-id='confirmCsc']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Complete your order - Barclaycard Checkout']/XCUIElementTypeOther[15]/XCUIElementTypeTextField")
    public WebElement paymentMethodOverlayCVV;


    @AndroidFindBy(xpath = "//*[@class='android.widget.EditText' and @resource-id='passcode']")
    @iOSXCUITFindAll({
            @iOSXCUITBy(xpath = "//XCUIElementTypeOther[@name='Contacting card issuer - Barclaycard Checkout']/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[5]/XCUIElementTypeSecureTextField"),
            @iOSXCUITBy(xpath = "//*[@type='XCUIElementTypeSecureTextField']")
    })
    public WebElement barclaysScreenCardPassword;


    @iOSXCUITBy(xpath = "//*[@type='XCUIElementTypeStaticText' and contains(@label,'Please enter your passcode to complete your payment:')]")
    public WebElement barclaysPWDScreenDescription;


    @AndroidFindBy(xpath = "//*[@class='android.widget.Button' and @text='Submit']")
    @iOSXCUITFindBy(xpath = "//*[@type='XCUIElementTypeButton' and @label='Submit']")
    public WebElement barclaysScreenSubmitCTA;


    @AndroidFindBy(xpath = "//*[@class='android.view.View' and @text='Data entered is invalid, please re-enter details.']")
    @iOSXCUITFindBy(xpath = "//*[@type='XCUIElementTypeStaticText' and @label='Data entered is invalid, please re-enter details.']")
    public WebElement barclaysScreenInvalidPasswordText;


    @AndroidFindBy(id = "com.myvodafoneapp:id/txtRedHybridTitle")
    @iOSXCUITFindBy(id = "bottomSheetTitleIdentifier")
    public static WebElement paymentMethodOverlayHeader;


    @AndroidFindBy(id = "com.myvodafoneapp:id/imgRedHybridCloseView")
    @iOSXCUITFindBy(id = "bottomSheetDismissButtonIdentifier")
    public static WebElement RedHybrid_BottomSheetDismissCTA;


    @iOSXCUITFindBy(xpath = "//*[@name= 'Done']")
    public WebElement IOSDoneCTAKeyBoard;


    @AndroidFindBy(xpath = "//*[@text='Continue']")
    @iOSXCUITFindAll({
            @iOSXCUITBy(xpath = "//*[@label='Continue']"),
            @iOSXCUITBy(id = "confirmScreenBuyCTA")
    })
    public WebElement ContinueCTA;


    @AndroidFindBy(xpath = "//*[@text='Change plan for next month']")
    @iOSXCUITFindAll({
            @iOSXCUITBy(xpath = "//*[@label='Change plan for next month']"),
            @iOSXCUITBy(id = "txtDashboardLinksMenuCellLabel_Change plan for next month")
    })
    public WebElement changeNextPlanQuickLinks;


    @AndroidFindBy(id = "com.myvodafoneapp:id/txtDashboardVeryMeRewardsTitle")
    @iOSXCUITFindBy(id = "imgDashboardVeryMeOffer")
    public WebElement imgDashboardVeryMeOffer;


    @AndroidFindBy(id = "com.myvodafoneapp:id/offerDescTextView")
    @iOSXCUITFindBy(id = "txtDashboardDiscoverOfferDescription")
    public static WebElement DefaultOffer_Description;


    @AndroidFindBy(xpath = "//*[@text='Airtime Plan']")
    @iOSXCUITFindBy(xpath = "//*[@label='Airtime Plan']")
    public WebElement SO_AirtimePlanTab;


    @AndroidFindBy(xpath = "//*[@text='Device Plan']")
    @iOSXCUITFindBy(xpath = "//*[@label='Device Plan']")
    public WebElement SO_DevicePlanTab;


    @AndroidFindBy(id = "com.myvodafoneapp:id/cardView")
    @iOSXCUITFindAll({
            @iOSXCUITBy(id = "wdgTabContent_Device plan"),
            @iOSXCUITBy(id = "txtDashboardCurrentSpendsAdditionalLabel")
    })
    public static WebElement SO_DevicePlanTabContainer;


    @AndroidFindBy(xpath = "//*[@text='Make a payment']")
    @iOSXCUITFindBy(id = "action_0")
    public static WebElement SO_DevicePlanMakePaymentCTA;


    @AndroidFindBy(xpath = "//*[@text='Payment history']")
    @iOSXCUITFindBy(id = "action_1")
    public static WebElement SO_DevicePlanPaymentHistoryCTA;


    @AndroidFindBy(xpath = "//*[@text='View more details']")
    @iOSXCUITFindBy(id = "action_2")
    public static WebElement SO_DevicePlanViewMoreDetailsCTA;


    @AndroidFindBy(id = "com.myvodafoneapp:id/currentChargesContainer")
    @iOSXCUITFindBy(id = "Dashboard_CurrentSpends_Section")
    public WebElement DB_billingTileContainer;


    @AndroidFindBy(id = "com.myvodafoneapp:id/paymentErrorScreenAlertMessage")
    @iOSXCUITFindAll({
            @iOSXCUITBy(id = "paymentErrorScreenAlertMessage"),
            @iOSXCUITBy(xpath = "//*[@type='XCUIElementTypeStaticText' and @label='There was a problem confirming your card']")
    })
    public static WebElement paymentFailedScreenDescription;


    @AndroidFindBy(xpath = "//*[@text='Add Extras']")
    @iOSXCUITFindBy(xpath = "//*[@label='Add Extras']")
    public WebElement addExtrasTile;


    @AndroidFindBy(id = "com.myvodafoneapp:id/txtRedHybridTitle")
    @iOSXCUITFindBy(id = "bottomSheetTitleIdentifier")
    public WebElement addExtrasOverlayTitle;


    @AndroidFindBy(id = "com.myvodafoneapp:id/txtDXIDMSubsOverlay_HeaderTitle")
    @iOSXCUITFindAll({
            @iOSXCUITBy(id = "txtDXIDMSubsOverlay_HeaderTitle"),
            @iOSXCUITBy(id = "txtAlertOverlay_HeaderTitle")
    })
    public WebElement RedHybrid_reminderTitle;


    @AndroidFindBy(id = "com.myvodafoneapp:id/txtDXIDMSubsOverlay_HeaderBody")
    @iOSXCUITFindAll({
            @iOSXCUITBy(id = "txtAlertOverlay_HeaderBody"),
            @iOSXCUITBy(id = "txtDXIDMSubsOverlay_HeaderBody")
    })
    public WebElement RedHybrid_reminderBody;


    @AndroidFindAll({
            @AndroidBy(id = "com.myvodafoneapp:id/DXIDMSubsOverlay_Button"),
            @AndroidBy(xpath = "//*[@text='Turn on auto-renew']")

    })
    @iOSXCUITFindAll({
            @iOSXCUITBy(id = "ReminderOverlay_Button_0"),
            @iOSXCUITBy(id = "DXIDMSubsOverlay_Button_0")
    })
    public WebElement reminderCTA;


    @AndroidFindBy(className = "android.widget.Button")
    public List<WebElement> reminderCTAs;


    @AndroidFindBy(xpath = "//*[@text='Return to My Vodafone']")
    @iOSXCUITFindBy(id = "ReminderOverlay_Button_1")
    public WebElement returnToMyVodafoneCTA;


    @AndroidFindBy(id = "com.myvodafoneapp:id/DXIDMSubsOverlayXIcon")
    @iOSXCUITFindAll({
            @iOSXCUITBy(id = "AlertOverlayXIcon"),
            @iOSXCUITBy(id = "closeIcon")
    })
    public WebElement RedHybrid_reminderCloseButton;


    @AndroidFindBy(xpath = "//*[@text='Username and password']")
    @iOSXCUITFindBy(xpath = "//*[@label='Username and password']")
    public WebElement DX_IDM_LogPrefPassword;


    @AndroidFindBy(xpath = "//*[@resource-id='pass']")
    @iOSXCUITFindBy(xpath = "//*[@type='XCUIElementTypeSecureTextField']")
    public WebElement DX_IDM_PasswordField_ForgetPIN;


    @AndroidFindBy(id = "com.myvodafoneapp:id/txtSubSwitchSelectAccountTitle")
    @iOSXCUITFindBy(id = "txtSubSwitchSelectAccountTitle")
    public WebElement MyAccSelectAccountTitle;


    @AndroidFindBy(id = "com.myvodafoneapp:id/discoverViewAllCTA")
    @iOSXCUITFindBy(id = "discoverViewAllCTA")
    public WebElement DB_DiscoverViewAllCTA;


    @AndroidFindBy(id = "android:id/button1")
    @iOSXCUITFindBy(id = "Remove")
    public WebElement RedHybrid_RemoveCTA;


    @AndroidFindBy(id = "com.myvodafoneapp:id/tvTitle")
    @iOSXCUITFindBy(id = "Estimated charges")
    public WebElement ChargesSSOTitle;


    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View/android.view.View[1]/android.view.View[2]/android.view.View")
    @iOSXCUITFindBy(id = "tvTitle")
    public WebElement ChargesEstimatedSSO;


    @AndroidFindBy(id = "com.myvodafoneapp:id/btnClose")
    @iOSXCUITFindBy(id = "btnClose")
    public WebElement ChargesSSOXIcon;


    @AndroidFindBy(id = "com.myvodafoneapp:id/removeCurrentCardCTA")
    @iOSXCUITFindBy(id = "removeCurrentCardCTA")
    public WebElement RedHybrid_RemoveCardCTA;


    @AndroidFindBy(id = "com.myvodafoneapp:id/btnActionCTA")
    @iOSXCUITFindAll({
            @iOSXCUITBy(id = "Pay securely"),
            @iOSXCUITBy(id = "confirmPlanChangePaySecurelyCTA")
    })
    public WebElement paySecurelyCTA;


    @AndroidFindBy(id = "com.myvodafoneapp:id/txtRedHybridTitle")
    @iOSXCUITFindBy(id = "bottomSheetTitleIdentifier")
    public WebElement changePlanChoosePlanHeader;


    @AndroidFindBy(xpath = "//*[@text='Skip']")
    @iOSXCUITFindBy(id = "action_1")
    public static WebElement RedHybrid_PaymentOverlaySkipCTA;


    @AndroidFindBy(xpath = "//*[@text='Reset the app']")
    @iOSXCUITFindAll({
            @iOSXCUITBy(xpath = "//*[@label='Reset the app']"),
            @iOSXCUITBy(xpath = "//*[@name='txtAppSettingsSubitems_0"),
            @iOSXCUITBy(id = "txtDrawerSettingsSubTitle_App")
    })
    public static WebElement ResetTheApp;


    @AndroidFindBy(id = "com.myvodafoneapp:id/INBOX_LIST_TITLE")
    @iOSXCUITFindBy(xpath = "txtScreenTitle")
    public WebElement Notification_title;


    @AndroidFindBy(id = "com.myvodafoneapp:id/dismissImageView")
    @iOSXCUITFindBy(xpath = "closeIcon")
    public WebElement DB_NotificationXicon;


    @AndroidFindAll({
            @AndroidBy(id = "com.myvodafoneapp:id/notNowCTA"),
            @AndroidBy(xpath = "//*[@text='Button[2]']")
    })
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Not right now\"]")
    public WebElement Login_Prompt_CloseCTA;


    @AndroidFindBy(id = "confirmScreenBuyCTA")
    @iOSXCUITFindBy(xpath = "confirmScreenBuyCTA")
    public WebElement confirmScreenBuyCTA;


    @AndroidFindBy(id = "confirmScreenXCTA")
    @iOSXCUITFindBy(xpath = "bottomSheetDismissButtonIdentifier")
    public WebElement confirmScreenXCTA;


    @AndroidFindBy(id = "confirmScreenExtraTitle")
    @iOSXCUITFindBy(xpath = "confirmScreenExtraTitle")
    public WebElement confirmScreenExtraTitle;

    @AndroidFindBy(id = "confirmScreenExtraAmount")
    @iOSXCUITFindBy(xpath = "confirmScreenExtraAmount")
    public WebElement confirmScreenExtraSubtitle;


    @AndroidFindBy(id = "confirmScreenExtraPrice")
    @iOSXCUITFindBy(xpath = "confirmScreenExtraPrice")
    public WebElement confirmScreenExtraPrice;


    @AndroidFindBy(id = "confirmScreenExtraDescription")
    @iOSXCUITFindBy(xpath = "confirmScreenExtraDescription")
    public WebElement confirmScreenExtraDescription;


    @AndroidFindBy(id = "com.myvodafoneapp:id/traySuccessNotification")
    @iOSXCUITFindAll({
            @iOSXCUITBy(id = "traySuccessNotification"),
            @iOSXCUITBy(id = "traySuccessTitle")
    })
    public WebElement traySuccessNotification;


    @AndroidFindBy(id = "com.myvodafoneapp:id/imgRedHybridTickIcon")
    @iOSXCUITFindAll({
            @iOSXCUITBy(id = "imgRedHybridTickIcon"),
            @iOSXCUITBy(id = "traySuccessIcon")
    })
    public WebElement thankYouTickIcon;


    @AndroidFindBy(id = "com.myvodafoneapp:id/traySuccessSubNotification")
    @iOSXCUITFindAll({
            @iOSXCUITBy(id = "traySuccessSubNotification"),
            @iOSXCUITBy(id = "traySuccessDescription")
    })
    public WebElement traySuccessSubNotification;


    @AndroidFindBy(id = "imgRedHybridCloseView")
    @iOSXCUITFindBy(xpath = "bottomSheetDismissButtonIdentifier")
    public WebElement thankYouCloseIcon;


    @AndroidFindAll({
            @AndroidBy(id = "com.myvodafoneapp:id/controlText"),
            @AndroidBy(id = "com.myvodafoneapp:id/controlIcon")
    })
    public WebElement DB_AirtimeTile;


    @AndroidFindBy(id = "controlsTrayItemTitle")
    @iOSXCUITFindBy(xpath = "controlsTrayItemTitle")
    public List<WebElement> controlsCategoryItemTitle;


    @AndroidFindBy(xpath = "//*[@text='Turn on Auto-Renew']")
    @iOSXCUITFindBy(xpath = "action_0")
    public WebElement RH_TurnOnToggleCTA;


    @AndroidFindBy(xpath = "//*[@text='Close']")
    @iOSXCUITFindBy(xpath = "action_1")
    public WebElement CloseCTA;


    @AndroidFindBy(id = "confirmControlsCTA_0")
    @iOSXCUITFindBy(xpath = "confirmControlsCTA")
    public WebElement confirmControlsConfirmCTA;


    @AndroidFindAll({
            @AndroidBy(xpath = "//*[@text='Data']"),
            @AndroidBy(xpath = "//*[@text='Group Data']")
    })
    @iOSXCUITFindAll({
            @iOSXCUITBy(xpath = "//*[@text='Data']"),
            @iOSXCUITBy(xpath = "//*[@text='Group Data']")
    })
    public WebElement DB_data;


    @AndroidFindBy(xpath = "//*[@text='Controls']")
    @iOSXCUITFindAll({
            @iOSXCUITBy(id = "Controls"),
            @iOSXCUITBy(id = "wdgTabContent_Controls"),
    })
    public WebElement controlTab;


    @AndroidFindBy(id = "com.myvodafoneapp:id/ivCardChevron")
    @iOSXCUITFindBy(id = "ivCardChevron")
    public WebElement SO_DevicePlan_Chevron;


    @AndroidFindBy(id = "com.myvodafoneapp:id/tv_intro_subtitle")
    @iOSXCUITFindBy(xpath = "//*[@name='Welcome_YourAccount']")
    protected static WebElement DX_IDM_WelcomeTextBody;


    @AndroidFindBy(id = "com.myvodafoneapp:id/tv_terms_text")
    @iOSXCUITFindBy(xpath = "//*[@name='We store certain information to improve the app and give you the best experience.']")
    protected static WebElement DX_IDM_BeforeYouGetStartedBody;


    @iOSXCUITFindBy(xpath = "//*[@name='I agree to Vodafone’s Terms and Conditions']")
    protected static WebElement DX_IDM_BeforeYouGetStartedSubBody;


    @AndroidFindBy(id = "com.myvodafoneapp:id/tv_terms_subtitle")
    @iOSXCUITFindBy(xpath = "//*[@name='Please agree to our Terms and Conditions']")
    protected static WebElement DX_IDM_TermsandConditionsAgreeToggleMsg;


    @AndroidFindBy(id = "com.myvodafoneapp:id/tv_terms_message")
    @iOSXCUITFindBy(xpath = "//*[@label='Please agree to the Terms and Conditions before continuing']")
    public static WebElement DX_IDM_termsandConidtionsPopup;


    @AndroidFindBy(id = "com.myvodafoneapp:id/btn_continue")
    @iOSXCUITFindAll({
            @iOSXCUITBy(xpath = "//*[@label='Continue']"),
            @iOSXCUITBy(xpath = "//*[@name='Continue']"),
    })
    protected static WebElement New_DX_IDM_ContinueCTA;


    @AndroidFindAll({
            @AndroidBy(id = "com.myvodafoneapp:id/iv_back_icon"),
            @AndroidBy(id = "com.myvodafoneapp:id/welcomeHeaderBackBtn")
    })
    @iOSXCUITFindBy(xpath = "//*[@name='backIcon']")
    protected static WebElement DX_IDM_BackCTA;


    @AndroidFindBy(id = "tv_cookies_title")
    @iOSXCUITFindBy(id = "tv_cookies_title")
    public static WebElement weValueYourPrivacyTitle;


    @AndroidFindBy(id = "tv_cookies_subtitle")
    @iOSXCUITFindBy(id = "tv_cookies_subtitle")
    public static WebElement cookiePolicyDescription;


    @AndroidFindBy(id = "btn_accept_cookies")
    @iOSXCUITFindBy(id = "btn_accept_cookies")
    public static WebElement acceptAllCookiesCTA;


    @AndroidFindBy(id = "btn_manage_cookies")
    @iOSXCUITFindBy(id = "btn_manage_cookies")
    public static WebElement manageCookiesCTA;


    @AndroidFindBy(id = "com.myvodafoneapp:id/welcomeHeaderTitle")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"wdgTermsAndConditionsContainer\"]/XCUIElementTypeOther[2]")
    public static WebElement DX_IDM_termsAndConditionsScreenTitle;


    @AndroidFindBy(id = "com.myvodafoneapp:id/tv_read_terms_label")
    @iOSXCUITFindBy(id = "I have read and agree to the terms and conditions")
    public static WebElement DX_IDM_TAndCAgreement;


    @AndroidFindBy(id = "com.myvodafoneapp:id/vf_btn_accept")
    @iOSXCUITFindBy(id = "action_0")
    public static WebElement DX_IDM_okCtaTAndCsScreen;


    @AndroidFindBy(id = "com.myvodafoneapp:id/welcomeHeaderTitle")
    @iOSXCUITFindBy(id = "txtScreenTitleLabel")
    public static WebElement DX_IDM_welcomeFlowTitle;


    @AndroidFindBy(id = "com.myvodafoneapp:id/btn_accept_cookies")
    @iOSXCUITFindBy(id = "accept_all_button")
    public static WebElement AcceptAllCTA;


    @AndroidFindBy(id = "com.myvodafoneapp:id/btn_reject_cookies")
    @iOSXCUITFindBy(id = "reject_all_button")
    public static WebElement RejectAllCTA;


    @AndroidFindBy(id = "com.myvodafoneapp:id/cookies_permissions_title")
    @iOSXCUITFindBy(id = "Manage cookie permissions")
    public static WebElement CookiePermissionsTitle;


    @AndroidFindBy(xpath = "//*[@text='Strictly necessary']")
    @iOSXCUITFindBy(xpath = "//*[@label='Strictly necessary']")
    public static WebElement StrictlyNecessaryCard;


    @AndroidFindBy(xpath = "//*[@text='Functional cookies']")
    @iOSXCUITFindBy(xpath = "//*[@label='Functional cookies']")
    public static WebElement FunctionalCookieCard;


    @AndroidFindBy(xpath = "//*[@text='Performance cookies']")
    @iOSXCUITFindBy(xpath = "//*[@label='Performance cookies']")
    public static WebElement PerformanceCookieCard;


    @AndroidFindBy(xpath = "//*[@text='Targeting cookies']")
    @iOSXCUITFindBy(xpath = "//*[@label='Targeting cookies']")
    public static WebElement TargetingCookieCard;


    @AndroidFindBy(id = "com.myvodafoneapp:id/welcomeHeaderBackBtn")
    @iOSXCUITFindBy(id = "backIcon")
    public static WebElement ManageCookiesBack;


    //@AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"Strictly necessary show this section\"]/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.TextView")
    @AndroidFindBy(id = "com.myvodafoneapp:id/txtItemStatus")
    @iOSXCUITFindBy(id = "always_active_label")
    public static WebElement AlwaysActiveLozenge;


    @AndroidFindBy(id = "com.myvodafoneapp:id/card_content")
    @iOSXCUITFindBy(id = "group_decr_label")
    public static WebElement CookieDesc;


    @AndroidFindBy(xpath = "//*[@text='Total Care Warranty']")
    @iOSXCUITFindAll({
            @iOSXCUITBy(xpath = "//*[@label='Total Care Warranty']"),
            @iOSXCUITBy(id = "Total Care Warranty")
    })
    public WebElement SO_DevicePlan_TotalCareWarrantyLink;


    @AndroidFindBy(id = "com.myvodafoneapp:id/txtProductDetails")
    @iOSXCUITFindBy(id = "Get the best care for your device – you’re covered against manufacturer faults and repairs, for two years. Giving you complete peace of mind, at no extra cost to you. Plus, we offer a two-year warranty on all our Apple products – that’s one year more than the manufacturer warranty. You can visit us in store if you need any help or need your device repaired.")
    public WebElement SO_DevicePlan_TotalCareWarrantyDescription;


    @AndroidFindBy(id = "com.myvodafoneapp:id/tv_terms_text")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeLink[@name=\"App Privacy Supplement\"]")
    public WebElement AppPrivacySupplementLink;


    @AndroidFindBy(id = "com.myvodafoneapp:id/welcomeHeaderTitle")
    @iOSXCUITFindBy(id = "txtScreenTitleLabel")
    public WebElement AppAppPrivacySupplementHeader;


    @AndroidFindBy(id = "com.myvodafoneapp:id/tv_privacy_supplement_header_title")
    @iOSXCUITFindBy(id = "My Vodafone App")
    public WebElement AppPrivacySupplementTitle;


    @AndroidFindBy(id = "com.myvodafoneapp:id/tv_privacy_supplement_header_desc")
    @iOSXCUITFindBy(id = "To provide you with features of My Vodafone, VeryMe Rewards send you personalised recommendations, and help improve our products and services, My Vodafone will share certain information from your device with us. This privacy supplement explains the information that is collected by My Vodafone and how it will be used. For further information on our privacy policy please see our main privacy policy page")
    public WebElement AppPrivacySupplementSubTitle;


    @AndroidFindBy(id = "com.myvodafoneapp:id/tv_privacy_supplement_footer_desc")
    @iOSXCUITFindBy(id = "For information about other data retention with Vodafone, please refer to our general privacy policy.")
    public WebElement AppPrivacySupplementBelowText1;


    @iOSXCUITFindBy(id = "The service is offered by Vodafone Limited, which is also the controller of your personal data. If you have any queries in any aspect of this privacy supplement, please use our privacy query form and a member of our dedicated team will respond to you.")
    public WebElement AppPrivacySupplementBelowText2;


    @AndroidFindBy(id = "com.myvodafoneapp:id/settingsSectionTitle")
    public WebElement SettingsTitle;


    @AndroidFindBy(id = "com.myvodafoneapp:id/settingsSectionSubTitle")
    public WebElement SettingsSubTitle;


    @AndroidFindBy(id = "com.myvodafoneapp:id/tv_best_experience_desc")
    @iOSXCUITFindBy(id = "To get the most from our app, we suggest enabling these permissions. You’ll need to accept the pop-ups on the next screen.")
    public WebElement DX_IDM_GettheBestExperienceBody;


    @AndroidFindBy(id = "btn_enable_all")
    @iOSXCUITFindBy(id = "enable_all_cta")
    public WebElement DX_IDM_EnableAllCTA;


    @AndroidFindBy(id = "tv_best_experience_enable_cookie")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeLink[@name='Targeting Cookies.']")
    public WebElement DX_IDM_EnableTargetingCookiesLink;


    @AndroidFindBy(xpath = "//*[@text='OFF']")
    @iOSXCUITFindBy(xpath = "//*[@value='off']")
    public WebElement DX_IDM_NotificationsToggles_OFF;


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeLink[@name='Cookie policy']")
    public static WebElement cookiePolicyLink_IOS;


    @AndroidFindBy(id = "tv_cookies_subtitle")
    public static WebElement cookiePolicyLink_Android;


    @AndroidFindBy(xpath = "//*[@text='Our Cookies policy']")
    @iOSXCUITFindBy(xpath = "//*[@name='card_0_title']")
    public WebElement OurCookiePolicy;


    @AndroidFindBy(xpath = "//*[@text='Controlling your cookies']")
    @iOSXCUITFindBy(xpath = "//*[@name='card_1_title']")
    public WebElement ControllingYourCookies;


    @AndroidFindBy(xpath = "//*[@text='First-party required cookies']")
    @iOSXCUITFindBy(xpath = "//*[@name='first_party_coookie_cta']")
    public WebElement FirstPartyCookie;


    @AndroidFindBy(xpath = "//*[@text='Third party cookies']")
    @iOSXCUITFindBy(xpath = "//*[@name='third_party_coookie_cta']")
    public WebElement ThirdPartyCookie;


    @iOSXCUITFindBy(xpath = "//*[@name='card_0_arrow']")
    public WebElement CookiePolicy_downChevrons1;


    @iOSXCUITFindBy(xpath = "//*[@name='card_1_arrow']")
    public WebElement CookiePolicy_downChevrons2;


    @AndroidFindBy(id = "com.myvodafoneapp:id/card_title")
    @iOSXCUITFindBy(id = "card_expand_button_0_0")
    public WebElement CookiePolicy_FirstpartySDKName;


    @AndroidFindBy(id = "com.myvodafoneapp:id/card_title")
    @iOSXCUITFindBy(id = "card_expand_button_0_50")
    public WebElement CookiePolicy_ThirdpartySDKName;

    @AndroidFindBy(id = "com.myvodafoneapp:id/btmResetAppCTA")
   // @iOSXCUITFindBy(id = "")
    public WebElement ResetCTA;

    @AndroidFindBy(id = "android:id/button1")
   // @iOSXCUITFindBy(id = "")
    public WebElement ResetPopup_ResetCTA;
}

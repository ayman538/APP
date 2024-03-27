package pages.DX_IDM.WelcomeFlow;


import io.appium.java_client.pagefactory.*;
import org.openqa.selenium.WebElement;

import pages.Commons.CommonPo;

public class DX_IDM_WelcomeFlowPO extends CommonPo {


    @AndroidFindBy(id = "com.myvodafoneapp:id/tv_intro_title")
    @iOSXCUITFindBy(id = "Welcome_to_My_Vodafone_Title")
    public WebElement DX_IDM_WelcomeTitle;

    @AndroidFindBy(id = "com.myvodafoneapp:id/tv_terms_title")
    @iOSXCUITFindBy(id = "Welcome_to_My_Vodafone_Title")
    public WebElement DX_IDM_PrivacyScreenTitle;

    @AndroidFindBy(id = "tv_network_service_title")
    @iOSXCUITFindBy(id = "Welcome_to_My_Vodafone_Title")
    public WebElement DX_IDM_NetworkandServiceTitle;

    @AndroidFindBy(id = "tv_best_experience_title")
    @iOSXCUITFindBy(id = "Welcome_to_My_Vodafone_Title")
    public WebElement DX_IDM_GettheBestExperienceTitle;

    @AndroidFindBy(id = "com.myvodafoneapp:id/tv_terms_text")
    @iOSXCUITFindBy(id = "Welcome_YourAccount")
    public WebElement DX_IDM_PrivacyAndTerms;

    @AndroidFindBy(id = "com.myvodafoneapp:id/tv_permissions_title")
    @iOSXCUITFindBy(id = "One last thing")
    public WebElement DX_IDM_PermissionScreenTitle;

    @AndroidFindBy(id = "com.myvodafoneapp:id/tv_permissions_subtitle")
    @iOSXCUITFindBy(id = "To get the most from the My Vodafone App we'd like to ask for some permissions")
    public WebElement DX_IDM_PermissionScreenSubTitle;

    @AndroidFindBy(id = "com.myvodafoneapp:id/alertTitle")
    public WebElement DX_IDM_UsageAccessPopupTitle;

    @AndroidFindBy(id = "android:id/message")
    public WebElement DX_IDM_UsageAccessPopupMessage;

    @AndroidFindBy(id = "com.myvodafoneapp:id/txtDXIDMFTL_HeaderTitle")
    @iOSXCUITFindBy(xpath= "(//XCUIElementTypeStaticText[@name='txtDXIDMFTL_HeaderTitle'])")
    @iOSXCUITFindBy(xpath= "(//XCUIElementTypeStaticText[1])[1]")
    public WebElement DX_IDM_LoginScreenTitle;

    @AndroidFindBy(id = "com.myvodafoneapp:id/txtDXIDMFTL_HeaderBody")
    @iOSXCUITFindBy(xpath= "//XCUIElementTypeStaticText[2]")
    public WebElement DX_IDM_LoginScreenBody;

    @AndroidFindAll({
            @AndroidBy(xpath= "//*[@text='Log in']"),
            @AndroidBy(xpath= "//*[@text='Log In']")
    })
    @iOSXCUITFindAll({
            @iOSXCUITBy(xpath= "//*[@name='Log in']"),
            @iOSXCUITBy(xpath= "//*[@name='Log In']")
    })
    public WebElement DX_IDM_LoginCTA;

    @AndroidFindBy(id = "com.myvodafoneapp:id/DXIDMSkipLogin_Button")
    @iOSXCUITFindBy(id = "action_1")
    public WebElement DX_IDM_SkipLoginCTA;

    @iOSXCUITFindBy(xpath= "//*[contains(@name,'Help us provide better connectivity and services in your area')]")
    @AndroidFindBy(id = "com.myvodafoneapp:id/tv_network_service_desc")
    public WebElement DX_IDM_NetworkandServiceBody;

    @iOSXCUITFindBy(xpath= "//*[@value='off']")
    @AndroidFindBy(xpath= "//*[@text='OFF']")
    public WebElement DX_IDM_NetworkImprovementsToggleOFF;

    @iOSXCUITFindBy(xpath= "//*[@value='on']")
    @AndroidFindBy(xpath= "//*[@text='ON']")
    public WebElement DX_IDM_NetworkImprovementsToggleON;

    @iOSXCUITFindBy(xpath= "//*[@name='Network Improvements']")
    @AndroidFindBy(xpath= "//*[@text='Network Improvements']")
    public WebElement DX_IDM_NetworkImprovementsToggle;

    @iOSXCUITFindBy(xpath= "//*[@name='Share my network and device  performance information with  Vodafone.']")
    @AndroidFindBy(id = "com.myvodafoneapp:id/network_improvements_description")
    public WebElement DX_IDM_NetworkImprovementsToggleBody;

    @iOSXCUITFindBy(xpath= "//*[@name='Performance Cookies.']")
    @AndroidFindBy(id = "com.myvodafoneapp:id/tv_network_service_enable_cookie")
    public WebElement DX_IDM_EnablePerformanceCookiesLink;

    @iOSXCUITFindBy(xpath= "//*[@name='How do you want to share your Network and device performance Information?']")
    @AndroidFindBy(id = "com.myvodafoneapp:id/network_personalisation_title")
    public WebElement DX_IDM_ShareNetworkToggle;

    @iOSXCUITFindBy(xpath= "//*[@name='Share anonymously']")
    @AndroidFindBy(xpath= "//*[@text='Share anonymously']")
    public WebElement DX_IDM_ShareAnonymously;

    @iOSXCUITFindBy(xpath= "//*[@name='Share my customer profile']")
    @AndroidFindBy(xpath= "//*[@text='Share my customer profile']")
    public WebElement DX_IDM_ShareMyCustomerProfile;

    @AndroidFindBy(xpath= "//*[@resource-id='user']")
    @iOSXCUITFindBy(id = "txtAcquisitionNewDBTile_Pay monthly phones")
    public WebElement DX_IDM_Username;
    //TODO need to check when story is deployed

    @AndroidFindBy(id = "com.myvodafoneapp:id/overlayCloseButton")
    @AndroidFindBy(xpath= "//*[@text='Sign in: Voxi.co.uk']")
    @iOSXCUITFindBy(id = "CVMconfirmButton")
    public WebElement DX_IDM_VOXISignINURL;
    //TODO need to check when story is deployed

    @AndroidFindBy(xpath= "//*[@text='Return to My Vodafone']")
    @iOSXCUITFindBy(id = "Return to My Vodafone")
    public WebElement DX_IDM_VOXIReturnToMyVodafoneCTA;
    //TODO need to check when story is deployed

    @AndroidFindBy(xpath= "//*[@text='Return to My Vodafone']")
    @iOSXCUITFindBy(id = "txtAcquisitionNewDBTile_Pay monthly phones")
    public WebElement DX_IDM_VOXITobiIcon;
    //TODO need to check when story is deployed

    @AndroidFindBy(xpath= "//*[@text='Return to My Vodafone']")
    @iOSXCUITFindBy(xpath= "//*[@label='Return to My Vodafone']")
    public WebElement DX_IDM_VOXITobiContentScreen;
    //TODO need to check when story is deployed

    @AndroidFindBy(xpath= "//*[@text='Settings']")
    @iOSXCUITFindBy(xpath= "//*[@label='Settings']")
    public WebElement DX_IDM_VOXISettingDrawer;
    //TODO need to check when story is deployed

    @AndroidFindBy(xpath= "//*[@text='App']")
    @AndroidFindBy(xpath= "//*[@text='App settings']")
    @iOSXCUITFindBy(xpath= "//*[@label='App settings']")
    @iOSXCUITFindBy(xpath= "//*[@label='App']")
    public WebElement DX_IDM_VOXIAppSettingDrawer;
    //TODO need to check when story is deployed

    @AndroidFindBy(xpath= "//*[@text='Privacy']")
    @AndroidFindBy(xpath= "//*[@text='Privacy settings']")
    @iOSXCUITFindBy(xpath= "//*[@label='Privacy settings']")
    @iOSXCUITFindBy(xpath= "//*[@label='Privacy']")
    public WebElement DX_IDM_VOXIPrivacySettingDrawer;
    //TODO need to check when story is deployed

    @AndroidFindBy(xpath= "//*[@text='My Account']")
    @iOSXCUITFindBy(xpath= "//*[@label='My Account']")
    public WebElement DX_IDM_VOXIMyAccountDrawer;
    //TODO need to check when story is deployed

    @AndroidFindBy(id = "com.myvodafoneapp:id/txtDXIDMSubsOverlay_HeaderTitle")
    @iOSXCUITFindBy(xpath= "//*[@label='Hello friend!']")
    @iOSXCUITFindBy(id = "Hello friend!")
    public WebElement DX_IDM_HelloFriendTitle;

    @AndroidFindBy(id = "com.myvodafoneapp:id/overlayBirthdaySecondaryText")
    @iOSXCUITFindBy(id = "The My Vodafone app doesn’t currently support the plan connected with your device’s SIM card.\n" +
            "\n" +
            "If you have another Vodafone service you’d like to manage you can log in via the My Account page.")
    public WebElement DX_IDM_HelloFriendBody;

    @AndroidFindBy(id = "com.myvodafoneapp:id/overlayCloseButton")
    @AndroidFindBy(xpath= "//*[@text='Log in']")
    @iOSXCUITFindBy(id = "txtAcquisitionNewDBTile_Pay monthly phones")
    public WebElement DX_IDM_HelloFriendLoginCTA;

    @AndroidFindBy(xpath= "//*[@label='Return to My Vodafone']")
    @iOSXCUITFindBy(id = "CVMconfirmButton")
    public WebElement DX_IDM_HelloFriendReturnToMyVodafoneCTA;

    @AndroidFindBy(id = "com.myvodafoneapp:id/DXIDMSubsOverlayXIcon")
    @iOSXCUITFindBy(id = "txtAcquisitionNewDBTile_Pay monthly phones")
    public WebElement DX_IDM_HelloFriendXIcon;

    @AndroidFindBy(id = "com.myvodafoneapp:id/txtAcquisitionNewDB_HeaderTitle")
    public WebElement DX_IDM_AcquisitionScreenHeaderTitle;

    @AndroidFindBy(id = "com.myvodafoneapp:id/txtAcquisitionNewDB_HeaderBody")
    public WebElement DX_IDM_AcquisitionScreenHeaderBody;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
    public WebElement DX_IDM_LocationPermission;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
    public WebElement DX_IDM_PhonePermission;

    public DX_IDM_WelcomeFlowPO() {
        super();
    }

}


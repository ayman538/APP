package pages.Tray.Settings.PrivacySetting;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.Commons.CommonPo;


public class PrivacySettingsPO extends CommonPo {
    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='App privacy']"),
            @FindBy(how = How.XPATH, using = "//*[@label='App privacy']")
    })
    public WebElement PS_AppPrivacyOption;
    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Privacy Settings']"),
            @FindBy(how = How.XPATH, using = "//*[@label='Privacy Settings'")
    })
    public WebElement PS_PrivacySettingTitle;
    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Marketing preferences']"),
            @FindBy(how = How.XPATH, using = "//*[@label='Marketing preferences']")
    })
    public WebElement PS_MarketingPermissionsOption;
    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='App Privacy Supplement']"),
            @FindBy(how = How.XPATH, using = "//*[@label='App Privacy Supplement']")
    })
    public WebElement PS_AppPrivacySupplementOption;
    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Vodafone Privacy Portal']"),
            @FindBy(how = How.XPATH, using = "//*[@label='Vodafone Privacy Portal']")
    })
    public WebElement PS_VodafonePrivacyPortalOption;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/dismissImageView"),
            @FindBy(how = How.ID, using = "backIcon")
    })
    public WebElement PS_DismissButton;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/privacy_options_page_title"),
            @FindBy(how = How.XPATH, using = "//*[@label='App Privacy']")
    })
    public WebElement PS_AppPrivacyTitle;
    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Tailored service and recommendations']"),
            @FindBy(how = How.XPATH, using = "//*[@label='Tailored service and recommendations']")
    })
    public WebElement PS_RecommendationCardTitle;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/personalized_description"),
            @FindBy(how = How.XPATH, using = "((//*[@label='Tailored service and recommendations']/following::*[@type='XCUIElementTypeTextView']))[1]")
    })
    public WebElement PS_RecommendationDescription;
    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Network optimisation']"),
            @FindBy(how = How.XPATH, using = "//*[@label='Network optimisation']"),
            @FindBy(how = How.ID, using = "Network Optimization")
    })
    public WebElement PS_NetworkOptimisationTitle;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/anonymous_description"),
            @FindBy(how = How.XPATH, using = "((//*[@label='Network optimisation']/following::*[@type='XCUIElementTypeTextView']))[1]")
    })
    public WebElement PS_NetworkOptimisationDescription;
    @FindAll({
            @FindBy(how = How.ID, using = "com.android.chrome:id/close_button"),
            @FindBy(how = How.XPATH, using = "//XCUIElementTypeButton[@name='Done']")
    })
    public WebElement PS_CloseButtonCustomTab;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/backImageView"),
            @FindBy(how = How.XPATH, using = "//XCUIElementTypeButton[@name='back icon']"),
            @FindBy(how = How.NAME,using = "backIcon")
    })
    public WebElement PS_BackButton;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/supplement_title"),
            @FindBy(how = How.ID, using = "Settings_AppPrivacySupplementsView_AppPrivacySupplements_Label")
    })
    public WebElement PS_SupplementTitle;
    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Information we collect']"),
            @FindBy(how = How.ID, using = "Settings_AppPrivacySupplementView_What information we collect_label")
    })
    public WebElement PS_SupplementCardInfoWeCollect;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/privacy_item_expandable_content"),
            @FindBy(how = How.ID, using = "Settings_AppPrivacySupplementView__details")
    })
    public WebElement PS_SupplementCardInfoWeCollectDescription;
    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Usage of My Vodafone app']"),
            @FindBy(how = How.ID, using = "Settings_AppPrivacySupplementView_Usage of My Vodafone app_label")
    })

    public WebElement PS_SupplementCardUsageOfVodafone;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/privacy_item_expandable_content"),
            @FindBy(how = How.ID, using = "Settings_AppPrivacySupplementView__details")
    })

    public WebElement PS_SupplementCardUsageOfVodafoneDescription;
    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text=\"What information we don't collect\"]"),
            @FindBy(how = How.ID, using = "Settings_AppPrivacySupplementView_Information"),
            @FindBy(how = How.NAME,using = "Settings_AppPrivacySupplementView_What information we don't collect_label")
    })

    public WebElement PS_SupplementCardWhatInfoNotCollected;
    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='How we use this information']"),
            @FindBy(how = How.ID, using = "Settings_AppPrivacySupplementView_Information"),
            @FindBy(how = How.NAME,using = "Settings_AppPrivacySupplementView_How we use this information_label")
    })
    public WebElement PS_SupplementCardHowToUseInfo;
    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='What choices do you have?']"),
            @FindBy(how = How.ID, using = "Settings_AppPrivacySupplementView_What"),
            @FindBy(how = How.NAME,using = "Settings_AppPrivacySupplementView_What choices do you have?_label")
    })
    public WebElement PS_SupplementCardWhatChoices;
    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='How do you protect my data?']"),
            @FindBy(how = How.ID, using = "Settings_AppPrivacySupplementView_How"),
            @FindBy(how = How.NAME,using = "Settings_AppPrivacySupplementView_What choices do you have?_label")
    })
    public WebElement PS_SupplementCardProtectData;
    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='For how long do you keep my data?']"),
            @FindBy(how = How.ID, using = "Settings_AppPrivacySupplementView_For"),
            @FindBy(how = How.NAME,using = "Settings_AppPrivacySupplementView_For how long do you keep my data?_label")
    })
    public WebElement PS_SupplementCardKeepData;
    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Vodafone privacy policy']"),
            @FindBy(how = How.ID, using = "Settings_AppPrivacySupplementView_Vodafone"),
            @FindBy(how = How.NAME,using = "Settings_AppPrivacySupplementView_Vodafone privacy policy_label")
    })
    public WebElement PS_SupplementCardVodafonePrivacy;
    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Tailored service and recommendations']"),
            @FindBy(how = How.ID, using = "Tailored service and recommendations")
    })
    public WebElement PS_AppPrivacyTailoredServiceTitle;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/personalized_description"),
            @FindBy(how = How.XPATH, using = "//*[@value='We can make personal recommendations and tailor our service based on your location, the quality and use of your connectivity services.']")
    })
    public WebElement PS_AppPrivacyTailoredServiceDescription;
    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Keep on']"),
            @FindBy(how = How.ID, using = "action_1")
    })
    public WebElement PS_AppPrivacyKeepOnCTA;
    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Turn off']"),
            @FindBy(how = How.ID, using = "action_0")
    })
    public WebElement PS_AppPrivacyTurnOffCTA;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/messageTextView"),
            @FindBy(how = How.ID, using = "If you turn this option OFF, you will not only miss out on personalised assistance and recommendations but also be unable to check the data consumption of the apps installed on your device.")
    })
    public WebElement PS_AppPrivacyWarningMessage;
    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Network optimisation']"),
            @FindBy(how = How.ID, using = "Network Optimization")
    })
    public WebElement PS_AppPrivacyNetworkOptimisation;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/anonymous_description"),
            @FindBy(how = How.XPATH, using = "//*[@value='By collecting data including location and the performance of your phone we can improve the service we offer to everyone. This data is not linked back to you in any way.']")
    })
    public WebElement PS_AppPrivacyNetworkOptimisationDescription;
    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='What happens when you keep this on?']"),
            @FindBy(how = How.XPATH, using = "//*[@value='What happens when you keep this on?']")
    })
    public WebElement PS_AppPrivacyChevron;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/usage_access_sub_description"),
            @FindBy(how = How.XPATH, using = "//*[@value='What happens when you keep this on?']")
    })
    public WebElement PS_AppPrivacyDataUsageCard;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/primaryButton"),
            @FindBy(how = How.ID, using = "Settings_AppPrivacySupplementView_Information")
    })
    public WebElement PS_AppPrivacyGrantPermissionOkCTA;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/tv_bullets"),
            @FindBy(how = How.ID, using = "Settings_AppPrivacySupplementView_Information")
    })
    public WebElement PS_AppPrivacyChevronExpandContent;
    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@resource-id='" + "com.myvodafoneapp:id/vfg_commonui_title' and contains(@text,'usage')]"),
            @FindBy(how = How.ID, using = "Settings_AppPrivacySupplementView_Information")
    })
    public WebElement PS_AppPrivacyDataUsage;
    @FindAll({
            @FindBy(how = How.XPATH, using = "((//*[@resource-id='" + "com.myvodafoneapp:id/vfg_commonui_imgv_icon']))[1]"),
            @FindBy(how = How.XPATH, using = "(//*[@type='XCUIElementTypeSwitch'])[1]")
    })
    public WebElement PS_AppPrivacyTailoredServiceToggle;
    @FindAll({
            @FindBy(how = How.XPATH, using = "((//*[@resource-id='" + "com.myvodafoneapp:id/vfg_commonui_imgv_icon']))[3]"),
            @FindBy(how = How.XPATH, using = "(//*[@type='XCUIElementTypeSwitch'])[2]"),
            @FindBy(how =How.XPATH, using= "//*[@name='scrollView']/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther[4]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther")
    })
    public WebElement PS_AppPrivacyNetworkOptimisationToggle;
    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Network and Service']"),
            @FindBy(how = How.ID, using = "Network and Service")
    })
    public WebElement PrivacySettings_NetworkAndServices;
    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Cookie permissions']"),
            @FindBy(how = How.ID, using = "Cookie permissions")
    })
    public WebElement PrivacySettings_CookiePermissions;
    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Device permissions']"),
            @FindBy(how = How.ID, using = "Device permissions")
    })
    public WebElement PrivacySettings_DevicePermissions;
    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Vodafone Privacy Information']"),
            @FindBy(how = How.ID, using = "Vodafone Privacy Information")
    })
    public WebElement PrivacySettings_VodafonePrivacyInformation;


    public PrivacySettingsPO() {
        super();
    }
}

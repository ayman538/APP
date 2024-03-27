package pages.RedHybrid.AppAndPrivacySettings;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.Commons.CommonPo;

public class AppAndPrivacySettingsPO extends CommonPo {

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Settings']"),
            @FindBy(how = How.XPATH, using = "//*[@label='Settings']")
    })
    public WebElement settingsIcon;


    //Settings Drawer
    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Settings']"),
            @FindBy(how = How.XPATH, using = "//*[@label='Settings']")
    })
    public WebElement settingsDrawerTitle;

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='App']"),
            @FindBy(how = How.XPATH, using = "//*[@label='App']")
    })
    public WebElement appSettingsIcon;

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Account']"),
            @FindBy(how = How.XPATH, using = "//*[@label='Account']")
    })
    public WebElement accountSettingsIcon;

    //App Settings Screen Content
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/txtAppSettingsTitle"),
            @FindBy(how = How.ID, using = "txtScreenTitle")
    })
    public WebElement appSettingsScreenTitle;

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Reset the app']"),
            @FindBy(how = How.XPATH, using = "//*[@label='Reset the app']")
    })
    public WebElement resetTheAppLink;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/txtResetAppTitle"),
            @FindBy(how = How.ID, using = "txtResetAppTitle")
    })
    public WebElement resetTheAppScreenTitle;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/btmResetAppCTA"),
            @FindBy(how = How.XPATH, using = "//*[@label='Reset']")
    })
    public WebElement resetCTA;
    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Login options']"),
            @FindBy(how = How.XPATH, using = "//*[@label='Login options']")
    })
    public WebElement loginOptionsLink;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/txtLoginOptionTitle"),
            @FindBy(how = How.ID, using = "txtLoginOptionTitle")
    })
    public WebElement loginOptionsScreenTitle;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/recyclerViewLoginOptionMethods"),
            @FindBy(how = How.ID, using = "Username and password")
    })
    public WebElement loginOptions;


    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Device permissions']"),
            @FindBy(how = How.XPATH, using = "//*[@label='Device permissions']")
    })
    public WebElement devicePermissionsLink;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/txtDevicePermissionTitle"),
            @FindBy(how = How.ID, using = "txtDevicePermissionTitle")
    })
    public WebElement devicePermissionsScreenTitle;
    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Configure permission']"),
            @FindBy(how = How.XPATH, using = "//*[@label='Configure permission']")
    })
    public WebElement devicePermissionsScreenCTA;


    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Terms and Conditions']"),
            @FindBy(how = How.XPATH, using = "//*[@label='Terms and Conditions']")
    })
    public WebElement termsAndConditionsLink;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/Settings_TACView_TAC_Label"),
            @FindBy(how = How.ID, using = "txtTermsAndConditionTitle")
    })
    public WebElement termsAndConditionsScreenTitle;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/txtTermsAndConditionDescription"),
            @FindBy(how = How.ID, using = "Settings_TACView_TACCopyright_Label")
    })
    public WebElement TAndCDescription;




    //Privacy Settings Screen Content
    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Privacy']"),
            @FindBy(how = How.XPATH, using = "//*[@label='Privacy']")
    })
    public WebElement privacySettingsIcon;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/txtAppSettingsTitle"),
            @FindBy(how = How.ID, using = "txtScreenTitle")
    })
    public WebElement privacySettingsScreenTitle;



    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='App privacy']"),
            @FindBy(how = How.XPATH, using = "//*[@label='App privacy']")
    })
    public WebElement appPrivacyLink;



    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Marketing preferences']"),
            @FindBy(how = How.XPATH, using = "//*[@label='Marketing preferences']")
    })
    public WebElement marketingPreferencesLink;


    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='App Privacy Supplement']"),
            @FindBy(how = How.XPATH, using = "//*[@label='App Privacy Supplement']")
    })
    public WebElement appPrivacySupplementLink;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/supplement_title"),
            @FindBy(how = How.ID, using = "Settings_AppPrivacySupplementsView_AppPrivacySupplements_Label")
    })
    public WebElement appPrivacySupplementScreenTitle;
    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Information we collect']"),
            @FindBy(how = How.ID, using = "Settings_AppPrivacySupplementView_What information we collect_label")
    })
    public WebElement PS_SupplementCardInfoWeCollect;
    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Marketing preferences']"),
            @FindBy(how = How.XPATH, using = "//*[@label='Marketing preferences']")
    })
    public WebElement MarketingPreferencesLink;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/tvTitle"),
            @FindBy(how = How.XPATH, using = "(//XCUIElementTypeStaticText[@name='Marketing preferences'])[1]")
    })
    public WebElement MarketingPreferencesScreenTitle;

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Vodafone Privacy Portal']"),
            @FindBy(how = How.XPATH, using = "//*[@label='Vodafone Privacy Portal']")
    })
    public WebElement vodafonePrivacyPortalLink;
    @FindAll({
            @FindBy(how = How.ID, using = "com.sec.android.app.sbrowser:id/custom_tab_toolbar_url_bar_text"),
            @FindBy(how = How.XPATH, using = "//XCUIElementTypeOther[@name='URL']")
    })
    public WebElement vodafonePrivacyPortalScreenURL;
    @FindAll({
            @FindBy(how = How.ID, using = "com.sec.android.app.sbrowser:id/customtab_view"),
            @FindBy(how = How.ID, using = "Privacy and cookies policies | Vodafone")
    })
    public WebElement vodafonePrivacyPortalCustomView;
    @FindAll({
            @FindBy(how = How.ID, using = "com.sec.android.app.sbrowser:id/custom_tab_toolbar_close_icon"),
            @FindBy(how = How.XPATH, using = "//XCUIElementTypeButton[@name='Done']")
    })
    public WebElement vodafonePrivacyPortalScreenDismiss;
}

package pages.Tray.Settings.PrivacySetting;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import models.response.SegmentResponseModel;
import org.assertj.core.util.Lists;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.Tray.Settings.AccountSetting.SettingsDrawerAndAccountSettingsAndroid;
import utils.SegmentUtils;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import static core.Config.getUnknownUser;
import static utilities.PropertiesLoader.readEnv;
import static utilities.PropertiesLoader.readPropertyFile;
import static utils.element_helpers.GenericHelpers.navigateToURL;
import static utils.element_helpers.ScrollHelpers.*;
import static utils.element_helpers.VerifyHelpers.*;
import static utils.element_helpers.VerifyHelpers.AssertDisplayed;
import static utils.element_helpers.WaitHelpers.waitForVisibility;
import static utils.element_helpers.WaitHelpers.waitForVisibilityForReinvent;

public class PrivacySettingsAndroid extends PrivacySettingsAbstract {

    SettingsDrawerAndAccountSettingsAndroid accountSettings;
    SegmentResponseModel  segmetResponseModel ;
    Properties envProp = readPropertyFile("config/env.properties");
    Boolean live = System.getProperty("isLiveTest", readEnv("isLiveTest")).equalsIgnoreCase("true");
    By NetworkImprovementsToggleFromSettings_ANDROID = By.id("com.myvodafoneapp:id/network_improvements_toggle");
    By NetworkAndServicesTitle_ANDROID = By.id("com.myvodafoneapp:id/network_and_service_title");
    By NetworkAndServicesDes_ANDROID = By.id("com.myvodafoneapp:id/network_and_service_desc");
    By Bluebanner_ANDROID = By.id("com.myvodafoneapp:id/warningMessage");
    By NetworkImprovementsCardIcon_ANDROID = By.id("com.myvodafoneapp:id/network_improvements_icon");
    By NetworkImprovementsCardTitle_ANDROID = By.id("com.myvodafoneapp:id/network_improvements_title");
    By NetworkImprovementsCardDes_ANDROID = By.id("com.myvodafoneapp:id/network_improvements_description");
    By NetworkAndServicesSecondCardTitle_ANDROID = By.id("com.myvodafoneapp:id/network_personalisation_title");
    By NetworkAndServicesSecondCardlogo_ANDROID = By.id("com.myvodafoneapp:id/network_personalisation_icon");
    By ShareAnonymously_ANDROID = By.id("com.myvodafoneapp:id/network_service_anonymously");
    By ShareMyCustomerProfile_ANDROID = By.id("com.myvodafoneapp:id/network_service_share_profile");
    By PerformenceCookieLink_ANDROID = By.id("com.myvodafoneapp:id/warningMessage");
    By PrivacyInfoScreenTitle = By.id("com.myvodafoneapp:id/welcomeHeaderTitle");
    By PrivacyPortalScreenHeader = By.id("com.myvodafoneapp:id/settingsSectionTitle");
    By AppPrivacySupplementCTA = By.xpath("//*[@text='App Privacy Supplement']");
    By CookiePolicyCTA = By.xpath("//*[@text='Cookie policy']");
    By PrivacyPortalCTA = By.xpath("//*[@text='Privacy portal']");
    By PrivacyInfoChevrons = By.id("com.myvodafoneapp:id/settingsItemChevron");
    By PrivacyPortalWebviewDissmis_ANDROID = By.id("com.android.chrome:id/close_button");
    By PrivacyPortalWebviewTitle_ANDROID = By.id("com.android.chrome:id/url_bar");
    By DevicePermissionsCTA_ANDROID = By.xpath("//*[@text='Device permissions']");
    By DevicePermissionsScreenTitle_ANDROID = By.id("com.myvodafoneapp:id/device_permissions_title");
    By DevicePermissionsScreenDescription_ANDROID = By.id("com.myvodafoneapp:id/device_permissions_desc");
    List<String> DevicePermissionCardTitle = Lists.newArrayList("Notifications","Phone calls", "Usage", "Share location", "Media");
    List<String> DevicePermissionDescription = Lists.newArrayList("like to receive notifications from the app. We can share useful updates on your bills and data allowance.","The app requests this permission to understand the phone identity and is required to use the network speed checker in the app.", "The app requests this permission to collect data about your Network and App usage to optimise network performance.", "Choose to share your location with the app. This helps us find products and offers to suit you, and improves your experience in the app.", "The app requests this permission to download your bill to the device.");
    List<String> DevicePermissionCTA = Lists.newArrayList("Manage notifications","Manage phone calls", "Manage usage settings", "Manage location settings", "Manage media settings");
    List<WebElement> DevicePermissionsLozenges = driver.findElements(By.id("com.myvodafoneapp:id/txtItemStatus"));
    private  By Network_and_services_title = By.id("com.myvodafoneapp:id/network_and_service_title");

    public PrivacySettingsAndroid() throws IOException {
        super();
        if(!live) {
            segmetResponseModel = SegmentUtils.GetSegment();
            accountSettings = new SettingsDrawerAndAccountSettingsAndroid();
        }
    }
    private final By Settings_from_tray = By.xpath("//android.widget.TextView[contains(@resource-id, 'com.myvodafoneapp:id/txtPlanListItemTitle') and @text='Settings']");
    private final By App_settings = By.xpath("//android.widget.TextView[contains(@resource-id, 'com.myvodafoneapp:id/txtPlanListItemTitle') and @text='App']");
    private final By Privacy_settings_from_tray = By.xpath("//android.widget.TextView[contains(@resource-id, 'com.myvodafoneapp:id/txtPlanListItemTitle') and @text='Privacy settings']");
    private final By App_privacy= By.xpath("//android.widget.TextView[contains(@resource-id, 'com.myvodafoneapp:id/settingsItemTitle') and @text='App privacy']");
    private final By Marketing_preferences = By.xpath("//android.widget.TextView[contains(@resource-id, 'com.myvodafoneapp:id/settingsItemTitle') and @text='Marketing preferences']");
    private final By App_privacy_Supplement = By.xpath("//android.widget.TextView[contains(@resource-id, 'com.myvodafoneapp:id/settingsItemTitle') and @text='App Privacy Supplement']");
    private final By Vodafone_privacy_portal= By.xpath("//android.widget.TextView[contains(@resource-id, 'com.myvodafoneapp:id/settingsItemTitle') and @text='Vodafone Privacy Portal']");
    private final By back_from_privacy = By.id("com.myvodafoneapp:id/welcomeHeaderBackBtn");

    public void navigateToPrivacyScreen() {
        if(live){
            waitForVisibility(Settings_from_tray);
            driver.findElement(Settings_from_tray).click();
            waitForVisibility(Privacy_settings_from_tray);
            driver.findElement(Privacy_settings_from_tray).click();

        }else {
            try {
                clickOnSettingsInTray();
                String segment = segmetResponseModel.segment;
                if (getUnknownUser().equalsIgnoreCase("false")) {
                    if (!segment.equalsIgnoreCase("PREPAY")) {
                        SwipeToElement(DB_Account, "Right");
                        SwipeToElement(DB_PrivacySetting, "Right");
                    }
                }
                clickOnPrivacySettings();
            } catch (Exception e) {
                navigateToURL("myvodafone://PRIVACY_SETTINGS");
            }
        }
    }

    public void validatePrivacySettingsItems() {
        if (live) {
            waitForVisibility(Marketing_preferences);
            AssertResult(driver.findElement(Marketing_preferences).getText(), "Marketing preferences");
            verifyAllElementsPresent(App_privacy,App_privacy_Supplement,Vodafone_privacy_portal);
            waitForVisibility(back_from_privacy);
            driver.findElement(back_from_privacy).click();
        } else {
            PrivacyCommanItems();
            String segment = segmetResponseModel.segment;
            if (envProp.getProperty("UnknownUser").equalsIgnoreCase("true")) {
                assertElementDoesNotExist(PS_MarketingPermissionsOption);
            } else if (segment.equalsIgnoreCase("CONSUMER") || segment.equalsIgnoreCase("SMB") || segment.equalsIgnoreCase("SOLETRADER")) {
                AssertResult(PS_MarketingPermissionsOption.getText(), "Marketing preferences");
            }
            waitForVisibility(GeneralBackIcon);
            GeneralBackIcon.click();
        }
    }
    public void validatePrivacySettingsItemsForAcq() {
        PrivacyCommanItems();
        PS_DismissButton.click();
    }

    public void PrivacyCommanItems() {
        waitForVisibilityForReinvent(PS_AppPrivacyOption,60);
        AssertResult(PS_AppPrivacyOption.getText(), "App privacy");
        AssertResult(PS_AppPrivacySupplementOption.getText(), "App Privacy Supplement");
        AssertResult(PS_VodafonePrivacyPortalOption.getText(), "Vodafone Privacy Portal");
    }

    public void clickOnPrivacySettings() {
        waitForVisibility(DB_PrivacySetting);
        DB_PrivacySetting.click();
    }

    public void clickOnSettingsInTray() {
        waitForVisibility(DB_SettingDashboardTray_icon);
        DB_SettingDashboardTray_icon.click();
    }

    public void validateAppPrivacySupplementChevrons() {
        clickOnAppPrivacySupplement();
        AssertDisplayed(PS_SupplementTitle.isDisplayed());
        AssertDisplayed(PS_SupplementCardInfoWeCollect.isDisplayed());

        AssertDisplayed(PS_SupplementCardWhatInfoNotCollected.isDisplayed());

        scrollDown();
        waitForVisibility(PS_SupplementCardHowToUseInfo);
        AssertDisplayed(PS_SupplementCardHowToUseInfo.isDisplayed());

        waitForVisibility(PS_SupplementCardWhatChoices);
        AssertDisplayed(PS_SupplementCardWhatChoices.isDisplayed());

        PS_BackButton.click();
    }

    public void assertExternalBrowserDisplayed() {
        waitForVisibility(DoneCtaInExternalbrowser);
        AssertDisplayed(DoneCtaInExternalbrowser.isDisplayed());
        DoneCtaInExternalbrowser.click();
    }

    public void clickOnSupplementCardVodafonePrivacy() {
        waitForVisibility(PS_SupplementCardVodafonePrivacy);
        PS_SupplementCardVodafonePrivacy.click();
    }

    public void assertSupplementCardKeepDataCollapse() {
        PS_SupplementCardKeepData.click();
        AssertDisplayed(!IsElementDisplayed(PS_SupplementCardInfoWeCollectDescription));
    }

    public void assertSupplementCardKeepDataExpansion() {
        waitForVisibility(PS_SupplementCardKeepData);
        PS_SupplementCardKeepData.click();
        AssertDisplayed(PS_SupplementCardUsageOfVodafoneDescription.isDisplayed());
    }

    public void assertSupplementCardInfoWeCollectCollapse() {
        PS_SupplementCardProtectData.click();
        AssertDisplayed(!IsElementDisplayed(PS_SupplementCardInfoWeCollectDescription));
    }

    public void assertSupplementCardProtectDataExpansion() {
        waitForVisibility(PS_SupplementCardProtectData);
        PS_SupplementCardProtectData.click();
        AssertDisplayed(PS_SupplementCardUsageOfVodafoneDescription.isDisplayed());
    }

    public void assertSupplementCardCollapse() {
        PS_SupplementCardUsageOfVodafone.click();
        AssertDisplayed(!IsElementDisplayed(PS_SupplementCardInfoWeCollectDescription));
    }

    public void assertSupplementCardExpansion() {
        PS_SupplementCardUsageOfVodafone.click();
        AssertDisplayed(PS_SupplementCardUsageOfVodafoneDescription.isDisplayed());
    }

    public void clickOnAppPrivacySupplement() {
        waitForVisibility(PS_AppPrivacySupplementOption);
        PS_AppPrivacySupplementOption.click();
    }

    public void ChevronChecks(WebElement ps_supplementCardInfoWeCollect, String s, WebElement ps_supplementCardInfoWeCollectDescription) {
        AssertResult(ps_supplementCardInfoWeCollect.getText(), s);
        ps_supplementCardInfoWeCollect.click();
        AssertDisplayed(ps_supplementCardInfoWeCollectDescription.isDisplayed());
        ps_supplementCardInfoWeCollect.click();
        AssertDisplayed(!IsElementDisplayed(PS_SupplementCardInfoWeCollectDescription));
    }

    public void validateAppPrivacyTailored() {
        waitForVisibility(PS_AppPrivacyOption);
        PS_AppPrivacyOption.click();
        if(live){
            waitForVisibility(Network_and_services_title);
            AssertResult(driver.findElement(Network_and_services_title).getText(), "Network and Service");
        }else {
            AssertResult(PS_AppPrivacyTailoredServiceTitle.getText(), "Tailored service and recommendations");
            AssertDisplayed(PS_AppPrivacyTailoredServiceDescription.isDisplayed());
            scrollDownTo(PS_AppPrivacyNetworkOptimisationDescription);
        }
    }

    public void validateAppPrivacyNetwork() {
        AssertResult(PS_NetworkOptimisationTitle.getText(), "Network optimisation");
        AssertDisplayed(PS_AppPrivacyChevron.isDisplayed());
    }

    public void validateAppPrivacyChevron() {
        PS_AppPrivacyChevron.click();
        scrollDownTo(PS_AppPrivacyChevronExpandContent);
        AssertDisplayed(PS_AppPrivacyChevronExpandContent.isDisplayed());
        PS_AppPrivacyChevron.click();
    }

    public void validateAppPrivacyUsageCard() {
        scrollDownTo(PS_AppPrivacyDataUsageCard);
        scrollDown();
//        AssertDisplayed(PS_AppPrivacyDataUsage.isDisplayed());
        System.out.println(PS_AppPrivacyDataUsage.getText());
        AssertDisplayed(PS_AppPrivacyDataUsage.getText().contains("App data usage:"));
        PS_BackButton.click();
    }

    public void validateMarketingPreferencesFunctionality() {
        SegmentResponseModel segment= SegmentUtils.GetSegment();
        if (segment.segment.equalsIgnoreCase("PREPAY")) {
            AssertDisplayed(!IsElementDisplayed(PS_MarketingPermissionsOption));
        } else {
            clickOnMarketingPermissionsOption();
            waitForVisibility(DX_IDM_X_Button);
            AssertDisplayed(DX_IDM_X_Button.isDisplayed());
        }
    }

    public void clickOnMarketingPermissionsOption() {
        waitForVisibility(PS_MarketingPermissionsOption);
        PS_MarketingPermissionsOption.click();
    }

    public void validateVodafonePrivacyPortalFunctionality() {
        clickOnVodafonePrivacyPortalOption();
        assertExternalBrowserDisplayed();
    }

    public void clickOnVodafonePrivacyPortalOption() {
        waitForVisibility(PS_VodafonePrivacyPortalOption);
        PS_VodafonePrivacyPortalOption.click();
    }

    public void ChekNewUIOfPrivacySettings(){
        int numberOfItems = 5;

        if((envProp.getProperty("UnknownUser").equalsIgnoreCase("true")) ||
                ((segmetResponseModel.segment.equalsIgnoreCase("PREPAY")) && (!(segmetResponseModel.subscriptionType.name.equalsIgnoreCase("HYBRID")) ))) {
            assertElementDoesNotExist(PS_MarketingPermissionsOption);
            numberOfItems = 4;
        } else {
            validateVisibilityListOfItems(PS_MarketingPermissionsOption);
            AssertDisplayed(driver.findElement(By.xpath("//*[@text='Choose how you’d like to hear from us about our latest products, offers and rewards']")).isDisplayed());
        }
        validateCommonUIOfPrivacySettings(numberOfItems);
        // validate back behavior
        GeneralBackIcon.click();
        waitForVisibility(DB_SettingDashboardTray_icon);
        AssertDisplayed(DB_SettingDashboardTray_icon.isDisplayed());
    }
    public void validateCommonUIOfPrivacySettings(int num){
        // Assert on chevrons
        List<WebElement> chevronsFirstView = driver.findElements(By.id("com.myvodafoneapp:id/settingsItemChevron"));
        int numOfChevronsFirstView = chevronsFirstView.size();
        int remainChevrons = num-numOfChevronsFirstView;

        // Assert on icons
        List<WebElement> iconsFirstView = driver.findElements(By.id("com.myvodafoneapp:id/settingsItemIcon"));
        int numOfIconsFirstView = iconsFirstView.size();
        int remainIcons = num-numOfIconsFirstView;

        waitForVisibility(AppAppPrivacySupplementHeader);
        AssertResult(AppAppPrivacySupplementHeader.getText(),"Settings");
        AssertDisplayed(GeneralBackIcon.isDisplayed());
        AssertResult(SettingsTitle.getText(),"Privacy Settings");
        AssertResult(SettingsSubTitle.getText(),"Manage your permissions and control what information is shared from your device.");
        validateVisibilityListOfItems(PrivacySettings_NetworkAndServices);
        AssertDisplayed(driver.findElement(By.xpath("//*[@text='Choose how our app uses your data']")).isDisplayed());
        validateVisibilityListOfItems(PrivacySettings_CookiePermissions);
        AssertDisplayed(driver.findElement(By.xpath("//*[@text='Choose how our app uses your data ']")).isDisplayed());
        validateVisibilityListOfItems(PrivacySettings_DevicePermissions);
        AssertDisplayed(driver.findElement(By.xpath("//*[@text='Update the permissions for this app on your device']")).isDisplayed());
        validateVisibilityListOfItems(PrivacySettings_VodafonePrivacyInformation);
        AssertDisplayed(driver.findElement(By.xpath("//*[@text='Check out our privacy and cookie policies']")).isDisplayed());

        // Assert on chevrons after scroll
        List<WebElement> chevronsSecondView = driver.findElements(By.id("com.myvodafoneapp:id/settingsItemChevron"));
        int numOfChevronsSecondView = chevronsSecondView.size();
        Assert.assertEquals(numOfChevronsFirstView,numOfChevronsSecondView);
        Assert.assertEquals(numOfChevronsSecondView+remainChevrons,num);

        // Assert on icons after scroll
        List<WebElement> iconsSecondView = driver.findElements(By.id("com.myvodafoneapp:id/settingsItemIcon"));
        int numOfIconsSecondView = iconsSecondView.size();
        Assert.assertEquals(numOfIconsFirstView,numOfIconsSecondView);
        Assert.assertEquals(numOfIconsSecondView+remainIcons,num);


    }

    public void CheckNavigationtoPrivacySettings(){
        waitForVisibility(SettingsTitle);
        AssertResult(SettingsTitle.getText(),"Privacy Settings");
    }
    public void validateVisibilityListOfItems(WebElement element){
        try{
            element.isDisplayed();
        }
        catch(Exception E){
            System.out.println("element is not displayed");
            scrollDown();
        }
        AssertDisplayed(element.isDisplayed());
    }

    public void OpenPrivacySettings(){
        waitForVisibility(DB_PrivacySetting);
        DB_PrivacySetting.click();
    }

    public void PrivacyInformationEntryPoint() {
        try {
            waitForVisibility(PrivacySettings_VodafonePrivacyInformation);
        }
        catch (Exception e) {
            scrollDown();
        }
        PrivacySettings_VodafonePrivacyInformation.click();
    }

    public void NavigateToVodafonePrivacyPortalScreen() {
        waitForVisibility(AppPrivacySupplementCTA);
        Assert.assertEquals(driver.findElement(PrivacyInfoScreenTitle).getText(), "Vodafone Privacy Information");
        AssertDisplayed(ManageCookiesBack.isDisplayed());
        Assert.assertEquals(driver.findElement(PrivacyPortalScreenHeader).getText(), "Privacy and cookie policies");
        Assert.assertEquals(driver.findElement(AppPrivacySupplementCTA).getText(), "App Privacy Supplement");
        Assert.assertEquals(driver.findElement(CookiePolicyCTA).getText(), "Cookie policy");
        Assert.assertEquals(driver.findElement(PrivacyPortalCTA).getText(), "Privacy portal");

        for (int i = 0; i < driver.findElements(PrivacyInfoChevrons).size(); i++) {
            AssertDisplayed(driver.findElements(PrivacyInfoChevrons).get(i).isDisplayed());
        }
    }

    public void OpenCookiePermissions(){
        waitForVisibility(PrivacySettings_CookiePermissions);
        PrivacySettings_CookiePermissions.click();
    }
    public void ClickOnNetworkAndService(){
        validateVisibilityListOfItems(PrivacySettings_NetworkAndServices);
        PrivacySettings_NetworkAndServices.click();
    }

    public void ValidateNetworkImprovementsToggleStateFromSettings(String state){
        waitForVisibility(NetworkImprovementsToggleFromSettings_ANDROID);
        Assert.assertTrue(driver.findElement(NetworkImprovementsToggleFromSettings_ANDROID).getText().equalsIgnoreCase(state));
        if(state.equalsIgnoreCase("ON")){
            try{
                waitForVisibility(ShareMyCustomerProfile_ANDROID);
            }
            catch (Exception e){
                scrollDown();
            }
            AssertResult(driver.findElement(NetworkAndServicesSecondCardTitle_ANDROID).getText(),"Choose to share your data anonymously or include your customer profile.");
            AssertDisplayed(driver.findElement(NetworkAndServicesSecondCardlogo_ANDROID).isDisplayed());
            AssertDisplayed(driver.findElement(ShareAnonymously_ANDROID).isDisplayed());
            AssertDisplayed(driver.findElement(ShareMyCustomerProfile_ANDROID).isDisplayed());
        } else if (state.equalsIgnoreCase("OFF")) {
            assertElementDoesNotExist(NetworkAndServicesSecondCardTitle_ANDROID);
            assertElementDoesNotExist(NetworkAndServicesSecondCardlogo_ANDROID);
            assertElementDoesNotExist(ShareAnonymously_ANDROID);
            assertElementDoesNotExist(ShareMyCustomerProfile_ANDROID);
        }
    }

    public void ToggleNetworkImprovementsFromSettings(String state){
        waitForVisibility(NetworkImprovementsToggleFromSettings_ANDROID);
        if(!(driver.findElement(NetworkImprovementsToggleFromSettings_ANDROID).getText().equalsIgnoreCase(state))){
            driver.findElement(NetworkImprovementsToggleFromSettings_ANDROID).click();
        }
    }

    public void ValidateNetworkAndServiceScreenFromSettingsWithoutLink(){
        waitForVisibility(DX_IDM_welcomeFlowTitle);
        AssertResult(DX_IDM_welcomeFlowTitle.getText(),"Network and Service");
        AssertResult(driver.findElement(NetworkAndServicesTitle_ANDROID).getText(),"Network and Service");
        AssertResult(driver.findElement(NetworkAndServicesDes_ANDROID).getText(),"Choose how our app uses your data.\n" +
                "\n" +
                "By accepting, you agree to us using your data according to our App Privacy Supplement");
        assertElementDoesNotExist(Bluebanner_ANDROID);
        AssertDisplayed(driver.findElement(NetworkImprovementsCardIcon_ANDROID).isDisplayed());
        AssertResult(driver.findElement(NetworkImprovementsCardTitle_ANDROID).getText(),"Network Improvements");
        AssertResult(driver.findElement(NetworkImprovementsCardDes_ANDROID).getText(),"By sharing your network and device performance information, you help us to improve our connectivity and services in your area. This data can’t be traced back to you.");
    }

    public void ValidateNetworkAndServiceScreenFromSettingsWithLink(){
        waitForVisibility(DX_IDM_welcomeFlowTitle);
        AssertResult(DX_IDM_welcomeFlowTitle.getText(),"Network and Service");
        AssertResult(driver.findElement(NetworkAndServicesTitle_ANDROID).getText(),"Network and Service");
        AssertResult(driver.findElement(NetworkAndServicesDes_ANDROID).getText(),"Choose how our app uses your data.\n" +
                "\n" +
                "By accepting, you agree to us using your data according to our App Privacy Supplement");
        AssertDisplayed(driver.findElement(Bluebanner_ANDROID).isDisplayed());
        AssertDisplayed(driver.findElement(NetworkImprovementsCardIcon_ANDROID).isDisplayed());
        AssertResult(driver.findElement(NetworkImprovementsCardTitle_ANDROID).getText(),"Network Improvements");
        AssertResult(driver.findElement(NetworkImprovementsCardDes_ANDROID).getText(),"By sharing your network and device performance information, you help us to improve our connectivity and services in your area. This data can’t be traced back to you.");
    }
    public void clickOnEnablePerformanceCookiesLinkFromSettings(){
        TouchAction touchAction = new TouchAction((PerformsTouchActions) driver);
        waitForVisibility(PerformenceCookieLink_ANDROID);
        Point point = driver.findElement(PerformenceCookieLink_ANDROID).getLocation();
        int x = (int) ( point.getX() + (driver.findElement(PerformenceCookieLink_ANDROID).getSize().width * 0.8 ));
        int y = (int) (point.getY() + (driver.findElement(PerformenceCookieLink_ANDROID).getSize().height * 0.8));
        touchAction.tap(PointOption.point(x,y)).perform();
    }


    public void ClickOnTheBackIconForSettingsScreens() {
        ManageCookiesBack.click();
    }

    public void ClickOnAppPrivacySupplementCTA() {
        driver.findElement(AppPrivacySupplementCTA).click();
    }

    public void ClickOnCookiePolicyCTA() {
        driver.findElement(CookiePolicyCTA).click();
    }

    public void ClickOnPrivacyPortalCTA() {
        driver.findElement(PrivacyPortalCTA).click();
    }

    public void ValidateNavigationToPrivacyPortalWebview(){
        waitForVisibility(PrivacyPortalWebviewTitle_ANDROID);
        AssertDisplayed(driver.findElement(PrivacyPortalWebviewDissmis_ANDROID).isDisplayed());
        AssertResult(driver.findElement(PrivacyPortalWebviewTitle_ANDROID).getText(),"vodafone.co.uk");
    }

    public void ClickOnDevicePermissionsCTA() {
        driver.findElement(DevicePermissionsCTA_ANDROID).click();
        waitForVisibility(DevicePermissionsScreenTitle_ANDROID);
    }
    public void assertionsOnPermissionsList(int i) {
        By cardTitles=By.xpath("//*[@text='"+ DevicePermissionCardTitle.get(i)+"']");
        By cardDesc=By.xpath("//*[contains(@text,'"+ DevicePermissionDescription.get(i)+"')]");
        AssertDisplayed(driver.findElement(cardTitles).isDisplayed());
        AssertDisplayed(driver.findElement(cardDesc).isDisplayed());
    }

    @Override
    public void ValidateDevicePermissionsWithEnableTargetingCookies() {
        //For OS less than 13, Notifications will not appear as it's granted by default
        AssertResult(driver.findElement(DevicePermissionsScreenTitle_ANDROID).getText(), "Device Permissions");
        AssertResult(driver.findElement(DevicePermissionsScreenDescription_ANDROID).getText(), "Update the permissions for this app on your device.");
        AssertDisplayed(driver.findElement(Bluebanner_ANDROID).isDisplayed());
        AssertResult(driver.findElement(Bluebanner_ANDROID).getText(), "To ensure that you can receive all push notifications, please enable Targeting Cookies");
        AssertDisplayed(GeneralBackIcon.isDisplayed());
        for (int i = 0; i < DevicePermissionCTA.size(); i++) {
            By cardCTAs=By.xpath("//*[@text='"+ DevicePermissionCTA.get(i)+"']");
            try {
                AssertDisplayed(driver.findElement(cardCTAs).isDisplayed());
                assertionsOnPermissionsList(i);
            } catch (Exception e) {
                scrollDownTo(cardCTAs);
                AssertDisplayed(driver.findElement(cardCTAs).isDisplayed());
                assertionsOnPermissionsList(i);
            }
        }
        scrollUp();
    }
        public void clickOnEnableTargetingCookiesLinkFromSettings() {
        TouchAction touchAction = new TouchAction((PerformsTouchActions) driver);
        waitForVisibility(PerformenceCookieLink_ANDROID);
        Point point = driver.findElement(PerformenceCookieLink_ANDROID).getLocation();
        int x = (int) (point.getX() + (driver.findElement(PerformenceCookieLink_ANDROID).getSize().width * 0.8));
        int y = (int) (point.getY() + (driver.findElement(PerformenceCookieLink_ANDROID).getSize().height * 0.8));
        touchAction.tap(PointOption.point(x, y)).perform();
    }

    public void validateAllDevicePermissionsAreEnabled() {
        // assert only for first two cards because of Usage card
        Assert.assertEquals(DevicePermissionsLozenges.get(0).getText(),"Enabled");
        try{
            Assert.assertEquals(DevicePermissionsLozenges.get(1).getText(),"Enabled");
        } catch (Exception e){
            scrollDownTo(DevicePermissionsLozenges.get(1));
            Assert.assertEquals(DevicePermissionsLozenges.get(1).getText(),"Enabled");
        }
    }

    @Override
    public void ValidateDevicePermissionsWithoutEnableTargetingCookies() {
        //For OS less than 13, Notifications will not appear as it's granted by default
        AssertResult(driver.findElement(DevicePermissionsScreenTitle_ANDROID).getText(), "Device Permissions");
        AssertResult(driver.findElement(DevicePermissionsScreenDescription_ANDROID).getText(), "Update the permissions for this app on your device.");
        assertElementDoesNotExist(Bluebanner_ANDROID);
        AssertDisplayed(GeneralBackIcon.isDisplayed());
        for (int i = 0; i < DevicePermissionCTA.size(); i++) {
            By cardCTAs=By.xpath("//*[@text='"+ DevicePermissionCTA.get(i)+"']");
            try {
                AssertDisplayed(driver.findElement(cardCTAs).isDisplayed());
                assertionsOnPermissionsList(i);
            } catch (Exception e) {
                scrollDownTo(cardCTAs);
                AssertDisplayed(driver.findElement(cardCTAs).isDisplayed());
                assertionsOnPermissionsList(i);
            }
        }
        scrollUp();
    }
}








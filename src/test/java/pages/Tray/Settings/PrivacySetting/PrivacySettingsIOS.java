package pages.Tray.Settings.PrivacySetting;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import models.response.SegmentResponseModel;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.Tray.Settings.AccountSetting.SettingsDrawerAndAccountSettingsIOS;
import utils.SegmentUtils;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import static core.Config.getUnknownUser;
import static utilities.PropertiesLoader.readEnv;
import static utilities.PropertiesLoader.readPropertyFile;
import static utils.element_helpers.ScrollHelpers.*;
import static utils.element_helpers.VerifyHelpers.*;
import static utils.element_helpers.VerifyHelpers.assertElementDoesNotExist;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

public class PrivacySettingsIOS extends PrivacySettingsAbstract {

    SettingsDrawerAndAccountSettingsIOS accountSettings;
    SegmentResponseModel  segmetResponseModel ;
    Boolean live = System.getProperty("isLiveTest", readEnv("isLiveTest")).equalsIgnoreCase("true");
    By NetworkImprovementsToggleFromSettings_IOS = By.id("toggle");
    By NetworkAndServicesTitle_IOS = By.id("Welcome_to_My_Vodafone_Title");
    By NetworkAndServicesSubTitle_IOS = By.id("Choose how our app uses your data.");
    By NetworkAndServicesDes_IOS = By.id("By accepting, you agree to us using your data according to our App Privacy Supplement");
    By NetworkAndServicesBanner_IOS = By.xpath("//*[@name='notificationViewText']");
    By NetworkAndServicesBannerDes_IOS = By.id("To ensure that your network and device performance information can be successfully shared, please enable Performance Cookies");
    By NetworkAndServicesBannerlogo_IOS = By.id("notificationViewIcon");
    By NetworkImprovementsCardIcon_IOS = By.id("ic_network_and_service");
    By NetworkImprovementsCardTitle_IOS = By.id("Network Improvements");
    By NetworkImprovementsCardDes_IOS = By.id("By sharing your network and device performance information, you help us to improve our connectivity and services in your area. This data can’t be traced back to you.");
    By NetworkAndServicesSecondCardTitle_IOS = By.id("Choose to share your data anonymously or include your customer profile.");
    By NetworkAndServicesSecondCardlogo_IOS = By.id("ic_vodafone_privacy_info");
    By ShareAnonymously_IOS = By.id("Share anonymously");
    By ShareMyCustomerProfile_IOS = By.id("Share my customer profile");
    By PerformenceCookieLink_IOS = By.id("Performance Cookies");
    By PrivacyInfoScreenTitle = By.name("txtScreenTitleLabel");
    By PrivacyPortalScreenHeader = By.name("Privacy and cookie policies");
    By AppPrivacySupplementCTA = By.name("App Privacy Supplement");
    By CookiePolicyCTA = By.name("Cookie policy");
    By PrivacyPortalCTA = By.name("Privacy portal");
    By PrivacyInfoChevrons = By.xpath("//XCUIElementTypeTable/XCUIElementTypeCell");
    By PrivacyPortalWebviewDone_IOS = By.id("Done");
    By PrivacyPortalWebviewTitle_IOS = By.id("URL");
    By DevicePermissionsCTA_IOS = By.id("Device permissions");
    By WelcomeTitle_IOS = By.id("Welcome_to_My_Vodafone_Title");
    By DevicePermissionsScreenDescription_IOS = By.id("Update the permissions for this app on your device.");
    By NotificationTitle_IOS= By.id("Notifications");
    By ShareLocationTitle_IOS= By.id("Share location");
    By NotificationsPermissionsDesc_IOS = By.xpath("(//*[@name='txtPermissionDescription'])[1]");
    By LocationPermissionsDesc_IOS = By.xpath("(//*[@name='txtPermissionDescription'])[2]");
    By ManageNotificationCTA_IOS = By.id("Manage notifications");
    By ManageLocationCTA_IOS = By.id("Manage location settings");
    By TargetingCookiesLink_IOS = By.xpath("//XCUIElementTypeLink[@name='Targeting Cookies']");
    By TargetingCookiesLinkDesc_IOS = By.id("To ensure that you can receive all push notifications, please enable Targeting Cookies");
    By x_close_from_privacy = By.xpath("//XCUIElementTypeButton[@name='closeIcon']");
    List<WebElement> DevicePermissionsLozenges_IOS = driver.findElements(By.id("XXXX"));


    public PrivacySettingsIOS() throws IOException {
        super();
        if(!live) {
            segmetResponseModel = SegmentUtils.GetSegment();
            accountSettings = new SettingsDrawerAndAccountSettingsIOS();
        }
    }


    public void navigateToPrivacyScreen() {
        clickOnSettingsInTray();
        if(getUnknownUser().equalsIgnoreCase("false")) {
            SwipeToElement(DefaultOffer_Description, "Right");
        }
        clickOnPrivacySettings();
    }

    public void validatePrivacySettingsItems() {
        if (live) {
            AssertResult(PS_MarketingPermissionsOption.getText(), "Marketing preferences");
            waitForVisibility(x_close_from_privacy);
            driver.findElement(x_close_from_privacy).click();
        } else {
            PrivacyCommanItems();
            Properties envProp = readPropertyFile("config/env.properties");
            String segment = segmetResponseModel.segment;
            if (envProp.getProperty("UnknownUser").equalsIgnoreCase("true")) {
                assertElementDoesNotExist(PS_MarketingPermissionsOption);
            } else if (segment.equalsIgnoreCase("CONSUMER") || segment.equalsIgnoreCase("SMB") || segment.equalsIgnoreCase("SOLETRADER")) {
                AssertResult(PS_MarketingPermissionsOption.getText(), "Marketing preferences");
            }
            waitForVisibility(x_close_from_privacy);
            driver.findElement(x_close_from_privacy).click();
        }
    }

    public void validatePrivacySettingsItemsForAcq() {
        PrivacyCommanItems();
        PS_DismissButton.click();
    }

    public void PrivacyCommanItems() {
        waitForVisibility(PS_AppPrivacyOption);
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
        AssertResult(PS_AppPrivacyTailoredServiceTitle.getText(), "Tailored service and recommendations");
        AssertDisplayed(PS_AppPrivacyTailoredServiceDescription.isDisplayed());
        scrollDownTo(PS_AppPrivacyNetworkOptimisationDescription);
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

        if((readEnv("UnknownUser").equalsIgnoreCase("true")) ||
                ((segmetResponseModel.segment.equalsIgnoreCase("PREPAY")) && (!(segmetResponseModel.subscriptionType.name.equalsIgnoreCase("HYBRID")) ))) {
            assertElementDoesNotExist(PS_MarketingPermissionsOption);
            numberOfItems = 4;
        } else {
            validateVisibilityListOfItems(PS_MarketingPermissionsOption);
            AssertDisplayed(driver.findElement(By.id("Choose how you’d like to hear from us about our latest products, offers and rewards")).isDisplayed());
            AssertDisplayed(driver.findElement(By.id("card_arrow_3")).isDisplayed());
            AssertDisplayed(driver.findElement(By.id("card_logo_3")).isDisplayed());

        }
        validateCommonUIOfPrivacySettings(numberOfItems);
        // validate back behavior
        SO_Xicon.click();
        waitForVisibility(DB_SettingDashboardTray_icon);
        AssertDisplayed(DB_SettingDashboardTray_icon.isDisplayed());
    }
    public void validateCommonUIOfPrivacySettings(int num){

        waitForVisibility(AppAppPrivacySupplementHeader);
        AssertResult(AppAppPrivacySupplementHeader.getText(),"Settings");
        AssertDisplayed(SO_Xicon.isDisplayed());

        AssertDisplayed(driver.findElement(By.id("Privacy Settings")).isDisplayed());
        AssertDisplayed(driver.findElement(By.id("Manage your permissions and control what information is shared from your device.")).isDisplayed());

        validateVisibilityListOfItems(PrivacySettings_NetworkAndServices);
        AssertDisplayed(driver.findElement(By.id("Choose how our app uses your data")).isDisplayed());
        AssertDisplayed(driver.findElement(By.id("card_arrow_0")).isDisplayed());
        AssertDisplayed(driver.findElement(By.id("card_logo_0")).isDisplayed());

        validateVisibilityListOfItems(PrivacySettings_CookiePermissions);
        AssertDisplayed(driver.findElement(By.id("Choose how our app uses your data ")).isDisplayed());
        AssertDisplayed(driver.findElement(By.id("card_arrow_1")).isDisplayed());
        AssertDisplayed(driver.findElement(By.id("card_logo_1")).isDisplayed());

        validateVisibilityListOfItems(PrivacySettings_DevicePermissions);
        AssertDisplayed(driver.findElement(By.id("Update the permissions for this app on your device")).isDisplayed());
        AssertDisplayed(driver.findElement(By.id("card_arrow_2")).isDisplayed());
        AssertDisplayed(driver.findElement(By.id("card_logo_2")).isDisplayed());

        validateVisibilityListOfItems(PrivacySettings_VodafonePrivacyInformation);
        AssertDisplayed(driver.findElement(By.id("Check out our privacy and cookie policies")).isDisplayed());
        AssertDisplayed(driver.findElement(By.id("card_arrow_"+(num-1))).isDisplayed());
        AssertDisplayed(driver.findElement(By.id("card_logo_"+(num-1))).isDisplayed());

    }

    public void CheckNavigationtoPrivacySettings(){
        waitForVisibility(SO_Xicon);
        AssertDisplayed(driver.findElement(By.id("Privacy Settings")).isDisplayed());
    }
    public void validateVisibilityListOfItems(WebElement element){

        scrollDownTo(element);
        AssertDisplayed(element.isDisplayed());
    }

    public void OpenPrivacySettings(){
        waitForVisibility(DB_PrivacySetting);
        DB_PrivacySetting.click();
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
        waitForVisibility(NetworkImprovementsToggleFromSettings_IOS);
        Assert.assertTrue(driver.findElement(NetworkImprovementsToggleFromSettings_IOS).getAttribute("value").equalsIgnoreCase(state));
        if(state.equalsIgnoreCase("ON")){
            waitForVisibility(NetworkAndServicesSecondCardTitle_IOS);
            AssertDisplayed(driver.findElement(NetworkAndServicesSecondCardTitle_IOS).isDisplayed());
            AssertDisplayed(driver.findElement(NetworkAndServicesSecondCardlogo_IOS).isDisplayed());
            AssertDisplayed(driver.findElement(ShareAnonymously_IOS).isDisplayed());
            AssertDisplayed(driver.findElement(ShareMyCustomerProfile_IOS).isDisplayed());
        } else if (state.equalsIgnoreCase("OFF")) {
            assertElementDoesNotExist(NetworkAndServicesSecondCardTitle_IOS);
            assertElementDoesNotExist(NetworkAndServicesSecondCardlogo_IOS);
            assertElementDoesNotExist(ShareAnonymously_IOS);
            assertElementDoesNotExist(ShareMyCustomerProfile_IOS);
        }
    }

    public void ToggleNetworkImprovementsFromSettings(String state){
        waitForVisibility(NetworkImprovementsToggleFromSettings_IOS);
        if(!(driver.findElement(NetworkImprovementsToggleFromSettings_IOS).getAttribute("value").equalsIgnoreCase(state))){
            driver.findElement(NetworkImprovementsToggleFromSettings_IOS).click();
        }
    }

    public void ValidateNetworkAndServiceScreenFromSettingsWithoutLink(){
        waitForVisibility(DX_IDM_welcomeFlowTitle);
        AssertResult(DX_IDM_welcomeFlowTitle.getAttribute("value"),"Network and Service");
        AssertResult(driver.findElement(NetworkAndServicesTitle_IOS).getAttribute("value"),"Network and Service");
        AssertDisplayed(driver.findElement(NetworkAndServicesSubTitle_IOS).isDisplayed());
        AssertDisplayed(driver.findElement(NetworkAndServicesDes_IOS).isDisplayed());
        assertElementDoesNotExist(NetworkAndServicesBanner_IOS);
        AssertDisplayed(driver.findElement(NetworkImprovementsCardIcon_IOS).isDisplayed());
        AssertDisplayed(driver.findElement(NetworkImprovementsCardTitle_IOS).isDisplayed());
        AssertDisplayed(driver.findElement(NetworkImprovementsCardDes_IOS).isDisplayed());
    }

    public void ValidateNetworkAndServiceScreenFromSettingsWithLink(){
        waitForVisibility(DX_IDM_welcomeFlowTitle);
        AssertResult(DX_IDM_welcomeFlowTitle.getAttribute("value"),"Network and Service");
        AssertResult(driver.findElement(NetworkAndServicesTitle_IOS).getAttribute("value"),"Network and Service");
        AssertDisplayed(driver.findElement(NetworkAndServicesSubTitle_IOS).isDisplayed());
        AssertDisplayed(driver.findElement(NetworkAndServicesDes_IOS).isDisplayed());
        AssertDisplayed(driver.findElement(NetworkAndServicesBanner_IOS).isDisplayed());
        AssertDisplayed(driver.findElement(NetworkAndServicesBannerDes_IOS).isDisplayed());
        AssertDisplayed(driver.findElement(NetworkAndServicesBannerlogo_IOS).isDisplayed());
        AssertDisplayed(driver.findElement(NetworkImprovementsCardIcon_IOS).isDisplayed());
        AssertDisplayed(driver.findElement(NetworkImprovementsCardTitle_IOS).isDisplayed());
        AssertDisplayed(driver.findElement(NetworkImprovementsCardDes_IOS).isDisplayed());
    }

    public void clickOnEnablePerformanceCookiesLinkFromSettings(){
        waitForVisibility(PerformenceCookieLink_IOS);
        driver.findElement(PerformenceCookieLink_IOS).click();
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
        Assert.assertEquals(driver.findElement(PrivacyInfoScreenTitle).getText(),"Vodafone Privacy Information");
        AssertDisplayed(ManageCookiesBack.isDisplayed());
        Assert.assertEquals(driver.findElement(PrivacyPortalScreenHeader).getText(),"Privacy and cookie policies");
        Assert.assertEquals(driver.findElement(AppPrivacySupplementCTA).getText(),"App Privacy Supplement");
        Assert.assertEquals(driver.findElement(CookiePolicyCTA).getText(),"Cookie policy");
        Assert.assertEquals(driver.findElement(PrivacyPortalCTA).getText(),"Privacy portal");

        for(int i=0 ; i < driver.findElements(PrivacyInfoChevrons).size() ; i++){

            AssertDisplayed(driver.findElements(PrivacyInfoChevrons).get(i).isDisplayed());
        }
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
        waitForVisibility(PrivacyPortalWebviewTitle_IOS);
        AssertDisplayed(driver.findElement(PrivacyPortalWebviewDone_IOS).isDisplayed());
        Assert.assertTrue(driver.findElement(PrivacyPortalWebviewTitle_IOS).getAttribute("value").contains("vodafone.co.uk, secure and validated"));
    }
    public void ClickOnDevicePermissionsCTA() {
        driver.findElement(DevicePermissionsCTA_IOS).click();
        waitForVisibility(WV_Title);
        AssertResult(WV_Title.getText(), "Device Permissions");
    }
    public void clickOnEnableTargetingCookiesLinkFromSettings() {
        TouchAction touchAction = new TouchAction((PerformsTouchActions) driver);
        waitForVisibility(TargetingCookiesLinkDesc_IOS);
        Point point = driver.findElement(TargetingCookiesLinkDesc_IOS).getLocation();
        int x = (int) ( point.getX() + (driver.findElement(TargetingCookiesLinkDesc_IOS).getSize().width * 0.8));
        int y = (int) (point.getY() + (driver.findElement(TargetingCookiesLinkDesc_IOS).getSize().height * 0.3));
        touchAction.tap(PointOption.point(x,y)).perform();
    }

    @Override
    public void validateAllDevicePermissionsAreEnabled() {
        for (int i = 0; i < DevicePermissionsLozenges_IOS.size(); i++){

            try{
                Assert.assertEquals(DevicePermissionsLozenges_IOS.get(i).getText(),"Enabled");
            } catch (Exception e){
                scrollDownTo(DevicePermissionsLozenges_IOS.get(i));
                Assert.assertEquals(DevicePermissionsLozenges_IOS.get(i).getText(),"Enabled");
            }
        }
    }

    @Override
    public void ValidateDevicePermissionsWithEnableTargetingCookies() {
        AssertResult(driver.findElement(WelcomeTitle_IOS).getText(), "Device Permissions");
        AssertDisplayed(GeneralBackIcon.isDisplayed());
        AssertResult(driver.findElement(DevicePermissionsScreenDescription_IOS).getText(), "Update the permissions for this app on your device.");
        AssertDisplayed(driver.findElement(TargetingCookiesLink_IOS).isDisplayed());
        AssertDisplayed(driver.findElement(TargetingCookiesLinkDesc_IOS).isDisplayed());
        AssertResult(driver.findElement(NotificationTitle_IOS).getText(), "Notifications");
        AssertResult(driver.findElement(ShareLocationTitle_IOS).getText(), "Share location");
        System.out.println(driver.findElement(NotificationsPermissionsDesc_IOS).getText());
        AssertResult(driver.findElement(NotificationsPermissionsDesc_IOS).getText(), "Tell us if you’d like to receive notifications from the app. We can share useful updates on your bills and data allowance.");
        AssertResult(driver.findElement(LocationPermissionsDesc_IOS).getText(), "Choose to share your location with the app. This helps us find products and offers to suit you, and improves your experience in the app.");
        AssertResult(driver.findElement(ManageNotificationCTA_IOS).getText(), "Manage notifications");
        AssertResult(driver.findElement(ManageLocationCTA_IOS).getText(), "Manage location settings");
    }
    @Override
    public void ValidateDevicePermissionsWithoutEnableTargetingCookies() {
        AssertDisplayed(WV_Title.isDisplayed());
        AssertResult(driver.findElement(WelcomeTitle_IOS).getText(), "Device Permissions");
        AssertDisplayed(GeneralBackIcon.isDisplayed());
        AssertResult(driver.findElement(DevicePermissionsScreenDescription_IOS).getText(), "Update the permissions for this app on your device.");
        assertElementDoesNotExist(TargetingCookiesLink_IOS);
        AssertResult(driver.findElement(NotificationTitle_IOS).getText(), "Notifications");
        AssertResult(driver.findElement(ShareLocationTitle_IOS).getText(), "Share location");
        AssertResult(driver.findElement(NotificationsPermissionsDesc_IOS).getText(), "Tell us if you’d like to receive notifications from the app. We can share useful updates on your bills and data allowance.");
        AssertResult(driver.findElement(LocationPermissionsDesc_IOS).getText(), "Choose to share your location with the app. This helps us find products and offers to suit you, and improves your experience in the app.");
        AssertResult(driver.findElement(ManageNotificationCTA_IOS).getText(), "Manage notifications");
        AssertResult(driver.findElement(ManageLocationCTA_IOS).getText(), "Manage location settings");
    }

}








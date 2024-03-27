package pages.RedHybrid.AppAndPrivacySettings;

import models.response.DashboardV4ResponseModel;
import org.openqa.selenium.By;
import org.testng.Assert;
import utils.DashboardUtils;

import static utilities.PropertiesLoader.readEnv;
import static utils.element_helpers.ScrollHelpers.SwipeToElement;
import static utils.element_helpers.VerifyHelpers.AssertDisplayed;
import static utils.element_helpers.VerifyHelpers.assertEquals;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

public class AppAndPrivacySettingsAndroid extends AppAndPrivacySettingsAbstract{

    DashboardV4ResponseModel dashboardV4ResponseModel;
    private final By privacy_settings = By.xpath("//android.widget.TextView[contains(@resource-id, 'com.myvodafoneapp:id/txtPlanListItemTitle') and @text='Privacy settings']");
    private final By app_settings = By.xpath("//android.widget.TextView[contains(@resource-id, 'com.myvodafoneapp:id/txtPlanListItemTitle') and @text='App settings']");
    private final By app_settings_title = By.xpath("//android.widget.TextView[contains(@resource-id, 'com.myvodafoneapp:id/settingsSectionTitle') and @text='App Settings']");

    Boolean live = System.getProperty("isLiveTest", readEnv("isLiveTest")).equalsIgnoreCase("true");


    @Override
    public void clickOnSettingIcon() {
        waitForVisibility(settingsIcon);
        settingsIcon.click();
    }

    @Override
    public void settingsDrawer(){
        dashboardV4ResponseModel = DashboardUtils.GetDashboard();
        waitForVisibility(settingsDrawerTitle);
        Assert.assertTrue(settingsDrawerTitle.isDisplayed());
        Assert.assertTrue(dashboardV4ResponseModel.settingsDrawer.cards.get(0).name.equalsIgnoreCase("App"));
        Assert.assertTrue(dashboardV4ResponseModel.settingsDrawer.cards.get(1).name.equalsIgnoreCase("account"));
        Assert.assertTrue(dashboardV4ResponseModel.settingsDrawer.cards.get(2).name.equalsIgnoreCase("privacy"));

    }

    @Override
    public void clickOnAppSettingIcon() {
        waitForVisibility(settingsDrawerTitle);
        driver.findElement(app_settings).click();
        waitForVisibility(app_settings_title);
        Assert.assertTrue(driver.findElement(app_settings_title).isDisplayed());
    }

    @Override
    public void checkUIOfAppSettings() {
        dashboardV4ResponseModel = DashboardUtils.GetDashboard();
        waitForVisibility(appSettingsScreenTitle);
        Assert.assertTrue(resetTheAppLink.isDisplayed());
        Assert.assertTrue(loginOptionsLink.isDisplayed());
        Assert.assertTrue(devicePermissionsLink.isDisplayed());
        Assert.assertTrue(termsAndConditionsLink.isDisplayed());

        assertEquals(resetTheAppLink.getText(),
                    dashboardV4ResponseModel.settingItems.get(0).subItems.get(0).title);
        assertEquals(loginOptionsLink.getText(),
                dashboardV4ResponseModel.settingItems.get(0).subItems.get(1).title);
        assertEquals(devicePermissionsLink.getText(),
                dashboardV4ResponseModel.settingItems.get(0).subItems.get(2).title);
        assertEquals(termsAndConditionsLink.getText(),
                dashboardV4ResponseModel.settingItems.get(0).subItems.get(3).title);

        assertEquals(dashboardV4ResponseModel.settingItems.get(0).subItems.get(0).journeyKey, "SETTINGS_RESET_APP");
        assertEquals(dashboardV4ResponseModel.settingItems.get(0).subItems.get(1).journeyKey, "LOGIN_OPTIONS_DXIDM");
        assertEquals(dashboardV4ResponseModel.settingItems.get(0).subItems.get(2).journeyKey, "DEVICE_PERMISSIONS");
        assertEquals(dashboardV4ResponseModel.settingItems.get(0).subItems.get(3).journeyKey, "TERMS_AND_CONDITIONS_SETTINGS");

        assertEquals(4, dashboardV4ResponseModel.settingItems.get(0).subItems.size());
    }

    @Override
    public void clickOnResetAppLink() {
        waitForVisibility(app_settings_title);
        resetTheAppLink.click();
    }

    @Override
    public void checkResetAppScreen() {
        waitForVisibility(resetTheAppScreenTitle);
        Assert.assertTrue(resetTheAppScreenTitle.isDisplayed());
        Assert.assertTrue(resetCTA.isDisplayed());
    }

    @Override
    public void clickOnLoginOptionsLink() {
        waitForVisibility(app_settings_title);
        loginOptionsLink.click();
    }

    @Override
    public void checkLoginOptionsScreen() {
        waitForVisibility(loginOptionsScreenTitle);
        Assert.assertTrue(loginOptionsScreenTitle.isDisplayed());
        Assert.assertTrue(loginOptions.isDisplayed());
    }

    @Override
    public void clickOnDevicePermissionsLink() {
        waitForVisibility(appSettingsScreenTitle);
        devicePermissionsLink.click();
    }

    @Override
    public void checkDevicePermissionsScreen() {
        waitForVisibility(devicePermissionsScreenTitle);
        Assert.assertTrue(devicePermissionsScreenTitle.isDisplayed());
        Assert.assertTrue(devicePermissionsScreenCTA.isDisplayed());
    }

    @Override
    public void clickOnTermsAndConditionsLink() {
        waitForVisibility(appSettingsScreenTitle);
        termsAndConditionsLink.click();
    }

    @Override
    public void checkTermsAndConditionsScreen() {
        waitForVisibility(termsAndConditionsScreenTitle);
        Assert.assertTrue(termsAndConditionsScreenTitle.isDisplayed());
        Assert.assertTrue(TAndCDescription.isDisplayed());
    }

    @Override
    public void clickOnPrivacySettingIcon() {
        if(live){
            waitForVisibility(settingsIcon);
            waitForVisibility(privacy_settings);
            driver.findElement(privacy_settings).click();
        }else {
            waitForVisibility(settingsIcon);
            SwipeToElement(accountSettingsIcon, "Right");
            SwipeToElement(privacySettingsIcon, "Right");
            waitForVisibility(privacySettingsIcon);
            privacySettingsIcon.click();
        }
    }

    @Override
    public void checkPrivacySettingsScreen() {
        dashboardV4ResponseModel = DashboardUtils.GetDashboard();
        waitForVisibility(privacySettingsScreenTitle);
        Assert.assertTrue(appPrivacyLink.isDisplayed());
        Assert.assertTrue(marketingPreferencesLink.isDisplayed());
        Assert.assertTrue(appPrivacySupplementLink.isDisplayed());
        Assert.assertTrue(vodafonePrivacyPortalLink.isDisplayed());

        assertEquals(appPrivacyLink.getText(),
                dashboardV4ResponseModel.settingItems.get(1).subItems.get(0).title);
        assertEquals(marketingPreferencesLink.getText(),
                dashboardV4ResponseModel.settingItems.get(1).subItems.get(1).title);
        assertEquals(appPrivacySupplementLink.getText(),
                dashboardV4ResponseModel.settingItems.get(1).subItems.get(2).title);
        assertEquals(vodafonePrivacyPortalLink.getText(),
                dashboardV4ResponseModel.settingItems.get(1).subItems.get(3).title);

        assertEquals(dashboardV4ResponseModel.settingItems.get(1).subItems.get(0).journeyKey, "SPEED_CHECKER_SETTINGS");
        assertEquals(dashboardV4ResponseModel.settingItems.get(1).subItems.get(1).journeyKey, "PRIVACY_PERMISSIONS");
        assertEquals(dashboardV4ResponseModel.settingItems.get(1).subItems.get(2).journeyKey, "PRIVACY_SUPPLEMENT");
        assertEquals(dashboardV4ResponseModel.settingItems.get(1).subItems.get(3).journeyKey, "VODAFONE_PRIVACY");


        assertEquals(4, dashboardV4ResponseModel.settingItems.get(1).subItems.size());
    }


    @Override
    public void clickOnMarketingPreferencesLink() {
        waitForVisibility(privacySettingsScreenTitle);
        MarketingPreferencesLink.click();
    }

    @Override
    public void checkOnMarketingPreferencesScreen() {
        waitForVisibility(WV_Xicon);
        AssertDisplayed(MarketingPreferencesScreenTitle.isDisplayed());
        WV_Xicon.click();
    }

    @Override
    public void checkAppPrivacySupplementScreen() {
        AssertDisplayed(appPrivacySupplementLink.isDisplayed());
        appPrivacySupplementLink.click();
        AssertDisplayed(appPrivacySupplementScreenTitle.isDisplayed());
        Assert.assertTrue(appPrivacySupplementScreenTitle.isDisplayed());
        Assert.assertTrue(PS_SupplementCardInfoWeCollect.isDisplayed());
    }

    @Override
    public void clickOnVodafonePrivacyPortalLink() {
        waitForVisibility(privacySettingsScreenTitle);
        vodafonePrivacyPortalLink.click();
        try {
            AssertDisplayed(AcceptCookies.isDisplayed());
            System.out.println("Cookies is appeared");
            AcceptCookies.click();
        }catch (Exception | Error e){
            System.out.println("Cookies is already accepted");
        }
    }

    @Override
    public void checkVodafonePrivacyPortalScreen() {
        waitForVisibility(vodafonePrivacyPortalScreenDismiss);
        waitForVisibility(vodafonePrivacyPortalCustomView);
        Assert.assertTrue(vodafonePrivacyPortalCustomView.isDisplayed());
        Assert.assertTrue(vodafonePrivacyPortalScreenURL.getText().contains("privacy"));
        waitForVisibility(vodafonePrivacyPortalScreenDismiss);
    }
}

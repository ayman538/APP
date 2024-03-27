package pages.Tray.Settings.AccountSetting;

import models.response.DashboardV4ResponseModel;
import models.response.SIMOptionsResponseModel;
import models.response.SegmentResponseModel;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.Tray.MyAccount.MyAccountIOS;
import pages.Tray.Settings.AppSetting.AppSettingsIOS;
import utils.DashboardUtils;
import utils.ManageMySIMOptionsUtils;
import utils.SegmentUtils;

import java.io.IOException;
import java.util.*;

import static core.Config.getLoginStatus;
import static utilities.PropertiesLoader.readPropertyFile;
import static utils.element_helpers.GenericHelpers.navigateToURL;
import static utils.element_helpers.ScrollHelpers.*;
import static utils.element_helpers.VerifyHelpers.*;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

public class SettingsDrawerAndAccountSettingsIOS extends SettingsDrawerAndAccountSettingsAbstract {

    private final MyAccountIOS subsSwitch;
    private final AppSettingsIOS AppSettings;
    Properties envProp = readPropertyFile("config/env.properties");

    By manageSIMOption(String optionName){
        return By.xpath("//XCUIElementTypeOther[@name='"+optionName+"']");
    }


    By manageSIMOptionsList = By.xpath("//XCUIElementTypeOther[2]/XCUIElementTypeTable/XCUIElementTypeCell/XCUIElementTypeStaticText");
    By manageMySIMTitle = By.id("Manage my SIM");
    By WebViewXIcon = By.id("VFGwebCloseButton");

    SIMOptionsResponseModel manageSIMResponse = ManageMySIMOptionsUtils.GetSIMOptions();



    public SettingsDrawerAndAccountSettingsIOS() throws IOException {
        super();
        subsSwitch = new MyAccountIOS();
        AppSettings = new AppSettingsIOS();
    }

    public void ValidateSettingsDrawerItems() {
        SegmentResponseModel segment= SegmentUtils.GetSegment();
        if (segment.segment.equalsIgnoreCase("PREPAY")) {
            AppSettings.clickOnSettingsInTray();
            AssertDisplayed(DB_AppSetting.isDisplayed());
            AssertDisplayed(DB_PrivacySetting.isDisplayed());
            AssertDisplayed(!IsElementDisplayed(DB_AccountSetting));
            DB_SettingsDrawerCloseButton.click();
            AssertDisplayed(!IsElementDisplayed(DB_AppSetting));
        } else {
            AppSettings.clickOnSettingsInTray();
            AssertDisplayed(DB_AppSetting.isDisplayed());
            AssertDisplayed(DB_AccountSetting.isDisplayed());
            SwipeToElement(DB_AccountSetting, "Right");
            AssertDisplayed(DB_PrivacySetting.isDisplayed());
            DB_SettingsDrawerCloseButton.click();
            AssertDisplayed(!IsElementDisplayed(DB_AppSetting));
        }

    }

    public void checkLoginStatus() {

        checkPinLoginForUserWithoutBiometrics();
        checkPinLoginForUserWithBiometrics();
        checkIfUserIsLoggedInOrNot();
    }

    public void checkIfUserIsLoggedInOrNot() {
        if (getLoginStatus().equalsIgnoreCase("False")) {
            waitForVisibility(Login_username);
            Login_Xicon.click();
        } else {
            waitForVisibility(eCare_XButton);
            eCare_XButton.click();
        }
    }

    public void checkPinLoginForUserWithoutBiometrics() {
        boolean exist = true;
        try {
            exist = Pin_Field.isDisplayed();
        } catch (Exception e) {
            exist = false;
        }
        if (exist) {
            Login_Xicon.click();
        }

    }

    public void checkPinLoginForUserWithBiometrics() {
        boolean displayed = true;

        try {
            displayed = CancelFingerPrintCTA.isDisplayed();
        } catch (Exception e) {
            displayed = false;
        }

        if (displayed) {
            CancelFingerPrintCTA.click();
            waitForVisibility(Pin_Field);
            Login_Xicon.click();
        }
    }


    public void ValidateAccountSettingsItems() {
        AppSettings.clickOnSettingsInTray();
        clickOnAccountSettings();
        clickonAccountControls();
        checkLoginStatus();

        clickOnAccountManagment();
        checkLoginStatus();

        clickOnAddressDetails();
        checkLoginStatus();

        clickOnDirectDebit();
        checkLoginStatus();

        clickOnSimSwap();
        checkLoginStatus();

        AppScreenCloseButton.click();
    }

    public void clickOnSimSwap() {
        waitForVisibility(AS_SIMSwap);
        AS_SIMSwap.click();
    }

    public void clickOnDirectDebit() {
        waitForVisibility(AS_DirectDebit);
        AS_DirectDebit.click();
    }

    public void clickOnAddressDetails() {
        waitForVisibility(AS_AddressDetails);
        AS_AddressDetails.click();
    }

    public void clickOnAccountManagment() {
        waitForVisibility(AS_ManageAccount);
        AS_ManageAccount.click();
    }

    public void clickonAccountControls() {
        waitForVisibility(AS_AccountControls);
        AS_AccountControls.click();
    }

    public void clickOnAccountSettings() {
        waitForVisibility(DB_AccountSetting);
        DB_AccountSetting.click();
    }

    //method to be called by other methods to validate account settings not displayed in settings drawer
    public void ValidateAccountSettingsNotDisplayedInDrawer() {
        AppSettings.clickOnSettingsInTray();
        AssertDisplayed(DB_AppSetting.isDisplayed());
        AssertDisplayed(DB_PrivacySetting.isDisplayed());
        AssertDisplayed(!IsElementDisplayed(DB_AccountSetting));
        DB_SettingsDrawerCloseButton.click();
    }

    public void ValidateSettingsDrawerForSubscription(String subSwitch) throws InterruptedException, ParseException, IOException {
        subsSwitch.SwitchToSubscription(subSwitch);
        ValidateAccountSettingsNotDisplayedInDrawer();

    }

    public void clickOnSettings(){
        AppSettings.clickOnSettingsInTray();
        AssertDisplayed(DB_AppSetting.isDisplayed());
        AssertDisplayed(DB_PrivacySetting.isDisplayed());
    }

    // List Reordering for Account Settings


    @Override

    public void CheckAccountSettingOrderingAndTexts()
    {
        waitForVisibility(AS_AccountSettingTittle);

        List<WebElement> AccountSettingsElements =  GetAccountSettingsElements();
        List<String> SortedAccountSettingsItems = Arrays.asList(new String[]{
                "Profile & Address",
                "Spend Manager",
                "Cards & Payments",
                "Data Notifications",
                "Activate SIM",
                "Important Documents",
                "Change my PIN",
                "Accessibility"
        });


        for(int k=0;k<getAPIAccountSettingsText().size();k++){
            try {
               scrollDownTo((AccountSettingsElements.get(k)));
           }
            catch (Exception e){
               scrollDownTo((AS_AccountSettingTittle));
            }

            Assert.assertEquals(getAPIAccountSettingsText().get(k) ,AccountSettingsElements.get(k).getText());
            Assert.assertEquals(getAPIAccountSettingsText().get(k) ,SortedAccountSettingsItems.get(k));
        }
    }
    public List<String> getAPIAccountSettingsText(){
        DashboardV4ResponseModel DashboardResponse = DashboardUtils.GetDashboard();
        List AccountSettings = DashboardResponse.settingItems.get(2).subItems;
        List<String> APIAccountSettingsText = new ArrayList<>();

        for(int j=0;j<AccountSettings.size();j++){
            if(!DashboardResponse.settingItems.get(2).subItems.get(j).title.equals("Logout")){
                APIAccountSettingsText.add(DashboardResponse.settingItems.get(2).subItems.get(j).title);
            }
        }
        return APIAccountSettingsText;
    }

    public List<WebElement> GetAccountSettingsElements(){
        List<WebElement> elements = new ArrayList<>();
        for (String text : getAPIAccountSettingsText()) {
            try {
                elements.add(driver.findElement(By.xpath("//*[@label='" + text + "']")));
            } catch (Exception e) {
                break;
            }
        }

        return elements;
    }

    @Override
    public void SpendManagerCTA() {

        waitForVisibility(SpendManagerCTA);
        SpendManagerCTA.click();
    }

    @Override
    public void SpendManagerWebView() {

        waitForVisibility(SpendManagerWebViewHeader);
        AssertDisplayed(SpendManagerWebViewHeader.isDisplayed());
    }

    @Override
    public void CardsAndPaymentsCTA() {
        CardsAndPaymentsCTA.click();
    }

    @Override
    public void ManageCardsAndPaymentsWebview() {
        waitForVisibility(ManageCardsAndPaymentWebviewHeader);
        AssertDisplayed(ManageCardsAndPaymentWebviewHeader.isDisplayed());
    }
    @Override
    public void ClickOnProfileAndAddressCTA() {
        waitForVisibility(ProfileAndAddressCTA);
        ProfileAndAddressCTA.click();
    }

    @Override
    public void ValidateProfileAndAddressWebviewIsDisplayed() {
        waitForVisibility(ProfileWebviewHeader);
        AssertDisplayed(ProfileWebviewHeader.isDisplayed());

    }

    @Override
    public void ClickOnDataNotificationsCTA() {
        waitForVisibility(DataNotificationsCTA);
        DataNotificationsCTA.click();
    }
    @Override
    public void ValidateDataNotificationsWebviewIsDisplayed() {
        waitForVisibility(DataNotificationsWebviewHeader);
        AssertDisplayed(DataNotificationsWebviewHeader.isDisplayed());
        AssertDisplayed(SSO_DataNotifications.isDisplayed());
        AssertDisplayed(SSO_SendMyAlertstoPreferredNumberCTA.isDisplayed());
    }

    @Override
    public void ActivateSimCTA() {
        waitForVisibility(ActivateSimCTA);
        ActivateSimCTA.click();
    }

    @Override
    public void ValidateActivateSimWebviewIsDisplayed() {
        waitForVisibility(ActivateSimWebviewHeader);
        AssertDisplayed(ActivateSimWebviewHeader.isDisplayed());
    }
    @Override
    public void SimSwapCTA(){
        waitForVisibility(SimSwapCTA);
        SimSwapCTA.click();
    }
    @Override
    public void ValidateSimSwapWebviewIsDisplayed() {
        waitForVisibility(SimSwapWebviewHeader);
        AssertDisplayed(SimSwapWebviewHeader.isDisplayed());
        Assert.assertEquals(SimSwapWebViewTitle.getText(),"SIM Swap");
        Assert.assertEquals(SimSwapWebviewHeader.getText(),"Swap my SIM");
    }
    public void validateSettings(){
        SegmentResponseModel segment= SegmentUtils.GetSegment();
        if (envProp.getProperty("UnknownUser").equalsIgnoreCase("true") || (segment.segment.equalsIgnoreCase("PREPAY") && !(segment.subscriptionType.name.equalsIgnoreCase("HYBRID")))){
            AppSettings.clickOnSettingsInTray();
            AssertDisplayed(DB_AppSetting.isDisplayed());
            AssertDisplayed(DB_PrivacySetting.isDisplayed());
            AssertDisplayed(!IsElementDisplayed(DB_AccountSetting));
            AssertDisplayed(DB_SettingsDrawerCloseButton.isDisplayed());
        } else {
            AppSettings.clickOnSettingsInTray();
            AssertDisplayed(DB_AppSetting.isDisplayed());
            AssertDisplayed(DB_AccountSetting.isDisplayed());
            AssertDisplayed(DB_PrivacySetting.isDisplayed());
            AssertDisplayed(DB_SettingsDrawerCloseButton.isDisplayed());
        }
    }
    public void validateXCTAinSettings(){
        waitForVisibility(DB_SettingsDrawerCloseButton);
        DB_SettingsDrawerCloseButton.click();
        AssertDisplayed(IsElementDisplayed(DB_AppSetting));
    }

    @Override
    public void validateAccountSettingsForSMB() {
        waitForVisibility(AS_AccountSettingTittle);
        Assert.assertEquals(AS_AccountSettingTittle.getText(),"Account settings");
        Assert.assertEquals(AppAppPrivacySupplementHeader.getText(),"Settings");
        AssertDisplayed(SO_Xicon.isDisplayed());

        List<String> SortedAccountSettingsItems = Arrays.asList(new String[]{
                "Data notifications",
                "Manage account",
                "Change my PIN",
                "Address details",
                "Spend Manager",
                "Direct debit",
                "Important documents",
                "SIM swap"
        });


        for (int k = 0; k < SortedAccountSettingsItems.size(); k++) {
            try {
                AssertDisplayed(driver.findElement(By.xpath("//*[@label='" + SortedAccountSettingsItems.get(k) + "']")).isDisplayed());
            } catch (Exception e) {
                scrollDown();
                AssertDisplayed(driver.findElement(By.xpath("//*[@label='" + SortedAccountSettingsItems.get(k) + "']")).isDisplayed());
            }
        }
    }

    @Override
    public void validateAccountSettingsForPAYGPLUS() {
        waitForVisibility(AS_AccountSettingTittle);
        Assert.assertEquals(AS_AccountSettingTittle.getText(),"Account settings");
        Assert.assertEquals(AppAppPrivacySupplementHeader.getText(),"Settings");
        AssertDisplayed(SO_Xicon.isDisplayed());

        List<String> SortedAccountSettingsItems = Arrays.asList(new String[]{
                "Manage account",
                "Change my PIN",
                "Address details",
                "Mobile switching",
                "Important documents",
                "Activate SIM",
                "Accessibility"
        });


        for (int k = 0; k < SortedAccountSettingsItems.size(); k++) {
            try {
                AssertDisplayed(driver.findElement(By.xpath("//*[@label='" + SortedAccountSettingsItems.get(k) + "']")).isDisplayed());
            } catch (Exception e) {
                scrollDown();
                AssertDisplayed(driver.findElement(By.xpath("//*[@label='" + SortedAccountSettingsItems.get(k) + "']")).isDisplayed());
            }
        }
    }

    @Override
    public void validateLogoutCTA() {
        if (envProp.getProperty("UFL").equalsIgnoreCase("wifi")){

            try {
                AssertDisplayed(driver.findElement(By.xpath("//*[@label='Logout']")).isDisplayed());
            } catch (Exception e) {
                scrollDown();
                AssertDisplayed(driver.findElement(By.xpath("//*[@label='Logout']")).isDisplayed());
            }
        }
    }

    @Override
    public void clickOnLogoutCTA() {
        LogoutCTA.click();
    }

    @Override
    public void validateManageMySIMList() {
        waitForVisibility(manageMySIMTitle);
        Assert.assertEquals(driver.findElements(manageSIMOptionsList).size(),manageSIMResponse.subItems.size());
    }

    @Override
    public void checkWebviewsOfManageMySIMList() {
        int i=0;
        String webViewTitle;
        List<WebElement> options = driver.findElements(manageSIMOptionsList);
        Map<String,String> manageMySIMOptions = new HashMap<String,String>();
        manageMySIMOptions.put("Activate my SIM card","Activate my SIM card");
        manageMySIMOptions.put("Activate my eSIM","activate your eSIM");
        manageMySIMOptions.put("Transfer my eSIM","Transfer my eSIM");
        manageMySIMOptions.put("Block my plan","Block my plan");
        for(WebElement option: options) {
            webViewTitle = option.getText();
            Assert.assertEquals(option.getText(), manageSIMResponse.subItems.get(i).title);
            option.click();

            waitForVisibility(WebViewXIcon);
            AssertDisplayed(driver.findElement(WebViewXIcon).isDisplayed());

            waitForVisibility(manageSIMOption(manageMySIMOptions.get(webViewTitle)));
            System.out.println(driver.findElement(manageSIMOption(manageMySIMOptions.get(webViewTitle))).getText() + "  option");
            Assert.assertTrue(driver.findElement(manageSIMOption(manageMySIMOptions.get(webViewTitle))).isDisplayed());
            driver.findElement(WebViewXIcon).click();
            i++;
            waitForVisibility(manageMySIMTitle);
        }
    }

    @Override
    public void validateLogoutPopupMessage() {
        waitForVisibility(LogoutLogo);
        Assert.assertEquals(LogoutMessage.getText(),"Are you sure you want to log out?");
        AssertDisplayed(Logout_Confirm.isDisplayed());
        AssertDisplayed(Logout_Cancel.isDisplayed());
    }
}


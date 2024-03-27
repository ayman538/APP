package pages.RedHybrid.AccountSettings;

import core.drivers_initializer.drivers.AppiumMobileDriver;
import models.response.DashboardV4ResponseModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.DashboardUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static utilities.PropertiesLoader.readEnv;
import static utils.element_helpers.DriverHelps.hideKeyboard;
import static utils.element_helpers.TextHelpers.getElementByText;
import static utils.element_helpers.VerifyHelpers.*;
import static utils.element_helpers.WaitHelpers.waitForVisibility;
import static utils.element_helpers.WaitHelpers.waitForVisibilityForReinvent;

public class RedHybrid_AccountSettings_Android extends RedHybrid_AccountSettings_Abstract {
    Boolean live = System.getProperty("isLiveTest", readEnv("isLiveTest")).equalsIgnoreCase("true");
    private final By _ScreenTitle = By.xpath("//android.widget.TextView[contains(@resource-id, 'com.myvodafoneapp:id/settingsSectionTitle') and @text='Account settings']");
    DashboardV4ResponseModel DashboardResponse;

    public RedHybrid_AccountSettings_Android() {
        super();
        if(!live)DashboardResponse = DashboardUtils.GetDashboard();
    }

    @Override
    public void clickOnAccount() {
        waitForVisibility(DB_AccountSetting);
        DB_AccountSetting.click();
    }

    @Override
    public void closeMyAccountSheet() {
        waitForVisibility(DB_SettingsDrawerCloseButton);
        DB_SettingsDrawerCloseButton.click();
    }


//    @Override
//    public void validateAccountSettingsTitlesAndArrangement() {
//        //Validate account settings screen is displayed
//        waitForVisibility(AS_ScreenTitle);
//        assertEquals(AS_ScreenTitle.getText(), "Account settings");
//
//      // Assert Account list is displayed and mapped as the API
//        for (int i = 0; i < getAccountSettingsListTitles().size(); i++){
//            assertEquals(getAccountSettingsListTitles().get(i), DashboardResponse.settingItems.get(2).subItems.get(i).title);
//        Assert.assertTrue(getElementByText(getAccountSettingsListTitles().get(i)).isDisplayed());
//        }
//
//
//    }


    public List<String> getAccountSettingsListTitles() {
        List<String> accountSettingsListText = new ArrayList<>();
        List<WebElement> accountSettingsElements = driver.findElements(By.xpath("//*[@resource-id='com.myvodafoneapp:id/txtAppSettingsSubitems']"));
        for (WebElement accountSettingsElement : accountSettingsElements) {
            accountSettingsListText.add(accountSettingsElement.getText());
        }
        return accountSettingsListText;

    }

    @Override
    public void validateAccountSettingsTitlesAndArrangement() {
        List<String> accountSettingsItems = Arrays.asList("Profile & Address", "Spend Manager", "Cards & Payments",
                "Data Notifications", "SIM Swap", "Important Documents", "Change my PIN", "Accessibility");
        waitForVisibility(_ScreenTitle);
        assertEquals(driver.findElement(_ScreenTitle).getText(), "Account settings");
        if (live) {
            for (String item : accountSettingsItems) {
                By itemLocator = By.xpath("//*[@text='" + item + "']");
                WebElement element = driver.findElement(itemLocator);
                Assert.assertTrue(element.isDisplayed(), "Element '" + item + "' is not displayed");
                System.out.println(item);
            }

        } else {
            System.out.println("Size Of list Should not be equal zero =" + getAccountSettingsListTitles().size());
            System.out.println("Account settings text: ");
            for (int i = 0; i < getAccountSettingsListTitles().size(); i++) {
                System.out.println(getAccountSettingsListTitles().get(i));
                String apiAccountSettingsTitle = (DashboardResponse.settingItems.get(2).subItems.get(i).title);
                assertEquals(getAccountSettingsListTitles().get(i), apiAccountSettingsTitle);
                Assert.assertTrue(getElementByText(apiAccountSettingsTitle).isDisplayed());
            }
        }
    }

    @Override
    public void validateDataNotificationsNotAppearInAccountSettings() {
        waitForVisibility(AS_ScreenTitle);
        assertEquals(AS_ScreenTitle.getText(), "Account settings");
        System.out.println("Size Of list Should not be equal zero =" + getAccountSettingsListTitles().size());
        System.out.println("Account settings text: ");
        for (int i = 0; i < getAccountSettingsListTitles().size(); i++) {
            System.out.println(getAccountSettingsListTitles().get(i));
            String apiAccountSettingsTitle = (DashboardResponse.settingItems.get(2).subItems.get(i).title);
            AssertResultNotEqual(getAccountSettingsListTitles().get(i), "Data notifications");
            AssertResultNotEqual(apiAccountSettingsTitle, "Data notifications");
        }
    }

    @Override
    public void validateAccessibilityAppearInAccountSettings() {
        waitForVisibility(AS_ScreenTitle);
        assertEquals(AS_ScreenTitle.getText(), "Account settings");
        System.out.println("Size Of list Should not be equal zero =" + getAccountSettingsListTitles().size());
        System.out.println("Account settings text: ");
        boolean accessibilityISAppeared = false;
        for (int i = 0; i < getAccountSettingsListTitles().size(); i++) {
            System.out.println(getAccountSettingsListTitles().get(i));
            String apiAccountSettingsTitle = (DashboardResponse.settingItems.get(2).subItems.get(i).title);
            if (getAccountSettingsListTitles().get(i).equalsIgnoreCase("Accessibility")) {
                assertEquals(getAccountSettingsListTitles().get(i), "Accessibility");
                assertEquals(apiAccountSettingsTitle, "Accessibility");
                accessibilityISAppeared = true;
            }
        }
        Assert.assertTrue(accessibilityISAppeared);
    }

    @Override
    public void iClickOnLink(String linkName) {
        WebElement linkElement = getElementByText(linkName);
        waitForVisibility(linkElement);
        AssertDisplayed(linkElement.isDisplayed());
        linkElement.click();
    }

    @Override
    public void iNavigateToThePage(String PageTitle) {
        waitForVisibilityForReinvent(By.xpath("//*[@text='" + PageTitle + "']"), 60);
        AssertDisplayed(getElementByText(PageTitle).isDisplayed());
        if (PageTitle.equalsIgnoreCase("Enter your new PIN")) {
            hideKeyboard();
        }
    }
}

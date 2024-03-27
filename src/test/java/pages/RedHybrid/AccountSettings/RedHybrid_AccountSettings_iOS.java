package pages.RedHybrid.AccountSettings;

import models.response.DashboardV4ResponseModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.DashboardUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import static utilities.PropertiesLoader.readEnv;
import static utils.element_helpers.TextHelpers.getElementByText;
import static utils.element_helpers.VerifyHelpers.*;
import static utils.element_helpers.WaitHelpers.waitForVisibility;
import static utils.element_helpers.WaitHelpers.waitForVisibilityForReinvent;

public class RedHybrid_AccountSettings_iOS extends RedHybrid_AccountSettings_Abstract {
    Boolean live = System.getProperty("isLiveTest", readEnv("isLiveTest")).equalsIgnoreCase("true");
    DashboardV4ResponseModel DashboardResponse;
    public RedHybrid_AccountSettings_iOS() {
        super();
        if(!live) {
            DashboardResponse = DashboardUtils.GetDashboard();
        }
    }

    @Override
    public void clickOnAccount() {
        waitForVisibility(DB_AccountSetting);
        DB_AccountSetting.click();
    }

    @Override
    public void closeMyAccountSheet(){
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
        List<WebElement> accountSettingsElements = driver.findElements(By.xpath("//XCUIElementTypeScrollView[@name='scrollView']/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell"));
        for (WebElement accountSettingsElement : accountSettingsElements) {
            accountSettingsListText.add(accountSettingsElement.findElement(By.xpath("//*[@type='XCUIElementTypeStaticText']")).getText());
        }
        return accountSettingsListText;

    }


    @Override
    public void validateAccountSettingsTitlesAndArrangement() {
        List<String> accountSettingsItems = Arrays.asList("Profile & Address", "Spend Manager", "Cards & Payments",
                "Data Notifications", "SIM Swap", "Important Documents","Change my PIN","Accessibility");
        if (live) {
            waitForVisibility(AS_ScreenTitle);
            assertEquals(AS_ScreenTitle.getText(), "Account settings");
            for (String item : accountSettingsItems) {
                By itemLocator = By.xpath("//*[@value='" + item + "']");
                WebElement element = driver.findElement(itemLocator);
                Assert.assertTrue(element.isDisplayed(), "Element '" + item + "' is not displayed");
                System.out.println(item);
            }

        } else {
            waitForVisibility(AS_ScreenTitle);
            assertEquals(AS_ScreenTitle.getText(), "Account settings");
            System.out.println("Size Of list is Should not be equal zero =" + getAccountSettingsListTitles().size());
            System.out.println("Account settings text ");
            for (int i = 0; i < getAccountSettingsListTitles().size(); i++) {
                System.out.println(getAccountSettingsListTitles().get(i));
                String apiAccountSettingsTitle = (DashboardResponse.settingItems.get(2).subItems.get(i).title);
                assertEquals(getAccountSettingsListTitles().get(i), apiAccountSettingsTitle);
                Assert.assertTrue(getElementByText(apiAccountSettingsTitle).isDisplayed());
            }
        }
    }

    @Override
    public void validateDataNotificationsNotAppearInAccountSettings(){
        waitForVisibility(AS_ScreenTitle);
        assertEquals(AS_ScreenTitle.getText(), "Account settings");
        System.out.println("Size Of list Should not be equal zero =" + getAccountSettingsListTitles().size());
        System.out.println("Account settings text: " );
        for(int i = 0 ; i < getAccountSettingsListTitles().size();i++){
            System.out.println(getAccountSettingsListTitles().get(i));
            String apiAccountSettingsTitle= (DashboardResponse.settingItems.get(2).subItems.get(i).title);
            AssertResultNotEqual(getAccountSettingsListTitles().get(i),"Data notifications");
            AssertResultNotEqual(apiAccountSettingsTitle,"Data notifications");
        }
    }

    @Override
    public void validateAccessibilityAppearInAccountSettings(){
        waitForVisibility(AS_ScreenTitle);
        assertEquals(AS_ScreenTitle.getText(), "Account settings");
        System.out.println("Size Of list Should not be equal zero =" + getAccountSettingsListTitles().size());
        System.out.println("Account settings text: " );
        boolean accessibilityISAppeared = false;
        for(int i = 0 ; i < getAccountSettingsListTitles().size();i++){
            System.out.println(getAccountSettingsListTitles().get(i));
            String apiAccountSettingsTitle= (DashboardResponse.settingItems.get(2).subItems.get(i).title);
            if(getAccountSettingsListTitles().get(i).equalsIgnoreCase("Accessibility"))
            {
                assertEquals(getAccountSettingsListTitles().get(i),"Accessibility");
                assertEquals(apiAccountSettingsTitle,"Accessibility");
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
        waitForVisibilityForReinvent(By.xpath("//*[@label='"+ PageTitle +"']"), 60);
        AssertDisplayed(getElementByText(PageTitle).isDisplayed());
    }
}

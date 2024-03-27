package pages.Dashboard.NetworkLinks;

import models.response.DashboardV4ResponseModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utilities.PropertiesLoader;
import utils.DashboardUtils;

import java.util.ArrayList;
import java.util.List;

import static utils.element_helpers.GenericHelpers.navigateBackForAndroid;
import static utils.element_helpers.ScrollHelpers.*;
import static utils.element_helpers.VerifyHelpers.*;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

public class NetworkLinksAndroid extends NetworkLinksAbstract {
    Boolean live = System.getProperty("isLiveTest", PropertiesLoader.readEnv("isLiveTest")).equalsIgnoreCase("true");
    private final By network_status_checker = By.xpath("//android.widget.TextView[contains(@resource-id, 'com.myvodafoneapp:id/nameTextView') and @text='Network Status Checker']");
    private final By check_data_and_wifi_speed = By.xpath("//android.widget.TextView[contains(@resource-id, 'com.myvodafoneapp:id/nameTextView') and @text='Check Data and Wi-Fi Speed']");

    DashboardV4ResponseModel DashboardResponse;
    List NetworkLinks;

    public NetworkLinksAndroid() {
        super();
        if (!live) {
            DashboardResponse = DashboardUtils.GetDashboard();
            NetworkLinks = DashboardResponse.linksMenu.menuItems.get(1).subItems;
        }
    }

    private DashboardV4ResponseModel.MenuItem getYourNetworkMenuItem() {
        DashboardV4ResponseModel.MenuItem yourNetworkMenuItem = new DashboardV4ResponseModel.MenuItem();
        for (DashboardV4ResponseModel.MenuItem menuItem : DashboardResponse.linksMenu.menuItems) {
            if (menuItem.title.equalsIgnoreCase("Your Network")) {
                yourNetworkMenuItem = menuItem;
                break;
            }
        }
        return yourNetworkMenuItem;
    }

    private List<DashboardV4ResponseModel.DashboardSubItem> getYourNetworkSubItems() {
        return getYourNetworkMenuItem().subItems;
    }

    public void assertNetworkStatus() {
        Assert.assertEquals(DashboardResponse.linksMenu.status.analytics.status, "Success");
    }

    public List<WebElement> NetworkLinks() {
        return (List<WebElement>) driver.findElements(By.xpath("//*[@text='Your Network']/parent::*//android.widget.TextView[@resource-id='com.myvodafoneapp:id/nameTextView']"));
    }

    public void NetworkLinksStatus() {
        waitForVisibility(DB_SettingDashboardTray_icon);
        scrollToElement(DB_NetworkCheckerLink, 10);
        if (!live) assertNetworkStatus();
    }

    public void assertNetworkTitleText() {
        if (live) {
            assertEquals("Your Network", DB_NetworkTitle.getText());
        } else {
            AssertResult(DB_NetworkTitle.getText(), getYourNetworkMenuItem().title);
        }
    }

    public List<String> getAPINetworkLinksText() {
        List<String> APINetworkLinksText = new ArrayList<>();
        for (int j = 0; j < NetworkLinks().size(); j++) {
            APINetworkLinksText.add(DashboardResponse.linksMenu.menuItems.get(2).subItems.get(j).title);
        }
        return APINetworkLinksText;
    }

    public void ValidateNetworkLinksOrderAndText() {
        if(live){
            scrollAndVerifyElements(network_status_checker,check_data_and_wifi_speed);
        }else {
            scrollDownTo(DB_VodafoneSecureNet);
            scrollUpTo(DB_NetworkTitle);
            for (int k = 0; k < getYourNetworkSubItems().size(); k++) {
                scrollDownTo((NetworkLinks().get(k)));
                Assert.assertEquals(getAPINetworkLinksText().get(k), NetworkLinks().get(k).getText());
            }
        }
    }

    public void ValidateNetworkLinksCTA() {
        scrollDownTo(DB_VodafoneSecureNet);
        scrollUpTo(DB_NetworkTitle);
        List<WebElement> ListOfWebelements = NetworkLinks();
        for (WebElement networkLinksLocator : ListOfWebelements) {
            ListOfWebelements = NetworkLinks();
            scrollDownTo(DB_VodafoneSecureNet);
            scrollUpTo(networkLinksLocator);
            waitForVisibility(networkLinksLocator);
            switch (networkLinksLocator.getText()) {
                case "Network Status Checker":
                    networkLinksLocator.click();
                    checkNetworkStatusJourney();
                    break;
                case "Check Data and Wi-Fi Speed":
                case "Speed checker":
                    networkLinksLocator.click();
                    checkDataWIFIJourney();
                    break;
            }
        }
    }

    public void checkNetworkStatusJourney() {
        assertNetworkStatusTitleText();
        NetworkScreenXIcon.click();
        waitForVisibility(DB_SettingDashboardTray_icon);

    }
    private final By networkStatus_title = By.id("com.myvodafoneapp:id/tvTitle");

    public void assertNetworkStatusTitleText() {
        waitForVisibility(networkStatus_title);
        AssertResult(driver.findElement(networkStatus_title).getText(), "Network Status Checker");
    }


    public void checkDataWIFIJourney() {
        assertSpeedCheckerTitleText();
    }

    public void assertSpeedCheckerTitleText() {
        waitForVisibility(DB_speedChecker_title);
        AssertResult(DB_speedChecker_title.getText(), "Speed checker");
        DB_speedCheckerXicon.click();
    }

    @Override
    public void scrollDownToBroadBandServiceTest() {
        scrollDownTo(BroadBandServiceTestLink);
        waitForVisibility(BroadBandServiceTestLink);
        BroadBandServiceTestLink.click();

    }

    @Override
    public void ValidateBroadBandServiceTestLink() {
        waitForVisibility(BroadBandServiceTestLink);
        Assert.assertTrue(BroadBandServiceTestLink.isDisplayed());
    }


    @Override
    public void ValidateUserName() {
        waitForVisibility(DX_IDM_Username);
        Assert.assertTrue(DX_IDM_Username.isDisplayed());
    }

    @Override
    public void navigateBack() {
        navigateBackForAndroid();
    }
}

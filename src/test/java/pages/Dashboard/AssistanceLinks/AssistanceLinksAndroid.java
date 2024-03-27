package pages.Dashboard.AssistanceLinks;

import models.response.DashboardV4ResponseModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.DXIDMUtils;
import utils.DashboardUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static utilities.PropertiesLoader.readEnv;
import static utils.element_helpers.VerifyHelpers.*;
import static utils.element_helpers.WaitHelpers.*;
import static utils.element_helpers.ScrollHelpers.*;

public class AssistanceLinksAndroid extends AssistanceLinksAbstract {
    Boolean live = System.getProperty("isLiveTest", readEnv("isLiveTest")).equalsIgnoreCase("true");
    private final By assistance_title = By.xpath("//android.widget.TextView[contains(@resource-id, 'com.myvodafoneapp:id/headerTextView') and @text='Assistance']");
    private final By network_title = By.xpath("//android.widget.TextView[contains(@resource-id, 'com.myvodafoneapp:id/headerTextView') and @text='Your Network']");
    List<String> live_assistance_links = Arrays.asList("Frequently Asked Questions", "Battery Refresh Tool","Store Locator",
            "Track An Order","Top Up A Friend","Digital Parenting");

    public AssistanceLinksAndroid() {
        super();
    }

    List<WebElement> AssistanceLinksElements = new ArrayList<>();


    public List<WebElement> getAssistanceLinksElements() {
        return (List<WebElement>) driver.findElements(By.xpath("//*[@text='Assistance']/parent::*//android.widget.TextView[@resource-id='com.myvodafoneapp:id/nameTextView']"));
    }


    public void AssistanceLinksStatus() {
        waitForVisibility(DB_SettingDashboardTray_icon);
        assertAssistanceStatus();
        scrollDownTo(DB_AssistanceTitle);
    }

    public void assertAssistanceStatus() {
        DashboardV4ResponseModel DashboardResponse = DashboardUtils.GetDashboard();
        Assert.assertEquals(DashboardResponse.linksMenu.status.analytics.status, "Success");
    }

    public void assertOnlyFourLinksDisplayed() {
        try {
//            scrollDownTo(DB_SeeMoreAssistanceCTA);
            scrollDownToAssistanceLinks();
            AssistanceLinksElements = getAssistanceLinksElements();
            if (DB_SeeMoreAssistanceCTA.getText().equals("Show more")) {
                for (int i = 0; i < 5; i++) Assert.assertTrue(AssistanceLinksElements.get(i).isDisplayed());
                for (int j = 5; j < AssistanceLinksElements.size(); j++)
                    Assert.assertFalse(AssistanceLinksElements.get(j).isDisplayed());
            }
        } catch (Exception e) {
            System.out.println("Less than four links");
            AssistanceLinksElements = getAssistanceLinksElements();
            for (int i = 0; i < AssistanceLinksElements.size(); i++)
                Assert.assertTrue(AssistanceLinksElements.get(i).isDisplayed());
        }
    }

    @Override
    public void assertNotificationsIsRemoved() {
        scrollDownTo(DB_AssistanceTitle);
        for (String assistanceLinksText : getAPIAssistanceLinksText()) {
            AssertResultNotEqual(assistanceLinksText, "Notifications");
        }
        HardAssertNotDisplayed("Notifications", elementIsPresent(DB_NotificationsLink));
    }

    public void assistanceLinkSeeMoreCTA() {
        List<DashboardV4ResponseModel.DashboardSubItem> AssistanceLinksSubItems = getAssistanceLinkSubItems();

        if (AssistanceLinksSubItems.size() > 5) {
//            scrollDownTo(DB_SeeMoreAssistanceCTA); //Tobi icon might overlap on the show more button
            scrollDownTo(DB_NetworkTitle);
//            scrollUpTo(DB_NetworkStatusCheckerIcon);
            waitForVisibility(DB_SeeMoreAssistanceCTA);
            DB_SeeMoreAssistanceCTA.click();
            scrollUpTo(DB_AssistanceTitle);
            waitForVisibility(DB_AssistanceTitle);
        }
    }


    public void assertAssistanceTitleText() {
        scrollDownToAssistanceLinks();
        if(live){
            Assert.assertTrue(driver.findElement(assistance_title).isDisplayed());
        }else {
            DashboardV4ResponseModel DashboardResponse = DashboardUtils.GetDashboard();
            AssertResult(DB_AssistanceTitle.getText(), DashboardResponse.linksMenu.menuItems.get(1).title);
        }
    }

    public void ValidateAssistanceLinksOrderAndText() {
        if(live){
            validateLinksLive(live_assistance_links);
        }else {
//        scrollUpTo(DB_AssistanceTitle);
            assistanceLinkSeeMoreCTA();
            AssistanceLinksElements = getAssistanceLinksElements();
            List<String> assistanceLinksTextsFromAPI = getAPIAssistanceLinksText();
            for (int k = 0; k < assistanceLinksTextsFromAPI.size(); k++) {
                try {
                    scrollDownTo((AssistanceLinksElements.get(k)));
                } catch (Exception e) {
                    scrollDownTo((DB_SeeMoreAssistanceCTA));
                }
                Assert.assertEquals(assistanceLinksTextsFromAPI.get(k), AssistanceLinksElements.get(k).getText());
            }
        }
    }
    private void validateLinksLive(List<String> live_assistance_links) {
        for (String link : live_assistance_links) {
            int index = live_assistance_links.indexOf(link);
            if (index < live_assistance_links.size() - 1) {
                scrollDownTo(network_title);
                scrollUpTo(By.xpath("//*[@text='" + link + "']"));
                System.out.println(link);
            } else {
                scrollDownTo(DB_SeeMoreAssistanceCTA);
                DB_SeeMoreAssistanceCTA.click();
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                scrollDownTo(By.xpath("//*[@text='Digital Parenting']"));
            }
        }
    }


    @Override
    public void ValidateAssistanceLinksOrderAndTextAfterNotificationIsRemoved() {
        AssistanceLinksElements = getAssistanceLinksElements();
        scrollUpTo(DB_AssistanceTitle);
        for (int k = 0; k < getAPIAssistanceLinksText().size(); k++) {
            Assert.assertEquals(getAPIAssistanceLinksText().get(k), AssistanceLinksElements.get(k).getText());
            System.out.println(AssistanceLinksElements.get(k).getText());
        }
    }

    @Override
    public void assertOnlyFourLinksDisplayed(int count) {
        assertOnlyFourLinksDisplayed();
    }

    public List<String> getAPIAssistanceLinksText() {
        List<DashboardV4ResponseModel.DashboardSubItem> AssistanceLinks = getAssistanceLinkSubItems();
        List<String> APIAssistanceLinksText = new ArrayList<>();
        for (int j = 0; j < AssistanceLinks.size(); j++) {
            APIAssistanceLinksText.add(AssistanceLinks.get(j).title);
        }
        return APIAssistanceLinksText;
    }

    public void ValidateAssistanceLinksCTA() {
//        assistanceLinkSeeMoreCTA();
        if (!DB_AssistanceTitle.isDisplayed()) {
            scrollDownTo(DB_NetworkStatusCheckerIcon);
            scrollUpTo(DB_AssistanceTitle);
            waitForVisibility(DB_AssistanceTitle);
        }
        List<WebElement> listOfAssistanceWebElements = getAssistanceLinksElements();
        for (WebElement assitanceLinksLocator : listOfAssistanceWebElements) {
            listOfAssistanceWebElements = getAssistanceLinksElements();
            System.out.println("Current assistance link is: " + assitanceLinksLocator.getText());
            scrollDownTo(DB_NetworkTitle);
            scrollUpTo(assitanceLinksLocator);
            waitForVisibility(assitanceLinksLocator);
            switch (assitanceLinksLocator.getText()) {
                case "Free Business Advice":
                    assitanceLinksLocator.click();
                    assertDoneCTADisplayedFreeBusiness();
                    DoneCTAAfterFreeBusiness();
                    break;

                case "Frequently Asked Questions":
                    assitanceLinksLocator.click();
                    CheckFAQs();
                    break;
                case "Store Locator":
                    assitanceLinksLocator.click();
                    CheckStoreLocator();
                    break;
                case "Track An Order":
                    assitanceLinksLocator.click();
                    CheckTrackAnOrder();
                    break;
                case "Top Up A Friend":
                    assitanceLinksLocator.click();
                    checkTopUpFriend();
                    break;
                case "Manage your devices":
                    assitanceLinksLocator.click();
                    checkManageYouDevice();
                    break;
                case "Battery Refresh Tool":
                    assitanceLinksLocator.click();
                    checkBatteryRefresh();
                    break;
            }
        }

    }

    public void assertDoneCTADisplayedFreeBusiness() {
        waitForVisibility(DoneCtaInExternalbrowser);
        AssertDisplayed(DoneCtaInExternalbrowser.isDisplayed());
    }

    public void DoneCTAAfterFreeBusiness() {
        DoneCtaInExternalbrowser.click();
        waitForVisibility((DB_SettingDashboardTray_icon));
    }


    public void CheckNotificationScreen() {
        assertNotificationTitleText();
        notificationXIconCTA();
    }

    public void notificationXIconCTA() {
        DB_NotificationXicon.click();
        waitForVisibility((DB_SettingDashboardTray_icon));
    }

    public void assertNotificationTitleText() {
        waitForVisibility(Notification_title);
        AssertResult(Notification_title.getText(), "My Vodafone Messages");
    }


    public void CheckStoreLocator() {
        assertDoneCTADisplayed();
        doneCTA();
    }

    public void doneCTA() {
        DoneCtaInExternalbrowser.click();
        waitForVisibility((DB_SettingDashboardTray_icon));
    }

    public void assertDoneCTADisplayed() {
        waitForVisibility(DoneCtaInExternalbrowser);
        AssertDisplayed(DoneCtaInExternalbrowser.isDisplayed());
    }


    public void checkManageYouDevice() {
        waitForVisibility(DoneCtaInExternalbrowser);
        AssertDisplayed(DoneCtaInExternalbrowser.isDisplayed());
        DoneCtaInExternalbrowser.click();
        waitForVisibility((DB_SettingDashboardTray_icon));
    }

    public void checkTopUpFriend() {
        waitForVisibility(DoneCtaInExternalbrowser);
        AssertDisplayed(DoneCtaInExternalbrowser.isDisplayed());
        DoneCtaInExternalbrowser.click();
        waitForVisibility((DB_SettingDashboardTray_icon));
    }


    /*   public void checkConnectAnotherDevice(){
           waitForVisibility(DoneCtaInExternalbrowser);
           AssertDisplayed(DoneCtaInExternalbrowser.isDisplayed());
           DoneCtaInExternalbrowser.click();
           waitForVisibility((DB_SettingDashboardTray_icon));
       }*/
    public void CheckTrackAnOrder() {
        assertTrackOrderTitleText();
        trackOrderXIconCTA();
    }

    public void trackOrderXIconCTA() {
        DB_TrackAnOrderXIcon.click();
        waitForVisibility((DB_SettingDashboardTray_icon));
    }

    public void assertTrackOrderTitleText() {
        waitForVisibility(DB_TrackAnOrderTitle);
        AssertResult(DB_TrackAnOrderTitle.getText(), "My Vodafone");
    }


    public void checkBatteryRefresh() {
        assertBatteryRefreshXIconDisplayed();
//        BatteryRefreshBackCTA();
        driver.navigate().back();
    }

    public void BatteryRefreshBackCTA() {
        DB_BatteryRefreshXIcon.click();
    }

    public void assertBatteryRefreshXIconDisplayed() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        waitForVisibility(DB_BatteryRefreshXIcon);
        AssertDisplayed(DB_BatteryRefreshXIcon.isDisplayed());
    }


    public void CheckFAQs() {
        assertDoneCTADisplayedFAQs();
        DoneCTAAfterFAQs();
    }

    public void DoneCTAAfterFAQs() {
        DoneCtaInExternalbrowser.click();
        waitForVisibility((DB_SettingDashboardTray_icon));
    }

    public void assertDoneCTADisplayedFAQs() {
        waitForVisibility(DoneCtaInExternalbrowser);
        AssertDisplayed(DoneCtaInExternalbrowser.isDisplayed());
    }


    @Override
    public void validateConnectedAnotherDeviceAndTradeinLinksIsRemoved() {
        {
            scrollDownTo(DB_SeeMoreAssistanceCTA);
            for (String assistanceLinksText : getAPIAssistanceLinksText()) {
                AssertResultNotEqual(assistanceLinksText, "Connect another device");
                AssertResultNotEqual(assistanceLinksText, "Trade in Tool");
            }
            Assert.assertFalse(elementIsPresent(DB_ConnectAnotherDeviceLink));
            Assert.assertFalse(elementIsPresent(DB_TradeInLink));
            DB_SeeMoreAssistanceCTA.click();
            scrollDownTo(DB_SeeLessAssistanceCTA);
            Assert.assertFalse(elementIsPresent(DB_ConnectAnotherDeviceLink));
            Assert.assertFalse(elementIsPresent(DB_TradeInLink));
        }

    }


    public void CheckTradeIN() {
        assertTradInXIconDisplayed();
        TradeInXIconCTA();
    }

    public void TradeInXIconCTA() {
        Trade_XIcon.click();
    }

    public void assertTradInXIconDisplayed() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        waitForVisibility(Trade_XIcon);
        AssertDisplayed(Trade_XIcon.isDisplayed());
    }


    public void assistanceLinkSeeLessCTA() {
        scrollDownElementOverCenterScreen(DB_SeeLessAssistanceCTA);
        if (DB_SeeLessAssistanceCTA.getText().equals("Show less")) {
            DB_SeeLessAssistanceCTA.click();
            scrollUpTo(DB_AssistanceTitle);
        }
    }

    @Override
    public void scrollDownToAssistanceLinks() {
        waitForVisibility(DB_SettingDashboardTray_icon);
        scrollDownTo(DB_VodafoneSecureNet);
        scrollUpTo(DB_AssistanceTitle);
    }

    @Override
    public void CheckChildAssistanceLinks() {
        if(live){
            validateLinksLive(live_assistance_links);
        }else {
            DashboardV4ResponseModel DashboardResp = DashboardUtils.GetDashboard(
                    System.getProperty("SwitchedMSISDN"),
                    System.getProperty("SwitchedSegment"),
                    System.getProperty("SwitchedSubsType"),
                    DXIDMUtils.getLOA1Token(System.getProperty("SwitchedMSISDN")),
                    System.getProperty("SwitchedAccount"));
            for (int i = 0; i < DashboardResp.linksMenu.menuItems.size(); i++) {
                if (DashboardResp.linksMenu.menuItems.get(i).title.equals("Assistance")) {
                    int AssistanceLinksNum = DashboardResp.linksMenu.menuItems.get(i).subItems.size();
                    if (AssistanceLinksNum > 4) {
                        DB_SeeMoreAssistanceCTA.click();
                    }
                    for (int j = 0; j < DB_AssistanceLinks.size(); j++) {
                        Assert.assertEquals(DB_AssistanceLinks.get(j).getText(), DashboardResp.linksMenu.menuItems.get(i).subItems.get(j).title);
                    }
                    break;
                }

            }
        }

    }

    @Override
    public void ClickOnBatteryRefresh() {
        waitForVisibility(DB_BatteryRefreshLink);
        DB_BatteryRefreshLink.click();
    }

    @Override
    public void ValidateBatteryRefreshPage() {
        waitForVisibility(DB_BatteryRefreshXIcon);
        waitForVisibility(DB_BatteryRefresh);
        Assert.assertTrue(DB_BatteryRefreshXIcon.isDisplayed());
        Assert.assertTrue(DB_BatteryRefresh.isDisplayed());
    }

    @Override
    public void CheckBatteryRefreshExistence() {
        if (DB_SeeMoreAssistanceCTA.isDisplayed()) {
            DB_SeeMoreAssistanceCTA.click();
        }
        waitForVisibility(DB_BatteryRefreshLink);
        Assert.assertTrue(DB_BatteryRefreshLink.isDisplayed());

    }

    @Override
    public void checkFreeBuisnessSupport() {
        waitForVisibility(DB_FreeBusinessSupportCTA);
        AssertDisplayed(DB_FreeBusinessSupportCTA.isDisplayed());
        DB_FreeBusinessSupportCTA.click();
        waitForVisibility(DB_FreeBusinessSupportXCTA);
        AssertDisplayed(DB_FreeBusinessSupportXCTA.isDisplayed());

    }

    @Override
    public void checkBatteryRefreshForPAYG() {
        waitForVisibility(DB_AssistanceTitle);
        HardAssertNotDisplayed("Battery Refresh Tool", elementIsPresent(DB_BatteryRefreshLink));
    }

    public List<DashboardV4ResponseModel.DashboardSubItem> getAssistanceLinkSubItems() {
        List<DashboardV4ResponseModel.DashboardSubItem> subItems = new ArrayList<>();
        List<DashboardV4ResponseModel.MenuItem> dashboardMenuItems = DashboardUtils.GetDashboard().linksMenu.menuItems;
        for (DashboardV4ResponseModel.MenuItem menuItem : dashboardMenuItems)
            if (menuItem.title.equalsIgnoreCase("Assistance")) {
                subItems = menuItem.subItems;
                break;
            }

        return subItems;
    }
}
//package pages.Dashboard.AssistanceLinks;
//
//import org.json.simple.parser.ParseException;
//import org.openqa.selenium.WebElement;
//import org.testng.Assert;
//import testdata.ReadResponse;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Properties;
//
//import static core.Config.getUser;
//import static utilities.PropertiesLoader.readPropertyFile;
//
//@Deprecated
//public class AssistanceLinksLogic extends AssistanceLinksPO {
//
//    static List<HashMap<String, String>> AssistanceLinks;
//    private final String[] originalList = {"Free Business Advice", "Notifications", "Frequently Asked Questions", "Trade In", "Store Locator", "Battery Refresh Tool", "Track An Order", "device", "Top Up A Friend"};
//    static boolean run = false;
//
//    public AssistanceLinksLogic() throws ParseException {
//        super();
//        AssistanceLinks = ReadResponse.GetAssistanceLinksList();
//        Properties envProp = readPropertyFile("config/env.properties");
//        String UI = System.getProperty("UI", envProp.getProperty("UI"));
//        String UFL = System.getProperty("UFL", envProp.getProperty("UFL"));
//        if (!run && UI.equalsIgnoreCase("new")
//                && UFL.equalsIgnoreCase("3g")) {
//            waitForVisibility(DX_IDM_SkipLoginCTA);
//            DX_IDM_SkipLoginCTA.click();
//            run = true;
//        }
//        waitForVisibility(DB_SettingDashboardTray_icon);
//    }
//
//
//    public void ValidateOrdering() {
//        assistanceLinkSeeMoreCTA();
//        assertStatus();
//    }
//
//    public void assertStatus() {
//        int lastIndex = 0;
//        boolean status = true;
//        for (int i = 0; i < AssistanceLinks.size(); i++) {
//            for (int j = lastIndex; j < originalList.length; j++) {
//                if (AssistanceLinks.get(i).get("title").contains(originalList[j])) {
//                    status = true;
//                    lastIndex = j + 1;
//                    break;
//                } else
//                    status = false;
//            }
//            Assert.assertTrue(status);
//        }
//    }
//
//    public void assistanceLinkSeeMoreCTA() {
//        System.out.println("Given  Validate the order ");
//        scrollDownTo((DB_AssistanceTitle));
//        System.out.println("Scroll down to the Assistance Title");
//        scrollDownTo((DB_SeeMoreAssistanceCTA));
//        System.out.println("Scroll down to the See more Assistance Action ");
//        DB_SeeMoreAssistanceCTA.click();
//        System.out.println("Click on See more notification CTA");
//    }
//
//    public void ValidateAssistanceLabel() {
//        assertAssistanceTitleText();
//    }
//
//    public void assertAssistanceTitleText() {
//        System.out.println("Given Validate Assistance label");
//        System.out.println("Scroll down to the assistance title" + (DB_AssistanceTitle));
//        AssertResult(DB_AssistanceTitle.getText(), "Assistance");
//        System.out.println("Should the assistance title displayed");
//    }
//
//    public void ValidateFreeBusinessLink() {
//        assertFreeBusinessLinkText();
//    }
//
//    public void assertFreeBusinessLinkText() {
//        System.out.println("Given Validate the FreeBusiness link displayed ");
//        scrollDownTo((DB_FreeBusinessLink));
//        System.out.println("Scroll to the FreeBusiness Link ");
//        AssertResult(DB_FreeBusinessLink.getText(), "Free Business Advice");
//        System.out.println("Should the validate Free Business Advice link displayed ");
//    }
//
//    public void FreeBusinessCTA() {
//        System.out.println("Given check the FreeBusiness");
//        DB_FreeBusinessLink.click();
//        System.out.println(" Click on the FreeBusiness link");
//    }
//
//    public void assertDoneCTADisplayedFreeBusiness() {
//        waitForVisibility(DoneCtaInExternalbrowserHuawei);
//        System.out.println("Wait till the done external browser by value");
//        AssertDisplayed(DoneCtaInExternalbrowserHuawei.isDisplayed());
//        System.out.println("Should done by CTA in External browser displayed ");
//    }
//
//    public void DoneCTAAfterFreeBusiness() {
//        DoneCtaInExternalbrowserHuawei.click();
//        System.out.println("Click on Done by external browser ");
//        waitForVisibility((DB_SettingDashboardTray_icon));
//        System.out.println("Wait till the dashboard displayed successfully");
//    }
//
//
//    public void ValidateNotificationLink() {
//        assertNotificationLinkText();
//    }
//
//    public void assertNotificationLinkText() {
//        System.out.println("Given Validate the notification link displayed ");
//        scrollDownTo((DB_NotificationsLink));
//        System.out.println("Scroll to the Notification Link ");
//        AssertResult(DB_NotificationsLink.getText(), "Notifications");
//        System.out.println("Should the validate notification link displayed ");
//    }
//
//    public void assertBatteryRefreshText() {
//        System.out.println("Given Validate the Battery Refresh link displayed ");
//        scrollDownTo((DB_BatteryRefreshLink));
//        System.out.println("Scroll to the Battery Refresh Link ");
//        AssertResult(DB_BatteryRefreshLink.getText(), "Battery Refresh Tool");
//        System.out.println("Should the validate Battery Refresh link displayed ");
//    }
//
//    public void ValidateFAQsLink() {
//        assertFAQsText();
//    }
//
//    public void assertFAQsText() {
//        System.out.println("Given Validate the FAQs link ");
//        scrollDownTo((DB_FreqAskQuestLink));
//        System.out.println("Scroll to the FAQ Ask questions Link");
//        AssertResult(DB_FreqAskQuestLink.getText(), "Frequently Asked Questions");
//        System.out.println("Should the FAQ ask questions displayed successfully");
//    }
//
//    public void ValidateTradeInLink() {
//        assertTradInText();
//    }
//
//    public void assertTradInText() {
//        System.out.println("Given Validate the trade-in link");
//        System.out.println("If we are using ios and the user has Trade in ");
//        scrollDownTo((DB_TradeInLink));
//        System.out.println("Scroll yo the TradINLink ");
//        AssertResult(DB_TradeInLink.getText(), "Trade-in Tool");
//        System.out.println("Should the Trade in link displayed successfully");
//    }
//
//    public void ValidateStoreLocatorLink() {
//        assertFindStoreLinkText();
//    }
//
//    public void assertFindStoreLinkText() {
//        System.out.println("Given Validate Store Locator link ");
//        scrollDownTo((DB_FindStoreLink));
//        System.out.println("Scroll to the find store link");
//        AssertResult(DB_FindStoreLink.getText(), "Store Locator");
//        System.out.println("Should the find store link displayed successfully ");
//    }
//
//    public void ValidateTrackAndOrderLink() {
//        assertTrackOrderText();
//    }
//
//    public void assertTrackOrderText() {
//        System.out.println("Given validate the track an order link ");
//        AssertResult(DB_TrackAnOrderLink.getText(), "Track An Order");
//        System.out.println("Should the Track An order link displayed successfully");
//    }
//
//    public void ValidateOneNumberLink() {
//        System.out.println("Given Validate the one number link");
//        if (!ReadResponse.GetSegment().equalsIgnoreCase("PREPAY")) {
//            System.out.println("if the user segment is PREPAY");
//            if (getUser().contains("One")) {
//                assertManageDeviceLinkTextForPREPAY();
//            } else {
//                assertManageDeviceLinkTextForNonPREPAY();
//            }
//        }
//    }
//
//    public void assertManageDeviceLinkTextForNonPREPAY() {
//        System.out.println("else the user not has one number device");
//        scrollDownTo((DB_ConnectAnotherDeviceLink));
//        System.out.println("Scroll Down to the Connect Another Device link");
//        AssertResult(DB_ConnectAnotherDeviceLink.getText(), "Connect another device");
//        System.out.println("Should the Connect Another devices link displayed successfully");
//    }
//
//    public void assertManageDeviceLinkTextForPREPAY() {
//        System.out.println("if the user type is one ");
//        scrollDownTo((DB_ManageYourDeviceLink));
//        System.out.println("Scroll to the manage your devics link");
//        AssertResult(DB_ManageYourDeviceLink.getText(), "Manage your devices");
//        System.out.println("Should the manage your device link displayed successfully");
//    }
//
//
//    public void ValidateOneNumberLinkFunc() {
//        System.out.println("Given the Validate one Number link");
//        if (!ReadResponse.GetSegment().equalsIgnoreCase("PREPAY")) {
//            System.out.println("if the user segment of the user is PREPAY");
//            if (getUser().contains("One")) {
//                assertManageDeviceLinkCTAForPREPAY();
//            } else {
//                assertManageDeviceLinkCTAForNonPREPAY();
//            }
//        }
//    }
//
//    public void assertManageDeviceLinkCTAForNonPREPAY() {
//        System.out.println("else the user not has one number device");
//        scrollDownTo((DB_ConnectAnotherDeviceLink));
//        System.out.println("Scroll down to the connect another devices link");
//        CheckOneNumber((DB_ConnectAnotherDeviceLink));
//        System.out.println("Should the connect to another devices link displayed ");
//    }
//
//    public void assertManageDeviceLinkCTAForPREPAY() {
//        System.out.println("if the user type include one");
//        scrollDownTo((DB_ManageYourDeviceLink));
//        System.out.println("Scroll to Manage your device link");
//        CheckOneNumber((DB_ManageYourDeviceLink));
//        System.out.println("should  one Number ");
//    }
//
//    public void CheckNotificationScreen() {
//        notificationsLinkCTA();
//        assertNotificationTitleText();
//        notificationXIconCTA();
//    }
//
//    public void notificationXIconCTA() {
//        DB_NotificationXicon.click();
//        System.out.println("Click on speed checker x icon ");
//        waitForVisibility((DB_SettingDashboardTray_icon));
//        System.out.println("wait till the dashboard displayed  ");
//    }
//
//    public void assertNotificationTitleText() {
//        waitForVisibility(Notification_title);
//        System.out.println("Wait Notification title");
//        AssertResult(Notification_title.getText(), "My Vodafone Messages");
//        System.out.println("Should the notification title displayed successfully ");
//    }
//
//    public void notificationsLinkCTA() {
//        System.out.println("Given check the notification screen");
//        DB_NotificationsLink.click();
//        System.out.println("Click on the notification link ");
//    }
//
//    public void CheckStoreLocator() {
//        findStoreCTA();
//        assertDoneCTADisplayed();
//        doneCTA();
//    }
//
//    public void doneCTA() {
//        DoneCtaInExternalbrowser.click();
//        System.out.println("Click on the done CTA in external browser");
//        waitForVisibility((DB_SettingDashboardTray_icon));
//        System.out.println("Wait till the dashboard displayed  ");
//    }
//
//    public void assertDoneCTADisplayed() {
//        waitForVisibility(DoneCtaInExternalbrowser);
//        System.out.println("wait till the done external browser by value");
//        AssertDisplayed(DoneCtaInExternalbrowser.isDisplayed());
//        System.out.println("Should the Done Cta In External browser");
//    }
//
//    public void findStoreCTA() {
//        System.out.println("Given the check store locator  ");
//        DB_FindStoreLink.click();
//        System.out.println("Click on find store link");
//    }
//
//    public void CheckTrackAnOrder() {
//        trackOrderCTA();
//        assertTrackOrderTitleText();
//        trackOrderXIconCTA();
//    }
//
//    public void trackOrderXIconCTA() {
//        DB_TrackAnOrderXIcon.click();
//        System.out.println("Click on the x icon ");
//        waitForVisibility((DB_SettingDashboardTray_icon));
//        System.out.println("Wait till the dashboard displayed successfully");
//    }
//
//    public void assertTrackOrderTitleText() {
//        waitForVisibility(DB_TrackAnOrderTitle);
//        AssertResult(DB_TrackAnOrderTitle.getText(), "My Vodafone");
//        System.out.println("Should the WV title displayed ");
//    }
//
//    public void trackOrderCTA() {
//        System.out.println("Given check track An order ");
//        DB_TrackAnOrderLink.click();
//        System.out.println("Click on track an order link");
//    }
//
//    public void BatteryRefreshCTA() {
//        System.out.println("Given check Battery refresh CTA ");
//        scrollDownTo(DB_BatteryRefreshLink);
//        DB_BatteryRefreshLink.click();
//        System.out.println("Click on Battery Refresh CTA link");
//        waitForVisibility(DB_BatteryRefreshXIcon);
//        AssertDisplayed(DB_BatteryRefreshXIcon.isDisplayed());
//    }
//
//    public void BatteryRefreshXIconCTA() {
//        DB_BatteryRefreshXIcon.click();
//        System.out.println("Click on the X icon ");
//        waitForVisibility((DB_SettingDashboardTray_icon));
//        System.out.println("Wait till the dashboard displayed successfully");
//    }
//
//
//    public void CheckFAQs() {
//        FAQCTA();
//        assertDoneCTADisplayedFAQs();
//        DoneCTAAfterFAQs();
//    }
//
//    public void DoneCTAAfterFAQs() {
//        DoneCtaInExternalbrowser.click();
//        System.out.println("Click on Done by external browser ");
//        waitForVisibility((DB_SettingDashboardTray_icon));
//        System.out.println("Wait till the dashboard displayed successfully");
//    }
//
//    public void assertDoneCTADisplayedFAQs() {
//        waitForVisibility(DoneCtaInExternalbrowser);
//        System.out.println("Wait till the done external browser by value");
//        AssertDisplayed(DoneCtaInExternalbrowser.isDisplayed());
//        System.out.println("Should done by CTA in External browser displayed ");
//    }
//
//    public void FAQCTA() {
//        System.out.println("Given check the FAQ");
//        DB_FreqAskQuestLink.click();
//        System.out.println(" Click on the FAQ link");
//    }
//
//    public void CheckOneNumber(WebElement element) {
//        System.out.println("Given check one number");
//        element.click();
//        System.out.println("Click on element ");
//        waitForVisibility(DoneCtaInExternalbrowser);
//        System.out.println("Wait till the done external browser by value ");
//        AssertDisplayed(DoneCtaInExternalbrowser.isDisplayed());
//        System.out.println("Should done CTA in external browser");
//        DoneCtaInExternalbrowser.click();
//        System.out.println("Click on Done CTA in external browser");
//        waitForVisibility((DB_SettingDashboardTray_icon));
//        System.out.println("Wait till the dashboard screen displayed ");
//    }
//
//    public void CheckTradeIN() {
//        TradeInCTA();
//        assertTradInXIconDisplayed();
//        TradeInXIconCTA();
//    }
//
//    public void TradeInXIconCTA() {
//        Trade_XIcon.click();
//    }
//
//    public void assertTradInXIconDisplayed() {
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        waitForVisibility(Trade_XIcon);
//        AssertDisplayed(Trade_XIcon.isDisplayed());
//    }
//
//    public void TradeInCTA() {
//        System.out.println("if the using ios and the user has tradein ");
//        DB_TradeInLink.click();
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("click on TradeIn link");
//    }
//
//    public void expandAssistanceLink() {
//        try {
//            scrollDownTo(DB_SeeLessAssistanceCTA);
//            if (DB_SeeLessAssistanceCTA.getText().equalsIgnoreCase("Show more"))
//                DB_SeeLessAssistanceCTA.click();
//            System.out.println("Assistance link still expanded");
//        } catch (Exception e) {
//            System.out.println("Assistance links collapsed");
//            assistanceLinkSeeMoreCTA();
//        }
//    }
//}

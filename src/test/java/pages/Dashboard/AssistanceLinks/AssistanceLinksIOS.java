package pages.Dashboard.AssistanceLinks;

import models.response.DashboardV4ResponseModel;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utilities.PropertiesLoader;
import utils.DXIDMUtils;
import utils.DashboardUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static utilities.PropertiesLoader.readEnv;
import static utils.element_helpers.ActionsHelpers.*;
import static utils.element_helpers.VerifyHelpers.*;
import static utils.element_helpers.WaitHelpers.*;
import static utils.element_helpers.ScrollHelpers.*;

public class AssistanceLinksIOS extends AssistanceLinksAbstract{
    By assistance_title = By.id("txtDashboardLinksMenuSectionTitle_Assistance");
    By my_account_from_dashboard = By.xpath("//XCUIElementTypeStaticText[@name='My Account']");
    By network_title = By.xpath("//XCUIElementTypeStaticText[@name='txtDashboardLinksMenuSectionTitle_Your Network']");
    DashboardV4ResponseModel DashboardResponse ;
    List AssistanceLinks ;
    Boolean live = System.getProperty("isLiveTest", readEnv("isLiveTest")).equalsIgnoreCase("true");
    List<String> live_assistance_links = Arrays.asList("Frequently Asked Questions", "Battery Refresh Tool","Store Locator",
            "Track An Order","Top Up A Friend","Digital Parenting");


    public AssistanceLinksIOS(){
        super();
        if(!live){
            DashboardResponse = DashboardUtils.GetDashboard();
            AssistanceLinks = DashboardResponse.linksMenu.menuItems.get(1).subItems;
        }
    }
    List<WebElement> AssistanceLinksElements = new ArrayList<>();
    List<String> linkElements;

    public List<WebElement> AssistanceLinks(){
        List<WebElement> elements = new ArrayList<>();
        linkElements = getAPIAssistanceLinksText();
        for (String text : linkElements ) {
            elements.add(driver.findElement(By.xpath("//*[@label='" + text + "']")));
        }
        return elements;
    }


    public void AssistanceLinksStatus(){
        waitForVisibility(DB_SettingDashboardTray_icon);
        assertAssistanceStatus();
        scrollDownTo((DB_AssistanceTitle));
//        scrollDownTo(driver.findElementByXPath("//*[@text='Assistance']"));
    }

    public void assertAssistanceStatus() {
        Assert.assertEquals(DashboardResponse.linksMenu.status.analytics.status, "Success");
    }

    public void assertOnlyFourLinksDisplayed(int count){
        try {
            // this function will be used if the "assistance links" business changed to be more than 5 links with see more CTA
//            assistanceLinkSeeMoreCTA();
            scrollDownToAssistanceLinks();
//            scrollUpTo(DB_AssistanceTitle);
            AssistanceLinksElements = AssistanceLinks();
            DB_SeeLessAssistanceCTA.click();
//            assistanceLinkSeeLessCTA();
//            scrollUpTo(DB_AllowanceTileHeader);
            if(DB_SeeMoreAssistanceCTA.getText().equals("Show more")) {
                for(int i=0;i<count;i++) {
                    Assert.assertTrue(AssistanceLinksElements.get(i).isDisplayed());
                }
                for(int j=count;j<getAPIAssistanceLinksText().size();j++) {
                    Assert.assertFalse(AssistanceLinksElements.get(j).isDisplayed());
                }
            }
        }
        catch (Exception e){
            System.out.println("Less than six links");
            AssistanceLinksElements = AssistanceLinks();
            System.out.println(AssistanceLinks().size());
            for(int i=0;i<AssistanceLinksElements.size();i++){
                System.out.println(AssistanceLinksElements.get(i).getText());
                Assert.assertTrue(AssistanceLinksElements.get(i).isDisplayed());
            }
        }
    }

    @Override
    public void assertNotificationsIsRemoved() {
        scrollDownElementOverCenterScreen(DB_AssistanceTitle);
        for (String assistanceLinksText : getAPIAssistanceLinksText()) {
            System.out.println(assistanceLinksText);
            AssertResultNotEqual(assistanceLinksText, "Notifications");
        }
        HardAssertNotDisplayed("Notifications",elementIsPresent(DB_NotificationsLink));
    }

    public void assistanceLinkSeeMoreCTA() {
        if(AssistanceLinks.size()>5) {
            scrollDownToAssistanceLinks();
            scrollDownTo(DB_SeeMoreAssistanceCTA);
            waitForVisibility(DB_SeeMoreAssistanceCTA);
            DB_SeeMoreAssistanceCTA.click();
        }
    }

    public void assertAssistanceTitleText(){
        if(live){
            waitForVisibility(my_account_from_dashboard);
            scrollDownTo(assistance_title);
            Assert.assertTrue(driver.findElement(assistance_title).isDisplayed());

        }else {
            AssertResult(DB_AssistanceTitle.getText(), DashboardResponse.linksMenu.menuItems.get(1).title);
        }
    }

    public void ValidateAssistanceLinksOrderAndText(){

        if(live){
            validateLinksLive(live_assistance_links);

        }else {
            assistanceLinkSeeMoreCTA();
            AssistanceLinksElements = AssistanceLinks();
            scrollUpTo(DB_AssistanceTitle);
            for (int k = 0; k < getAPIAssistanceLinksText().size(); k++) {
                try {
                    scrollDownTo((AssistanceLinksElements.get(k)));
                } catch (Exception e) {
                    scrollDownTo((DB_SeeMoreAssistanceCTA));
                    DB_SeeMoreAssistanceCTA.click();
                    scrollDownTo(AssistanceLinksElements.get(k));
                }
                Assert.assertEquals(getAPIAssistanceLinksText().get(k), AssistanceLinksElements.get(k).getText());
            }
        }
    }
    private void validateLinksLive(List live_assistance_links ){
        for(int i = 0 ; i < live_assistance_links.size();i++){
            if(i<live_assistance_links.size()-1){
                scrollDownTo(network_title);
                scrollUpTo(By.xpath("//*[@label='" + live_assistance_links.get(i) + "']"));
                System.out.println(live_assistance_links.get(i));
            } else {
                scrollDownTo((DB_SeeMoreAssistanceCTA));
                DB_SeeMoreAssistanceCTA.click();
                verifyAllElementsPresent(By.xpath("//*[@value='Digital Parenting']"));
            }
        }
    }

    @Override
    public void ValidateAssistanceLinksOrderAndTextAfterNotificationIsRemoved() {
        AssistanceLinksElements = AssistanceLinks();
        scrollUpTo(DB_AssistanceTitle);
        for (int k = 0; k < getAPIAssistanceLinksText().size(); k++) {
            Assert.assertEquals(getAPIAssistanceLinksText().get(k), AssistanceLinksElements.get(k).getText());
            System.out.println(getAPIAssistanceLinksText().get(k));
            System.out.println( AssistanceLinksElements.get(k).getText());
        }
    }

    public List<String> getAPIAssistanceLinksText(){
        List<String> APIAssistanceLinksText = new ArrayList<>();
        for(int j=0;j<AssistanceLinks.size();j++){
            APIAssistanceLinksText.add(DashboardResponse.linksMenu.menuItems.get(1).subItems.get(j).title);
        }
        return APIAssistanceLinksText;
    }

    public void ValidateAssistanceLinksCTA(){
        assistanceLinkSeeMoreCTA();
        AssistanceLinksElements = AssistanceLinks();
        List<WebElement> listOfAssistanceWebElements = AssistanceLinks();
        scrollUpTo(DB_AssistanceTitle);
        for (WebElement assitanceLinksLocator : listOfAssistanceWebElements) {
//            waitForVisibility(DB_BillingTray_icon);
            System.out.println("Current assistance link is: "+assitanceLinksLocator.getText());
            scrollDownToAssistanceLinks();
            scrollUpTo(assitanceLinksLocator);
            switch (assitanceLinksLocator.getText()) {
                case "Free Business Support":
                    assitanceLinksLocator.click();
                    assertDoneCTADisplayedFreeBusiness();
                    DoneCTAAfterFreeBusiness();
                    break;
//                case "Notifications":
//                    CheckNotificationScreen();
//                    break;
                case "Frequently Asked Questions":
                    assitanceLinksLocator.click();
                    CheckFAQs();
                    break;
      /*        case "Trade In Tool":
                    CheckTradeIN();
                    break;*/
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
        try {
            waitForVisibility(AcceptCookies);
            AcceptCookies.click();
        } catch (Exception e) {
            System.out.println("Cookies popup not displayed");
        }
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



    public void checkManageYouDevice(){
        waitForVisibility(DoneCtaInExternalbrowser);
        AssertDisplayed(DoneCtaInExternalbrowser.isDisplayed());
        DoneCtaInExternalbrowser.click();
        waitForVisibility((DB_SettingDashboardTray_icon));
    }

    public void checkTopUpFriend(){
        waitForVisibility(DoneCtaInExternalbrowser);
        AssertDisplayed(DoneCtaInExternalbrowser.isDisplayed());
        AssertDisplayed(topUpInternalWebviewTitle.isDisplayed());
        DoneCtaInExternalbrowser.click();
        waitForVisibility((DB_SettingDashboardTray_icon));
    }

    /*public void checkConnectAnotherDevice(){
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
        Assert.assertTrue(trackAnOrderInternalWebViewTitle.isDisplayed());
    }


    public void checkBatteryRefresh(){
        assertBatteryRefreshXIconDisplayed();
        BatteryRefreshBackCTA();
    }

    public void BatteryRefreshBackCTA() {
        DB_BatteryRefreshXIcon.click();
    }

    public void assertBatteryRefreshXIconDisplayed() {
        try {
            Thread.sleep(20000);
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



    public void CheckTradeIN() {
        assertTradInXIconDisplayed();
        TradeInXIconCTA();
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
        scrollDownTo(DB_SeeLessAssistanceCTA);
        if(DB_SeeLessAssistanceCTA.isDisplayed()) {
            DB_SeeLessAssistanceCTA.click();
            scrollUpTo(DB_AssistanceTitle);
        }
    }

    @Override
    public void scrollDownToAssistanceLinks() {
        waitForVisibility(DB_SettingDashboardTray_icon);
//        scrollDownTo(ShopLinks_AddExtra);
//        waitForVisibility(ShopLinks_AddExtra);
        scrollDownTo((driver.findElement(By.id("txtDashboardLinksMenuSectionTitle_Your Network"))));
        waitForVisibility(DB_NetworkTitle);
//        scrollUpTo(DB_AssistanceTitle);
    }
    @Override
    public void CheckChildAssistanceLinks() {
        if (System.getProperty("isLiveTest", PropertiesLoader.readEnv("isLiveTest")).equalsIgnoreCase("false")) {
            //need to get authCode from subswitch idJourney to get the right child response
            DashboardV4ResponseModel DashboardResp = DashboardUtils.GetDashboard(
                    System.getProperty("SwitchedMSISDN"),
                    System.getProperty("SwitchedSegment"),
                    System.getProperty("SwitchedSubsType"),
                    DXIDMUtils.getLOA1Token(System.getProperty("SwitchedMSISDN")),
                    System.getProperty("SwitchedAccount"));
            for (int i = 0; i <DashboardResp.linksMenu.menuItems.size() ; i++) {
                if(DashboardResp.linksMenu.menuItems.get(i).title.equals("Assistance")){
                    int AssistanceLinksNum=DashboardResp.linksMenu.menuItems.get(i).subItems.size();
                    if(AssistanceLinksNum>5){
                        DB_SeeMoreAssistanceCTA.click();
                    }
                    for (int j = 0; j < DB_AssistanceLinks.size(); j++) {
                        if(DB_AssistanceLinks.get(j).getText().equals("Network Status Checker"))
                            break;
                        Assert.assertEquals(DB_AssistanceLinks.get(j).getText(),DashboardResp.linksMenu.menuItems.get(i).subItems.get(j).title);
                    }
                    break;
                }
            }
        }else {
            Assertions.assertTrue(FrequentlyAskedQuestions.isDisplayed());
            Assertions.assertTrue(DB_BatteryRefresh.isDisplayed());
            Assertions.assertTrue(StoreLocator.isDisplayed());
            Assertions.assertTrue(DB_TrackAnOrder.isDisplayed());
            Assertions.assertTrue(DigitalParenting.isDisplayed());
            HardAssertNotDisplayed("Show more", elementIsPresent(DB_SeeMoreAssistanceCTA));
        }
    }

    @Override
    public void ClickOnBatteryRefresh() {
        waitForVisibility(DB_BatteryRefreshLink);
        doubleClick(DB_BatteryRefreshLink);
    }

    @Override
    public void ValidateBatteryRefreshPage() {
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        waitForVisibility(DB_BatteryRefreshXIcon);
        waitForVisibility(DB_BatteryRefresh);
        Assert.assertTrue(DB_BatteryRefreshXIcon.isDisplayed());
        Assert.assertTrue(DB_BatteryRefresh.isDisplayed());
    }

    @Override
    public void CheckBatteryRefreshExistence() {
        if(DB_SeeMoreAssistanceCTA.isDisplayed()){
            DB_SeeMoreAssistanceCTA.click();
        }
        waitForVisibility(DB_BatteryRefreshLink);
        Assert.assertTrue(DB_BatteryRefreshLink.isDisplayed());
    }

    @Override
    public void checkFreeBuisnessSupport(){
        waitForVisibility(DB_FreeBusinessSupportCTA);
        AssertDisplayed(DB_FreeBusinessSupportCTA.isDisplayed());

        DB_FreeBusinessSupportCTA.click();
        DB_FreeBusinessSupportCTA.click();
        waitForVisibility(CustomeTabBar);
        AssertDisplayed(CustomeTabBar.isDisplayed());

    }
    @Override
    public void checkBatteryRefreshForPAYG(){
        waitForVisibility(DB_AssistanceTitle);
        HardAssertNotDisplayed("Battery Refresh Tool", elementIsPresent(DB_BatteryRefreshLink));
    }
}
package pages.Dashboard.NetworkLinks;

import models.response.DashboardV4ResponseModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utilities.PropertiesLoader;
import utils.DashboardUtils;

import java.util.ArrayList;
import java.util.List;

import static utils.element_helpers.ActionsHelpers.doubleClick;
import static utils.element_helpers.GenericHelpers.navigateBackForiOS;
import static utils.element_helpers.ScrollHelpers.scrollDownElementOverCenterScreen;
import static utils.element_helpers.ScrollHelpers.scrollDownTo;
import static utils.element_helpers.TextHelpers.getElementByText;
import static utils.element_helpers.VerifyHelpers.*;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

public class NetworkLinksIOS extends NetworkLinksAbstract{

    public NetworkLinksIOS(){
        super();
    }

    private static DashboardV4ResponseModel DashboardResponse;
    Boolean live = System.getProperty("isLiveTest", PropertiesLoader.readEnv("isLiveTest")).equalsIgnoreCase("true");
    By network_status_checker = By.xpath("//XCUIElementTypeStaticText[@name='DashboardLinksMenuCellLeftIcon_Network Status Checker']");
    By check_data_and_wifi_speed = By.xpath("//XCUIElementTypeStaticText[@name='DashboardLinksMenuCellLeftIcon_Check Data and Wi-Fi Speed']");

    public void assertNetworkStatus() {
        DashboardResponse = DashboardUtils.GetDashboard();
        Assert.assertEquals(DashboardResponse.linksMenu.status.analytics.status, "Success");
    }

    public List<WebElement> NetworkLinks(){
        List<WebElement> networkList= new ArrayList<>();
        for(String link : getAPINetworkLinksText()){
            networkList.add(getElementByText(link));
        }
        return networkList;
    }

    public void NetworkLinksStatus(){
        waitForVisibility(DB_SettingDashboardTray_icon);
        scrollDownElementOverCenterScreen(DB_NetworkCheckerLink);
        if (!live)assertNetworkStatus();
    }

    public void assertNetworkTitleText() {
        if (live) {
            assertEquals("Your Network", DB_NetworkTitle.getText());
        } else {
            assertEquals(DashboardResponse.linksMenu.menuItems.get(2).title, DB_NetworkTitle.getText());
            System.out.println(DashboardResponse.linksMenu.menuItems.get(2).title);
        }
    }

    public List<String> getAPINetworkLinksText(){
        List<String> APINetworkLinksText = new ArrayList<>();
        for(int j=0;j<DashboardResponse.linksMenu.menuItems.get(2).subItems.size();j++){
            APINetworkLinksText.add(DashboardResponse.linksMenu.menuItems.get(2).subItems.get(j).title);
        }
        return APINetworkLinksText;
    }

    public void ValidateNetworkLinksOrderAndText(){
        if(live){
            scrollAndVerifyElements(network_status_checker,check_data_and_wifi_speed);
        }else {
            List<WebElement> ListOfWebelements = NetworkLinks();
            List<String> APIList = getAPINetworkLinksText();
            for (int k = 0; k < DashboardResponse.linksMenu.menuItems.get(2).subItems.size(); k++) {
                System.out.println(APIList.get(k));
                System.out.println(ListOfWebelements.get(k).getText());
                Assert.assertEquals(getAPINetworkLinksText().get(k), NetworkLinks().get(k).getText());

            }
        }
    }

    public void ValidateNetworkLinksCTA() {
        if (System.getProperty("isLiveTest", PropertiesLoader.readEnv("isLiveTest")).equalsIgnoreCase("false")) {
            List<WebElement> ListOfWebelements = NetworkLinks();
            for (WebElement networkLinksLocator : ListOfWebelements) {
                scrollDownTo(networkLinksLocator);
                waitForVisibility(networkLinksLocator);
                switch (networkLinksLocator.getText()) {
                    case "Network Status Checker":
                        doubleClick(networkLinksLocator);
                        checkNetworkStatusJourney();
                        break;
                    case "Check Data and Wi-Fi Speed":
                        doubleClick(networkLinksLocator);
                        checkDataWIFIJourney();
                        break;
                }
            }}else {
            doubleClick(DB_NetworkStatusCheckerIcon);
            checkNetworkStatusJourney();
            doubleClick(CheckDataAndWiFiSpeed);
            checkDataWIFIJourney();
        }
    }

    public void checkNetworkStatusJourney() {
        assertNetworkStatusTitleText();
        NetworkScreenXIcon.click();
        scrollDownTo(DB_NetworkCheckerLink);
        waitForVisibility(DB_NetworkCheckerLink);
    }

    public void assertNetworkStatusTitleText() {
        waitForVisibility(DB_NetworkStatus_title);
        AssertResult(DB_NetworkStatus_title.getText(), "Network Status Checker");
    }


    public void checkDataWIFIJourney() {
        assertSpeedCheckerTitleText();
        doubleClick(DB_speedCheckerXicon);
    }

    public void assertSpeedCheckerTitleText() {
        waitForVisibility(DB_speedChecker_title);
        AssertResult(DB_speedChecker_title.getText(), "Speed checker");
    }

    @Override
    public void scrollDownToBroadBandServiceTest() {
        scrollDownTo(BroadBandServiceTestLink);
        waitForVisibility(BroadBandServiceTestLink);
        BroadBandServiceTestLink.click();
    }

    @Override
    public void ValidateUserName() {
        waitForVisibility(DX_IDM_Username);
        Assert.assertTrue(DX_IDM_Username.isDisplayed());
    }

    @Override
    public void ValidateBroadBandServiceTestLink() {
        waitForVisibility(BroadBandServiceTestLink);
        Assert.assertTrue(BroadBandServiceTestLink.isDisplayed());
    }

    @Override
    public void navigateBack(){
        navigateBackForiOS();

    }
}

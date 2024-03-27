package pages.Dashboard.ConnectedApps;

import models.response.DashboardV4ResponseModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.DashboardUtils;

import java.util.ArrayList;
import java.util.List;

import static utilities.PropertiesLoader.readEnv;
import static utils.element_helpers.ScrollHelpers.scrollDown;
import static utils.element_helpers.VerifyHelpers.AssertDisplayed;
import static utils.element_helpers.VerifyHelpers.AssertResult;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

public class ConnectedAppsIOS extends ConnectedAppsAbstract{
    Boolean live = System.getProperty("isLiveTest", readEnv("isLiveTest")).equalsIgnoreCase("true");
    DashboardV4ResponseModel DashboardResponse ;

    public ConnectedAppsIOS(){
        super();
        if(!live) {
            DashboardResponse = DashboardUtils.GetDashboard();
        }
    }


    public List<WebElement> ConnectedAppsImgs() {
        List<WebElement> elements = new ArrayList<>();
        elements = driver.findElements(By.xpath("//*[@name='Other Vodafone Apps']/following::*[@type='XCUIElementTypeImage']"));
        return elements;
    }

    public List<WebElement> ConnectedAppsTexts() {
        List<WebElement> elements = new ArrayList<>();
        elements = driver.findElements(By.xpath("//XCUIElementTypeCell/XCUIElementTypeStaticText[contains(@name,'txtConnectedAppsLabel_')]"));
        return elements;
    }

    public List<WebElement> ConnectedAppsCTAs() {
        List<WebElement> elements = new ArrayList<>();
        elements = driver.findElements(By.xpath("//XCUIElementTypeCell/XCUIElementTypeButton[contains(@name,'Get')]"));
        return elements;
    }

    public void scrollToConnectedApps(){
        scrollDown();
        scrollDown();
        scrollDown();
        scrollDown();
        scrollDown();
        scrollDown();
    }

    public void checkConnectedAppsImgs(){
        waitForVisibility(DB_MyAccountTray_icon);
        scrollToConnectedApps();
        AssertDisplayed(DB_ConnectedAppsTitle.isDisplayed());
        List<WebElement> connectedApps = ConnectedAppsImgs();
        for (WebElement connectedApp:connectedApps) {
            AssertDisplayed(connectedApp.isDisplayed());
        }
    }

    public void checkConnectedAppsTitles(){
        AssertDisplayed(DB_DreamLabApp.isDisplayed());
        AssertDisplayed(DB_VodafoneBroadbandApp.isDisplayed());
        AssertDisplayed(DB_VodafoneSecureNet.isDisplayed());
    }

    public void checkConnectedAppsTextOrder(){
        for(int i = 0; i < DashboardResponse.connectedApps.items.size(); i++) {
            AssertResult(ConnectedAppsTexts().get(i).getText(),DashboardResponse.connectedApps.items.get(i).title);
            System.out.println(ConnectedAppsTexts().get(i).getText());
            System.out.println(DashboardResponse.connectedApps.items.get(i).title);
            AssertDisplayed(ConnectedAppsCTAs().get(i).isDisplayed());
        }
    }
}

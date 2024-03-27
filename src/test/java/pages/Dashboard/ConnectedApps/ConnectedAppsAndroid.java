package pages.Dashboard.ConnectedApps;

import models.response.DashboardV4ResponseModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.DashboardUtils;

import java.util.ArrayList;
import java.util.List;

import static utilities.PropertiesLoader.readEnv;
import static utils.element_helpers.ScrollHelpers.scrollDownTo;
import static utils.element_helpers.ScrollHelpers.scrollToElement;
import static utils.element_helpers.VerifyHelpers.AssertDisplayed;
import static utils.element_helpers.VerifyHelpers.AssertResult;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

public class ConnectedAppsAndroid extends ConnectedAppsAbstract{
    Boolean live = System.getProperty("isLiveTest", readEnv("isLiveTest")).equalsIgnoreCase("true");
    DashboardV4ResponseModel DashboardResponse;

    public ConnectedAppsAndroid(){
        super();
        if(!live){
            DashboardResponse = DashboardUtils.GetDashboard();
        }
    }

    public List<WebElement> ConnectedAppsImgs() {
        List<WebElement> elements = new ArrayList<>();
            elements = driver.findElements(By.xpath("//*[@text='Other Vodafone Apps']/parent::*//android.widget.ImageView[@resource-id='com.myvodafoneapp:id/iconImageView']"));
            return elements;
    }

    public List<WebElement> ConnectedAppsTexts() {
        List<WebElement> elements = new ArrayList<>();
        elements = driver.findElements(By.xpath("//*[@text='Other Vodafone Apps']/parent::*//android.widget.TextView[@resource-id='com.myvodafoneapp:id/nameTextView']"));
        return elements;
    }

    public List<WebElement> ConnectedAppsCTAs() {
        List<WebElement> elements = new ArrayList<>();
        elements = driver.findElements(By.xpath("//*[@text='Other Vodafone Apps']/parent::*//android.widget.LinearLayout[@resource-id='com.myvodafoneapp:id/ctaButton']"));
        return elements;
    }

    public void checkConnectedAppsImgs(){
        waitForVisibility(DB_MyAccountTray_icon);
        scrollToElement(DB_VodafoneSecureNet,10);
        List<WebElement> connectedApps = ConnectedAppsImgs();
        for (WebElement connectedApp:connectedApps) {
            AssertDisplayed(connectedApp.isDisplayed());
        }
    }

    public void checkConnectedAppsTitles(){
        scrollDownTo(DB_VodafoneSecureNet);
        AssertDisplayed(DB_DreamLabApp.isDisplayed());
        AssertDisplayed(DB_VodafoneBroadbandApp.isDisplayed());
        AssertDisplayed(DB_VodafoneSecureNet.isDisplayed());
    }

    public void checkConnectedAppsTextOrder(){
        scrollDownTo(DB_VodafoneSecureNet);
        for(int i = 0; i < DashboardResponse.connectedApps.items.size() - 1; i++) {
            AssertResult(ConnectedAppsTexts().get(i).getText(),DashboardResponse.connectedApps.items.get(i).title);
            AssertDisplayed(ConnectedAppsCTAs().get(i).isDisplayed());
            }
        }
}

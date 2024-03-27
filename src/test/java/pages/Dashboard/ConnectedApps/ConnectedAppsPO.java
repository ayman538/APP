package pages.Dashboard.ConnectedApps;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.Commons.CommonPo;


public class ConnectedAppsPO extends CommonPo {

 
            @AndroidFindBy(xpath = "//*[@text='Other Vodafone Apps']")
            @iOSXCUITFindBy(xpath = "//*[@label='Other Vodafone Apps']")
     public WebElement DB_ConnectedAppsTitle;
 
            @AndroidFindBy(xpath = "//*[@text='DreamLab']")
            @iOSXCUITFindBy(id = "txtConnectedAppsLabel_DreamLab")
     public WebElement DB_DreamLabApp;

            @AndroidFindBy(xpath = "(//*[@text='DreamLab']/following::*[@resource-id='" + "com.myvodafoneapp:id/ctaButton'][1])")
            @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='Get'])[1]")
     public WebElement DB_DreamLabAppCTA;
 
            @AndroidFindBy(xpath = "//*[@text='Vodafone Broadband']")
            @iOSXCUITFindBy(id = "txtConnectedAppsLabel_Vodafone Broadband")
     public WebElement DB_VodafoneBroadbandApp;

            @AndroidFindBy(xpath = "(//*[@text='Vodafone Broadband']/following::*[@resource-id='" + "com.myvodafoneapp:id/ctaButton'][1])")
            @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='Get'])[2]")
     public WebElement DB_VodafoneBroadbandAppCTA;


    public ConnectedAppsPO() {
        super();
    }
}

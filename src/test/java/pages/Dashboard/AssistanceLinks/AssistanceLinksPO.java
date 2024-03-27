package pages.Dashboard.AssistanceLinks;

import io.appium.java_client.pagefactory.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.Commons.CommonPo;
import java.util.ArrayList;
import java.util.List;


public class AssistanceLinksPO extends CommonPo {


            @AndroidFindBy(xpath = "//*[@text='Notifications']")
            @iOSXCUITFindBy(id = "txtDashboardLinksMenuCellLabel_Notifications")
    public WebElement DB_NotificationsLink;

            @AndroidFindBy(xpath = "//*[@text='Trade In Tool']")
            @iOSXCUITFindBy(id = "txtDashboardLinksMenuCellLabel_Trade-in Tool")
    public WebElement DB_TradeInLink;

            @AndroidFindBy(xpath = "(//*[@class='android.widget.Button'])[1]")
            @iOSXCUITFindBy(xpath = "(//*[@type='XCUIElementTypeButton'])")
    public WebElement Trade_XIcon;
            @AndroidFindAll({
                    @AndroidBy(xpath = "(//*[@resource-id='com.myvodafoneapp:id/showTextView'])[1]"),
                    @AndroidBy(xpath = "(//*[@text='Your Network'])[2]"),


            })
            @iOSXCUITFindAll({
                    @iOSXCUITBy(xpath = "(//*[@label='Your Network'])[2]"),
                    @iOSXCUITBy(xpath = "(//XCUIElementTypeStaticText[@name='btnDashboardLinksMenuSHOWMORECTA'])[2]"),
                    @iOSXCUITBy(xpath = "//*[@name='btnDashboardLinksMenuSHOWMORECTA']"),
                    @iOSXCUITBy(id = "btnDashboardLinksMenuSHOWMORECTA")
            })
    public WebElement DB_SeeMoreAssistanceCTA;

            @AndroidFindBy(xpath = "//*[@text='Connect another device']")
            @iOSXCUITFindBy(id = "txtDashboardLinksMenuCellLabel_Connect another device")
    public WebElement DB_ConnectAnotherDeviceLink;

            @AndroidFindBy(xpath = "//*[@text='Show less']")
            @iOSXCUITFindBy(id = "Show less")
    public WebElement DB_SeeLessAssistanceCTA;

            @AndroidFindAll({
                    @AndroidBy(xpath = "//*[@resource-id='com.myvodafoneapp:id/tvTitle']"),
                    @AndroidBy(id = "com.myvodafoneapp:id/webview_title"),
            })
            @iOSXCUITFindAll({
                    @iOSXCUITBy(xpath = "//XCUIElementTypeStaticText[@name='My Vodafone']"),
                    @iOSXCUITBy(xpath = "//*[@name='My Vodafone']")
            })
    public WebElement DB_TrackAnOrderTitle;

            @AndroidFindBy(xpath = "//*[@name='Track my order']")
            @iOSXCUITFindBy(xpath = "//*[@name='Track my order']")
    public WebElement trackAnOrderInternalWebViewTitle;

            @AndroidFindAll({
                    @AndroidBy(id = "com.myvodafoneapp:id/btnClose"),
                    @AndroidBy(xpath = "//*[@resource-id='com.myvodafoneapp:id/btnClose']"),
                    @AndroidBy(id = "com.myvodafoneapp:id/img_close"),
            })
            @iOSXCUITFindAll({
                    @iOSXCUITBy(xpath = "(//*[@name='txtScreenTitleLabel']/following::*[@type='XCUIElementTypeButton'])[1]"),
                    @iOSXCUITBy(id = "VFGwebCloseButton")
            })
    public WebElement DB_TrackAnOrderXIcon;

            @AndroidFindBy(xpath = "//*[@text='Battery Refresh Tool']")
            @iOSXCUITFindAll({
                    @iOSXCUITBy(xpath = "//*[@label='Battery Refresh Tool']"),
                    @iOSXCUITBy(xpath = "//*[@name='DashboardLinksMenuCellLeftIcon_Battery Refresh Tool']")
            })
    public WebElement DB_BatteryRefreshLink;

            @AndroidFindBy(xpath = "//*[@text='Assistance']/parent::*//android.widget.TextView[@resource-id='com.myvodafoneapp:id/nameTextView']")
            @iOSXCUITFindBy(xpath = "//*[@name='Assistance']/following::*[@type='XCUIElementTypeCell']/child::*[@type='XCUIElementTypeStaticText']")
    public List<WebElement> DB_AssistanceLinks;




    public AssistanceLinksPO() {
        super();
    }


}

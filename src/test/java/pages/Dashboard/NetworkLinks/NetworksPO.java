package pages.Dashboard.NetworkLinks;

import io.appium.java_client.pagefactory.*;
import org.openqa.selenium.WebElement;
import pages.Commons.CommonPo;

public class NetworksPO extends CommonPo {

    @AndroidFindBy(xpath = "//*[@text='Your Network']")
    @iOSXCUITFindBy(id = "txtDashboardLinksMenuSectionTitle_Your Network")
    public WebElement DB_NetworkTitle;

    @AndroidFindBy(xpath = "//*[@text='Network Status Checker']")
    @iOSXCUITFindAll({
            @iOSXCUITBy(id = "DashboardLinksMenuCellLeftIcon_Network Status Checker"),
            @iOSXCUITBy(id = "txtDashboardLinksMenuCellLabel_Network Status Checker")
    })
    public WebElement DB_NetworkCheckerLink;

    @AndroidFindBy(xpath = "//*[@text='Check Data and Wi-Fi Speed']")
    @iOSXCUITFindAll({
            @iOSXCUITBy(id = "DashboardLinksMenuCellLeftIcon_Check Data and Wi-Fi Speed"),
            @iOSXCUITBy(id = "txtDashboardLinksMenuCellLabel_Check Data and Wi-Fi Speed")
    })
    public WebElement DB_CheckDataSpeedLink;

    @AndroidFindBy(xpath = "//*[@text='Broadband Service Test']")
    @iOSXCUITFindBy(xpath = "//*[@label='Broadband Service Test']")
    public WebElement BroadBandServiceTestLink;

    @AndroidFindBy(id = "com.myvodafoneapp:id/webview_title")
    @iOSXCUITFindAll({
            @iOSXCUITBy(id = "tvTitle"),
            @iOSXCUITBy(xpath = "//XCUIElementTypeOther[@name='Network Status Checker']"),
            @iOSXCUITBy(id = "Network Status Checker"),
            @iOSXCUITBy(id = "DashboardLinksMenuCellLeftIcon_Network Status Checker")
    })
    public WebElement DB_NetworkStatus_title;

    @AndroidFindBy(xpath = "//*[@text='Speed checker']")
    @iOSXCUITFindAll({
            @iOSXCUITBy(id = "Speed checker"),
            @iOSXCUITBy(id = "DashboardLinksMenuCellLeftIcon_Check Data and Wi-Fi Speed")
    })
    public WebElement DB_speedChecker_title;

    @AndroidFindAll({
            @AndroidBy(id = "com.myvodafoneapp:id/img_close"),
            @AndroidBy(id = "com.myvodafoneapp:id/btnClose")
    })
    @iOSXCUITFindBy(id = "VFGwebCloseButton")
    public WebElement NetworkScreenXIcon;

    @AndroidFindAll({
            @AndroidBy(id = "com.myvodafoneapp:id/dismissImageView"),
            @AndroidBy(xpath = "//android.widget.ImageView[@content-desc='NPcloseIcon']")
    })
    @iOSXCUITFindAll({
            @iOSXCUITBy(id = "closeButtonSpeedCheckerView"),
            @iOSXCUITBy(id = "closeIcon")
    })
    public WebElement DB_speedCheckerXicon;

    @AndroidFindBy(id = "com.myvodafoneapp:id/dashboardActionButton")
    @iOSXCUITFindBy(id = "NPtestNetworkSpeedButtonBtn")
    public WebElement DB_StartSpeedTestCTA;

    @AndroidFindBy(id = "com.myvodafoneapp:id/speed_checker_title_text_view")
    @iOSXCUITFindBy(xpath = "(//*[@name='Retest'])[1]")
    public WebElement DB_StartSpeedRetestCTA;

    public NetworksPO() {
        super();
    }

}

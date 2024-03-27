package pages.Dashboard.EshopLinks;

import io.appium.java_client.pagefactory.*;
import org.openqa.selenium.WebElement;
import pages.Commons.CommonPo;


public class EshopLinksPO extends CommonPo {

    public EshopLinksPO() {
        super();
    }

    @AndroidFindBy(xpath = "(//*[@class='android.widget.Button'])[1]")
    @iOSXCUITFindBy(xpath = "/XCUIElementTypeApplication/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeWebView/XCUIElementTypeWebView/XCUIElementTypeWebView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeButton")
    public WebElement Trade_XIcon;

    @AndroidFindAll({
            @AndroidBy(xpath = "//*[@text='Show more']"),
            @AndroidBy(id = "com.myvodafoneapp:id/showTextView")
    })
    @iOSXCUITFindBy(id = "btnDashboardLinksMenuSHOWMORECTA")
    public WebElement DB_SeeMoreEshopCTA;

    @AndroidFindBy(xpath = "//*[@resource-id='com.myvodafoneapp:id/closeImg']")
    @iOSXCUITFindAll({
            @iOSXCUITBy(id = "btnClose"),
            @iOSXCUITBy(xpath = "//XCUIElementTypeButton[@name='VFGwebCloseButton']")
    })
    public WebElement closeInternalWebview;

    @AndroidFindBy(xpath = "//*[@text='Show less']")
    @iOSXCUITFindBy(xpath = "//*[@label='Show less']")
    public WebElement DB_SeeLessEshopCTA;
}

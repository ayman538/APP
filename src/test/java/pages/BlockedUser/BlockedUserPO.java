package pages.BlockedUser;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.Commons.CommonPo;


public class BlockedUserPO extends CommonPo {


    @AndroidFindBy(xpath = "(//*[@resource-id='" + "com.myvodafoneapp:id/txtTitle'])[1]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='txtTitle'])[1]")
    public WebElement BlockedU_CantUseTitle;

    @AndroidFindBy(xpath = "(//*[@resource-id='" + "com.myvodafoneapp:id/txtDescription'])[1]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='txtDescription'])[1]")
    public WebElement BlockedU_CantUseText;

    @AndroidFindBy(xpath = "(//*[@resource-id='" + "com.myvodafoneapp:id/btnActionCTA'])[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@label='Go to FAQs']")
    public WebElement BlockedU_FAQsCTA;

    @AndroidFindBy(xpath = "(//*[@resource-id='" + "com.myvodafoneapp:id/txtTitle'])[2]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='txtTitle'])[2]")
    public WebElement BlockedU_SettingTitle;

    @AndroidFindBy(xpath = "(//*[@resource-id='" + "com.myvodafoneapp:id/txtDescription'])[2]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='txtDescription'])[2]")
    public WebElement BlockedU_SettingText;

    @AndroidFindBy(xpath = "(//*[@resource-id='" + "com.myvodafoneapp:id/btnActionCTA'])[2]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@label='Go to settings']")
    public WebElement BlockedU_GoToSettingCTA;

    public BlockedUserPO() {
        super();
    }
}

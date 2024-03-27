package pages.SubsctionOverlay.NewPlanDesign;

import io.appium.java_client.pagefactory.*;
import org.openqa.selenium.WebElement;
import pages.Commons.CommonPo;

public class UnlimitedDataBoosterPO extends CommonPo {

    @AndroidFindBy(xpath = "//*[@text='Unlimited Data Booster']")
    @iOSXCUITFindAll({
            @iOSXCUITBy(xpath = "//*[@label='Unlimited Data Booster']"),
            @iOSXCUITBy(id = "Unlimited Data Booster"),
            @iOSXCUITBy(xpath = "//*[@name='Unlimited Data Booster']")
    })
    public WebElement unlimitedDataBoosterButton;

    @AndroidFindAll({
            @AndroidBy(id = "com.myvodafoneapp:id/btnIncludesShowMore"),
            @AndroidBy(xpath = "//*[@value='Show more']")
    })
    @iOSXCUITFindAll({
            @iOSXCUITBy(id = "Show more"),
            @iOSXCUITBy(xpath = "//XCUIElementTypeStaticText[@name=\"Show more\"]")
    })

    public WebElement Includes_seeMore;

    @AndroidFindBy(id = "com.myvodafoneapp:id/txtDetailedProductPageTitle")
    public WebElement unlimitedDataScreenTitle;

    @AndroidFindBy(id = "com.myvodafoneapp:id/btnDetailedProductCTA")
    public WebElement Plan_changeYourAirtimePlanButton;

    @AndroidFindBy(id = "com.myvodafoneapp:id/txtAvailableText")
    public WebElement Plan_availableCounter;

    @AndroidFindBy(id = "com.myvodafoneapp:id/txtUsedText")
    public WebElement Plan_usedCounter;

    @AndroidFindBy(xpath = "//*[@text='Active']")
    public WebElement Plan_activeCounter;

    @AndroidFindBy(xpath = "//*[@text='Activate by text']")
    @iOSXCUITFindBy(xpath = "//*[@label='Activate by text']")
    public WebElement ActivateByTextCTA;

    @AndroidFindBy(xpath = "//*[@text='Chat now']")
    @iOSXCUITFindBy(xpath = "//*[@label='Chat now']")
    public WebElement ChatNowCTA;

    public UnlimitedDataBoosterPO() {
        super();
    }
}
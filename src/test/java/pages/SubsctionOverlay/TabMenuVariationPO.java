package pages.SubsctionOverlay;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import pages.Commons.CommonPo;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

@Deprecated
public class TabMenuVariationPO extends CommonPo {


    @AndroidFindBy(xpath = "//*[@text='Usage']")
    @iOSXCUITFindBy(id = "Usage")

    public WebElement SO_UsageTab;

    @AndroidFindBy(xpath = "//*[@text='Extras']")
    @iOSXCUITFindBy(id = "Extras")

    public WebElement SO_ExtrasTab;

    @AndroidFindBy(xpath = "//*[@text='Charges']")
    @iOSXCUITFindBy(id = "Charges")

    public WebElement SO_ChargesTab;


    @AndroidFindBy(xpath = "//*[@text='Device plan']")
    @iOSXCUITFindBy(id = "Device plan")

    public WebElement SO_DevicePlanTab;

    @AndroidFindBy(xpath = "//*[@text='Group Data']")
    @iOSXCUITFindBy(xpath = "//*[@label='Group Data']")

    public WebElement SO_DataGroupTab;

    public TabMenuVariationPO() {
        super();
    }
}

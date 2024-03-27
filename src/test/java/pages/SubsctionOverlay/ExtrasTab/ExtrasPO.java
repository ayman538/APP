package pages.SubsctionOverlay.ExtrasTab;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.Commons.CommonPo;


public class ExtrasPO extends CommonPo {


    @AndroidFindBy(xpath = "//*[@text='Extras']")
    @iOSXCUITFindBy(id = "Extras")
    @AndroidFindBy(xpath = "(//*[@resource-id='om.myvodafoneapp:id/tabSubscriptionMenuItem'])[3]")
    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"Extras\"]/android.widget.TextView")
    public WebElement SO_ExtrasTab;

    @AndroidFindBy(id = "com.myvodafoneapp:id/txtCardDescription")
    @iOSXCUITFindBy(id = "txtCardDescription")
    public WebElement Extras_MyExtrasAllowancesDescription;

    @AndroidFindBy(id = "com.myvodafoneapp:id/txtCardTitle")
    @iOSXCUITFindBy(id = "txtCardTitle")
    public WebElement Extras_MyExtrasAllowancesTitle;

    @AndroidFindBy(xpath = "//*[@text='Data cap']")
    @iOSXCUITFindBy(xpath = "//*[@label='Data cap']")
    public WebElement Extra_DataCaps;

    @AndroidFindBy(xpath = "//*[@text='Manage Data cap']")
    @iOSXCUITFindBy(xpath = "//*[@label='Manage Data cap']")
    public WebElement Extra_ManageDataCapCTA;

    @AndroidFindBy(id = "com.myvodafoneapp:id/backImageView")
    @iOSXCUITFindBy(id = "backIcon")
    public WebElement Extra_backIcon;

    @AndroidFindBy(id = "com.myvodafoneapp:id/txtCardbtn")
    @iOSXCUITFindBy(id = "Manage extras")
    public WebElement Extra_detailsCTA;

    @AndroidFindBy(xpath = "//*[contains(@text 'Broadband discount')]")
    @iOSXCUITFindBy(xpath = "//*[contains(@label 'Broadband discount')]")
    public WebElement User_Discount;

    @AndroidFindBy(id = "com.myvodafoneapp:id/btnTopUpCTA")
    @iOSXCUITFindBy(id = "Manage Controls and Limits")
    public WebElement ManageControlsAndLimitsCTA;

    @AndroidFindBy(xpath = "//*[contains(@text 'Controls and limits')]")
    @iOSXCUITFindBy(xpath = "//*[contains(@label 'Controls and limits')]")
    public WebElement ManageControlsAndLimitsWebView;


    public ExtrasPO() {
        super();
    }
}

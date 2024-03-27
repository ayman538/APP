package pages.OnePlatform_SpeedCheckerHistory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.Commons.CommonPo;

public class SpeedCheckerHistoryPO extends CommonPo {

    public SpeedCheckerHistoryPO() { super();}

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Speed history']"),
            @FindBy(how = How.ID, using = "NPnetworkSpeedHistoryText")
    })
    public WebElement SpeedHistory_Tab;

    @FindAll({
            @FindBy(how = How.ID, using = "NPspeedHistoryCard1"),
            @FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc='NPspeedHistoryCard1']")
    })
    public WebElement SpeedTest_Card;

    @FindAll({
            @FindBy(how = How.ID, using = "NPshowTheMapButton"),
            @FindBy(how = How.XPATH, using = "//android.widget.TextView[@content-desc='NPshowTheMapButton']")
    })
    public WebElement ShowMAP_CTA;

    @FindAll({
            @FindBy(how = How.ID, using = "NPhideTheMapButton"),
            @FindBy(how = How.XPATH, using = "//android.widget.TextView[@content-desc='NPhideTheMapButton']")
    })
    public WebElement HideMap_CTA;

    @FindAll({
            @FindBy(how = How.ID, using = "NPspeedCheckerMap"),
            @FindBy(how = How.XPATH, using = "//android.widget.FrameLayout[@content-desc='NPspeedCheckerMap']")
    })
    public WebElement Map_Image;

    @FindAll({
            @FindBy(how = How.ID, using = "NPspeedResultStatusText"),
            @FindBy(how = How.XPATH, using = "//android.widget.TextView[@content-desc='NPspeedResultStatusText']")
    })
    public WebElement TestStatus_text;

    @FindAll({
            @FindBy(how = How.ID, using = "NPspeedResultDate"),
            @FindBy(how = How.XPATH, using = "//android.widget.TextView[@content-desc='NPspeedResultDate']")
    })
    public WebElement TestStatus_Date;

    @FindAll({
            @FindBy(how = How.ID, using = "vodafoneLogoImageView"),
            @FindBy(how = How.ID, using = "vodafoneLogoImageView"),
            @FindBy(how = How.ID_OR_NAME, using = "imgVodafoneLogo")
    })
    public WebElement DashboardLogo;


    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Your Network']"),
            @FindBy(how = How.XPATH, using = "//*[@text='Your Network']")
    })
    public WebElement YourNetworkSection;

    @FindAll({
            @FindBy(how = How.ID, using = "NPconnectedToText"),
            @FindBy(how = How.XPATH, using = "//android.widget.TextView[@content-desc='NPconnectedToText']")
    })
    public WebElement SpeedCheckLandingPage;

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Test network speed']"),
            @FindBy(how = How.XPATH, using = "//*[@text='Test network speed']"),
            @FindBy(how = How.ID_OR_NAME, using = "NPtestNetworkSpeedButtonBtn")

    })
    public WebElement StartSpeedTestCta;

    @FindAll({
            @FindBy(how = How.ID, using = "NPtestResultGauge"),
            @FindBy(how = How.XPATH, using = "//android.widget.ImageView[@content-desc='NPtestResultGauge']")
    })
    public WebElement ResultGauge;

    @FindAll({
            @FindBy(how = How.ID, using = "NPspeedHistoryNoResult"),
            @FindBy(how = How.XPATH, using = "//android.widget.TextView[@content-desc='NPspeedHistoryNoResult']")
    })
    public WebElement NoResultText;

    @FindAll({
            @FindBy(how = How.ID, using = "speedHistoryDeleteButton"),
            @FindBy(how = How.XPATH, using = "//android.widget.TextView[@content-desc='speedHistoryDeleteButton']")
    })
    public WebElement DeletePreviousSpeedTests_CTA;

    @FindAll({
            @FindBy(how = How.XPATH, using = "//android.view.View[@index='0']"),
            @FindBy(how = How.XPATH, using = "NPspeedHistoryNoResult")
    })
    public WebElement DeleteOverlay;


    @FindAll({
            @FindBy(how = How.ID, using = "QuickActionMenu title label"),
            @FindBy(how = How.XPATH, using = "//android.widget.TextView[@content-desc='QuickActionMenu title label']"),
            @FindBy(how = How.NAME, using = "Delete history")
    })
    public WebElement DeleteOverlayTitle;


    @FindAll({
            @FindBy(how = How.ID, using = "confirmDeleteMenuPrimaryBtnBtn"),
            @FindBy(how = How.XPATH, using = "//android.widget.TextView[@content-desc='confirmDeleteMenuPrimaryBtn']"),
            @FindBy(how = How.ID_OR_NAME, using = "confirmDeleteMenuPrimaryBtn")
    })
    public WebElement ConfirmDelete_CTA;

    @FindAll({
            @FindBy(how = How.ID, using = "confirmDeleteMenuSecondaryBtnBtn"),
            @FindBy(how = How.XPATH, using = "//android.widget.TextView[@content-desc='confirmDeleteMenuSecondaryBtn']"),
            @FindBy(how = How.ID_OR_NAME, using = "confirmDeleteMenuSecondaryBtn")

    })
    public WebElement CancelDelete_CTA;

}

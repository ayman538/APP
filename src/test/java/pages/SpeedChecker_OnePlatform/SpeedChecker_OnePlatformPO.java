package pages.SpeedChecker_OnePlatform;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.Commons.CommonPo;
import io.appium.java_client.pagefactory.*;

public class SpeedChecker_OnePlatformPO extends CommonPo {

    public SpeedChecker_OnePlatformPO() {
        super();
    }

    @AndroidFindAll({
            @AndroidBy(xpath = "//*[@text='Check Data and Wi-Fi Speed']"),
            @AndroidBy(xpath = "//*[@name='txtDashboardLinksMenuCellLabel_Check Data and Wi-Fi Speed']")
    })
    @iOSXCUITFindAll({
            @iOSXCUITBy(xpath = "//*[@name='txtDashboardLinksMenuCellLabel_Check Data and Wi-Fi Speed']"),
            @iOSXCUITBy(xpath = "//*[@label = 'Check Data and Wi-Fi Speed']"),
            @iOSXCUITBy(id = "DashboardLinksMenuCellLeftIcon_Check Data and Wi-Fi Speed"),
            @iOSXCUITBy(xpath = "//*[@name='DashboardLinksMenuCellLeftIcon_Check Data and Wi-Fi Speed']")
    })


    protected WebElement checkDataAndWifiSpeed;

    @AndroidFindAll({
            @AndroidBy(xpath = "//android.widget.TextView[@resource-id='NPspeedCheckerTitle']"),
            @AndroidBy(xpath = "//android.widget.TextView[@content-desc='NPspeedCheckerTitle']")
    })
    @iOSXCUITFindAll({
            @iOSXCUITBy(xpath = "//*[@name='NPspeedCheckerTitle']"),
            @iOSXCUITBy(xpath = "//*[@name='Speed checker']"),
            @iOSXCUITBy(id = "NPspeedCheckerTitle")
    })


    protected WebElement speedCheckerScreenTitle;
    @AndroidFindAll({
            @AndroidBy(xpath = "//android.widget.TextView[@resource-id='NPcarrierName']"),
            @AndroidBy(xpath = "//android.widget.TextView[@content-desc='NPcarrierName']")
    })
    @iOSXCUITFindAll({
            @iOSXCUITBy(xpath = "//*[@name='NPcarrierName']"),
            @iOSXCUITBy(id = "NPcarrierName")
    })


    protected WebElement speedCheckerNetworkType;

    @AndroidFindAll({
            @AndroidBy(xpath = "//android.widget.TextView[@resource-id='NPphoneNumber']"),
            @AndroidBy(xpath = "//android.widget.TextView[@content-desc='NPphoneNumber']")
    })
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'447')]")

    protected WebElement speedCheckerMSISDN;

    @AndroidFindAll({
            @AndroidBy(xpath = "//android.widget.TextView[@content-desc='NPwhyThisNetworkText']"),
            @AndroidBy(xpath = "//android.widget.TextView[@content-desc='NPwhyThisNetworkText']")
    })
    @iOSXCUITFindAll({
            @iOSXCUITBy(xpath = "//*[@name='NPwhyThisNetworkText']"),
            @iOSXCUITBy(id = "NPwhyThisNetworkText")
    })

    protected WebElement speedChecker_WhyThisNetwork_Text;

    @AndroidFindAll({
            @AndroidBy(xpath = "//android.widget.TextView[@content-desc='NPerrorWhyNetworkText']"),
            @AndroidBy(xpath = "//android.widget.TextView[@resource-id='NPerrorWhyNetworkText']")
    })
    @iOSXCUITFindAll({
            @iOSXCUITBy(xpath = "//*[@name='NPerrorWhyNetworkText']"),
            @iOSXCUITBy(id = "NPerrorWhyNetworkText")
    })


    protected WebElement speedChecker_WhyThisNetwork_Tray_title;

    @AndroidFindAll({
            @AndroidBy(xpath = "//android.widget.ImageView[@content-desc='NPerrorConnectionIcon']"),
            @AndroidBy(xpath = "//android.widget.TextView[@resource-id='NPerrorConnectionIcon']")
    })
    @iOSXCUITFindAll({
            @iOSXCUITBy(xpath = "//*[@name='NPerrorConnectionIcon']"),
            @iOSXCUITBy(id = "NPerrorConnectionIcon")
    })


    protected WebElement speedChecker_WhyThisNetwork_Tray_Icon;
    @AndroidFindAll({
            @AndroidBy(xpath = "//android.widget.TextView[@content-desc='NPerrorConnectionTitle']"),
            @AndroidBy(xpath = "//android.widget.TextView[@resource-id='NPerrorConnectionTitle']")
    })
    @iOSXCUITFindAll({
            @iOSXCUITBy(xpath = "//*[@name='NPerrorConnectionTitle']"),
            @iOSXCUITBy(id = "NPerrorConnectionTitle")
    })


    protected WebElement speedChecker_WhyThisNetwork_Tray_Header;
    @AndroidFindAll({
            @AndroidBy(xpath = "//android.widget.TextView[@content-desc='NPerrorConnectionDesc']"),
            @AndroidBy(xpath = "//android.widget.TextView[@resource-id='NPerrorConnectionDesc']")
    })
    @iOSXCUITFindAll({
            @iOSXCUITBy(xpath = "//*[@name='NPerrorConnectionDesc']"),
            @iOSXCUITBy(id = "NPerrorConnectionDesc")
    })


    protected WebElement speedChecker_WhyThisNetwork_Tray_description;
    @AndroidFindAll({
            @AndroidBy(xpath = "//android.widget.TextView[@content-desc='NPerrorGoToSettingsButton']"),
            @AndroidBy(xpath = "//android.widget.TextView[@resource-id='NPerrorGoToSettingsButton']")
    })
    @iOSXCUITFindAll({
            @iOSXCUITBy(xpath = "//*[@name='NPerrorGoToSettingsButton']"),
            @iOSXCUITBy(id = "NPerrorGoToSettingsButton")
    })


    protected WebElement speedChecker_WhyThisNetwork_Tray_FCTA;
    @AndroidFindAll({
            @AndroidBy(xpath = "//android.view.ViewGroup[@content-desc='NPerrorNoThanksButton']"),
            @AndroidBy(xpath = "//android.view.ViewGroup[@content-desc='NPerrorNoThanksButton']")
    })
    @iOSXCUITFindAll({
            @iOSXCUITBy(xpath = "//*[@name='NPerrorNoThanksButton']"),
            @iOSXCUITBy(id = "NPerrorNoThanksButton"),
            @iOSXCUITBy(id = "NPerrorOkThanksButton")
    })


    protected WebElement speedChecker_WhyThisNetwork_Tray_SCTA;

    @AndroidFindAll({
            @AndroidBy(xpath = "//android.widget.ImageView[@content-desc='NPwhyThisNetworkIcon']"),
            @AndroidBy(xpath = "//android.widget.ImageView[@cresource-id='NPwhyThisNetworkIcon']")
    })

    @iOSXCUITFindBy(xpath = "//*[@name='NPwhyThisNetworkIcon']")

    protected WebElement speedChecker_WhyThisNetworkIcon;

    @AndroidFindAll({
            @AndroidBy(xpath = "//android.view.ViewGroup[@content-desc='NPnetworkSpeedHistoryText']"),
            @AndroidBy(xpath = "//android.widget.TextView[@content-desc='NPnetworkSpeedHistoryText']")
    })
    @iOSXCUITFindAll({
            @iOSXCUITBy(xpath = "//*[@name='Speed history']"),
            @iOSXCUITBy(id = "Speed history")
    })


    protected WebElement speedChecker_SpeedHistoryTab;
    @AndroidFindAll({
            @AndroidBy(xpath = "//android.view.ViewGroup[@content-desc='NPtestNetworkSpeedButton']"),
            @AndroidBy(xpath = "//android.view.ViewGroup[@resource-id='NPtestNetworkSpeedButtonBtn']")
    })
    @iOSXCUITFindAll({
            @iOSXCUITBy(xpath = "//*[@name='NPtestNetworkSpeedButtonBtn']"),
            @iOSXCUITBy(id = "NPtestNetworkSpeedButton"),
            @iOSXCUITBy(xpath = "//*[@label='Test network speed']"),
            @iOSXCUITBy(id = "NPtestNetworkSpeedButtonBtn")
    })


    protected WebElement speedChecker_TestNetworkSpeedCTA;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='NPtestResultStatus']")
     @iOSXCUITFindBy(xpath = "//*[@name='NPtestResultStatus']")
     @iOSXCUITFindBy(xpath = "//*[@label='Great']")

    protected WebElement speedChecker_ResultScreenStatus;

    //
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='NPtestResultDescription']")
    @iOSXCUITFindBy(id = "NPtestResultDescription")
    @iOSXCUITFindBy(xpath = "//*[@name='NPtestResultDescription']")


    protected WebElement speedChecker_ResultDescription;


    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='NPcheckAgainButton']")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='NPcheckAgainButtonBtn']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='NPcheckAgainButtonBtnBtn']")

    protected WebElement speedChecker_CheckAgainCTA;


    @AndroidFindBy(xpath = "//*[@text='More on data and WI-FI speed']")
    @iOSXCUITFindBy(xpath = "//*[@content-desc='NPshowTipsAndTricks']")
    @iOSXCUITFindBy(xpath = "//*[@name='More on data and Wi-Fi speed']")


    protected WebElement MoreOnDataAndWifiLink;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='NPbetterConnectionTitle']")
    @iOSXCUITFindBy(id = "More on data and Wi-Fi speed")
    @iOSXCUITFindBy(xpath = "//*[@name='More on data and Wi-Fi speed']")


    protected WebElement MoreDataAndWifiSpeedPageTitle;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='NPbetterConnectionView']")
    @AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id='NPbetterConnectionClose']")
    @iOSXCUITFindBy(id = "quickActionMenuCloseIcon")
    @iOSXCUITFindBy(xpath = "//*[@name='quickActionMenuCloseIcon']")

    protected WebElement MoreDataAndWifiSpeedCloseCTA;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='NPbetterConnectionDesc']/android.widget.TextView[@index='0']")
    @iOSXCUITFindBy(id = "What is download speed?")
    @iOSXCUITFindBy(xpath = "//*[@name='What is download speed?']")

    protected WebElement DownloadSpeedTitle;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='NPbetterConnectionDesc']/android.widget.TextView[@index='1']")
    @iOSXCUITFindAll({
            @iOSXCUITBy(id = "This is the ability to receive information from the internet. The higher the speed, the more information you can receive per second, which means webpages load faster and content loading on apps are smoother. Network speed is measured by Megabits per second, written as MB/s."),
            @iOSXCUITBy(xpath = "//*[@name='What is upload speed?']")
    })
    protected WebElement DownloadSpeedDescription;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='NPbetterConnectionDesc']/android.widget.TextView[@index='2']")
    @FindBy(how = How.ID_OR_NAME, using = "")
    @iOSXCUITFindAll({
            @iOSXCUITBy(id = "What is upload speed?"),
            @iOSXCUITBy(xpath = "//*[@name='What is upload speed?']")
    })


    protected WebElement UploadSpeedTitle;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='NPbetterConnectionDesc']/android.widget.TextView[@index='3']")
    @FindBy(how = How.ID_OR_NAME, using = "")
    @iOSXCUITFindAll({
            @iOSXCUITBy(id = "This is the ability to send information from your device to the internet. Normally the default setting of upload speed is lower than download, as people tend to download and consume information more."),
            @iOSXCUITBy(xpath = "//*[@name='This is the ability to send information from your device to the internet. Normally the default setting of upload speed is lower than download, as people tend to download and consume information more.']")
    })
    protected WebElement UploadSpeedDescription;


    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='NPbetterConnectionDesc']/android.widget.TextView[@index='4']")
    @iOSXCUITFindAll({
            @iOSXCUITBy(id = "What is ping?"),
            @iOSXCUITBy(xpath = "//*[@name='What is ping?']")
    })

    protected WebElement PingSpeedTitle;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='NPbetterConnectionDesc']/android.widget.TextView[@index='5']")
    @iOSXCUITFindAll({
            @iOSXCUITBy(id = "Ping is a measure of network latency, a key factor in how fast your online experience feels. The lower the latency, the more responsive the network is when streaming video, playing games, sending messages, or browsing the internet."),
            @iOSXCUITBy(xpath = "//*[name='Ping is a measure of network latency, a key factor in how fast your online experience feels. The lower the latency, the more responsive the network is when streaming video, playing games, sending messages, or browsing the internet.']")
    })
    protected WebElement PingSpeedDescription;

    @AndroidFindBy(xpath = "//*[@text='OK, please proceed']")
    @iOSXCUITFindAll({
            @iOSXCUITBy(xpath = "//*[@label='OK, please proceed']"),
            @iOSXCUITBy(id = "NPgrantPermissionOkActionButtonBtn"),
            @iOSXCUITBy(xpath = "//XCUIElementTypeOther[name='NPgrantPermissionOKActionButton']")
    })

    protected WebElement NetworkOptimizationPermissionsScreen_OKPleaseProceedCTA;


}

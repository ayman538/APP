package pages.SubsctionOverlay.NewPlanDesign;


import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.Commons.CommonPo;

public class UpgradeCardsPO extends CommonPo {


    @FindBy(id = ":id/collapsing_toolbar")
    public WebElement NumberOfCallUS;


    @iOSXCUITFindBy(xpath = "//*[@label=='Upgrade only']")
    @AndroidFindBy(xpath = "//*[@text='Upgrade only']")
    public WebElement UpgradeNowCTA;


    @FindBy(xpath = "//*[@text='choose phone plan']")
    public WebElement ChoosePhonePlanCTA;


    @FindBy(xpath = "//*[@text='Upgrade Your Phone or Plan']")
    public WebElement upgradeyourphoneorplantxt;


    @AndroidFindBy(id = "com.myvodafoneapp:id/closePartialImageView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='bottomSheetDismissButtonIdentifier']")
    public WebElement XCloseCTA;


    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.myvodafoneapp:id/txtSubItemLabel\" and @text=\"Data\"]")
    @iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name='Data']")
    public WebElement DataTXt;


    @FindBy(xpath = "//*[@text='Check Your Phone's Value']")
    public WebElement checkyourphonevaluetxt;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Get a trade-in quote\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Get a trade-in quote']")
    public WebElement tradeInTitle;
    @AndroidFindBy(xpath = "//*[@text='Upgrade Phone and Plan']")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"txtPlanListItemTitle\"])[1]")

    public WebElement HandsetUpgradeCard_Title;


    @AndroidFindBy(xpath = "*//androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.TextView")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"sectionsSubTitle_0\"])[1]")

    public WebElement HandsetUpgradeCard_Txt;


    @AndroidFindBy(xpath = "//*[@text='Browse Phones']")
    @iOSXCUITFindBy(xpath = "//*[@name='Browse Phones']")

    public WebElement HandsetUpgradeCard_CTA;


    @AndroidFindBy(xpath = "//*[@text='Upgrade your Plan']")
    @iOSXCUITFindBy(xpath = "//*[@label=='Upgrade your Plan']")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"txtPlanListItemTitle\"])[2]")
    public WebElement SIMOsetUpgradeCard_Title;


    @AndroidFindBy(xpath = "*//androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.TextView")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"sectionsSubTitle_0\"])[2]")
    @iOSXCUITFindBy(xpath = "//*[contains(@label,'Keep your phone and Upgrade to a new SIM Only plan')]")
    public WebElement SIMOUpgradeCard_Txt;

    @AndroidFindBy(xpath = "//*[@text='Browse Phones']")
    @iOSXCUITFindBy(xpath = "//*[@label=='Browse Phones']")
    public WebElement BrowsePhonesCTA;


    @AndroidFindBy(xpath = "//*[@text='Browse recommended plans']")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"action_0\"])[2]")
    @iOSXCUITFindBy(xpath = "//*[@label=='Browse recommended plans']")
    public WebElement SIMOUpgradeCard_CTA;


    @AndroidFindBy(id = "com.myvodafoneapp:id/txtTradeInUpgradePoPUP_title")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Got a device you'd like to trade in?\"]")
    public WebElement TradeInUpgradePoPUP_title;


    @AndroidFindBy(id = "com.myvodafoneapp:id/txtTradeInUpgradePoPUP_body")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Find out how much you can save on your upgrade with our Trade-in tool']")
    public WebElement TradeInUpgradePoPUP_body;


    @AndroidFindBy(id = "com.myvodafoneapp:id/btnYesPleaseTradeInUpgradePoPUP_CTA")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Trade-in and upgrade\"]")
    public WebElement YesPleaseTradeInUpgradePoPUP_CTA;


    @FindBy(xpath = "com.myvodafoneapp:id/btnNoThankYouTradeInUpgradePoPUP_CTA")

    public WebElement NoThankYouTradeInUpgradePoPUP_CTA;


    @AndroidFindBy(id = "com.myvodafoneapp:id/btnNoThankYouTradeInUpgradePoPUP_CTA")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Upgrade only']")

    public WebElement UpgradeOnlyCTA;


    @AndroidFindBy(id = "com.myvodafoneapp:id/DiscountCardTitle")
    @iOSXCUITFindBy(id = "DiscountCardTitle")
    @iOSXCUITFindBy(xpath = "//*[@name='DiscountCardTitle']")

    public WebElement DiscountCardTitle;

    @AndroidFindBy(id = "com.myvodafoneapp:id/DiscountCardHeader")
    @iOSXCUITFindBy(id = "DiscountCardHeader")
    @iOSXCUITFindBy(xpath = "//*[@name='DiscountCardHeader']")

    public WebElement DiscountCardHeader;


    @AndroidFindBy(id = "com.myvodafoneapp:id/DiscountCardDeviceName")
    @iOSXCUITFindBy(xpath = "//*[@name='DiscountCardDeviceName']")

    public WebElement DiscountCardDeviceName;

    @AndroidFindBy(id = "com.myvodafoneapp:id/DiscountCardDescription")
    @iOSXCUITFindBy(xpath = "//*[@name='DiscountCardDescription']")

    public WebElement DiscountCardDescription;

    @AndroidFindBy(id = "com.myvodafoneapp:id/DiscountCardMainImg")
    @iOSXCUITFindBy(xpath = "//*[@name='DiscountCardMainImg']")

    public WebElement DiscountCardDeviceIcon;


    @AndroidFindBy(id = "com.myvodafoneapp:id/RecommendationReasonCard")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"RecommendationReason\"]/XCUIElementTypeOther/XCUIElementTypeOther")

    public WebElement AomRecommendationReason;

    @AndroidFindBy(id = "com.myvodafoneapp:id/RecommendationReasonImg")
    @iOSXCUITFindBy(xpath = "//*[@name='RecommendationReasonImg']")

    public WebElement AoMRecommendationReasonIcon;

    @AndroidFindBy(id = "com.myvodafoneapp:id/RecommendationReasonTitle")
    @iOSXCUITFindBy(xpath = "//*[@name='RecommendationReasonTitle']")

    public WebElement AoMRecommendationReasonTitle;

    @AndroidFindBy(id = "com.myvodafoneapp:id/RecommendationReasonDesc")
    @iOSXCUITFindBy(xpath = "//*[@name='RecommendationReasonDesc']")

    public WebElement AoMRecommendationReasonDescription;

    @AndroidFindBy(id = "com.myvodafoneapp:id/DiscountCardRightImg")
    @iOSXCUITFindBy(xpath = "//*[@name='DiscountCardRightImg']")

    public WebElement DiscountCard5GIcon;

    @FindBy(id = "brandsCarouselTitle")


    public WebElement BrandIconTitle;


    @AndroidFindBy(xpath = "(//*[@resource-id='com.myvodafoneapp:id/BrandImg'])[1]")
    @iOSXCUITFindBy(id = "brandsCarousel_0")

    public WebElement AppleIcon;

    @AndroidFindBy(xpath = "(//*[@resource-id='com.myvodafoneapp:id/BrandImg'])[2]")
    @iOSXCUITFindBy(id = "brandsCarousel_1")

    public WebElement SamsungIcon;

    @AndroidFindBy(xpath = "(//*[@resource-id='com.myvodafoneapp:id/BrandImg'])[3]")
    @iOSXCUITFindBy(id = "brandsCarousel_2")

    public WebElement GoogleIcon;

    @AndroidFindBy(id = "com.myvodafoneapp:id/InstallmentAmount")
    @iOSXCUITFindBy(xpath = "//*[@name='InstallmentAmount']")

    public WebElement DiscountCardInstallmentAmount;

    @AndroidFindBy(id = "com.myvodafoneapp:id/UpfrontAmount")
    @iOSXCUITFindBy(xpath = "//*[@name='UpfrontAmount']")

    public WebElement DiscountCardUpfrontAmount;

    @AndroidFindBy(id = "com.myvodafoneapp:id/OldAmount")
    @iOSXCUITFindBy(xpath = "//*[@name='OldAmount']")

    public WebElement DiscountCardOldAmount;

    @AndroidFindBy(id = "com.myvodafoneapp:id/actionsLinearLayout")
    @iOSXCUITFindBy(xpath = "//*[@name='View full offer']")

    public WebElement ViewFullOfferCTA;


    @AndroidFindBy(id = "com.myvodafoneapp:id/btnPlanCTA")
    @iOSXCUITFindBy(xpath = "//*[@name='See all devices']")

    public WebElement SeeMoreDevicePlanCTA;

    @AndroidFindBy(id = "com.myvodafoneapp:id/ASACopy")
    @iOSXCUITFindBy(xpath = "//*[@name='ASACopy']")

    public WebElement ASACopy;

    @AndroidFindBy(xpath = "(//*[@resource-id='com.myvodafoneapp:id/txtPlanListItemTitle'])[1]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"txtPlanListItemTitle\"])[1]")

    public WebElement PlanCardTitle;

    @AndroidFindBy(id = "btnClose")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='VFGwebCloseButton']")

    public WebElement closeInternalWebview;

    @AndroidFindBy(id = "com.myvodafoneapp:id/txtPlanListItemDetails")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"sectionsSubTitle_0\"]")

    public WebElement DiscountSubTitle;


    @AndroidFindBy(xpath = "//*[@text='Basket']")
    @iOSXCUITFindBy(id = "Basket")

    public WebElement InternalWebViewBasketIcon;


    @AndroidFindBy(xpath = "//*[@text='Browse our range of pay monthly phones']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Browse our range of pay monthly phones']")


    public WebElement InternalWebViewTitle;

    @AndroidFindBy(id = "com.myvodafoneapp:id/btnPlanCTA")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='cta_upgrade_now_0']")
    public WebElement UpgradeNowPlanCTA;
    @AndroidFindBy(xpath = "(//android.view.View[@content-desc=\"Product info\"])[2]/android.widget.TextView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Product info\"]")

    public WebElement ProductInfoElement;


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Select colour\"]")


    public WebElement webViewSelectColorElement;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.myvodafoneapp:id/txtPlanListItemTitle\" and @text=\"Upgrade SIM Only Plan\"]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"txtPlanListItemTitle\"])[2]")

    public WebElement UpgradeTitle;


    @AndroidFindBy(id = "com.myvodafoneapp:id/txtPlanListItemDetails")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='sectionsSubTitle_0']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"sectionsSubTitle_0\"]")
    public WebElement UpgradeSubTitle;


    @AndroidFindBy(xpath = "//*[@text= \"What do you want to do today?\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"What do you want to do today?\"]")

    public WebElement PopUpHeaderTitle;


    @AndroidFindBy(xpath = "//android.widget.Button[@text= \"Upgrade now\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Upgrade now\"]")

    public WebElement WebViewUpgradeNowCTA;

    public UpgradeCardsPO() {
        super();
    }
}
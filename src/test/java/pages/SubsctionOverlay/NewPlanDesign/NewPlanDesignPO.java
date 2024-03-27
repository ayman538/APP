package pages.SubsctionOverlay.NewPlanDesign;

import io.appium.java_client.pagefactory.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.Commons.CommonPo;


public class NewPlanDesignPO extends CommonPo {

    @AndroidFindBy(id = "com.myvodafoneapp:id/btnDetailedProductPageBackButton")
    @iOSXCUITFindBy(id = "backIcon")
    public WebElement IncludesBackIcon;

    @AndroidFindAll({
            @AndroidBy(xpath = "//android.widget.LinearLayout[@content-desc='Plan']/android.widget.TextView"),
            @AndroidBy(id = "planCardTitle_0"),
    })
    @iOSXCUITFindAll({
            @iOSXCUITBy(id = "planCardTitle_0"),
            @iOSXCUITBy(xpath = "//*[@label='Plan']")
    })
    public WebElement PlanTitle;

    @AndroidFindAll({
            @AndroidBy(id = "com.myvodafoneapp:id/btnIncludesShowMore"),
            @AndroidBy(xpath = "//*[@value='Show more']")

    })
    @iOSXCUITFindAll({
            @iOSXCUITBy(id = "Show more"),
            @iOSXCUITBy(xpath = "//*[@name='Show more']"),
            @iOSXCUITBy(xpath = "//XCUIElementTypeStaticText[@name=\"Show more\"]")
    })
    public WebElement Includes_seeMore;

    @iOSXCUITFindAll({
            @iOSXCUITBy(xpath = "(//XCUIElementTypeStaticText[@name=\"txtPlanListItemTitle\"])[3]"),
            @iOSXCUITBy(xpath = "//*[@name='txtPlanListItemTitle']"),

    })
    @AndroidFindBy(xpath = "//*[@text='Contract']")
    public WebElement SO_PlanTabContract;
    @AndroidFindBy(id = "com.myvodafoneapp:id/txtDetailedProductPageTitle")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText)[2]")
    public WebElement Includes_DetailedTitle;

    @AndroidFindAll({
            @AndroidBy(id = "Send endless picture and video messages at no extra cost."),
            @AndroidBy(xpath = "//*[@name='Send endless picture and video messages at no extra cost.']"),
            @AndroidBy(xpath = "(//XCUIElementTypeStaticText)[3]"),
            @AndroidBy(xpath = "//*[@label='Send endless picture and video messages at no extra cost.']"),
            @AndroidBy(xpath = "//XCUIElementTypeTextView[@name=\"Send endless picture and video messages at no extra cost. \"]")
    })
    @iOSXCUITFindAll({
            @iOSXCUITBy(xpath = "Send endless picture and video messages at no extra cost."),
            @iOSXCUITBy(xpath = "//*[@name='Send endless picture and video messages at no extra cost.']"),
            @iOSXCUITBy(xpath = "(//XCUIElementTypeStaticText)[3]"),
            @iOSXCUITBy(xpath = "//*[@label='Send endless picture and video messages at no extra cost.']"),
            @iOSXCUITBy(xpath = "//XCUIElementTypeTextView[@name=\"Send endless picture and video messages at no extra cost. \"]")
    })
    public WebElement Includes_DetailedDescription;

    @AndroidFindBy(id = "com.myvodafoneapp:id/btnDetailedProductCTA")
    @iOSXCUITFindBy(id = "action_0")
    public WebElement Includes_DetailedCTA;
    @FindBy(how = How.XPATH, using = "//*[@text='50% off Smartwatch Connectivity']")
    public WebElement Plan_oneNumberBenefit;
    @FindBy(how = How.XPATH, using = "//*[@text='Inclusive roaming in 51 European destinations']")
    public WebElement Plan_51roamFreeDestinations;
    @FindBy(how = How.XPATH, using = "//*[@text='81 roam-free destinations']")
    public WebElement Plan_81roamFreeDestinations;

    @AndroidFindBy(xpath = "(//*[@resource-id='com.myvodafoneapp:id/txtPlanTitle'])[1]")
    @iOSXCUITFindBy(id = "planCardTitle_0")
    public WebElement Plan_PAYG1Title;

    @AndroidFindBy(xpath = "(//*[@resource-id='com.myvodafoneapp:id/txtPlanDetails'])[1]")
    @iOSXCUITFindBy(id = "planCardDescription_0")
    public WebElement Plan_PAYG1Desc;

    @AndroidFindBy(xpath = "(//*[@resource-id='com.myvodafoneapp:id/txtPlanTitle'])[2]")
    @iOSXCUITFindBy(id = "planCardTitle_1")
    public WebElement Plan_GetMoreBundleTitle;

    @AndroidFindBy(xpath = "(//*[@resource-id='com.myvodafoneapp:id/txtPlanDetails'])[2]")
    @iOSXCUITFindBy(id = "planCardDescription_1")
    public WebElement Plan_GetMoreBundleDesc;

    @AndroidFindBy(xpath = "(//*[@resource-id='com.myvodafoneapp:id/btnPlanCTA'])[1]")
    @iOSXCUITFindBy(id = "planCardCTA_1_0")
    public WebElement Plan_GetMoreBundleCTA;

    @AndroidFindBy(xpath = "(//*[@resource-id='com.myvodafoneapp:id/txtPlanTitle'])[3]")
    @iOSXCUITFindBy(id = "planCardTitle_2")
    public WebElement Plan_OffersForYouTitle;

    @AndroidFindBy(xpath = "(//*[@resource-id='com.myvodafoneapp:id/txtPlanDetails'])[3]")
    @iOSXCUITFindBy(id = "planCardDescription_2")
    public WebElement Plan_OffersForYouDesc;


    @AndroidFindBy(xpath = "(//*[@resource-id='com.myvodafoneapp:id/btnPlanCTA'])[2]")
    @iOSXCUITFindBy(id = "planCardCTA_2_0")
    public WebElement Plan_OffersForYouCTA;


    @AndroidFindBy(id = "com.myvodafoneapp:id/txtDetailedProductPageExpiryDate")
    @iOSXCUITFindBy(xpath = "//*[@label[contains(.,'Expires')]]")
    public WebElement ExpiryOfProducts;


    @AndroidFindBy(id = "com.myvodafoneapp:id/txtSubItemLabel")
    @iOSXCUITFindBy(xpath = "//*[contains(@name ,'Vodafone Together Discount')]")
    public WebElement VodafoneTogetherDiscount;


    @AndroidFindAll({
            @AndroidBy(id = "com.myvodafoneapp:id/titleTextView"),
            @AndroidBy(id = "com.myvodafoneapp:id/imgIncludesChevron")
    })
    @iOSXCUITFindBy(xpath = "*//XCUIElementTypeStaticText[@name='Phone Buy-Back Price Guarantee']")
    public WebElement PhoneBuyBackGuaranteeCTA;


    @AndroidFindBy(id = "com.myvodafoneapp:id/txtDetailedProductPageTitle")
    @iOSXCUITFindBy(xpath = "*//XCUIElementTypeTextView")
    public WebElement PhoneBuyBackGuaranteeTitle;


    @AndroidFindBy(id = "com.myvodafoneapp:id/txtProductDetails")
    @iOSXCUITFindBy(xpath = "*//XCUIElementTypeTextView")
    public WebElement PhoneBuyBackGuaranteeDescription;


    @AndroidFindBy(id = "com.myvodafoneapp:id/txtItemStatus")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Available soon\"]")
    public WebElement PhoneBBGEntryPointLabel;


    @AndroidFindBy(xpath = "//*[@text='Lifetime Warranty']")
    @iOSXCUITFindBy(xpath = "//*[@label='Lifetime Warranty']")
    public WebElement LifetimeWarrantyCTA;


    @AndroidFindBy(id = "com.myvodafoneapp:id/txtDetailedProductPageTitle")
    @iOSXCUITFindBy(id = "Lifetime Warranty")
    @iOSXCUITFindBy(xpath = "//*[@name='Lifetime Warranty']")
    public WebElement LifetimeWarrantyTitle;


    @AndroidFindBy(id = "com.myvodafoneapp:id/txtProductDetails")
    @iOSXCUITFindBy(xpath = "*//XCUIElementTypeOther[1]/XCUIElementTypeTextView")
    public WebElement LifetimeWarrantyDescription;


    @AndroidFindBy(xpath = "//*[@text='Find out more']")
    @iOSXCUITFindBy(xpath = "//*[@label='Find out more']")
    public WebElement FindOutMoreCTA;


    @AndroidFindBy(id = "com.myvodafoneapp:id/tvTitle")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"My Vodafone\"]")
    public WebElement LifeTimeServiceWarrantyWebview;


    @AndroidFindBy(id = "com.myvodafoneapp:id/txtItemStatus")
    @iOSXCUITFindBy(id = "Available soon")
    @iOSXCUITFindBy(xpath = "//*[@name='Available soon']")
    public WebElement PBBGiPhone15Lozenge;


    @AndroidFindBy(xpath = "//*[@text='Phone Buy-Back Price Guarantee']")
    @iOSXCUITFindBy(id = "Phone Buy-Back Price Guarantee")
    public WebElement PBBGiPhone15CTA;


    @AndroidFindBy(id = "com.myvodafoneapp:id/txtDetailedProductPageTitle")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Phone Buy-Back Price Guarantee\"]")
    public WebElement PBBGiPhone15ScreenTitle;


    @AndroidFindBy(id = "com.myvodafoneapp:id/txtProductDetails")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextView[@name=\"With our Phone Buy-Back Guarantee, we'll give you a guaranteed price including a £50 bonus when you trade in & upgrade your Apple iPhone 15 Plus 256GB blue between 1st September 2024 and 31st October 2024.\"]")
    public WebElement PBBGiPhone15ElibilityDescription;

    public NewPlanDesignPO() {
        super();
    }
}
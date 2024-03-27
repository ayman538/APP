package pages.AcquisitionBoard;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import pages.Commons.CommonPo;


public class AcquisitionBoardPO extends CommonPo {


    @AndroidFindBy(xpath = "//*[@text='SIM only deals']")
    @iOSXCUITFindBy(id = "txtAcquisitionNewDBTile_SIM only deals")
    public WebElement Acquisition_NewDB_SIMonly_Title;

    @AndroidFindBy(xpath = "//*[@text='Broadband']")
    @iOSXCUITFindBy(id = "txtAcquisitionNewDBTile_Broadband")
    public WebElement Acquisition_NewDB_HBBicon_Title;

    @AndroidFindBy(xpath = "//*[@text='Trade In']")
    @iOSXCUITFindBy(id = "txtAcquisitionNewDBTile_Trade-in Tool")
    public WebElement Acquisition_NewDB_TradeIn_Title;

    @AndroidFindBy(id = "com.myvodafoneapp:id/txtAcquisitionNewDBVeryMe_title")
    @iOSXCUITFindBy(id = "txtAcquisitionNewDBVeryMe_title")
    public WebElement Acquisition_NewDB_VeryMe_Title;

    @AndroidFindBy(id = "com.myvodafoneapp:id/imgAcquisitionNewDBVeryMe_image")
    @iOSXCUITFindBy(id = "imgAcquisitionNewDBVeryMe_image")
    public WebElement Acquisition_NewDB_VeryMe_Image;

    @AndroidFindBy(id = "com.myvodafoneapp:id/txtAcquisitionNewDBVeryMe_body")
    @iOSXCUITFindBy(id = "txtAcquisitionNewDBVeryMe_body")
    public WebElement Acquisition_NewDB_VeryMe_Body;

    @AndroidFindBy(id = "com.myvodafoneapp:id/footerTitleTextView")
    @AndroidFindBy(xpath = "//*[@text='Why Vodafone']")
    @iOSXCUITFindBy(id= "Why Vodafone")
    public WebElement WhyVodafone_Title;

    @AndroidFindBy(xpath = "//*[@text='Online assistance']")
    @iOSXCUITFindBy(id = "txtAcquisitionNewDBLinksMenu_Online assistance")
    public WebElement Acquisition_NewDB_OnlineAssistance_Title;

    @AndroidFindBy(xpath = "//*[@text='Our virtual chat assistant is available to help you 24/7']")
    @iOSXCUITFindBy(id = "txtAcquisitionNewDBLinksMenu_Our virtual chat assistant is available to help you 24/7")
    public WebElement Acquisition_NewDB_OnlineAssistance_Body;

    @iOSXCUITFindBy(xpath = "//*[@label='How to contact us']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Need to contact us?']")
    @iOSXCUITFindBy(id= "How to contact us")
    public WebElement OnlineAssistance_WebView;

    @AndroidFindBy(xpath = "//*[@text='Free home delivery']")
    @iOSXCUITFindBy(id = "txtAcquisitionNewDBLinksMenu_Free home delivery")
    public WebElement Acquisition_NewDB_FreeHomeDelivery_Title;

    @AndroidFindBy(xpath = "//*[@text='Free home delivery']")
    @iOSXCUITFindBy(xpath = "//*[@label='Free home delivery']")
    @iOSXCUITFindBy(id = "txtAcquisitionNewDBLinksMenu_Free home delivery")
    public WebElement Acquisition_NewDB_FreeHomeDelivery_Body;

    @AndroidFindBy(xpath = "//*[@text='Getting your order']")
    @iOSXCUITFindBy(xpath = "//*[@value='Getting your order']")
    public WebElement FreeHomeDelivery_WebView;

    @AndroidFindBy(xpath = "//*[@text='14 day returns']")
    @iOSXCUITFindBy(id = "txtAcquisitionNewDBLinksMenu_14 day returns")
    public WebElement Acquisition_NewDB_14DayReturns_Title;

    @AndroidFindBy(xpath = "//*[@text='Hassle-free returns with no cancellation fee']")
    @iOSXCUITFindBy(id = "txtAcquisitionNewDBLinksMenu_Hassle-free returns with no cancellation fee")
    public WebElement Acquisition_NewDB_14DayReturns_Body;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Return an item\"]")
    @iOSXCUITFindBy(xpath = "//*[@label='Return an item']")
    @AndroidFindBy(xpath = "//*[@text='Return an item']")
    public WebElement Acquisition_NewDB_14DayReturns_WebView;

    @AndroidFindBy(xpath = "//*[@text=\"UK’s reliable award winning network\"]")
    @iOSXCUITFindBy(id = "txtAcquisitionNewDBLinksMenu_UK’s reliable award winning network")
    @iOSXCUITFindBy(xpath = "//*[@label='UK’s reliable award winning network\n']")
    public WebElement Acquisition_NewDB_UK;

    @AndroidFindBy(xpath = "//*[@text=\"Find out how we're keeping the UK connected\"]")
    @iOSXCUITFindBy(id = "txtAcquisitionNewDBLinksMenu_Find out how we're keeping the UK connected")
    public WebElement Acquisition_NewDB_UK_Body;

    @AndroidFindBy(xpath = "//*[contains(@text'reliable')]")
    @iOSXCUITFindBy(xpath = "//*[contains(@label'reliable')]")
    public WebElement UK_Reliale_NW_WebView;

    @AndroidFindBy(xpath = "//*[@text='More to love']")
    @iOSXCUITFindBy(xpath = "//*[@label='More to love']")
    public WebElement Acquisition_NewDB_Moretolove_Title;

    @AndroidFindBy(xpath = "//*[@text='Order a free SIM today and add a Pay as you go Bundle later']")
    @iOSXCUITFindBy(xpath = "//*[@label='Order a free SIM today and add a Pay as you go Bundle later']")
    public WebElement Acquisition_NewDB_MoreToLove_Body_SecondOffer;

    @AndroidFindBy(xpath = "//*[@text='Find out how our Network is performing where you are']")
    @iOSXCUITFindBy(xpath = "//*[@label='Find out how our Network is performing where you are']")
    public WebElement Acquisition_NewDB_MoreToLove_Body_ThirdOffer;

    @AndroidFindBy(id = "com.myvodafoneapp:id/txtAcquisitionNewDBDiscover_offerTitle")
    @iOSXCUITFindBy(id = "txtAcquisitionNewDBDiscover_offerTitle")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='txtAcquisitionNewDBDiscover_offerTitle'])[2]")
    public WebElement Acquisition_NewDB_MoreToLove_Body;

    @AndroidFindBy(id = "com.myvodafoneapp:id/btnAcquisitionNewDBDiscover_offerCTA")
    @iOSXCUITFindBy(id= "Find out more")
    @AndroidFindBy(xpath = "//*[@text='Find out more']")
    public WebElement Acquisition_NewDB_MoreToLove_CTA;

    @AndroidFindBy(xpath = "(//*[@text='Find out more'])[2]")
    @iOSXCUITFindBy(xpath = "(//*[@label='Find out more'])[2]")
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.LinearLayout/android.widget.ScrollView/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.TextView[2]")
    public WebElement Acquisition_NewDB_MoreToLove_CTA_SecondOffer;

    @iOSXCUITFindBy(xpath = "//*[@label='Find out how our Network is performing where you are']")
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.Button")
    public WebElement Acquisition_NewDB_MoreToLove_CTA_ThirdOffer;

    @AndroidFindBy(id = "com.myvodafoneapp:id/btnClose")
    @iOSXCUITFindBy(id = "VFGwebCloseButton")
    public WebElement Exit_WebView;

    @AndroidFindBy(xpath = "//*[@text='Order a free SIM']")
    @iOSXCUITFindBy(xpath = "//*[@label='Order a free SIM']")
    public WebElement Order_free_sim;

    @AndroidFindBy(xpath = "//*[@text='Mobile network alerts']")
    @iOSXCUITFindBy(xpath = "//*[@label='Mobile network alerts']")
    public WebElement Network_Alert;

    @AndroidFindBy(xpath = "//*[@text='Vodafone deals and offers']")
    @iOSXCUITFindBy(xpath = "//*[@label='Vodafone deals and offers']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Mobile Phone Deals | Phone & SIM Offers | Vodafone UK\"]/XCUIElementTypeOther[20]")
    public WebElement Deals_Offers;

    @AndroidFindBy(id = "com.myvodafoneapp:id/txtAcquisitionNewDB_HeaderTitle")
    @iOSXCUITFindBy(id= "txtAcquisitionNewDB_HeaderTitle")
    @iOSXCUITFindBy(xpath = "//*[@label='Latest Offers']")
    public WebElement Acquisition_NewDB_Header_Title;

    @AndroidFindBy(id = "com.myvodafoneapp:id/txtAcquisitionNewDB_HeaderBody")
    @iOSXCUITFindBy(id = "txtAcquisitionNewDB_HeaderBody")
    public WebElement Acquisition_NewDB_Header_Body;

    @AndroidFindBy(id = "com.myvodafoneapp:id/imgAcquisitionNewDB_HeaderBackground")
    @AndroidFindBy(xpath = "//*[@text='HeaderBackground']")
    @iOSXCUITFindBy(id = "imgAcquisitionNewDB_HeaderBackground")
    public WebElement Acquisition_Background_Image;

    @AndroidFindBy(id = "com.myvodafoneapp:id/seeOfferButton")
    @AndroidFindBy(xpath = "//*[@text='seeOfferButton']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='See offer']")
    public WebElement Acquisition_Background_CTA;

    @iOSXCUITFindBy(id= "Hey")
    public WebElement NewDBHeaderTitle;

    @AndroidFindBy(id = "com.myvodafoneapp:id/dashboardHeaderAccountSecondaryText\n")
    @iOSXCUITFindBy(id= "Already a Vodafone customer? Log in")
    public WebElement NewDBHeaderSubTitle;

    @AndroidFindBy(id = "com.myvodafoneapp:id/dashboardHeaderAccountPrimaryText")
    @iOSXCUITFindBy(id= "icChevronRightWhite")
    public WebElement ArrowLogin;

    public AcquisitionBoardPO() {
        super();
    }


    ////

    @AndroidFindBy(id = "com.myvodafoneapp:id/sectionTitle")
    @iOSXCUITFindBy(xpath = "/XCUIElementTypeApplication/XCUIElementTypeWindow[1]/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeOther/XCUIElementTypeStaticText")
    public WebElement DiscoverVodafone;

    @AndroidFindBy(xpath = "	/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.LinearLayout/android.widget.ScrollView/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.TextView")
    @iOSXCUITFindBy(xpath = "/XCUIElementTypeApplication/XCUIElementTypeWindow[1]/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell[1]/XCUIElementTypeOther/XCUIElementTypeStaticText")
    public WebElement PayMonthlyCta;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.LinearLayout/android.widget.ScrollView/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.FrameLayout/android.widget.ImageView")
    @iOSXCUITFindBy(xpath = "/XCUIElementTypeApplication/XCUIElementTypeWindow[1]/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeImage")
    public WebElement PayMonthlyIcon;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View[3]/android.widget.TextView")
    @iOSXCUITFindBy(xpath = "/XCUIElementTypeApplication/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeWebView/XCUIElementTypeWebView/XCUIElementTypeWebView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeStaticText")
    public WebElement PayMonthly_WebView;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.LinearLayout/android.widget.ScrollView/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.widget.TextView")
    @iOSXCUITFindBy(xpath = "/XCUIElementTypeApplication/XCUIElementTypeWindow[1]/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell[2]/XCUIElementTypeOther/XCUIElementTypeStaticText")
    public WebElement SimOnlyDeals;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.LinearLayout/android.widget.ScrollView/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.widget.FrameLayout/android.widget.ImageView")
    @iOSXCUITFindBy(xpath = "/XCUIElementTypeApplication/XCUIElementTypeWindow[1]/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeImage")
    public WebElement SimOnlyDealsIcon;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View[2]/android.view.View[3]/android.view.View/android.widget.TextView[2]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='CapsuleViewController']")
    public WebElement SimOnlyDealsWebView;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.LinearLayout/android.widget.ScrollView/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]/android.widget.TextView")
    @iOSXCUITFindBy(xpath = "/XCUIElementTypeApplication/XCUIElementTypeWindow[1]/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell[3]/XCUIElementTypeOther/XCUIElementTypeStaticText")
    public WebElement BroadbandCta;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.LinearLayout/android.widget.ScrollView/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]/android.widget.FrameLayout/android.widget.ImageView")
    @iOSXCUITFindBy(xpath = "/XCUIElementTypeApplication/XCUIElementTypeWindow[1]/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeImage")
    public WebElement BroadbandIcon;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View/android.view.View[2]/android.widget.TextView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Log In']")
    public WebElement BroadBandWebView;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.LinearLayout/android.widget.ScrollView/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[4]/android.widget.TextView")
    @iOSXCUITFindBy(xpath = "/XCUIElementTypeApplication/XCUIElementTypeWindow[1]/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell[4]/XCUIElementTypeOther/XCUIElementTypeStaticText")
    public WebElement TradeInToolCTA;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.LinearLayout/android.widget.ScrollView/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[4]/android.widget.FrameLayout/android.widget.ImageView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Get a trade-in quote']")
    public WebElement TradeInToolIcon;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[2]/android.view.View[1]/android.widget.Image")
    @iOSXCUITFindBy(xpath = "/XCUIElementTypeApplication/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeWebView/XCUIElementTypeWebView/XCUIElementTypeWebView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeStaticText")
    public WebElement TradeInToolsWebView;

    @AndroidFindBy(id = "com.myvodafoneapp:id/tv_title")
    @iOSXCUITFindBy(id= "DBlatestTitle")
    public WebElement LatestOffersTitle;

    @AndroidFindBy(xpath = "//*[@text='Discover all our best offers and promotions in one place']")
    @iOSXCUITFindBy(id= "Discover all our best offers and promotions in one place")
    public WebElement FirstOffer;

    @AndroidFindBy(id = "com.myvodafoneapp:id/cta_primary_btn")
    @iOSXCUITFindBy(id= "Find out more")
    public WebElement offerCta;

    @AndroidFindBy(xpath = "//*[@text='Vodafone deals and offers']")
    @iOSXCUITFindBy(id= "Vodafone deals and offers")
    @iOSXCUITFindBy(xpath = "(//*[@label='Vodafone deals and offers'])")
    public WebElement firstOfferWebViewDescription;

    @AndroidFindBy(xpath = "(//*[@resource-id='com.myvodafoneapp:id/cta_description'])[1]")
    @AndroidFindBy(xpath = "//*[@text='Order a free SIM today and add a Pay as you go Bundle later']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Order a free SIM today and add a Pay as you go Bundle later\"]")
    public WebElement SecondOffer;

    @AndroidFindBy(id = "com.myvodafoneapp:id/tvTitle")
    @iOSXCUITFindBy(xpath = "(//*[@label='My Vodafone'])")
    public WebElement SecondOfferWebView;

    @AndroidFindBy(xpath = "//*[@text='Order a free SIM']")
    @iOSXCUITFindBy(id= "Order a free SIM")
    @iOSXCUITFindBy(xpath = "(//*[@label='Order a free SIM'])")
    public WebElement SecondOfferWebViewDescription;

    @AndroidFindBy(xpath = "//*[@text='Discover more']")
    @iOSXCUITFindBy(id= "Discover more")
    public WebElement thirdOfferWebViewDescription;

    //using resource-id will be the same when ever you swipe -- the displayed offer will be with index 1
    //as android screen see 2 card elements after the swipe
//  @AndroidFindBy(xpath = "(//*[@resource-id='com.myvodafoneapp:id/cta_description'])[1]")
    @AndroidFindBy(xpath = "//*[@text='Find out how our Network is performing where you are']")
    @iOSXCUITFindBy(id= "Find out how our Network is performing where you are")
    public WebElement ThirdOffer;

    @AndroidFindBy(id = "com.myvodafoneapp:id/tvTitle")
    @iOSXCUITFindBy(xpath = "(//*[@label='My Vodafone'])")
    public WebElement ThirdOfferWebView;

}

package pages.Dashboard.Discover;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITBy;
import io.appium.java_client.pagefactory.iOSXCUITFindAll;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.Commons.CommonPo;


public class DiscoverPO extends CommonPo {


            @AndroidFindBy(id= "com.myvodafoneapp:id/offerDescTextView")
            @iOSXCUITFindBy(xpath= "(//XCUIElementTypeStaticText[@name='txtDashboardDiscoverOfferDescription'])[1]")
    public WebElement DB_NBADefaultOffersBody;

            @AndroidFindBy(id= "com.myvodafoneapp:id/offerImageView")
            @iOSXCUITFindBy(xpath= "//XCUIElementTypeOther[@name='wdgDashboardDiscoverSection']/XCUIElementTypeImage")
    public WebElement DB_NBADefaultOffersImage;

    @AndroidFindBy(id = "com.myvodafoneapp:id/positiveButton")
    @iOSXCUITFindBy(id = "btnDashboardDiscoverFindOutMoreCTA")

    public WebElement DB_NBADefaultOffersCTA;

    //@FindBy(how = How.ID_OR_NAME, using = "Vodafone deals and offers"),
    @AndroidFindBy(xpath = "//*[@text='Vodafone deals and offers']")
    @iOSXCUITFindBy(xpath = "//*[@name='Vodafone deals and offers']")

    public WebElement OffersTittleinExternalBrowser;


    @AndroidFindBy(id = "com.myvodafoneapp:id/btnDashboardDiscoverDismissCTA")
    @iOSXCUITFindBy(id = "btnDashboardDiscoverDismissCTA")

    public WebElement DB_NBADefaultOffersDismissCTA;


    @AndroidFindBy(xpath = "(//*[@resource-id='com.myvodafoneapp:id/positiveButton'])[1]")
    @iOSXCUITFindAll({
            @iOSXCUITBy(xpath = "//*[@label='Find out more']"),
            @iOSXCUITBy(xpath = "//*[@label='Find out']"),
            @iOSXCUITBy(xpath = "//XCUIElementTypeButton[@name='btnDashboardDiscoverFindOutMoreCTA']")
    })
    public WebElement DB_DiscoverAcceptCTA;


    @AndroidFindBy(xpath = "(//*[@resource-id='com.myvodafoneapp:id/negativeButton'])[1]")
    @iOSXCUITFindAll({
            @iOSXCUITBy(xpath = "//*[@label='No thanks']"),
            @iOSXCUITBy(xpath = "//*[@label='Not Now']"),
            @iOSXCUITBy(xpath = "//*[@label='Not Now']")
    })
    public WebElement DB_DiscoverDeclineCTA;


        @AndroidFindBy(id = "com.myvodafoneapp:id/txtViewAllDesc")
        @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains (@name, 'See the latest offers')]")

    public WebElement DB_DiscoverAcceptScreen;


        @AndroidFindBy(id = "com.myvodafoneapp:id/img_close")
        @iOSXCUITFindBy(id = "closeIcon")

    public WebElement ViewAllDiscoverOffersScreen;


    @AndroidFindBy(id = "com.myvodafoneapp:id/img_close")
    @iOSXCUITFindBy(id = "closeIcon")

    public WebElement DB_DiscoverXIcon;
    @AndroidFindBy(id = "com.myvodafoneapp:id/DXIDMSkipLogin_Button")
    @iOSXCUITFindBy(id = "yourElementId")
    private WebElement yourElement;
    public DiscoverPO() {
        super();
    }
}

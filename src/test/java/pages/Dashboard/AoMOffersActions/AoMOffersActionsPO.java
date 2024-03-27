package pages.Dashboard.AoMOffersActions;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITBy;
import io.appium.java_client.pagefactory.iOSXCUITFindAll;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.Commons.CommonPo;

public class AoMOffersActionsPO extends CommonPo {

            @AndroidFindBy(id =  "negativeButton")
            @iOSXCUITFindAll({
                    @iOSXCUITBy(xpath = "//*[@name='btnDashboardDiscoverDismissCTA']"),
                    @iOSXCUITBy(id = "btnDashboardDiscoverDismissCTA")
            })
    public static WebElement dismissCTA;
            @AndroidFindBy(id =  "positiveButton")
            @iOSXCUITFindAll({
                    @iOSXCUITBy(xpath = "//*[@name='btnDashboardDiscoverFindOutMoreCTA']"),
                    @iOSXCUITBy(id = "btnDashboardDiscoverFindOutMoreCTA")
            })
    public static WebElement acceptCTA;
            @AndroidFindBy(id = "offerImageView")
            @iOSXCUITFindAll({
                    @iOSXCUITBy(xpath = "//*[@name='wdgDashboardDiscoverSection']"),
                    @iOSXCUITBy(id = "wdgDashboardDiscoverSection")
            })
    public WebElement firstAOMOffer;
            @AndroidFindBy(id = "offerDescTextView")
            @iOSXCUITFindAll({
                    @iOSXCUITBy(xpath = "//*[@name='txtDashboardDiscoverOfferDescription']"),
                    @iOSXCUITBy(id = "txtDashboardDiscoverOfferDescription")
            })
    public WebElement firstOfferText;

            @AndroidFindBy(id = "//*[@text='My Account']")
            @iOSXCUITFindBy(id = "My Account")
    public WebElement DB_MyAccountTray_icon;

    public AoMOffersActionsPO() {
        super();
    }
}

package pages.Dashboard.ChordientOffersActionsV2;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITBy;
import io.appium.java_client.pagefactory.iOSXCUITFindAll;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.Commons.CommonPo;

public class ChordientOffersActionsPO extends CommonPo {

            @AndroidFindBy(id = "negativeButton")
            @iOSXCUITFindAll({
                    @iOSXCUITBy(id = "btnDashboardDiscoverDismissCTA"),
                    @iOSXCUITBy(xpath = "//*[@name='btnDashboardDiscoverDismissCTA']")
            })
    public static WebElement dismissCTA;
            @AndroidFindBy(id = "positiveButton")
            @iOSXCUITFindAll({
                    @iOSXCUITBy(id = "btnDashboardDiscoverFindOutMoreCTA"),
                    @iOSXCUITBy(xpath = "//*[@name='btnDashboardDiscoverFindOutMoreCTA']")
            })
    public static WebElement acceptCTA;
            @AndroidFindBy(id = "offerImageView")
            @iOSXCUITFindAll({
                    @iOSXCUITBy(id = "wdgDashboardDiscoverSection"),
                    @iOSXCUITBy(xpath = "//*[@name='wdgDashboardDiscoverSection']")
            })
    public WebElement firstAOMOffer;
            @AndroidFindBy(id = "offerDescTextView")
            @iOSXCUITFindAll({
                    @iOSXCUITBy(id = "txtDashboardDiscoverOfferDescription"),
                    @iOSXCUITBy(xpath = "//*[@name='txtDashboardDiscoverOfferDescription']")
            })
    public WebElement firstOfferText;

            @AndroidFindBy(xpath = "//*[@text='My Account']")
            @iOSXCUITFindBy(id = "My Account")
    public WebElement DB_MyAccountTray_icon;

            @AndroidFindBy(id = "txtDashboardVeryMeRewardsTitle")
            @iOSXCUITFindBy(id = "wdgDiscoverOffersContainer")
    public static WebElement scrollDownToDiscoverSection;
}

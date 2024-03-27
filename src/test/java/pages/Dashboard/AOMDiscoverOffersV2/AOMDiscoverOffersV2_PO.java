package pages.Dashboard.AOMDiscoverOffersV2;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITBy;
import io.appium.java_client.pagefactory.iOSXCUITFindAll;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import pages.Commons.CommonPo;

import java.util.List;

public class AOMDiscoverOffersV2_PO extends CommonPo {

    public AOMDiscoverOffersV2_PO(){super();}

            @AndroidFindBy(xpath = "(//*[@resource-id='com.myvodafoneapp:id/offerDescTextView'])[1]")
            @iOSXCUITFindAll({
                    @iOSXCUITBy(xpath = "//*[@name='txtDashboardDiscoverOfferDescription'])[1]"),
                    @iOSXCUITBy(id = "txtDashboardDiscoverOfferDescription")
            })
    public WebElement firstAOMOffer;

            @AndroidFindBy(xpath = "(//*[@resource-id='com.myvodafoneapp:id/offerDescTextView'])[2]")
            @iOSXCUITFindBy(xpath = "(//*[@name='txtDashboardDiscoverOfferDescription'])[2]")
    public WebElement secondAOMOffer;
            @AndroidFindBy(xpath = "(//*[@resource-id='com.myvodafoneapp:id/offerDescTextView'])[3]")
            @iOSXCUITFindBy(xpath = "(//*[@name='txtDashboardDiscoverOfferDescription'])[2]")
            @iOSXCUITFindAll({
                    @iOSXCUITBy(xpath = "//*[@name='txtDashboardDiscoverOfferDescription'])[1]"),
                    @iOSXCUITBy(id = "txtDashboardDiscoverOfferDescription")
            })
    public WebElement thirdAOMOffer;

            @AndroidFindBy(id =  "com.myvodafoneapp:id/offerTitleTextView")
            @iOSXCUITFindBy(id = "txtDashboardDiscoverTitle")
    public static WebElement DefaultOffer_Title;

            @AndroidFindBy(id =  "com.myvodafoneapp:id/offersRecyclerView")
            @iOSXCUITFindBy(id = "wdgDashboardDiscoverSection")
    public static WebElement Discover_Carousel;

}
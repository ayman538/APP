package pages.Dashboard.VeryMe;

import models.response.DashboardV4ResponseModel;
import models.response.VeryMeResponseModel;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.testng.Assert;
import utilities.PropertiesLoader;
import utils.DashboardUtils;
import utils.VeryMeUtils;

import java.util.Properties;

import static utilities.PropertiesLoader.readPropertyFile;
import static utils.element_helpers.ActionsHelpers.tapAtt;
import static utils.element_helpers.GenericHelpers.navigateToURL;
import static utils.element_helpers.GenericHelpers.openDeepLinkForiOS;
import static utils.element_helpers.ScrollHelpers.*;
import static utils.element_helpers.VerifyHelpers.*;
import static utils.element_helpers.ScrollHelpers.SwipeToElement;
import static utils.element_helpers.ScrollHelpers.scrollDownTo;
import static utils.element_helpers.VerifyHelpers.elementIsPresent;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

public class VeryMeIOS extends VeryMeAbstract{
    private final By very_me_view_all_CTA = By.xpath("//XCUIElementTypeButton[@name='btnDashboardVeryMeRewardsCTA']");
    private final By very_me_title = By.xpath("(//XCUIElementTypeStaticText[@name='txtDashboardVeryMeRewardsTitle'])[2]");
    private final By very_me_image = By.xpath("(//XCUIElementTypeImage[@name='imgDashboardVeryMeOffer'])[1]");
    private final By very_me_offer_title = By.xpath("(//XCUIElementTypeStaticText[@name='txtDashboardVeryMeOfferTitle'])[1]");
    private final By very_me_offer_logo = By.xpath("(//XCUIElementTypeImage[@name='imgDashboardVeryMeOfferLogo'])[1]");
    static Properties envProp = readPropertyFile("config/env.properties");
    Boolean live = System.getProperty("isLiveTest", envProp.getProperty("isLiveTest")).equalsIgnoreCase("true");


    public VeryMeIOS(){
        super();
        if(!live){
            DashboardResponse = DashboardUtils.GetDashboard();
        }
    }

    DashboardV4ResponseModel DashboardResponse;
    VeryMeResponseModel veryMeResponseModel;

    public void scrollDownToVeryMe(){
        waitForVisibility(DB_SettingDashboardTray_icon);
        scrollDownTo(DB_CarouselVeryMe_logo);
    }

    public void checkVeryMeTitle(){
        if(live){
            scrollUpTo(very_me_view_all_CTA);
            verifyAllElementsPresent(very_me_title,very_me_view_all_CTA,very_me_image);
            scrollDownTo(very_me_offer_title);
            verifyAllElementsPresent(very_me_offer_title,very_me_offer_logo);
            AssertResult(DB_VeryMe_Title.getText(), "VeryMe Rewards");
        }else {
            AssertDisplayed(DB_VeryMe_Title.isDisplayed());
            AssertResult(DB_VeryMe_Title.getText(), DashboardResponse.veryMeLink.heading);
        }
    }

    public void checkVeryMeViewAllCTA() throws InterruptedException {
        scrollDownToVeryMe();
        //AssertResult(DB_ViewAll_CTA.getText(),DashboardResponse.veryMeLink.ctaLabel);
        //Assert.assertTrue(DashboardResponse.veryMeLink.ctaTarget.equalsIgnoreCase("LOYALTY_LASSIE"));
        DB_ViewAll_CTA.click();
        waitForVisibility(DB_VerMePage);
        AssertDisplayed(DB_VerMePage.isDisplayed());
    }

    public void assertLassieDisplayed() {
        waitForVisibility(DB_Lassie);
        System.out.println("Wait till the lassie displayed ");
        AssertDisplayed(DB_VerMePage.isDisplayed());
        System.out.println("should the web page displayed successfully ");
    }

    public void lassieCTA() throws InterruptedException {
        Thread.sleep(4500);
        Point location = DB_Lassie.getLocation();
        tapAtt(location.x , location.y);
        waitForVisibility(DB_SettingDashboardTray_icon);
    }

    public void checkVeryMeUI(){
        veryMeResponseModel = VeryMeUtils.getVeryMe();
        scrollDownTo(DB_CarouselVeryMe_logo);
        if(veryMeResponseModel.status.code == 0) {
            int VeryMeOffers = veryMeResponseModel.veryMeOffers.items.size();
            for (int offerNo = 0; offerNo < VeryMeOffers; offerNo++) {
                AssertDisplayed(DB_CarouselVeryMe_Image.isDisplayed());
                AssertDisplayed(DB_CarouselVeryMe_text.isDisplayed());
                AssertDisplayed(DB_CarouselVeryMe_logo.isDisplayed());
                if (offerNo < (VeryMeOffers - 1))
                    SwipeToElement(DB_CarouselVeryMe_Image, "Left");
            }
        }

    }

    public void checkVeryMeDisappearForSpecificUsers() {
        waitForVisibility(DB_AllowanceTileHeader);
        scrollDownTo(DB_EshopTitle);
        HardAssertNotDisplayed("Veryme", elementIsPresent(DB_VeryMe_Title));
        HardAssertNotDisplayed("View All", elementIsPresent(DB_ViewAll_CTA));
        if (System.getProperty("isLiveTest", PropertiesLoader.readEnv("isLiveTest")).equalsIgnoreCase("false"))
            Assert.assertNull(DashboardResponse.veryMe);
    }

    @Override
    public void validateVeryMeDeepLink() {
        openDeepLinkForiOS("myvodafone://LOYALTY_LASSIE");
        waitForVisibility(DB_VerMePage);
        AssertDisplayed(DB_VerMePage.isDisplayed());
    }

    @Override
    public void validateVeryMeUniversalLink() {
        navigateToURL("https://www.vodafone.co.uk/myvf/verymerewards");
        waitForVisibility(DB_VerMePage);
        AssertDisplayed(DB_VerMePage.isDisplayed());
    }

}

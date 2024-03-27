package pages.Dashboard.VeryMe;

import models.response.DashboardV4ResponseModel;
import models.response.VeryMeResponseModel;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.testng.Assert;
import utils.DashboardUtils;
import utils.VeryMeUtils;
import java.util.Properties;

import static utilities.PropertiesLoader.readEnv;
import static utilities.PropertiesLoader.readPropertyFile;

import static utils.element_helpers.ActionsHelpers.tapAtt;
import static utils.element_helpers.GenericHelpers.navigateToURL;
import static utils.element_helpers.ScrollHelpers.*;
import static utils.element_helpers.VerifyHelpers.*;
import static utils.element_helpers.VerifyHelpers.verifyAllElementsPresent;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

public class VeryMeAndroid extends VeryMeAbstract{
    Boolean live = System.getProperty("isLiveTest", readEnv("isLiveTest")).equalsIgnoreCase("true");
    DashboardV4ResponseModel DashboardResponse;
    VeryMeResponseModel veryMeResponseModel;
    private final By very_me_view_all_CTA = By.id("com.myvodafoneapp:id/btnDashboardVeryMeRewardsCTA");
    private final By very_me_title = By.id("com.myvodafoneapp:id/txtDashboardVeryMeRewardsTitle");
    private final By very_me_offer_title = By.id("com.myvodafoneapp:id/txtDashboardVeryMeOfferTitle");
    private final By very_me_image = By.id("com.myvodafoneapp:id/imgDashboardVeryMeOffer");

    public VeryMeAndroid(){
        super();
        if(!live) {
            DashboardResponse = DashboardUtils.GetDashboard();
            veryMeResponseModel = VeryMeUtils.getVeryMe();
        }
    }

    public void scrollDownToVeryMe(){
        waitForVisibility(DB_SettingDashboardTray_icon);
        scrollDownTo(DB_CarouselVeryMe_logo);
    }
    public void checkVeryMeTitle(){
        if(live){
            scrollUpTo(very_me_view_all_CTA);
            System.out.println(driver.findElement(very_me_title).getText());
            AssertResult(driver.findElement(very_me_title).getText(), "VeryMe Rewards");
            verifyAllElementsPresent(very_me_title,very_me_view_all_CTA,very_me_image);
            scrollDownTo(very_me_offer_title);
            verifyAllElementsPresent(very_me_offer_title);
        }else {
            AssertDisplayed(DB_VeryMe_Title.isDisplayed());
            AssertResult(DB_VeryMe_Title.getText(), DashboardResponse.veryMeLink.heading);
        }
    }

    public void checkVeryMeViewAllCTA() throws InterruptedException {
        scrollDownToVeryMe();
        AssertDisplayed(DB_ViewAll_CTA.isDisplayed());
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
        scrollDownTo(DB_CarouselVeryMe_logo);
        int VeryMeOffers = veryMeResponseModel.veryMeOffers.items.size();

        for (int offerNo=0; offerNo<VeryMeOffers; offerNo++){
            AssertDisplayed(DB_CarouselVeryMe_Image.isDisplayed());
            AssertDisplayed(DB_CarouselVeryMe_text.isDisplayed());
            AssertDisplayed(DB_CarouselVeryMe_logo.isDisplayed());
            if(offerNo < (VeryMeOffers-1))
                SwipeToElement(DB_CarouselVeryMe_Image, "Left");
        }

    }

    public void checkVeryMeDisappearForSpecificUsers(){
        waitForVisibility(DB_AllowanceTileHeader);
        scrollDownTo(DB_AssistanceTitle);
        try {
            AssertDisplayed(DB_VeryMe_Title.isDisplayed());
            AssertDisplayed(DB_ViewAll_CTA.isDisplayed());
            Assert.assertNull(DashboardResponse.veryMe);
        }
        catch (org.openqa.selenium.NoSuchElementException e) {
            System.out.println("Element shouldn't be visible to this user");
        }

    }

    @Override
    public void validateVeryMeDeepLink() {
        navigateToURL("myvodafone://LOYALTY_LASSIE");
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

package pages.Dashboard.Discover;

import models.response.DiscoverResponseModel;
import utils.DiscoverOffersUtils;

import static utils.element_helpers.ScrollHelpers.scrollDownTo;
import static utils.element_helpers.VerifyHelpers.*;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

@Deprecated
public class DiscoverLogic extends DiscoverPO {


    private DiscoverResponseModel discoverResponseModel;

    public DiscoverLogic(){
        super();
        discoverResponseModel = DiscoverOffersUtils.getDiscoverOffers();
        waitForVisibility(DB_SettingDashboardTray_icon);
    }

    public void ValidateDiscoverCardDisplayed() throws InterruptedException {
        System.out.println("ValidateDiscoverCardDisplayed ");
        Thread.sleep(4000);
        if (discoverResponseModel.items.size() == 0) {
            System.out.println("if the discoverOffers is equal 0" + discoverResponseModel.items.size());
            scrollToDiscoverAndWait();
            assertDefaultOfferImgDisplayed();
            assertDefaultOfferBodyText();
            assertDefaultOfferCTAText();
            assertDefaultOfferDismissCTADisplayed();
        }
        else if(discoverResponseModel.items.size() !=0 && discoverResponseModel.items.size() < 3) {
            System.out.println("There are more than one offer however not more than 3 so View All CTA will not be displayed ");
            CheckElementNotExist(DB_DiscoverViewAllCTA);
        }
    }

    public void ValidateViewAllCTAIsDisplayed() throws InterruptedException
    {
        System.out.println("ValidateDiscoverCardDisplayed ");
        Thread.sleep(4000);
        if(discoverResponseModel.items.size() > 3)
        {
            System.out.println("There are more than three offers");
        }
        assertViewAllCtaDiscplayed();
        System.out.println("View All CTA is displayed successfully!!");
    }

    public void ValidateViewAllCTAIsWorkingSuccessfully() {
        waitForVisibility(DB_DiscoverViewAllCTA);
        DB_DiscoverViewAllCTA.click();
        waitForVisibility(ViewAllDiscoverOffersScreen);
        AssertDisplayed(ViewAllDiscoverOffersScreen.isDisplayed());
    }

    public void DiscoverOffersTC_AcceptCTA() {
        waitForVisibility(DB_DiscoverAcceptCTA);
        DB_DiscoverAcceptCTA.click();
        waitForVisibility(DB_DiscoverAcceptScreen);
        AssertDisplayed(DB_DiscoverAcceptScreen.isDisplayed());
    }

    public void DiscoverOffersTC_DeclinedCTA() {
        scrollDownTo(DB_DiscoverViewAllCTA);
        DB_DiscoverViewAllCTA.click();
        waitForVisibility(DB_DiscoverAcceptScreen);
        scrollDownTo(DB_DiscoverDeclineCTA);
        DB_DiscoverDeclineCTA.click();
    }

    public void DiscoverOffersTC_XIcon() {
        waitForVisibility(DB_DiscoverXIcon);
        DB_DiscoverXIcon.click();
        waitForVisibility(DB_DiscoverViewAllCTA);
        AssertDisplayed(DB_DiscoverViewAllCTA.isDisplayed());
    }

    public void assertViewAllCtaDiscplayed(){
        AssertDisplayed(DB_DiscoverViewAllCTA.isDisplayed());
        System.out.println("Offers appear in the carousel and View all CTA is displayed successfully");
    }

    public void assertDefaultOfferDismissCTADisplayed() {
        AssertDisplayed(CheckElementNotExistWithoutScroll(DB_NBADefaultOffersDismissCTA));
        System.out.println("The NBA offer dismiss call to action displayed successfully");
    }

    public void assertDefaultOfferCTAText() {
        AssertResult(DB_NBADefaultOffersCTA.getText(), "Find out more");
        System.out.println("The NBA offer CTA displayed successfully");
    }

    public void assertDefaultOfferBodyText() {
        AssertResult(DB_NBADefaultOffersBody.getText(), "Get more of the good stuff with our deals");
        System.out.println("The NBA offer text displayed successfully");
    }

    public void assertDefaultOfferImgDisplayed() {
        AssertDisplayed(DB_NBADefaultOffersImage.isDisplayed());
        System.out.println("Th image of NBA offer displayed successfully ");
    }

    public void scrollToDiscoverAndWait() {
        scrollDownTo(DB_NBADefaultOffersCTA);
        waitForVisibility(DB_NBADefaultOffersBody);
        System.out.println("Th NBA default offer body is displayed ");
    }

    public void ValidateOfferIsOpened() throws InterruptedException {
        System.out.println("ValidateOfferIsOpened ");
        Thread.sleep(4000);
        if (discoverResponseModel.items.size() == 0) {
            System.out.println("if the discoverOffers is equal 0" + discoverResponseModel.items.size());
            defaultOfferCTA();
            assertDoneCTADisplayed();
            doneCTA();
        }
        // ToDo handling the user has offers
    }

    public void doneCTA() {
        DoneCtaInExternalbrowser.click();
        System.out.println("Click on the Done CTA in external browser ");
        waitForVisibility(DB_SettingDashboardTray_icon);
        System.out.println("wait till the setting in the dashboard displayed ");
    }

    public void assertDoneCTADisplayed() {
        waitForVisibility(DoneCtaInExternalbrowser);
        System.out.println("Wait till CTA in external browser is displayed ");
        AssertDisplayed(DoneCtaInExternalbrowser.isDisplayed());
        System.out.println("Check the done CTA in the external browser is displayed ");
    }

    public void defaultOfferCTA() {
        scrollDownTo(DB_NBADefaultOffersCTA);
        System.out.println("scroll to the offer CTA displayed successfully");
        DB_NBADefaultOffersCTA.click();
        System.out.println("Click on the NBA offer CTA BTN ");
    }

}

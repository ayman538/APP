package pages.Dashboard.Discover;

import models.response.DashboardV4ResponseModel;
import models.response.DiscoverV2ResponseModel;
import org.openqa.selenium.By;
import utils.DashboardUtils;
import utils.DiscoverOffersUtils;


import static utilities.PropertiesLoader.readEnv;
import static utilities.PropertiesLoader.readPropertyFile;
import static utils.element_helpers.ScrollHelpers.scrollDownElementOverCenterScreen;
import static utils.element_helpers.ScrollHelpers.scrollDownTo;
import static utils.element_helpers.VerifyHelpers.*;
import static utils.element_helpers.WaitHelpers.waitForVisibility;


public class DiscoverIOS extends DiscoverAbstract {
    Boolean live = System.getProperty("isLiveTest", readEnv("isLiveTest")).equalsIgnoreCase("true");
    private final By discover_image = By.xpath("(//XCUIElementTypeOther[@name='wdgDashboardDiscoverSection'])[1]/XCUIElementTypeImage");
    private final By discover_description = By.xpath("(//XCUIElementTypeStaticText[@name='txtDashboardDiscoverOfferDescription'])[1]");
    private final By accept_CTA = By.xpath("(//XCUIElementTypeButton[@name='btnDashboardDiscoverFindOutMoreCTA'])[1]");
    private final By Reject_CTA = By.xpath("//XCUIElementTypeButton[@name='btnDashboardDiscoverDismissCTA']");
    private DiscoverV2ResponseModel discoverResponseModel;
    private DiscoverV2ResponseModel discoverResponseModelV2;
    DashboardV4ResponseModel DashboardResponse;

    public DiscoverIOS() {
        super();
        if(!live) {
            discoverResponseModel = DiscoverOffersUtils.getDiscoverOffersV2();
            waitForVisibility(DB_SettingDashboardTray_icon);
        }
    }

    @Override
    public void ValidateDiscoverCardDisplayed() throws InterruptedException {
        Thread.sleep(4000);
        scrollToDiscoverAndWait();
        if(live){
            verifyAllElementsPresent(discover_image,discover_description,accept_CTA,Reject_CTA);
        }else {
            if (discoverResponseModel.items != null && discoverResponseModel.items.size() == 0) {
                assertDefaultOfferImgDisplayed();
                assertDefaultOfferBodyText();
                assertDefaultOfferCTAText();
                assertDefaultOfferDismissCTADisplayed();
            }
        }
    }

    @Override
    public void ValidateViewAllCTA() throws InterruptedException {
        Thread.sleep(4000);
        if (discoverResponseModel.items.size() > 3)
            assertViewAllCtaDisplayed();
        else
            assertViewAllCtaNOTDisplayed();
    }

    @Override
    public void assertViewAllCtaNOTDisplayed() {
        boolean exist = false;
        try {
            exist = DB_DiscoverViewAllCTA.isDisplayed();
        } catch (Exception e) {
            System.out.println("CTA is Exist");
        }
        AssertDisplayed(!exist);
    }

    @Override
    public void ValidateViewAllCTAIsWorkingSuccessfully() {
        if (discoverResponseModel.items.size() > 3) {
            waitForVisibility(DB_DiscoverViewAllCTA);
            DB_DiscoverViewAllCTA.click();
            waitForVisibility(ViewAllDiscoverOffersScreen);
            AssertDisplayed(ViewAllDiscoverOffersScreen.isDisplayed());
        }
    }

    @Override
    public void DiscoverOffersTC_AcceptCTA() {
        if (discoverResponseModel.items.size() > 0) {
            waitForVisibility(DB_SettingDashboardTray_icon);
            scrollDownElementOverCenterScreen(DB_DiscoverAcceptCTA);
            DB_DiscoverAcceptCTA.click();
            assertDoneCTADisplayed();
            doneCTA();
        }
    }

    @Override
    public void DiscoverOffersTC_DeclinedCTA() {
        if (discoverResponseModel.items.size() > 3) {
            scrollDownElementOverCenterScreen(DB_DiscoverViewAllCTA);
            DB_DiscoverViewAllCTA.click();
            waitForVisibility(DB_DiscoverAcceptScreen);
            scrollDownElementOverCenterScreen(DB_DiscoverDeclineCTA);
            DB_DiscoverDeclineCTA.click();
        }
    }

    @Override
    public void DiscoverOffersTC_XIcon() {
        if (discoverResponseModel.items.size() > 3) {
            waitForVisibility(DB_DiscoverXIcon);
            DB_DiscoverXIcon.click();
            waitForVisibility(DB_SettingDashboardTray_icon);
            try {
                scrollDownElementOverCenterScreen(DB_DiscoverViewAllCTA);
                AssertDisplayed(DB_DiscoverViewAllCTA.isDisplayed());
            } catch (Exception e) {
                System.out.println("View All CTA is not displayed any more as less than 3 offers are displayed");
            }
        }
    }

    @Override
    public void assertViewAllCtaDisplayed() {
        waitForVisibility(DB_SettingDashboardTray_icon);
        scrollDownElementOverCenterScreen(DB_DiscoverViewAllCTA);
        AssertDisplayed(DB_DiscoverViewAllCTA.isDisplayed());
    }

    @Override
    public void assertDefaultOfferDismissCTADisplayed() {
        AssertDisplayed(CheckElementNotExistWithoutScroll(DB_NBADefaultOffersDismissCTA));
        System.out.println("The NBA offer dismiss call to action displayed successfully");
    }

    @Override
    public void assertDefaultOfferCTAText() {
        AssertResult(DB_NBADefaultOffersCTA.getText(), "Find out more");
        System.out.println("The NBA offer CTA displayed successfully");
    }

    @Override
    public void assertDefaultOfferBodyText() {
        AssertResult(DB_NBADefaultOffersBody.getText(), "Get more of the good stuff with our deals");
        System.out.println("The NBA offer text displayed successfully");
    }

    @Override
    public void assertDefaultOfferImgDisplayed() {
        AssertDisplayed(DB_NBADefaultOffersImage.isDisplayed());
        System.out.println("Th image of NBA offer displayed successfully ");
    }

    @Override
    public void scrollToDiscoverAndWait() {
        scrollDownElementOverCenterScreen(DB_NBADefaultOffersCTA);
        waitForVisibility(DB_NBADefaultOffersBody);
        System.out.println("Th NBA default offer body is displayed ");
    }

    @Override
    public void ValidateOfferIsOpened() {
        waitForVisibility(DB_SettingDashboardTray_icon);
        if (discoverResponseModel.items.size() == 0) {
            System.out.println("if the discoverOffers is equal 0 = " + discoverResponseModel.items.size());
            defaultOfferCTA();
        }
    }

    @Override
    public void ValidateOfferIsOpenedExternalBrowser() throws InterruptedException {
        DashboardResponse = DashboardUtils.GetDashboard();
        if (discoverResponseModel.items.size() == 0) {
            assertDiscoverOffersVisible();
            assertDoneCTADisplayed();
            doneCTA();
            assertEquals(DashboardResponse.discover.defaultOffer.buttons.size(), 1);
            assertEquals(DashboardResponse.discover.defaultOffer.buttons.get(0).text, "Find out more");
        }
    }

    @Override
    public void assertDiscoverOffersVisible() {
        waitForVisibility(OffersTittleinExternalBrowser);
        AssertDisplayed(OffersTittleinExternalBrowser.isDisplayed());
        System.out.println("Offers for you is opened successfully in the external browser");
    }

    @Override
    public void doneCTA() {
        DoneCtaInExternalbrowser.click();
        System.out.println("Click on the Done CTA in external browser ");
        waitForVisibility(DB_SettingDashboardTray_icon);
        System.out.println("wait till the setting in the dashboard displayed ");
    }

    @Override
    public void assertDoneCTADisplayed() {
        waitForVisibility(DoneCtaInExternalbrowser);
        System.out.println("Wait till CTA in external browser is displayed ");
        AssertDisplayed(DoneCtaInExternalbrowser.isDisplayed());
        System.out.println("Check the done CTA in the external browser is displayed ");
    }

    @Override
    public void defaultOfferCTA() {
        scrollDownTo(DB_NBADefaultOffersCTA);
        System.out.println("scroll to the offer CTA displayed successfully");
        DB_NBADefaultOffersCTA.click();
        System.out.println("Click on the NBA offer CTA BTN ");
    }

    @Override
    public void ValidateAomTileFunc() {
        discoverResponseModelV2= DiscoverOffersUtils.getDiscoverOffersV2();
        assertEquals("AoM", discoverResponseModelV2.items.get(0).offerSource);
        scrollDownTo(DB_NBADefaultOffersBody);
        DB_NBADefaultOffersBody.click();
        try {
            waitForVisibility(DoneCtaInExternalbrowser);
            AssertDisplayed(DoneCtaInExternalbrowser.isDisplayed());
            DoneCtaInExternalbrowser.click();
            waitForVisibility(DB_SettingDashboardTray_icon);
        } catch (Exception e) {
            waitForVisibility(WV_Xicon);
            AssertDisplayed(WV_Xicon.isDisplayed());
            WV_Xicon.click();
            waitForVisibility(DB_SettingDashboardTray_icon);
        }

    }
    @Override
    public void ValidateChordiantTileFunc() {
        discoverResponseModelV2= DiscoverOffersUtils.getDiscoverOffersV2();
        assertEquals("Chordiant",discoverResponseModelV2.items.get(0).offerSource);
        scrollDownTo(DB_NBADefaultOffersBody);
        DB_NBADefaultOffersBody.click();
        waitForVisibility(DoneCtaInExternalbrowser);
        AssertDisplayed(DoneCtaInExternalbrowser.isDisplayed());
        DoneCtaInExternalbrowser.click();
        waitForVisibility(DB_SettingDashboardTray_icon);
    }
}


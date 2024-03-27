package pages.Dashboard.AOMDiscoverOffersV2;

import models.response.DiscoverV2ResponseModel;
import utils.DiscoverOffersUtils;
import static utils.element_helpers.VerifyHelpers.*;
import static utils.element_helpers.WaitHelpers.*;
import static utils.element_helpers.ScrollHelpers.*;


public class AOMDiscoverOffersV2_Logic_iOS extends AOMDiscoverOffersV2_Abstract{

    DiscoverV2ResponseModel discoverV2ResponseModel = new DiscoverV2ResponseModel();

    public AOMDiscoverOffersV2_Logic_iOS() {super();}

    @Override
    public void AOMOffersIsDisplayed() throws InterruptedException {

        Thread.sleep(30000);
        scrollDownTo(firstAOMOffer);

        assertEquals("AoM", discoverV2ResponseModel.items.get(0).offerSource);
        assertEquals(firstAOMOffer.getText(), discoverV2ResponseModel.items.get(0).body);

        SwipeToElement(secondAOMOffer, "Left");
        assertEquals("AoM", discoverV2ResponseModel.items.get(1).offerSource);
        assertEquals(secondAOMOffer.getText(), discoverV2ResponseModel.items.get(1).body);

        SwipeToElement(thirdAOMOffer, "Left");
        assertEquals("AoM", discoverV2ResponseModel.items.get(2).offerSource);
        assertEquals(thirdAOMOffer.getText(), discoverV2ResponseModel.items.get(2).body);
    }

    @Override
    public void ChordiantOffersIsDisplayed() {
        discoverV2ResponseModel = DiscoverOffersUtils.getDiscoverOffersV2();
        int noOfReturnedOffers = discoverV2ResponseModel.items.size();
        scrollDownTo(firstAOMOffer.getText());
        for(int i=0; i < noOfReturnedOffers; i++){
            assertEquals("Chordiant", discoverV2ResponseModel.items.get(i).offerSource);
            if(i < 2)
                SwipeToElement(Discover_Carousel, "Left");
        }
    }

    public void assertViewAllCtaDisplayed() {
        waitForVisibility(DB_SettingDashboardTray_icon);
        //scrollDownTo(DB_DiscoverViewAllCTA);
        AssertDisplayed(DB_DiscoverViewAllCTA.isDisplayed());
    }
    @Override
    public void ValidateViewAllCTA() {
        discoverV2ResponseModel = DiscoverOffersUtils.getDiscoverOffersV2();
        if(discoverV2ResponseModel.items.size() > 3)
            assertViewAllCtaDisplayed();
        else
            HardAssertNotDisplayed("Discover CTA", elementIsPresent(DB_DiscoverViewAllCTA));
    }

    @Override
    public void defaultOfferIsDisplayed() {
        scrollDownTo(DefaultOffer_Title);
        assertEquals(DefaultOffer_Title.getText(), "Deals and offers");
        assertEquals(DefaultOffer_Description.getText(), "Get more of the good stuff with our deals");
    }

}
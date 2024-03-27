package pages.Dashboard.ChordientOffersActionsV2;

import models.response.DiscoverV2ResponseModel;
import utils.DiscoverOffersUtils;
import static utils.element_helpers.VerifyHelpers.*;
import static utils.element_helpers.ScrollHelpers.*;

public class ChordientOffersActionsAndroid extends ChordientOffersActionsAbstract {
    private DiscoverV2ResponseModel discoverV2ResponseModel;
    public ChordientOffersActionsAndroid() {
        super();
        discoverV2ResponseModel = DiscoverOffersUtils.getDiscoverOffersV2();

    }

    private String dismissedOfferText;
    private String targetURL;

    @Override
    public void userHasChordientOffer() {
        assertEquals("Chordiant", discoverV2ResponseModel.items.get(0).offerSource);;
    }

    @Override
    public void dismissAnOffer() {
        scrollDownTo(scrollDownToDiscoverSection);
        dismissedOfferText = firstOfferText.getText();
        dismissCTA.click();

    }


    @Override
    public void acceptAnOffer() {
        scrollDownTo(scrollDownToDiscoverSection);
        targetURL = discoverV2ResponseModel.items.get(1).buttons.get(0).targetURL;
        acceptCTA.click();
    }

    @Override
    public void offerIsDisplayed() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println(driver.getPageSource());
        if (targetURL.contains("myvf")) {
            assertEquals(true, driver.getPageSource().contains("com.myvodafoneapp"));
            CheckElementNotExist(DB_MyAccountTray_icon);
        } else {
            assertEquals(true, driver.getPageSource().contains("Close tab"));
            CheckElementNotExist(DB_MyAccountTray_icon);
        }
    }

    }



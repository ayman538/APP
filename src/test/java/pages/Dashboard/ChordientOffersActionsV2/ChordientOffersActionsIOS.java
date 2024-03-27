package pages.Dashboard.ChordientOffersActionsV2;

import models.response.DiscoverV2ResponseModel;
import utils.DiscoverOffersUtils;
import static utils.element_helpers.VerifyHelpers.*;
import static utils.element_helpers.ScrollHelpers.*;

public class ChordientOffersActionsIOS extends ChordientOffersActionsAbstract{
    private DiscoverV2ResponseModel discoverV2ResponseModel;
    public ChordientOffersActionsIOS() {
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
      //  scrollDownTo(scrollDownToDiscoverSection);
        scrollDownElementOverCenterScreen(scrollDownToDiscoverSection);
        dismissedOfferText = firstOfferText.getText();
        dismissCTA.click();

    }


    @Override
    public void acceptAnOffer() throws InterruptedException {
        scrollDownElementOverCenterScreen(scrollDownToDiscoverSection);
        Thread.sleep(5000);
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
            assertEquals(true, driver.getPageSource().contains("Done"));
            CheckElementNotExist(DB_MyAccountTray_icon);
        }
    }
}

package pages.Dashboard.AoMOffersActions;


import models.response.DiscoverV2ResponseModel;
import utils.DiscoverOffersUtils;
import static utils.element_helpers.VerifyHelpers.*;
import static utils.element_helpers.ScrollHelpers.*;

public class AoMOffersActionAndroid extends AoMOffersActionAbstract {

    private DiscoverV2ResponseModel discoverV2ResponseModel;

    public AoMOffersActionAndroid() {
        super();
        discoverV2ResponseModel = DiscoverOffersUtils.getDiscoverOffersV2();
    }


    private int offersCount;
    private String dismissedOfferText;
    private String targetURL;

    @Override
    public void checkNoOfReturnedOffers() {
        offersCount = discoverV2ResponseModel.items.size();
        assertEquals(true, offersCount >= 3);
    }

    @Override
    public void dismissAnOffer() {
        scrollDownTo(dismissCTA);
        dismissedOfferText = firstOfferText.getText();
        dismissCTA.click();
    }

    @Override
    public void offerIsDisappeared() throws InterruptedException {
        Thread.sleep(2000);
        assertEquals(false, firstOfferText.getText().equals(dismissedOfferText));
    }

    @Override
    public void acceptAnOffer() {
        targetURL = discoverV2ResponseModel.items.get(1).buttons.get(0).targetURL;
        scrollDownTo(acceptCTA);
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
            assertEquals(false, driver.getPageSource().contains("com.myvodafoneapp"));
            CheckElementNotExist(DB_MyAccountTray_icon);
        }
    }
}

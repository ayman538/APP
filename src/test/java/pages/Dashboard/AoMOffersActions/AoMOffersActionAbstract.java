package pages.Dashboard.AoMOffersActions;

public abstract class AoMOffersActionAbstract extends AoMOffersActionsPO {

    public AoMOffersActionAbstract() {
        super();
    }

    public abstract void checkNoOfReturnedOffers();

    public abstract void dismissAnOffer() throws InterruptedException;

    public abstract void offerIsDisappeared() throws InterruptedException;

    public abstract void acceptAnOffer() throws InterruptedException;

    public abstract void offerIsDisplayed() throws InterruptedException;
}

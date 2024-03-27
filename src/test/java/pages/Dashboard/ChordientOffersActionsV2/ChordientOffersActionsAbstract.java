package pages.Dashboard.ChordientOffersActionsV2;

public abstract class ChordientOffersActionsAbstract extends ChordientOffersActionsPO{

    public abstract void userHasChordientOffer() ;

    public abstract void dismissAnOffer() ;

    public abstract void acceptAnOffer() throws InterruptedException;

    public abstract void offerIsDisplayed() throws InterruptedException;
}

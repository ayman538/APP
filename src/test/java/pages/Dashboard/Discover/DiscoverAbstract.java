package pages.Dashboard.Discover;

public abstract class DiscoverAbstract extends DiscoverPO {

    public DiscoverAbstract(){
        super();
    }

    public abstract void ValidateDiscoverCardDisplayed() throws InterruptedException;

    public abstract void ValidateViewAllCTA() throws InterruptedException;

    public abstract void ValidateViewAllCTAIsWorkingSuccessfully();

    public abstract void DiscoverOffersTC_AcceptCTA();

    public abstract void DiscoverOffersTC_DeclinedCTA();

    public abstract void DiscoverOffersTC_XIcon();

    public abstract void assertViewAllCtaDisplayed();

    public abstract void assertViewAllCtaNOTDisplayed();

    public abstract void assertDefaultOfferDismissCTADisplayed();

    public abstract void assertDefaultOfferCTAText();

    public abstract void assertDefaultOfferBodyText();

    public abstract void assertDefaultOfferImgDisplayed();

    public abstract void scrollToDiscoverAndWait();

    public abstract void ValidateOfferIsOpened() throws InterruptedException;
    public abstract void ValidateOfferIsOpenedExternalBrowser() throws InterruptedException;

    public abstract void doneCTA();

    public abstract void assertDiscoverOffersVisible();

    public abstract void assertDoneCTADisplayed();

    public abstract void defaultOfferCTA();

    public abstract void ValidateAomTileFunc();

    public abstract void ValidateChordiantTileFunc();
}

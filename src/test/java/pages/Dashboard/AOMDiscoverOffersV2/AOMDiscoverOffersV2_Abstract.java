package pages.Dashboard.AOMDiscoverOffersV2;

public abstract class AOMDiscoverOffersV2_Abstract extends AOMDiscoverOffersV2_PO{

    public AOMDiscoverOffersV2_Abstract(){super();}

    public abstract void AOMOffersIsDisplayed() throws InterruptedException;

    public abstract void defaultOfferIsDisplayed();

    public abstract void ChordiantOffersIsDisplayed() throws InterruptedException;

    public abstract void ValidateViewAllCTA();
}
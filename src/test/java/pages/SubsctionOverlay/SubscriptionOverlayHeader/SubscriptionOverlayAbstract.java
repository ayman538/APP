package pages.SubsctionOverlay.SubscriptionOverlayHeader;

public abstract class SubscriptionOverlayAbstract extends SubscriptionOverlayPO{

    public SubscriptionOverlayAbstract(){
        super();
    }

    public abstract void navigateToSubsOverlay();

    public abstract void checkSubsOverlayHeader();

    public abstract void checkSubsHeaderIcon();

    public abstract void checkSubsHeaderID();

    public abstract void checkSubsHeaderType();

    public abstract void checkSubsHeaderCurrentCharges();

    public abstract void checkSubsHeaderCurrentChargesPeriod();

    public abstract void checkSubsHeaderCurrentAdditionalCharges();

}
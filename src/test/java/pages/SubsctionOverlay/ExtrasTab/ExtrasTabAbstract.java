package pages.SubsctionOverlay.ExtrasTab;

public abstract class ExtrasTabAbstract extends ExtrasPO{

    public ExtrasTabAbstract(){
        super();
    }

    public abstract void checkExtraBarsCapsCard() throws InterruptedException;

    public abstract void checkManageBarsExtrasCTA();

    public abstract void checkLoginScreenAppear();

    public abstract void checkExtraAllowancesCard() throws InterruptedException;

    public abstract void checkExtraAllowancesCTADetails() throws InterruptedException;

    public abstract void navigateToExtras();

    public abstract void ExtrasCTA();

    public abstract void TapOnDataCapProduct();


    public abstract void checkAffiliateOrPromoDiscount();

    public abstract void ValidateManageControlsLimitsCopy();

    public abstract void ValidateRedirectionOfManageControlsLimits();


}

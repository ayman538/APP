package pages.SubsctionOverlay.NewPlanDesign;

public abstract class NewPlanPAYGCardsAbstract extends NewPlanDesignPO {

    public NewPlanPAYGCardsAbstract() {
        super();
    }

    public abstract void WVXIconCTAPlan();

    public abstract void ValidateNewPlanPageForPAYG();

    public abstract void assertPlanDetailsTextPAYG();

    public abstract void ValidateNewPlanPageOffersCardForBVB();

    public abstract void assertPlanDetailsOffersCardTextBVB();

    public abstract void ValidateNewPlanPageForPAYGCTA();

    public abstract void assertPlanPageCTAPAYG();

    public abstract void WVXIconCTATopUp();

    public abstract void ValidateNewPlanPageOffersCardCTAForBVB();

    public abstract void assertPlanDetailsOffersCardCTABVB();

    public abstract void ValidateNewPlanPageForPAYG1Content();

    public abstract void ValidateNewPlanPageForPAYG1CTAs();
}

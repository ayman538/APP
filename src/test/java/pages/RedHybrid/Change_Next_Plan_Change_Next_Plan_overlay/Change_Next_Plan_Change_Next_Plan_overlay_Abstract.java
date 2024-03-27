package pages.RedHybrid.Change_Next_Plan_Change_Next_Plan_overlay;

public abstract class Change_Next_Plan_Change_Next_Plan_overlay_Abstract extends Change_Next_Plan_Change_Next_Plan_overlay_PO{

    public Change_Next_Plan_Change_Next_Plan_overlay_Abstract(){
        super();
    }
    public abstract void changePlanCTAClick();
//    public abstract void clickChangeNextPlanCTA();
    public abstract void changeNextPlanOverlayAppears();
    public abstract void planItemSelection();
    public abstract void continueCTAIsDimmed();
    public abstract void screenUIValidation() throws InterruptedException;
    public abstract void checkUIWithPromoOrNoPromo();
    public abstract void clickOnPromosTermsApplyHyperLink();
    public abstract void ChangePlanOverlayDisplayed();
    public abstract void ChangePlanOverlayUIValidation();
    public abstract void ChoseChangePlanForNextMonthCardAndClickContinueCTA();
    public abstract void ChoseRenewPlanEarlyCardAndClickContinueCTA();
}

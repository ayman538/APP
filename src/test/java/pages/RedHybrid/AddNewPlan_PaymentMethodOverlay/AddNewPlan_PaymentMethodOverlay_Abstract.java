package pages.RedHybrid.AddNewPlan_PaymentMethodOverlay;

public abstract class AddNewPlan_PaymentMethodOverlay_Abstract extends AddNewPlan_PaymentMethodOverlay_PO{
    public AddNewPlan_PaymentMethodOverlay_Abstract (){
        super();
    }
    public abstract void paymentMethodOverlayAppears();
    public abstract void paymentMethodOverlayAppears(String paymentMethodOverlay_Title);
    public abstract void checkTheUIOfCellWithPromotedPlan();
    public abstract void checkTheUIOfCellWithNopromotedPlans();
    public abstract void clickOnPromosTermsApplyLink();
    public abstract void promosTermsScreen();

}

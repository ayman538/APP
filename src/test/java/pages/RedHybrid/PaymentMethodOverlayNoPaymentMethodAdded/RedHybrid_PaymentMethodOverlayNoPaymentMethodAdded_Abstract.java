package pages.RedHybrid.PaymentMethodOverlayNoPaymentMethodAdded;


public abstract class RedHybrid_PaymentMethodOverlayNoPaymentMethodAdded_Abstract extends RedHybrid_PaymentMethodOverlayNoPaymentMethodAdded_PO {
    public RedHybrid_PaymentMethodOverlayNoPaymentMethodAdded_Abstract(){
        super();
    }
    public abstract void redHybridUserOnDashboard();
    public abstract void noPlanAddedValidation();
    public abstract void addNewPlan();
    public abstract void planChoosed();
    public abstract void clickContinueInAddNewPlanScreen();
    public abstract void callBeginCardPaymentAPI();
    public abstract void noPaymentMethodIsVisible();
    public abstract void noPaymentMethodOverlayUIValidation();
    public abstract void beginCardPaymentAPIresponseCheck();
}

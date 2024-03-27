package pages.RedHybrid.WelcomeFlow;

public abstract class RedHybrid_WelcomeFlowLogic_Abstract extends RedHybrid_WelcomeFlowPO{

    public RedHybrid_WelcomeFlowLogic_Abstract(){
        super();
    }

    public abstract void redHybridWelcomeFlow();
    public abstract void validateWelcomeScreenContent();
    public abstract void validatePrivacyScreenContent();
    public abstract void validatePrivacyScreenFunctionality();
    public abstract void validatePermissionsScreenContent();
}
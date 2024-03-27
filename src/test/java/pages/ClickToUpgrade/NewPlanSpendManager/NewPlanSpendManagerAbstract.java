package pages.ClickToUpgrade.NewPlanSpendManager;

public abstract class NewPlanSpendManagerAbstract extends NewPlanSpendManagerPO{
    public NewPlanSpendManagerAbstract(){
        super();
    }

    public abstract void VerifyTheTitle();
    public abstract void VerifyTheDescriptiveTextExist();
    public abstract void VerifyThePriceLabelIsCorrect();
    public abstract void VerifyThePlanPriceExist();
    public abstract void VerifyThePlanPriceCyclePerMonth();
    public abstract void VerifyTheSpendLimitLabelExist();
    public abstract void ValidateTheDefaultValueForSpendLimitMenu();
    public abstract void VerifyTheGreenBoxAppearsWithCheckmarkAfterSelectingTheValue();
    public abstract void scrollToSpendManager();
//    public abstract void ValidateTheSpendManagerDetails();

}

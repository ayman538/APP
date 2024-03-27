package pages.SubsctionOverlay.UsagesTab;

public abstract class UsagesTabAbstract extends UsagesPO{

    public UsagesTabAbstract(){
        super();
    }

    public abstract void navigateToUsages();

    public abstract void checkPlanCardinUsage();

    public abstract void checkViewPlanCTAinUsageTab();

    public abstract void checkAddExtraCTAinUsageTab();

    public abstract void checkCroExperience();

    public abstract void validateExperienceFunctionality();

    public abstract void clickOnDataTile();

    public abstract void validateUsageTabIsOpened();

    public abstract void validateManageExtrasCapsAndBarsCTAExistence();

    public abstract void ValidateExtrasCTA();

    public abstract void validateSMBTilesNavigation();

    public abstract void iShouldSeeTilesTitle();

    public abstract void iShouldSeeTheTileListAndValidateTheirFunctionality();
}

package pages.Dashboard.ControlTiles;

public abstract class ControlTilesAbstract extends ControlTilesPO{

    public ControlTilesAbstract() {
        super();
    }


    public abstract void SetBeforeClass();

    public abstract void ValidatePrimaryControlTileText();

    public abstract void waitDashboardLoading();

    /*
    public abstract void assertFirstControlTileTitleTextRestOfUsers();

    public abstract void assertFirstControlTileTitleTextBINGO();

    public abstract void assertFirstControlTileTitleTextPAYGBVB();

    public abstract void assertFirstControlTileTitleTextPAYG1();

    public abstract void assertFirstControlTileTitleTextPAYGSimply();

     */

    public abstract void ValidateSecondaryControlTileText();
    /*

    public abstract void assertSecondControlTileTitleTextRestOfUsers();

    public abstract void assertSecondControlTileTitleTextPAYG1AndPAYGSimply();

    public abstract void assertSecondControlTileTitleTextRED();

        public abstract void ClickOnControlTileCTA() throws InterruptedException;

     */

    public abstract void ValidatePrimaryControlTileCTA();



    public abstract void SOXIconCTA();

    public abstract void assertPlanTabDisplayed();

    public abstract void firstControlTileCTA();

    public abstract void ValidateSecondaryControlTileCTA();

    /*

    public abstract void assertExtrasDisplayedAfterSecondControlTileCTA();

    public abstract void assertGroupDataDisplayedAfterFirstControlTileCTA();

     */

    public abstract void secondControlTileCTA();
    public abstract void VerifyYourPlanTile();
    public abstract void ValidateTilesForBingoUser() ;
    public abstract void clickonDevicePlanTile();
    public abstract void validateDevicePlanSuboverlayScreen();
    public abstract void ClickOnNudgeXIcon();
    public abstract void ClickOnUpgradeNowCTA();
    public abstract void ValidateCroExperience();

    public abstract void clickonManageControlsAndExtrasTile();

    public abstract void ExtrasTab();
}

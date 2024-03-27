package pages.OnePlatform_SpeedCheckerHistory;

public abstract class SpeedCheckerHistoryAbstractLogic extends SpeedCheckerHistoryPO {

    public SpeedCheckerHistoryAbstractLogic() {
        super();
    }

    public abstract void clickOnCheckDataAndWiFiSpeed();

    public abstract void ValidateNospeedResultCardIsDisplayed();

    public abstract void ValidateSpeedHistoryScreenIsDisplayed();

    public abstract void ClickOnDeletePreviousTestsCTA();

    public abstract void ValiateDeleteOverlay();

    public abstract void ClickOnCancelCTAOnDeletedOverlay();

    public abstract void ClickOnConfirmCTAOnDeletedOverlay();
    public abstract void ClickOnSpeedHistoryTab();
    public abstract void ClickOnStartTest();

    public abstract void ValidateThatTestDoneSuccessfully();

    public abstract void StartTestAndValidateSpeedHistoryScreenIsDisplayed();
    public abstract void CheckToMakeSureThatThereIsNoSpeedTestHistory();


}





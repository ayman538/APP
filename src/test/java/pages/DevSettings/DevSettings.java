package pages.DevSettings;

public abstract class DevSettings extends DevSettingsPo {

    public DevSettings() {
        super();
    }

    public abstract void setDevSetting() throws InterruptedException;

    protected abstract void EnterMSISDN();

    protected abstract void SelectServer() throws InterruptedException;
    protected abstract void SelectReinventServer() throws InterruptedException;


    protected abstract void ConfigureWifiOr3GRun();

    protected abstract void enableStubbed();

    protected abstract void DisableSurveysPopUps();

    protected abstract void set3G();

    protected abstract void switchTheToggles();

    public abstract void resetAppForIOS();

    public abstract void goToTestJourneyPage();

    protected abstract void SelectEcareServer()throws InterruptedException;

    public abstract void EnableAdobeTargetToggle();

    public abstract void SaveandRestart();
}
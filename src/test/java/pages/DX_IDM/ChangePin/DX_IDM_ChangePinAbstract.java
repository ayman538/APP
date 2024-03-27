package pages.DX_IDM.ChangePin;

public abstract class DX_IDM_ChangePinAbstract extends DX_IDM_ChangePinPO{


    public DX_IDM_ChangePinAbstract()  {
        super();

    }

    public abstract void hardClose() ;

    public abstract void AccountSettingsScreenIsDisplayed() ;

    public abstract void ValidateChangePinOptionIsDisplayed() ;

    public abstract void ChangePinIsDisplayedInAccountSettings();

    public abstract void ValidateEnterPinScreenIsDisplayed() ;

    public abstract void EnterPinScreenIsDisplayed();

    public abstract void ClickOnXiconOnEnterPinScreen() ;

    public abstract void ValidateEnterPinScreenFourFields() ;

    public abstract void tapOnNextCTA();

    public abstract void ValidateThanksForVerifyingScreen() throws InterruptedException ;

    public abstract void ReEnterPinScreenIsDisplayed() ;
    public abstract void EnterPinFields();//

    public abstract void PinSuccessfullyUpdatedScreenIsDisplayed() ;

    public abstract void ValidatePinSuccessfullyUpdatedScreenFourFields() ;


}

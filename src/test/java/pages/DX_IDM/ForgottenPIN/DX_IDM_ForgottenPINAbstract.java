package pages.DX_IDM.ForgottenPIN;


public abstract class DX_IDM_ForgottenPINAbstract extends DX_IDM_ForgottenPIN_PO {
    public DX_IDM_ForgottenPINAbstract(){ super();}

    public abstract void ClickOnMyAccountForForgottenPIN() throws InterruptedException;

    public abstract void ClickOnForgottenPINCTA();

    public abstract void EnterPasswordForForgottenPIN() throws InterruptedException;

    public abstract void EnterAndConfirmNewPIN(String PIN);

    public abstract void ClickOkDone();

    public abstract void CheckMyAccountOpenSuccessfully();

    public abstract void EnterPIN(String PIN);

    public abstract void ConfirmPIN(String PIN);

    public abstract void ClickBackCTA();

    public abstract void checkPINExistsAfterBackCTA();

    public abstract void checkPINErrorAppears();
}

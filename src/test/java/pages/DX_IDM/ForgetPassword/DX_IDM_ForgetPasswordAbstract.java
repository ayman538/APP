package pages.DX_IDM.ForgetPassword;


public abstract class DX_IDM_ForgetPasswordAbstract extends DX_IDM_ForgetPasswordPO {


    public DX_IDM_ForgetPasswordAbstract() {
        super();
    }

    public abstract void softLoginForForgetPass();

    public abstract void clickMyAccount();

    public abstract void enterUsernameForForgetPass() throws InterruptedException ;

    public abstract void clickForgetPassCTA();

    public abstract void addUsernameForForgetPass();

    public abstract void clickResetPass();

    public abstract void clickResetPassContinueCTA();

    public abstract void enterTempPass();

    public abstract void enterOTAC() throws InterruptedException;

    public abstract void enterNewPass();

    public abstract void checkLoginPrefScreen();

    public abstract void clickForgetPasswordCTA();
}

package pages.DX_IDM.ForgotUsername;

import pages.Commons.CommonPo;

public abstract class DXIDM_ForgotUsernameAbstract extends CommonPo {
    public DXIDM_ForgotUsernameAbstract() {
        super();
    }

    public abstract void ClickOnForgotUsername();

    public abstract void acceptCookies();

    public abstract void clickOnBack();

    public abstract void ValidateThanksForVerifyingScreen() throws InterruptedException;

    public abstract void ValidateUsernameIsAutoPopulated();

    public abstract void enterFirstAndSecondName();

    public abstract void ValidateExternalWebView();
}

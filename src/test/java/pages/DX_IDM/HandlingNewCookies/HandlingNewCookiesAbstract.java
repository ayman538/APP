package pages.DX_IDM.HandlingNewCookies;

import pages.Commons.CommonPo;

public abstract class HandlingNewCookiesAbstract extends CommonPo {

    public HandlingNewCookiesAbstract() {
        super();
    }

    public abstract void acceptCookies();

    public abstract void assertLoginUsernameIsDisplayed() ;

    public abstract void hardClose() ;
    public abstract void ValidatePasswordScreenContent() ;

    public abstract void clickOn_MyAccount() ;

    public abstract void ClickXButton();

    public abstract void navigateWelcomeScreen();
    public abstract void relogin();

    public abstract void clickOnLoginCTA();
}

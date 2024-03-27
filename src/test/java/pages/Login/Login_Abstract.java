package pages.Login;

import java.io.IOException;

public abstract class Login_Abstract extends LoginPO {

    public static boolean HasFaceID = false;

    public Login_Abstract() {
        super();
    }

    public abstract void LoginFlow() throws InterruptedException, IOException;

    public abstract void enterPin() throws InterruptedException ;

    public abstract void ReEnterPin() throws InterruptedException ;

/*
    public abstract static WebElement Login_username();

    public abstract static WebElement Login_Xicon() ;

    public abstract static WebElement Pin_Field();

    public abstract static WebElement Pin_ContinueCTA() ;

    public abstract static WebElement ForgottenUsername_Hyperlink() ;

    public abstract static WebElement ForgottenPassword_Hyperlink() ;

    public abstract static WebElement MemorableWordField() ;

    public abstract static WebElement ResetYourPasswordTitle() ;

    public abstract static WebElement EnterUsernameField() ;

    public abstract static WebElement ResetPasswordCTA();
    */

    public abstract void loginMyAccount() throws InterruptedException, IOException ;

    public abstract void LoginFlow(String pinValue1, String pinValue2, String pinValue3, String pinValue4) throws InterruptedException, IOException ;


    public abstract void loginOptions() throws InterruptedException, IOException ;


    public abstract void validateLoginSwipeDown() ;


}

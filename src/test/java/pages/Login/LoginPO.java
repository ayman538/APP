package pages.Login;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import pages.Commons.CommonPo;

public class LoginPO extends CommonPo {
    @AndroidFindBy(id= "com.myvodafoneapp:id/Login_LoginView_UsernameField_Text")
    @iOSXCUITFindBy(id= "Enter username")
    public WebElement Login_username;

    @AndroidFindBy(id= "com.myvodafoneapp:id/Login_LoginView_PasswordField_Text")
    @iOSXCUITFindBy(id= "Password")
    public WebElement Login_password;

    @AndroidFindBy(id= "com.myvodafoneapp:id/Login_LoginView_Login_CTA")
    @iOSXCUITFindBy(id= "Login_LoginView_Login_CTA")
    public WebElement Login_CTA;

    @AndroidFindBy(id= "com.myvodafoneapp:id/Login_EnterPINView_Login_CTA")
    @iOSXCUITFindBy(id= "Login_SetupPINView_Continue_CTA")
    public WebElement Pin_ContinueCTA;

    @AndroidFindBy(xpath= "(//*[@resource-id='" + "com.myvodafoneapp:id/Login_EnterPINView_BOX1_TextField'])[2]")
    @iOSXCUITFindBy(id= "Login_SetupPINReEnterView_PINTextFieldsContainer")
    public WebElement Pin_ReEnterField1;

    @AndroidFindBy(xpath= "(//*[@resource-id='" + "com.myvodafoneapp:id/Login_EnterPINView_BOX2_TextField'])[2]")
    @iOSXCUITFindBy(id= "Login_SetupPINReEnterView_PINTextFieldsContainer")
    public WebElement Pin_ReEnterField2;

    @AndroidFindBy(xpath= "(//*[@resource-id='" + "com.myvodafoneapp:id/Login_EnterPINView_BOX3_TextField'])[2]")
    @iOSXCUITFindBy(id= "Login_SetupPINReEnterView_PINTextFieldsContainer")
    public WebElement Pin_ReEnterField3;

    @AndroidFindBy(xpath= "(//*[@resource-id='" + "com.myvodafoneapp:id/Login_EnterPINView_BOX4_TextField'])[2]")
    @iOSXCUITFindBy(id= "Login_SetupPINReEnterView_PINTextFieldsContainer")
    public WebElement Pin_ReEnterField4;

    @AndroidFindBy(xpath= "(//*[@resource-id='" + "com.myvodafoneapp:id/Login_EnterPINView_Login_CTA'])[2]")
    @iOSXCUITFindBy(id= "Login_SetupPINReEnterView_Continue_CTA")
    public WebElement Pin_ContinueCTA2;

    @AndroidFindBy(id= "com.myvodafoneapp:id/buttonEnableTouchId")
    @iOSXCUITFindBy(id= "Enable Face ID")
    public WebElement EnableTouchID_CTA;

    @AndroidFindBy(id= "com.myvodafoneapp:id/btnConfirm")
    @iOSXCUITFindBy(id= "btnLoginSuccessOKAllDoneCTA")
    public WebElement SuccessfullLogin_DoneCTA;

    @AndroidFindBy(xpath= "//*[@text='Set up your PIN']")
    @iOSXCUITFindBy(id= "My Account")
    public WebElement setUpYourPin_CTA;

    public LoginPO() {
        super();
    }
}

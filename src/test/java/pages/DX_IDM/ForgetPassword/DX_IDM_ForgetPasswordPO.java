package pages.DX_IDM.ForgetPassword;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.Commons.CommonPo;

public class DX_IDM_ForgetPasswordPO extends CommonPo {

    public DX_IDM_ForgetPasswordPO() {
        super();
    }


    @AndroidFindBy(xpath = "//*[@text='Forgotten username?']")
    @iOSXCUITFindBy(xpath = "//*[@label='Forgotten username?']")
    public WebElement DX_IDM_ForgotUsername;

    @iOSXCUITFindBy(xpath = "//*[@label='Forgotten password?']")
    @AndroidFindBy(xpath = "//*[@text='Forgotten password?']")
    public WebElement DX_IDM_ForgotPassword;

    @AndroidFindBy(id= "com.myvodafoneapp:id/Login_ResetPasswordView_ResetPassword_CTA")
    public WebElement DX_IDM_ResetPasswordCTA;

    @AndroidFindBy(id= "com.myvodafoneapp:id/Login_ResetPasswordView_EnterPIN_TextField")
    public WebElement DX_IDM_ResetPasswordUsernameTxtField;

    @AndroidFindBy(id= "com.myvodafoneapp:id/Login_ResetPasswordView_Close_CTA")
    public WebElement DX_IDM_ResetPasswordContinueCTA;


    @AndroidFindBy(xpath = "//*[@text='Update your password']")
    public WebElement DX_IDM_ResetPasswordUpdatePassTitle;

    @AndroidFindBy(xpath = "//*[@resource-id='new_password']")
    public WebElement DX_IDM_ResetPasswordNewPassTxtField;

    @AndroidFindBy(xpath = "//*[@resource-id='new_password_confirm']")
    public WebElement DX_IDM_ResetPasswordConfirmPassTxtField;

    @AndroidFindBy(xpath = "//*[@text='Continue']")
    public WebElement DX_IDM_ResetPasswordUpdatePassContinueCTA;

}
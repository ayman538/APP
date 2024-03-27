package pages.DX_IDM.FullLogin;


import io.appium.java_client.pagefactory.*;
import org.openqa.selenium.WebElement;
import pages.Commons.CommonPo;

public class DX_IDM_FullLoginPO extends CommonPo {
    @AndroidFindAll({
            @AndroidBy(id = "com.myvodafoneapp:id/DXIDLogin_Button"),
            @AndroidBy(xpath = "//*[@text='Log in']")
    })
    @iOSXCUITFindAll({
            @iOSXCUITBy(xpath = "//*[@label='Log In']"),
            @iOSXCUITBy(xpath = "//*[@label='Log in']")
    })
    public WebElement DX_IDM_LoginCTA;

    @AndroidFindBy(id = "//*[@resource-id='root']/android.widget.Button")
    @iOSXCUITFindBy(id = "txtAcquisitionNewDBTile_Pay monthly phones")
    public WebElement DX_IDM_UsernameInPasswordScreen;

    @AndroidFindBy(xpath = "//*[@text='Forgotten username?']")
    @iOSXCUITFindAll({
            @iOSXCUITBy(xpath = "//*[@label='Forgotten username?']"),
            @iOSXCUITBy(id = "Forgotten username?"),
            @iOSXCUITBy(id = "Forgotten username?")
    })
    public WebElement DX_IDM_ForgotUsername;

    @AndroidFindBy(xpath = "//*[@text='Register for My Vodafone']")
    @iOSXCUITFindBy(xpath = "//*[@label='Register for My Vodafone']")
    public WebElement DX_IDM_CreateAccountLink;

    @AndroidFindBy(xpath = "//*[@text='Not registered?']")
    @iOSXCUITFindBy(xpath = "//*[@label='Not registered?']")
    public WebElement DX_IDM_RegisterLink;

    @AndroidFindBy(xpath = "//*[@text='Forgotten password?']")
    @iOSXCUITFindBy(xpath = "//*[@label='Forgotten password?']")
    public WebElement DX_IDM_ForgotPassword;

    @AndroidFindBy(xpath = "//*[@text='Show password']")
    @iOSXCUITFindBy(xpath = "//*[@label='Show password']")
    public WebElement DX_IDM_ShowPassword;

    @AndroidFindBy(id = "com.myvodafoneapp:id/tvSuccessHeader")
    @iOSXCUITFindBy(id = "Login successful")
    public WebElement DX_IDM_LoginPreferencesTitle;

    @AndroidFindBy(xpath = "//*[@text='Biometrics']")
    @iOSXCUITFindAll({
            @iOSXCUITBy(xpath = "//*[@label='Biometrics']"),
            @iOSXCUITBy(xpath = "//*[@label='Face ID']")
    })
    public WebElement DX_IDM_LogPrefBiometrics;

    @AndroidFindBy(id = "login_prompt_text")
    public WebElement DX_IDM_LogPrefBiometricsPrompt;

    @AndroidFindBy(id = "com.myvodafoneapp:id/closeImg")
    public WebElement DX_IDM_XCTA;

    @AndroidFindBy(xpath = "//*[@text='Log in']")
    @iOSXCUITFindBy(id = "Log in")
    public WebElement DX_IDM_PasswordLoginCTA;

    @AndroidFindBy(xpath = "//*[@text='Enter your PIN']")
    @iOSXCUITFindBy(xpath = "//*[@label='Enter your PIN']")
    public WebElement DX_IDM_PINScreenAfterLogin;

    @AndroidFindBy(xpath = "(//*[@class='android.widget.EditText'])[1]")
    @iOSXCUITFindBy(id = "Login_SetupPINReEnterView_PINTextFieldsContainer")
    public WebElement DX_IDM_PINEditTxt;

    @AndroidFindBy(xpath = "(//*[@class='android.widget.EditText'])[2]")
    @iOSXCUITFindBy(id = "Login_SetupPINReEnterView_PINTextFieldsContainer")
    public WebElement DX_IDM_PINEditTxt1;

    @AndroidFindBy(xpath = "(//*[@class='android.widget.EditText'])[3]")
    @iOSXCUITFindBy(id = "Login_SetupPINReEnterView_PINTextFieldsContainer")
    public WebElement DX_IDM_PINEditTxt2;

    @AndroidFindBy(xpath = "(//*[@class='android.widget.EditText'])[4]")
    @iOSXCUITFindBy(id = "Login_SetupPINReEnterView_PINTextFieldsContainer")
    public WebElement DX_IDM_PINEditTx3;

    @AndroidFindBy(xpath = "//*[@text='My account']")
    public WebElement DX_IDM_MyAccountTrayTitle;

    @AndroidFindBy(xpath= "//*[@text='OK']")
    @iOSXCUITFindBy(xpath= "//*[@label='OK']")
    public WebElement DX_IDM_OKCTA;

    @AndroidFindBy(xpath= "//*[@text='My Vodafone']")
    @iOSXCUITFindBy(xpath= "//*[@label='My Vodafone']")
    public WebElement DX_IDM_BlockedScreenTitle;

    @AndroidFindBy(id= "com.myvodafoneapp:id/messageTextView")
    @iOSXCUITFindAll({
            @iOSXCUITBy(xpath= "//*[contains(@label'The incorrect login details')]"),
            @iOSXCUITBy(xpath= "//*[@label='Continue']"),
            @iOSXCUITBy(xpath= "//*[@label='Back']")
    })
    public WebElement DX_IDM_BlockedScreenMessage;

    @AndroidFindBy(xpath= "//*[@text='Reset password']")
    @iOSXCUITFindBy(xpath= "//*[@label='Reset password']")
    public WebElement DX_IDM_BlockedScreenResetPasswordCTA;

    @AndroidFindBy(xpath= "//*[@text='Close']")
    @iOSXCUITFindBy(xpath= "//*[@label='Close']")
    public WebElement DX_IDM_BlockedScreenCloseCTA;

    @AndroidFindBy(xpath= "//*[@text='There has been an issue validating your PIN. Please enter the details again.']")
    @iOSXCUITFindBy(id= "txtLoginOptionTitle")
    public WebElement DX_IDM_MessageInvalidPIN;

    @AndroidBy(xpath= "//*[@text='Reset your password']")
    @iOSXCUITFindBy(xpath= "//*[@label='Reset your password']")
    public WebElement DX_IDM_ResetPasswordTitle;


    @AndroidFindBy(xpath= "//*[@text='We’ve locked your account to protect your security']")
    @iOSXCUITFindBy(xpath= "//*[@label='We’ve locked your account to protect your security']")

    public WebElement DX_IDM_LockedTitle;

    @AndroidFindBy(xpath= "//*[contains(@text'Your login')]")
    @iOSXCUITFindBy(id="Your login details were entered incorrectly more than five times so we’ve temporarily locked your account. To unlock your account please")
    public WebElement DX_IDM_LockedBody;

    @AndroidFindBy(xpath= "//*[@text='reset your password']")
    @iOSXCUITFindBy(xpath= "//*[@label='reset your password']")
    public WebElement DX_IDM_ResetLinkInLockedScreen;


    @AndroidFindBy(xpath= "//*[@resource-id='onetrust-accept-btn-handler']")
    @iOSXCUITFindBy(id= "Accept all cookies")
    public WebElement DX_IDM_AcceptCookiesCTA;

    public DX_IDM_FullLoginPO() {
        super();
    }
}

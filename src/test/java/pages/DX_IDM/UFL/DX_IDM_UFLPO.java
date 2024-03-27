package pages.DX_IDM.UFL;


import io.appium.java_client.pagefactory.*;
import org.openqa.selenium.WebElement;
import pages.Commons.CommonPo;

public class DX_IDM_UFLPO extends CommonPo {

    public DX_IDM_UFLPO() {
        super();
    }
    
    @AndroidFindBy(id= "com.myvodafoneapp:id/wifiStatusLay")
    public WebElement DX_IDM_DisconnectWiFi;
    
    @AndroidFindBy(id= "com.myvodafoneapp:id/DXIDMDisconnectWifi_CloseIcon")
    public WebElement DX_IDM_DisconnectWiFiCloseCTA;

    @AndroidFindAll({
            @AndroidBy(xpath= "//*[@text='Log in']"),
            @AndroidBy(xpath= "//*[@text='Log In']")
    })
    @iOSXCUITFindAll({
            @iOSXCUITBy(xpath= "//*[@name='Log in']"),
            @iOSXCUITBy(xpath= "//*[@name='Log In']")
    })
    public WebElement DX_IDM_LoginCTA;

    @iOSXCUITFindBy(xpath= "//*[@label='Log in']")
    @AndroidFindBy(xpath= "//*[@text='Log in']")
    public WebElement DX_IDM_Password_LoginCTA;

    @iOSXCUITFindBy(xpath= "//*[@type='XCUIElementTypeTextField']")
    @AndroidFindAll({
            @AndroidBy(xpath= "//*[@resource-id='user']"),
            @AndroidBy(xpath= "//*[@resource-id='username-or-phone-number-field']")
    })
    public WebElement DX_IDM_Username;

    @AndroidFindBy(xpath= "//*[@text='Log in']")
    @AndroidFindBy(xpath= "//*[@text='Log In']")
    public WebElement DX_IDM_Login_Android;

    @iOSXCUITFindBy(xpath= "//*[@name='Log in']")
    @iOSXCUITFindBy(xpath= "//*[@name='Log In']")
    public WebElement DX_IDM_Login_IOS;

    @AndroidFindBy(xpath= "//*[@text='Forgotten username?']")
    @iOSXCUITFindBy(xpath= "//*[@label='Forgotten username?']")
    public WebElement DX_IDM_ForgotUsername;

    @AndroidFindBy(xpath= "//*[@text='Not registered?']")
    @iOSXCUITFindBy(xpath= "//*[@label='Not registered?']")
    public WebElement DX_IDM_RegisterLink;

    @AndroidFindBy(xpath= "//*[@text='Register for My Vodafone']")
    @iOSXCUITFindBy(xpath= "//*[@label='Register for My Vodafone']")
    public WebElement DX_IDM_CreateAccountLink;

    @iOSXCUITFindBy(xpath= "//*[@name='Continue']")
    @AndroidFindBy(xpath= "//*[@resource-id='submit-button']")
    public WebElement DX_IDM_ContinueCTA;

    @AndroidFindBy(xpath= "//*[@resource-id='pass']")
    @iOSXCUITFindAll({
            @iOSXCUITBy(id= "pass"),
            @iOSXCUITBy(xpath= "//*[@type='XCUIElementTypeSecureTextField']")
    })
    public WebElement DX_IDM_Password;

    @iOSXCUITFindBy(xpath= "//*[@label='Request security code']")
    @AndroidFindBy(xpath= "//*[@text='Request security code']")
    public WebElement DX_IDM_RequestSecurityTitle;

    @iOSXCUITFindBy(xpath= "//*[@label='For added security we’ll text a code to one of your phones.']")
    @AndroidFindBy(xpath= "//*[@text='For added security we’ll text a code to one of your phones.']")
    public WebElement DX_IDM_RequestSecuritySubTitle;

    @iOSXCUITFindBy(xpath= "//*[@value ='Choose a phone from the list']")
    @AndroidFindBy(xpath= "//*[@resource-id='choosePhone']")
    public WebElement DX_IDM_SelectSecurityAccount;

    @iOSXCUITFindBy(xpath= "//*[@label='Enter security code']")
    @AndroidFindBy(xpath= "//android.widget.TextView[@text='Enter code']")
    public WebElement DX_IDM_EnterSecurityCodeTitle;

    @iOSXCUITFindBy(xpath= "(//*[@type= 'XCUIElementTypeSecureTextField'])[1]")
    @AndroidFindBy(xpath= "(//*[@class='android.widget.EditText'])[1]")
    public WebElement DX_IDM_EnterSecurityCodeField1;

    @AndroidFindBy(xpath= "(//*[@class='android.widget.EditText'])[2]")
    @iOSXCUITFindBy(xpath= "(//*[@type= 'XCUIElementTypeSecureTextField'])[2]")
    public WebElement DX_IDM_EnterSecurityCodeField2;

    @AndroidFindBy(xpath= "(//*[@class='android.widget.EditText'])[3]")
    @iOSXCUITFindBy(xpath= "(//*[@type= 'XCUIElementTypeSecureTextField'])[3]")
    public WebElement DX_IDM_EnterSecurityCodeField3;

    @AndroidFindBy(xpath= "(//*[@class='android.widget.EditText'])[4]")
    @iOSXCUITFindBy(xpath= "(//*[@type= 'XCUIElementTypeSecureTextField'])[4]")
    public WebElement DX_IDM_EnterSecurityCodeField4;

    @AndroidFindBy(xpath= "(//*[@class='android.widget.EditText'])[5]")
    @iOSXCUITFindBy(xpath= "(//*[@type= 'XCUIElementTypeSecureTextField'])[5]")
    public WebElement DX_IDM_EnterSecurityCodeField5;

    @iOSXCUITFindBy(xpath= "//*[@name='Choose plan']")
    @AndroidFindBy(xpath= "//*[@text='Choose plan']")
    public WebElement DX_IDM_ChoosePlanTitle;

    @AndroidFindBy(xpath= "//*[@text='This will be set as your default when using the My Vodafone App']")
    @iOSXCUITFindBy(xpath= "//*[@label='This will be set as your default when using the My Vodafone App']")
    public WebElement DX_IDM_ChoosePlanSubTitle;

    @AndroidFindBy(id= "com.myvodafoneapp:id/tvSuccessHeader")
    @iOSXCUITFindBy(id= "action_0")
    public WebElement DX_IDM_LoginPreferencesTitle;

    @AndroidFindBy(id= "com.myvodafoneapp:id/tvSuccessDesc")
    @iOSXCUITFindBy(id= "action_0")
    public WebElement DX_IDM_LoginPreferencesSubTitle;

    @AndroidFindBy(id= "com.myvodafoneapp:id/btnConfirm")
    @iOSXCUITFindBy(id= "action_0")
    public WebElement DX_IDM_LoginPreferencesOkCTA;

    @AndroidFindBy(xpath= "//*[@text='You can manage your Login details in the app settings.']")
    @iOSXCUITFindBy(id= "action_0")
    public WebElement DX_IDM_LoginPreferencesFooter;

    @AndroidFindBy(id= "com.myvodafoneapp:id/txtDXIDMFTL_HeaderTitle")
    @iOSXCUITFindBy(id= ":id/txtDXIDMFTL_HeaderTitle")
    public WebElement DX_IDM_X_LoginToMyVodafoneScreen;

    @AndroidFindBy(xpath= "//*[@text='Chat to us']")
    @iOSXCUITFindBy(xpath= "//*[@label='Chat to us']")
    public WebElement DX_IDM_ChatToUs;

    @iOSXCUITFindBy(xpath= "//*[@label='Choose account']")
    @AndroidFindBy(xpath= "//*[@text='Choose account']")
    public WebElement DX_IDM_ChooseAccountTitle;

}
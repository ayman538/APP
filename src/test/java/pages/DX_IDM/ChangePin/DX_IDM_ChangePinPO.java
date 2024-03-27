package pages.DX_IDM.ChangePin;


import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.Commons.CommonPo;

public class DX_IDM_ChangePinPO extends CommonPo {


    @AndroidFindBy(id = "com.myvodafoneapp:id/Login_EnterPINView_BOX1_TextField")
    @iOSXCUITFindBy(id = "Login_SetupPINView_PINTextFieldsContainer")
    protected static WebElement Pin_Field;

    @AndroidFindBy(xpath= "//*[@text='Change my PIN']")
    @iOSXCUITFindBy(xpath= "//*[@label='Change my PIN']")
    public WebElement AccountSetting_ChangePin;

    @AndroidFindBy(id = "com.myvodafoneapp:id/pin_view_title_Label")
    @iOSXCUITFindBy(id = "Re-enter your new PIN")
    public WebElement DX_IDM_EnterPinTitle;

    @AndroidFindBy(id = "com.myvodafoneapp:id/pin_View_subtitle_Label")
    @iOSXCUITFindBy(id = "Login_SetupPINReEnterView_Description")
    public WebElement DX_IDM_EnterPinSubTitle;

    @AndroidFindBy(id = "com.myvodafoneapp:id/pin_View_Description_Label")
    @iOSXCUITFindBy(id = "Login_SetupPINView_Description_Label")
    public WebElement DX_IDM_EnterPinBody;

    @AndroidFindBy(id = "com.myvodafoneapp:id/Login_EnterPINView_BOX1_TextField")
    @iOSXCUITFindBy(id = "PIN_BOX1_TextField")
    public WebElement DX_IDM_PinField1;

    @AndroidFindBy(id = "com.myvodafoneapp:id/Login_EnterPINView_BOX2_TextField")
    @iOSXCUITFindBy(id = "PIN_BOX2_TextField")
    public WebElement DX_IDM_PinField2;

    @AndroidFindBy(id = "com.myvodafoneapp:id/Login_EnterPINView_BOX3_TextField")
    @iOSXCUITFindBy(id = "PIN_BOX3_TextField")
    public WebElement DX_IDM_PinField3;

    @AndroidFindBy(id = "com.myvodafoneapp:id/Login_EnterPINView_BOX4_TextField")
    @iOSXCUITFindBy(id = "PIN_BOX4_TextField")
    public WebElement DX_IDM_PinField4;

    @AndroidFindBy(id = "com.myvodafoneapp:id/tv_repeated_text")
    @iOSXCUITFindBy(id = "Welcome_to_My_Vodafone_Title")
    public WebElement DX_IDM_EnterPinFooter1;

    @AndroidFindBy(id = "com.myvodafoneapp:id/tv_consecutive_text")
    @iOSXCUITFindBy(id = "Welcome_to_My_Vodafone_Title")
    public WebElement DX_IDM_EnterPinFooter2;

    @AndroidFindBy(id = "com.myvodafoneapp:id/ForgetUserName_pin_Next_CTA")
    @iOSXCUITFindBy(xpath= "//XCUIElementTypeButton[@name='Next']")
    public WebElement DX_IDM_PinNextCTA;

    @AndroidFindBy(id = "com.myvodafoneapp:id/confirm_pin_back")
    @iOSXCUITFindBy(id = "Back")
    public WebElement DX_IDM_PinBackCTA;

    @AndroidFindBy(id = "com.myvodafoneapp:id/idmSuccessBtn")
    @iOSXCUITFindBy(id = "Welcome_to_My_Vodafone_Title")
    public WebElement DX_IDM_PinXicon; //to be define later

    @AndroidFindBy(id = "com.myvodafoneapp:id/idmSuccessBtn")
    @iOSXCUITFindBy(id = "OK all done")
    public WebElement DX_IDM_PinOkDoneCTA;

    @AndroidFindBy(id = "com.myvodafoneapp:id/imageView6")
    @iOSXCUITFindBy(id = "LoginSuccess")
    public WebElement DX_IDM_PinSuccessfullyIcon;

    @AndroidFindBy(id = "com.myvodafoneapp:id/tvSuccessMessage")
    @iOSXCUITFindBy(id = "Your PIN was successfully updated")
    public WebElement DX_IDM_PinSuccessfullyTitle;

    @AndroidFindBy(id = "com.myvodafoneapp:id/textView6")
    @iOSXCUITFindBy(id = "Remember to keep your PIN safe and don't let anyone else know what it is.")
    public WebElement DX_IDM_PinSuccessfullyBody;

    @AndroidFindBy(id = "com.myvodafoneapp:id/rhombus_title")
    @iOSXCUITFindBy(id = "Welcome_to_My_Vodafone_Title")
    public WebElement DX_IDM_ThanksForVerify;

    @AndroidFindBy(id = "com.myvodafoneapp:id/btn_login")
    @iOSXCUITFindBy(id = "Welcome_to_My_Vodafone_Title")
    public WebElement DX_IDM_BtnLoginCTAThanksForVerify;

    public DX_IDM_ChangePinPO() {
        super();
    }
}

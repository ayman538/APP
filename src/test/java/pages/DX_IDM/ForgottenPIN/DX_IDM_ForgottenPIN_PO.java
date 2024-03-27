package pages.DX_IDM.ForgottenPIN;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.Commons.CommonPo;

public class DX_IDM_ForgottenPIN_PO extends CommonPo {

    public DX_IDM_ForgottenPIN_PO() {
        super();
    }

    @AndroidFindBy(id = "com.myvodafoneapp:id/forgotPinTextView")
    @iOSXCUITFindBy(xpath = "//*[@type='XCUIElementTypeButton' and @name='Forgotten your PIN?']")
    public WebElement DX_IDM_ForgotYourPIN_Link;

    @AndroidFindBy(id = "com.myvodafoneapp:id/change_pin_continue")
    @iOSXCUITFindBy(id = "Login_SetupPINView_Continue_CTA")
    public WebElement ContinueCTAAfterEnteringPIN;

    @AndroidFindBy(id = "com.myvodafoneapp:id/loginPinContinueButton")
    @iOSXCUITFindBy(xpath = "//*[@name='Login_SetupPINReEnterView_Continue_CTA'][1]")
    public WebElement LoginWithPINContinueCTA;

    @AndroidFindBy(xpath = "//*[@resource-id='com.myvodafoneapp:id/confirm_pin_continue']")
    @iOSXCUITFindBy(xpath = "//*[@name='Login_SetupPINReEnterView_Continue_CTA' and @label='Continue']")
    public WebElement ContinueCTAAfterConfirmPIN;

    @AndroidFindBy(xpath = "(//*[@resource-id='com.myvodafoneapp:id/pinEditText'])[1]")
    @iOSXCUITFindBy(id = "Login_SetupPINView_PINTextFieldsContainer")
    @iOSXCUITFindBy(id = "Login_SetupPINReEnterView_PINTextFieldsContainer")
    public WebElement PIN1;

    @AndroidFindBy(xpath = "(//*[@resource-id='com.myvodafoneapp:id/pinEditText'])[2]")
    public WebElement PIN2;

    @AndroidFindBy(xpath = "(//*[@resource-id='com.myvodafoneapp:id/pinEditText'])[3]")
    public WebElement PIN3;

    @AndroidFindBy(xpath = "(//*[@resource-id='com.myvodafoneapp:id/pinEditText'])[4]")
    public WebElement PIN4;

    @AndroidFindBy(id = "idmSuccessBtn")
    @iOSXCUITFindBy(id = "OK all done")
    public WebElement OKAllDoneCTA;

    @AndroidFindBy(id = "confirm_pin_back")
    @iOSXCUITFindBy(xpath = "//*[@name='Login_SetupPINReEnterView_Continue_CTA' and @label='Back']")
    public WebElement BackCTAAfterEnteringPIN;

    @AndroidFindBy(id = "error_pin")
    @iOSXCUITFindBy(id = "PINs do not match")
    public WebElement ErrorPINMismatch;
}

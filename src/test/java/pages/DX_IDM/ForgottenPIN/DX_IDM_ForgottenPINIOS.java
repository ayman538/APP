package pages.DX_IDM.ForgottenPIN;

import org.testng.Assert;

import java.util.Properties;

import static utilities.PropertiesLoader.readPropertyFile;
import static utils.element_helpers.VerifyHelpers.AssertDisplayed;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

public class DX_IDM_ForgottenPINIOS extends DX_IDM_ForgottenPINAbstract{

    public DX_IDM_ForgottenPINIOS(){super();}

    Properties envProp = readPropertyFile("config/env.properties");
    String password = System.getProperty("password",envProp.getProperty("password"));

    public void ClickOnMyAccountForForgottenPIN() throws InterruptedException {
        Thread.sleep(5000);
        waitForVisibility(DB_MyAccountTray_icon);
        DB_MyAccountTray_icon.click();
    }

    public void ClickOnForgottenPINCTA(){
        waitForVisibility(DX_IDM_ForgotYourPIN_Link);
        DX_IDM_ForgotYourPIN_Link.click();
    }

    public void EnterPasswordForForgottenPIN() throws InterruptedException {
        waitForVisibility(DX_IDM_PasswordField_ForgetPIN);
        DX_IDM_PasswordField_ForgetPIN.sendKeys(password);
        Thread.sleep(1000);
        DX_IDM_PasswordLoginCTA.click();
    }

    public void EnterAndConfirmNewPIN(String PIN){
        EnterPIN(PIN);
        ConfirmPIN(PIN);
    }

    public void EnterPIN(String PIN){
        waitForVisibility(PIN1);
        PIN1.sendKeys(PIN);
        try {
            ContinueCTAAfterEnteringPIN.click();
        }
        catch (Exception e)
        {
            LoginWithPINContinueCTA.click();
        }
    }

    public void ConfirmPIN(String PIN){
        waitForVisibility(PIN1);
        PIN1.sendKeys(PIN);
        ContinueCTAAfterConfirmPIN.click();
    }

    public void ClickOkDone(){
        waitForVisibility(OKAllDoneCTA);
        OKAllDoneCTA.click();
    }

    public void CheckMyAccountOpenSuccessfully(){
        waitForVisibility(MyAccSelectAccountTitle);
        AssertDisplayed(MyAccSelectAccountTitle.isDisplayed());
    }

    public void ClickBackCTA(){
        waitForVisibility(BackCTAAfterEnteringPIN);
        BackCTAAfterEnteringPIN.click();
    }

    public void checkPINExistsAfterBackCTA(){
        waitForVisibility(PIN1);
        Assert.assertNotEquals(PIN1.getText(), null);
        ContinueCTAAfterEnteringPIN.click();
    }

    public void checkPINErrorAppears(){
        waitForVisibility(ErrorPINMismatch);
        AssertDisplayed(ErrorPINMismatch.isDisplayed());
    }
}

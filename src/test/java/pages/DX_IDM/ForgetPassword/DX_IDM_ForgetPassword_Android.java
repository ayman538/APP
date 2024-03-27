package pages.DX_IDM.ForgetPassword;

import pages.DX_IDM.SoftLogin.DX_IDM_SoftLoginLogicAndroid;
import pages.DX_IDM.SoftLogin.DX_IDM_SoftLoginLogic_Abstract;
import pages.DX_IDM.UFL.DX_IDM_UFL_Abstract;
import pages.DX_IDM.UFL.DX_IDM_UFL_Android;
import pages.Forgetpassword;
import testdata.TestData;

import static utils.element_helpers.VerifyHelpers.AssertDisplayed;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

public class DX_IDM_ForgetPassword_Android extends DX_IDM_ForgetPasswordAbstract {

    private DX_IDM_SoftLoginLogic_Abstract dx_idm_softLoginLogic;
    private DX_IDM_UFL_Abstract dx_idm_uflLogic;
    private Forgetpassword forgetpassword;
    private String tempPass;
    private String username;

    public DX_IDM_ForgetPassword_Android() {
        super();
        dx_idm_softLoginLogic = new DX_IDM_SoftLoginLogicAndroid();
        dx_idm_uflLogic = new DX_IDM_UFL_Android();
        forgetpassword = new Forgetpassword();
        username = TestData.GetUserName();
    }

    public void softLoginForForgetPass() {
        dx_idm_softLoginLogic.navigateWelcomeScreen();
        dx_idm_softLoginLogic.navigatePrivacyAndTermsScreen();
        dx_idm_softLoginLogic.navigatePermissionScreen();
        dx_idm_softLoginLogic.validateDashboardAfterSoftLogin();
    }

    public void clickMyAccount() {
        waitForVisibility(DB_MyAccountTray_icon);
        DB_MyAccountTray_icon.click();
    }

    public void enterUsernameForForgetPass() throws InterruptedException {
        DX_IDM_Username.sendKeys(username);
        Thread.sleep(1000);
        DX_IDM_ContinueCTA.click();
    }

    public void clickForgetPassCTA() {
        waitForVisibility(DX_IDM_ForgotUsername);
        DX_IDM_ForgotUsername.click();
    }

    public void clickForgetPasswordCTA() {
        try{
            AcceptCookies.click();
        }
        catch(Exception e){
            System.out.println("Cookies didn't display");
        }
        waitForVisibility(DX_IDM_ForgotPassword);
        DX_IDM_ForgotPassword.click();
    }


    public void addUsernameForForgetPass() {
        waitForVisibility(DX_IDM_ResetPasswordUsernameTxtField);
        DX_IDM_ResetPasswordUsernameTxtField.sendKeys(username);
    }

    public void clickResetPass() {
        waitForVisibility(DX_IDM_ResetPasswordCTA);
        DX_IDM_ResetPasswordCTA.click();
    }

    public void clickResetPassContinueCTA() {
        waitForVisibility(DX_IDM_ResetPasswordContinueCTA);
        DX_IDM_ResetPasswordContinueCTA.click();
    }

    public void enterTempPass() {
        waitForVisibility(DX_IDM_Password);
        tempPass = forgetpassword.getTempPass();
        DX_IDM_Password.sendKeys(tempPass);
        waitForVisibility(DX_IDM_LoginCTA);
        DX_IDM_LoginCTA.click();
    }

    public void enterOTAC() throws InterruptedException {
        dx_idm_uflLogic.validateSelectingAccount();
        dx_idm_uflLogic.EnterSecurityCode();
    }

    public void enterNewPass() {
        waitForVisibility(DX_IDM_ResetPasswordUpdatePassTitle);
        DX_IDM_ResetPasswordNewPassTxtField.sendKeys("Testing@1");
        DX_IDM_ResetPasswordConfirmPassTxtField.sendKeys("Testing@1");
        DX_IDM_ResetPasswordUpdatePassContinueCTA.click();
    }

    public void checkLoginPrefScreen() {
        waitForVisibility(DX_IDM_LogPrefPIN);
        AssertDisplayed(DX_IDM_LogPrefPIN.isDisplayed());
    }
}

package pages.DX_IDM.ForgetPassword;

import core.Config;
import pages.DX_IDM.FullLogin.DX_IDM_FullLoginPO;
import pages.DX_IDM.SoftLogin.DX_IDM_SoftLoginLogic_Abstract;
import pages.DX_IDM.SoftLogin.DX_IDM_SoftLoginLogic_IOS;
import pages.DX_IDM.UFL.DX_IDM_UFL_Abstract;
import pages.DX_IDM.UFL.DX_IDM_UFL_IOS;
import pages.Forgetpassword;
import testdata.TestData;

import static utils.element_helpers.VerifyHelpers.AssertDisplayed;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

public class DX_IDM_ForgetPassword_IOS extends DX_IDM_ForgetPasswordAbstract {

    private DX_IDM_FullLoginPO dx_idm_fullLoginPO;
    private DX_IDM_SoftLoginLogic_Abstract dx_idm_softLoginLogic;
    private final Config config =new Config();
    private DX_IDM_UFL_Abstract dx_idm_uflLogic;
    private Forgetpassword forgetpassword;
    private String tempPass;
    private String username;

    public DX_IDM_ForgetPassword_IOS(){
        super();
        dx_idm_softLoginLogic = new DX_IDM_SoftLoginLogic_IOS();
        dx_idm_uflLogic = new DX_IDM_UFL_IOS();
        forgetpassword = new Forgetpassword();
        username = TestData.GetUserName();
    }

    public void softLoginForForgetPass(){
        dx_idm_softLoginLogic.navigateWelcomeScreen();
        dx_idm_softLoginLogic.navigatePrivacyAndTermsScreen();
        dx_idm_softLoginLogic.navigatePermissionScreen();
        dx_idm_softLoginLogic.validateDashboardAfterSoftLogin();
    }

    public void clickMyAccount(){
        waitForVisibility(DB_MyAccountTray_icon);
        DB_MyAccountTray_icon.click();
    }

    public void enterUsernameForForgetPass() throws InterruptedException {
        dx_idm_fullLoginPO.DX_IDM_Username.sendKeys(username);
        Thread.sleep(1000);
        dx_idm_fullLoginPO.DX_IDM_ContinueCTA.click();
    }

    public void clickForgetPassCTA(){
        waitForVisibility(DX_IDM_ForgotUsername);
        DX_IDM_ForgotUsername.click();
    }

    public void addUsernameForForgetPass(){
        waitForVisibility(DX_IDM_ResetPasswordUsernameTxtField);
        DX_IDM_ResetPasswordUsernameTxtField.sendKeys(username);
    }

    public void clickResetPass(){
        waitForVisibility(DX_IDM_ResetPasswordCTA);
        DX_IDM_ResetPasswordCTA.click();
    }

    public void clickResetPassContinueCTA(){
        waitForVisibility(DX_IDM_ResetPasswordContinueCTA);
        DX_IDM_ResetPasswordContinueCTA.click();
    }

    public void enterTempPass(){
        waitForVisibility(dx_idm_fullLoginPO.DX_IDM_Password);
        tempPass = forgetpassword.getTempPass();
        dx_idm_fullLoginPO.DX_IDM_Password.sendKeys(tempPass);
        waitForVisibility(dx_idm_fullLoginPO.DX_IDM_LoginCTA);
        dx_idm_fullLoginPO.DX_IDM_LoginCTA.click();
    }

    public void enterOTAC() throws InterruptedException {
        dx_idm_uflLogic.validateSelectingAccount();
        dx_idm_uflLogic.EnterSecurityCode();
    }

    public void enterNewPass(){
        waitForVisibility(DX_IDM_ResetPasswordUpdatePassTitle);
        DX_IDM_ResetPasswordNewPassTxtField.sendKeys("Testing@1");
        DX_IDM_ResetPasswordConfirmPassTxtField.sendKeys("Testing@1");
        DX_IDM_ResetPasswordUpdatePassContinueCTA.click();
    }

    public void checkLoginPrefScreen(){
        waitForVisibility(dx_idm_fullLoginPO.DX_IDM_LogPrefPIN);
        AssertDisplayed(dx_idm_fullLoginPO.DX_IDM_LogPrefPIN.isDisplayed());
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
}

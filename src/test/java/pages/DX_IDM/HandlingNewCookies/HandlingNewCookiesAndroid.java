package pages.DX_IDM.HandlingNewCookies;

import static utils.element_helpers.DriverHelps.killApp;
import static utils.element_helpers.DriverHelps.startActivity;
import static utils.element_helpers.VerifyHelpers.AssertDisplayed;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

public class HandlingNewCookiesAndroid extends HandlingNewCookiesAbstract {

    public HandlingNewCookiesAndroid() {
        super();
    }

    @Override
    public  void acceptCookies() {
        try {
            waitForVisibility(AcceptCookies);
            AcceptCookies.click();
        } catch (Exception e) {
            System.out.println("Cookies are already accepted");
        }
    }

    @Override
    public void assertLoginUsernameIsDisplayed() {
        waitForVisibility(DX_IDM_Username);
        AssertDisplayed(DX_IDM_Username.isDisplayed());
    }

    @Override
    public void hardClose() {
        killApp();
        startActivity();
    }

    @Override
    public void ValidatePasswordScreenContent() {
        waitForVisibility(DX_IDM_Password);
        AssertDisplayed(DX_IDM_ForgotPassword.isDisplayed());
    }

    @Override
    public void clickOn_MyAccount() {
        try{
            waitForVisibility(DB_MyAccountTray_icon);
            DB_MyAccountTray_icon.click();
        }
        catch(Exception e)
        {
         System.out.println("My account icon doesn't exist");
        }
    }

    @Override
    public void ClickXButton() {
        DX_IDM_X_Button.click();
    }

    @Override
    public void navigateWelcomeScreen() {
        waitForVisibility(DX_IDM_SkipLoginCTA);
        DX_IDM_SkipLoginCTA.click();
    }


    @Override
    public void relogin() {
        waitForVisibility(DX_IDM_WelcomeContinueCTA);
        DX_IDM_WelcomeContinueCTA.click();

        waitForVisibility(DX_IDM_PrivacyAndTermsToggle);
        DX_IDM_PrivacyAndTermsToggle.click();
        DX_IDM_PrivacyScreenContinueCTA.click();

        waitForVisibility(DX_IDM_PermissionScreenContinueCTA);
        DX_IDM_PermissionScreenContinueCTA.click();
        DX_IDM_NoThanksPermission.click();

    }
    @Override
    public void clickOnLoginCTA(){
        waitForVisibility(Login_Button);
        Login_Button.click();
    }

}

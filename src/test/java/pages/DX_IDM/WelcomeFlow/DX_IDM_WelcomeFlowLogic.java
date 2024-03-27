package pages.DX_IDM.WelcomeFlow;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.DX_IDM.FullLogin.DX_IDM_FullLoginLogic;
import pages.DX_IDM.FullLogin.DX_IDM_FullLoginPO;
import pages.DX_IDM.UFL.DX_IDM_UFLLogic;

import java.time.Duration;

import static core.Config.getPlatformType;
import static utils.element_helpers.DriverHelps.killApp;
import static utils.element_helpers.DriverHelps.startActivity;
import static utils.element_helpers.VerifyHelpers.AssertDisplayed;
import static utils.element_helpers.VerifyHelpers.AssertResult;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

public class DX_IDM_WelcomeFlowLogic extends DX_IDM_WelcomeFlowPO {
    DX_IDM_FullLoginPO loginObject;
    DX_IDM_UFLLogic UFL_Logic;
    DX_IDM_FullLoginLogic FL_Logic;


    public DX_IDM_WelcomeFlowLogic() {
        super();
    }

    public void beforeWelcomeScreen() {
        waitForVisibility(DX_IDM_WelcomeTitle);
    }

    public void validateWelcomeScreenContent() {
        AssertResult(DX_IDM_WelcomeTitle.getText(), "Welcome to My Vodafone");
        AssertResult(DX_IDM_WelcomeContinueCTA.getText(), "Continue");
        DX_IDM_WelcomeContinueCTA.click();
    }

    public void beforePrivacyScreen() {
        waitForVisibility(DX_IDM_PrivacyScreenTitle);
    }

    public void validatePrivacyScreenContent() {
        AssertResult(DX_IDM_PrivacyScreenTitle.getText(), "Before we get\nyou started...");
        AssertResult(DX_IDM_PrivacyAndTerms.getText(), "I agree to the App Privacy\nSupplement and Terms & Conditions");
        AssertDisplayed(DX_IDM_PrivacyAndTermsToggle.isDisplayed());
        AssertResult(DX_IDM_PrivacyScreenContinueCTA.getText(), "Continue");
    }

    public void validatePrivacyScreenFunc() {
        DX_IDM_PrivacyScreenContinueCTA.click();
        if (getPlatformType().equalsIgnoreCase("Android"))
            AssertResult(DX_IDM_PrivacyAndTermsToggleMessage.getText(), "Please agree to the Terms and\nConditions before continuing");
        else
            AssertResult(DX_IDM_PrivacyAndTermsToggleMessage.getText(), "Please agree to the Terms and \u2028Conditions before continuing");
        DX_IDM_PrivacyAndTermsToggle.click();
        DX_IDM_PrivacyScreenContinueCTA.click();
    }

    public void beforePermissionScreen() {
        waitForVisibility(DX_IDM_PermissionScreenTitle);
    }

    public void validatePermissionScreenContent() {
        AssertResult(DX_IDM_PermissionScreenTitle.getText(), "One last thing");
        //TODO: to be handled for IOS
        if (getPlatformType().equalsIgnoreCase("Android"))
            AssertResult(DX_IDM_PermissionScreenSubTitle.getText(), "To get the most from the My Vodafone App,\nwe'd like to ask for some permissions");
        AssertResult(DX_IDM_PermissionScreenContinueCTA.getText(), "Continue");
        DX_IDM_PermissionScreenContinueCTA.click();
        acceptIOSPermission();
    }

    public void closePermission() {
        if (getPlatformType().equalsIgnoreCase("Android")) {
            waitForVisibility(DX_IDM_NoThanksPermission);
            DX_IDM_NoThanksPermission.click();
        }
    }

    public void acceptIOSPermission() {
        if (getPlatformType().equalsIgnoreCase("IOS")) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.alertIsPresent());
            acceptAlert();
        }
    }

    public void acceptAlert() {
        Alert alert;
        alert = driver.switchTo().alert();
        alert.accept();
    }

    public void beforeLoginScreen() {
        if (getPlatformType().equalsIgnoreCase("Android")) {
            waitForVisibility(DX_IDM_NoThanksPermission);
            DX_IDM_NoThanksPermission.click();
        }
        waitForVisibility(DX_IDM_LoginCTA);
    }

    public void validateLoginScreenContent() {
        //TODO: to be handled for IOS
        if (getPlatformType().equalsIgnoreCase("Android")) {
            AssertResult(DX_IDM_LoginScreenTitle.getText(), "Log in to My Vodafone");
            AssertResult(DX_IDM_LoginScreenBody.getText(), "Log in to access My Vodafone. If your phone is using a Vodafone SIM card, you can turn off Wi-Fi for a faster log in.");
        }
        AssertResult(DX_IDM_LoginCTA.getText(), "Log In");
        AssertResult(DX_IDM_SkipLoginCTA.getText(), "Skip Login");
    }

    public void dxIDMWelcomeFlow() {
        waitForVisibility(DX_IDM_WelcomeTitle);
        DX_IDM_WelcomeContinueCTA.click();
        waitForVisibility(DX_IDM_PrivacyScreenTitle);
        waitForVisibility(DX_IDM_PrivacyAndTermsToggle);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        DX_IDM_PrivacyAndTermsToggle.click();
        DX_IDM_PrivacyScreenContinueCTA.click();
        waitForVisibility(DX_IDM_PermissionScreenTitle);
        //TODO: to be handled for IOS
        if (getPlatformType().equalsIgnoreCase("Android")) {
            DX_IDM_PermissionScreenContinueCTA.click();
            // acceptIOSPermission();
        }
        acceptIOSPermission();
        beforeLoginScreen();
        waitForVisibility(DX_IDM_LoginCTA);
    }

    public void dxIdmVOXIScreenContent() {
        AssertDisplayed(DX_IDM_VOXISignINURL.isDisplayed());
        AssertDisplayed(DX_IDM_VOXIReturnToMyVodafoneCTA.isDisplayed());
    }

    public void clickOnReturnToMyVodafoneCTA() {
        DX_IDM_VOXIReturnToMyVodafoneCTA.click();
    }

    public void clickOnXIcon() {
        DX_IDM_VOXIReturnToMyVodafoneCTA.click();
    }

    public void clickOnTobiIcon() {
        DX_IDM_VOXITobiIcon.click();
    }

    public void validateTobiContentScreen() {
        AssertDisplayed(DX_IDM_VOXITobiContentScreen.isDisplayed());
    }

    public void clickOnSettingsDrawer() {
        DX_IDM_VOXISettingDrawer.click();
    }

    public void validateAppAndPrivacySettingsDisplayed() {
        waitForVisibility(DX_IDM_VOXIAppSettingDrawer);
        AssertDisplayed(DX_IDM_VOXIAppSettingDrawer.isDisplayed());
        AssertDisplayed(DX_IDM_VOXIPrivacySettingDrawer.isDisplayed());
    }

    public void clickOnVOXIMyAccountDrawer() {
        DX_IDM_VOXIMyAccountDrawer.click();
    }

    public void validateLoginToMyVodafoneUsername() {
        loginObject = new DX_IDM_FullLoginPO();
        waitForVisibility(loginObject.DX_IDM_Username);
        AssertDisplayed(loginObject.DX_IDM_Username.isDisplayed());
    }

    public void dxIdmSMEScreenContent() {
        waitForVisibility(DX_IDM_HelloFriendTitle);
        AssertResult(DX_IDM_HelloFriendTitle.getText(), "Hello, friend!");
        AssertResult(DX_IDM_HelloFriendReturnToMyVodafoneCTA.getText(), "Return to My Vodafone");
        AssertResult(DX_IDM_HelloFriendBody.getText(), "The My Vodafone app doesn’t currently support the plan connected with your device’s SIM card.\n" +
                "\n" +
                "If you have another Vodafone service you’d like to manage, you can log in via the My Account page.");
    }

    public void TapOnXIconInHelloFriendScreen() {
        waitForVisibility(DX_IDM_HelloFriendXIcon);
        DX_IDM_HelloFriendXIcon.click();
//        AcquisitionBoardPO acq = new AcquisitionBoardPO();
//        waitForVisibility(acq.Acquisition_NewDB_Xicon);
//        AssertDisplayed(acq.Acquisition_NewDB_Xicon.isDisplayed());
    }

    public void ValidateHelloFriendScreenContentWithUnknownUser() {
        waitForVisibility(DX_IDM_HelloFriendTitle);
        AssertResult(DX_IDM_HelloFriendTitle.getText(), "Hello, friend!");
        AssertResult(DX_IDM_HelloFriendBody.getText(), "Log in to My Vodafone to view your current charges and usage, view and pay your bill, manage your extras and more.\n" +
                "\n" +
                "If you’d prefer, you can always log in via the My Account page later.");
        AssertResult(DX_IDM_HelloFriendLoginCTA.getText(), "Log in");
        AssertResult(DX_IDM_HelloFriendReturnToMyVodafoneCTA.getText(), "Return to My Vodafone");
    }

    public void ClickOnReturnToVodafoneCTAWithUnknownUser() {
        waitForVisibility(DX_IDM_HelloFriendReturnToMyVodafoneCTA);
        DX_IDM_HelloFriendReturnToMyVodafoneCTA.click();
    }

    public void AppHardCloseInHelloFriendScreenThenRelaunch() {
        killApp();
        startActivity();
    }

    public void ClickOnLoginCTAWithUnknownUser() {
        waitForVisibility(DX_IDM_HelloFriendLoginCTA);
        DX_IDM_HelloFriendLoginCTA.click();
    }

    public void UFLJourneyIsTriggeredTillReachDashboard() throws ParseException, InterruptedException {
        UFL_Logic = new DX_IDM_UFLLogic();
        FL_Logic = new DX_IDM_FullLoginLogic();

        UFL_Logic.LoginTillReachPasswordScreen();
        UFL_Logic.LoginTillReachRequestSecurityCodeScreen();
        UFL_Logic.validateSelectingAccount();
        UFL_Logic.LoginTillReachChooseAccountScreen();
        UFL_Logic.LoginTillReachChoosePlanScreen();
        UFL_Logic.LoginTillReachLoginPreferenceScreen();
        FL_Logic.selectPIN();
        FL_Logic.pressAllDoneCTA();
    }

    public void AcquisitionScreenIsDisplayed() {
        waitForVisibility(DX_IDM_AcquisitionScreenHeaderTitle);
        AssertResult(DX_IDM_AcquisitionScreenHeaderTitle.getText(), "Vodafone Together");
        AssertResult(DX_IDM_AcquisitionScreenHeaderBody.getText(), "Unlimited home broadband and unlimited mobile data in one great deal.");

    }


}

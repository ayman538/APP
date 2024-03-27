/*package pages.DX_IDM.ForgottenPIN;


import core.Config;
import pages.DX_IDM.ChangePin.DX_IDM_ChangePinAbstract;
import pages.DX_IDM.ChangePin.DX_IDM_ChangePinAndroid;
import pages.DX_IDM.ChangePin.DX_IDM_ChangePinIOS;
import pages.DX_IDM.FullLogin.DX_IDM_FullLoginLogic_Abstract;
import pages.DX_IDM.FullLogin.DX_IDM_FullLoginLogic_Android;
import pages.DX_IDM.FullLogin.DX_IDM_FullLoginLogic_IOS;
import pages.DX_IDM.UFL.DX_IDM_UFLLogic;

import java.io.IOException;

import static utils.element_helpers.VerifyHelpers.AssertResult;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

@Deprecated
public class DX_IDM_ForgottenPIN_Logic extends DX_IDM_ForgottenPIN_PO{
    private DX_IDM_FullLoginLogic_Abstract FL_Logic;

    DX_IDM_UFLLogic UFL_Logic;
    private DX_IDM_ChangePinAbstract ChangePIN_Logic;
    private final Config config= new Config();


    public DX_IDM_ForgottenPIN_Logic() throws IOException {
        super();
        if (config.isAndroid()) FL_Logic = new DX_IDM_FullLoginLogic_Android();
        if (config.isIos()) FL_Logic = new DX_IDM_FullLoginLogic_IOS();

        if (config.isAndroid()) ChangePIN_Logic = new DX_IDM_ChangePinAndroid();
        if (config.isIos()) ChangePIN_Logic = new DX_IDM_ChangePinIOS();

        UFL_Logic = new DX_IDM_UFLLogic();
    }

    public void triggerJourneyRequiresLogin() throws InterruptedException {
        Thread.sleep(2000);
        FL_Logic.navigateToMyAccount();
    }

    public void triggerForgotPINJourneyTillEnterNewPINScreen() throws InterruptedException {
        FL_Logic.DX_IDM_Password.sendKeys("testing1");
        Thread.sleep(1000);
        FL_Logic.DX_IDM_PasswordLoginCTA.click();
        waitForVisibility(ChangePIN_Logic.DX_IDM_EnterPinTitle);
    }

    public void triggerForgotPINJourneyTillReEnterNewPINScreen() throws InterruptedException {
        triggerJourneyRequiresLogin();
        waitForVisibility(DX_IDM_ForgotYourPIN_Link);
        DX_IDM_ForgotYourPIN_Link.click();
        triggerForgotPINJourneyTillEnterNewPINScreen();
        enterValidPIN();
        FL_Logic.DX_IDM_ContinueCTA.click();
    }
    public void triggerForgotPINJourneyTillPINSuccessfullyUpdatedScreen() throws InterruptedException {
        triggerForgotPINJourneyTillReEnterNewPINScreen();
        enteringMatchedPIN();
        FL_Logic.DX_IDM_ContinueCTA.click();
    }
    public void triggerAnyJourneyRequireLoginThenEnterNewSetPIN() throws InterruptedException {
        FL_Logic.navigateToMyAccount();
        enterValidPIN();
        FL_Logic.DX_IDM_ContinueCTA.click();
    }

    public void passwordScreenIsDisplayed() throws InterruptedException {
        Thread.sleep(20000);
        waitForVisibility(FL_Logic.DX_IDM_Password);
        FL_Logic.DX_IDM_Password.isDisplayed();
    }

    public void enterYourPINScreenIsDisplayed() throws  InterruptedException {
        Thread.sleep(2000);
        waitForVisibility(DX_IDM_EnterYourPIN_Desc);
        AssertResult(DX_IDM_EnterYourPIN_Desc.getText(),"Please enter the PIN you use to log in to My Vodafone, or use to chat with customer support.");
        AssertResult(DX_IDM_EnterYourPIN_Subtitle.getText(), "Enter your PIN");
        waitForVisibility(DX_IDM_ForgotYourPIN_Link);
        AssertResult(DX_IDM_ForgotYourPIN_Link.getText(), "Forgotten Pin?");
    }
    public void enterYourNewPINScreenISDisplayed() {
        waitForVisibility(ChangePIN_Logic.DX_IDM_EnterPinTitle);
        AssertResult(ChangePIN_Logic.DX_IDM_EnterPinTitle.getText(), "Enter your new PIN");
    }
    public void reEnterPINScreenISDisplayed() {
        FL_Logic.DX_IDM_ContinueCTA.click();
        waitForVisibility(ChangePIN_Logic.DX_IDM_EnterPinTitle);
        AssertResult(ChangePIN_Logic.DX_IDM_EnterPinTitle.getText(), "Re-enter your new PIN");
    }
    public void validatePINSuccessfullyUpdatedScreenIsDisplayed() {
        ChangePIN_Logic.PinSuccessfullyUpdatedScreenIsDisplayed();
    }

    public void validateEnterNewPINScreenContent() {
        ChangePIN_Logic.ValidateEnterPinScreenIsDisplayed();
    }

    public void validateReEnterNewPINScreenContent() {
        ChangePIN_Logic.ReEnterPinScreenIsDisplayed();
    }

    public void clickOnForgotYourPINLink(){
        DX_IDM_ForgotYourPIN_Link.click();
    }
    public void clickXButton() {
        X_Button.click();
    }
    public void clickBackCTA() {
        ChangePIN_Logic.DX_IDM_PinBackCTA.click();
    }

    public void clickOnOKAllDoneCTA() {
        ChangePIN_Logic.DX_IDM_PinOkDoneCTA.click();
    }

    public void hardCloseTheAppThenRelaunch() throws InterruptedException {
        driver.closeApp();
        driver.launchApp();
        Thread.sleep(10000);
    }

    public void enterValidPIN() {
        ChangePIN_Logic.DX_IDM_PinField1.sendKeys("1");
        ChangePIN_Logic.DX_IDM_PinField2.sendKeys("3");
        ChangePIN_Logic.DX_IDM_PinField3.sendKeys("5");
        ChangePIN_Logic.DX_IDM_PinField4.sendKeys("7");
    }
    public void enterNotMatchedPIN() {
        ChangePIN_Logic.DX_IDM_PinField1.sendKeys("2");
        ChangePIN_Logic.DX_IDM_PinField2.sendKeys("4");
        ChangePIN_Logic.DX_IDM_PinField3.sendKeys("6");
        ChangePIN_Logic.DX_IDM_PinField4.sendKeys("8");
    }

    public void enteringMatchedPIN() {
        waitForVisibility(ChangePIN_Logic.DX_IDM_EnterPinTitle);
        enterValidPIN();
        FL_Logic.DX_IDM_ContinueCTA.click();
    }

    public void validateContinueCTAIsDisabled() {
        FL_Logic.DX_IDM_ContinueCTA.click();
        AssertResult(ChangePIN_Logic.DX_IDM_EnterPinTitle.getText(), "Re-enter your new PIN");
    }

    public void journeyShouldBeOpened() throws InterruptedException {
        FL_Logic.validateMYAccountOpenedAfterEnterValidPIN();
    }

    public void dashboardIsDisplayed() throws InterruptedException {
        Thread.sleep(20000);
        waitForVisibility(FL_Logic.DX_IDM_MyAccountTray);
        FL_Logic.DX_IDM_MyAccountTray.isDisplayed();
    }

    public void pinIsNotReset() throws InterruptedException {
        FL_Logic.navigateToMyAccount();
        FL_Logic.validateMYAccountOpenedAfterEnterValidPIN();
    }
}

 */
/*package pages.DX_IDM.ChangePin;

import pages.Tray.Settings.AppSetting.AppSettingsLogic;

import static utils.element_helpers.VerifyHelpers.AssertDisplayed;
import static utils.element_helpers.VerifyHelpers.AssertResult;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

@Deprecated
public class DX_IDM_ChangePinLogic extends DX_IDM_ChangePinPO {

    private final AppSettingsLogic AppSettings;

    public DX_IDM_ChangePinLogic()  {
        super();
        AppSettings = new AppSettingsLogic();
    }

    public void hardClose() {
        driver.closeApp();
        driver.launchApp();
    }

    public void AccountSettingsScreenIsDisplayed() {
        AppSettings.clickOnSettingsInTray();
        waitForVisibility(DB_AccountSetting);
        DB_AccountSetting.click();
    }

    public void ValidateChangePinOptionIsDisplayed() {
        waitForVisibility(AccountSetting_ChangePin);
        AssertDisplayed(AccountSetting_ChangePin.isDisplayed());
    }

    public void ChangePinIsDisplayedInAccountSettings() {
        AccountSetting_ChangePin.click();
    }

    public void ValidateEnterPinScreenIsDisplayed() {
        waitForVisibility(DX_IDM_EnterPinTitle);
        AssertResult(DX_IDM_EnterPinTitle.getText(), "Enter your new PIN");
        AssertResult(DX_IDM_EnterPinBody.getText(), "Make sure it’s memorable - we use it to check your identity when you contact us or log in.");
        AssertResult(DX_IDM_EnterPinFooter1.getText(), "Can’t use all repeated numbers e.g. 1111");
        AssertResult(DX_IDM_EnterPinFooter2.getText(), "Can’t all be consecutive e.g. 1234");
    }

    public void EnterPinScreenIsDisplayed() {
        waitForVisibility(Pin_Field);
    }

    public void ClickOnXiconOnEnterPinScreen() {
        EnterPinScreenIsDisplayed();
        DX_IDM_PinXicon.click();
    }

    public void ValidateEnterPinScreenFourFields() {
        EnterPinFields();
        tapOnNextCTA();
    }

    public void tapOnNextCTA() {
        DX_IDM_PinNextCTA.click();
    }

    public void ValidateThanksForVerifyingScreen() throws InterruptedException {
        Thread.sleep(2000);
        waitForVisibility(DX_IDM_ThanksForVerify);
        AssertResult(DX_IDM_ThanksForVerify.getText(), "Thanks for verifying");
        AssertResult(DX_IDM_BtnLoginCTAThanksForVerify.getText(), "Log in now");
        DX_IDM_BtnLoginCTAThanksForVerify.click();
    }

    public void ReEnterPinScreenIsDisplayed() {
        waitForVisibility(DX_IDM_PinBackCTA);
        AssertResult(DX_IDM_EnterPinTitle.getText(), "Re-enter your new PIN");
        AssertResult(DX_IDM_EnterPinBody.getText(), "Make sure it’s memorable - we use it to check your identity when you contact us or log in.");
        AssertResult(DX_IDM_EnterPinSubTitle.getText(), "Re-enter your new PIN");
        AssertResult(DX_IDM_PinBackCTA.getText(), "Back");
    }

    private void EnterPinFields() {
        DX_IDM_PinField1.sendKeys("2");
        DX_IDM_PinField2.sendKeys("2");
        DX_IDM_PinField3.sendKeys("3");
        DX_IDM_PinField4.sendKeys("3");
    }

    public void PinSuccessfullyUpdatedScreenIsDisplayed() {
        waitForVisibility(DX_IDM_PinOkDoneCTA);
        AssertResult(DX_IDM_PinOkDoneCTA.getText(), "OK, all done");
        AssertResult(DX_IDM_PinSuccessfullyTitle.getText(), "Your PIN was \nsuccessfully updated");
        AssertResult(DX_IDM_PinSuccessfullyBody.getText(), "Remember to keep your PIN safe and don't let anyone else know what it is.");
        AssertDisplayed(DX_IDM_PinSuccessfullyIcon.isDisplayed());
    }

    public void ValidatePinSuccessfullyUpdatedScreenFourFields() {
        DX_IDM_PinOkDoneCTA.click();
        waitForVisibility(AccountSetting_ChangePin);
        AssertDisplayed(AccountSetting_ChangePin.isDisplayed());
    }

}

 */
package pages.DX_IDM.ForgotUsername;

import testdata.ReadTestData;

import static utils.element_helpers.VerifyHelpers.AssertDisplayed;
import static utils.element_helpers.VerifyHelpers.AssertResult;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

public class DXIDM_ForgotUsername_Android extends DXIDM_ForgotUsernameAbstract {


    String FirstName = ReadTestData.getFirstName();
    String LastName = ReadTestData.getLastName();
    String username = ReadTestData.getUsername();


    public DXIDM_ForgotUsername_Android() {
        super();
    }


    @Override
    public void ClickOnForgotUsername() {
        waitForVisibility(DX_IDM_ForgotUsername);
        DX_IDM_ForgotUsername.click();
    }

    @Override
    public void acceptCookies() {
        waitForVisibility(AcceptCookies);
        AcceptCookies.click();
    }

    @Override
    public void clickOnBack() {
        waitForVisibility(GeneralBackIcon);
        GeneralBackIcon.click();
    }

    @Override
    public void ValidateThanksForVerifyingScreen() throws InterruptedException {
        Thread.sleep(2000);
        waitForVisibility(DX_IDM_ThanksForVerify);
        AssertResult(DX_IDM_BtnLoginCTAThanksForVerify.getText(), "Log in now");
        DX_IDM_BtnLoginCTAThanksForVerify.click();
    }

    @Override
    public void ValidateUsernameIsAutoPopulated() {
        waitForVisibility(DX_IDM_Password);
        AssertDisplayed(DX_IDM_UsernameInPasswordScreen.isDisplayed());
//        AssertResult(DX_IDM_UsernameInPasswordScreen.getText(), username);
        DX_IDM_UsernameInPasswordScreen.click();
    }


    @Override
    public void enterFirstAndSecondName() {

        waitForVisibility(First_name);
        First_name.sendKeys(FirstName);
        Last_name.sendKeys(LastName);
        NextCTA.click();

    }

    @Override
    public void ValidateExternalWebView() {
        waitForVisibility(DXIDM_ExternalBrowser);
    }

}

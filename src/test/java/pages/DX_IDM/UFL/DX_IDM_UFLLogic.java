package pages.DX_IDM.UFL;


import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.testng.SkipException;
import testdata.ReadResponse;
import testdata.TestData;

import java.time.Duration;

import static utils.element_helpers.DriverHelps.killApp;
import static utils.element_helpers.DriverHelps.startActivity;
import static utils.element_helpers.GenericHelpers.hashMSISDIN;
import static utils.element_helpers.ScrollHelpers.scrollDownTo;
import static utils.element_helpers.TextHelpers.GetXpath;
import static utils.element_helpers.VerifyHelpers.AssertDisplayed;
import static utils.element_helpers.VerifyHelpers.AssertResult;
import static utils.element_helpers.WaitHelpers.waitForVisibility;
@Deprecated
public class DX_IDM_UFLLogic extends DX_IDM_UFLPO {
    String username;

    public DX_IDM_UFLLogic() {
        super();
    }

    public void SkipLoginCTA() {
        waitForVisibility(DX_IDM_SkipLoginCTA);
        DX_IDM_SkipLoginCTA.click();
    }

    public void ValidateSkipLogin() {
        waitForVisibility(DX_IDM_DisconnectWiFi);
        AssertDisplayed(DX_IDM_DisconnectWiFi.isDisplayed());
    }

    public void DisconnectWiFiCloseCTA() {
        waitForVisibility(DX_IDM_DisconnectWiFiCloseCTA);
        DX_IDM_DisconnectWiFiCloseCTA.click();
    }

    public void validateSelectingAccount() {
        try {
            DX_IDM_SelectSecurityAccount.click();
            String MSISDN = TestData.GetMSISDN();
            String hashedMSISDN = hashMSISDIN(MSISDN);
            Thread.sleep(1000);
            driver.findElement(By.xpath(GetXpath(hashedMSISDN))).click();
        } catch (Exception e) {
            System.out.println("The user has one number only");
        }
        DX_IDM_ContinueCTA.click();
    }

    public void EnterSecurityCode() {
        DX_IDM_EnterSecurityCodeField1.sendKeys("1");
        DX_IDM_EnterSecurityCodeField2.sendKeys("2");
        DX_IDM_EnterSecurityCodeField3.sendKeys("3");
        DX_IDM_EnterSecurityCodeField4.sendKeys("4");
        DX_IDM_EnterSecurityCodeField5.sendKeys("5");
    }

    private void ValidateMSISDNs() throws ParseException {
        String MSISDN;
        MSISDN = ReadResponse.getSubsList().get(0).get("msisdn");
        if (!ReadResponse.getSubsType(0).equalsIgnoreCase("BB")) {
            MSISDN = "0" + MSISDN.substring(2);
        }
        AssertDisplayed(driver.findElement(By.xpath("//*[@text='" + MSISDN + "']")).isDisplayed());
        for (int i = 1; i < ReadResponse.getSubsList().size() - 1; i++) {
            MSISDN = ReadResponse.getSubsList().get(i).get("msisdn");
            if (!ReadResponse.getSubsType(i).equalsIgnoreCase("BB")) {
                MSISDN = "0" + MSISDN.substring(2);
                assertSubscriptionCardIsDisplayed(MSISDN);
            }
            assertSubscriptionCardIsDisplayed(MSISDN);
        }
    }

    public void assertSubscriptionCardIsDisplayed(String MSISDN) {
        scrollDownTo(driver.findElement(By.xpath("//*[@text='" + MSISDN + "']")));
        AssertDisplayed(driver.findElement(By.xpath("//*[@text='" + MSISDN + "']")).isDisplayed());
    }

    public void LoginTillReachUsernameScreen() {
        username = TestData.GetUserName();
        DX_IDM_LoginCTA.click();
        waitForVisibility(DX_IDM_Username);
    }

    public void LoginTillReachPasswordScreen() throws InterruptedException {
        waitForVisibility(DX_IDM_Username);
        username = TestData.GetUserName();
        DX_IDM_Username.sendKeys(username);
        Thread.sleep(1000);
        DX_IDM_ContinueCTA.click();
        waitForVisibility(DX_IDM_Password);
    }

    public void LoginTillReachRequestSecurityCodeScreen() throws InterruptedException {
        DX_IDM_Password.sendKeys("testing1");
        Thread.sleep(1000);
        DX_IDM_Password_LoginCTA.click();
        Thread.sleep(1000);
    }

    public void LoginTillReachChooseAccountScreen() {
        AssertDisplayed(DX_IDM_EnterSecurityCodeTitle.isDisplayed());
        EnterSecurityCode();
        DX_IDM_ContinueCTA.click();
    }

    public void LoginTillReachChoosePlanScreen() throws ParseException {
        if (ReadResponse.getAccountIds().size() > 1) {
            waitForVisibility(DX_IDM_ChooseAccountTitle);
            DX_IDM_ContinueCTA.click();
        }
    }

    public void LoginTillReachLoginPreferenceScreen() throws ParseException {
        if (ReadResponse.getSubsList().size() > 1) {
            waitForVisibility(DX_IDM_ChoosePlanTitle);
            DX_IDM_ContinueCTA.click();
        }
    }


    public void validateUsernameScreenContent() {
        AssertDisplayed(DX_IDM_ForgotUsername.isDisplayed());
        AssertDisplayed(DX_IDM_RegisterLink.isDisplayed());
        AssertDisplayed(DX_IDM_CreateAccountLink.isDisplayed());
    }

    public void validatePasswordScreenContent() {
        waitForVisibility(DX_IDM_Password);
        AssertDisplayed(DX_IDM_ForgotPassword.isDisplayed());
        AssertDisplayed(DX_IDM_RegisterLink.isDisplayed());
        AssertDisplayed(DX_IDM_CreateAccountLink.isDisplayed());
    }

    public void ValidateRequestSecurityCodeScreenContent() {
        AssertDisplayed(DX_IDM_RequestSecurityTitle.isDisplayed());
        AssertDisplayed(DX_IDM_RequestSecuritySubTitle.isDisplayed());
//        AssertDisplayed(DX_IDM_SelectSecurityAccount.isDisplayed());
    }

    public void ValidateEnterSecurityCodeScreenContent() {
        AssertDisplayed(DX_IDM_EnterSecurityCodeTitle.isDisplayed());
    }

    public void ValidateChooseYourAccountScreenContent() throws ParseException {
        if (ReadResponse.getAccountIds().size() > 1) {
            AssertDisplayed(DX_IDM_ChooseAccountTitle.isDisplayed());
        } else throw new SkipException("Item not exist in the response");
    }

    public void ValidateChooseYourPlanScreenContent() throws ParseException {
        if (ReadResponse.getSubsList().size() > 1) {
            waitForVisibility(DX_IDM_ChoosePlanTitle);
            AssertDisplayed(DX_IDM_ChoosePlanTitle.isDisplayed());
            AssertDisplayed(DX_IDM_ChoosePlanSubTitle.isDisplayed());
            ValidateMSISDNs();
        } else throw new SkipException("Item not exist in the response");
    }

    public void ValidateLoginPreferencesScreenContent() throws InterruptedException {
        Thread.sleep(1000);
        AssertResult(DX_IDM_LoginPreferencesTitle.getText(), "Login successful");
        AssertResult(DX_IDM_LoginPreferencesSubTitle.getText(), "Speed up your log in process by setting a default method");
        AssertResult(DX_IDM_LoginPreferencesOkCTA.getText(), "OK, all done");
        AssertResult(DX_IDM_LoginPreferencesFooter.getText(), "You can manage your Login details in the app settings.");
    }

    public void ValidateLoginToMyVodafoneScreenIsDisplayed() {
        DX_IDM_X_LoginToMyVodafoneScreen.isDisplayed();
    }

    public void UsernameScreenIsDisplayed() {
        DX_IDM_Username.isDisplayed();
    }

    public void PasswordScreenIsDisplayed() {
        DX_IDM_Password.isDisplayed();
    }

    public void RequestSecurityCodeScreenIsDisplayed() {
        waitForVisibility(DX_IDM_RequestSecurityTitle);
    }

    public void ValidateTobiJourneyIsTriggered() throws InterruptedException {
        Thread.sleep(2000);
        waitForVisibility(TobiXIcon);
        TobiXIcon.click();
    }

//    public void AppSoftClose() {
//        driver.runAppInBackground(Duration.ofSeconds(3));
//    }

    public void AppHardCloseThenRelaunch() {
        killApp();
        startActivity();
    }

    public void ClickXButton() {
        DX_IDM_X_Button.click();
    }

    public void ClickOnChatToUs() {
        DX_IDM_ChatToUs.click();
    }

    public void ClickOnPhysicalBackButton() throws InterruptedException {
        Thread.sleep(5000);
        driver.navigate().back();
    }
}

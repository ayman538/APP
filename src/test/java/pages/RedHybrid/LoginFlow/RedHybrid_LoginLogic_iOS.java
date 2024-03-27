package pages.RedHybrid.LoginFlow;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testdata.ReadTestData;

import java.time.Duration;

import static utils.element_helpers.ActionsHelpers.tapAtt;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

public class RedHybrid_LoginLogic_iOS extends RedHybrid_LoginLogic_Abstract {

    String username;

    public RedHybrid_LoginLogic_iOS() {
        super();
    }

    @Override
    public void loginToMyVodafoneScreenIsDisplayed() {
        waitForVisibility(RedHybrid_SkipLoginCTA);
    }

    @Override
    public void clickOnSkipLoginButton() {

        waitForVisibility(RedHybrid_SkipLoginCTA);
        RedHybrid_SkipLoginCTA.click();
    }

    @Override
    public void disconnectWiFiAndClickContinue() {
        ((AndroidDriver) driver).toggleWifi();
        waitForVisibility(RedHybrid_WifiDisconnectedContinueCTA);
        RedHybrid_WifiDisconnectedContinueCTA.click();
    }

    @Override
    public void dashboardIsDisplayed() {
        try{
            waitForVisibility(DX_IDM_MyAccountDrawerXIcon);
            DX_IDM_MyAccountDrawerXIcon.click();
        }
        catch (Exception e){

        }
        waitForVisibility(RedHybrid_MyAccount);
    }

    @Override
    public void clickOnLoginCTA() {
        waitForVisibility(DX_IDM_LoginCTA);
        DX_IDM_LoginCTA.click();
    }

    @Override
    public void enterUsernameAndPassword() {
        waitForVisibility(RedHybrid_Username);
        username = ReadTestData.getUsername();
        RedHybrid_Username.sendKeys(username);
        waitForVisibility(RedHybrid_ContinueCTA);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(RedHybrid_ContinueCTA));
        RedHybrid_ContinueCTA.click();
        waitForVisibility(RedHybrid_Password);
        RedHybrid_Password.sendKeys("testing1");
        RedHybrid_Password_LoginCTA.click();
    }

    @Override
    public void selectAccountAndEnterSecurityCode() {
        waitForVisibility(RedHybrid_RequestSecurityTitle);
        try {
            RedHybrid_SelectSecurityAccount.click();
            Thread.sleep(1000);
            int X = driver.manage().window().getSize().width / 2;
            int Y = driver.manage().window().getSize().height - 30;
            tapAtt(X, Y);
            Thread.sleep(3000);
            IOSDoneCTAKeyBoard.click();
        } catch (Exception e) {
            System.out.println("The user has one number only2222");
        }
        RedHybrid_ContinueCTA.click();

        waitForVisibility(RedHybrid_EnterSecurityCodeTitle);
        RedHybrid_EnterSecurityCodeField1.sendKeys("1");
        RedHybrid_EnterSecurityCodeField2.sendKeys("2");
        RedHybrid_EnterSecurityCodeField3.sendKeys("3");
        RedHybrid_EnterSecurityCodeField4.sendKeys("4");
        RedHybrid_EnterSecurityCodeField5.sendKeys("5");
        RedHybrid_ContinueCTA.click();
    }

    @Override
    public void ChoseLoginPreferenceAndClickOkAllDone() {
        waitForVisibility(RedHybrid_LoginPreferencesTitle);
        RedHybrid_LoginPreferencesOkCTA.click();
    }

}

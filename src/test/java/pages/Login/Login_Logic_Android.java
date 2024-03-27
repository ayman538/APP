package pages.Login;

import org.openqa.selenium.By;
import testdata.TestData;

import static core.Config.setLoginStatusStatus;
import static utils.element_helpers.ScrollHelpers.SwipeDownForIOS;
import static utils.element_helpers.VerifyHelpers.AssertDisplayed;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

public class Login_Logic_Android extends Login_Abstract{

    public static boolean HasFaceID = false;
    private By PromptLabel = By.id("bio_Login_Description_Label");
    private By PromptBiometricCta = By.id("useBiometricsCTA");
    private By PromptNotNowCta = By.id("notNowCTA");


    public Login_Logic_Android() {
        super();
    }

    @Override
    public void LoginFlow() throws InterruptedException {
        String username = TestData.GetUserName();
        System.out.println("Wait till the login user name displayed successfully " + Login_username);
        waitForVisibility(Login_username);

        Login_username.click();
        Login_username.sendKeys(username);
        driver.navigate().back();


        Login_password.click();
        Login_password.sendKeys("testing1");
        driver.navigate().back();


        Login_CTA.click();
        System.out.println("click on login CTA");


        waitForVisibility(Pin_Field);
        System.out.println("Wait till pin field");
//        Pin_Field.sendKeys("2345");
        enterPin();
        System.out.println("Send the Pin key");
        Thread.sleep(1000);
        Pin_ContinueCTA.click();
        System.out.println("Click on the Pin Continue CTA");
        Thread.sleep(1000);
//        waitForVisibility(Pin_ReEnterField);
        System.out.println("wait pin Re-Enter filed ");
//        Pin_ReEnterField.sendKeys("2345");
        ReEnterPin();
        System.out.println("Enter the PIN ");
        Thread.sleep(1000);
        Pin_ContinueCTA2.click();
        System.out.println("click on PIN continue CTA");

        try {
            waitForVisibility(EnableTouchID_CTA);
            System.out.println("Wait till the Enable TochID CTA");
            EnableTouchID_CTA.click();
            System.out.println("Click on the Enable Touch ID CTA");
            waitForVisibility(SuccessfullLogin_DoneCTA);
            System.out.println("Wait till the Successfully login Done Screen displayed ");
            SuccessfullLogin_DoneCTA.click();
            System.out.println("Click on the successfully login done CTA ");
            HasFaceID = true;
        } catch (Exception e) {
            HasFaceID = false;
            System.out.println("The device don't have Touch ID");
        }
        setLoginStatusStatus("LoggedIn");

    }

    @Override
    public void enterPin() throws InterruptedException {
        waitForVisibility(Pin_Field1);
        Pin_Field1.sendKeys("2");
        Thread.sleep(1000);
        Pin_Field2.sendKeys("5");
        Thread.sleep(1000);
        Pin_Field3.sendKeys("8");
        Thread.sleep(1000);
        Pin_Field4.sendKeys("0");
    }

    @Override
    public void ReEnterPin() throws InterruptedException {
        waitForVisibility(Pin_ReEnterField1);
        Pin_ReEnterField1.sendKeys("2");
        Thread.sleep(1000);
        Pin_ReEnterField2.sendKeys("5");
        Thread.sleep(1000);
        Pin_ReEnterField3.sendKeys("8");
        Thread.sleep(1000);
        Pin_ReEnterField4.sendKeys("0");
    }

    @Override
    public void loginMyAccount() throws InterruptedException {
        waitForVisibility(DB_MyAccountTray_icon);
        DB_MyAccountTray_icon.click();
        LoginFlow();
    }

    @Override
    public void LoginFlow(String pinValue1, String pinValue2, String pinValue3, String pinValue4) throws InterruptedException {
        String username = TestData.GetUserName();
        System.out.println("Wait till the login user name displayed successfully " + Login_username);
        waitForVisibility(Login_username);
        Login_username.click();
        Login_username.sendKeys(username);
        driver.navigate().back();

        Login_password.click();
        Login_password.sendKeys("testing1");
        driver.navigate().back();

        Login_CTA.click();
//        scrollDown();
        waitForVisibility(Pin_Field);
//        Pin_Field.sendKeys(pinValue);
        Pin_Field1.sendKeys(pinValue1);
        Pin_Field2.sendKeys(pinValue2);
        Pin_Field3.sendKeys(pinValue3);
        Pin_Field4.sendKeys(pinValue4);
        Pin_ContinueCTA.click();
        Thread.sleep(1000);
//        scrollDown();
        waitForVisibility(Pin_ReEnterField1);
//        Pin_ReEnterField.sendKeys(pinValue);

        Pin_ReEnterField1.sendKeys(pinValue1);
        Pin_ReEnterField2.sendKeys(pinValue2);
        Pin_ReEnterField3.sendKeys(pinValue3);
        Pin_ReEnterField4.sendKeys(pinValue4);
        waitForVisibility(Pin_ContinueCTA2);
        Pin_ContinueCTA2.click();

        try {
            waitForVisibility(EnableTouchID_CTA);
            System.out.println("Wait till the Enable TochID CTA");
            EnableTouchID_CTA.click();
            System.out.println("Click on the Enable Touch ID CTA");
            waitForVisibility(SuccessfullLogin_DoneCTA);
            System.out.println("Wait till the Successfully login Done Screen displayed ");
            SuccessfullLogin_DoneCTA.click();
            System.out.println("Click on the successfully login done CTA ");
            setLoginStatusStatus("LoggedIn");
            HasFaceID = true;
        } catch (Exception e) {
            HasFaceID = false;
            System.out.println("The device don't have Touch ID");
        }

    }

    @Override
    public void loginOptions() throws InterruptedException {
        DB_SettingDashboardTray_icon.click();
        waitForVisibility(appSettingsTray);
        appSettingsTray.click();
        loginOptionsCTA.click();
        waitForVisibility(setUpYourPin_CTA);
        setUpYourPin_CTA.click();
        LoginFlow();
    }

    @Override
    public void validateLoginSwipeDown() {
        waitForVisibility(DB_MyAccountTray_icon);
        DB_MyAccountTray_icon.click();
        SwipeDownForIOS();
        waitForVisibility(DB_MyAccountTray_icon);
        AssertDisplayed(DB_MyAccountTray_icon.isDisplayed());
    }



}

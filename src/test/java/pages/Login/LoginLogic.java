//package pages.Login;
//
//import testdata.TestData;
//
//import java.io.IOException;
//
//import static core.Config.getPlatformType;
//import static core.Config.setLoginStatusStatus;
//
//public class LoginLogic extends LoginPO {
//
//    public static boolean HasFaceID = false;
//
//    public LoginLogic() {
//        super();
//    }
//
//    public void LoginFlow() throws InterruptedException, IOException {
//        String username = TestData.GetUserName();
//        System.out.println("Wait till the login user name displayed successfully " + Login_username);
//        waitForVisibility(Login_username);
//        if (getPlatformType().equalsIgnoreCase("Android"))
//            Login_username.click();
//        Login_username.sendKeys(username);
//        switch (getPlatformType().toLowerCase()) {
//            case "android":
//                driver.navigate().back();
//                break;
//            case "ios":
//                tapAtt(330, 700); // *****************************************************
//                break;
//        }
//        if (getPlatformType().equalsIgnoreCase("Android"))
//            Login_password.click();
//        Login_password.sendKeys("testing1");
//        switch (getPlatformType().toLowerCase()) {
//            case "android":
//                driver.navigate().back();
//                break;
//            case "ios":
//                tapAtt(330, 700); // *****************************************************
//                break;
//        }
//        Login_CTA.click();
//        System.out.println("click on login CTA");
////        if (getPlatformType().equalsIgnoreCase("IOS")) {
////            WebDriverWait wait = new WebDriverWait(driver, 5);
////            wait.until(ExpectedConditions.alertIsPresent());
////            Alert alert = driver.switchTo().alert();
////            alert.accept();
////        }
//        waitForVisibility(Pin_Field);
//        System.out.println("Wait till pin field");
////        Pin_Field.sendKeys("2345");
//        enterPin();
//        System.out.println("Send the Pin key");
//        Thread.sleep(1000);
//        Pin_ContinueCTA.click();
//        System.out.println("Click on the Pin Continue CTA");
//        Thread.sleep(1000);
////        waitForVisibility(Pin_ReEnterField);
//        System.out.println("wait pin Re-Enter filed ");
////        Pin_ReEnterField.sendKeys("2345");
//        ReEnterPin();
//        System.out.println("Enter the PIN ");
//        Thread.sleep(1000);
//        Pin_ContinueCTA2.click();
//        System.out.println("click on PIN continue CTA");
//
//        try {
//            waitForVisibility(EnableTouchID_CTA);
//            System.out.println("Wait till the Enable TochID CTA");
//            EnableTouchID_CTA.click();
//            System.out.println("Click on the Enable Touch ID CTA");
//            waitForVisibility(SuccessfullLogin_DoneCTA);
//            System.out.println("Wait till the Successfully login Done Screen displayed ");
//            SuccessfullLogin_DoneCTA.click();
//            System.out.println("Click on the successfully login done CTA ");
//            HasFaceID = true;
//        } catch (Exception e) {
//            HasFaceID = false;
//            System.out.println("The device don't have Touch ID");
//        }
//        setLoginStatusStatus("LoggedIn");
//
//    }
//
//    public void enterPin() throws InterruptedException {
//        waitForVisibility(Pin_Field1);
//        Pin_Field1.sendKeys("2");
//        Thread.sleep(1000);
//        Pin_Field2.sendKeys("3");
//        Thread.sleep(1000);
//        Pin_Field3.sendKeys("4");
//        Thread.sleep(1000);
//        Pin_Field4.sendKeys("5");
//    }
//
//    public void ReEnterPin() throws InterruptedException {
//        waitForVisibility(Pin_ReEnterField1);
//        Pin_ReEnterField1.sendKeys("2");
//        Thread.sleep(1000);
//        Pin_ReEnterField2.sendKeys("3");
//        Thread.sleep(1000);
//        Pin_ReEnterField3.sendKeys("4");
//        Thread.sleep(1000);
//        Pin_ReEnterField4.sendKeys("5");
//    }
//
///*
//    public static WebElement Login_username() {
//        return Login_username;
//    }
//
//    public static WebElement Login_Xicon() {
//        return Login_Xicon;
//    }
//
//    public static WebElement Pin_Field() {
//        return Pin_Field;
//    }
//
//    public static WebElement Pin_ContinueCTA() {
//        return Pin_ContinueCTA;
//    }
//
//    public static WebElement ForgottenUsername_Hyperlink() {
//        return ForgottenUsername_Hyperlink;
//    }
//
//    public static WebElement ForgottenPassword_Hyperlink() {
//        return ForgottenPassword_Hyperlink;
//    }
//
//    public static WebElement MemorableWordField() {
//        return MemorableWordField;
//    }
//
//    public static WebElement ResetYourPasswordTitle() {
//        return ResetYourPasswordTitle;
//    }
//
//    public static WebElement EnterUsernameField() {
//        return EnterUsernameField;
//    }
//
//    public static WebElement ResetPasswordCTA() {
//        return ResetPasswordCTA;
//    }
//    */
//
//    public void loginMyAccount() throws InterruptedException, IOException {
//        waitForVisibility(DB_MyAccountTray_icon);
//        DB_MyAccountTray_icon.click();
//        LoginFlow();
//    }
//
//    public void LoginFlow(String pinValue1, String pinValue2, String pinValue3, String pinValue4) throws InterruptedException, IOException {
//        String username = TestData.GetUserName();
//        System.out.println("Wait till the login user name displayed successfully " + Login_username);
//        waitForVisibility(Login_username);
//        if (getPlatformType().equalsIgnoreCase("Android"))
//            Login_username.click();
//        Login_username.sendKeys(username);
//        switch (getPlatformType().toLowerCase()) {
//            case "android":
//                driver.navigate().back();
//                break;
//            case "ios":
//                tapAtt(330, 700); // *****************************************************
//                break;
//        }
//        if (getPlatformType().equalsIgnoreCase("Android"))
//            Login_password.click();
//        Login_password.sendKeys("testing1");
//        switch (getPlatformType().toLowerCase()) {
//            case "android":
//                driver.navigate().back();
//                break;
//            case "ios":
//                tapAtt(330, 700); // *****************************************************
//                break;
//        }
//        Login_CTA.click();
////        scrollDown();
//        waitForVisibility(Pin_Field);
////        Pin_Field.sendKeys(pinValue);
//        Pin_Field1.sendKeys(pinValue1);
//        Pin_Field2.sendKeys(pinValue2);
//        Pin_Field3.sendKeys(pinValue3);
//        Pin_Field4.sendKeys(pinValue4);
//        Pin_ContinueCTA.click();
//        Thread.sleep(1000);
////        scrollDown();
//        waitForVisibility(Pin_ReEnterField1);
////        Pin_ReEnterField.sendKeys(pinValue);
//
//        Pin_ReEnterField1.sendKeys(pinValue1);
//        Pin_ReEnterField2.sendKeys(pinValue2);
//        Pin_ReEnterField3.sendKeys(pinValue3);
//        Pin_ReEnterField4.sendKeys(pinValue4);
//        waitForVisibility(Pin_ContinueCTA2);
//        Pin_ContinueCTA2.click();
//
//        try {
//            waitForVisibility(EnableTouchID_CTA);
//            System.out.println("Wait till the Enable TochID CTA");
//            EnableTouchID_CTA.click();
//            System.out.println("Click on the Enable Touch ID CTA");
//            waitForVisibility(SuccessfullLogin_DoneCTA);
//            System.out.println("Wait till the Successfully login Done Screen displayed ");
//            SuccessfullLogin_DoneCTA.click();
//            System.out.println("Click on the successfully login done CTA ");
//            setLoginStatusStatus("LoggedIn");
//            HasFaceID = true;
//        } catch (Exception e) {
//            HasFaceID = false;
//            System.out.println("The device don't have Touch ID");
//        }
//
//    }
//
//    public void loginOptions() throws InterruptedException, IOException {
//        DB_SettingDashboardTray_icon.click();
//        waitForVisibility(appSettingsTray);
//        appSettingsTray.click();
//        loginOptionsCTA.click();
//        waitForVisibility(setUpYourPin_CTA);
//        setUpYourPin_CTA.click();
//        LoginFlow();
//    }
//
//
//    public void validateLoginSwipeDown() {
//        waitForVisibility(DB_MyAccountTray_icon);
//        DB_MyAccountTray_icon.click();
//        SwipeDownForIOS();
//        waitForVisibility(DB_MyAccountTray_icon);
//        AssertDisplayed(DB_MyAccountTray_icon.isDisplayed());
//    }
//
//}

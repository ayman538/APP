package pages.RedHybrid.DashboardTray;

import org.testng.Assert;
import pages.DX_IDM.FullLogin.DX_IDM_FullLoginPO;
import pages.RedHybrid.LoginFlow.RedHybrid_Login_PO;
import pages.RedHybrid.PaymentMethod.RedHybrid_AddNewPaymentPO;
import pages.Tray.MyAccount.MyAccountPO;
import testdata.ReadTestData;

import static utils.element_helpers.VerifyHelpers.*;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

public class RedHybrid_DashboardTray_Android extends RedHybrid_DashboardTray_Abstract{

    String username= ReadTestData.getUsername();
    RedHybrid_AddNewPaymentPO obj = new RedHybrid_AddNewPaymentPO();
    DX_IDM_FullLoginPO obj2 = new DX_IDM_FullLoginPO();
    MyAccountPO obj3 = new MyAccountPO();
    RedHybrid_Login_PO obj4 = new RedHybrid_Login_PO();


    @Override
    public void validateTrayItems() {
        waitForVisibility(DB_MyAccountTray_icon);
        AssertResult(DB_MyAccountTray_icon.getText(), "My Account");
        System.out.println("My account is displayed in tray");
        waitForVisibility(DB_VeryMeTray);
        AssertResult(DB_VeryMeTray.getText(), "VeryMe");
        System.out.println("Veryme is displayed in tray");
        AssertDisplayed(DB_TobiTray_icon.isDisplayed());
        System.out.println("TOBi is here");
        waitForVisibility(DB_PaymentsTray);
        AssertResult(DB_PaymentsTray.getText(), "Payments");
        System.out.println("Payments is displayed in tray");
        waitForVisibility(RH_AppSettingsTray);
        AssertResult(RH_AppSettingsTray.getText(), "Settings");
        System.out.println("Settings is displayed in tray");
    }

    @Override
    public void checkTargetOfMyAccount() throws InterruptedException {
        waitForVisibility(DB_MyAccountTray_icon);
        DB_MyAccountTray_icon.click();
        Thread.sleep(5000);
        try{
            loginFlow();
        }catch (Exception e){
            System.out.println("User is Logged in to the App");
        }
        AssertDisplayed(obj3.MyAccTitle.isDisplayed());
        System.out.println("Pass");
    }

    @Override
    public void checkTargetOfVeryMe() throws InterruptedException {
        waitForVisibility(DB_VeryMeTray);
        DB_VeryMeTray.click();
        Thread.sleep(5000);
        AssertDisplayed(VerymeView.isDisplayed());
        System.out.println("Veryme is opened");
    }

    @Override
    public void acceptCookies() {
        try {
            waitForVisibility(AcceptCookies);
            AcceptCookies.click();
        } catch (Exception e)
        {
            //doNothing
        }
    }

    @Override
    public void checkTargetOfTOBi() throws InterruptedException {
        waitForVisibility(DB_TobiTray_icon);
        DB_TobiTray_icon.click();
        acceptCookies();
        waitForVisibility(TobiXIcon);
        AssertDisplayed(TobiXIcon.isDisplayed());
        System.out.println("Tobi is opened");
        TobiXIcon.click();
        waitForVisibility(TOBi_EndChat);
        TOBi_EndChat.click();
        waitForVisibility(DB_TobiTray_icon);
    }
    @Override
    public void CloseTobi() throws InterruptedException {
        TobiXIcon.click();
        waitForVisibility(TOBi_EndChat);
        TOBi_EndChat.click();
        waitForVisibility(DB_TobiTray_icon);
    }
    @Override
    public void checkTargetOfPayments() throws InterruptedException {
        try{
            loginFlow();
        }catch (Exception e){
            System.out.println("User is Logged in to the App");
        }
        waitForVisibility(RedHybrid_PaymentTitle_2);
        AssertDisplayed(RedHybrid_PaymentTitle_2.isDisplayed());
        RedHybrid_PaymentXIcon.click();
    }

    public void clickOnPaymentTray(){
        waitForVisibility(DB_PaymentsTray);
        DB_PaymentsTray.click();
    }

    @Override
    public void checkTargetOfSettings() {
        waitForVisibility(RH_AppSettingsTray);
        RH_AppSettingsTray.click();
        AssertDisplayed(DB_SettingsDrawerCloseButton.isDisplayed());
        System.out.println("Settings is opened");
        DB_SettingsDrawerCloseButton.click();
    }

    public void loginFlow() throws InterruptedException {
        try {
            //if (AcceptCookies.isDisplayed() || DX_IDM_Username.isDisplayed()) {
            acceptCookies();
            waitForVisibility(DX_IDM_Username);
            System.out.println(username);
            DX_IDM_Username.sendKeys(username);
            //Thread.sleep(1000);
            DX_IDM_ContinueCTA.click();
            waitForVisibility(DX_IDM_Password);
            DX_IDM_Password.sendKeys("testing1");
            DX_IDM_PasswordLoginCTA.click();
            //Thread.sleep(5000);
            waitForVisibility(obj2.DX_IDM_LoginPreferencesTitle);
            obj2.DX_IDM_LogPrefPassword.click();
            obj2.DX_IDM_LoginPreferencesOkCTA.click();
            Thread.sleep(5000);
            // }
        }catch (Exception e)
        {
            System.out.println("user already logged");
            waitForVisibility(DX_IDM_Password);
            DX_IDM_Password.sendKeys("testing1");
            DX_IDM_PasswordLoginCTA.click();
        }
    }

    public void DismissSkipLoginScreen(){
        try {
               obj4.RedHybrid_SkipLoginCTA.click();
        }catch (Exception e)
        {
            System.out.println("catch");
        }
    }

    @Override
    public void clickOnMyAccount() throws InterruptedException {
        waitForVisibility(DB_MyAccountTray_icon);
        DB_MyAccountTray_icon.click();
        Thread.sleep(5000);
        try{
            loginFlow();
        }catch (Exception e){
            System.out.println("User is Logged in to the App");
        }
    }

    @Override
    public void clickOnMyAccountTray() throws InterruptedException {
        waitForVisibility(DB_MyAccountTray_icon);
        DB_MyAccountTray_icon.click();
        Thread.sleep(5000);
    }

    @Override
    public void clickOnSettings() {
        waitForVisibility(RH_AppSettingsTray);
        RH_AppSettingsTray.click();
        System.out.println("Settings is opened");
    }

    @Override
    public void validateThatTheDashboardTrayHiddenUnderMyAccount() {
        waitForVisibility(selctOne);
        HardAssertNotDisplayed("My Account", elementIsPresent(DB_MyAccountTray_icon));
    }


    @Override
    public void validateThatTheDashboardTrayHiddenUnderPayments() {
        waitForVisibility(Payment_method_icon);
        HardAssertNotDisplayed("My Account", elementIsPresent(DB_MyAccountTray_icon));


    }

    @Override
    public void OpenTobiAndSendMessage(String Message) {
        waitForVisibility(DB_TobiTray_icon);
        DB_TobiTray_icon.click();
        acceptCookies();
        AssertDisplayed(TobiXIcon.isDisplayed());
        System.out.println("Tobi is opened");
        waitForVisibility(TobiChatBox);
        TobiChatBox.click();
        TobiChatBox.sendKeys(Message);
        TobiSendButton.click();
    }

    @Override
    public void CheckTobiResponse(String message) {
        waitForVisibility(TobiMessageResponse);
        Assert.assertTrue(TobiMessageResponse.getText().contains(message));
        System.out.println(TobiMessageResponse.getText());
    }

    @Override
    public void validateThatTheDashboardTrayHiddenUnderSettings() {
        waitForVisibility(offersImageView);
        waitForVisibility(DB_SettingsDrawerCloseButton);
        HardAssertNotDisplayed("My Account", elementIsPresent(DB_MyAccountTray_icon));
    }

    @Override
    public void clickOnPayment() throws InterruptedException {
        waitForVisibility(DB_PaymentsTray);
        DB_PaymentsTray.click();
        try{
            loginFlow();
        }catch (Exception e){
            System.out.println("User is Logged in to the App");
        }
    }
}

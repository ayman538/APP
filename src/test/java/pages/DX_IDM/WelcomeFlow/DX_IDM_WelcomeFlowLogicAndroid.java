package pages.DX_IDM.WelcomeFlow;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.DX_IDM.FullLogin.DX_IDM_FullLoginLogic;
import pages.DX_IDM.FullLogin.DX_IDM_FullLoginPO;
import pages.DX_IDM.UFL.DX_IDM_UFLLogic;
import pages.DX_IDM.UFL.DX_IDM_UFL_Android;
import utils.BeFlagConfigUtils;

import java.util.List;
import java.util.Properties;

import static utilities.PropertiesLoader.readPropertyFile;
import static utils.element_helpers.DriverHelps.killApp;
import static utils.element_helpers.DriverHelps.startActivity;
import static utils.element_helpers.ScrollHelpers.*;
import static utils.element_helpers.VerifyHelpers.*;
import static utils.element_helpers.WaitHelpers.*;

public class DX_IDM_WelcomeFlowLogicAndroid extends DX_IDM_WelcomeFlowLogicAbstract {

    DX_IDM_FullLoginPO loginObject;
    DX_IDM_UFLLogic UFL_Logic;
    DX_IDM_FullLoginLogic FL_Logic;
    TouchAction touchAction = new TouchAction((PerformsTouchActions) driver);
    Properties envProp = readPropertyFile("config/env.properties");
    boolean BeFlag=BeFlagConfigUtils.getBeFlagConfigFlag();
    public DX_IDM_WelcomeFlowLogicAndroid() {
        super();
        UFL_Logic = new DX_IDM_UFLLogic();
    }

    @Override
    public void beforeWelcomeScreen() {
        waitForVisibility(DX_IDM_WelcomeTitle);
    }

    @Override
    public void validateWelcomeScreenContent() {
        AssertResult(DX_IDM_WelcomeTitle.getText(), "Welcome to My Vodafone");
        AssertResult(DX_IDM_WelcomeContinueCTA.getText(), "Continue");
        DX_IDM_WelcomeContinueCTA.click();
    }

    @Override
    public void beforePrivacyScreen() {
        waitForVisibility(DX_IDM_PrivacyScreenTitle);
    }

    @Override
    public void validatePrivacyScreenContent() {
        AssertResult(DX_IDM_PrivacyScreenTitle.getText(), "Before we get\nyou started...");
        AssertResult(DX_IDM_PrivacyAndTerms.getText(), "I agree to the App Privacy\nSupplement and Terms & Conditions");
        AssertDisplayed(DX_IDM_PrivacyAndTermsToggle.isDisplayed());
        AssertResult(DX_IDM_PrivacyScreenContinueCTA.getText(), "Continue");
    }

    @Override
    public void validatePrivacyScreenFunc() {
        DX_IDM_PrivacyScreenContinueCTA.click();
        AssertResult(DX_IDM_PrivacyAndTermsToggleMessage.getText(), "Please agree to the Terms and\nConditions before continuing");

        DX_IDM_PrivacyAndTermsToggle.click();
        DX_IDM_PrivacyScreenContinueCTA.click();
    }

    @Override
    public void beforePermissionScreen() {
        waitForVisibility(DX_IDM_PermissionScreenTitle);
    }

    @Override
    public void validatePermissionScreenContent() {
        AssertResult(DX_IDM_PermissionScreenTitle.getText(), "One last thing");
        AssertResult(DX_IDM_PermissionScreenSubTitle.getText(), "To get the most from the My Vodafone App,\nwe'd like to ask for some permissions");
        AssertResult(DX_IDM_PermissionScreenContinueCTA.getText(), "Continue");
        DX_IDM_PermissionScreenContinueCTA.click();
    }

    @Override
    public void beforeUsageAccessPopup(){ waitForVisibility(DX_IDM_UsageAccessPopupTitle);}
    @Override
    public void validateUsageAccessPopupContent(){
        AssertResult(DX_IDM_UsageAccessPopupTitle.getText(), "Usage Access");
        AssertResult(DX_IDM_UsageAccessPopupMessage.getText(), "MyVodafone App collects usage data of your apps even when the app is closed or not in use. We at MyVodafone App determine how fast each app performs on mobile and Wi-Fi. For this we need access to the data statistics of your smartphone.");
        DX_IDM_NoThanksPermission.click();
    }

    public void closePermission() {
        waitForVisibility(DX_IDM_NoThanksPermission);
        DX_IDM_NoThanksPermission.click();
    }

    @Override
    public void acceptAlert() {
        Alert alert;
        alert = driver.switchTo().alert();
        alert.accept();
    }

    @Override
    public void beforeLoginScreen() {
        if (elementIsPresent(DX_IDM_LocationPermission)) {
            DX_IDM_LocationPermission.click();
            waitForVisibility(DX_IDM_PhonePermission);
            DX_IDM_PhonePermission.click();}
        waitForVisibility(DX_IDM_NoThanksPermission);
        DX_IDM_NoThanksPermission.click();
    }

    @Override
    public void validateLoginScreenContent() {
        waitForVisibility(DX_IDM_LoginScreenTitle);
        AssertResult(DX_IDM_LoginScreenTitle.getText(), "Log in to My Vodafone");
        AssertResult(DX_IDM_LoginScreenBody.getText(), "Log in to access My Vodafone. If you’re using a Vodafone SIM card, you can skip this step for a faster log-in.");
        AssertResult(DX_IDM_LoginCTA.getText(), "Log In");
        AssertResult(DX_IDM_SkipLoginCTA.getText(), "Skip Login");
    }

    @Override
    public void dxIDMWelcomeFlow() {
        double appVersion = Double.parseDouble(envProp.getProperty("AppVersion"));
        if (BeFlag = true && appVersion >= 10.51){
            waitForVisibilityForReinvent(DX_IDM_WelcomeTitle, 60);
            New_DX_IDM_ContinueCTA.click();
            waitForVisibilityForReinvent(DX_IDM_PrivacyScreenTitle, 60);
            waitForVisibility(DX_IDM_PrivacyAndTermsToggle);
            DX_IDM_PrivacyAndTermsToggle.click();
            New_DX_IDM_ContinueCTA.click();
            waitForVisibility(weValueYourPrivacyTitle);
            acceptAllCookiesCTA.click();
            waitForVisibility(DX_IDM_NetworkandServiceTitle);
            DX_IDM_NetworkImprovementsToggleOFF.click();
            waitForVisibility(DX_IDM_NetworkImprovementsToggleON);
            New_DX_IDM_ContinueCTA.click();
            if (elementIsPresent(DX_IDM_GettheBestExperienceTitle)){
                New_DX_IDM_ContinueCTA.click();
            }
            else {
                System.out.println("Permissions granted already");
            }
        }
        else {
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
            try {
                waitForVisibility(DX_IDM_PermissionScreenTitle);
                DX_IDM_PermissionScreenContinueCTA.click();
                beforeLoginScreen();
            }
            catch (Exception e)
            { System.out.println("App not first installation");}
        }
        //I commented this because sometimes it redirects user to only "Return to My Vodafone"
           /* if (System.getProperty("isLiveTest", envProp.getProperty("isLiveTest")).equalsIgnoreCase("false")){
                if (!System.getProperty("Segment", envProp.getProperty("Segment")).equalsIgnoreCase("PREPAY") && !(System.getProperty("Segment", envProp.getProperty("SubscriptionType")).equalsIgnoreCase("HYBRID"))) {
                    if (!System.getProperty("UnknownUser", envProp.getProperty("UnknownUser")).equalsIgnoreCase("true")) {
                        waitForVisibilityForReinvent(DX_IDM_LoginCTA, 60);
                    }
                }
            }*/
    }


    @Override
    public void dxIdmVOXIScreenContent() {
        waitForVisibility(DX_IDM_VOXISignINURL);
        AssertDisplayed(DX_IDM_VOXISignINURL.isDisplayed());
        AssertDisplayed(DX_IDM_VOXIReturnToMyVodafoneCTA.isDisplayed());
    }

    @Override
    public void clickOnReturnToMyVodafoneCTA() {
        waitForVisibility(DX_IDM_VOXIReturnToMyVodafoneCTA);
        DX_IDM_VOXIReturnToMyVodafoneCTA.click();
    }
    @Override
    public void clickOnXIcon() {
        DX_IDM_VOXIReturnToMyVodafoneCTA.click();
    }

    @Override
    public void clickOnTobiIcon() {
        DX_IDM_VOXITobiIcon.click();
    }

    @Override
    public void validateTobiContentScreen() {
        AssertDisplayed(DX_IDM_VOXITobiContentScreen.isDisplayed());
    }

    @Override
    public void clickOnSettingsDrawer() {
        DX_IDM_VOXISettingDrawer.click();
    }

    @Override
    public void validateAppAndPrivacySettingsDisplayed() {
        waitForVisibility(DX_IDM_VOXIAppSettingDrawer);
        AssertDisplayed(DX_IDM_VOXIAppSettingDrawer.isDisplayed());
        AssertDisplayed(DX_IDM_VOXIPrivacySettingDrawer.isDisplayed());
    }

    @Override
    public void clickOnVOXIMyAccountDrawer() {
        try {
            waitForVisibility(DX_IDM_VOXIMyAccountDrawer);
            DX_IDM_VOXIMyAccountDrawer.click();
        }catch (Exception e){
            System.out.println("My account drawer is already opened");
        }
    }

    @Override
    public void validateLoginToMyVodafoneUsername() {
        loginObject = new DX_IDM_FullLoginPO();
        waitForVisibility(loginObject.DX_IDM_Username);
        AssertDisplayed(loginObject.DX_IDM_Username.isDisplayed());
    }

    @Override
    public void dxIdmSMEScreenContent() {
        waitForVisibility(DX_IDM_HelloFriendTitle);
        AssertResult(DX_IDM_HelloFriendTitle.getText(), "Hello, friend!");
        AssertResult(DX_IDM_HelloFriendReturnToMyVodafoneCTA.getText(), "Return to My Vodafone");
        assertElementDoesNotExist(DX_IDM_HelloFriendLoginCTA);
        AssertResult(DX_IDM_HelloFriendBody.getText(), "The My Vodafone app doesn’t currently support the plan connected with your device’s SIM card.\n" +
                "\n" +
                "If you have another Vodafone service you’d like to manage, you can log in via the My Account page.");
        //AssertDisplayed(DX_IDM_HelloFriendBody.getText().contains("If you have another Vodafone service like to manage, you can log in via the My Account page."));
        //AssertResult(DX_IDM_HelloFriendBody.getText(), "My Vodafone app doesn’t currently support the plan connected with your device’s SIM card. If you have another Vodafone service you’d like to manage, you can log in via the My Account page.");
    }

    @Override
    public void TapOnXIconInHelloFriendScreen() {
        waitForVisibility(DX_IDM_HelloFriendXIcon);
        DX_IDM_HelloFriendXIcon.click();
//        AcquisitionBoardPO acq = new AcquisitionBoardPO();
//        waitForVisibility(acq.Acquisition_NewDB_Xicon);
//        AssertDisplayed(acq.Acquisition_NewDB_Xicon.isDisplayed());
    }

    @Override
    public void ValidateHelloFriendScreenContentWithUnknownUser() {
        waitForVisibility(DX_IDM_HelloFriendTitle);
        AssertResult(DX_IDM_HelloFriendTitle.getText(), "Hello, friend!");
        //AssertResult(DX_IDM_HelloFriendBody.getText(), "Log in to My Vodafone to view your current charges and usage, view and pay your bill, manage your extras and more.\n" +
                //"\n" +
               // "If you’d prefer, you can always log in via the My Account page later.");
        AssertDisplayed(DX_IDM_HelloFriendBody.getText().contains("Log in to My Vodafone to view your current charges and usage, view and pay your bill, manage your extras and more"));
        AssertResult(DX_IDM_HelloFriendLoginCTA.getText(), "Log in");
        AssertResult(DX_IDM_HelloFriendReturnToMyVodafoneCTA.getText(), "Return to My Vodafone");
    }

    @Override
    public void ClickOnReturnToVodafoneCTAWithUnknownUser() {
        waitForVisibility(DX_IDM_HelloFriendReturnToMyVodafoneCTA);
        DX_IDM_HelloFriendReturnToMyVodafoneCTA.click();
    }

    @Override
    public void AppHardCloseInHelloFriendScreenThenRelaunch() {
        killApp();
        startActivity();
    }

    @Override
    public void ClickOnLoginCTAWithUnknownUser() {
        waitForVisibility(DX_IDM_HelloFriendLoginCTA);
        DX_IDM_HelloFriendLoginCTA.click();
    }

    @Override
    public void UFLJourneyIsTriggeredTillReachDashboard() throws ParseException, InterruptedException {
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

    @Override
    public void AcquisitionScreenIsDisplayed() {
        waitForVisibility(DX_IDM_AcquisitionScreenHeaderTitle);
        AssertResult(DX_IDM_AcquisitionScreenHeaderTitle.getText(), "Vodafone Together");
        AssertResult(DX_IDM_AcquisitionScreenHeaderBody.getText(), "Unlimited home broadband and unlimited mobile data in one great deal.");

    }

    @Override
    public void acceptCookies() {
        waitForVisibility(AcceptCookies);
        AcceptCookies.click();
    }

    public void ValidateWelcomeScreenOpened(){
        waitForVisibility(DevSett_VodafoneLogoIcon);
        AssertResult(DX_IDM_WelcomeTitle.getText(),"Welcome to\n" +
                "My Vodafone");
        waitForVisibility(DX_IDM_WelcomeTextBody);
        AssertResult(DX_IDM_WelcomeTextBody.getText(),"Keep track of your bills, usage, get rewards and more.");
        assertDisplayed(New_DX_IDM_ContinueCTA,60);
    }
    public void clickOnContinueCTAWelcomeScreens() {
        waitForVisibility(New_DX_IDM_ContinueCTA);
        New_DX_IDM_ContinueCTA.click();
    }
    public void validateBeforeYouGetStartedScreenOpened(){
        waitForVisibility(DX_IDM_PrivacyScreenTitle);
        AssertResult(DX_IDM_PrivacyScreenTitle.getText(),"Before you get\n" +
                "started");
    }
    public void validateBeforeYouGetStartedScreen(){
        waitForVisibility(DevSett_VodafoneLogoIcon);
        AssertResult(DX_IDM_PrivacyScreenTitle.getText(),"Before you get\n" +
                "started");
        AssertResult(DX_IDM_TermsandConditionsAgreeToggleMsg.getText(),"Please agree to our Terms and Conditions");
        AssertDisplayed(DX_IDM_BeforeYouGetStartedBody.getText().contains("We store certain information to improve the app and give you the best experience.\n" +
                "\n" +
                "App Privacy Supplement"));
        assertDisplayed(New_DX_IDM_ContinueCTA,60);
    }
    public void validateTermsandConditionsPopup(){
        waitForVisibility(DX_IDM_termsandConidtionsPopup);
        AssertResult(DX_IDM_termsandConidtionsPopup.getText(),"Please agree to the Terms and\n" +
                "Conditions before continuing");
    }
    public void toggleOnTermsandConditions() {
        waitForVisibility(DX_IDM_PrivacyAndTermsToggle);
        DX_IDM_PrivacyAndTermsToggle.click();
    }
    public void clickOnBackCTA(){
        waitForVisibility(DX_IDM_BackCTA);
        DX_IDM_BackCTA.click();
    }
    public void weValueYourPrivacyScreen() {
        waitForVisibility(weValueYourPrivacyTitle);
        Assert.assertTrue(cookiePolicyDescription.getText().contains("Accept all cookies below, or select \"Manage Cookies\" to choose which cookies we can use."));
        AssertDisplayed(cookiePolicyLink_Android.isDisplayed());
        AssertDisplayed(acceptAllCookiesCTA.isDisplayed());
        AssertDisplayed(manageCookiesCTA.isDisplayed());
    }
    public void TermsAndConditionsLink() {
        DX_IDM_TermsandConditionsAgreeToggleMsg.click();
    }
    public void TermsAndConditionsScreen() {
        waitForVisibility(DX_IDM_termsAndConditionsScreenTitle);
        AssertDisplayed(DX_IDM_TAndCAgreement.isDisplayed());
        AssertDisplayed(DX_IDM_okCtaTAndCsScreen.isDisplayed());
    }
    public void clickOkCtaTermsAndConditionsScreen() {
        DX_IDM_okCtaTAndCsScreen.click();
    }

    public void OpenCookiePermissions(){
        waitForVisibility(manageCookiesCTA);
        manageCookiesCTA.click();
    }

    public void validateNavigationToCookiePermissions(){
        waitForVisibility(CookiePermissionsTitle);
        AssertResult(DX_IDM_welcomeFlowTitle.getText(),"Cookie Permissions");
    }

    public void validateCookiePermissionsScreen(String enteryPoint){
        ValidateCommonUIOfCookiePermissions();

        switch (enteryPoint){
            case "welcomeflow":{
                AssertDisplayed(AcceptAllCTA.isDisplayed());
                AssertDisplayed(RejectAllCTA.isDisplayed());
                AssertDisplayed(New_DX_IDM_ContinueCTA.isDisplayed());

                // Assert that there are 3 turned off toggles by default
                List<WebElement> toggels = driver.findElements(By.id("com.myvodafoneapp:id/card_toggle"));
                Assert.assertEquals(toggels.size(),3);
                for(int i=0;i< toggels.size();i++)
                {
                    AssertResult(toggels.get(i).getText(),"OFF");
                }
                break;
            }
            case "settings":{
                AssertDisplayed(!IsElementDisplayed(AcceptAllCTA));
                AssertDisplayed(!IsElementDisplayed(RejectAllCTA));
                AssertDisplayed(!IsElementDisplayed(New_DX_IDM_ContinueCTA));
                break;
            }
            default:
                System.out.println("invalid entery point");
                break;
        }
    }

    public void ValidateCommonUIOfCookiePermissions(){
        waitForVisibility(CookiePermissionsTitle);
        AssertResult(DX_IDM_welcomeFlowTitle.getText(),"Cookie Permissions");
        AssertDisplayed(ManageCookiesBack.isDisplayed());
        AssertResult(CookiePermissionsTitle.getText(),"Manage cookie permissions");
        AssertDisplayed(StrictlyNecessaryCard.isDisplayed());
        AssertDisplayed(FunctionalCookieCard.isDisplayed());
        AssertDisplayed(PerformanceCookieCard.isDisplayed());
        AssertDisplayed(TargetingCookieCard.isDisplayed());
        AssertDisplayed(AlwaysActiveLozenge.isDisplayed());
        AssertResult(AlwaysActiveLozenge.getText(),"Always active");

        // Assert that there are 4 chevrons
        List<WebElement> chevrons = driver.findElements(By.id("com.myvodafoneapp:id/card_arrow"));
        Assert.assertEquals(chevrons.size(),4);
    }

    public void ClickOnBackInCookiePerms(){
        waitForVisibility(ManageCookiesBack);
        ManageCookiesBack.click();
    }

    public void ToggleOnOffAllCookies(){
        Toggle_Cookie("Performance","ON");
        Toggle_Cookie("Functional","ON");
        Toggle_Cookie("Targeting","ON");

        Toggle_Cookie("Performance","OFF");
        Toggle_Cookie("Functional","OFF");
        Toggle_Cookie("Targeting","OFF");
    }
    public void expandAndCollapseAllCookies(){
        List<WebElement> chevrons = driver.findElements(By.id("com.myvodafoneapp:id/card_arrow"));
        WebElement [] CookiesElements = {StrictlyNecessaryCard,PerformanceCookieCard,FunctionalCookieCard,TargetingCookieCard};
        String [] CookiesCopies = {"These cookies are necessary for the app to function and cannot be switched off in our systems. They are usually only set in response to actions made by you which amount to a request for services, such as setting your privacy preferences, logging in or filling in forms. ",
        "These cookies allow us to count visits and traffic sources so we can measure and improve the performance of our app. They help us to know which pages are the most and least popular and see how visitors move around the app. All information these cookies collect is aggregated and therefore anonymous. If you do not allow these cookies we will not know when you have visited our app, and will not be able to monitor its performance.",
        "These cookies enable the app to provide enhanced functionality and personalisation. They may be set by us or by third party providers whose services we have added to our pages. If you do not allow these cookies then some or all of these services may not function properly.",
        "We use these to help us to show you relevant offers and advertising content, and to tailor messages we send you. They can also be used to share some information with third parties who we advertise with. They only store information that uniquely identifies your app and do not store any personal data. Some of this targeted content may require the use of your location. By opting out of targeting cookies, you may not receive the best offers or content experience."};

        for(int i =0;i< chevrons.size();i++){
            chevrons.get(i).click();
            AssertDisplayed(CookieDesc.isDisplayed());
            AssertResult(CookieDesc.getText(), CookiesCopies[i]);
            System.out.println("cookie "+(i+1)+" copy is verified");
            CookiesElements[i].click();
            HardAssertNotDisplayed("com.myvodafoneapp:id/card_content",false);
        }

    }
    public void Toggle_Cookie(String cookie,String state){
        List<WebElement> toggels = driver.findElements(By.id("com.myvodafoneapp:id/card_toggle"));
        int j = 0;
        if(!((state.equals("ON")) || (state.equals("OFF")))) {
            System.out.println("state is wrong");
            Assert.assertTrue((state.equals("ON")) || (state.equals("OFF")));
        }
        switch (cookie){
            case "Performance":
                j=0;
                break;
            case "Functional":
                j=1;
                break;
            case "Targeting":
                j=2;
                break;
            default:
                System.out.println("Cookie name is wrong");
                break;
        }
        if(!(toggels.get(j).getText().equalsIgnoreCase(state))){
            toggels.get(j).click();
        }
        Assert.assertTrue(toggels.get(j).getText().equalsIgnoreCase(state));
    }

    public void ValidateValueOfCookie(String cookie, String value){
        List<WebElement> toggels = driver.findElements(By.id("com.myvodafoneapp:id/card_toggle"));
        int j = 0;
        if(!((value.equals("ON")) || (value.equals("OFF")))) {
            System.out.println("state is wrong");
            Assert.assertTrue((value.equals("ON")) || (value.equals("OFF")));
        }
        switch (cookie){
            case "Performance":
                j=0;
                break;
            case "Functional":
                j=1;
                break;
            case "Targeting":
                j=2;
                break;
            default:
                System.out.println("Cookie name is wrong");
                break;
        }
        Assert.assertTrue(toggels.get(j).getText().equalsIgnoreCase(value));
    }

    public void ClickOnAppPrivacySupplementLink() {
        Point point = AppPrivacySupplementLink.getLocation();
        int x = (int) (point.getX() + (0.01 * AppPrivacySupplementLink.getSize().width));
        int y = point.getY() + AppPrivacySupplementLink.getSize().height - 10 ;

        TouchAction touchAction = new TouchAction((PerformsTouchActions) driver);
        touchAction.tap(PointOption.point(x,y)).perform();
    }

    public void ValidateAppPrivacySupplementScreen() {
        waitForVisibility(AppAppPrivacySupplementHeader);
        Assert.assertEquals(AppAppPrivacySupplementHeader.getText(),"App Privacy Supplement");
        AssertDisplayed(DX_IDM_BackCTA.isDisplayed());
        AssertResult(AppPrivacySupplementTitle.getText(),"My Vodafone App");
        AssertResult(AppPrivacySupplementSubTitle.getText(),"To provide you with features of My Vodafone, VeryMe Rewards send you personalised recommendations, and help improve our products and services, My Vodafone will share certain information from your device within our company. This privacy supplement explains the information that is collected by My Vodafone and how it will be used. For further information on our privacy policy please see our main privacy policy page");
        String [] cards_titles = {
                "Information we collect","Usage of My Vodafone app",
                "Information we don","How we use this information",
                "What choices do you have","How do you protect my data","How long do you keep my data"};

        for (int i = 0; i < cards_titles.length; i++){
            By CardTitle = By.xpath("//*[contains(@text,'"+cards_titles[i]+"')]");
            By Chevron;
            try{
                driver.findElement(CardTitle).isDisplayed();
            }
            catch(Exception E){
                System.out.println("element is not displayed");
                scrollDown();
            }
            if(i<3) {
                Chevron = By.xpath("//android.widget.LinearLayout[@content-desc=\"<b>" + driver.findElement(CardTitle).getText() + "</b> show this section\"]/android.widget.ImageView");
            }
            else{
                Chevron = By.xpath("//android.widget.LinearLayout[@content-desc=\"<b> " + driver.findElement(CardTitle).getText() + "</b> show this section\"]/android.widget.ImageView");
            }
            AssertDisplayed(driver.findElement(CardTitle).isDisplayed());
            AssertDisplayed(driver.findElement(Chevron).isDisplayed());
            System.out.println(driver.findElement(CardTitle).getText());
        }
        scrollDownTo(AppPrivacySupplementBelowText1);
        AssertResult(AppPrivacySupplementBelowText1.getText(),"For information about other data retention with Vodafone, please refer to our general privacy policy.\n" +
                "\n" +
                "The service is offered by Vodafone Limited, which is also the controller of your personal data. If you have any queries in any aspect of this privacy supplement, please use our privacy query form and a member of our dedicated team will respond to you.");
    }
    public void clickonAcceptAllCookiesinWeValueYourPrivacy(){
        waitForVisibility(acceptAllCookiesCTA);
        acceptAllCookiesCTA.click();
    }
    public void redirectNetworkandService(){
        waitForVisibility(DevSett_VodafoneLogoIcon);
        waitForVisibility(DX_IDM_NetworkandServiceTitle);
        AssertDisplayed(DX_IDM_BackCTA.isDisplayed());
        AssertDisplayed(DX_IDM_NetworkandServiceTitle.getText().equals("Our Network & \n" +
                "Service"));
        AssertDisplayed(New_DX_IDM_ContinueCTA.isDisplayed());
    }
    public void validateOurNetworkandServiceWithoutLink() {
        waitForVisibility(DX_IDM_NetworkandServiceTitle);
        AssertDisplayed(DX_IDM_BackCTA.isDisplayed());
        AssertDisplayed(DX_IDM_NetworkandServiceTitle.getText().equals("Our Network & \n" +
                "Service"));
        AssertDisplayed(DX_IDM_NetworkandServiceBody.getText().equals("Help us provide better connectivity and services in your area, by sharing your network and device performance. You can update your preferences in the app at any time."));
        AssertDisplayed(DX_IDM_NetworkImprovementsToggle.isDisplayed());
        AssertDisplayed(DX_IDM_NetworkImprovementsToggleBody.getText().equals("Share my network and device \n" +
                "performance information with \n" +
                "Vodafone."));
        AssertDisplayed(New_DX_IDM_ContinueCTA.isDisplayed());
        AssertDisplayed(!IsElementDisplayed(DX_IDM_EnablePerformanceCookiesLink));
        AssertDisplayed(DX_IDM_NetworkImprovementsToggleOFF.isDisplayed());
    }
    public void validateOurNetworkImprovementsToggle(){
        DX_IDM_NetworkImprovementsToggleOFF.click();
        waitForVisibility(DX_IDM_NetworkImprovementsToggleON);
        AssertDisplayed(DX_IDM_NetworkImprovementsToggleON.isDisplayed());
        AssertDisplayed(DX_IDM_ShareNetworkToggle.getText().equals("How do you want to share your Network and device performance Information?"));
        try{
            waitForVisibilityForReinvent(DX_IDM_ShareMyCustomerProfile,40);
        }
        catch (Exception e){
            System.out.println("scrolling till find element");
            scrollDown();
        }
        AssertDisplayed(DX_IDM_ShareAnonymously.getText().equals("Share anonymously"));
        AssertDisplayed(DX_IDM_ShareMyCustomerProfile.getText().equals("Share my customer profile"));
        Assert.assertEquals("true",DX_IDM_ShareAnonymously.getAttribute("checked"));
        Assert.assertEquals("false",DX_IDM_ShareMyCustomerProfile.getAttribute("checked"));
    }

    public void ToggleNetworkImprovementsFromWelcomeFlow(){
        waitForVisibility(DX_IDM_NetworkImprovementsToggleOFF);
        DX_IDM_NetworkImprovementsToggleOFF.click();
        waitForVisibility(DX_IDM_NetworkImprovementsToggleON);
        AssertDisplayed(DX_IDM_NetworkImprovementsToggleON.isDisplayed());
    }
    public void validateOurNetworkandServiceWithLink(){
        waitForVisibility(DX_IDM_NetworkandServiceTitle);
        AssertDisplayed(DX_IDM_BackCTA.isDisplayed());
        AssertDisplayed(DX_IDM_NetworkandServiceTitle.getText().equals("Our Network & \n" +
                "Service"));
        AssertDisplayed(DX_IDM_NetworkandServiceBody.getText().equals("Help us provide better connectivity and services in your area, by sharing your network and device performance. You can update your preferences in the app at any time."));
        AssertDisplayed(DX_IDM_NetworkImprovementsToggle.isDisplayed());
        AssertDisplayed(DX_IDM_NetworkImprovementsToggleBody.getText().equals("Share my network and device \n" +
                "performance information with \n" +
                "Vodafone."));
        AssertDisplayed(New_DX_IDM_ContinueCTA.isDisplayed());
        AssertDisplayed(IsElementDisplayed(DX_IDM_EnablePerformanceCookiesLink));
        AssertDisplayed(DX_IDM_NetworkImprovementsToggleOFF.isDisplayed());
    }
    public void clickonAcceptAllfromCookiePermissions(){
        waitForVisibility(AcceptAllCTA);
        AcceptAllCTA.click();
        AssertDisplayed(DX_IDM_NetworkandServiceTitle.isDisplayed());
        AssertDisplayed(!IsElementDisplayed(DX_IDM_EnablePerformanceCookiesLink));
    }
    public void clickonRejectAllfromCookiePermissions(){
        waitForVisibility(RejectAllCTA);
        RejectAllCTA.click();
        AssertDisplayed(DX_IDM_NetworkandServiceTitle.isDisplayed());
        AssertDisplayed(IsElementDisplayed(DX_IDM_EnablePerformanceCookiesLink));
    }
    public void clickOnEnablePerformanceCookiesLink(){
        waitForVisibility(DX_IDM_EnablePerformanceCookiesLink);
        Point point = DX_IDM_EnablePerformanceCookiesLink.getLocation();
        int x = (int) (0.01 * point.getX() + DX_IDM_EnablePerformanceCookiesLink.getSize().width);
        int y = point.getY() + 4;
        touchAction.tap(PointOption.point(x,y)).perform();
    }
    public void clickOnEnableTargetingCookiesLink(){
        waitForVisibility(DX_IDM_EnableTargetingCookiesLink);
        Point point = DX_IDM_EnableTargetingCookiesLink.getLocation();
        int x = point.getX() + DX_IDM_EnableTargetingCookiesLink.getSize().width - 200;
        int y = point.getY() + DX_IDM_EnableTargetingCookiesLink.getSize().height- 10;
        touchAction.tap(PointOption.point(x,y)).perform();
    }
    public void validateGettheBestExperienceWithoutLink(){
        waitForVisibility(DX_IDM_GettheBestExperienceTitle);
        AssertDisplayed(DX_IDM_BackCTA.isDisplayed());
        AssertDisplayed(DX_IDM_NotificationsToggles_OFF.isDisplayed());
        AssertDisplayed(DX_IDM_GettheBestExperienceTitle.getText().equals("Get the best \n" +
                "experience"));
        AssertDisplayed(DX_IDM_GettheBestExperienceBody.getText().equals("To get the most from our app, we suggest enabling these permissions. You’ll need to accept the pop-ups on the next screen."));
        AssertDisplayed(New_DX_IDM_ContinueCTA.isDisplayed());
        AssertDisplayed(DX_IDM_EnableAllCTA.isDisplayed());
        AssertDisplayed(!IsElementDisplayed(DX_IDM_EnableTargetingCookiesLink));
    }

    public void validateNavigationToGetTheBestExperience(){
        try {
            waitForVisibility(DX_IDM_GettheBestExperienceTitle);
            New_DX_IDM_ContinueCTA.click();
        }
        catch(Exception e){
            System.out.println("App Not fresh installed");
        }
    }
    public void validateGettheBestExperienceWithLink(){
        waitForVisibility(DX_IDM_GettheBestExperienceTitle);
        AssertDisplayed(DX_IDM_BackCTA.isDisplayed());
        AssertDisplayed(DX_IDM_NotificationsToggles_OFF.isDisplayed());
        AssertDisplayed(DX_IDM_GettheBestExperienceTitle.getText().equals("Get the best \n" +
                "experience"));
        AssertDisplayed(DX_IDM_GettheBestExperienceBody.getText().equals("To get the most from our app, we suggest enabling these permissions. You’ll need to accept the pop-ups on the next screen."));
        AssertDisplayed(New_DX_IDM_ContinueCTA.isDisplayed());
        AssertDisplayed(DX_IDM_EnableAllCTA.isDisplayed());
        AssertDisplayed(IsElementDisplayed(DX_IDM_EnableTargetingCookiesLink));
    }
    public void clickOnEnableAllCTA(){
        waitForVisibility(DX_IDM_EnableAllCTA);
        DX_IDM_EnableAllCTA.click();
    }
    @Override
    public void clickOnCookiePolicyLink() {
        Point point = cookiePolicyLink_Android.getLocation();
        int x = (int) (point.getX() + (0.01 * cookiePolicyLink_Android.getSize().width));
        int y = point.getY() + cookiePolicyLink_Android.getSize().height - 10 ;

        TouchAction touchAction = new TouchAction((PerformsTouchActions) driver);
        touchAction.tap(PointOption.point(x,y)).perform();
    }

    @Override
    public void validateCookiePolicyScreen() {
        waitForVisibility(DX_IDM_welcomeFlowTitle);
        AssertDisplayed(DX_IDM_BackCTA.isDisplayed());
        Assert.assertEquals(DX_IDM_welcomeFlowTitle.getText(),"Cookie policy");
        Assert.assertEquals(OurCookiePolicy.getText(),"Our Cookies policy");
        Assert.assertEquals(ControllingYourCookies.getText(),"Controlling your cookies");
        Assert.assertEquals(FirstPartyCookie.getText(),"First-party required cookies");
        Assert.assertEquals(ThirdPartyCookie.getText(),"Third party cookies");

        //Assert that the first 2 chevrons are shown
        List<WebElement> DownChevrons = driver.findElements(By.id("com.myvodafoneapp:id/card_arrow"));
        Assert.assertEquals(DownChevrons.size(),2);
        //Assert that the last 2 chevrons are shown
        List<WebElement> SideChevrons = driver.findElements(By.id("com.myvodafoneapp:id/settingsItemChevron"));
        Assert.assertEquals(SideChevrons.size(),2);
    }

    @Override
    public void clickOnFirstTwoPolicies() {
        List<WebElement> DownChevrons = driver.findElements(By.id("com.myvodafoneapp:id/card_arrow"));
        for(int i=0; i<DownChevrons.size(); i++){
            DownChevrons.get(i).click();
            waitForVisibility(DX_IDM_welcomeFlowTitle);
            Assert.assertEquals(DX_IDM_welcomeFlowTitle.getText(),"Cookie policy");
            DownChevrons.get(i).click();
        }
    }

    @Override
    public void clickOnLastTwoPolicies() {
        FirstPartyCookie.click();
        AssertDisplayed(CookiePolicy_FirstpartySDKName.isDisplayed());
        DX_IDM_BackCTA.click();
        waitForVisibilityForReinvent(DX_IDM_welcomeFlowTitle,60);
        Assert.assertEquals(DX_IDM_welcomeFlowTitle.getText(), "Cookie policy");
        //Third party cookie check
        ThirdPartyCookie.click();
        AssertDisplayed(CookiePolicy_ThirdpartySDKName.isDisplayed());
        DX_IDM_BackCTA.click();
        waitForVisibilityForReinvent(DX_IDM_welcomeFlowTitle,60);
        Assert.assertEquals(DX_IDM_welcomeFlowTitle.getText(),"Cookie policy");
    }
}

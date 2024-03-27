package pages.DX_IDM.WelcomeFlow;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.DX_IDM.FullLogin.DX_IDM_FullLoginLogic;
import pages.DX_IDM.FullLogin.DX_IDM_FullLoginPO;
import pages.DX_IDM.UFL.DX_IDM_UFL_Abstract;
import pages.DX_IDM.UFL.DX_IDM_UFL_IOS;
import pages.DX_IDM.UFL.DX_IDM_UFLLogic;
import utils.BeFlagConfigUtils;


import java.util.List;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static utils.element_helpers.DriverHelps.*;
import static utilities.PropertiesLoader.readPropertyFile;
import static utils.element_helpers.ScrollHelpers.scrollDownTo;
import static utils.element_helpers.VerifyHelpers.*;
import static utils.element_helpers.WaitHelpers.waitForVisibility;
import static utils.element_helpers.WaitHelpers.waitForVisibilityForReinvent;

public class DX_IDM_WelcomeFlowLogic_IOS extends DX_IDM_WelcomeFlowLogicAbstract {


    DX_IDM_FullLoginPO loginObject;
    DX_IDM_UFLLogic UFL_Logic;
    DX_IDM_FullLoginLogic FL_Logic;
    Properties envProp = readPropertyFile("config/env.properties");
    boolean BeFlag=BeFlagConfigUtils.getBeFlagConfigFlag();
    public DX_IDM_WelcomeFlowLogic_IOS() {
        super();
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
        AssertResult(DX_IDM_PrivacyAndTermsToggleMessage.getText(), "Please agree to the Terms and \u2028Conditions before continuing");
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
        AssertResult(DX_IDM_PermissionScreenContinueCTA.getText(), "Continue");
        DX_IDM_PermissionScreenContinueCTA.click();
        acceptIOSPermission();
    }

    @Override
    public void beforeUsageAccessPopup(){}
    @Override
    public void validateUsageAccessPopupContent() {}

    public void acceptIOSPermission() {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.alertIsPresent());
            acceptAlert();
    }

    @Override
    public void acceptAlert() {
        Alert alert;
        alert = driver.switchTo().alert();
        alert.accept();
    }

    @Override
    public void beforeLoginScreen() {
        waitForVisibility(DX_IDM_LoginCTA);
    }

    @Override
    public void validateLoginScreenContent() {
        waitForVisibility(DX_IDM_LoginScreenTitle);
        System.out.println(DX_IDM_LoginScreenTitle.getText());
        AssertResult(DX_IDM_LoginScreenTitle.getText(), "Log in to  My Vodafone");
        System.out.println(DX_IDM_LoginScreenBody.getText());
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
                waitForVisibility(driver.findElement(By.id("Allow While Using App")));
                driver.findElement(By.id("Allow While Using App")).click();
                beforeLoginScreen();
            }
            catch (Exception e)
            { System.out.println("App not first installation");
            }
            //I commented this because sometimes it redirects user to only "Return to My Vodafone" CTA let's only stop this function to the welcome flow
            /*if (System.getProperty("isLiveTest", envProp.getProperty("isLiveTest")).equalsIgnoreCase("false")){
                if (!System.getProperty("Segment", envProp.getProperty("Segment")).equalsIgnoreCase("PREPAY") && !(System.getProperty("Segment", envProp.getProperty("SubscriptionType")).equalsIgnoreCase("HYBRID"))) {
                    if (!System.getProperty("UnknownUser", envProp.getProperty("UnknownUser")).equalsIgnoreCase("true")) {
                        waitForVisibilityForReinvent(DX_IDM_LoginCTA, 60);
                    }
                }
            }*/
        }
    }




    @Override
    public void dxIdmVOXIScreenContent() {
        waitForVisibility(DX_IDM_VOXISignINURL);
        AssertDisplayed(DX_IDM_VOXISignINURL.isDisplayed());
        AssertDisplayed(DX_IDM_VOXIReturnToMyVodafoneCTA.isDisplayed());
    }

    @Override
    public void clickOnReturnToMyVodafoneCTA() throws InterruptedException {
        try{
            waitForVisibilityForReinvent(DX_IDM_VOXIReturnToMyVodafoneCTA,100);
            DX_IDM_VOXIReturnToMyVodafoneCTA.click();
        }
        catch (Exception e){
            System.out.println("Return to My Vodafone didn't display");
        }
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
        waitForVisibility(DX_IDM_VOXISettingDrawer);
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
        if (elementIsPresent(AcceptCookies)) {
            AcceptCookies.click();
        } else {
            System.out.println("Cookies are not displayed");
        }
        waitForVisibility(loginObject.DX_IDM_Username);
        AssertDisplayed(loginObject.DX_IDM_Username.isDisplayed());
        waitForVisibility(DX_IDM_MyAccountDrawerXIcon);
        DX_IDM_MyAccountDrawerXIcon.click();
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
        AssertResult(DX_IDM_HelloFriendBody.getText(), "Log in to My Vodafone to view your current charges and usage, view and pay your bill, manage your extras and more.\n" +
                "\n" +
                "If you’d prefer, you can always log in via the My Account page later.");
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
        AssertDisplayed(DX_IDM_BeforeYouGetStartedSubBody.getText().contains("I agree to Vodafone's Terms and Conditions"));
        AssertDisplayed(DX_IDM_BeforeYouGetStartedBody.getText().contains("We store certain information to improve the app and give you the best experience. App Privacy Supplement"));
        assertDisplayed(New_DX_IDM_ContinueCTA,60);
    }
    public void validateTermsandConditionsPopup(){
        waitForVisibility(DX_IDM_termsandConidtionsPopup);
        AssertResult(DX_IDM_termsandConidtionsPopup.getText(),"Please agree to the Terms and Conditions before continuing");
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
        AssertDisplayed(cookiePolicyLink_IOS.isDisplayed());
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

    public void validateCookiePermissionsScreen(){
        waitForVisibility(New_DX_IDM_ContinueCTA);
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
                List<WebElement> toggels = driver.findElements(By.id("toggle_control"));
                Assert.assertEquals(toggels.size(),3);
                for(int i=0;i< toggels.size();i++)
                {
                    AssertResult("off",toggels.get(i).getAttribute("value"));
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
        List<WebElement> chevrons = driver.findElements(By.id("ic_arrow"));
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
        List<WebElement> chevrons = driver.findElements(By.id("ic_arrow"));
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
            HardAssertNotDisplayed("group_decr_label",false);
        }

    }
    public void Toggle_Cookie(String cookie,String state){
        List<WebElement> toggels = driver.findElements(By.id("toggle_control"));
        int j = 0;
        if(!(state.equals("ON") || state.equals("OFF"))) {
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

        if(!state.equalsIgnoreCase(toggels.get(j).getAttribute("value"))){
            toggels.get(j).click();
        }
        Assert.assertTrue(toggels.get(j).getAttribute("value").equalsIgnoreCase(state));
    }

    public void ValidateValueOfCookie(String cookie, String value){
        List<WebElement> toggels = driver.findElements(By.id("toggle_control"));
        int j = 0;
        if(!(value.equals("ON") || value.equals("OFF"))) {
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

        Assert.assertTrue(toggels.get(j).getAttribute("value").equalsIgnoreCase(value));
    }
    public void clickonAcceptAllCookiesinWeValueYourPrivacy(){
        waitForVisibility(acceptAllCookiesCTA);
        acceptAllCookiesCTA.click();
    }
    public void redirectNetworkandService(){
        waitForVisibility(DX_IDM_NetworkandServiceTitle);
        AssertDisplayed(DX_IDM_BackCTA.isDisplayed());
        AssertDisplayed(DX_IDM_NetworkandServiceTitle.getText().equals("Our Network & \n" +
                "Service"));
        AssertDisplayed(New_DX_IDM_ContinueCTA.isDisplayed());
    }
    public void validateOurNetworkandServiceWithoutLink() {
        waitForVisibility(DX_IDM_NetworkandServiceTitle);
        AssertDisplayed(DX_IDM_BackCTA.isDisplayed());
        AssertDisplayed(DX_IDM_NetworkandServiceTitle.getText().equals(" Our Network &\n" +
                "        Service"));
        AssertDisplayed(DX_IDM_NetworkandServiceBody.getText().equals("Help us provide better connectivity and services in your area, by sharing your network and device performance. You can update your preferences in the app at any time."));
        AssertDisplayed(DX_IDM_NetworkImprovementsToggle.isDisplayed());
        AssertDisplayed(DX_IDM_NetworkImprovementsToggleBody.getText().equals("Share my network and device and device performance information with \n" +
                "Vodafone."));
        AssertDisplayed(New_DX_IDM_ContinueCTA.isDisplayed());
        AssertDisplayed(!IsElementDisplayed(DX_IDM_EnablePerformanceCookiesLink));
        AssertDisplayed(DX_IDM_NetworkImprovementsToggleOFF.isDisplayed());
    }

    public void validateOurNetworkandServiceWithLink(){
        waitForVisibility(DX_IDM_NetworkandServiceTitle);
        AssertDisplayed(DX_IDM_BackCTA.isDisplayed());
        AssertDisplayed(DX_IDM_NetworkandServiceTitle.getText().equals(" Our Network &\n" +
                "        Service"));
        AssertDisplayed(DX_IDM_NetworkandServiceBody.getText().equals("Help us provide better connectivity and services in your area, by sharing your network and device performance. You can update your preferences in the app at any time."));
        AssertDisplayed(DX_IDM_NetworkImprovementsToggle.isDisplayed());
        AssertDisplayed(DX_IDM_NetworkImprovementsToggleBody.getText().equals("Share my network and device and device performance information with \n" +
                "Vodafone."));
        AssertDisplayed(New_DX_IDM_ContinueCTA.isDisplayed());
        AssertDisplayed(IsElementDisplayed(DX_IDM_EnablePerformanceCookiesLink));
        AssertDisplayed(DX_IDM_NetworkImprovementsToggleOFF.isDisplayed());
    }
    public void validateOurNetworkImprovementsToggle(){
        DX_IDM_NetworkImprovementsToggleOFF.click();
        waitForVisibility(DX_IDM_NetworkImprovementsToggleON);
        AssertDisplayed(DX_IDM_NetworkImprovementsToggleON.isDisplayed());
        AssertDisplayed(DX_IDM_ShareNetworkToggle.getText().equals("How do you want to share your Network and device performance Information?"));
        try{
            waitForVisibility(DX_IDM_ShareMyCustomerProfile);
        }
        catch (Exception e){
            System.out.println("scrolling till find element");
            scrollDownTo(DX_IDM_ShareMyCustomerProfile);
        }
        AssertDisplayed(DX_IDM_ShareAnonymously.getText().equals("Share anonymously"));
        AssertDisplayed(DX_IDM_ShareMyCustomerProfile.getText().equals("Share my customer profile"));
        AssertDisplayed(DX_IDM_ShareAnonymously.isDisplayed());
        AssertDisplayed(DX_IDM_ShareMyCustomerProfile.isDisplayed());
    }

    public void ToggleNetworkImprovementsFromWelcomeFlow(){
        waitForVisibility(DX_IDM_NetworkImprovementsToggleOFF);
        DX_IDM_NetworkImprovementsToggleOFF.click();
        waitForVisibility(DX_IDM_NetworkImprovementsToggleON);
        AssertDisplayed(DX_IDM_NetworkImprovementsToggleON.isDisplayed());
    }
    public void clickonAcceptAllfromCookiePermissions(){
        waitForVisibility(AcceptAllCTA);
        AcceptAllCTA.click();
        AssertDisplayed(DX_IDM_NetworkandServiceTitle.isDisplayed());
        AssertDisplayed(IsElementDisplayed(DX_IDM_EnablePerformanceCookiesLink));
    }
    public void clickonRejectAllfromCookiePermissions(){
        waitForVisibility(RejectAllCTA);
        RejectAllCTA.click();
        AssertDisplayed(DX_IDM_NetworkandServiceTitle.isDisplayed());
        AssertDisplayed(IsElementDisplayed(DX_IDM_EnablePerformanceCookiesLink));
    }
    public void clickOnEnablePerformanceCookiesLink(){
        waitForVisibility(DX_IDM_EnablePerformanceCookiesLink);
        DX_IDM_EnablePerformanceCookiesLink.click();
    }
    public void clickOnEnableTargetingCookiesLink(){
        waitForVisibility(DX_IDM_EnableTargetingCookiesLink);
        DX_IDM_EnableTargetingCookiesLink.click();
    }
    public void ClickOnAppPrivacySupplementLink() {
        AppPrivacySupplementLink.click();
    }

    public void ValidateAppPrivacySupplementScreen() {
        waitForVisibility(AppAppPrivacySupplementHeader);
        Assert.assertEquals(AppAppPrivacySupplementHeader.getText(),"App Privacy Supplement");
        AssertDisplayed(DX_IDM_BackCTA.isDisplayed());
        AssertResult(AppPrivacySupplementTitle.getText(),"My Vodafone App");
        AssertDisplayed(AppPrivacySupplementSubTitle.isDisplayed());


        String [] cards_titles = {
                "Information we collect","Usage of My Vodafone app",
                "Information we don't collect"," How we use this information",
                " What choices do you have?"," How do you protect my data?"," How long do you keep my data?"};

        AssertResult(driver.findElement(By.id("card_title_0_0")).getAttribute("value").toString(),"Information we collect");

        for (int i = 1; i < cards_titles.length; i++){
            scrollDownTo(driver.findElement(By.id("card_title_0_"+i)));
            String itemTitle = driver.findElement(By.id("card_title_0_"+i)).getAttribute("value").toString();
            Assert.assertEquals(itemTitle,cards_titles[i]);
            AssertDisplayed(driver.findElement(By.id("card_arrow_0_"+i)).isDisplayed());
            System.out.println(itemTitle);
        }
        scrollDownTo(AppPrivacySupplementBelowText2);
        AssertDisplayed(AppPrivacySupplementBelowText1.isDisplayed());
        AssertDisplayed(AppPrivacySupplementBelowText2.isDisplayed());
    }
    public void validateGettheBestExperienceWithoutLink(){
        waitForVisibility(DX_IDM_GettheBestExperienceTitle);
        AssertDisplayed(DX_IDM_BackCTA.isDisplayed());
        AssertDisplayed(DX_IDM_NotificationsToggles_OFF.isDisplayed());
        AssertDisplayed(DX_IDM_GettheBestExperienceTitle.getText().equals("Get the best & \n" +
                "Experience"));
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
        AssertDisplayed(DX_IDM_GettheBestExperienceTitle.getText().equals("Get the best & \n" +
                "Experience"));
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
        waitForVisibility(cookiePolicyLink_IOS);
        cookiePolicyLink_IOS.click();
        Assert.assertEquals(OurCookiePolicy.getText(),"Our Cookies policy");
    }

    @Override
    public void validateCookiePolicyScreen() {
        waitForVisibility(DX_IDM_welcomeFlowTitle);
        AssertDisplayed(DX_IDM_BackCTA.isDisplayed());
        Assert.assertEquals(DX_IDM_welcomeFlowTitle.getText(),"Cookie policy");
        Assert.assertEquals(OurCookiePolicy.getText(),"Our Cookies policy");
        Assert.assertEquals(ControllingYourCookies.getText(),"Controlling your cookies");
        AssertDisplayed(FirstPartyCookie.isDisplayed());
        AssertDisplayed(ThirdPartyCookie.isDisplayed());

        //Assert that the first 2 chevrons are shown
        AssertDisplayed(CookiePolicy_downChevrons1.isDisplayed());
        AssertDisplayed(CookiePolicy_downChevrons2.isDisplayed());
        //Assert that the last 2 chevrons are shown
        List<WebElement> SideChevrons = driver.findElements(By.id("popUpArrow"));
        Assert.assertEquals(SideChevrons.size(),2);
    }

    @Override
    public void clickOnFirstTwoPolicies() {
        CookiePolicy_downChevrons1.click();
        waitForVisibility(DX_IDM_welcomeFlowTitle);
        Assert.assertEquals(DX_IDM_welcomeFlowTitle.getText(),"Cookie policy");
        CookiePolicy_downChevrons1.click();
        CookiePolicy_downChevrons2.click();
        waitForVisibility(DX_IDM_welcomeFlowTitle);
        Assert.assertEquals(DX_IDM_welcomeFlowTitle.getText(),"Cookie policy");
        CookiePolicy_downChevrons2.click();
    }

    @Override
    public void clickOnLastTwoPolicies() {
        //first-party Cookie check
        FirstPartyCookie.click();
        AssertDisplayed(CookiePolicy_FirstpartySDKName.isDisplayed());
        DX_IDM_BackCTA.click();
        waitForVisibility(DX_IDM_welcomeFlowTitle);
        Assert.assertEquals(DX_IDM_welcomeFlowTitle.getText(), "Cookie policy");
        //Third party cookie check
        ThirdPartyCookie.click();
        AssertDisplayed(CookiePolicy_ThirdpartySDKName.isDisplayed());
        DX_IDM_BackCTA.click();
        waitForVisibility(DX_IDM_welcomeFlowTitle);
        Assert.assertEquals(DX_IDM_welcomeFlowTitle.getText(), "Cookie policy");
    }
}

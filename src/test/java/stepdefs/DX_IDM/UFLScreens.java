package stepdefs.DX_IDM;

import core.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.simple.parser.ParseException;
import org.testng.SkipException;
import pages.DX_IDM.ForgetPassword.DX_IDM_ForgetPasswordAbstract;
import pages.DX_IDM.ForgetPassword.DX_IDM_ForgetPassword_Android;
import pages.DX_IDM.ForgetPassword.DX_IDM_ForgetPassword_IOS;
import pages.DX_IDM.ForgotUsername.DXIDM_ForgotUsernameAbstract;
import pages.DX_IDM.ForgotUsername.DXIDM_ForgotUsername_Android;
import pages.DX_IDM.ForgotUsername.DXIDM_ForgotUsername_IOS;
import pages.DX_IDM.FullLogin.DX_IDM_FullLoginLogic_Abstract;
import pages.DX_IDM.FullLogin.DX_IDM_FullLoginLogic_Android;
import pages.DX_IDM.FullLogin.DX_IDM_FullLoginLogic_IOS;
import pages.DX_IDM.UFL.*;
import testdata.ReadResponse;

import static stepdefs.DX_IDM.FullLogin.LoginState;


public class UFLScreens {
    private DX_IDM_UFL_Abstract DX_IDM_UFL;
    private DX_IDM_UFL_Android dX_IDM_UFL_Android;
    private DX_IDM_ForgetPasswordAbstract dX_IDM_ForgetPassword;
    private DX_IDM_FullLoginLogic_Abstract dx_idm_fullLoginLogic_abstract;
    private DXIDM_ForgotUsernameAbstract DXIDM_ForgotUsername;
    public static boolean loginState = false;
    private static boolean UFLFlag=false;

    public UFLScreens(Config config) {
        if (config.isAndroid())
        {
            DX_IDM_UFL = new DX_IDM_UFL_Android();
            dX_IDM_UFL_Android = new DX_IDM_UFL_Android();
            dX_IDM_ForgetPassword = new DX_IDM_ForgetPassword_Android();
            dx_idm_fullLoginLogic_abstract = new DX_IDM_FullLoginLogic_Android();
            DXIDM_ForgotUsername = new DXIDM_ForgotUsername_Android();
        }
        if (config.isIos())
        {
            DX_IDM_UFL = new DX_IDM_UFL_IOS();
            dX_IDM_ForgetPassword = new DX_IDM_ForgetPassword_IOS();
            dx_idm_fullLoginLogic_abstract = new DX_IDM_FullLoginLogic_IOS();
            DXIDM_ForgotUsername = new DXIDM_ForgotUsername_IOS();
        }
    }

    @Given("Skip Login")
    public void SkipLoginCTA() {
        DX_IDM_UFL.SkipLoginCTA();
    }

    @Then("Validate Disconnect WiFi screen")
    public void ValidateSkipLogin() {
        DX_IDM_UFL.ValidateSkipLogin();
    }

    @And("Close Disconnect WiFi screen")
    public void DisconnectWiFiCloseCTA() {
        DX_IDM_UFL.DisconnectWiFiCloseCTA();
    }

    @Given("Login Till Reach Username Screen")
    public void LoginTillReachUsernameScreen() {
        DX_IDM_UFL.LoginTillReachUsernameScreen();
    }

    @Given("Login Till Reach Password Screen")
    public void LoginTillReachPasswordScreen() throws InterruptedException {
        DX_IDM_UFL.LoginTillReachUsernameScreen();
        DX_IDM_UFL.LoginTillReachPasswordScreen();
    }

    @Given("Login Till Reach Request Security Code Screen")
    public void LoginTillReachSelectSecurityAccountScreen() throws InterruptedException {
        DX_IDM_UFL.LoginTillReachUsernameScreen();
        DX_IDM_UFL.LoginTillReachPasswordScreen();
        DX_IDM_UFL.LoginTillReachRequestSecurityCodeScreen();
    }

    @Given("Login Till Reach Enter Security Code Screen")
    public void LoginTillReachEnterSecurityCodeScreen() {
        DX_IDM_UFL.validateSelectingAccount();
    }

    @Given("Login Till Reach Choose Account Screen")
    public void LoginTillReachChooseAccountScreen() throws InterruptedException {
        DX_IDM_UFL.validateSelectingAccount();
        DX_IDM_UFL.LoginTillReachChooseAccountScreen();
    }

    @Given("Login Till Reach Choose Plan Screen")
    public void LoginTillReachChoosePlanScreen() throws InterruptedException, ParseException {
        DX_IDM_UFL.LoginTillReachUsernameScreen();
        DX_IDM_UFL.LoginTillReachPasswordScreen();
        DX_IDM_UFL.LoginTillReachRequestSecurityCodeScreen();
        DX_IDM_UFL.validateSelectingAccount();
        DX_IDM_UFL.LoginTillReachChooseAccountScreen();
        DX_IDM_UFL.LoginTillReachChoosePlanScreen();
    }
    @Given("Login Till Reach Login Preference Screen")
    public void LoginTillReachLoginPreferenceScreen() throws InterruptedException, ParseException {
        DX_IDM_UFL.LoginTillReachUsernameScreen();
        DX_IDM_UFL.LoginTillReachPasswordScreen();
        DX_IDM_UFL.LoginTillReachRequestSecurityCodeScreen();
        DX_IDM_UFL.validateSelectingAccount();
        DX_IDM_UFL.LoginTillReachChooseAccountScreen();
        DX_IDM_UFL.LoginTillReachChoosePlanScreen();
        DX_IDM_UFL.LoginTillReachLoginPreferenceScreen();
       dx_idm_fullLoginLogic_abstract.pressAllDoneCTA();
    }
    @Given("Login Till Reach Login Preference Screen but don't press")
    public void LoginTillReachLoginPreferenceScreenButDontPress() throws InterruptedException, ParseException {
        DX_IDM_UFL.LoginTillReachUsernameScreen();
        DX_IDM_UFL.LoginTillReachPasswordScreen();
        DX_IDM_UFL.LoginTillReachRequestSecurityCodeScreen();
        DX_IDM_UFL.validateSelectingAccount();
        DX_IDM_UFL.LoginTillReachChooseAccountScreen();
        DX_IDM_UFL.LoginTillReachChoosePlanScreen();
        DX_IDM_UFL.LoginTillReachLoginPreferenceScreen();
        // dx_idm_fullLoginLogic_abstract.pressAllDoneCTA();
    }

    @Given("I am MVA user and upfront logged in using user name and password")
    public void upFrontLoginUsingUserNameAndPassword() throws InterruptedException, ParseException {
        try {
            DX_IDM_UFL.LoginTillReachUsernameScreen();
            DX_IDM_UFL.LoginTillReachPasswordScreen();
            DX_IDM_UFL.LoginTillReachRequestSecurityCodeScreen();
            DX_IDM_UFL.validateSelectingAccount();
            DX_IDM_UFL.LoginTillReachChooseAccountScreen();
            DX_IDM_UFL.LoginTillReachChoosePlanScreen();
            DX_IDM_UFL.LoginTillReachLoginPreferenceScreen();
            dx_idm_fullLoginLogic_abstract.selectPassword();
            dx_idm_fullLoginLogic_abstract.pressAllDoneCTA();

        }
        catch(Exception e ){
            System.out.println("User Already Logged in");
        }
    }

    @Given("I am MVA user and upfront logged in using PIN")
    public void upFrontLoginUsingPIN() throws InterruptedException, ParseException {
        if (!UFLFlag) {
            DX_IDM_UFL.LoginTillReachUsernameScreen();
            DX_IDM_UFL.LoginTillReachPasswordScreen();
            DX_IDM_UFL.LoginTillReachRequestSecurityCodeScreen();
            DX_IDM_UFL.validateSelectingAccount();
            DX_IDM_UFL.LoginTillReachChooseAccountScreen();
            DX_IDM_UFL.LoginTillReachChoosePlanScreen();
            DX_IDM_UFL.LoginTillReachLoginPreferenceScreen();
            dx_idm_fullLoginLogic_abstract.selectPIN();
            dx_idm_fullLoginLogic_abstract.pressAllDoneCTA();
        }
        UFLFlag=true;
    }


    @Then("Validate username screen content")
    public void ValidateUsernameScreenContent() {
        DX_IDM_UFL.validateUsernameScreenContent();
    }

    @Then("Validate password screen content")
    public void ValidatePasswordScreenContent() {
        DX_IDM_UFL.validatePasswordScreenContent();
    }

    @Then("Validate Request Security Code Screen Content")
    public void ValidateRequestSecurityCodeScreenContent() {
        DX_IDM_UFL.ValidateRequestSecurityCodeScreenContent();
    }

    @Then("Validate Enter Security Code Screen Content")
    public void ValidateEnterSecurityCodeScreenContent() {
        DX_IDM_UFL.ValidateEnterSecurityCodeScreenContent();
    }

    @Then("Validate Choose Your Account Screen Content")
    public void ValidateChooseYourAccountScreenContent() throws ParseException {
        DX_IDM_UFL.ValidateChooseYourAccountScreenContent();
    }

    @Then("Validate Choose Your Plan Screen Content")
    public void ValidateChooseYourPlanScreenContent() throws ParseException {
        DX_IDM_UFL.ValidateChooseYourPlanScreenContent();
    }

    @Then("Validate Login Preferences Screen Content")
    public void ValidateLoginPreferencesScreenContent() throws InterruptedException {
        DX_IDM_UFL.ValidateLoginPreferencesScreenContent();
    }


    @Then("Validate Login to My Vodafone screen is displayed")
    public void ValidateLoginToMyVodafoneScreenIsDisplayed() {
        DX_IDM_UFL.ValidateLoginToMyVodafoneScreenIsDisplayed();
    }

    @Then("Username screen is displayed")
    public void UsernameScreenIsDisplayed() {
        DX_IDM_UFL.UsernameScreenIsDisplayed();
    }

    @Then("Password screen is displayed")
    public void PasswordScreenIsDisplayed() {
        DX_IDM_UFL.PasswordScreenIsDisplayed();
    }

    @Then("Request Security Code Screen Is Displayed")
    public void RequestSecurityCodeScreenIsDisplayed() {
        DX_IDM_UFL.RequestSecurityCodeScreenIsDisplayed();
    }

    @When("Click X button")
    public void ClickXButton() {
        DX_IDM_UFL.ClickXButton();
    }

    @When("Click X button in Accounts screen")
    public void ClickXButtonInAccountScreen() throws ParseException {
        if (ReadResponse.getAccountIds().size() > 1)
            DX_IDM_UFL.ClickXButton();
        else throw new SkipException("Item not exist in the response");
    }

    @When("Click X button  in Plan screen")
    public void ClickXButtonInPlanScreen() throws ParseException {
        if (ReadResponse.getSubsList().size() > 1)
            DX_IDM_UFL.ClickXButton();
        else throw new SkipException("Item not exist in the response");
    }


    @When("I put the app in background")
    public void AppSoftClose() {
        DX_IDM_UFL.AppSoftClose();
    }

    @When("App HardClose Then Relaunch")
    public void AppHardCloseThenRelaunch() {
        DX_IDM_UFL.AppHardCloseThenRelaunch();
    }

    @When("Click On Chat To Us")
    public void ClickOnChatToUs() {
        DX_IDM_UFL.ClickOnChatToUs();
    }

    @Then("Validate Tobi Journey Is Triggered")
    public void ValidateTobiJourneyIsTriggered() throws InterruptedException {
        DX_IDM_UFL.ValidateTobiJourneyIsTriggered();
    }

    @When("Click On Physical Back Button")
    public void ClickOnPhysicalBackButton() throws InterruptedException {
        DX_IDM_UFL.ClickOnPhysicalBackButton();
    }


    @Then("Validate click on the Physical Back Button on username screen_FullLogin")
    public void validateClickOnThePhysicalBackButtonOnUsernameScreen_FullLogin() throws InterruptedException {
        dX_IDM_UFL_Android.ValidateCheckOnPhysicalBackButtonBehaviorOnUsername();

    }

    @Then("Validate click on the Physical Back Button on Password screen_FullLogin")
    public void validateClickOnThePhysicalBackButtonOnPasswordScreen_FullLogin() throws InterruptedException {
        dX_IDM_UFL_Android.ValidateCheckOnPhysicalBackButtonBehaviorOnPassword();

    }

    @Then("Validate click on the Physical Back Button on Requested security code screen")
    public void validateClickOnThePhysicalBackButtonOnRequestedSecurityCodeScreen() throws InterruptedException {
        dX_IDM_UFL_Android.ValidateCheckOnPhysicalBackButtonBehaviorOnRequestedSecurityCode();

    }

    @Then("Validate click on the Physical Back Button on Enter security code screen")
    public void validateClickOnThePhysicalBackButtonOnEnterSecurityCodeScreen() throws InterruptedException {
        dX_IDM_UFL_Android.ValidateCheckOnPhysicalBackButtonBehaviorOnEnterSecurityCode();

    }

    @Then("Validate click on the Physical Back Button on Choose account screen")
    public void validateClickOnThePhysicalBackButtonOnChooseAccountScreen() throws ParseException, InterruptedException {
        dX_IDM_UFL_Android.ValidateCheckOnPhysicalBackButtonBehaviorOnChooseAccount();

    }

    @Then("Validate click on the Physical Back Button on Choose plan screen")
    public void validateClickOnThePhysicalBackButtonOnChoosePlanScreen() throws ParseException, InterruptedException {
        dX_IDM_UFL_Android.ValidateCheckOnPhysicalBackButtonBehaviorOnChoosePlan();
    }

    @Then("Validate click on the Physical Back Button on Login preference screen")
    public void validateClickOnThePhysicalBackButtonOnLoginPreferenceScreen() throws InterruptedException {
        dX_IDM_UFL_Android.ValidateCheckOnPhysicalBackButtonBehaviorOnLoginPreference();
    }

    @Then("Validate click on the Physical Back Button on forgotten username  screen")
    public void validateClickOnThePhysicalBackButtonOnForgottenUsernameScreen() throws InterruptedException {
        dX_IDM_UFL_Android.ValidateClickOnThePhysicalBackButtonOnForgottenUsernameScreen();
    }

    @When("Click on Forgotten password")
    public void clickOnForgottenPassword() {
        dX_IDM_ForgetPassword.clickForgetPasswordCTA();
    }

    @Then("Validate click on the Physical Back Button on Forgotten password screen")
    public void validateClickOnThePhysicalBackButtonOnForgottenPasswordScreen() throws InterruptedException {
        dX_IDM_UFL_Android.ValidateClickOnThePhysicalBackButtonOnForgottenPasswordScreen();
    }


    @Given("Login Till Reach Login Preference Screen and choose FLN")
    public void loginTillReachLoginPreferenceScreenAndChooseFLN() throws InterruptedException, ParseException {
        DX_IDM_UFL.LoginTillReachUsernameScreen();
        DX_IDM_UFL.LoginTillReachPasswordScreen();
        DX_IDM_UFL.LoginTillReachRequestSecurityCodeScreen();
        DX_IDM_UFL.validateSelectingAccount();
        DX_IDM_UFL.LoginTillReachChooseAccountScreen();
        DX_IDM_UFL.LoginTillReachChoosePlanScreen();
        DX_IDM_UFL.chooseFLN();
    }

    @Given("Login Till Reach Login Preference Screen and choose BB")
    public void loginTillReachLoginPreferenceScreenAndChooseBB() throws InterruptedException, ParseException {
        DX_IDM_UFL.LoginTillReachUsernameScreen();
        DX_IDM_UFL.LoginTillReachPasswordScreen();
        DX_IDM_UFL.LoginTillReachRequestSecurityCodeScreen();
        DX_IDM_UFL.validateSelectingAccount();
        DX_IDM_UFL.LoginTillReachChooseAccountScreen();
        DX_IDM_UFL.LoginTillReachChoosePlanScreen();
        DX_IDM_UFL.chooseBB();
    }

    @And("I close the external webview")
    public void iCloseTheExternalWebview() {
        DX_IDM_UFL.closeTheExternalWebview();
    }

    @And("I click on Register for My Vodafone")
    public void iClickOnRegisterForMyVodafone() {
        DX_IDM_UFL.clickOnRegisterForMyVodafone();
    }

    @And("I navigate to a custom tab")
    public void iNavigateToTheExternalWebview() {
        DX_IDM_UFL.navigateToACustomTab();
    }

    @Then("I navigate to the password screen")
    public void iNavigateToThePasswordScreen() throws InterruptedException {
        DX_IDM_UFL.LoginTillReachPasswordScreen();
    }

    @And("I close the custom tab")
    public void iCloseTheCustomTab() {
        DX_IDM_UFL.closeTheCustomTab();
    }

    @And("I navigate to the forgotten password external webview")
    public void iNavigateToTheForgottenPasswordExternalWebview() {
        DX_IDM_UFL.navigateToForgottenPasswordExternalWebview();
    }

    @And("I click on I haven't received my security code link")
    public void iClickOnIhavenotReceivedMySecurityCodeLink() {
        DX_IDM_UFL.iClickOnIhavenotReceivedMySecurityCodeLink();
    }

    @When("I see multiple accounts")
    public void iSeeMultipleAccounts() {
        DX_IDM_UFL.validateSelectingAccount();
    }
    @And("I click on a {string} subscription")
    public void iClickOnASubscription(String planNum) {
        DX_IDM_UFL.chooseAsubscription(planNum);
    }

    @And("I choose {string} account")
    public void iChooseAccount(String accNum) {
        DX_IDM_UFL.chooseAccount("3");
    }

    @Given("I am prod user and logged in using UFL")
    public void UFLogin() throws InterruptedException {
        if(!UFLFlag) {
            DX_IDM_UFL.UFLogin();
            UFLFlag = true;
        }
    }
    @Given("Preform UFL Using Login Preference Method {string}")
    public void UFL(String logPrefChoice) throws InterruptedException {
        System.out.println("user login status : " +LoginState);
        if(!LoginState) {
            DX_IDM_UFL.UFL(logPrefChoice);
            LoginState = true;
        }
        else
        {
            System.out.println("User already logged in");
        }
    }

    @And("I proceed UFL till reach login preference screen")
    public void iProceedUFLTillReachLoginPreferenceScreen() throws InterruptedException, ParseException {
        DX_IDM_UFL.LoginTillReachRequestSecurityCodeScreen();
        DX_IDM_UFL.validateSelectingAccount();
        DX_IDM_UFL.LoginTillReachChooseAccountScreen();
        DX_IDM_UFL.LoginTillReachChoosePlanScreen();
        DX_IDM_UFL.LoginTillReachLoginPreferenceScreen();
        dx_idm_fullLoginLogic_abstract.selectPassword();
    }

}
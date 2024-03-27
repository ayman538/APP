package stepdefs.DX_IDM;

import core.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DX_IDM.ChangePin.DX_IDM_ChangePinAbstract;
import pages.DX_IDM.ChangePin.DX_IDM_ChangePinAndroid;
import pages.DX_IDM.ChangePin.DX_IDM_ChangePinIOS;
import pages.DX_IDM.FullLogin.DX_IDM_FullLoginLogic_Abstract;
import pages.DX_IDM.FullLogin.DX_IDM_FullLoginLogic_Android;
import pages.DX_IDM.FullLogin.DX_IDM_FullLoginLogic_IOS;



import static core.Config.getLoginStatus;

// TODO Handel Login flow after hooks
public class FullLogin {

    DX_IDM_ChangePinAbstract DX_IDM_ChangePin;
    private DX_IDM_FullLoginLogic_Abstract dx_idm_fullLoginLogic_abstract;
    private DX_IDM_FullLoginLogic_Android dx_idm_fullLoginLogic_android;


    public static boolean LoginState = false;

    public FullLogin(Config config) {
        if (config.isAndroid()) {
            dx_idm_fullLoginLogic_abstract = new DX_IDM_FullLoginLogic_Android();
            DX_IDM_ChangePin = new DX_IDM_ChangePinAndroid();
        }
        if (config.isIos()) {
            dx_idm_fullLoginLogic_abstract = new DX_IDM_FullLoginLogic_IOS();
            DX_IDM_ChangePin = new DX_IDM_ChangePinIOS();
        }
        dx_idm_fullLoginLogic_android = new DX_IDM_FullLoginLogic_Android();
    }

    @Given("Press Login to start Full login Journey")
    public void beforeLoginUsernameAndPasswordScreen() throws InterruptedException {
        dx_idm_fullLoginLogic_abstract.beforeLoginUsernameAndPasswordScreen();
    }

    @When("Validate Username screen and Insert Username")
    public void validateUsernameScreenContent() throws InterruptedException {
        dx_idm_fullLoginLogic_abstract.validateUsernameScreenContent();
    }

    @And("Validate Password screen and Insert Password")
    public void validatePasswordScreenContent() throws InterruptedException {
        dx_idm_fullLoginLogic_abstract.validatePasswordScreenContent();
    }

    @And("Select PIN")
    public void selectPIN() {
        dx_idm_fullLoginLogic_abstract.selectPIN();
    }

    @And("Select Username and Password")
    public void selectPassword() {
        dx_idm_fullLoginLogic_abstract.selectPassword();
    }

    @And("Select Biometric")
    public void selectBiometric() {
        dx_idm_fullLoginLogic_abstract.selectBiometric();
    }

    @Then("Press All done CTA and Validate Dashboard")
    public void pressAllDoneCTA() {
        dx_idm_fullLoginLogic_abstract.pressAllDoneCTA();
        dx_idm_fullLoginLogic_abstract.closeMyAccountScreenIfDisplayed();
    }

    @When("Enter password")
    public void enterPassword() {
        dx_idm_fullLoginLogic_abstract.enterPassword();
    }

    @And("Press Show Password")
    public void showPassword() throws InterruptedException {
        dx_idm_fullLoginLogic_abstract.showPassword();
    }

    @Then("Validate Password shown")
    public void validatePasswordShown() {
        dx_idm_fullLoginLogic_abstract.validatePasswordShown();
    }

    @Then("Validate Password not shown")
    public void validatePasswordHidden() {
        dx_idm_fullLoginLogic_abstract.validatePasswordHidden();
    }

    @Then("Tap on My Account")
    public void TapOnMyAccount() {
        dx_idm_fullLoginLogic_abstract.TapOnMyAccount();
    }

    @Then("Validate username is auto populated")
    public void ValidateUsernameIsAutoPopulated() {
        dx_idm_fullLoginLogic_abstract.ValidateUsernameIsAutoPopulated();
    }

    @Then("Tap on forgot username and enter pin")
    public void TC09_ValidateForgotUsernameHyperLinkIsClickable() {
        dx_idm_fullLoginLogic_abstract.assertPinFieldInForgottenUsernameScreen();
    }

    @Then("Tap on forgot username for complex users")
    public void assertComplexInForgottenUsernameScreen() {
        dx_idm_fullLoginLogic_abstract.assertComplexInForgottenUsernameScreen();
    }

    @Then("Tap on universal link")
    public void TapOnUniversalLink() {
        dx_idm_fullLoginLogic_abstract.TapOnUniversalLink();
    }

    // ANDROID ONLY
    @Then("Validate click on the Physical Back Button on username screen")
    public void validateClickOnThePhysicalBackButtonOnUsername() throws InterruptedException {
        dx_idm_fullLoginLogic_android.validateCheckOnPhysicalBackButtonBehavior_Username();
    }

    // ANDROID ONLY
    @Then("Validate click on the Physical Back Button on Password screen")
    public void validateClickOnThePhysicalBackButtonOnPasswordScreen() throws InterruptedException {
        dx_idm_fullLoginLogic_android.validateCheckOnPhysicalBackButtonBehavior_Password();
    }

    // ANDROID ONLY
    @Then("Validate click on the Physical Back Button Login preference screen")
    public void validateClickOnThePhysicalBackButtonLoginPreferenceScreen() throws InterruptedException {
        dx_idm_fullLoginLogic_android.validateCheckOnPhysicalBackButtonBehavior_LoginPreference();
    }

    @Given("I am MVA user and logged in using full login with user name and password")
    public void ProceedInFullLogin() throws InterruptedException {
        if(!getLoginStatus().equalsIgnoreCase("true")) {
            if(!LoginState) {
                try {
                    dx_idm_fullLoginLogic_abstract.fullLoginWithUserNameAndPwdAndAcceptCookies();
                    LoginState = true;
                } catch (Exception e) {
                    System.out.println("User already logged in");
                }
            }
        }
    }
    @Given("Click on Login CTA")
    public void ClickOnLogin() throws InterruptedException {
        dx_idm_fullLoginLogic_abstract.clickOnLoginCTA();
        }
    @Given("Preform FL Using Login Preference Method {string}")
    public void ProceedInFullLoginRefactored(String logPrefChoice) throws InterruptedException {
        System.out.println("user login status : " + LoginState);
        if (!LoginState) {
            dx_idm_fullLoginLogic_abstract.FL(logPrefChoice);
            LoginState = true;
        }
    }
    @Then("Preform Returning User Using UN and Password")
    public void returnigUserUsingUN() {
        dx_idm_fullLoginLogic_abstract.returnigUserUsingUN();
    }



    @Given("I navigate to Username or Phone number login screen")
    public void iNavigateToUsernameOrPhoneNumberLoginScreen() {
        dx_idm_fullLoginLogic_abstract.userNavigateToLoginScreen();
    }

    @And("Validate prompt experience")
    public void validatePromptExperience() {
        dx_idm_fullLoginLogic_abstract.validateBiometricsPrompt();
        System.out.println("biometrics validated");
    }
}


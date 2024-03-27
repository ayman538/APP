package pages.DX_IDM.UFL;

import org.json.simple.parser.ParseException;

public abstract class DX_IDM_UFL_Abstract extends DX_IDM_UFLPO{


    public DX_IDM_UFL_Abstract() {
        super();
    }

    public abstract void SkipLoginCTA();

    public abstract void ValidateSkipLogin();

    public abstract void DisconnectWiFiCloseCTA() ;

    public abstract void validateSelectingAccount() ;


    public abstract void EnterSecurityCode() throws InterruptedException;

    public abstract void ValidateMSISDNs() throws ParseException ;


    public abstract void assertSubscriptionCardIsDisplayed(String MSISDN);

    public abstract void LoginTillReachUsernameScreen() ;

    public abstract void LoginTillReachPasswordScreen() throws InterruptedException ;

    public abstract void LoginTillReachRequestSecurityCodeScreen() throws InterruptedException ;

    public abstract void LoginTillReachChooseAccountScreen() throws InterruptedException;

    public abstract void LoginTillReachChoosePlanScreen() throws ParseException ;

    public abstract void LoginTillReachLoginPreferenceScreen() throws ParseException ;

    public abstract void validateUsernameScreenContent();

    public abstract void validatePasswordScreenContent();

    public abstract void ValidateRequestSecurityCodeScreenContent() ;

    public abstract void ValidateEnterSecurityCodeScreenContent() ;

    public abstract void ValidateChooseYourAccountScreenContent() throws ParseException ;

    public abstract void ValidateChooseYourPlanScreenContent() throws ParseException ;

    public abstract void ValidateLoginPreferencesScreenContent() throws InterruptedException ;

    public abstract void ValidateLoginToMyVodafoneScreenIsDisplayed() ;

    public abstract void UsernameScreenIsDisplayed();

    public abstract void PasswordScreenIsDisplayed();

    public abstract void RequestSecurityCodeScreenIsDisplayed();

    public abstract void ValidateTobiJourneyIsTriggered() throws InterruptedException ;
    public abstract void AppSoftClose();

    public abstract void AppHardCloseThenRelaunch() ;

    public abstract void ClickXButton();

    public abstract void ClickOnChatToUs();

    public abstract void ClickOnPhysicalBackButton() throws InterruptedException ;

    public abstract void chooseFLN();

    public abstract void chooseBB();

    public abstract void closeTheExternalWebview();

    public abstract void clickOnRegisterForMyVodafone();

    public abstract void navigateToACustomTab();

    public abstract void closeTheCustomTab();

    public abstract void navigateToForgottenPasswordExternalWebview();

    public abstract void iClickOnIhavenotReceivedMySecurityCodeLink();

    public abstract void chooseAsubscription(String c);

    public abstract void chooseAccount(String c);

    public abstract void UFLogin() throws InterruptedException;
    public abstract void clickOnLoginCTA();
    public abstract void insertUsername();
    public abstract void insertPassword();
    public abstract void choosePhone();
    public abstract void selectNumberToSendOTAC();
    public abstract void insertSecurityCode() throws InterruptedException;
    public abstract void selectPlan() throws InterruptedException;
    public abstract void selectLogPref(String logPrefChoice);
    public abstract void selectAccount();
    public abstract void UFL(String logPrefChoice) throws InterruptedException;
}

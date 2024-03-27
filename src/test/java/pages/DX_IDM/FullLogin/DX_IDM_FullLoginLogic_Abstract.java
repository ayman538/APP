package pages.DX_IDM.FullLogin;

public abstract class DX_IDM_FullLoginLogic_Abstract extends DX_IDM_FullLoginPO {


    public DX_IDM_FullLoginLogic_Abstract( ) {super();}

    public abstract void  beforeLoginUsernameAndPasswordScreen() throws InterruptedException ;

    public abstract void validateUsernameScreenContent() throws InterruptedException ;

    public abstract void validatePasswordScreenContent() throws InterruptedException;

    public abstract void validateLoginPrefScreenContent() ;

    public abstract void enterPassword() ;
    public abstract void showPassword() throws InterruptedException;

    public abstract void enterMSISDN() throws InterruptedException;
    public abstract void proceedLoginFromPasswordScreen() throws InterruptedException;
    public abstract void fullLoginWithPhoneNumberUsingMultipleContactAccount() throws InterruptedException;
    public abstract void fullLoginWithPhoneNumberUsingMultipleContactAccountSameDOB() throws InterruptedException;

    public abstract void validateInvalidPhoneNumberOrPasswordErrorMessage() ;
    public abstract void validateInvalidDOBErrorMessage() ;
    public abstract void validateInvalidPersonalDetailsErrorMessage() ;


    public abstract void validatePasswordShown() ;

    public abstract void validatePasswordHidden() ;

    public abstract void selectPIN();

    public abstract void selectPassword() ;
    public abstract void selectBiometric() ;

    public abstract void pressAllDoneCTA() ;
    public abstract void closeMyAccountScreenIfDisplayed() ;


    public abstract void fullLoginWithPIN() throws InterruptedException ;
    public abstract void fullLoginWithUNandPW() throws InterruptedException ;
    public abstract void fullLoginWithUserNameAndPwdAndAcceptCookies() throws InterruptedException;
    public abstract void userNavigateToLoginScreen();
    public abstract void acceptCookies();
    public abstract void loginWithBioUserNameAndPwd() throws InterruptedException;
    public abstract void hardClose();

    public abstract void validateDashboardDisplayedAfterFullLoginWithPIN() throws InterruptedException ;


    public abstract void validateDashboardDisplayedAfterFullLoginWithPassword() throws InterruptedException ;


    public abstract void loginJourney() throws InterruptedException ;


    //   public abstract void validateDashboardDisplayedAfterFullLoginWithPassword() throws InterruptedException ;


    public abstract void navigateToMyAccount() throws InterruptedException;

    public abstract void closeMyAccountDrawer();

    public abstract void validatePINScreenDisplayedAfterHardCloseAndOpenMyAccount() throws InterruptedException ;


    public abstract void validatePasswordScreenDisplayedAfterHardCloseAndOpenMyAccount() throws InterruptedException ;


    public abstract void enterInvalidPasswordMoreThanSixTimes() throws InterruptedException ;


    public abstract void validateLockedAccountScreen() throws InterruptedException ;


    public abstract void validateLockedScreenDisplayedAfterEnterInvalidPasswordMoreThanSixTrial() throws InterruptedException ;


    public abstract void validateResetJourneyDisplayedAfterClickOnResetPasswordOnLockedScreen() throws InterruptedException ;



    public abstract void enterPINAndClickOnContinue() throws InterruptedException ;


    public abstract void enterInValidPINAndClickOnContinue() throws InterruptedException ;


    public abstract void validateMYAccountOpenedAfterEnterValidPIN() throws InterruptedException ;


    public abstract void validateErrorScreenDisplayedAfterEnterInvalidPIN() throws InterruptedException ;



    public abstract void validatePINScreenDisplayedAfterClickOnOKCTA() ;


    public abstract void validateBlockedScreenShouldBeDisplayedAfterEnterInvalidPINFor5Times() throws InterruptedException ;


    public abstract void validateResetJourneyDisplayedAfterClickOnResetPassword() ;


    public abstract void validateCloseCTAWillDismissTheBlockedErrorScreen() ;


    public abstract void TapOnMyAccount() ;

    public abstract void ValidateUsernameIsAutoPopulated() ;

    public abstract void assertPinFieldInForgottenUsernameScreen() ;
    public abstract void assertComplexInForgottenUsernameScreen() ;
    public abstract void TapOnUniversalLink() ;
    public abstract void fullLoginWithBiometrics() throws InterruptedException;
    public abstract void enterInValidPINForFiveTimesandContinue() throws InterruptedException;
    public abstract void clickOnLoginCTA() throws InterruptedException;
    public abstract void insertUsername();
    public abstract void insertPassword();
    public abstract void selectLogPref(String LogPrefChoice);
    public abstract void FL(String logPrefChoice) throws InterruptedException;
    public abstract void returnigUserUsingUN();

    public abstract void validateBiometricsPrompt();
}

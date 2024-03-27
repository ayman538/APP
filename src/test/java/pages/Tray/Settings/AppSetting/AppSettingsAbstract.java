package pages.Tray.Settings.AppSetting;

import core.Config;
import pages.Login.Login_Abstract;
import pages.Welcome.WelcomeLogicAbstract;
import java.io.IOException;

public abstract class AppSettingsAbstract extends AppSettingsPO {

    private Login_Abstract login;
   private WelcomeLogicAbstract WelcLogic;
    private static boolean run = false;
    private static boolean resetPin = false;
    private final Config config=new Config();

    public AppSettingsAbstract()  {
        super();
    }


    public abstract void navigateToAppSettingsScreen() ;

    public abstract void clickOnAppSettings();

    public abstract void clickOnSettingsInTray();

    public abstract void assertOnItemsDisplayed();

    public abstract void assertOnItemsDisplayedForAcq();

    public abstract void AppSettingCommanItems();

    public abstract void assertCopiedMsg();

    public abstract void assertResetAppText();

    public abstract void assertOnResetCardCTAandDescription();

    public abstract void assertTitleOfResetAppScreen();

    public abstract void UserNavigatedToAppSettingsScreen();

    public abstract void assertResetAppJourney() throws IOException ;
    public abstract void resetAppFromDashboard() throws IOException;

//    public abstract void assertElementsOfUsageCard();

//    public abstract void assertElementsOfMediaCard();

//    public abstract void assertElementsOfLocationCard();

//    public abstract void assertElementsForPhoneCard();

//    public abstract void assertUsageText();

//    public abstract void assertMediaTitle() ;

//    public abstract void assertDeviceLocationTitle();

    public abstract void assertDevicePermissionsTitle();

    public abstract void assertDevicePermissionContent();

    public abstract void clickOnDevicePermissionElement();

    public abstract void assertTandCDescriptionAndVersion();

    public abstract void assertTandCTitle();

    public abstract void clickOnTandCElement();

    public abstract void assertOnLoginOptionsScreenElements();

    public abstract void clickOnSetUpYourPinCTA();

    public abstract void clickOnLoginOptionsElement();
    public abstract void choosePinLoginOption();

    public abstract void validateLoginOptionsLoginFunctionality() throws InterruptedException, IOException ;

    public abstract void assertOnLoginOptionsScreenElementsAfterLogin() ;

    public abstract void clickOnResetYourPinCTA();

    public abstract void assertFingerPrintStatus();

    public abstract void assertTextAfterPinLoginToTurnToggleOFF();

    public abstract void assertFingerPrintToggleONStatus();

    public abstract void loginWithNewPin() throws InterruptedException, IOException;

    public abstract void assertInvalidPinErrorMessageIsDisplayed();

    public abstract void ValidateSwipeBack();

    public abstract void navigateToAppSettings();

    public abstract void navigateToPrivacySettings();

    public abstract void clickOnPrivacySettings();

    public abstract void validateSwipeDown();
    public abstract void validateAppSettings();
    public abstract void validateAppSettingsDeeplink();

    public abstract void resetAppFromNewSettingsTray();

}

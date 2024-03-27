package pages.Tray.Settings.AccountSetting;

import org.json.simple.parser.ParseException;

import java.io.IOException;


public abstract class SettingsDrawerAndAccountSettingsAbstract extends SettingsDrawerAndAccountSettingsPO {

    public SettingsDrawerAndAccountSettingsAbstract(){
        super();
    }

    public abstract void ValidateSettingsDrawerItems();

    public abstract void checkLoginStatus();

    public abstract void checkIfUserIsLoggedInOrNot();

    public abstract void checkPinLoginForUserWithoutBiometrics();

    public abstract void checkPinLoginForUserWithBiometrics();

    public abstract void ValidateAccountSettingsItems();

    public abstract void clickOnSimSwap();

    public abstract void clickOnDirectDebit();

    public abstract void clickOnAddressDetails();

    public abstract void clickOnAccountManagment();

    public abstract void clickonAccountControls();

    public abstract void clickOnAccountSettings();

    public abstract void ValidateAccountSettingsNotDisplayedInDrawer();

    public abstract void ValidateSettingsDrawerForSubscription(String subSwitch) throws InterruptedException, ParseException, IOException;

    public abstract void clickOnSettings();

    public abstract void CheckAccountSettingOrderingAndTexts();

    public abstract void SpendManagerCTA();

    public abstract void SpendManagerWebView();

    public abstract void CardsAndPaymentsCTA();

    public abstract void ManageCardsAndPaymentsWebview();

    public abstract void ClickOnProfileAndAddressCTA();

    public abstract void ValidateProfileAndAddressWebviewIsDisplayed();

    public abstract void ClickOnDataNotificationsCTA();

    public abstract void ValidateDataNotificationsWebviewIsDisplayed();

    public abstract void ActivateSimCTA();

    public abstract void ValidateActivateSimWebviewIsDisplayed();
    public abstract void SimSwapCTA();
    public abstract void ValidateSimSwapWebviewIsDisplayed();
    public abstract void validateSettings();
    public abstract void validateXCTAinSettings();

    public abstract void validateAccountSettingsForSMB();

    public abstract void validateAccountSettingsForPAYGPLUS();

    public abstract void validateLogoutCTA();

    public abstract void clickOnLogoutCTA();

    public abstract void validateManageMySIMList();

    public abstract void checkWebviewsOfManageMySIMList() throws InterruptedException;


    public abstract void validateLogoutPopupMessage();
}


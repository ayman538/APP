/*package pages.Tray.Settings.AccountSetting;

import org.json.simple.parser.ParseException;
import pages.Tray.MyAccount.MyAccountLogic;
import pages.Tray.Settings.AppSetting.AppSettingsLogic;
import testdata.ReadResponse;

import java.io.IOException;

import static core.Config.getLoginStatus;
import static utils.element_helpers.ScrollHelpers.SwipeToElement;
import static utils.element_helpers.VerifyHelpers.AssertDisplayed;
import static utils.element_helpers.VerifyHelpers.IsElementDisplayed;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

@Deprecated
public class SettingsDrawerAndAccountSettingsLogic extends SettingsDrawerAndAccountSettingsPO {

    private final MyAccountLogic subsSwitch;
    private final AppSettingsLogic AppSettings;

    public SettingsDrawerAndAccountSettingsLogic() throws IOException {
        super();
        subsSwitch = new MyAccountLogic();
        AppSettings = new AppSettingsLogic();

    }

    public void ValidateSettingsDrawerItems() {
        if (ReadResponse.GetSegment().equalsIgnoreCase("PREPAY")) {
            AppSettings.clickOnSettingsInTray();
            AssertDisplayed(DB_AppSetting.isDisplayed());
            AssertDisplayed(DB_PrivacySetting.isDisplayed());
            AssertDisplayed(!IsElementDisplayed(DB_AccountSetting));
            DB_SettingsDrawerCloseButton.click();
            AssertDisplayed(!IsElementDisplayed(DB_AppSetting));

        } else {
            AppSettings.clickOnSettingsInTray();
            AssertDisplayed(DB_AppSetting.isDisplayed());
            AssertDisplayed(DB_AccountSetting.isDisplayed());
            SwipeToElement(DB_AccountSetting, "Right");
            AssertDisplayed(DB_PrivacySetting.isDisplayed());
            DB_SettingsDrawerCloseButton.click();
            AssertDisplayed(!IsElementDisplayed(DB_AppSetting));
        }

    }

    public void checkLoginStatus() {

        checkPinLoginForUserWithoutBiometrics();
        checkPinLoginForUserWithBiometrics();
        checkIfUserIsLoggedInOrNot();
    }

    public void checkIfUserIsLoggedInOrNot() {
        if (getLoginStatus().equalsIgnoreCase("False")) {
            waitForVisibility(Login_username);
            Login_Xicon.click();
        } else {
            waitForVisibility(eCare_XButton);
            eCare_XButton.click();
        }
    }

    public void checkPinLoginForUserWithoutBiometrics() {
        boolean exist = true;
        try {
            exist = Pin_Field.isDisplayed();
        } catch (Exception e) {
            exist = false;
        }
        if (exist) {
            Login_Xicon.click();
        }

    }

    public void checkPinLoginForUserWithBiometrics() {
        boolean displayed = true;

        try {
            displayed = CancelFingerPrintCTA.isDisplayed();
        } catch (Exception e) {
            displayed = false;
        }

        if (displayed) {
            CancelFingerPrintCTA.click();
            waitForVisibility(Pin_Field);
            Login_Xicon.click();
        }
    }


    public void ValidateAccountSettingsItems() {
        AppSettings.clickOnSettingsInTray();
        clickOnAccountSettings();
        clickonAccountControls();
        checkLoginStatus();

        clickOnAccountManagment();
        checkLoginStatus();

        clickOnAddressDetails();
        checkLoginStatus();

        clickOnDirectDebit();
        checkLoginStatus();

        clickOnSimSwap();
        checkLoginStatus();

        AppScreenCloseButton.click();
    }

    public void clickOnSimSwap() {
        waitForVisibility(AS_SIMSwap);
        AS_SIMSwap.click();
    }

    public void clickOnDirectDebit() {
        waitForVisibility(AS_DirectDebit);
        AS_DirectDebit.click();
    }

    public void clickOnAddressDetails() {
        waitForVisibility(AS_AddressDetails);
        AS_AddressDetails.click();
    }

    public void clickOnAccountManagment() {
        waitForVisibility(AS_ManageAccount);
        AS_ManageAccount.click();
    }

    public void clickonAccountControls() {
        waitForVisibility(AS_AccountControls);
        AS_AccountControls.click();
    }

    public void clickOnAccountSettings() {
        waitForVisibility(DB_AccountSetting);
        DB_AccountSetting.click();
    }

    //method to be called by other methods to validate account settings not displayed in settings drawer
    public void ValidateAccountSettingsNotDisplayedInDrawer() {
        AppSettings.clickOnSettingsInTray();
        AssertDisplayed(DB_AppSetting.isDisplayed());
        AssertDisplayed(DB_PrivacySetting.isDisplayed());
        AssertDisplayed(!IsElementDisplayed(DB_AccountSetting));
        DB_SettingsDrawerCloseButton.click();
    }

    public void ValidateSettingsDrawerForSubscription(String subSwitch) throws InterruptedException, ParseException, IOException {
        subsSwitch.SwitchToSubscription(subSwitch);
        ValidateAccountSettingsNotDisplayedInDrawer();

    }

}

 */

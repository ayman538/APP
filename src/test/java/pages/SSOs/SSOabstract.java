package pages.SSOs;

import org.openqa.selenium.WebElement;
import java.util.List;
public abstract class SSOabstract extends SsoPO{

    public SSOabstract(){
        super();
    }

    public abstract void navigateToBilling();
    public abstract void validateLatestBillingSSO();
    public abstract void validateViewChargesCTA();
    public abstract void validateManageExtrasCTA();
    public abstract void openManageExtrasCTA();
    public abstract void navigateToAccountSettings();
    public abstract void validateSpendManagerSSO();
    public abstract void ClickOnSpendManagerSSO();
    public abstract void ClickOnDataCapJourney();
    public abstract void validateDataCapSSO() throws InterruptedException;
    public abstract void validateUpgradeNowSSO();
    public abstract void ExitWebView();
    public abstract void AssertExitConfirmationMsg(String ConfirmationMsg);
    public abstract void validateDISCOVER_NBA_SIMOSSO();
    public abstract void validateDISCOVER_NBA_FLBB_SSO();
    public abstract void CloseWebView() throws InterruptedException;
    public abstract void FLNdashboard();
    public abstract void BBdashboard();
    public abstract void openChangeYourPlan();
    public abstract void validateChangeYourPlan();
    public abstract void openTrackAnOrder();
    public abstract void validateTrackAnOrder();
    public abstract void openMakeAPayment();
    public abstract void validateMakeAPayment();
    public abstract void openPaymentHistory();
    public abstract void validatePaymentHistory();
    public abstract void openViewMoreDetails();
    public abstract void validateViewMoreDetails();
    public abstract void validateTrackAnOrderContent();
    public abstract void validateTopupIsDisplayed();
    public abstract void ClickOnTopup();
    public abstract void ClickOnActivateVoucher();
    public abstract void validateActivateVoucher();
    public abstract void validateManageBarsContent();
    public abstract void validateIntCallsContent();
    public abstract void ValidateMarketingPrefrences();
    public abstract void NavigateToChargesSSO();
    public abstract void ValidateChargesSSOScreen();
    public abstract void ValidateTopUpItems();
    public abstract List<String> getTopupLItemsList();

    public abstract void UpgradeNow();
    public abstract void validateUpgradeScreen();





}

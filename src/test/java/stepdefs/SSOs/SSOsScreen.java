package stepdefs.SSOs;

import core.Config;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DX_IDM.FullLogin.DX_IDM_FullLoginLogic_Abstract;
import pages.DX_IDM.FullLogin.DX_IDM_FullLoginLogic_Android;
import pages.DX_IDM.FullLogin.DX_IDM_FullLoginLogic_IOS;
import pages.SSOs.SSOabstract;
import pages.SSOs.SSOandroid;
import pages.SSOs.SSOios;
import pages.SubsctionOverlay.ChargesTab.ChargesTabAbstract;
import pages.SubsctionOverlay.ChargesTab.ChargesTabAndroid;
import pages.SubsctionOverlay.ChargesTab.ChargesTabIOS;
import pages.SubsctionOverlay.ExtrasTab.ExtrasTabAbstract;
import pages.SubsctionOverlay.ExtrasTab.ExtrasTabAndroid;
import pages.SubsctionOverlay.ExtrasTab.ExtrasTabIOS;
import pages.SubsctionOverlay.SubscriptionOverlayHeader.SubscriptionOverlayAbstract;
import pages.SubsctionOverlay.SubscriptionOverlayHeader.SubscriptionOverlayAndroid;
import pages.SubsctionOverlay.SubscriptionOverlayHeader.SubscriptionOverlayIOS;
import static core.Config.getLoginStatus;

public class SSOsScreen {
    SSOabstract SSO;
    ChargesTabAbstract ChargesTab;
    SubscriptionOverlayAbstract subsOver;
    ExtrasTabAbstract extras;
    DX_IDM_FullLoginLogic_Abstract dx_idm_fullLoginLogic_abstract;

    public SSOsScreen(Config config) {
        if (config.isAndroid()) {
            dx_idm_fullLoginLogic_abstract = new DX_IDM_FullLoginLogic_Android();
            extras = new ExtrasTabAndroid();
            subsOver = new SubscriptionOverlayAndroid();
            SSO = new SSOandroid();
            ChargesTab = new ChargesTabAndroid();
        }
        if (config.isIos()) {
            dx_idm_fullLoginLogic_abstract = new DX_IDM_FullLoginLogic_IOS();
            extras = new ExtrasTabIOS();
            subsOver = new SubscriptionOverlayIOS();
            SSO = new SSOios();
            ChargesTab = new ChargesTabIOS();
        }
    }

    @Given("Proceed in full login")
    public void ProceedInFullLogin() throws InterruptedException {
        if (!getLoginStatus().equalsIgnoreCase("true")) {
            dx_idm_fullLoginLogic_abstract.navigateToMyAccount();
            try {
                dx_idm_fullLoginLogic_abstract.fullLoginWithUserNameAndPwdAndAcceptCookies();
            } catch (Exception e) {
                System.out.println("User already logged in");
            }
            dx_idm_fullLoginLogic_abstract.closeMyAccountDrawer();
        }
    }

    @Given("The user navigated to billing screen")
    public void navigatedToBillingScreen() {
        SSO.navigateToBilling();
    }

    @Then("Validate latest bill SSO is opened")
    public void ValidateLatestBillSSOIsOpened() {
        SSO.validateLatestBillingSSO();
    }

    @Given("I navigate to charges tab from subscriptions overlay")
    public void navigatedToChargesTab() {
        ChargesTab.setBeforeClass();
    }

    @Given("I navigate to extras tab from subscriptions overlay")
    public void navigatedToExtrasTab() {
        extras.navigateToExtras();
    }

    @Then("Validate view charges SSO is opened")
    public void ValidateChargesSSOIsOpened() {
        SSO.validateViewChargesCTA();
    }

    @Then("I validate manage bars and extras SSO")
    public void ValidateManageExtrasSSOIsOpened() {
        SSO.validateManageExtrasCTA();
    }

    @Then("I click manage bars and extras SSO")
    public void openManageExtrasCTA() {
        SSO.openManageExtrasCTA();
    }

    @Given("I navigate to account settings from settings")
    public void navigatedToAccountSettings() {
        SSO.navigateToAccountSettings();
    }

    @Then("Validate Spend Manager SSO is opened")
    public void ValidateSpendManagerSSOIsOpened() {
        SSO.validateSpendManagerSSO();
    }

    @Then("Click on Data Cap journey")
    public void ClickOnDataCapJourney() {
        SSO.ClickOnDataCapJourney();
    }

    @Then("Validate Data Cap SSO is opened")
    public void ValidateDataCapSSOIsOpened() throws InterruptedException {
        SSO.validateDataCapSSO();
    }

    @Given("I navigate to plan tab from Dashboard")
    public void navigatedToPlanTab() {
        subsOver.navigateToSubsOverlay();
    }
    @Then("I click on x icon in webview")
    public void exitUpgradeWebview() {
        SSO.ExitWebView();
    }

    @Then("validate on exit webview confirmation message {string}")
    public void validateOnExitWebviewConfirmationMessage(String ConfirmationMsg) {
        SSO.AssertExitConfirmationMsg(ConfirmationMsg);

    }

    @Then("click on Cancel button")
    public void clickOnCancelButton() {
        SSO.ExitWebView_ConfirmationMsg_Cancel.click();
    }

    @Then("click on Exit")
    public void clickOnExit() {
        SSO.ExitWebView_ConfirmationMsg_Exit.click();
    }

    @Then("Validate Upgrade now SSO is opened")
    public void ValidateUpgradeNowSSOIsOpened() {
        SSO.validateUpgradeNowSSO();
    }

    @Then("Validate DISCOVER_NBA_SIMO is opened")
    public void Validate_DISCOVER_NBA_SIMO_SSOIsOpened() {
        SSO.validateDISCOVER_NBA_SIMOSSO();
    }

    @Then("Validate DISCOVER_FLBB is opened")
    public void Validate_DISCOVER_FLBB_SSOIsOpened() {
        SSO.validateDISCOVER_NBA_FLBB_SSO();
    }

    @Then("Close WebView")
    public void CloseWebView() throws InterruptedException {
        SSO.CloseWebView();
    }

    @Then("Validate FLN icon in Dashboard")
    public void validateFLNIconInDashboard() {
        SSO.FLNdashboard();
    }

    @Then("Validate BB icon in Dashboard")
    public void validateBBIconInDashboard() {
        SSO.BBdashboard();
    }

    @Then("user clicks on Change your Plan")
    public void userClicksOnChangeYourPlan() {
        SSO.openChangeYourPlan();
    }

    @Then("Change your Plan is opened")
    public void changeYourPlanIsOpened() {
        SSO.validateChangeYourPlan();
    }

    @When("User click on Track an order")
    public void userClickOnTrackAnOrder() {
        SSO.openTrackAnOrder();
    }

    @Then("Validate Track an order screen is opened")
    public void validateTrackAnOrderScreenIsOpened() {
        SSO.validateTrackAnOrder();
    }


    @Then("Click on Make a payment")
    public void clickOnMakeAPayment() {
        SSO.openMakeAPayment();
    }

    @Then("Validate Make a payment is opened")
    public void validateMakeAPaymentIsOpened() {
        SSO.validateMakeAPayment();
    }

    @Then("Click on Payment history")
    public void clickOnPaymentHistory() {
        SSO.openPaymentHistory();
    }

    @Then("Validate Payment history is opened")
    public void validatePaymentHistoryIsOpened() {
        SSO.validatePaymentHistory();
    }

    @Then("Click on View more details")
    public void clickOnViewMoreDetails() {
        SSO.openViewMoreDetails();
    }

    @Then("Validate View more details is opened")
    public void validateViewMoreDetailsIsOpened() {
        SSO.validateViewMoreDetails();
    }


    @Then("Validate Track an order content")
    public void validateTrackAnOrderContent() {
        SSO.validateTrackAnOrderContent();

    }

    @Given("Dashboard loaded and Topup is displayed")
    public void dashboardLoadedAndTopupIsDisplayed() {
        SSO.validateTopupIsDisplayed();
    }

    @Then("I navigate to Topup screen")
    public void navigateToTopupScreen() {
        SSO.ClickOnTopup();
    }

    @Then("User click on Activate voucher")
    public void userClickOnActivateVoucher() {
        SSO.ClickOnActivateVoucher();
    }

    @Then("Validate Activate voucher content")
    public void validateActivateVoucherContent() {
        SSO.validateActivateVoucher();

    }

    @Then("Validate Manage extras content")
    public void validateManageExtrasContent() {
        SSO.validateManageBarsContent();
    }

    @Then("Validate second level content")
    public void validateSecondLevelContent() {
        SSO.validateIntCallsContent();
    }

    @Then("Validate Marketing preferences screen")
    public void validateMarketingPreferencesScreen() {
        SSO.ValidateMarketingPrefrences();
    }


    @Then("I should be navigated to Estimated charges SSO")
    public void iShouldBeNavigatedToEstimatedChargesSSO() {SSO.NavigateToChargesSSO();
    }


    @Then("Validate new changes Estimated charges SSO")
    public void validateNewChangesEstimatedChargesSSO() { SSO.ValidateChargesSSOScreen();
    }

    @Given("I should validate TopUp screen Items")
    public void iShouldValidateTopUpScreenItems() {
        SSO.ValidateTopUpItems();
    }

    @Then("I should navigate to Topup")
    public void iShouldNavigateToTopup() {
        SSO.ClickOnTopup();
    }

    @When("I click on Upgrade Now")
    public void iClickOnUpgradeNow() {
        SSO.UpgradeNow();
        
    }

    @Then("Trade-in and upgrade Screen will displayed")
    public void tradeInAndUpgradeScreenWillDisplayed() {
        SSO.validateUpgradeScreen();
    }
}

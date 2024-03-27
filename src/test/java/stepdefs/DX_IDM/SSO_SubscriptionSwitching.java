package stepdefs.DX_IDM;

import core.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.json.simple.parser.ParseException;
import pages.DX_IDM.SSO_SubscriptionsSwitching.SSO_SubscriptionsSwitchingAbstract;
import pages.DX_IDM.SSO_SubscriptionsSwitching.SSO_SubscriptionsSwitchingAndroid;
import pages.DX_IDM.SSO_SubscriptionsSwitching.SSO_SubscriptionsSwitching_IOS;

import java.io.IOException;

public class SSO_SubscriptionSwitching {

    private SSO_SubscriptionsSwitchingAbstract sSO_SubscriptionsSwitching;


    public SSO_SubscriptionSwitching(Config config) throws IOException {
        if (config.isAndroid()) sSO_SubscriptionsSwitching = new SSO_SubscriptionsSwitchingAndroid();
        if (config.isIos()) sSO_SubscriptionsSwitching = new SSO_SubscriptionsSwitching_IOS();
    }

    @Given("InitControlTilesLogic_ssoLogicObject")
    public void InitControlTilesLogic_ssoLogicObject() {
        sSO_SubscriptionsSwitching.InitControlTilesLogic_ssoLogicObject();
    }

    @When("LoginAndSwitchToSubscriptionSMP_MPS")
    public void LoginAndSwitchToSubscriptionWithSMB_MPS_OverWIFI() throws ParseException, InterruptedException {
        sSO_SubscriptionsSwitching.LoginAndSwitchToSubscription("SMP MPS");
    }

    @And("clickOnControlTileAndValidateUpgradeNow")
    public void clickOnControlTileAndValidateUpgradeNow() throws InterruptedException {
        sSO_SubscriptionsSwitching.clickOnControlTileAndValidateUpgradeNow();
    }



    @Given("InitControlTilesLogic_extrasLogic_ssoLogicObjects")
    public void InitControlTilesLogic_extrasLogic_ssoLogic() {
        sSO_SubscriptionsSwitching.InitControlTilesLogic_extrasLogic_ssoLogic();
    }

    @When("LoginAndSwitchToSubscriptionConsumer_MPS")
    public void LoginAndSwitchToSubscriptionWithConsumerMPS_OverWIFI() throws ParseException, InterruptedException {
        sSO_SubscriptionsSwitching.LoginAndSwitchToSubscription("Consumer MPS");
    }

    @And("ClickOnControlTileAndNavigateToExtrasAndClickOnSpendManagerSSO")
    public void ClickOnControlTileAndNavigateToExtrasAndClickOnSpendManagerSSO() throws InterruptedException {
        sSO_SubscriptionsSwitching.ClickOnControlTileAndNavigateToExtrasAndClickOnSpendManagerSSO();
    }


    @Given("InitBillingLogicObject")
    public void InitBillingLogic() {
        sSO_SubscriptionsSwitching.InitBillingLogicObject();
    }

    @When("LoginAndSwitchToSubscriptionSMB_MBB")
    public void LoginAndSwitchToSubscriptionWithSMB_MBB_Over3G() throws ParseException, InterruptedException {
        sSO_SubscriptionsSwitching.LoginAndSwitchToSubscription("SMB MBB");
    }

    @And("navigateToBilling")
    public void navigateToBilling() {
        sSO_SubscriptionsSwitching.navigateToBilling();
    }


    //    @When("Switching Between Account Subscriptions to PayG MPS over WIFI")
//    public void SSO_SubscribtionSwitchingToPayG_MPS() throws ParseException, InterruptedException {
//        sSO_SubscriptionsSwitching.SSO_SubscribtionSwitchingwithPayG_MPS("PayG MPS");
//    }


    @When("LoginAndSwitchToSubscriptionSoleTrader_MBB")
    public void LoginAndSwitchToSubscriptionWithSoleTraderMBB_over3G() throws ParseException, InterruptedException {
        sSO_SubscriptionsSwitching.LoginAndSwitchToSubscription("SoleTrader MBB");
    }

    @And("clickOnSettingsThenClickOnAccountSettingsThenClickonAccountControls")
    public void clickOnSettingsThenClickOnAccountSettingsThenClickonAccountControls() {
        sSO_SubscriptionsSwitching.clickOnSettingsThenClickOnAccountSettingsThenClickonAccountControls();
    }


    @Given("InitControlTilesLogic_extrasLogic_extrasPO")
    public void InitControlTilesLogic_extrasLogic_extrasPO() {
        sSO_SubscriptionsSwitching.InitControlTilesLogic_extrasLogic_extrasPO();
    }

    @When("LoginAndSwitchToSubscriptionFLN")
    public void LoginAndSwitchToSubscriptionWithFLN_overWIFI() throws ParseException, InterruptedException {
        sSO_SubscriptionsSwitching.LoginAndSwitchToSubscription("FLN");
    }

    @And("ClickOnControlTileThenNavigateToExtrasThenClickOnExtras_BuyManageExtrasCTA")
    public void ClickOnControlTileThenNavigateToExtrasThenclickOnExtras_BuyManageExtrasCTA() throws InterruptedException {
        sSO_SubscriptionsSwitching.ClickOnControlTileThenNavigateToExtrasThenClickOnExtras_BuyManageExtrasCTA();
    }


    @Given("InitAppSettingsLogic_settingsDrawer_AccountSettingsLogic")
    public void InitAppSettingsLogic_settingsDrawer_AccountSettingsLogic() throws IOException {
        sSO_SubscriptionsSwitching.InitAppSettingsLogic_settingsDrawer_AccountSettingsLogic();
    }

    @When("The user login and switch to subscription HBB")
    public void LoginAndSwitchToSubscriptionWithHBB_over3G() throws ParseException, InterruptedException {
        sSO_SubscriptionsSwitching.LoginAndSwitchToSubscription("HBB");
    }

    @And("clickOnSettingsInTrayThenClickOnAccountSettingsThenClickOnAccountManagment")
    public void clickOnSettingsInTrayThenClickOnAccountSettingsThenClickOnAccountManagment() {
        sSO_SubscriptionsSwitching.clickOnSettingsInTrayThenClickOnAccountSettingsThenClickOnAccountManagment();
    }


    // @Then()
}

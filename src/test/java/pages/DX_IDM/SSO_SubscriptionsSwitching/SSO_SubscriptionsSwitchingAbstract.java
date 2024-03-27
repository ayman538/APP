package pages.DX_IDM.SSO_SubscriptionsSwitching;

import org.json.simple.parser.ParseException;

import java.io.IOException;

public abstract class SSO_SubscriptionsSwitchingAbstract {


    public SSO_SubscriptionsSwitchingAbstract()  {
    }

    public abstract void InitControlTilesLogic_ssoLogicObject();

    public abstract void LoginAndSwitchToSubscription(String userType) throws InterruptedException, ParseException ;

    public abstract void clickOnControlTileAndValidateUpgradeNow() throws InterruptedException ;

    public abstract void InitControlTilesLogic_extrasLogic_ssoLogic() ;

    public abstract void ClickOnControlTileAndNavigateToExtrasAndClickOnSpendManagerSSO() throws InterruptedException ;

    public abstract void InitBillingLogicObject() ;

    public abstract void navigateToBilling() ;

//    public void SSO_SubscribtionSwitchingwithPayG_MPS(String userType) throws InterruptedException, ParseException ;

    public abstract void InitAppSettingsLogic_settingsDrawer_AccountSettingsLogic() throws IOException ;


    public abstract void clickOnSettingsThenClickOnAccountSettingsThenClickonAccountControls() ;


    public abstract void InitControlTilesLogic_extrasLogic_extrasPO() ;

    public abstract void ClickOnControlTileThenNavigateToExtrasThenClickOnExtras_BuyManageExtrasCTA() throws InterruptedException ;

    public abstract void clickOnSettingsInTrayThenClickOnAccountSettingsThenClickOnAccountManagment() ;

}

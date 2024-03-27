@3G @WIFI @DXIDM  @SSO
Feature:SSO journeys to eCare for Subscriptions switching

  Scenario:SSo Subscriptions Switching "SMP MPS" Over WIFI
    Given InitControlTilesLogic_ssoLogicObject
    When LoginAndSwitchToSubscriptionSMP_MPS
    And  clickOnControlTileAndValidateUpgradeNow


  Scenario:SSo Subscriptions Switching "Consumer MPS" Over WIFI
    Given InitControlTilesLogic_extrasLogic_ssoLogicObjects
    When LoginAndSwitchToSubscriptionConsumer_MPS
    And ClickOnControlTileAndNavigateToExtrasAndClickOnSpendManagerSSO


  Scenario:SSo Subscriptions Switching "SMB MBB" Over 3G
    Given InitBillingLogicObject
    When LoginAndSwitchToSubscriptionSMB_MBB
    And navigateToBilling

#  Scenario:SSo Subscriptions Switching "PayG MPS"
#    When Switching Between Account Subscriptions to PayG MPS over WIFI

  Scenario:SSo Subscriptions Switching "SoleTrader MBB" Over 3G
    Given InitAppSettingsLogic_settingsDrawer_AccountSettingsLogic
    When LoginAndSwitchToSubscriptionSoleTrader_MBB
    And clickOnSettingsThenClickOnAccountSettingsThenClickonAccountControls


  Scenario:SSo Subscriptions Switching "FLN" Over WIFI
    Given InitControlTilesLogic_extrasLogic_extrasPO
    When LoginAndSwitchToSubscriptionFLN
    And ClickOnControlTileThenNavigateToExtrasThenClickOnExtras_BuyManageExtrasCTA

  Scenario:SSo Subscriptions Switching "HBB" Over WIFI
    Given InitAppSettingsLogic_settingsDrawer_AccountSettingsLogic
    When The user login and switch to subscription HBB
    And clickOnSettingsInTrayThenClickOnAccountSettingsThenClickOnAccountManagment
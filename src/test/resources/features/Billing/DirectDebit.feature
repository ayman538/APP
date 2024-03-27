@CONSUMER
Feature: Direct Debit

  @SANITY @TC611531 @TC_601901 @REGRESSION @MPS @3G
  Scenario: Validate Direct Debit UI
    Given I am MVA user and logged in using Soft Login
    And I should be navigated to dashboard
    Then InitBillingLogicObject
    Then navigateToBilling
    Then I should see the new billing dashboard
    Then Validate Direct Debit Card UI

  @SANITY @TC650990 @LOGIN @REGRESSION @MPS @3G @CCS
  Scenario: Check Direct Debit Functionality
    Given Click on Login CTA
    Given Preform FL Using Login Preference Method "un"
    And I should be navigated to dashboard
    Then The user navigated to billing screen
    When Click on Direct Debit CTA
    And click on accept it in The Cookie permission message
    Then Validate Direct Debit SSO screen is displayed

  @TC_664639 @REGRESSION @Special @SubswitchToFLN @LOGIN @MPS
  Scenario: Check the new changes in Reinvent webview  when accessing  "DIRECT_DEBIT" journey using a UFL FLN child
    Given Click on Login CTA
    Given Preform FL Using Login Preference Method "un"
    Then I should be navigated to dashboard
    Then I navigate to my account from dashboard tray
    Then I navigate to sub switch to "FLN" Subscription
    Then InitBillingLogicObject
    Then navigateToBilling
    Then I should see the new billing dashboard
    Then Click on Direct Debit CTA
    Then Validate Direct Debit SSO screen is displayed
    Then Validate Direct debit SSO Close btn

  @TC_650992 @WIFI @MPS @LOGIN
  Scenario: Check the app behavior when first time UFL Consumer MPS User access the Direct debit
    Given Click on Login CTA
    Given Preform FL Using Login Preference Method "un"
    Then The user navigated to billing screen
    When Click on Direct Debit CTA
    And click on accept it in The Cookie permission message
    Then Validate Direct Debit SSO screen is displayed

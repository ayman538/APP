@3G
Feature: Extras tab for all users
  Background:
    Given I am MVA user and logged in using Soft Login

  @SANITY @REGRESSION @TC_95613 @TC_225880 @TC_601809 @TC_99837 @TC_225912 @TC_601829 @CONSUMER @SMB @SOLETRADER @RED @PAYG
  Scenario: P1 - Check the display of (Extra bars and caps) card for PAYM, PAYG users_Functional
    Given Navigate to SubsOverlay
    And Navigate to Extras
    Then Validate Extras Bars and Caps Card


  @REGRESSION @TC_955628 @TC_225881 @TC_601810 @CONSUMER @SMB @SOLETRADER @RED
  Scenario: P1 - Check the display of (Buys and manage extras) CTA only for PAYM_Functional
    Given Navigate to SubsOverlay
    And Navigate to Extras
    When Press Extras Bars and Caps CTA
    Then Validate Login screen appears

  @SANITY @REGRESSION @TC_99757 @TC_225905 @TC_601824 @CONSUMER @PREPAY @SMB
  Scenario: P1 - Check allowances details using PayM user_UI
    Given Navigate to SubsOverlay
    And Navigate to Extras
    Then Validate Extra Allowances Card
    Then Validate Extra Allowances items details

  @HBB @TC_1071944 @TC_1071945
  Scenario: Check the content of Extras tab for HBB user has an affiliate or promo discount
    Given I close the tutorial if displayed
    When I am MVA user and logged in using full login with user name and password
    And The user switch to subscription HBB
    And Navigate to SubsOverlay
    And Navigate to Extras
    Then User should see his Affiliate or Promo Discount

  @HBB @TC_1109188 @TC_1109189 @REGRESSION @SubswitchToHBB @LOGIN
  Scenario: Check updated copy of "Manage Controls and Limits" CTA and It's redirection
    Given I close the tutorial if displayed
    And I am MVA user and logged in using full login with user name and password
    When I navigate to sub switch to SubscriptionType "BB" and Segment "CONSUMER"
    And Navigate to SubsOverlay
    And Navigate to Extras
    Then Validate Manage Controls and Limits copy
    Then Validate the redirection of Manage controls and Limits
@DXIDM @LOGIN
Feature: DX IDM Full Login feature

  @TC_630955 @MPS
  Scenario: TC 519809:02_P1_Check the UI after password is entered incorrectly more than 5 times during DX IDM Login and error message appears_UI
    Given I am MVA user and logged in using full login with user name and password
    When HardClose the App and Relaunch
    Then Validate Dashboard displayed after hard close
    When Click on My Account from dashboard tray
    Then Validate Password Screen
    When Enter invalid password more than six times
    Then Validate Locked your account screen

  @TC_630956 @REGRESSION @MPS
  Scenario: Test Case 519810: 4333797.03_P2_Check reset password link journey in account locked message for softlogged in PAYM user_Functional
    Given Locked Password Screen displayed
    When Click on Reset Password On Locked Screen

  @TC_630954 @3G @MPS
  Scenario: Check app behavior when click on "Close" CTA in the "locked account" pop up screen
    Given I am MVA user and logged in using full login with PIN
    When HardClose the App
    And I close the tutorial if displayed
    And Click on My Account
    And  Enter inValid PIN for 5 Times and Continue
    Then User should be blocked
    When Click on Close CTA The Blocked screen should be closed
    Then  Validate PIN Screen

  @TC_630953  @3G @MPS
  Scenario: Check app behavior when click on "Reset Password" CTA in the "locked account" pop up screen
    Given I am MVA user and logged in using full login with PIN
    When HardClose the App
    And I close the tutorial if displayed
    And Click on My Account
    And  Enter inValid PIN for 5 Times and Continue
    Then User should be blocked
    When Click on Reset Password and validate
    And Click on back
    Then  Validate PIN Screen
    And Enter valid PIN "2580"
    Then User should be blocked
    When Click on Close CTA The Blocked screen should be closed
    Then  Validate PIN Screen




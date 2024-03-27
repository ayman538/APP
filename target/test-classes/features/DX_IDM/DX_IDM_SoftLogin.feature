@3G @DXIDM

Feature: DX IDM Soft Login feature

  Background:
    Given I am MVA user and logged in using Soft Login
    And I navigate to my account from dashboard tray
    And Accept cookies


  @TC_630911 @3G @REGRESSION @MPS @SOFTLOGIN
  Scenario: Check back icon on "Verify your account" screen
    And Tap on forgot username
    And Click on back
    Then Validate username screen content

  @TC_630907 @3G @REGRESSION @MPS @SOFTLOGIN
  Scenario: Check back icon on "Reset your password" screen
#    Given I am MVA user and logged in using Soft Login
#    And soft login
#    And I navigate to my account from dashboard tray
#    And Accept cookies
    And Validate Username screen and Insert Username
    And Click on Forgotten password
    And Click on back
    Then Validate username screen content

  @TC_925717 @MPS @3G
  Scenario: Check opening the app by clicking the app icon after softclose
      Given I am MVA user and logged in using Soft Login
      And I should be navigated to dashboard
      When App SoftClose Then Relaunch it
      And I close the tutorial if displayed
      Then I should be navigated to dashboard

  @TC_505779 @TC_505780 @TC_505782 @TC_505783 @TC_505784 @TC_505785 @TC_505786 @TC_505787 @TC_505789
  Scenario: Validate Dashboard appears after Soft Login
    Given Click Continue in Welcome screen
    And Click Continue in privacy screen
    And Click Continue in permission screen
    Then Validate Dashboard appears
@REDHYBRID @3G @SIT-Cycle-5  @Regression_Active_Payment
Feature: Red Hybrid - MVA - Settings (App/Account/Privacy)

  Background:
    Given I am MVA user and logged in using Soft Login
    And  user dismiss the add payment method overlay
    When user clicks on Settings in Dashboard tray
    And  Settings drawer appeared successfully


  @TC_624088
  Scenario: P1_check UI of App Settings for Red Hybrid user
    When user clicks on App in settings drawer
    Then App Settings for Red Hybrid user appeared successfully
    Then Assert on Copied message of hardwareID

  @TC_624089
  Scenario: P1_check behavior of "Reset the app" link in App Settings
    When user clicks on App in settings drawer
    Then App Settings for Red Hybrid user appeared successfully
    And  user clicks on reset the app link
    Then reset the app screen appeared successfully
    Then Assert on Reset app card CTA and description

  @TC_624091  @LOGIN
  Scenario: P2_check behavior of "Login options" link in App Settings for soft logged in Red Hybrid user
    When user clicks on App in settings drawer
    And  user clicks on Login options link
    And  I am MVA user and logged in using full login with user name and password
    Then Login options screen appeared successfully

  @TC_624092
  Scenario: P1_check behavior of "Device permissions" link in App Settings
    When user clicks on App in settings drawer
    Then App Settings for Red Hybrid user appeared successfully
    And  user clicks on Device permissions link
    Then Device permissions screen appeared successfully

  @TC_624093
  Scenario: P1_check behavior of "Terms and Conditions" link in App Settings
    When user clicks on App in settings drawer
    Then App Settings for Red Hybrid user appeared successfully
    And  user clicks on Terms and Conditions link
    Then Terms and Conditions screen appeared successfully
    Then Assert on T&C Description and Version

  @TC_624094
  Scenario: P1_check behavior of "App privacy" link in Privacy Settings
    When user clicks on Privacy in settings drawer
    And  Privacy Settings for Red Hybrid user appeared successfully
    Then click on app privacy and validate screen the screen content

  @TC_624095
  Scenario: P1_check behavior of "Marketing preferences" link in Privacy Settings _FUNC
    When user clicks on Privacy in settings drawer
    And  Privacy Settings for Red Hybrid user appeared successfully
    And  user clicks on Marketing preferences link
    Then check Marketing preferences screen content appeared successfully

  @TC_624096
  Scenario: P1_check behavior of "App Privacy Supplement" link in Privacy Settings
  When user clicks on Privacy in settings drawer
  And  Privacy Settings for Red Hybrid user appeared successfully
  Then Validate App Privacy Supplement Chevrons
  And check App Privacy Supplement screen content appeared successfully


  @TC_624097
  Scenario:P1_check behavior of "Vodafone Privacy Portal" link in Privacy Settings
    When user clicks on Privacy in settings drawer
    And  Privacy Settings for Red Hybrid user appeared successfully
    And  user clicks on Vodafone Privacy Portal link
    Then Vodafone Privacy Portal screen appeared successfully

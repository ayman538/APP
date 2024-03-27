# new feature
Feature: DP&C - Settings - Settings tray new UI

  @TC_1771958 @TC_1771961 @TC_1771964 @TC_1771988 @CONSUMER @MBB @PREPAY @PAYG @RH
  Scenario: Check app behavior when MVA user taps on "Settings" tray in dashboard
    Given I am MVA user and logged in using Soft Login
    And I click on settings from dashboard Tray
    Then Validate New Settings Drawer Items

  @TC_1771964
  Scenario: Check app behavior when user taps on dismissal button of "Settings" tray
    Given I am MVA user and logged in using Soft Login
    And I click on settings from dashboard Tray
    Then I validate the 'X' CTA in Settings Drawer

  @TC_1777870 @UNKNOWN_USER
  Scenario: Check app behavior when Unknown user taps on "Settings" tray in Acquisition dashboard
    Given  I click on Return to my vodafone CTA
    And I click on settings from dashboard Tray
    Then Validate New Settings Drawer Items

  @TC_1771967 @PAYM
  Scenario: Check changes in Dashboard api for App and Privacy settings for root Paym user
    Given I am MVA user and logged in using Soft Login
    Then Validate changes of SettingsItems in Dashboard api for App Settings for PaymUser
    Then Validate changes of SettingsItems in Dashboard api for Privacy Settings for PaymUser

  @PAYM @TC_1998724 @TC_1998729 @TC_1998730 @TC_1998734
  Scenario: E2E Scenario for the new setting tray
    Given I am MVA user and logged in using Soft Login
    When  I navigate to settings from dashboard tray
    And I navigate to App settings screen
    Then I validate App settings is displayed
    And  I navigate to settings from dashboard tray
    And I click on Privacy Settings
    And I click on Cookie Permissions
    Then I redirected to 'Cookie permission' screen
    And I opt "Targeting" cookie with the "ON" state
    And I opt "Functional" cookie with the "ON" state
    And I opt "Performance" cookie with the "ON" state
    When I click on the back icon for settings screens
    And I click on Network And Service
    Then I Validate 'Network And Service' screen from settings without link
    When I click on the back icon for settings screens
    And I click on Device Permissions entry point
    Then I navigate to Device permissions screen without enabling targeting cookies link
    When I click on the back icon for settings screens
    And I click on Vodafone Privacy Information entry point
    Then I navigate to Vodafone Privacy Portal screen
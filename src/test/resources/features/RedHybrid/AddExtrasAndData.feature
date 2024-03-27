@3G @RedHybrid @Regression_Active_NO_Payment

Feature: 666282 - Red Hybrid - Dashboard - Add Extras and Data - Add payment method before journey
  Background: Launch the app using Red Hybrid user that has no payment method added and user clicked
  on "Add Data" or "Add Extras" in dashboard or subs overlay tab - User soft logged in
    Given I am MVA user and logged in using Soft Login

  @TC_696077 @TC_1347476
  Scenario: Check the behavior when user click on add data CTA on dashboard_FUN
    Given user is on dashboard
    When  User click on add data CTA
    Then  I should be navigated to an overlay to 'Add a new payment method' while trying to 'add-data'

  @TC_696080 @TC_1347476
  Scenario: Check the behavior when user click on add extras CTA on dashboard_FUN
    Given user is on dashboard
    When  User click on add extras CTA
    Then  I should be navigated to an overlay to 'Add a new payment method' while trying to 'add-extra'

  @TC_696081 @TC_1347476
  Scenario: Check the behavior when user click on buy extras CTA in extras tab in the subscription overlay_FUN
    Given user is on dashboard
    Then  user click on plan tile
    And   user click on extras tab
    And   User click on add extras CTA in subs overlay
    And   I should be navigated to an overlay to 'Add a new payment method' while trying to 'add-extra'
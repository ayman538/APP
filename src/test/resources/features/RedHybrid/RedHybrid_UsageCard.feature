@SIT_CYCLE1 @ACTIVE_PLAN @Regression_Active_NO_Payment
#@3G @RedHybrid
Feature: Red Hybrid - Subscriptions Overlay - Usage tab - Usage card

  Background: launched app with Redhybrid user that navigates to dashboard
    Given I am MVA user and logged in using Soft Login
    When  user dismiss the add payment method overlay
    Then  I navigate to subscriptions overlay
    When  I navigate to usage tab from subscriptions overlay

  @TC_583547
  Scenario: TC_583547: Check the displaying of the usage card for RedHybrid user has an active plan with auto renew on
    Then  usage tab should be displayed

  @TC_583556
  Scenario: TC_583556: P1_Check Mapping of the data retrieved from GetBalance DXL API with the Usage card_Functional
    Then  data is mapped correctly between usage API response and UI
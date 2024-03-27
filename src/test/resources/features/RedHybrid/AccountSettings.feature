@3G @RedHybrid @REDHYBRID @LOGIN  @SIT-Cycle-5 @Regression_Active_Payment
Feature: Account Settings

  Background:
    Given I am MVA user and logged in using full login with user name and password
    When user dismiss the add payment method overlay
    And  close my account sheet
    And  I should be navigated to dashboard
    And  click on my Settings on dashboard tray
    And  click on account setting


  @SANITY @REGRESSION @TC_623909 @TC_623912 @TC_623913 @TC_623914 @TC_623916 @TC_623919 @TC_623921
  Scenario Outline: : Check the behavior when User click on Account settings links
    When I click on "<Link>"
    Then I navigate to the "<Title>" Page

    Examples:
      |Link                 |Title                  |
      | Manage account      |   Manage your account |
      | Change my PIN       |   Enter your new PIN  |
      | Address details     |   Manage your address |
      | Mobile switching    |   Mobile Switching    |
      | Important documents |   Important documents |
      | Activate SIM        |   Swap my SIM         |
      | Accessibility       |   Accessibility       |


  @TC_623907 @TC_623906
  Scenario: Check the items of account settings_UI
    Then I should validate Account Settings Items

  @TC_1016871
  Scenario: Check Data Notifications items of account settings not appear for redhybrid users
    Then Validate Data Notifications item not appears in Account settings

  @TC_1016873
  Scenario: Check the Accessibility items of account settings appears for redhybrid users
    Then Validate Accessibility item appear in Account settings





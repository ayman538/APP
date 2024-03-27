@3G @RedHybrid
Feature: RedHybrid Plan card feature

  Background: launched app with Redhybrid user that navigates to dashboard
    Given I am MVA user and logged in using Soft Login

  Scenario: TC_582154: Check the UI displaying of "Plan card" in Subscriptions Overlay - Plan tab
    When  user dismiss the add payment method overlay
    Then  I should be navigated to dashboard
    And   RedHybrid Navigated to Plantab
    Then  ValidatePlanCardForRedHybrid



  Scenario: TC_582155: Check the Action of clicking on Show more button
    When  user dismiss the add payment method overlay
    Then  I should be navigated to dashboard
    And   RedHybrid Navigated to Plantab
    Then  Validate Includes Displaying


  @TC_856405 @TC_1031051 @SIT_Cycle_4
  Scenario: P1_Check Plan tab behavior in case of removing the payment method added and hardclose the app_Functional
    Given I should be navigated to dashboard
    When  RedHybrid Navigated to Plantab
    And   add card hyberLink Displayed is "false"
    And   user closes the subsoverlay
    And   I should be navigated to dashboard
    And   I navigate to payment tray from Dashboard
    And   I am MVA user and logged in using full login with user name and password
    And   Delete Payment Card
    And   I close the app and relaunch it again
    And   RedHybrid Navigated to Plantab
    Then  add card hyberLink Displayed is "true"
    ## active plan user with payment method added

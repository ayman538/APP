@3G @RedHybrid
Feature: Retrieve Payment Card

  Background:
    Given I am MVA user and logged in using Soft Login
    And   I should be navigated to dashboard
    When I click on payment on dashboard tray
    When I am MVA user and logged in using full login with user name and password
    Then I add new payment if no payment method exists

  @TC_507996
  Scenario: Check the app behavior when clicking on the continue button after a new payment method is verified_Functional
    Then Validate card is added successfully

  @TC_507997
  Scenario: check app behavior when clicking on the "x" button in the payment method screen_Functional
    When I should Validate Payment card drawer is displayed
    Then Validate X Icon close the flow

  @TC_508001
  Scenario: check app behavior when soft close the app on the add payment method screen_Functional
    When I should Validate Payment card drawer is displayed
    Then Validate The app soft close

@REGRESSION @BINGO
Feature: Tooltips

  Background:
   Given I am MVA user and logged in using Soft Login
    When I close the tutorial if displayed

  @TC_1048335 @TC_1087607 @TC_1048377 @TC_1048378 @TC_1048379 @TC_1048380
  Scenario: Check tooltips for Bingo users and dashboard after submit them
    Given Reset App from Dashboard
    When I Validate and Submit First Tip
    And I Validate and Submit Second Tip
    And I validate and Submit third Tip
    Then I navigate to settings from dashboard tray

  @TC_1048387 @TC_1048380 @TC_1048340
  Scenario: Check tooltips after reset
    Given Reset App from Dashboard
    When I Dismiss The First Tip
    Then Reset App from Dashboard
    When I Validate and Submit First Tip

  @TC_1048387 @TC_1048380 @TC_1048340
  Scenario: Check tooltips after hardclose
    Given HardClose the App
    When I close the tutorial if displayed
    When I Validate and Submit First Tip
    And I Dismiss The Second Tip
    Then Tooltips will not be displayed
    When HardClose the App
    And I close the tutorial if displayed
    Then Tooltips will not be displayed
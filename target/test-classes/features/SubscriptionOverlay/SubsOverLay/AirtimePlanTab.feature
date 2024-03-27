@3G
Feature:DevicePlanTab

  Background:
    Given I am MVA user and logged in using Soft Login

  @TC_1210449 @TC_1210450 @TC_1210451 @TC_1291603 @REGRESSION @BINGO @1210448
  Scenario: Check UI when Bingo user clicks on "What is an Airtime Plan?" link in airtime plan tab
    Given Navigate to Airtime plan tab
    When User clicks on What is an Airtime Plan? link
    And What is a Airtime Plan? new copy overlay screen should be displayed
    And User clicks on Ok, thanks CTA
    Then User should be navigated back to Airtime Plan tab

@3G @REGRESSION
Feature:RewardsTray

  Background:
    Given I am MVA user and logged in using Soft Login
    And I should be navigated to dashboard
    And I click on Rewards

  @SANITY @PAYG @TC_601800
  Scenario: Check veryme card function
    Given Validate Veryme Card
    When Click on veryme card
    Then Veryme is displayed

  @SANITY @PAYG @TC_601800 @MBB @TC_601799 @SMB @SOLETRADER
  Scenario: Check offers for you card function
    Given Validate offers for you Card
    When Click on offers for you
    Then offers for you displayed

@3G @BINGO
Feature: Unlimited Data Booster - Active
  Background:
    Given I am MVA user and logged in using Soft Login
    And I close the tutorial if displayed
    When I Dismiss The First Tip
    And Initialize Your Plans

  Scenario: Check Active Counter in Unlimited Data Booster screen when user has active data booster
    When User Selects Unlimited Data Booster
    Then Assert That Available and Used Counters Are Displayed
    And Assert That Active Counter Is Not Displayed


  @Consumer  @Bingo  @MPS  @hasDataBoosterInPlan @1207022
  Scenario: Check UI of "Unlimited Data Booster" screen for MPS users
    When User Selects Unlimited Data Booster
    Then I should see Unlimited data booster screen with "Activate by text" CTA

  @Consumer  @BINGO  @MBB  @hasDataBoosterInPlan @1207387
  Scenario: Check UI of "Unlimited Data Booster" screen for MBB subscription users
    When User Selects Unlimited Data Booster
    Then I should see Unlimited data booster screen with "Chat now" CTA
    And  I click on "Chat Now" CTA
    Then I should see the tobi chat

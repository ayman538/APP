@3G @BINGO
Feature: Unlimited Data Booster - Not Active
  Background:
    Given Initialize Your Plans

  @TC_601920
  Scenario: Check Unlimited Data Booster journey under "Includes" section in Plan Card_Functional
    When User Selects Unlimited Data Booster
    Then Assert That Unlimited Data Booster Screen Is Opened Successfully

  @TC_601922
  Scenario: Check UI of Need more data Card and Change your Plan CTA for a user that has used all boosts_UI
    When Clicks on Change your Airtime Plan
    Then Assert That Login Screen Is Opened


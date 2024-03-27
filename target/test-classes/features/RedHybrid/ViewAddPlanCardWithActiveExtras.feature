@RedHybrid

Feature: Automation First Red Hybrid - MVA - Dashboard Top Tiles
  Background:
    Given I am MVA user and logged in using Soft Login

  @TC_580871
  Scenario: Check that user can see the select new plan card in the top tiles
    When View Add plan Card when there is no Active Plan
    Then validate that the content of card appears successfully

  @TC_580872
  Scenario:  Check that user can swipe the allowance card to view his available extras
    When View Add plan Card when there is no Active Plan
    Then validate ability to swipe to view extras cards

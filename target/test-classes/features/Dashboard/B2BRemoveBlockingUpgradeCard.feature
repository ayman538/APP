@3G
Feature: B2B Remove Blocking Card

  Background: Initialize Bingo User
    Given I am MVA user and logged in using Soft Login

  @TC_909187  @TC_909188 @TC_909189 @TC_909192  @TC_909193  @Bingo_User   @Elgibile_Normal_Upgrade
  Scenario: TC01_Check existence of "Upgrade now" CTA of a bingo user has unpaid Primary loan and eligible for upgrade
    And user clicks on Your Plan control tile
    Then Validate Upgrade Card displayed






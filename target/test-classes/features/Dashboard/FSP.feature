@3G @PayMHasFSPOffer
Feature: FullScreenPromo FSP
Background: Initialize user login
  Given I am MVA user and logged in using Soft Login
  When I should be navigated to dashboard
  And HardClose the App and Relaunch

  @REGRESSION @TC_978867
  Scenario: TC01_Validate that the FSP overlay does not after the tutorial
    And I close the tutorial
    Then I should not see FSP overlay

  @REGRESSION @TC_978869
  Scenario: TC02_Check app behaviour when user accepts FSP offer
    And I close the tutorial if displayed
    And HardClose the App and Relaunch
    Then I view FSP Overlay with Multiple CTAs
    When I click on UpgradeNow CTA
    Then I should navigate to the offer webpage

  @TC_935294
  Scenario: TC03_Validate FSP overlay doesn't appear for child users
    And I close the tutorial if displayed
    And HardClose the App and Relaunch
    Then I view FSP Overlay with Multiple CTAs
    When I click on close CTA
    And I am MVA user and logged in using full login with user name and password
    And I navigate to PayM child
    Then I should not see FSP overlay

  @REGRESSION @TC_978865
  Scenario: TC04_Check app behaviour when user declines FSP offer
    And I close the tutorial if displayed
    And HardClose the App and Relaunch
    Then I view FSP Overlay with Multiple CTAs
    When I click on close CTA
    Then The FSP should be dismissed


  Scenario: TC05_Check app behaviour when return to the app after accepting the offer
    And I close the tutorial if displayed
    And HardClose the App and Relaunch
    Then I view FSP Overlay with Multiple CTAs
    When I click on UpgradeNow CTA
    Then I should navigate to the offer webpage
    When I close the offer page and return to the app
    Then I should not see FSP overlay
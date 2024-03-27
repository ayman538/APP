Feature: Controls Turn On Thank you bottom sheet

  @TC_1349292 @3G @CONSUMER @MPS @LOGIN
  Scenario: Test Case 1349292: 1039805.02_P1. Check the behavior when clicking on "Turn on" CTA using FL MPS consumer user _Functional
    Given I am MVA user and logged in using full login with user name and password
    And I click on the Manage Control And Limits tile
    Then I should be navigated to the Controls tab
    And I add any control
    When I click on Turn On CTA
    Then I should see Controls thank you bottom sheet

  @TC_1349374 @3G @CONSUMER @MPS
  Scenario: Test Case 1349374: 1039805_01_P1. Check the behavior when clicking on "Turn on" CTA using softlogged MPS soletrader user _Functional
    Given I am MVA user and logged in using Soft Login
    And I click on the Manage Control And Limits tile
    Then I should be navigated to the Controls tab
    When I add any control
    When I click on Turn On CTA
    When I am MVA user and logged in using full login with user name and password
    Then I should see Controls thank you bottom sheet

  @TC_1349718adb  @WIFI @CONSUMER @MPS @LOGIN
  Scenario: Test Case 1349718: 1039805.03_P1. Check the behavior when clicking on "Continue" CTA using UFL MPS consumer user _Functional
    Given I am MVA user and upfront logged in using user name and password
    And I click on the Manage Control And Limits tile
    Then I should be navigated to the Controls tab
    When I add any control
    When I click on Turn On CTA
    Then I should see Controls thank you bottom sheet
    And I clicks on Continue CTA
    And I should be navigated to the Controls tab
    Then I should see the added control reflected with pending status

Feature: Turn off controls

  @TC_1370101 @TC_1370550 @LOGIN @Consumer @MPS @3g
  Scenario: Check the behavior when clicking on "Turn off" CTA on the active control using FL MPS consumer
    Given I am MVA user and logged in using full login with user name and password
    And I close the tutorial if displayed
    And I should be navigated to dashboard
    When I click on the Manage Control And Limits tile
    And I should be navigated to the Controls tab
    Then I should see "Turn off" CTA for control under Active Controls Card
    And I click on "Turn off" CTA on control
    And I should navigate to "Turn off" confirmation bottom sheet

  @TC_1370551 @WIFI @Soletrader @MPS
  Scenario:  Check the behavior when clicking on the "X" CTA on the confirmation tray using a UFL MPS soletrader user
    Given I am MVA user and logged in using full login with user name and password
    And I close the tutorial if displayed
    And I should be navigated to dashboard
    When I click on the Manage Control And Limits tile
    And I should be navigated to the Controls tab
    And I click on "Turn off" CTA on control
    And I should navigate to "Turn off" confirmation bottom sheet
    And I click on X CTA for confirmation bottom sheet
    Then I should be navigated to the Controls tab

  @TC_1370553 @3g @Consumer @MPS
  Scenario: Check the behavior when clicking on the "Turn off" CTA on the confirmation tray using a softlogged MPS consumer
    Given I am MVA user and logged in using Soft Login
    And I close the tutorial if displayed
    And I should be navigated to dashboard
    When I click on the Manage Control And Limits tile
    And I should be navigated to the Controls tab
    And I click on "Turn off" CTA on control
    And I should navigate to "Turn off" confirmation bottom sheet
    And I click on Turn off CTA from confirmation bottom sheet
    Then I am MVA user and logged in using full login with user name and password
    And I should navigate to Turn off thank you bottom sheet


  @TC_1370554 @TC_1370555 @LOGIN @Consumer @MPS @3g
  Scenario: Check the behavior when clicking on the "X" CTA on the "thank you" tray using a FL MPS Bingo consumer
    Given I am MVA user and logged in using full login with user name and password
    And I close the tutorial if displayed
    And I Dismiss The First Tip
    And I should be navigated to dashboard
    When I click on the Native Add Extras tile
    Then I should be navigated to the Native Extras tab
    When I click on the Controls tab
    Then I should be navigated to the Controls tab
    And I click on "Turn off" CTA on control
    And I should navigate to "Turn off" confirmation bottom sheet
    And I click on Turn off CTA from confirmation bottom sheet
    Then I should navigate to Turn off thank you bottom sheet
    And I click on X CTA from thank you bottom sheet
    And I should be navigated to the Controls tab
    And I should find the dimmed "Turn off" CTA


  @TC_1370714 @Soletrader @3g @MPS
  Scenario: Check the behavior when clicking on the "Continue" CTA on the "Thank you" tray using a softlogged MPS soletrader
    Given I am MVA user and logged in using Soft Login
    And I close the tutorial if displayed
    And I should be navigated to dashboard
    When I click on the Manage Control And Limits tile
    And I should be navigated to the Controls tab
    And I click on "Turn off" CTA on control
    And I should navigate to "Turn off" confirmation bottom sheet
    And I click on Turn off CTA from confirmation bottom sheet
    And I am MVA user and logged in using full login with user name and password
    And I should navigate to Turn off thank you bottom sheet
    And I clicks on Continue CTA
    Then I should be navigated to the Controls tab
    And I should find the dimmed "Turn off" CTA


  @TC_1371115 @WIFI @Soletrader @MPS
  Scenario: Check the behavior when having "Spend Manager" under active controls using UFL MPS soletrader
    Given I am MVA user and logged in using full login with user name and password
    And I close the tutorial if displayed
    And I should be navigated to dashboard
    When I click on the Manage Control And Limits tile
    And I should be navigated to the Controls tab
    Then I should see Spend Manager control with "Manage" CTA



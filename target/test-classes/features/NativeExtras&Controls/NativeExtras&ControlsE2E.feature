Feature: Native extras and controls E2E flows for regression

  @TC_1531883 @3G @CONSUMER @MPS @LOGIN
  Scenario: Check the happy flow of adding extra journey using a softlogged MPS consumer user
    Given I am MVA user and logged in using full login with user name and password
    And I close the tutorial if displayed
    And I should be navigated to dashboard
    And I click on the Native Add Extras tile
    And I should be navigated to the Native Extras tab
    And I click on the "Calling"
    And I should be navigated to "Calling" Category Bottom Screen
    And I should see "Calling" category bottom sheet screen details
    And I select one of the extras on Category Bottom Sheet
    And I clicks on Continue CTA
    And I should be navigated to the "Calling" Confirm Bottom Sheet
    And I should see "Calling" Confirm Bottom Content
    And I click on Buy CTA
    And I should see the Thank you bottom sheet details
    When I Click on X CTA on Thank you bottom sheet
    Then I should see added extra under Active Extras with pending status

  @TC_1531893 @3G @CONSUMER @MPS @LOGIN
  Scenario: Check opting out/removing any extra journey
    Given I am MVA user and logged in using full login with user name and password
    And I close the tutorial if displayed
    And I should be navigated to dashboard
    And I click on the Native Add Extras tile
    And I should be navigated to the Native Extras tab
    And I should see "Opt out" CTA for recurring extra
    And I click on "Opt out" for CTA for recurring extra
    And I should be navigated to "Opt out" Confirmation Tray
    And I click on Opt CTA on the Opting Confirmation Tray
    And  I should see Opt Out Thank You Tray Content
    And I click on X CTA for Opting Thank You Tray
    Then I should be navigated to the Native Extras tab
    And I should see "Opt out" CTA disabled

  @TC_1531894 @3G @CONSUMER @MPS @LOGIN
  Scenario: Check re-opting in for any extra journey
    Given I am MVA user and logged in using full login with user name and password
    And I close the tutorial if displayed
    And I should be navigated to dashboard
    And I click on the Native Add Extras tile
    And I should be navigated to the Native Extras tab
    And I should see "Re-Opt In" CTA for recurring extra
    And I click on "Re-Opt In" for CTA for recurring extra
    And I should be navigated to "Re-Opt In" Confirmation Tray
    And I click on X CTA for Opting Confirmation Tray
    And  I should see Re-Opt In Thank You Tray Content
    And I click on X CTA for Opting Thank You Tray
    Then I should be navigated to the Native Extras tab
    And I should see "Re-Opt In" CTA disabled


  @TC_1586504 @LOGIN @Consumer @MPS
  Scenario: Check adding control journey
    Given I am MVA user and logged in using full login with user name and password
    And I close the tutorial if displayed
    And I should be navigated to dashboard
    When I click on the Manage Control And Limits tile
    And I should be navigated to the Controls tab
    And I navigate and check first level control subcategory
    And I navigate and check first level confirm bottom sheet
    And I click on Turn On CTA
    Then I should see Controls thank you bottom sheet
    And I clicks on Continue CTA
    And I should be navigated to the Controls tab
    And I should see the added control reflected with pending status


  @TC_1586497 @Consumer @MPS @LOGIN
  Scenario: Check the happy flow of adding a zero level control journey using UFL Bingo consumer
    Given I am MVA user and logged in using full login with user name and password
    And I close the tutorial if displayed
    And I should be navigated to dashboard
    When I click on the Manage Control And Limits tile
    And I should be navigated to the Controls tab
    And I should see "Turn off" CTA for control under Active Controls Card
    And I click on "Turn off" CTA on control
    And I should navigate to "Turn off" confirmation bottom sheet
    And I click on Turn off CTA from confirmation bottom sheet
    And I should navigate to Turn off thank you bottom sheet
    And I clicks on Continue CTA
    Then I should be navigated to the Controls tab
    And I should find the dimmed "Turn off" CTA

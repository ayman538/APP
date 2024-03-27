Feature: Category Bottom Sheet

  @TC_1048357 @3g @CONSUMER @MPS @SoftLogin
  Scenario: 990748.01_P1_Check the existence of the category bottom sheet when clicking on each Category using softlogged MPS consumer user_Functional
    Given I am MVA user and logged in using Soft Login
    And I close the tutorial if displayed
    And I should be navigated to dashboard
    And I click on the Native Add Extras tile
    When I should be navigated to the Native Extras tab
    And I click on the "Data"
    Then I should be navigated to "Data" Category Bottom Screen

  @TC_1048358 @3G @CONSUMER @MPS @LOGIN
  Scenario: 990748.02_P1_ Check the content of the category bottom sheet when clicking on any of the Category using FL MPS soletrader user_UI
    Given I am MVA user and logged in using full login with user name and password
    And I close the tutorial if displayed
    And I should be navigated to dashboard
    And I click on the Native Add Extras tile
    When I should be navigated to the Native Extras tab
    And I click on the "Roaming"
    And I should be navigated to "Roaming" Category Bottom Screen
    Then I should see "Roaming" category bottom sheet screen details

  @TC_1048359 @3G @CONSUMER @MPS
  Scenario: 990748.03_P2_ Check the behavior when clicking on X CTA on the Category bottom sheet using FL MPS consumer user_Functional
    Given I am MVA user and logged in using full login with user name and password
    And I close the tutorial if displayed
    And I should be navigated to dashboard
    And I click on the Native Add Extras tile
    When I should be navigated to the Native Extras tab
    And I click on the "Roaming"
    And I should be navigated to "Roaming" Category Bottom Screen
    And I click on X CTA
    Then I should be navigated to the Native Extras tab


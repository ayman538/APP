Feature: Active Controls Card

  @TC_1018088 @3G @CONSUMER @MPS
  Scenario: Test Case 1018088: 866545.01_ P1_Check the existence of "Active Controls and Limits" card when clicking on "Manage Controls and Limits" tile from the subsoverlay using softlogged consumer user_Functional
    Given I am MVA user and logged in using Soft Login
    And I close the tutorial if displayed
    And I should be navigated to dashboard
    And I click on the Manage Control And Limits tile
    When I should be navigated to the Controls tab
    Then I should see Active Controls that I have

  @TC_1018091 @3G @CONSUMER @MPS
  Scenario: Test Case 1018091: 866545.02_ P1_ Check the content of the "Active Controls and Limits" card in the "Controls" tab, when clicking on "Manage Controls and Limits" tile from the subsoverlay using a softlogged soletrader user_UI
    Given I am MVA user and logged in using Soft Login
    And I close the tutorial if displayed
    And I should be navigated to dashboard
    And I click on the Manage Control And Limits tile
    When I should be navigated to the Controls tab
    Then I should see active Controls Details

  @TC_1018092 @3G @CONSUMER @MPS @LOGIN
  Scenario: Test Case 1018092: 866545.03_P1_ Check the behavior when clicking on "Find out more" CTA of the "Active controls and limits" card in the "Controls" tab using FL MPS consumer user _Functional
    Given I am MVA user and logged in using full login with user name and password
    And I close the tutorial if displayed
    And I should be navigated to dashboard
    And I click on the Manage Control And Limits tile
    When I should be navigated to the Controls tab
    Then I should see description of active Controls after clicking Find Out CTA
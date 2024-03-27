Feature: Controls Category and Confirm Bottom sheet

  @TC_1227739 @3g @CONSUMER @MPS @LOGIN
  Scenario: Test Case 1227739: 1156099.01_P1_Check the existence of confirmation tray when clicking on any Control category that have only one sub category using a FL MPS consumer user_Functional
    Given I am MVA user and logged in using full login with user name and password
    When I close the tutorial if displayed
    And I should be navigated to dashboard
    And I click on the Manage Control And Limits tile
    Then I should be navigated to the Controls tab
    And I navigate and check zero level confirm bottom sheet

  @TC_1227799 @3g @CONSUMER @MPS @SoftLogin
  Scenario: Test Case 1227799: 1156099.03_P1_Check the existence of the confirmation tray when clicking on any sub category that have one 2nd level sub category using a softlogged MPS consumer user_Functional
    Given I am MVA user and logged in using Soft Login
    When I close the tutorial if displayed
    And I should be navigated to dashboard
    And I click on the Manage Control And Limits tile
    Then I should be navigated to the Controls tab
    When I navigate and check first level control subcategory
    Then I navigate and check first level confirm bottom sheet

  @TC_1227840 @3g @CONSUMER @MPS @LOGIN
  Scenario: Test Case 1227840: 1156099.05_P1_Check the existence of the confirmation tray when clicking on sub category that has multiple 2nd level sub category using a FL MPS consumer user_Functional
    Given I am MVA user and logged in using Soft Login
    When I close the tutorial if displayed
    And I should be navigated to dashboard
    And I click on the Manage Control And Limits tile
    Then I should be navigated to the Controls tab
    When I navigate and check second level control subcategory
    Then I navigate and check second level confirm bottom sheet
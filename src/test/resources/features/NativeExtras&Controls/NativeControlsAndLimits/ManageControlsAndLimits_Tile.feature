Feature: Add Manage Control And Limits Subsoverlay

  Background: Start the dashboard
    Given I am MVA user and logged in using Soft Login
    And I close the tutorial if displayed
    And I should be navigated to dashboard


  @TC944493 @3G @SOLETRADER @MPS
  Scenario: Validate the Existence of the Manage Controls and Limits tile
    Then I should see the Manage Control And Limits tile

  @TC944497 @3G @SOLETRADER @MPS
  Scenario: Validate the Redirection of the Manage Controls and Limits tile
    When I should see the Manage Control And Limits tile
    And I click on the Manage Control And Limits tile
    Then I should be navigated to the Controls tab

  @TC1675842 @TC1675848 @3G @BINGO @MPS
  Scenario: Validate the Existence and Redirection of the Manage Controls tile for Bingo users
    And I Dismiss The First Tip
    Then I should see the Manage Control And Limits tile
    And I click on the Manage Control And Limits tile
    Then I should be navigated to the Controls tab




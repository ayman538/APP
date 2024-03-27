Feature: Add Extras Subsoverlay

  Background: Start the dashboard
    Given I am MVA user and logged in using Soft Login
    And I close the tutorial if displayed
    And I should be navigated to dashboard


  @TC944493 @TC_1534691 @TC_1534692 @3G @MPS @SOLETRADER
  Scenario: Validate the Existence of the Add Extras tile
    Then I should see the Native Add Extras tile

  @TC944496 @3G @MPS @SOLETRADER
  Scenario: Validate the Redirection of the Add Extras  tile
    When I should see the Native Add Extras tile
    And I click on the Native Add Extras tile
    Then I should be navigated to the Native Extras tab






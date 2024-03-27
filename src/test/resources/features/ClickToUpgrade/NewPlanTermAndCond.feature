Feature: New Plan Terms And Conditions

  As a MVA user
  I should be able to see a toggle for the terms and conditions and a URL to view them
  to be able to read and confirm reading the terms and conditions

  @TC_651735
  Scenario: verify that new plan terms and conditions section has correct details
    Given I am MVA user and logged in using full login with user name and password
    When the user navigates to the recommended plans page
    And the user selects a specific plan
    Then the user redirected to the new plan page
    And terms and conditions section has correct details

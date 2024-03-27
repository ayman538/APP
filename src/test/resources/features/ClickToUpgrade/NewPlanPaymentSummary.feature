Feature: New Plan Payment Summary

  As MVA user
  I want to see my new plan payment summary (price, start and end dates)
  So that I can subscribe to it instead of my current plan

  @TC_652138
Scenario: verify that the new plan payment summary section contains the correct details
    Given I am MVA user and logged in using full login with user name and password
    When the user navigates to the recommended plans page
    And the user selects a specific plan
    Then the user redirected to the new plan page
    And the payment summary section contains the correct details
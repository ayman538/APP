Feature: New Plan Card

  As MVA user
  I want to see my new plan details and features
  So that I can subscribe to it instead of my current plan

  @TC_724798
  Scenario: verify that the new plan card contains the correct details and features
    Given I am MVA user and logged in using full login with user name and password
    When the user navigates to the recommended plans page
    And the user selects a specific plan
    Then the user redirected to the new plan page
    And the new plan card contains the correct details and features

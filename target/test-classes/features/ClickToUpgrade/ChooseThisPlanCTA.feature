Feature: Choose a Recommended Plan CTA

  As a MVA user
  I want to be able to choose a plan
  So that I can subscribe to it, instead of my current plan

  @TC_628106
  Scenario: choose a recommended plan
    Given I am MVA user and logged in using full login with user name and password
    When the user navigates to the recommended plans page
    And the user selects a specific plan
    Then the user redirected to the new plan page
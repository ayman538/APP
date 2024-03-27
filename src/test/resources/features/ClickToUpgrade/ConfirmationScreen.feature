Feature: Click to upgrade confirmation screen

  @TC_847343
  Scenario: Check confirmation Screen appears after clicking confirm this change
    Given I am MVA user and logged in using full login with user name and password
    When the user navigates to the recommended plans page
    And the user selects a specific plan
    Then the user redirected to the new plan page
    When the user toggles terms and conditions confirmation
    And the user clicks on Continue CTA
    When the user clicks on confirm CTA
    Then the confirmation screen appears
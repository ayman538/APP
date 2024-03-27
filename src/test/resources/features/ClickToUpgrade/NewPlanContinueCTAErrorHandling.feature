Feature: Change your plan - Continue CTA - Error handling

  AS a MVA user
  I should receive an error message
  So that I know there is a problem in continuing upgrade my plan

  @TC_816970
  Scenario: Verify there's an error message when there's an API failure
    Given I am MVA user and logged in using full login with user name and password
    When the user navigates to the recommended plans page
    And the user selects a specific plan
    Then the user redirected to the new plan page
    When the user toggles terms and conditions confirmation
    And the user clicks on Continue CTA
    Then the user gets an error screen due to API failure
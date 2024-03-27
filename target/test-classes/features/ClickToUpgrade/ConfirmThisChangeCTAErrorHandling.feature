Feature: Confirm This Change CTA Error Handling

@TC_849697
  Scenario: verify user gets an error after clicking on confirm this change CTA when there's an API Failure
  Given I am MVA user and logged in using full login with user name and password
    When the user navigates to the recommended plans page
    And the user selects a specific plan
    Then the user redirected to the new plan page
    When the user toggles terms and conditions confirmation
    And the user clicks on Continue CTA
    When the user clicks on confirm CTA
    Then the user gets an error screen due to API failure
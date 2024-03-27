Feature: Recommended Plan Card See Plan Details

  @TC_906521
  Scenario: verify that the user redirected to see plan details webview
    Given I am MVA user and logged in using full login with user name and password
    When the user navigates to the recommended plans page
    And I click on see plan details button
    Then I should redirected to see plan details page

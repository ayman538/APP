Feature: Recommended & New Plan Card Highlights

  Scenario: Verify that the recommended & new plan card highlights displayed
    Given I am MVA user and logged in using full login with user name and password
    When the user navigates to the recommended plans page
    Then I should find the recommended plan card highlights displayed
    When the user selects a specific plan
    Then I should find the new plan card highlights displayed

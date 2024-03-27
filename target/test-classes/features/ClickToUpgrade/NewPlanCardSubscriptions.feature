Feature: New Plan Card Free Subscriptions

  @TC_675643 @3G
  Scenario: Verify that the user can see the free subscriptions in the new plan card
    Given I am MVA user and logged in using full login with user name and password
    When the user navigates to the recommended plans page
    And the user selects a specific plan
    Then the user can see the free subscriptions in the new plan card
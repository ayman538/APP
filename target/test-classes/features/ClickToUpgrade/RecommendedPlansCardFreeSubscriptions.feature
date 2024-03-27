Feature: Recommended plan card free subscriptions

  @TC_675642 @3G
  Scenario: verify that the user can see the free subscriptions in recommended plan card
    Given I am MVA user and logged in using Soft Login
    When the user navigates to the recommended plans page
    Then the user can see the free subscriptions
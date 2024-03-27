Feature: Current plan card details

 @TC_929716
  Scenario: verify that te current plan card has the correct details
    Given I am MVA user and logged in using Soft Login
    When the user navigates to the recommended plans page
    Then I should find the correct details in the current plan card
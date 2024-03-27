Feature: Change your plan page - Continue CTA

  As a MVA user
  I should be able to toggle for the terms and conditions
  So that the Continue CTA is enabled and I can click it to go to the Checkout Modal

  @TC_816138
  Scenario: verify that the user redirected to the checkout modal when clicking on the Continue CTA
    Given I am MVA user and logged in using full login with user name and password
    When the user navigates to the recommended plans page
    And the user selects a specific plan
    Then the user redirected to the new plan page
    When the user toggle terms and conditions confirmation
    And the user clicks on Continue CTA
    Then the user redirected to Checkout modal
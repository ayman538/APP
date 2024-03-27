Feature: Choose This Plan CTA (Child Account - Root Subscription)
  As a MVA user with a child account
  I want to not be able to choose a plan
  So that I don't bypass the Root account's users

  @TC_819800
  Scenario: verify that a fully logged in child user get a full screen error when clicking on "Choose this plan" CTA
    Given I am MVA user and logged in using full login with user name and password
    When the user navigates to the recommended plans page
    And the user selects a specific plan
    Then the user gets a full screen error
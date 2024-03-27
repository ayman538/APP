Feature: See all plans on our website

  As a MVA user
  I want to see my recommended plans
  So that I can compare them to my current plan

  @TC_627999
  Scenario: see all recommended plans on the website
    Given I am MVA user and logged in using full login with user name and password
    When the user navigates to the recommended plans page
    And the user clicks on see all plans on our website CTA
    Then the user redirected to the webview with all plans
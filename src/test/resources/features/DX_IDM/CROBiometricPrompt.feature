Feature: CRO Biometric Prompt feature


  @TC_1563636
  Scenario: Validate Full Login with Biometric prompt
    Given Press Login to start Full login Journey
    And Accept cookies
    Then Validate Username screen and Insert Username
    And Validate Password screen and Insert Password
    And Validate prompt experience
    And Select Biometric
    Then Press All done CTA and Validate Dashboard


  @TC_1563637
  Scenario: Validate UFL with biometric prompt
    #switch unkownuser to true
    Given Login Till Reach Login Preference Screen but don't press
    And Validate prompt experience
    And Select Biometric
    Then Press All done CTA and Validate Dashboard

  @TC_1573655
  Scenario: Validate soft login then use account as entry point
    Given I am MVA user and logged in using Soft Login
    And I navigate to my account from dashboard tray
    And Accept cookies
    Then Validate Username screen and Insert Username
    And Validate Password screen and Insert Password
    And Validate prompt experience
    And Select Biometric
    Then Press All done CTA and Validate Dashboard

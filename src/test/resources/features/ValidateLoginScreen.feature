@3G @REGRESSION @696090 @MPS
Feature: Validate Login and Skip login screen content

  Scenario: Validate Login and skip login screen content
    Given I am MVA user and logged in using Soft Login
    When  I navigate to settings from dashboard tray
    When I navigate to App settings screen
    Then Reset app Journey
    Then Validate Login screen content
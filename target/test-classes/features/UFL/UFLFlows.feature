@WIFI
Feature: UFL Flows

  Background: Initialize UFL Flow
    Given Init UFL Flow

  Scenario: TC01_validatePleaseContactUsFooter
    Then Validate Please Contact Us

  Scenario: TC02_checkFingerPrintDisplayed
    Then Validate Biometrics Screen

  Scenario: TC03_validatedRestPINJourney
    Then Validate Reset Pin After UFL

@3G @WIFI @AUTOMATIC @FAIL
Feature: VOXI SubsOverlay

  Background: Init
    Given Init VOXIUserSubsOverlay
    And Init HeritageUserSubsOverlay
    And Init UnknownUserSubsOverlay

  Scenario: First time login/ Welcome Journey - VOXI Users Overlay

    Given VOXI User Launch the App
    When  Acquisition dashboard Displayed
    Then  A Specific Overlay should be displayed for VOXI users
    Then  visit VOXI CTA should be displayed
    Then  Return to my vodafone CTA should be displayed



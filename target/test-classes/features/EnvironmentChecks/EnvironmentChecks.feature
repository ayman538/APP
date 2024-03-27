@EnvChecks
Feature: Environments Checks

  Background:
   When I am MVA user and logged in using Soft Login

  Scenario: Check Environment Availability
    When I Validate Data Usage tile is displayed
    And I validate Charges tile is displayed
    And Navigate to SubsOverlay
    And Plan tab Is Displayed
    And Navigate to Usages
    And Navigate to Charges
    And I navigate to extras tab from subscriptions overlay
    And Click on Close Icon
    And Click on My Account
    And Preform FL Using Login Preference Method "pin"
    And HardClose the App and Relaunch
    And I close the tutorial if displayed
    And Click on My Account
    And Enter pin screen is displayed and enter the four fields then click on continue
    Then I Validate MyAccount Drawer
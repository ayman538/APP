@3G @DXIDM @LOGIN
Feature: Forgotten PIN

  Background: Enter Password after hardclosing the app while login with PIN
    Given I am MVA user and logged in using full login with PIN
    When HardClose the App
    And I close the tutorial if displayed
    And Click on My Account
    And Click on Forgotten PIN CTA
    And Enter password for forget PIN

  @TC_631464 @TC_567882
  Scenario: Test Case 631464: 425167.01_P1_check full flow of reset PIN Journey for soft logged in PayM user with PIN login preference_Functional
    And Enter and confirm PIN "2580"
    Then Check Accounts appears successfully

  @TC_631465 @TC_567884 @REGRESSION
  Scenario: Test Case 631465: 425167.04_P1_check behavior when re-entering a Pin that does not match the Pin entered in "Enter new PIN" screen for soft logged in PayM user with Pin login preferences_Functional
    And Enter valid PIN "2580"
    When Click Back CTA
    Then Check entered PIN still exists
    And Confirm with invalid PIN "1357"
    Then PIN Mismatch error appears
    Then Confirm with valid PIN "2580"
    Then Check Accounts appears successfully
    And HardClose the App
    And I close the tutorial if displayed
    When Click on My Account
    And Enter valid PIN "2580"
    Then Check Accounts appears successfully

  @TC_631464  @3G  @REGRESSION
  Scenario:check full flow of reset PIN Journey for soft logged in PayM
    And Enter valid PIN "2580"
    Then Confirm with valid PIN "2580"
    Then Check Accounts appears successfully
@3G @DXIDM
Feature: DX IDM Full Login feature

  @LoginWithUsername/Password
  @TC_530032 @TC_530033 @TC_530036 @REGRESSION @TC_630438
  Scenario: Validate Full Login with username and password
  Given Press Login to start Full login Journey
    Then Validate Username screen and Insert Username
    And Validate Password screen and Insert Password
#    And Select Username and Password
    Then Press All done CTA and Validate Dashboard

  @LoginWithPIN
  @TC_530024 @TC_530025
  Scenario: Validate Full Login with PIN
    Given Press Login to start Full login Journey
    Then Validate Username screen and Insert Username
    And Validate Password screen and Insert Password
    And Select PIN
    Then Press All done CTA and Validate Dashboard

  @TC_530033
  Scenario: Validate Full Login with Biometric
    Given Press Login to start Full login Journey
    Then Validate Username screen and Insert Username
    And Validate Password screen and Insert Password
    And Select Biometric
    Then Press All done CTA and Validate Dashboard

  @TC_530035
  Scenario: Validate Password Appear After Press Show Password
    Given Press Login to start Full login Journey
    When Validate Username screen and Insert Username
    And Enter password
    And Press Show Password
    Then Validate Password shown

  @TC_530035
  Scenario: Validate Password Is Hidden
    Given Press Login to start Full login Journey
    When Validate Username screen and Insert Username
    And Enter password
    Then Validate Password not shown

  @Android
  Scenario: Validate Physical Back Button not working on Enter your Username screen
    When Press Login to start Full login Journey
    Then Validate click on the Physical Back Button on username screen

  @Android
  Scenario: Validate Physical Back Button not working on Enter your Password screen
    Given Press Login to start Full login Journey
    When Validate Username screen and Insert Username
    Then Validate click on the Physical Back Button on Password screen

  @Android
  Scenario: Validate Physical Back Button not working on Login preference screen
    Given Press Login to start Full login Journey
    When Validate Username screen and Insert Username
    And  Validate Password screen and Insert Password
    Then Validate click on the Physical Back Button Login preference screen


  @3G @REGRESSION @LOGIN
  Scenario: Check prepopulation of Username field
    Given  I am MVA user and logged in using full login with user name and password
    When HardClose the App and Relaunch
    And I close the tutorial if displayed
    And I navigate to my account from dashboard tray
    Then Validate username is Auto Populated

  Scenario: Full login
    Given Click on Login CTA
    Given Preform FL Using Login Preference Method "pin"
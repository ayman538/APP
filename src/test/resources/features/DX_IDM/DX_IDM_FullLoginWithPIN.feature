@3G @DXIDM @LOGIN
Feature: DX IDM I am MVA user and logged in using full login with PIN

  @TC_530027 @TC_530026 @REGRESSION @TC_631586
  Scenario: Validate "Continue" CTA after Full login using inValid PIN
    Given I am MVA user and logged in using full login with PIN
    When HardClose the App
    Then Validate Dashboard displayed
    And I close the tutorial if displayed
    When Click on My Account
    Then Validate PIN Screen
    When Enter inValid PIN and Click on Continue
    Then User should see an error screen with OK CTA
    Then Click on OK CTA and validate the PIN Screen should be displayed

  Scenario: Validate "Continue" CTA after Full login using Valid PIN
    Given PIN Screen Displayed
    When Enter Valid PIN and Click on Continue
    Then User should see my account tray

  @TC_530027 @TC_530026
  Scenario: Validate app behavior when try to enter multiple wrong pin
    Given user logged with PIN and HardClose the app
    When Click on My Account
    Then Validate PIN Screen
    When Enter inValid PIN for 5 Times and Continue
    Then User should be blocked
    When Click on Reset Password and validate
    When Click on Close CTA The Blocked screen should be closed



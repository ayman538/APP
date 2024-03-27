@3G
Feature: App Settings

  @SANITY @PAYM @TC_601831 @CONSUMER @MPS @PAYG @REGRESSION
  Scenario: TC01_ValidateAppSettingsItems
    Given I am MVA user and logged in using Soft Login
    When  I navigate to settings from dashboard tray
    And I navigate to App settings screen
    Then Assert on items displayed
    Then Assert on Copied message of hardwareID

  @SANITY @TC_601833 @CONSUMER @MPS @REGRESSION
  Scenario: TC05_ValidateTAndCFunctionality
    Given I am MVA user and logged in using Soft Login
    When  I navigate to settings from dashboard tray
    And I navigate to App settings screen
    And User clicks on T&C element
    When T&C title is displayed
    Then Assert on T&C Description and Version

#  @LOGIN @CONSUMER @SOLETRADER @SMB
#  Scenario:  TC08_ValidateLoginOptionsAfterLoginFunctionality
#    Then Assert on elements displayed in Login Options screen after login
#    And Click on Reset your Pin CTA

  @SANITY @CONSUMER @MPS @TC_601832 @REGRESSION
  Scenario: TC06_ValidateLoginOptionsBeforeLoginFunctionality
    Given I am MVA user and logged in using Soft Login
    When  I navigate to settings from dashboard tray
    And I navigate to App settings screen
    And User clicks on Login Options element
    Then Assert on Login Options elements

  @SANITY @CONSUMER @MPS @TC_601832 @PAYG @REGRESSION
  Scenario: TC04_ValidateDevicePermissionsFunctionality
    Given I am MVA user and logged in using Soft Login
    When  I navigate to settings from dashboard tray
    And I navigate to App settings screen
    And User opens device permissions screen
    And Device permission Title is displayed
    Then Assert on device permission content

#    Then Assert on elements for phone card
#    And Assert on device location title
#    And Assert on elements of location card
#    And Assert on Media title
#    And Assert on Media card elements
#    And Assert on Usage text
#    And Assert on elements of usage card

  @SANITY @CONSUMER @MPS @TC_601832 @PAYG @REGRESSION
  Scenario: TC03_ValidateResetAppFunctionality
    Given I am MVA user and logged in using Soft Login
    When  I navigate to settings from dashboard tray
    And I navigate to App settings screen
    When User assert on Reset App screen Title
    Then Assert on Reset app card CTA and description

  @SANITY @CONSUMER @MPS @TC_601832 @PAYG @REGRESSION
  Scenario: TC13_ValidateResetAppJourney
    Given I am MVA user and logged in using Soft Login
    When  I navigate to settings from dashboard tray
    And I navigate to App settings screen
    When User navigated to App Settings screen
    When User assert on Reset App screen Title
    Then Reset app Journey
    Then Skip Login

  @TC_1774037 @TC_1774152 @TC_1774148 @TC_1774144
  Scenario: Validate App Settings Screen
    Given I am MVA user and logged in using Soft Login
    When  I navigate to settings from dashboard tray
    And I navigate to App settings screen
    Then I validate App settings is displayed

  @TC_1774148 @UNKNOWN_USER
  Scenario: Validate App Settings Screen for Unknown Users
    Given  I click on Return to my vodafone CTA
    When  I navigate to settings from dashboard tray
    And I navigate to App settings screen
    Then I validate App settings is displayed

  @TC_1774145
  Scenario: Validate App Settings deeplink
    Given  I click on Return to my vodafone CTA
    And I navigate to App Settings deeplink
    Then I validate App settings is displayed

#
#  @NOT_10_18
#  Scenario: TC09_ValidateForgotUsernameHyperLinkIsClickable
#    Given Click on Set Up your Pin CTA
#    Then Assert Pin Field is Displayed
#    And  Assert memorable word field is displayed
#  @NOT_10_18
#  Scenario: TC10_ValidateForgotPasswordHyperLinkIsClickable
#    Given User clicks on Forgotten password Hyperlink
#    Then Assert Reset Password Screen Elements
#
#
#
#  @LOGIN @NOT_10_18
#  Scenario: TC11_ValidateFingerPrintToggleFunctionality
#    Given Finger print Status is OFF
#    Then Turn Finger print status ON
#    Then Enter pin to turn status OFF again
#
#  @LOGIN @NOT_10_18
#  Scenario:TC12_ValidateOldPinIsNotWorking
#    Given User click on Reset your PIN CTA
#    When User login with new PIN
#    Then User Login with invalid PIN
#    And Assert on invalid error message displayed
#
#  @IOS @NOT_10_18
#  Scenario: TC13_ValidateSwipeBack
#    Then Check swipe back functionality
#
#

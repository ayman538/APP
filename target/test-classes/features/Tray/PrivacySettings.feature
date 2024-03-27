@3G
Feature:Privacy settings

  @SANITY @TC_601823 @PAYG @REGRESSION
  Scenario: TC01_ValidatePrivacySettingsItems
    Given I am MVA user and logged in using Soft Login
    And I navigate to Privacy Settings
    Then Validate Privacy Settings Items

  @SANITY @TC_601834 @MPS @REGRESSION
  Scenario: TC02_ValidateAppPrivacySupplementChevrons
    Given I am MVA user and logged in using Soft Login
    And I navigate to Privacy Settings
    Then Validate App Privacy Supplement Chevrons

  @SANITY @TC_601821 @MPS @REGRESSION
  Scenario: TC04_ValidateMarketingPreferencesFunctionality
    Given I am MVA user and logged in using Soft Login
    And I navigate to Privacy Settings
    Then Validate Marketing Preferences Functionality

#  Scenario: TC03_ValidateAppPrivacyFunctionality
#    Then Validate App Privacy Tailored
#    Then Validate App Privacy Network
#    Then Validate App Privacy Chevron
#    Then Validate App Privacy UsageCard
#
#  Scenario: TC05_ValidateVodafonePrivacyPortalFunctionality
#    Then Validate Vodafone Privacy Portal Functionality

  ########################################### DP&C - Privacy Settings #################################################
  #new feature

  @TC_1775632 @MPS @CONSUMER @MBB @RH @PREPAY @PAYG
    Scenario: Validate Privacy Settings Screen
    Given I am MVA user and logged in using Soft Login
    And click on my Settings on dashboard tray
    When I click on Privacy Settings
    Then Validate New UI Of Privacy Settings

  @TC_1775692 @UNKNOWN_USER
  Scenario: Check Privacy Settings tray UI using Unknown User
    Given I click on Return to my vodafone CTA
    And click on my Settings on dashboard tray
    When I click on Privacy Settings
    Then Validate New UI Of Privacy Settings

  @TC_1870889
  Scenario: Validate 'Cookie Permissions' screen from Privacy settings screen_FUNC
    Given I am MVA user and logged in using Soft Login
    Then I should be navigated to dashboard
    And click on my Settings on dashboard tray
    When I click on Privacy Settings
    Then I redirected to Privacy Settings
    And I click on Cookie Permissions
    Then I redirected to 'Cookie permission' screen
    And I validate 'Cookie permission' UI from "settings"

  @UNKNOWN_USER @TC_1873572
  Scenario: Check Cookie Permissions screen as a non-vodafone user
    Given I click on Return to my vodafone CTA
    And click on my Settings on dashboard tray
    When I click on Privacy Settings
    Then I redirected to Privacy Settings
    When I click on Cookie Permissions
    Then I validate 'Cookie permission' UI from "settings"

  @TC_1871837
  Scenario: Check collapsing/expanding of the cards inside 'Cookie Permissions' from settings
    Given I am MVA user and logged in using Soft Login
    Then I should be navigated to dashboard
    And click on my Settings on dashboard tray
    When I click on Privacy Settings
    Then I redirected to Privacy Settings
    And I click on Cookie Permissions
    Then I redirected to 'Cookie permission' screen
    And I can expand&collapse all cookies cards in Cookie Permissions screen

  @TC_1871293 @TC_1871294 @SeparateFeatureWelcomeFlowTests
  Scenario: Check that User selections are saved in 'Cookie Permissions' from Manage Cookies screen in welcomeflow
    Given I am MVA user and launches the app for the first time
    When I click on 'Continue' CTA in the Welcome flow Screens
    Then I redirected to 'Before you get started' screen
    When I toggle on 'Ts&Cs'
    And I click on 'Continue' CTA in the Welcome flow Screens
    Then I redirected to 'We Value Your Privacy' screen
    When I click on 'Manage cookies' CTA
    Then I redirected to 'Cookie permission' screen
    And I opt "Functional" cookie with the "OFF" state
    And I opt "Performance" cookie with the "ON" state
    And I opt "Targeting" cookie with the "ON" state
    When I click on 'Continue' CTA in the Welcome flow Screens
    Then I redirected 'Our Network & Service' screen
    When I click on 'Continue' CTA in the Welcome flow Screens
    Then I redirected to 'Get The Best Experience' Screen
    And I am MVA user and logged in using Soft Login
    And I should be navigated to dashboard
    When click on my Settings on dashboard tray
    And I click on Privacy Settings
    And I click on Cookie Permissions
    Then I redirected to 'Cookie permission' screen
    And I Validate Value Of "Functional" Cookie Is "OFF"
    And I Validate Value Of "Performance" Cookie Is "ON"
    And I Validate Value Of "Targeting" Cookie Is "ON"
    When I opt "Functional" cookie with the "ON" state
    And I opt "Performance" cookie with the "OFF" state
    And I click on 'Back' CTA in Cookie permissions screen
    Then I redirected to Privacy Settings
    And I click on Cookie Permissions
    Then I redirected to 'Cookie permission' screen
    And I Validate Value Of "Functional" Cookie Is "ON"
    And I Validate Value Of "Performance" Cookie Is "OFF"

  @TC_1919719 @SeparateFeatureWelcomeFlowTests
  Scenario: Check "Network & Service" screen for user who accepted "Performance Cookies" permission & didn't toggle on "Network Improvements" in welcome flow_UI
    Given I am MVA user and launches the app for the first time
    When I click on 'Continue' CTA in the Welcome flow Screens
    Then I redirected to 'Before you get started' screen
    When I toggle on 'Ts&Cs'
    And I click on 'Continue' CTA in the Welcome flow Screens
    Then I redirected to 'We Value Your Privacy' screen
    When I click on 'Manage cookies' CTA
    Then I redirected to 'Cookie permission' screen
    And I opt "Performance" cookie with the "ON" state
    When I click on 'Continue' CTA in the Welcome flow Screens
    Then I validate 'Our Network & Service' screen without 'Enable Performance cookies' link
    When I click on 'Continue' CTA in the Welcome flow Screens
    Then I redirected to 'Get The Best Experience' Screen
    And I am MVA user and logged in using Soft Login
    And I should be navigated to dashboard
    When click on my Settings on dashboard tray
    And I click on Privacy Settings
    And I click on Network And Service
    Then I Validate 'Network And Service' screen from settings without link
    And I Validate Network Improvements 'OFF' from settings
    When I Toggle Network Improvements 'ON' from settings
    Then I Validate Network Improvements 'ON' from settings
    And I click on 'Back' CTA in Cookie permissions screen
    Then I redirected to Privacy Settings

  @TC_1919722  @SeparateFeatureWelcomeFlowTests
  Scenario: Check "Network & Service" screen for user who doesn't accept performance cookie and opt on "Network Improvements" in welcome flow_functional
    Given I am MVA user and launches the app for the first time
    When I click on 'Continue' CTA in the Welcome flow Screens
    Then I redirected to 'Before you get started' screen
    When I toggle on 'Ts&Cs'
    And I click on 'Continue' CTA in the Welcome flow Screens
    Then I redirected to 'We Value Your Privacy' screen
    When I click on 'Manage cookies' CTA
    Then I redirected to 'Cookie permission' screen
    And I opt "Performance" cookie with the "OFF" state
    When I click on 'Continue' CTA in the Welcome flow Screens
    Then I validate 'Our Network & Service' screen with 'Enable Performance cookies' link
    And I Toggle ON Network Improvements from welcome flow
    When I click on 'Continue' CTA in the Welcome flow Screens
    Then I redirected to 'Get The Best Experience' Screen
    And I am MVA user and logged in using Soft Login
    And I should be navigated to dashboard
    When click on my Settings on dashboard tray
    And I click on Privacy Settings
    And I click on Network And Service
    Then I Validate 'Network And Service' screen from settings with link

  @TC_1919723
  Scenario: Check app behavior when user Taps on "Performance Cookies" link in the blue banner in "Network & Service" screen_functional
    Given I am MVA user and logged in using Soft Login
    Then I should be navigated to dashboard
    And click on my Settings on dashboard tray
    When I click on Privacy Settings
    Then I redirected to Privacy Settings
    And I click on Cookie Permissions
    Then I redirected to 'Cookie permission' screen
    When I opt "Performance" cookie with the "OFF" state
    And I click on 'Back' CTA in Cookie permissions screen
    Then I redirected to Privacy Settings
    When I click on Network And Service
    Then I Validate 'Network And Service' screen from settings with link
    When I click on 'Enable Performance Cookies' link in 'network and service' screen from settings
    Then I redirected to 'Cookie permission' screen
    When I opt "Performance" cookie with the "ON" state
    And I click on 'Back' CTA in Cookie permissions screen
    Then I Validate 'Network And Service' screen from settings without link

  @TC_1924832 @TC_1924836 @PayM @PayG @SMB
  Scenario: Validate Vodafone privacy information screen
    Given I am MVA user and logged in using Soft Login
    And click on my Settings on dashboard tray
    And I click on Privacy Settings
    Then I redirected to Privacy Settings
    When I click on Vodafone Privacy Information entry point
    Then I navigate to Vodafone Privacy Portal screen
    When I click on the back icon for settings screens
    Then I redirected to Privacy Settings

  @TC_1924833 @PayM @PayG @SMB
  Scenario: Validate App Privacy Supplement entry point
    Given I am MVA user and logged in using Soft Login
    And click on my Settings on dashboard tray
    And I click on Privacy Settings
    Then I redirected to Privacy Settings
    When I click on Vodafone Privacy Information entry point
    Then I navigate to Vodafone Privacy Portal screen
    When I click on App Privacy Supplement CTA
    Then I redirected to App Privacy Supplement screen

  @TC_1924834 @PayM @PayG @SMB
  Scenario: Validate Cookie Policy entry point
    Given I am MVA user and logged in using Soft Login
    And click on my Settings on dashboard tray
    And I click on Privacy Settings
    Then I redirected to Privacy Settings
    When I click on Vodafone Privacy Information entry point
    Then I navigate to Vodafone Privacy Portal screen
    When I click on Cookie policy CTA
    Then I should be navigated to CookiePolicy screen with collapsed chevrons

  @TC_1924835 @PayM @PayG @SMB
  Scenario: Validate Privacy Portal entry point
    Given I am MVA user and logged in using Soft Login
    And click on my Settings on dashboard tray
    And I click on Privacy Settings
    Then I redirected to Privacy Settings
    When I click on Vodafone Privacy Information entry point
    Then I navigate to Vodafone Privacy Portal screen
    When I click on Privacy portal CTA
    Then I navigate to privacy portal webview

  @TC_1935105 @TC_1935106 @TC_1935133 @TC_1935122 @TC_1935112 @TC_1935114 @PayM @PayG @SMB
  Scenario: Validate the Redirection & UI for 'Device Permissions' screen without Enabling targeting cookies
    Given I am MVA user and logged in using Soft Login
    Then I should be navigated to dashboard
    And click on my Settings on dashboard tray
    When I click on Privacy Settings
    Then I redirected to Privacy Settings
    And I click on Cookie Permissions
    Then I redirected to 'Cookie permission' screen
    When I opt "Targeting" cookie with the "OFF" state
    And I click on 'Back' CTA in Cookie permissions screen
    When I click on Device Permissions entry point
    Then I navigate to Device permissions screen with enabling targeting cookies link
    When I click on 'Enable Targeting Cookies' link in 'Device Permissions' screen from settings
    Then I redirected to 'Cookie permission' screen
    When I opt "Targeting" cookie with the "ON" state
    And I click on the back icon for settings screens
    Then I navigate to Device permissions screen without enabling targeting cookies link


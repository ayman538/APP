# new feature
@OneTrust @SeparateFeatureWelcomeFlowTests
Feature: First Time Users' Welcome Flow - One Trust Feature

  Background: MVA user and launches the app for the first time
    Given I am MVA user and launches the app for the first time
    And I click on 'Continue' CTA in the Welcome flow Screens

  @TC_1771955 @TC_1771974 @TC_1772040 @CONSUMER @PREPAY @PAYG
  Scenario: Validate the 'Welcome' screen
    Then I redirected to 'Before you get started' screen

  @TC_1772009 @TC_1772041 @CONSUMER @PREPAY @PAYG
  Scenario: Validate the 'Before you get started' screen
    Then I validate 'Before you get started' screen

  @TC_1772023 @CONSUMER
  Scenario: Check when user tries to click on 'Continue' CTA without agreeing to 'Ts&Cs' in 'Before You Get Started' screen
    And I redirected to 'Before you get started' screen
    And I click on 'Continue' CTA in the Welcome flow Screens
    Then I validate that pop up 'Please agree to the terms and conditions before continuing' displayed

  @TC_1772027 @CONSUMER
  Scenario: Check app behavior when I click on the 'back' CTA in 'Before you get started' screen
    Given I redirected to 'Before you get started' screen
    And I click on 'Back' CTA in Welcome flow screens
    Then I am MVA user and launches the app for the first time

  @TC_1772024 @TC_1772025 @TC_1772011
  Scenario: Check app behavior when I toggle on the 'Agree to Ts&Cs' toggle
    And I redirected to 'Before you get started' screen
    And I toggle on 'Ts&Cs'
    And I click on 'Continue' CTA in the Welcome flow Screens
    Then I redirected to 'We Value Your Privacy' screen

  @TC_1772012
  Scenario: Check app behavior when user clicks on 'Terms and Conditions' link in Before You Get Started' screen
    And I toggle on 'Ts&Cs'
    And I click on 'Terms and conditions' Link
    And I redirected to Terms and Conditions screen
    And I click on Ok CTA
    Then I redirected to 'We Value Your Privacy' screen

  @TC_1772016
  Scenario: Check app behavior when I click on the 'back' CTA in 'We Value Your Privacy' screen
    And I redirected to 'Before you get started' screen
    And I toggle on 'Ts&Cs'
    And I click on 'Continue' CTA in the Welcome flow Screens
    Then I redirected to 'We Value Your Privacy' screen
    And I click on 'Back' CTA in Welcome flow screens
    Then I redirected to 'Before you get started' screen


  @TC_1804309 @TC_1804313
  Scenario: P1_Check UI & back arrow for "Cookie Permissions" screen_UI
    And I redirected to 'Before you get started' screen
    And I toggle on 'Ts&Cs'
    And I click on 'Continue' CTA in the Welcome flow Screens
    Then I redirected to 'We Value Your Privacy' screen
    When I click on 'Manage cookies' CTA
    Then I redirected to 'Cookie permission' screen
    And I validate 'Cookie permission' UI from "welcomeflow"
    When I click on 'Back' CTA in Cookie permissions screen
    Then I redirected to 'We Value Your Privacy' screen

  @TC_1804310
  Scenario: P1_Check Toggle ON/OFF for all cookies in "Cookie Permissions" screen_FUN
    And I redirected to 'Before you get started' screen
    And I toggle on 'Ts&Cs'
    And I click on 'Continue' CTA in the Welcome flow Screens
    Then I redirected to 'We Value Your Privacy' screen
    When I click on 'Manage cookies' CTA
    Then I redirected to 'Cookie permission' screen
    And I can Toggle ON&OFF all cookies in Cookie Permissions screen

  @TC_1804311
  Scenario: P2_Check expand/collapse all cookies cards in "Cookie Permissions" screen_FUN
    And I redirected to 'Before you get started' screen
    And I toggle on 'Ts&Cs'
    And I click on 'Continue' CTA in the Welcome flow Screens
    Then I redirected to 'We Value Your Privacy' screen
    When I click on 'Manage cookies' CTA
    Then I redirected to 'Cookie permission' screen
    And I can expand&collapse all cookies cards in Cookie Permissions screen

  @TC_1855042 @TC_1855045
  Scenario: Validate "App Privacy Supplement" Screen
    And I redirected to 'Before you get started' screen
    And I click on App Privacy Supplement Link
    Then I redirected to App Privacy Supplement screen
    And I click on 'Back' CTA in Welcome flow screens
    Then I redirected to 'Before you get started' screen

  @TC_1848255 @TC_1848256 @TC_1849931
  Scenario: Check UI of "Our network and service" screen without tapping on "Network Improvements" toggle
    Given I redirected to 'Before you get started' screen
    And I toggle on 'Ts&Cs'
    And I click on 'Continue' CTA in the Welcome flow Screens
    And I redirected to 'We Value Your Privacy' screen
    When I click on 'Accept all cookies' CTA in 'We Value Your Privacy' screen
    Then I validate 'Our Network & Service' screen without 'Enable Performance cookies' link
    Then I validate on Network Improvements toggle ON and OFF

  @TC_1848257 @TC_1849930 @TC_1848293
  Scenario: Check app behavior when user taps on "Accept all" CTA in "Cookie Permissions" screen
    And I redirected to 'Before you get started' screen
    And I toggle on 'Ts&Cs'
    And I click on 'Continue' CTA in the Welcome flow Screens
    Then I redirected to 'We Value Your Privacy' screen
    When I click on 'Manage cookies' CTA
    And I redirected to 'Cookie permission' screen
    And I click on 'Accept all' CTA in 'Cookie Permissions' screen
    Then I validate 'Our Network & Service' screen without 'Enable Performance cookies' link
    And I click on 'Back' CTA in Welcome flow screens
    And I click on 'Manage cookies' CTA
    And I click on 'Reject all' CTA in 'Cookie Permissions' screen
    Then I validate 'Our Network & Service' screen with 'Enable Performance cookies' link
    Then I validate on Network Improvements toggle ON and OFF
  @TC_1848259
  Scenario: Check app behavior when user taps on "Continue" CTA in "Cookie Permissions" screen without opting in "Performance Cookies" permission
    And I redirected to 'Before you get started' screen
    And I toggle on 'Ts&Cs'
    And I click on 'Continue' CTA in the Welcome flow Screens
    Then I redirected to 'We Value Your Privacy' screen
    When I click on 'Manage cookies' CTA
    And I redirected to 'Cookie permission' screen
    And I opt "Performance" cookie with the "OFF" state
    And I click on 'Continue' CTA in the Welcome flow Screens
    Then I validate 'Our Network & Service' screen with 'Enable Performance cookies' link
    Then I validate on Network Improvements toggle ON and OFF

  @TC_1848260
  Scenario: Check app behavior when user taps on "Continue" CTA in "Cookie Permissions" screen with opting in "Performance Cookies" permission
    And I redirected to 'Before you get started' screen
    And I toggle on 'Ts&Cs'
    And I click on 'Continue' CTA in the Welcome flow Screens
    Then I redirected to 'We Value Your Privacy' screen
    When I click on 'Manage cookies' CTA
    Then I redirected to 'Cookie permission' screen
    And I opt "Performance" cookie with the "ON" state
    And I click on 'Continue' CTA in the Welcome flow Screens
    Then I validate 'Our Network & Service' screen without 'Enable Performance cookies' link
    Then I validate on Network Improvements toggle ON and OFF

  @TC_1848261 @TC_1848262
  Scenario: Check app behavior when user taps on "Performance Cookies" Link in "Our network and service" screen
    And I redirected to 'Before you get started' screen
    And I toggle on 'Ts&Cs'
    And I click on 'Continue' CTA in the Welcome flow Screens
    Then I redirected to 'We Value Your Privacy' screen
    When I click on 'Manage cookies' CTA
    And I click on 'Continue' CTA in the Welcome flow Screens
    And I click on 'Enable Performance Cookies' link in 'Our network and service' screen
    Then I redirected to 'Cookie permission' screen
    And I opt "Performance" cookie with the "ON" state
    And I click on 'Continue' CTA in the Welcome flow Screens
    Then I validate 'Our Network & Service' screen without 'Enable Performance cookies' link
    Then I validate on Network Improvements toggle ON and OFF

  @TC_1848292
  Scenario: Check app behavior when user taps on the back icon of "Cookie Permissions" screen after redirecting from "Our network and service" screen
    And I redirected to 'Before you get started' screen
    And I toggle on 'Ts&Cs'
    And I click on 'Continue' CTA in the Welcome flow Screens
    Then I redirected to 'We Value Your Privacy' screen
    When I click on 'Manage cookies' CTA
    And I click on 'Continue' CTA in the Welcome flow Screens
    And I click on 'Enable Performance Cookies' link in 'Our network and service' screen
    Then I redirected to 'Cookie permission' screen
    When I click on 'Back' CTA in Cookie permissions screen
    Then I validate 'Our Network & Service' screen with 'Enable Performance cookies' link
    Then I validate on Network Improvements toggle ON and OFF

  @TC_1890261 @TC_1890220 @TC_1890699 @TC_1890574 @TC_189162 @AppFreshInstalled
  Scenario: Validate 'Get the best experience' screen content with opting in/out "Targeting Cookies" permission from Manage Cookies
    And I redirected to 'Before you get started' screen
    And I toggle on 'Ts&Cs'
    And I click on 'Continue' CTA in the Welcome flow Screens
    And I redirected to 'We Value Your Privacy' screen
    And I click on 'Manage cookies' CTA
    And I opt "Targeting" cookie with the "ON" state
    And I click on 'Continue' CTA in the Welcome flow Screens
    And I redirected 'Our Network & Service' screen
    And I click on 'Continue' CTA in the Welcome flow Screens
    Then I validate 'Get the best experience' screen without 'Enable Targeting cookies' link
    And I click on 'Back' CTA in Welcome flow screens
    When I redirected 'Our Network & Service' screen
    And I click on 'Back' CTA in Welcome flow screens
    And I redirected to 'We Value Your Privacy' screen
    And I click on 'Manage cookies' CTA
    And I opt "Targeting" cookie with the "OFF" state
    And I click on 'Continue' CTA in the Welcome flow Screens
    And I redirected 'Our Network & Service' screen
    And I click on 'Continue' CTA in the Welcome flow Screens
    Then I validate 'Get the best experience' screen with 'Enable Targeting cookies' link

  @TC_1890155 @AppFreshInstalled
  Scenario: Validate 'Get the best experience' screen content with opting out "Targeting Cookies" permission by Accept All Cookies
    And I redirected to 'Before you get started' screen
    And I toggle on 'Ts&Cs'
    And I click on 'Continue' CTA in the Welcome flow Screens
    And I redirected to 'We Value Your Privacy' screen
    And I click on 'Accept all cookies' CTA in 'We Value Your Privacy' screen
    And I redirected 'Our Network & Service' screen
    And I click on 'Continue' CTA in the Welcome flow Screens
    And I validate 'Get the best experience' screen without 'Enable Targeting cookies' link

  @TC_1890158 @AppFreshInstalled
  Scenario: Validate 'Get the best experience' screen content with Targeting Cookies opted out from 'We Value your privacy' screen
    And I redirected to 'Before you get started' screen
    And I toggle on 'Ts&Cs'
    And I click on 'Continue' CTA in the Welcome flow Screens
    And I redirected to 'We Value Your Privacy' screen
    And I click on 'Manage cookies' CTA
    And I click on 'Continue' CTA in the Welcome flow Screens
    And I redirected 'Our Network & Service' screen
    And I click on 'Continue' CTA in the Welcome flow Screens
    Then I validate 'Get the best experience' screen with 'Enable Targeting cookies' link

  @TC_1890161 @AppFreshInstalled
  Scenario: Check 'Continue' CTA in 'Get the best experience' screen
    And I redirected to 'Before you get started' screen
    And I toggle on 'Ts&Cs'
    And I click on 'Continue' CTA in the Welcome flow Screens
    And I redirected to 'We Value Your Privacy' screen
    And I click on 'Accept all cookies' CTA in 'We Value Your Privacy' screen
    And I redirected 'Our Network & Service' screen
    And I click on 'Continue' CTA in the Welcome flow Screens
    And I click on 'Continue' CTA in the Welcome flow Screens
    Then Validate Login screen content

  @TC_1890634 @AppFreshInstalled
  Scenario: Check app behavior when user taps on "Targeting Cookies" Link in "Get the best experience" screen
    And I redirected to 'Before you get started' screen
    And I toggle on 'Ts&Cs'
    And I click on 'Continue' CTA in the Welcome flow Screens
    And I redirected to 'We Value Your Privacy' screen
    And I click on 'Manage cookies' CTA
    And I click on 'Reject all' CTA in 'Cookie Permissions' screen
    And I redirected 'Our Network & Service' screen
    And I click on 'Continue' CTA in the Welcome flow Screens
    And I click on 'Enable Targeting cookies' link
    And I redirected to 'Cookie permission' screen
    And I opt "Targeting" cookie with the "OFF" state
    And I click on 'Continue' CTA in the Welcome flow Screens
    Then I validate 'Get the best experience' screen with 'Enable Targeting cookies' link

  Scenario: Check Cookie Policy's screen
    When I redirected to 'Before you get started' screen
    And I toggle on 'Ts&Cs'
    And I click on 'Continue' CTA in the Welcome flow Screens
    Then I redirected to 'We Value Your Privacy' screen
    When I click on 'CookiePolicy' link
    Then I should be navigated to CookiePolicy screen with collapsed chevrons
    When I click on the first two policies they will expand to show their description
    Then I click on the last two policies it will redirect the user to another screen regarding each policy

  @TC_1928504 @AppFreshInstalled
  Scenario: E2E_Check the flow of the Welcome Flow screens without accepting all cookies using 3G E2E_FUNC
    Then I validate 'Before you get started' screen
    And I click on 'Continue' CTA in the Welcome flow Screens
    And I click on App Privacy Supplement Link
    Then I redirected to App Privacy Supplement screen
    And I click on 'Back' CTA in Welcome flow screens
    Then I redirected to 'Before you get started' screen
    And I click on 'Terms and conditions' Link
    And I redirected to Terms and Conditions screen
    And I click on Ok CTA
    Then I redirected to 'We Value Your Privacy' screen
    When I click on 'CookiePolicy' link
    Then I should be navigated to CookiePolicy screen with collapsed chevrons
    And I click on 'Back' CTA in Welcome flow screens
    When I click on 'Accept all cookies' CTA in 'We Value Your Privacy' screen
    Then I validate 'Our Network & Service' screen without 'Enable Performance cookies' link
    And I validate on Network Improvements toggle ON and OFF
    When I click on 'Continue' CTA in the Welcome flow Screens
    Then I validate 'Get the best experience' screen without 'Enable Targeting cookies' link

  @TC_1928897 @TC_1928754 @AppFreshInstalled
  Scenario: E2E_Check the flow of the Welcome Flow screens without accepting all cookies using 3G and its reflection on Settings_FUNC
    Then I validate 'Before you get started' screen
    And I toggle on 'Ts&Cs'
    And I click on 'Continue' CTA in the Welcome flow Screens
    Then I redirected to 'We Value Your Privacy' screen
    And I click on 'Manage cookies' CTA
    Then I validate 'Cookie permission' UI from "welcomeFlow"
    When I click on 'Continue' CTA in the Welcome flow Screens
    Then I validate 'Our Network & Service' screen with 'Enable Performance cookies' link
    And I validate on Network Improvements toggle ON and OFF
    When I click on 'Continue' CTA in the Welcome flow Screens
    Then I validate 'Get the best experience' screen with 'Enable Targeting cookies' link
    When I click on 'Continue' CTA in the Welcome flow Screens
    Then I am MVA user and logged in using Soft Login
    And I should be navigated to dashboard
    And click on my Settings on dashboard tray
    When I click on Privacy Settings
    Then I redirected to Privacy Settings
    When I click on Network And Service
    Then I Validate 'Network And Service' screen from settings with link
    When I click on 'Enable Performance Cookies' link in 'network and service' screen from settings
    Then I validate 'Cookie permission' UI from "settings"
    And I Validate Value Of "Functional" Cookie Is "OFF"
    And I Validate Value Of "Performance" Cookie Is "OFF"
    And I Validate Value Of "Targeting" Cookie Is "OFF"
    And I click on the back icon for settings screens
    And I click on the back icon for settings screens
    And I click on Device Permissions entry point
    Then I navigate to Device permissions screen with enabling targeting cookies link






@WIFI @3G
Feature: DX IDM other users welcome flow feature

  @VOXI @TC_630449 @REGRESSION
  Scenario: 252540_02_P3_Verify the App behaviour when launch the App as a new Voxi user on 4G_UI
    When  wait for one second and half
    Then Validate Hello friend overlay content

  @VOXI
  Scenario: 252540_04_P2_Check Target of "Return to my Vodafone" CTA on "Hello,Friend" Overlay_Functional
    Given Hello friend overlay is displayed
    When  I click on Return to my vodafone CTA
    Then Validate Acquisition Header

  @VOXI @SME @PARTNER_MANAGER @HERITAGE @TC_630451 @TC_630452 @TC_630447 @TC_630448 @REGRESSION
  Scenario: Test Case 506745: 309986.01_P1_Check app behavior when a Partner managed user on 4G Connection access the app_Functional
    When  wait for one second and half
    Then Validate Hello friend overlay content For SME users

  @SME @PARTNER_MANAGER @HERITAGE
  Scenario: Test Case 506748: 309986.04_P1_Check the app behavior of "X" icon in "Hello, friend" screen_Functional
    When  Tap on X icon in Hello friend screen
    Then Validate Acquisition Header

  @VOXI @SME @PARTNER_MANAGER @HERITAGE @TC_505792 @TC_736652 @REGRESSION
  Scenario: Test Case 506753: 309986.09_P1_Check Tobi behavior in the acquisition dashboard_Functional
    Given Hello friend overlay is displayed
    When  I click on Return to my vodafone CTA
    Then I navigate to TOBi and validate it is opened then close it

  @VOXI @SME @PARTNER_MANAGER @HERITAGE @TC_505793 @TC_505796
  Scenario:252540_11_P1_Check "Settings" Target from the acquisition dashboard_Functional
    When  I navigate to settings from dashboard tray
    Then  I validate app and privacy settings are opened from acquisition

  @VOXI @SME @PARTNER_MANAGER @HERITAGE @TC_505797
  Scenario:276979_05.check app behaviour when user click on Setting CTA from Acquisition Dashboard Tray
    Given Init App settings for Acquisition
    And I navigate to App settings screen
    Then I validate app setting is opened and each items for acquisition
    Given Initialize Privacy Settings for Acquisition
    Then I validate privacy setting is opened and each items


  @VOXI @SME @PARTNER_MANAGER @HERITAGE @TC_505794
  Scenario:252540_12_P1_Check "My Account" Target from the acquisition dashboard_Functional
    And   I navigate to my account from dashboard tray
    Then  User should land on Login to my vodafone-Username screen for the UFL mode

#  @VOXI
#  Scenario:252540_05_P1_Check the app behavior of "X" icon in "Hello, friend" screen_Functional
#    Given Hello friend overlay is displayed
#    When  Click on x icon
#    Then Validate Acquisition Header

# @HERITAGE
#  Scenario:258984.07_P2_Check the app behavior when selecting "Return to my Vodafone" CTA with no internet connection_Fucntional
#   Given Hello friend overlay is displayed
#    When  I click on Return to my vodafone CTA
#    Then Validate Acquisition Header

  @VOXI
  Scenario:252540_06_P2_Check the app behavior when hard close the app in "Hello, friend" screen and relaunch it again_Functional
    Given Hello friend overlay is displayed
    When I close the app and relaunch it again
    Then Hello friend overlay is displayed
    Then Validate Acquisition Header
    When wait for one second and half
    Then Hello friend overlay is displayed

  @VOXI
  Scenario:252540_07_P2_Check the app behavior when hard close the app in Acquistion dashboard screen and relaunch it again_Functional
    Given Hello friend overlay is displayed
    When  Click on x icon
    Then Validate Acquisition Header
    When I close the app and relaunch it again
    Then Hello friend overlay is displayed
    And  wait for one second and half
    Then Hello friend overlay is displayed

  @VOXI @SME @PARTNER_MANAGER @HERITAGE
  Scenario: Test Case 519692: 310590.08_P1_Check the behavior for using a Forgotten username Deep link when using unknown user on WiFi_FUNC
    Given Tap on universal link
    And  wait for one second and half
    Then Hello friend overlay is displayed


#  @VOXI @SME @PARTNER_MANAGER
#  Scenario:252540_10_P1_Check "Tobi" behavior in the acquisition dashboard_Functional
#    Given Hello friend overlay is displayed
#    When  I click on Return to my vodafone CTA
#    Then Validate Acquisition Header
#    When  Click on Tobi Icon
#    Then Tobi chat should be displayed


  @UNKNOWN @630453
  Scenario: Check Hello, friend Screen Content With Unknown User On Wifi Connection
    Then Validate Hello Friend Screen Content With Unknown User

  @UNKNOWN @630453
  Scenario: Check Target of Return to my vodafone CTA With Unknown User On Wifi Connection
    When I click on Return to my vodafone CTA With Unknown User
    Then Acquisition Screen Is Displayed

  @UNKNOWN
  Scenario: Check App Behavior After HardClose in Hello Friend Screen
    When App HardClose In Hello Friend Screen Then Relaunch
    Then Validate Hello Friend Screen Content With Unknown User



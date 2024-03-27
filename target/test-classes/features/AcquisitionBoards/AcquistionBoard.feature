#@VOXI @SME @PARTNER_MANAGER @HERITAGE
Feature: Acquisition Board

  Background: Initialize Acquisition Board
    When  I click on Return to my vodafone CTA

  @TC_630443 @REGRESSION @UNKNOWN_USER
  Scenario: Test Case 506753: 309986.09_P1_Check Tobi behavior in the acquisition dashboard_Functional
    Then I navigate to TOBi and validate it is opened then close it

  @TC_630444 @REGRESSION @UNKNOWN_USER
  Scenario:252540_11_P1_Check "Settings" Target from the acquisition dashboard_Functional
    When  I navigate to settings from dashboard tray
    Then  I validate app and privacy settings are opened from acquisition
    And I navigate to App settings screen
    Then I validate app setting is opened and each items for acquisition
    Given Initialize Privacy Settings for Acquisition
    Then I validate privacy setting is opened and each items


  @TC_630445 @REGRESSION @UNKNOWN_USER @Secondary_Subscription
  Scenario:252540_12_P1_Check "My Account" Target from the acquisition dashboard_Functional
    And   I navigate to my account from dashboard tray
    Then  User should land on Login to my vodafone-Username screen for the UFL mode

  @TC_1191146 @3G  @Secondary_Subscription
  Scenario: Check existence of secondary subscription on subscriptions sub-overlay screen
    When I navigate to my account from dashboard tray
    And I am MVA user and upfront logged in using user name and password
    And I click on my account without login
    Then I validate secondary subscription not exist on subscriptions sub-overlay screen

  @UFL @TC_630442 @REGRESSION @WIFI
  Scenario: Check Target of Login CTA With Unknown User On Wifi Connection
    When I navigate to my account from dashboard tray
    And I am MVA user and upfront logged in using user name and password
    Then I should be navigated to dashboard

  @UNKNOWN_USER @TC_1039331 @REGRESSION
  Scenario: Check acquisition dashboard background image targeted URL
    When I click on the background image
    Then the app should be directed to the offerpage

  @UNKNOWN_USER @TC_1039332 @REGRESSION
  Scenario: Check acquisition dashboard header SeeOffer CTA targeted URL
    When I click on the SeeOffer CTA
    Then the app should be directed to the offerpage

  @TC_630442  @WIFI
  Scenario: Check Target of Login CTA With Unknown User On Wifi Connection
    When I navigate to my account from dashboard tray
    And I am MVA user and upfront logged in using user name and password
    Then I should be navigated to dashboard

# These scenarios no need anymore in the regression suite
#  Scenario: TC01_checkAcquisitionHeader
#    Then Validate Acquisition Header
#  Scenario: Check Acquisition Tiles
#    Then Validate Acquisition Tiles

#  Scenario: TC04_checkVeryMeSection
#    Then Validate Very Me Section
#
#Scenario: TC05_checkFooterSection
#    Then Validate Footer Section
#
#  Scenario: TC06_checkCloseBtnGoBackAcqScreen
#    Given Press Acquisition Board X Icon
#    Then Validate Pressing X Icon
#
#  @ANDROID
#  Scenario: TC07_checkPressBackBtnGoBackAcqScreen
##    Given Press Acquisition CTA
#    Then Validate Pressing Native Back Button

  @UNKNOWN_USER @VOXI @HERITAGE @PARTNER @TC_1203774 @TC_1203772 @TC_1203749 @TC_1203771

  Scenario: validate New Acquisition Dashboard - Header and  Re direction
    When I validate New Acquisition Dashboard - Header
    And I click on the copy Already a Vodafone Customer? Log in
    Then Login screen should be displayed


  Scenario: Validate Why vodafone section new basic dashboard
    Then : I should validate why vodafone section


  @UNKNOWN_USER @TC_1226022 @TC_1226026  @TC_1226040 @TC_1226041 @TC_1226049 @TC_1226030
  Scenario: validate Discover vodafone in basic dashboard new implementation

    Then I should see a section titled Discover Vodafone with four mini cards carousel
    Then I click on PayMonthly
    Then I click on SIM only deals
    Then I click on Broadband
    Then I click on Trade-in Tool

  @TC_601894 @UNKNOWN_USER @TC_1048314 @REGRESSION
  Scenario: TC03_checkMoreToLoveSection
    Then Validate More To Love Section

  @TC_1054548 @UNKNOWN_USER @REGRESSION
  Scenario: Check Why Vodafone section
    Then Validate Why Vodafone header
    Then Validate Footer Section

  @TC_1596489 @UNKNOWN_USER
  Scenario:  Validate the latest offers in basic dashboard new section
    Then  I should validate The latest offers section


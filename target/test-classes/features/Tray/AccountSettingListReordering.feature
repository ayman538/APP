@1140845 @Consumer @SOLETRADER @3G
Feature:Account Settings List Reordering

  Background:Initialize Setting Drawer and Account Setting

    Given I am MVA user and logged in using Soft Login
    And I close the tutorial if displayed
    And  I should be navigated to dashboard
    And I navigate to settings from dashboard tray
    And Click on Account Setting

    @1140845 @Consumer @Soletrader @3G
    Scenario: validate the new order and text for Account setting list for Soft login user has Spend manager
     Then Check Account setting ordering and texts

    @1206205 @Consumer @MPS @3G
    Scenario: validate the new eCare reinvent page for spend Manager
     And Click on Spend Manager CTA
     And I am MVA user and logged in using full login with user name and password
     Then I should be directed to Spend Manager Webview

    @Consumer @Soletrader  @TC_1206919
    Scenario: Validate the new eCare Reinvent journey for Cards & Payments
     And Click on Cards & Payments CTA
     And I am MVA user and logged in using full login with user name and password
     Then I should be directed to Manage Cards & Payments Webview

    @1227402 @Consumer @Soletrader @3G
    Scenario: validate the new eCare reinvent page for Data Notifications
     And Click on Data Notifications CTA
     And I am MVA user and logged in using full login with user name and password
     Then I should be directed to Data Notifications

    @1227363 @Consumer @Soletrader @3G
    Scenario: validate the new eCare reinvent page for Profile & Address
     And Click on Profile & Address CTA
     And I am MVA user and logged in using full login with user name and password
     Then I should be directed to Profile & Address Webview

    @TC_1524483 @Consumer_MPS @Soletrader_MPS @3G
    Scenario: validate the new eCare reinvent page for Activate SIM
     And I click on Activate SIM CTA
     And I am MVA user and logged in using full login with user name and password
     Then I should be directed to Activate SIM Webview

    @TC_1886476 @Consumer_MPS @Soletrader_MPS @3G
    Scenario: validate the new eCare reinvent page for SIM Swap
     And I click on SIM Swap CTA
     And I am MVA user and logged in using full login with user name and password
     Then I should be directed to SIM Swap Webview

    @TC_1775329 @SMB @3G
    Scenario: validate Account settings screen for SMB user
     Then Check Account settings for SMB user

    @TC_1775324 @PAYG+ @3G
    Scenario: validate Account settings screen for PAYG+ user
     Then Check Account settings for PAYG+ user

    @TC_1775335 @UFL @WIFI
    Scenario: Validate Log out for UFL user using WIFI
     And Validate Logout CTA in Account settings list
     And I click on Logout CTA
     Then Logout Popup message appears

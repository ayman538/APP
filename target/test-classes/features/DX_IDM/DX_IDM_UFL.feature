@WIFI @DX_IDM @LOGIN
Feature: DX IDM UFL flow feature

#    Scenario: Validate Skip login
#      Given Skip Login
#      Then Validate Disconnect WiFi screen
#      And Close Disconnect WiFi screen

    Scenario: Validate Username Screen Content
      Given Login Till Reach Username Screen
      Then Validate username screen content

    Scenario: Check App behavior After Softclose In Username Screen
      Given Login Till Reach Username Screen
      When I put the app in background
      Then Username screen is displayed

    @TC_505732
    Scenario: Check Behavior of X Button In Username Screen
      Given Login Till Reach Username Screen
      When Click X button
      Then Validate Login to My Vodafone screen is displayed

    Scenario: Validate Password Screen Content
      Given Login Till Reach Password Screen
      Then Validate password screen content

    Scenario: Check App Behavior After Softclose In Password Screen
      Given Login Till Reach Password Screen
      When I put the app in background
      Then Password screen is displayed

    @TC_505732
    Scenario: Check Behavior of X Button In Password Screen
      Given Login Till Reach Password Screen
      When Click X button
      Then Validate Login to My Vodafone screen is displayed

    Scenario: Validate Request Security Code Screen Content
      Given Login Till Reach Request Security Code Screen
      Then Validate Request Security Code Screen Content

    @TC_505737
    Scenario: Check Chat To Us Functionality In Request Security Code screen
      Given Login Till Reach Request Security Code Screen
      When Click On Chat To Us
      Then Validate Tobi Journey Is Triggered

    Scenario: Validate Enter Security Code Screen Content
      Given Login Till Reach Request Security Code Screen
      Given Login Till Reach Enter Security Code Screen
      Then Validate Enter Security Code Screen Content

    @Android
    Scenario: Check Physical Back Button In Enter Security Code Screen
      Given Login Till Reach Request Security Code Screen
      When Click On Physical Back Button
      Then Request Security Code Screen Is Displayed

    @TC_505743
    Scenario: Validate Choose Account Screen Content
      Given Login Till Reach Request Security Code Screen
      Given Login Till Reach Choose Account Screen
      Then Validate Choose Your Account Screen Content

    @TC_505745
    Scenario: Check Behavior of X Button In Choose Account Screen
      When Click X button in Accounts screen
      Then Validate Login to My Vodafone screen is displayed

    @TC_505744
    Scenario: Validate Choose Plan Screen Content
      Given Login Till Reach Choose Plan Screen
      Then Validate Choose Your Plan Screen Content

    @TC_505745
    Scenario: Check Behavior of X Button In Choose Plan Screen
      When Click X button  in Plan screen
      Then Validate Login to My Vodafone screen is displayed

    @TC_505748
    Scenario: Validate Login Preferences Screen Content
      Given Login Till Reach Login Preference Screen
      Then Validate Login Preferences Screen Content

    @TC_505751
    Scenario: Check App Behavior After SoftClose in Login Preference screen
      When I put the app in background
      Then Validate Login to My Vodafone screen is displayed

    @TC_505751
    Scenario: Check App Behavior After HardClose in Login Preference screen
      Given Login Till Reach Login Preference Screen
      When App HardClose Then Relaunch
      Then Validate Login to My Vodafone screen is displayed

    @LoginWithPIN
    Scenario: Select Login Preferences As PIN
      Given Login Till Reach Login Preference Screen
      Then Select PIN
      Then Press All done CTA and Validate Dashboard

    @LoginWithUsername/Password
    Scenario: Select Login Preferences As Username and Password
      Given Login Till Reach Login Preference Screen
      When Select Username and Password
      Then Press All done CTA and Validate Dashboard

  @Android
  Scenario: Validate Physical Back Button not working on Enter your Username screen
    Given Login Till Reach Username Screen
    Then Validate click on the Physical Back Button on username screen_FullLogin


  @Android
  Scenario: Validate Physical Back Button not working on Enter your Password screen
    Given Login Till Reach Password Screen
    Then Validate click on the Physical Back Button on Password screen_FullLogin

  @Android
  Scenario: Validate Physical Back Button not working on Requested security code screen
    Given Login Till Reach Request Security Code Screen
    Then Validate click on the Physical Back Button on Requested security code screen

  @Android
  Scenario: Validate Physical Back Button not working on Enter security code screen
    Given Login Till Reach Enter Security Code Screen
    Then Validate click on the Physical Back Button on Enter security code screen

  @Android
  Scenario: Validate Physical Back Button not working on Choose account  screen
    Given Login Till Reach Choose Account Screen
    Then Validate click on the Physical Back Button on Choose account screen

  @Android
  Scenario: Validate Physical Back Button not working on Choose plan screen
    Given Login Till Reach Choose Plan Screen
    Then Validate click on the Physical Back Button on Choose plan screen

  @Android
  Scenario: Validate Physical Back Button not working on Login preference screen
    Given Login Till Reach Login Preference Screen
    Then Validate click on the Physical Back Button on Login preference screen

  @Android
  Scenario: Validate Physical Back Button not working on forgotten username screen
    Given Login Till Reach Username Screen
    When Tap on forgot username
    Then Validate click on the Physical Back Button on forgotten username  screen

  @Android
  Scenario: Validate Physical Back Button not working on forgotten Password screen
    Given Login Till Reach Password Screen
    When Click on Forgotten password
    Then Validate click on the Physical Back Button on Forgotten password screen

  @TC_630910 @WIFI @MPS
  Scenario: Validate app opens External webview after click on forgotten username
    Given Login Till Reach Username Screen
    When Tap on forgot username
    Then app opens forgot username in external webview

@TC_634285 @DXIDM @MPS @WIFI @REGRESSION
Scenario: Check UFL flow for user has one account with many subscriptions
  Given Login Till Reach Username Screen
  When Tap on forgot username
  And app opens forgot username in external webview
  And I close the external webview
  And Login Till Reach Username Screen
  And I click on Register for My Vodafone
  And I navigate to a custom tab
  And I close the custom tab
  And I navigate to the password screen
  And Click on Forgotten password
  And I navigate to the forgotten password external webview
  And I close the external webview
  And Login Till Reach Request Security Code Screen
  And Login Till Reach Enter Security Code Screen
  And I click on I haven't received my security code link
  Then I should see the tobi chat
  And Validate Tobi Journey Is Triggered

  @TC_634286 @WIFI @MPS @REGRESSION @DXIDM @UFLDXIDM
  Scenario: Check Account Subscription journey for a User with multiple accounts with multiple users
    Given Preform UFL Using Login Preference Method "pin"
    Then I should be navigated to dashboard

  @TC_634288 @WIFI @REGRESSION @LOGIN @DXIDM @UFLDXIDM
  Scenario: Check prepopulation of Username field
    Given Preform UFL Using Login Preference Method "un"
    Then I should be navigated to dashboard
    When HardClose the App and Relaunch
    And I close the tutorial if displayed
    And I navigate to my account from dashboard tray
    Then Validate username is Auto Populated

  Scenario: UFL
    Given Preform UFL Using Login Preference Method "pin"


  @WIFI @LoginWithPhoneNumber @single_contact @TC_1379898
  Scenario: Validate UFL Login with phone number and password with account has single contact
    Given I navigate to Username or Phone number login screen
    Then I validate username or phone number screen and Insert phone number
    And I proceed UFL till reach login preference screen
    Then Press All done CTA and Validate Dashboard
    When hard close the app
    And I close the tutorial if displayed
    And I navigate to Username or Phone number login screen
    Then Validate username is Auto Populated


  @WIFI @LoginWithPhoneNumber @multiple_contacts_diff_DOB  @TC_1406482
  Scenario: Validate UFL Login with phone number and password with account has multiple contacts with different DOB
    Given I navigate to Username or Phone number login screen
    Then I validate username or phone number screen and Insert phone number
    And I validate DOB screen and Insert DOB
    And I proceed UFL till reach login preference screen
    Then Press All done CTA and Validate Dashboard


  @WIFI @LoginWithPhoneNumber @multiple_contacts_same_DOB @TC_1406525
  Scenario: Validate UFL Login with phone number and password with account has multiple contacts with same DOB
    Given I navigate to Username or Phone number login screen
    Then I validate username or phone number screen and Insert phone number
    And I validate DOB screen and Insert DOB
    And I validate first and last name screen and Insert first and last name
    And I proceed UFL till reach login preference screen
    Then Press All done CTA and Validate Dashboard
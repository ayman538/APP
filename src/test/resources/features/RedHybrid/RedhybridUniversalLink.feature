@REDHYBRID
Feature: RedHybrid PaymentReminder Overlay

  Background:

    Given I am MVA user and logged in using Soft Login

  @RedHybrid @TC_634593 @Android
  Scenario: Check App's behavior when tapping on Manage cards universal link using PAYM after hard close the app
    When I should be navigated to dashboard
    And HardClose the App
    And Navigate to manage card
    And click on accept it in The Cookie permission message
    And Enter Username And Password
    And Chose Login Preference And Click Ok All Done
    Then Add Payment drawer is displayed

  @RedHybrid @TC_634593 @IOS
  Scenario: Check App's behavior when tapping on Manage cards universal link using PAYM after hard close the app
    When I should be navigated to dashboard
    And HardClose the App
    And Navigate to manage card
    And click on accept it in The Cookie permission message
    And Enter Username And Password
    And Chose Login Preference And Click Ok All Done
    Then Add Payment drawer is displayed


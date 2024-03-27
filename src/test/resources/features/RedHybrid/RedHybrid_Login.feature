@REDHYBRID
Feature: RedHybrid Login Feature

  Background: RedHybrid Login Flow

  @4G @TC_555732  @SIT_CYCLE1 @GENERAL_TESTDATA
  Scenario: Check Skip Login Functionality On 4G
    Given Login To My Vodafone Screen Is Displayed
    When I am MVA user and logged in using Soft Login
    Then I should be navigated to dashboard
    #to run this scenario you need to set connection to be 3g from dev settings

  @4G @TC_555730  @SIT_CYCLE1 @GENERAL_TESTDATA
  Scenario: Check Login Functionality On 4G
    Given Login To My Vodafone Screen Is Displayed
    When User full login
    Then I should be navigated to dashboard
    #to run this scenario you need to set connection to be 3g from dev settings

  @WIFI @TC_555729  @SIT_CYCLE1 @GENERAL_TESTDATA
  Scenario: Check Login Functionality On WiFi
    Given Login To My Vodafone Screen Is Displayed
    When Click On Login CTA
    And Enter Username And Password
    And Select Account And Enter Security Code
    And Chose Login Preference And Click Ok All Done
    Then I should be navigated to dashboard
    #to run this scenario you need to set connection to be WIFI from dev settings
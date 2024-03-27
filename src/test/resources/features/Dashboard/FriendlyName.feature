Feature: FriendlyName
  Background:
    Given I close the tutorial if displayed
    And I am MVA user and logged in using Soft Login


  @TC_1225852 @TC_1225853 @TC_1225856 @TC_1206223 @TC_1206399 @TC_1206400 @TC_1420717_E2E @PayM @Bingo
  Scenario:P1 - Check Pencil icon is exist in main dashboard of PayM user_Functional
    Given I am MVA user and logged in using full login with user name and password
    And close my account sheet
    When I tap on Pencil icon
    And I enter an invalid friendly name
    Then I validate invalid friendly name error message displayed
    When I enter a valid friendly name
    And I tap on save CTA
    Then I validate friendly name updating screen displayed
    When I close updating screen
    And I tap on Pencil icon
    Then I validate friendly name pending screen displayed


  @TC_1165959 @TC_1165957 @PayG @PayG+
  Scenario:P1 - Check Pencil icon is exist in main dashboard of PayG user_Functional
    Then I validate that Pencil icon is not displayed


  @TC_1595346 @TC_1595346 @PayM @PayG+
  Scenario: Check app behavior when user taps on the area containing the pencil/edit icon ,my MSISDN and Friendly Name on the main dashoard
    Given I tap on area containing the pencil-edit icon ,my MSISDN with-without Friendly Name
    When I am MVA user and logged in using full login with user name and password
    Then I validate friendly name overlay is displayed
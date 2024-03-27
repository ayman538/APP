@3G
Feature: Bingo Benefits

  Background: Initialize BingoBenefits Class
    Given I am MVA user and logged in using Soft Login
    When I Dismiss The First Tip


  Scenario: TC01_ValidateNewPlanIncludesSection
    Given New plan includes chevrons are displayed
    Then Check includes section existence
    And Validate elements displayed in includes section

  @REGRESSION @TC_601913 @BINGO
  Scenario: TC06_Check That 51 Roam Free Destinations Product in the Plan tab
    Given I navigate to plan tab from Dashboard
    Then Assert That 51 Roam Free Destinations Product Is Displayed
#    Then Validate Product Title is displayed "Inclusive roaming in 51 European destinations"


  @REGRESSION @BINGO @TC_601924
  Scenario: TC02_ValidateUnlimitedPictureMessagesProductTitle
    And   I navigate to plan tab from Dashboard
    When Assert ProductName and ProductTitle are displayed

 @TC_601923 @BINGO
  Scenario: TC05_Check That 50% off OneNumber Benefit in the Plan tab
    Given I navigate to plan tab from Dashboard
   Then Assert That 50% off Card Is Displayed

  @REGRESSION @TC_601920 @BINGO @1207022
  Scenario: Check Unlimited Data Booster journey under "Includes" section in Plan Card_Functional
    Given I navigate to plan tab from Dashboard
    When User Selects Unlimited Data Booster
    Then I should see Unlimited data booster screen with "Activate by text" CTA

  @TC_634660 @TC_634659 @TC_634655 @SMB
  Scenario: P2_Check Battery refresh Tool icon and copy for Bingo or non-Bingo users_UI
    And  I Scroll Down to Assistance links
    Then I Should See Battery Refresh in Assistance menu
    When I click on Battery Refresh Item
    Then I Should See the Battery Refresh Tool Page

  Scenario: TC07_Check That 81 Roam Free Destinations Product in the Plan tab
    Given I navigate to plan tab from Dashboard
    Then Assert That 81 Roam Free Destinations Product Is Displayed

   @TC_1230989 @TC_1290740 @BINGO @Eligible_BBG_Iphone14
  Scenario: Check app behavior when Bingo user clicks on "Phone Buy-Back Guarantee" in device plan sub overlay screen
    Given I click on device plan tile
    Then  I validate device plan sub overlay screen is displayed
    Then  I validate Buy-Back Guarantee is displayed in includes section with state Available soon
    When  I click on Phone Buy-Back Guarantee CTA of Iphone 14 loan
    Then I will be redirected to Phone Buy-Back Guarantee eligibility screen

  @TC_1639200 @TC_1403166 @TC_1327046 @BINGO
  Scenario: Check app behavior when Bingo user clicks on "Lifetime Warranty" in "Device plan" subs overlay screen
    Given I click on device plan tile
    Then I validate device plan sub overlay screen is displayed
    Then I validate Lifetime warranty entry point in includes section
    When I click on Lifetime warranty entry point
    Then I will be directed to Lifetime Warranty screen
    When I click on Find out more CTA
    Then I will be directed to Lifetime Promise Webview

  @TC_1639104 @BINGO
  Scenario: Check app behavior when Bingo user clicks on "Total Care Warranty" in "Device plan" subs overlay screen
    Given I click on device plan tile
    Then I validate device plan sub overlay screen is displayed
    And Check Total Care Warranty in Includes section
    And I click on Total Care Warranty CTA
    And I validate Total Care Warranty screen is displayed
    When I click on Find out more CTA
    Then I will be directed to Lifetime Promise Webview

  @TC_1817494 @TC_1817495 @TC_1817497 @BINGO @@Eligible_BBG_Iphone15
  Scenario: Check app behavior when Bingo user with iPhone 15 Loan clicks on "Phone Buy-Back Guarantee" in device plan sub overlay screen
    Given I click on device plan tile
    Then I validate device plan sub overlay screen is displayed
    Then  I validate Buy-Back Guarantee iPhone 15 Entry Point in includes section with state Available soon
    When  I click on Phone Buy-Back Guarantee CTA of iPhone 15 loan
    Then I will be redirected to Phone Buy-Back Guarantee of iPhone 15 eligibility screen
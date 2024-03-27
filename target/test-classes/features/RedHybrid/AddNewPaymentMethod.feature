@3G @RedHybrid
Feature: Add New Payment Method
  Background:
    Given I am MVA user and logged in using Soft Login
    And  I should be navigated to dashboard
    When I click on payment on dashboard tray
    When I am MVA user and logged in using full login with user name and password
    And  I remove the added payment card if exist

  @TC_467620 @TC_467621 @TC_468362
  Scenario: Check the UI for Add new card screen
    Then I should Validate Add new payment method is displayed successfully


  @TC_467622 @TC_467623 @Regression_Active_NO_Payment
  Scenario: Check the App behavior when tapping on Add a new card CTA
    When I click on Add a new card CTA
    Then I should Validate Add Payment method screen is displayed successfully
    Then I should Validate Add Payment method screen content

  @TC_467624
  Scenario: Check the App behavior when tapping on the payment toggles
    When I click on Add a new card CTA
    When Turn on the toggles
    Then I should Validate Continue CTA is clickable

  @TC_467625 @TC_467627
  Scenario: Check clicking on "X" button in Add new card drawer
    When I click on Add a new card CTA
    When I click on X icon
    Then I should Validate X icon is not displayed
    When I click on payment on dashboard tray
    When I click on X icon
    Then I should Validate X icon is not displayed

  @TC_473565 @Active_NO_Payment
  Scenario: P2_Check App behavior when selecting Back arrow in Add new payment screen_Functional
    When I click on Add a new card CTA
    When Tap on back icon
    Then I should Validate Add new payment method is displayed successfully

  @ANDROID @TC_467629
  Scenario: P3_Check the behavior when clicking on android back button in Add payment method screen
    When I click on Android physical back
    Then I should Validate X icon is not displayed

  @E2E_AddNewPaymentCard @TC_1240142
  Scenario: User Add new payment method from Payments icon from dashboard tray
    When I click on Add a new card CTA
    And  I agree on terms and conditions in add payment method
    And  I click on continue CTA
    And  I search for post code "BT41 1EZ"
    And  I select the first address
    And  I scroll down to bottom of the billing address screen
    And  I click on continue CTA
    And  I insert user's payment details "test" , "5105660000000152" , "3" , "29" and "258"
    Then I should validate processing icon displayed successfully
    Then I click on continue CTA
    And  I should be navigated to payment method
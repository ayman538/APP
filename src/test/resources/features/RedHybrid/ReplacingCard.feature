@3G @RedHybrid @LOGIN

Feature: Replacing Payment Card

  Background:
    Given I am MVA user and logged in using Soft Login
    And  I should be navigated to dashboard
    When I navigate to payment tray from Dashboard
    And I am MVA user and logged in using full login with user name and password
    Then I add new payment if no payment method exists
    And I should be navigated to payment method


  Scenario: P1- Check the behavior of the app when click on replace my card CTA in payment method screen _Functional
    When I click on replace my card CTA
    Then I should be navigated to add another payment

  @TC_520580 @Regression_Active_Payment
  Scenario: P1- Check the behavior of the app when replace the card with the card type_Functional
    Given I click on replace my card CTA
    When I agree on terms and conditions in add payment method
    And  I click on continue CTA
    And  I search for post code "BT41 1EZ"
    And  I select the first address
    And  I scroll down to bottom of the billing address screen
    And  I click on continue CTA
    And  I insert user's payment details "test" , "5105660000000152" , "3" , "29" and "258"
    Then I should validate processing icon displayed successfully
    Then I click on continue CTA
    Then I should validate that the card is replaced successfully

  @TC_520848
  Scenario: P2- Check the behavior of the app when click physical back button after tapping on replace my card
    Given I click on replace my card CTA
    When  Tap on back icon
    Then I should check replace card screen
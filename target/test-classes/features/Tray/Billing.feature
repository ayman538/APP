## This TCs not exist in teh regression suite
#@3G @CONSUMER
Feature: Billing Screen

Background: Initialize Billing class
    Given I am MVA user and logged in using Soft Login

#
#  @SMB @SOLETRADER @TC_601808
#  Scenario: TC01_validateBillingIconFunctionality
#    When clicks on Billing
#  @NOT_10_18
#  Scenario: TC02_ValidateAccountName
#    Then Validate Account name
#  @NOT_10_18
#  Scenario: TC03_ValidateGraphAppearance
#    Then Validate Graph appearance
#  @NOT_10_18
#  Scenario: TC04_ValidateGraphTitle
#    Then Validate Graph title
#
#  Scenario: TC05_ValidateViewAllCTAText
#    Then Validate View All CTA text
#
#  Scenario: TC06_ValidateViewAllCTA
#    Then Validate View All CTA opens Login screen
#  @NOT_10_18
#  Scenario: TC07_ValidateCloseCTADisplayed
#    Then Validate close x-icon is displayed
#  @NOT_10_18
#  Scenario: TC08_ValidateBillingCardsDisplayed
#    Then Validate Billing Cards are displayed
#  @NOT_10_18
#  Scenario: TC09_ValidateBillingCardsCTA
#    Then Validate Billing card CTAs are displayed
#  @NOT_10_18
#  Scenario: TC10_ValidateVatsDisplayed
#    Then Validate VATs displayed on cards
#  @NOT_10_18
#  Scenario: TC11_ValidateCloseCTAFunctionality
#    Then Validate Billing x-icon functionality

@SANITY @TC_675606 @REGRESSION @3G @MPS
Scenario: Check the content of the billing dashboard using a softlogged consumer MPS user has more than 6 bills
Then InitBillingLogicObject
Then navigateToBilling
Then I should see the new billing dashboard
Then I should see bar chart
Then I should see bills
Then I should NOT see View All CTA

@TC_675607 @3G @REGRESSION @MPS @Special @LessThan3Bills
Scenario: Check the content of the billing dashboard using a softlogged consumer MBB user who has less than 3 bills
Then InitBillingLogicObject
Then navigateToBilling
Then I should see the new billing dashboard
Then I should NOT see bar chart
Then I should see bills
Then I should NOT see View All CTA

    @TC601808 @SMB @SOLETRADER @REGRESSION
    Scenario: Validate Login Screen opened when user Click on Billing in soft logged in
    When I should see the new billing dashboard
    Then accept cookies
    Then I validate the login screen appears




# This TCs not exist in teh regression suite and not tags exist on the scenarios
Feature: Billing Card

  Background: Start the billing dashboard
    Given I am MVA user and logged in using Soft Login
    And I close the tutorial if displayed
    And I should be navigated to dashboard
    And I navigate to the new billing dashboard
    And I close the billing tutorial if displayed
    And I should see the new billing dashboard

  @TC820026 @TC2008157 @SoftLogin @FutureBillCard @Consumer @BillingRegression
  Scenario: Validate the Existence of the Future Bill Card
    Then I should see the "future" bill card
    And I should see The month of the "future" bill
    And I should see the i icon with a statement of when the "future" bill will be created
    And I should see the "future" bill status info
    And I should see the "future" bill Estimated Total text
    And I should see the "future" the total Amount of charges
    And I should see the VAT text beside the "future" bill card


  @TC820029 @SoftLogin @FutureBillCard @Consumer @BillingRegression
  Scenario: Validate the Redirection of the Future Bill Card to reinvent journey
    When I should see the "future" bill card
    And I click on the > icon of the "future" bill card
    And click on accept it in The Cookie permission message
    And Enter Username And Password
    And Chose Login Preference And Click Ok All Done
    Then I should see the Future Bill Reinvent journey is open
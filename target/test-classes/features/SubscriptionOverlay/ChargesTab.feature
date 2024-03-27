@3G @CONSUMER
Feature: Charges tab for PAYM users

  Background: Initialize Charges Tab tab
    Given I am MVA user and logged in using Soft Login
    Given I navigate to charges tab from subscriptions overlay

  @REGRESSION @MPS @TC_601811
  Scenario: CheckAdditionalCharges
    Then Validate Additional Charges

  @REGRESSION @MPS @TC_601885
  Scenario: Check not logged in user can't view the itemized out of bundle charges screen
    Then Validate Required Login in Itemized Journey

  @REGRESSION @MPS @TC_601887 @LOGIN
  Scenario: Check logged in user can view the itemized out of bundle charges screen
    Given Preform FL Using Login Preference Method "un"
    Then Click on Chevron of additional charges
    Then Click on Chevron of details item
    Then Validate Itemized screen
    Then Validate UnBills More Than Six

  @MPS @TC_601888 @LOGIN
  Scenario: TC06_validateUnBillsMoreThanSix
    Then Validate Total Estimated Charges
    Then Click on Chevron of additional charges
    Then Click on Chevron of details item
    Then User full login
    Then Validate UnBills More Than Six

 # Scenario: TC02_validateChargesSSO
 #   Then Validate Charges SSO

  @SANITY @TC_664543 @MPS @REGRESSION @LOGIN
  Scenario: Check the new changes in Reinvent webview  when accessing "VIEW_ITEMISED_BILL" journey using a FL SoleTrader
    Then Click on View Details CTA
    Then Preform FL Using Login Preference Method "un"
    Then Validate view charges SSO is opened

  @SANITY @REGRESSION @MPS @3G
  Scenario: Validate the Charges screen content
    Then Validate Additional Charges
    And Validate Total Estimated Charges
    And I validate Monthly Charges


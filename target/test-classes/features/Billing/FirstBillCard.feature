Feature: First Bill Card

  Background: Start the billing dashboard
    Given I am MVA user and logged in using Soft Login
    And I close the tutorial if displayed
    And I should be navigated to dashboard
    And I navigate to the new billing dashboard
    And I close the billing tutorial if displayed
    And I should see the new billing dashboard

  @TC838127 @TC2008157 @SoftLogin @FirstBillCard @Consumer @BillingRegression @FirstBillUer
  Scenario: Validate the Existence of The First Bill Card and the Explaining card
    Then I should see the "first" bill card
    And I should see The month of the "first" bill
    And I should see The month cycle of the first bill
    And I should see the i icon with a statement of when the "first" bill will be created
    And I should see the "first" bill status info
    And I should see the "first" bill Estimated Total text
    And I should see the "first" the total Amount of charges
    And I should see the VAT text beside the "first" bill card
#    And The Explaining bill Card Contains the explaining status
#    And The Explaining bill Card Contains the i Icon


  @TC838131 @SoftLogin @FirstBillCard @Consumer @BillingRegression @FirstBillUer
  Scenario: Validate the Redirection of the First Bill Card to reinvent journey
    When I should see the "first" bill card
    And I click on the > icon of the "first" bill card
    And click on accept it in The Cookie permission message
    And Enter Username And Password
    And Chose Login Preference And Click Ok All Done
    Then I should see the first Bill Reinvent journey is open

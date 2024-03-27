Feature: Payment overdue Card

  Background: Start the billing dashboard
    Given I am MVA user and logged in using Soft Login
    And I close the tutorial if displayed
    And I should be navigated to dashboard
    And I navigate to the new billing dashboard
    And I close the billing tutorial if displayed
    And I should see the new billing dashboard


    #It can be latest/first/future but the user bill should be overdue
  @TC @SoftLogin @PaymentOverDue @Consumer @UserHasAOverDue @BillingRegression
  Scenario: Validate the Existence of the Latest Bill Card
    Then I should see the "latest" bill card

  @TC938126 @SoftLogin @PaymentOverDue @Consumer @UserHasAOverDue @BillingRegression
  Scenario: Validate the Existence of the Payment Overdue Card
    Then I should see the Payment Overdue Card
    And I should see the Payment Overdue Card Icon
    And I should see the Payment Overdue Card Subtitle
    And I should see the Pay bill now CTA

  @TC938128 @SoftLogin @PaymentOverDue @Consumer @UserHasAOverDue @Reinvent @BillingRegression
  Scenario: Validate the reinvent journey is opened when click on Pay Bill CTA
    When I should see the Payment Overdue Card
    And I click on the Pay bill now CTA
    And click on accept it in The Cookie permission message
    And Enter Username And Password
    And Chose Login Preference And Click Ok All Done
    Then I should be navigated to the Payment Reinvent journey

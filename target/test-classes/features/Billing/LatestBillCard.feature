Feature: Latest Bill Card

  Background: Start the billing dashboard
    Given I am MVA user and logged in using Soft Login
    And I close the tutorial if displayed
    And I should be navigated to dashboard
    And I navigate to the new billing dashboard
    And I close the billing tutorial if displayed
    And I should see the new billing dashboard

  @TC847624 @SoftLogin @LatestBillCard @Consumer @BillingRegression
  Scenario: Validate the Existence of the Latest Bill Card
    Then I should see the "latest" bill card
    And I should see The month of the "latest" bill
    And I should see The month cycle of the latest bill
    And I should see the i icon with a statement of when the "latest" bill will be created
    And I should see the "latest" bill status info
    And I should see the "latest" bill Estimated Total text
    And I should see the "latest" the total Amount of charges


  @TC847627 @SoftLogin @LatestBillCard @Consumer @BillingRegression
  Scenario: Validate the Redirection of the Latest Bill Card to reinvent journey
    When I should see the "latest" bill card
    And I click on the > icon of the "latest" bill card
    And click on accept it in The Cookie permission message
    And Enter Username And Password
    And Chose Login Preference And Click Ok All Done
    Then I should see the latest Bill Reinvent journey is open
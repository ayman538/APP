Feature: Billing Tutorial for fresh install user

  Background: OPEN TUTORIAL SCREEN
    Given I am MVA user and logged in using Soft Login
    And I close the tutorial if displayed
    And I should be navigated to dashboard
    When I navigate to the new billing dashboard

  @TC944540 @TC944542 @SoftLogin @Consumer @BillingRegression
  Scenario: Verify that the Billing tutorial is displayed and click on Continue CTA
    Then I should see billing tutorial Title
    Then I should see billing tutorial description
    Then I should see billing Tutorial Continue Cta
    When I click on billing Tutorial Continue Cta
    Then I should see the new billing dashboard




# This TCs not exist in teh regression suite and not tags exist on the scenarios
Feature: Billing Card


  Background: Start the billing dashboard
    Given I am MVA user and logged in using Soft Login
    And I close the tutorial if displayed
    And I should be navigated to dashboard
    And I navigate to the new billing dashboard
    And I close the billing tutorial if displayed
    And I should see the new billing dashboard

  @TC655079 @FullLogin @Billing @BillingRegression
  Scenario: Validate the Billing Title Card X CTA Functionality
    When Clicking on X CTA from the billing title card
    Then The user should land on the dashboard

  @TC655072 @SoftLogin @Billing @BillingRegression
  Scenario: Validate the Billing Title Card Existence
    Then The billing Title Card should be existed with X CTA

  @TC_1932227 @Service_User
  Scenario: Test Case 1932227: 1876220.02.P1_Check the existence of Billing graph while opening Native Billing screen using a FL Service User with one NA value or more in the response
    Then I should NOT see Bill graph as a service user
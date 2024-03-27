@Synthetics
Feature: Synthetics

  Background:
    Given I am prod user and logged in using UFL
    And Validate Dashboard displayed

  @Discover @DRIVER @MPS @WIFI
  Scenario: Discover
    Then Validate Discover Offers

  @Veryme
  Scenario: Veryme
    Then Check VeryMe View All CTA

  @Tobi @MPS @WIFI
  Scenario: Tobi
    When I navigate to TOBi and validate it is opened then close it


  @C2U
  Scenario: C2U
    When I navigate to plan tab from Dashboard
    And I click on see plans button
    When the user selects a specific plan
    Then the user redirected to the new plan page
    When Scroll Down till the end of the page
    When the user toggles terms and conditions confirmation
    And the user clicks on Continue CTA
    Then the user redirected to Checkout modal

  @Billing
  Scenario: Billing and Usage
    When I navigate to the new billing dashboard
    Then I navigate to normal billing
    #And I close the billing tutorial if displayed
    #Then I should see the new billing dashboard

  @Sub-Switch
  Scenario: Sub-Switch
    When I click on my account without login
    Then I navigate to child

  @Top_up
  Scenario: Top up
    Then I navigate to Topup screen

  @Tariff_Migration  @ChangeYouPlan
  Scenario: Tariff Migration
    Given I navigate to plan tab from Dashboard
    Then user clicks on Change your Plan
    Then Change your Plan is opened


  @Upgrade
    Scenario: Upgrade Now
      When I navigate to plan tab from Dashboard
      And I click on Upgrade Now
      And I click on Upgrade only CTA in popup
      And click on accept it in The Cookie permission message
      Then Validate Upgrade now SSO is opened

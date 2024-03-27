@3G @RedHybrid @LOGIN
Feature: Removing Payment Card

  Background:
    Given I am MVA user and logged in using Soft Login
    When  I should be navigated to dashboard
    And   I navigate to payment tray from Dashboard
    And   I am MVA user and logged in using full login with user name and password
    Then  I add new payment if no payment method exists

  @TC_519853  @Regression_Active_Payment
  Scenario: 487760.1-P1.Check UI of Add payment method screen in case of a payment card is already added_UI
    Then I should be navigated to payment method


  Scenario: 487760.2-P1.Check app behavior when clicking on "Edit" CTA in "Add payment method" screen_Functional
    When I click on edit CTA in payment method
    Then I should be navigated to edit payment method


  Scenario: 487760.5-P1.Check app behavior when clicking on Cancel CTA in Confirmation popup_Functional
    Given I click on edit CTA in payment method
    When  I click on remove CTA in payment method
    And   I click on cancel CTA in confirmation popup in payment method
    Then  I should be navigated to edit payment method


  Scenario: 487760.6-P1.Check app behavior when clicking on Cancel CTA in "Add payment method" screen_Functional
    Given I click on edit CTA in payment method
    When  I click on cancel CTA in payment method
    Then  I should be navigated to payment method


  Scenario: 487760.7-P2. Check app behavior when clicking on "X" icon in "Add payment method" screen_Functional
    Given I click on edit CTA in payment method
    When  I click on x CTA
    Then  I should be navigated to dashboard

  @TC_1318164 @Regression_Active_Payment
  Scenario: P1_validate that the user will see new copy when removing payment card
    Given I click on edit CTA in payment method
    When  I click on remove CTA in payment method
    Then  I should be navigated to remove payment method pop up

  @TC_1318165
  Scenario: 487760.4-P1.Check app behavior when clicking on Remove CTA in Confirmation popup_Functional
    Given I click on edit CTA in payment method
    When  I click on remove CTA in payment method
    And   I click on confirm remove CTA in pop up
    Then  I should be navigated to add payment method
    When  I navigate to plantab through deep link
    Then  I should be able to see disclaimer Mask card

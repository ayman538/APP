#@3G @RedHybrid
Feature: 544579 - Red Hybrid - Add new plan - Add a payment method overlay - no payment method already added

  Background: Launched app using RedHybrid user that has no added plan and no payment method added
    Given User full login

  @TC_634300
  Scenario: Check UI of "Add a payment method" overlay after tapping on Continue CTA  in "Add new plan" overlay_UI
    Given user is on dashboard
    When  I should see the no plan added card
    And   I click on tap here to select a plan
    And   I should be navigated to Add New Plan screen with default plan selected
    And   I clicks on Add New Plan screen Continue CTA
    And   call beginCardPayment MVAX API
    And   No payment method overlay appears
    Then  UI of the noPaymentMethod screen must be compatible with the response of beginCardPayment MVAX API

  @TC_634305
  Scenario: Check the MVAX API "beginCardPayment" response if the user have no plan and no payment method added_Functional
    Given user is on dashboard
    When  I should see the no plan added card
    And   I click on tap here to select a plan
    And   I should be navigated to Add New Plan screen with default plan selected
    And   I clicks on Add New Plan screen Continue CTA
    And   call beginCardPayment MVAX API
    And   No payment method overlay appears
    Then  beginCardPayment API response check in case no payment method added

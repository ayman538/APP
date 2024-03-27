@3G @RedHybrid
Feature: 632627 - Red Hybrid - Add new plan - Confirm your purchase - Cancelled/Failed Status

  Background: Launched app using RedHybrid user that has no added plan ,payment method added and user full logged in
    Given User full login
    When  user is on dashboard
    And   I should see the no plan added card
    And   I click on tap here to select a plan
    And   I should be navigated to Add New Plan screen with default plan selected
    Then  I clicks on Add New Plan screen Continue CTA

  @TC_652236
  Scenario: P1_Check App behavior in case the user clicks on "cancel CTA in the  "Payment method" overlay_Functional
    Given  I should be navigated to Payment Method screen
    When   User clicks on Cancel CTA
    And    I should be navigated to Add New Plan screen with default plan selected
    Then   Payment error for cancelled status should be retrieved


  @TC_652222
  Scenario: Check App behavior in case the authorization fails after clicking "continue" CTA in "Payment method" overlay_Functional
    Given  User in Payment method overlay
    When   user inserts "user" name and "234" cvv
    And    user clicks on Pay now CTA
    And    password screen appears
    And    user inserts invalid "pa" password of the card
    And    user clicks on submit
    And    invalid password text appears
    And    user inserts invalid "pa" password of the card
    And    user clicks on submit
    And    invalid password text appears
    And    user inserts invalid "pa" password of the card
    And    user clicks on submit
    Then   Payment error overlay should appear to the user with try again CTA

  @TC_652224
  Scenario: P1_Check App behavior in case the user clicks on "Try again" CTA in the "Payment
    Given  I should be navigated to Payment Method screen
    When   user inserts "user" name and "234" cvv
    And    user clicks on Pay now CTA
    And    password screen appears
    And    user inserts invalid "pa" password of the card
    And    user clicks on submit
    And    invalid password text appears
    And    user inserts invalid "pa" password of the card
    And    user clicks on submit
    And    invalid password text appears
    And    user inserts invalid "pa" password of the card
    And    user clicks on submit
    And    Payment error overlay should appear to the user with try again CTA
    And    User clicks on Try Again CTA
    Then   I should be navigated to Add New Plan screen with default plan selected

  @TC_652233
  Scenario: P1_Check App behavior in case the user clicks on dismissal X CTA in the Payment error overlay after the authorization fails_Functional
    Given  I should be navigated to Payment Method screen
    When   user inserts "user" name and "234" cvv
    And    user clicks on Pay now CTA
    And    password screen appears
    And    user inserts invalid "pa" password of the card
    And    user clicks on submit
    And    invalid password text appears
    And    user inserts invalid "pa" password of the card
    And    user clicks on submit
    And    invalid password text appears
    And    user inserts invalid "pa" password of the card
    And    user clicks on submit
    And    Payment error overlay should appear to the user with try again CTA
    And    User clicks on dismissal button
    Then   user is on dashboard


  @TC_652236
  Scenario: P1_Check the UI of the Payment error overlay when the authorization fails after clicking continue CTA in Payment method overlay_UI
    Given  I should be navigated to Payment Method screen
    When   user inserts "user" name and "234" cvv
    And    user clicks on Pay now CTA
    And    password screen appears
    And    user inserts invalid "pa" password of the card
    And    user clicks on submit
    And    invalid password text appears
    And    user inserts invalid "pa" password of the card
    And    user clicks on submit
    And    invalid password text appears
    And    user inserts invalid "pa" password of the card
    And    user clicks on submit
    Then   Payment error overlay should be visible and compatible with the response of the API
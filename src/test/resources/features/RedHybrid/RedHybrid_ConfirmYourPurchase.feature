@3G @RedHybrid
Feature: Confirm Your Purchase screen in case of adding a new plan

  Background:
    Given I am MVA user and logged in using full login with user name and password
    When I should be navigated to dashboard
    And  I should see the no plan added card
    And  I click on tap here to select a plan
    And  I should be navigated to Add New Plan screen with default plan selected
    And  I clicks on Add New Plan screen Continue CTA
    And  I should be navigated to Payment Method screen
    And  I inserts "234" cvv number of the payment card
    And  I clicks on Continue CTA in Payment Method screen


  @TC_946614 @TC_1030305 @TC_1290671 @TC_1290693 @SIT_Cycle_4
  Scenario: TC_946614: P1_Check UI of "Payment processing"overlay in Add new plan journey _UI
    And   I should be navigated to Payment Card PWD screen
    Given I inserts "Pa55w0rd" password of the card
    When  I clicks on submit CTA in Payment Card PWD screen
    And   I should be navigated to Confirm Purchase Screen
    And   I should see that Pay Securely CTA is enabled
    And   I clicks on Pay Securely CTA
    And   I should be able to see Processing screen
    And I should validate the UI of confirmation screen of "Add a new plan"
    And   I clicks on Continue CTA
    Then  I should be navigated to dashboard
    And   I should see the Mask over the Dashboard tile


  @TC_650390
  Scenario: TC_650390: P1_Check App behavior in case of tapping on Continue CTA in "Payment method" overlay_Functional
    Then I should be navigated to Confirm Purchase Screen


  @TC_650393
  Scenario: TC_650393 : P1_Check App behavior when the user toggles ON the Terms and Conditions in "Confirm your purchase" overlay_Functional
    Given I should be navigated to Confirm Purchase Screen
    Then  I should see that Pay Securely CTA is enabled












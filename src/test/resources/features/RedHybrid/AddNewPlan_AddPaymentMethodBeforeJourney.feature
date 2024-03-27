@REDHYBRID @3g

  Feature: Automation First || Red Hybrid - MVA - Plan Management - Add new Plan and View Plan
    Background:
      Given I am MVA user and logged in using Soft Login
      Given I should be navigated to dashboard
      When  I should see the no plan added card
      And   I click on tap here to select a plan


      @SIT_Cycle_4 @TC_1030245 @TC_678306 @TC_678345 @TC_678338 @TC_1359349
      Scenario:P1_Check the overlay of "Add a new plan" after tapping on "Tap here to select a plan" card  _FUNC
        Then I should be navigated to an overlay to 'Add a new payment method' while trying to 'add-plan'
        And Clicked on a add new card CTA
        And I am MVA user and logged in using full login with user name and password
        Then user should redirected to Payment full flow
        When User clicked on X CTA
        Then I should be navigated to dashboard


    @TC_678348
    Scenario: Check App's behavior when tapping on Add new plan card after adding payment card
      Then User should be directed to Add Flexi plan screen
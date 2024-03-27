@REDHYBRID  @ActivePlan  @SIT_CYCLE2 @3G
Feature: RedHybrid PaymentReminder Overlay

  Background:user has active plan and no payment card added

    Given I am MVA user and logged in using Soft Login

  @TC_594911  @About_To_Expire_User
  Scenario: check App behavior for Red Hybrid user that his plan renews in 14 days or less days and has not added a Payment card _FUNC
    When wait for one second and half
    Then check Reminder Overlay UI

  @TC_594916
  Scenario: check behavior of "X" CTA in the Add Payment Method Reminder Overlay _FUNC
    When I close the app and relaunch it again
    And  click On Close Button
    Then I should be navigated to dashboard

  @TC_594914
  Scenario: check behavior of "Add payment card" CTA in the Add Payment Method Reminder Overlay _FUNC
    When I close the app and relaunch it again
    And wait for one second and half
    And click On Add Payment CTA
    And click on accept it in The Cookie permission message
    And Enter Username And Password
    And Chose Login Preference And Click Ok All Done
    Then Add Payment drawer is displayed
    And Dismiss add payment
    Then I should be navigated to dashboard

  @TC_594915
  Scenario: check behavior of "Return to My Vodafone" CTA in the Add Payment Method Reminder Overlay _FUNC
    When I close the app and relaunch it again
    And wait for one second and half
    And Click on back to my vodafone CTA
    Then I should be navigated to dashboard

  @TC_651722  @HasPaymentCardAdded
  Scenario: check App behavior when Red Hybrid user has active plan delete the Added payment card after adding it in the next visit_FUNC
    Given I navigate to payment tray from Dashboard
    Given Proceed in login flow
    When Delete Payment Card
    Then Add Payment drawer is displayed
    And Dismiss add payment
    Then I should be navigated to dashboard
    And I close the app and relaunch it again
    Then Payment Overlay Is Displayed


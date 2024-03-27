@3G @REDHYBRID  @ActivePlan  @SIT_CYCLE2  @About_To_Expire_User_with_Auto_Renew_Off
Feature: Feature 337887: Red Hybrid - MVA - Dashboard Common Items

  Background:red hybrid user with Active plan [about to expire in <7 days] and auto renew toggle is switched OFF

    Given I am MVA user and logged in using Soft Login

@TC_595487  @TC_595491
  Scenario: Check that Auto-renew Overlay is displayed when the turning it OFF and the plan will expire in 7 days or less_Functional
    When wait for one second and half
    Then check Auto renew Overlay UI
    And click On Turn on CTA
    Then Plan tab Is Displayed
    Then user closes the subsoverlay
    Then I should be navigated to dashboard

@TC_595876
  Scenario: Check App's behavior when tapping on X button in Overlay_Functional
    When I close the app and relaunch it again
    And  click On Close Button
    Then I should be navigated to dashboard


@TC_595492
  Scenario: Check App's behavior when the user selects "Return to my Vodafone" CTA_Functional
    When I close the app and relaunch it again
    And wait for one second and half
    And Click on back to my vodafone CTA
    Then I should be navigated to dashboard




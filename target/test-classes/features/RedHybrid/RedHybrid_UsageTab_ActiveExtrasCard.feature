@REDHYBRID @3G @SIT_CYCLE1 @ACTIVE_PLAN @ACTIVE_EXTRAS

  Feature: Red Hybrid - MVA - Subscriptions Overlay


    Background:
      Given I am MVA user and logged in using Soft Login
      And user dismiss the add payment method overlay
      When I navigate to subscriptions overlay
      And I navigate to usage tab from subscriptions overlay



   @TC_696273 @TC_716323 @TC_716324
    Scenario: Check the content of Active extras card for Red Hybrid user has active Extras
      Then Validate content of Active Extras Card for user that has active Extras



   @TC_697127
    Scenario: Check that Add Extras CTA is removed for Red Hybrid User has Active Extras
      Then Validate that Add Extras CTA is removed

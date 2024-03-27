@REDHYBRID @SIT_CYCLE1 @ACTIVE_PLAN

Feature: RedHybrid SubsOverlay Feature

  Background: RedHybrid SubsOverlay
    Given I am MVA user and logged in using Soft Login
    And user dismiss the add payment method overlay
    And Click On Any Tile

    @TC_567377
    Scenario: Test Case 567377: Check the header of Subscriptions overlay for RedHybrid user_UI
      Then Validate SubsOverlay UI

    @TC_567376
    Scenario: Test Case 567376: Check the tabs of Subscriptions overlay for RedHybrid user_FUNC
      Then Plan Usage Extras Tabs Are Displayed

    Scenario: Check RedHybrid SubsOverlay After App SoftClose
      When App SoftClose Then Relaunch it
      And user dismiss the add payment method overlay
      And Click On Any Tile
      Then Validate SubsOverlay UI

   @TC_567378
    Scenario: Test Case 567378: Check behavior of "X" CTA in the Subscriptions overlay header for RedHybrid user_FUNC
      When Click On X Icon
      Then I should be navigated to dashboard
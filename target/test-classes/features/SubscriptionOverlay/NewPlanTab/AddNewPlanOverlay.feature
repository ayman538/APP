@3G
Feature: Add New Plan Overlay
  Background:


    @594241
    Scenario: Check the UI of "Add a new plan overlay" after tapping on Tap here to select a plan card
      Given I am a Red Hybrid user And Skip Login
      And   I click on tap here to select a plan
      Then Add a new plan overlay should be displayed with correct components order

  @594265
    Scenario: Check App behavior in case of tapping on "View plan details" CTA in Add a new plan
    Given I am a Red Hybrid user And Skip Login
    And I click on tap here to select a plan
    Then Click on View plan details CTA


@REDHYBRID @3G
Feature: RedHybrid - Stay on My Plan

  Background: Red Hybrid user with active plan and has a queued change next plan request [teal card appears in plan tab]
    Given I am MVA user and logged in using Soft Login
    When  I should be navigated to dashboard
    And   user click on plan tile
    And   I am a redhybrid user who checks that teal card appeared successfully
    And   I should click on Stay on my plan CTA in the teal card
    Then  I am MVA user and logged in using full login with user name and password


  @TC_820774 @TC_820839
  Scenario: Clicking on Stay on my plan CTA from teal card while not logged-in user and verifying content
    And I should navigate to Stay on my plan overlay


  @TC_820840  @TC_820841
  Scenario: Clicking on No Thanks CTA and "X" CTA from StayOnMyPlanOrNot Overlay
    Given I should navigate to Stay on my plan overlay
    When  I should click on No thanks CTA
    Then  Plan tab Is Displayed
    Then  I should click on Stay on my plan CTA in the teal card
    When  I click on x CTA
    Then  Plan tab Is Displayed


  @TC_820868 @TC_820869 @TC_820939 @TC_999506  @TC_999509  @ChangePlanRequestReflectedTealCardAppears
  Scenario: Clicking on stay on current plan CTA from StayOnMyPlanOrNot tray and verifying content
    Given I should navigate to Stay on my plan overlay
    When  I should click on Stay on my plan CTA in the Overlay
    And   I should be able to see Processing screen
    Then  I should navigate to Stay on current plan confirmation overlay
    When  I clicks on Continue CTA
    Then  I Should see the mask over Manage your plan card
    When  user closes the subsoverlay
    Then  I should be navigated to dashboard
    When  User clicked on change next plan in quick links menu
    Then  I should see the screen that notify the user that a request is being processed
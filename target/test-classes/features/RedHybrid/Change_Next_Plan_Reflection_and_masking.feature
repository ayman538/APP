@WIFI @RedHybrid

Feature: 544820 - Red Hybrid - Change Next Plan - Reflection and masking of the change next plan action

  Background: Launch the app using redHybrid user that has active plan and has payment method added
    Given I am MVA user and upfront logged in using user name and password
    And   I should be navigated to dashboard
    And   User clicked on change next plan in quick links menu
    And   user selects a plan
    And   user clicks Continue CTA
    And   Change Plan Overlay should appear
    And   I Click on Confirm next plan CTA
    Then I should validate the UI of confirmation screen of "change plan"
    When  user clicks Continue CTA
    Then  I should see Plan tab

  @TC_816574
  Scenario:Check "Continue" CTA navigated to the plan tab for users changing their next plan
    Then I Should see the mask over Manage your plan card

  @OnePlatfrom_Tutorial
  @TC_816579
  Scenario: check behavior when try to change next plan from quick links after the mask cover the "Manage your plan" card
    Then I Should see the mask over Manage your plan card
    When user closes the subsoverlay
    Then I should be navigated to dashboard
    When User clicked on change next plan in quick links menu
    Then I should see the screen that notify the user that a request is being processed
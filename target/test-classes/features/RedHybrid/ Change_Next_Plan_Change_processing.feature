@WIFI @RedHybrid
Feature: 651956 - Red Hybrid - Change Next Plan - Change processing

  Background: Launch the app using redHybrid user that has active plan and payment method added and auto renew toggle is ON
    Given I am MVA user and upfront logged in using user name and password


  @TC_815788 @TC_815791
  Scenario:Check Change processing behavior when user initiate the journey from quick links _FUNC
    When User clicked on change next plan in quick links menu
    And user selects a plan
    And user clicks Continue CTA
    And Change Plan Overlay should appear
    When I Click on Confirm next plan CTA
    Then I should able to see Change plan processing
    Then I should able to see Change plan Notification screen
    Then I should validate the UI of confirmation screen of "change plan"


  @OnePlatfrom_Tutorial
  @TC_815793
  Scenario:Check behavior when user dismiss the notification overlay when initiate the journey from quick links _FUNC
    When User clicked on change next plan in quick links menu
    And user selects a plan
    And user clicks Continue CTA
    And Change Plan Overlay should appear
    When I Click on Confirm next plan CTA
    Then I should able to see Change plan processing
    Then I should able to see Change plan Notification screen
    When I Click on X CTA for redHybrid
    Then I should able to see quick links

  @OnePlatfrom_Tutorial
  @TC_815794
  Scenario:Check behavior when user dismiss the notification overlay when initiate the journey from Plan tab_FUNC
    When RedHybrid Navigated to Plantab
    And user clicks on Change Plan CTA
    And user selects a plan
    And user clicks Continue CTA
    And Change Plan Overlay should appear
    When I Click on Confirm next plan CTA
    Then I should able to see Change plan processing
    Then I should able to see Change plan Notification screen
    When I Click on X CTA for redHybrid
    Then I should see Plan tab

@REDHYBRID @ChangeCardRequestReflectedTealCardAppears

Feature: Automation First || Red Hybrid -  MVA - Plan Management - Change Plan and Opting In/Opting Out

  Background:  User should has initiated a change next plan request and the request[Teal card] is reflected in plan tab
    Given I am MVA user and logged in using Soft Login
    And   user dismiss the add payment method overlay
    Given I should be navigated to dashboard
    And   RedHybrid Navigated to Plantab


  @TC_820629  @ChangePlanRequestReflectedTealCardAppears
  Scenario: P1_Check the behavior when the request of changing next plan is reflected in the plan tab
    Then I am a redhybrid user who checks that teal card appeared successfully


  @TC_820634
  Scenario: P2_Check the behavior when the user try to initiate another request to change next plan
    And  I am a redhybrid user who checks that teal card appeared successfully
    Then user clicks on Change Plan CTA
    And  user should be directed to Change_Next_Plan_overlay


  @TC_820635
  Scenario: P2_Check the behavior when the user try to turn off auto renew toggle after the request of changing next plan is reflected
    And  I am a redhybrid user who checks that teal card appeared successfully
    And  I am a redhybrid user who turns off the auto renew toggle
    And I am MVA user and logged in using full login with user name and password
    Then I am a redhybrid user validates content of Plan Tab
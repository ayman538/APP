@3G @RedHybrid
Feature: 544953 - Red Hybrid - Change Next Plan - Change Next Plan overlay

  Background: Launch the app using redHybrid user that has active plan and has payment method added and user is soft login
    Given  I am MVA user and logged in using Soft Login

  @TC_675911
  Scenario: Check App behavior in case of tapping on "Change Plan" CTA in SubsOverlay "Plan" tab_Functional
    Given  I should be navigated to dashboard
    When   RedHybrid Navigated to Plantab
    And    user clicks on Change Plan CTA
    Then   user should be directed to Change_Next_Plan_overlay

  @TC_676264
  Scenario: Check App behavior in case of selecting a plan in "Change Next Plan" overlay_Functional
    Given  I should be navigated to dashboard
    When   RedHybrid Navigated to Plantab
    And    user clicks on Change Plan CTA
    And    user should be directed to Change_Next_Plan_overlay
    And    user selects a plan
    Then   Continue button should not be dimmed

  @TC_675913   @TC_1017998
  Scenario: Check UI of Change Next Plan overlay after tapping on "Change Plan" CTA in SubsOverlay "Plan" tab_UI
    Given  I should be navigated to dashboard
    When   RedHybrid Navigated to Plantab
    And    user clicks on Change Plan CTA
    And    user should be directed to Change_Next_Plan_overlay
    Then   Change_Next_Plan_overlay UI should be respected
    And   I should validate the UI of overlay if plans have promotion or not

  @TC_1017997 @TC_1017999
  Scenario: Check UI of Change Next Plan overlay after tapping on "Change next plan" CTA in quick links
    Given  I should be navigated to dashboard
    When   User clicked on change next plan in quick links menu
    And    user should be directed to Change_Next_Plan_overlay
    Then   Change_Next_Plan_overlay UI should be respected
    And   I should validate the UI of overlay if plans have promotion or not
    Then I should click on Promos terms apply link

  @TC_922944  @ChangePlanRequestReflectedTealCardAppears
  Scenario: check the  Manage plan Tile in Dashboard for a user who has a queued plan  as plan API response
    When  I should be navigated to dashboard
    Then I should able to see that reflected plan with message on the Plan Tile


   @TC_1049817 @POST_BETA
  Scenario: Check "Continue" CTA behavior when the user chose "Change plan for the Next month" in the "Change Plan" overlay _Functional
    Given  I should be navigated to dashboard
    When  RedHybrid Navigated to Plantab
    And    user clicks on Change Plan CTA
    And    I should navigate to Change plan overlay
    Then   I Should Validate Change plan overlay UI
    And    I Select Change plan for next month Card and click continue CTA
    And    user should be directed to Change_Next_Plan_overlay


  @TC_1049816 @POST_BETA
  Scenario: Check "Continue" CTA behavior when the user chose "Renew Plan early" from the "Change Plan" overlay _Functional
    Given  I should be navigated to dashboard
    When   RedHybrid Navigated to Plantab
    And    user clicks on Change Plan CTA
    And    I should navigate to Change plan overlay
    Then   I Should Validate Change plan overlay UI
    And    I Select Renew plan early Card and click continue CTA
    Then   I should be directed to Renew_plan_early_overlay
@4G @REDHYBRID  @ActivePlan  @SIT_CYCLE2 @Regression_Active_Payment
Feature: RedHybrid Quick Links Menu

  Background: Launch the app using redHybrid user that has active plan
    Given I am MVA user and logged in using Soft Login
    When user dismiss the add payment method overlay
    Then I should be navigated to dashboard

  @TC_607674
  Scenario: Check that quick links menu is displayed_FUN
    Then I expect to see a new section displayed under the discover carousel as Quick Links

  @TC_607677 @LOGIN
  Scenario: Check the behavior when clicking on quick links_FUN
    Given I expect to see a new section displayed under the discover carousel as Quick Links
    When scroll to quick links
    And  user clicks on Change plan for next month from quick links
    Then  user should be directed to Change_Next_Plan_overlay
    When  User clicked on X CTA
    And   I click on the Manage payments item
    And  I am MVA user and logged in using full login with user name and password
    Then  I expect to be redirected to the payments flow
    When  User clicked on X CTA


    ####### copy change for quicklinks
  @TC_788315
  Scenario:Check the UI of the quick links for RedHybrid users that have active plan to change plan journey_UI
    Given scroll to quick links
    Then change plan quick link text should comply with the UI on figma

  @TC_788316 @BETA
  Scenario:Check the UI of the quick links for RedHybrid users  that have active plan  to manage payments_UI
    Given scroll to quick links
    Then manage Payment quick link text should comply with the UI on figma "Beta"

  @TC_1030358  @POST_BETA
  Scenario: Check the UI of Renew early at quick links for RedHybrid users that have active plan _UI
    Given scroll to quick links
    Then Renew plan Early quick link text should comply with the UI on figma

  @TC_1030362 @POST_BETA @LOGIN
  Scenario: Check the behavior when click on quick links items after adding renew early E2E_fun
    When scroll to quick links
    And  user clicks on Change plan for next month from quick links
    Then  user should be directed to Change_Next_Plan_overlay
    When  User clicked on X CTA
    And   I click on the Manage payments item
    And  I am MVA user and logged in using full login with user name and password
    Then  I expect to be redirected to the payments flow
    When  User clicked on X CTA
    And  scroll to quick links
    Then  I click on Renew Early from quick links
    Then  I should be directed to Renew_plan_early_overlay


  @TC_1574773 @POST_BETA
  Scenario:Check the UI of the quick links for RedHybrid users  that have active plan  to manage payments_UI PostBeta
    Given scroll to quick links
    Then manage Payment quick link text should comply with the UI on figma "PostBeta"
@REDHYBRID  @ActivePlan
Feature: Feature 337887: Red Hybrid - Auto renew - Tooltips

  Background: Launch the app using redHybrid user that has active plan and has payment method added and user is soft login
    Given  I am MVA user and logged in using Soft Login

@REGRESSION @TC_1140051  @TC_1140058  @TC_1140454
  Scenario: Check AutoRenew Tooltip
    Given  I should be navigated to dashboard
    When   Navigate to redhybrid plan
    And Validate and Click on i ICon
    Then AutoRenew Tip will displayed successfully
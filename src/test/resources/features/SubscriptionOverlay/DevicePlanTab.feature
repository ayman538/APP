@3G @BINGO
Feature:DevicePlanTab

  Background:
  Given I am MVA user and logged in using Soft Login
    When I Dismiss The First Tip

  @TC_601899 @TC_191966 @BINGO @REGRESSION
  Scenario: Test Case 601899: P1_Check Device plan tab when user has one loan_UI
    Given Navigate to Device plan tab
    Then check Device plan card
    Then Check Device plan CTAs
    And Check Make a Payment CTA has different color

  @TC_601925 @TC_248464 @BINGO @REGRESSION
  Scenario: Test Case 601925: P1 232566.04_Check that after tapping on Total Care Warranty in includes it will open Total Care Warranty screen_UI
    Given Navigate to Device plan tab
    Then Check Total Care Warranty in Includes section
    And Check Total Care Warranty chevron

  @TC_634662 @TC_505620 @BINGO @REGRESSION
  Scenario: Test Case 634662: P1-Check Battery refresh for Bingo in device plan_FUN
    Given Navigate to Device plan tab
    Then Check Battery Refresh in Includes section
    And Check Battery Refresh chevron

  @TC_1165910 @TC_1225977 @TC_1227134 @TC_1227135 @TC_1227138 @TC_1227150 @TC_1227151 #10.43
  Scenario: P1-Check Manage device plans CTA and tray list in each card in device plan_FUN
    Given I am MVA user and logged in using full login with user name and password
    When Navigate to Device plan tab
    Then I Check Manage Device Plan CTA
    Then I Check New Device Plan Tray List
    Then I Check 'Manage Payment Method' URL and description
    And I Check 'Make a payment' URL and description
    And I Check 'Payment History' URL and description
    And I Check 'Important Documents' URL and description
    And I Click on Cancel button

  @TC_1227410 @TC_1227411 @REGRESSION @1227408 @BINGO
  Scenario: Check behavior when Bingo user clicks on "What is a Device Plan?" link in device plan
    When I click on device plan tile
    And User clicks on 'What is a Device Plan?' link
    And What is a Device Plan? new copy overlay screen should be displayed
    And User clicks on Ok for device plan, thanks CTA
    Then User should be navigated back to Device Plan tab
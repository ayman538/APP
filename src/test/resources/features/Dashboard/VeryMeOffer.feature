Feature: VeryMe offers
  Background:
    Given I am MVA user and logged in using Soft Login

  @SANITY @REGRESSION @MPS @TC_601792 @TC_90858 @CONSUMER @3G
  Scenario: Test Case 601792: P1- Check app behavior when open the app with PAYM eligible user for VeryMe offers _Functional
    Given Dashboard loaded and scroll to VeryMe offers
    Then Check VeryMe title
    And Check VeryMe View All CTA

  @SANITY @REGRESSION @MPS @TC_601797 @TC_91588 @CONSUMER @3G
  Scenario: Test Case 601797: P1 - Check Each Very Me Rewards displayed as UID_UI
    Given Dashboard loaded and scroll to VeryMe offers
    Then Check VeryMe UI

  @SANITY @REGRESSION @TC_601793 @TC_90861 @MBB @3G
  Scenario: Test Case 601793: P1 - Check app behavior when open the app with MBB not eligible user for VeryMe offers _Functional
    Then Scroll down and check VeryMe does not appear for child users

  @TC_601794 @SMB @3G @Child @Login
  Scenario: Check that VeryMe is displayed for root subscription only
    Given I am MVA user and logged in using full login with user name and password
    When I navigate to my account from dashboard tray
    And I navigate to sub switch to "MBB" Subscription
    Then Scroll down and check VeryMe does not appear for child users

  @TC_1049049 @MPS @3G @REGRESSION
  Scenario: Check that very me offer will open from deep link
    Given HardClose the App
    And I close the tutorial if displayed
    Then Validate VeryMe deep link




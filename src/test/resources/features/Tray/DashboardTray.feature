
Feature:DashboardTray

  Background: Initialize Dashboard Tray

  @SANITY @TC_601795 @TC_601796 @3G @CONSUMER @REGRESSION @MPS @PAYG @SOLETRADER @TC_601837
  Scenario: Validate My Account
    Given I am MVA user and logged in using Soft Login
    Then Validate MyAccount item in dashboard tray
    Then Validate Rewards and very me item in dashboard tray
    Then Validate Billing and top up item in dashboard tray
    Then Validate Settings item in dashboard tray
    Then I navigate to TOBi and validate it is opened then close it

  @TC_634682 @3G @CONSUMER @REGRESSION @MPS
  Scenario: Check that TOBi opens and respond successfully from dashboard Tray
    Given I am MVA user and logged in using Soft Login
    When Open Tobi and Send "Hello" Message
    Then TOBi should respond With "I’m here to answer questions about Vodafone"

  @TC_727735 @3G @LOGIN @REGRESSION @MPS @SubswitchToConsumer
  Scenario: Check Tobi journey displayed for child user _function
    Given Click on Login CTA
    Given Preform FL Using Login Preference Method "un"
    When I navigate to my account from dashboard tray
    And I navigate to sub switch to SubscriptionType "MPS" and Segment "CONSUMER"
    Then  I navigate to TOBi and validate it is opened then close it
    When I close the app and relaunch it again
    Then I close the tutorial if displayed
    And Click on My Account
    Then Preform Returning User Using UN and Password

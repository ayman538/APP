
Feature:My Account drawer

  Background: Initialize My Account drawer
    Given Click on Login CTA
    Given Preform FL Using Login Preference Method "un"
    And I navigate to my account from dashboard tray

  @3G @CONSUMER @LOGIN @REGRESSION @MPS @TC_634273 @MultipleAccount @Special
  Scenario: TC02_ValidateMultipleAccountsUsers
    Then Validate MyAccount for Multiple Accounts Users


  @3G @CONSUMER @LOGIN @MPS @634271 @Special @SubswitchToPAYG
  Scenario: Check app behavior when switch to PayG user
    Then I navigate to sub switch to SubscriptionType "MPS" and Segment "PREPAY"



  @REGRESSION @3G @634272 @CONSUMER @LOGIN @MPS
  Scenario: Check app behavior when switch to another subscription and hard close the app
    Given Click on Login CTA
    Given Preform FL Using Login Preference Method "un"
    Then I navigate to sub switch to SubscriptionType "MPS" and Segment "CONSUMER"
    Then I close the app and relaunch it again
    Then I close the tutorial if displayed
    Then Root account Dashboard displayed

  @MultipleAccount @LOGIN @TC_1048394 @TC_1048395 @TC_1048394 @TC_1048406 @TC_1048405 @TC_1048404 @1048397 @Special @REGRESSION @MPS
  Scenario: Validate My Account New Implementation
    Then I validate root account subscriptions
    When I login using multiple accounts user
    Then I Should validate all accounts and their Subscriptions


    #  @NOT_10_18
#  Scenario: TC01_ValidateMyAccountDrawer
#    Then Validate MyAccount Drawer
#
#  @NOT_10_18
#  Scenario: TC03_SwitchToSubscription
#    Then Validate Switching to another Subscription1
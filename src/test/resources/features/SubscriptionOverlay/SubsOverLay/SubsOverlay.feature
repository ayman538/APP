@3G
Feature: Subscription overlay for different users

  @SANITY @REGRESSION @PAYG @FLN @TC_601818 @TC_601815 @TC_601814 @TC_95698 @TC_225891 @TC_95691 @TC_225890 @TC_95796 @TC_225894 @CONSUMER @PREPAY
  Scenario: P1 - Check subscription overlay header view for PayM,PayG,FLN and BB users in subscription overlay screen_UI
    Given I am MVA user and logged in using Soft Login
    Given Navigate to SubsOverlay
    Then Validate SubsOverlay header

  @REGRESSION @BB @SubswitchToHBB @LOGIN @Special @TC_601818
  Scenario: Check BB subsoverlay
    Given User full login
    Given Click on My account tray
    And I navigate to sub switch to SubscriptionType "BB" and Segment "CONSUMER"
    Given Navigate to SubsOverlay
    Then Validate SubsOverlay header
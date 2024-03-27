#TODO: revisit this feature when the running user not has the child that switch to, it should throw skip exception to ignore this scenario
Feature: RelocateInboxAndRemoveGreeting

  @TC_716807 @TC_716806 @TC_716805 @TC_730726 @TC_730727 @3G @MPS
  Scenario: TC01_Validate Inbox Removal and User Greeting Removal for PayM/PayG/SOHO root users
    Then Validate User Greeting is removed from the top of the dashboard
    Then Validate that Inbox is relocated to the top of the dashboard

  @TC_716298 @3G @REGRESSION @MPS
  Scenario: 640781.01_P1_Check that the inbox is displayed in the top of the dashboard for PayM user_Function
    Then Validate that Inbox is relocated to the top of the dashboard
    Then Open the messages box Notifications on the dashboard


  @TC_716304 @LOGIN @3G @REGRESSION @MPS
  Scenario: TC01_Validate Inbox Relocation and User Greeting Removal for PayM child user
    Given Click on Login CTA
    Given Preform FL Using Login Preference Method "un"
    When I navigate to my account from dashboard tray
    And  I navigate to sub switch to SubscriptionType "MPS" and Segment "CONSUMER"
    Then Validate User Greeting is removed from the top of the dashboard
    Then Validate that Inbox does not exist at the top of the dashboard
    Then I close the app and relaunch it again
    Then I close the tutorial if displayed
    And Click on My Account
    Then Preform Returning User Using UN and Password


  @TC_716815 @TC_716814 @TC_716308 @TC_716307 @LOGIN
  Scenario: TC01_Validate Inbox Relocation and User Greeting Removal for FLN/BB child user
    Given I am MVA user and logged in using full login with user name and password
    And  SwitchToSubscriptionFLN
    Then Validate User Greeting is removed from the top of the dashboard
    Then Validate that Inbox does not exist at the top of the dashboard
    When The user switch to subscription HBB
    Then Validate User Greeting is removed from the top of the dashboard
    Then Validate that Inbox does not exist at the top of the dashboard

  @TC_716816 @TC_716796 @LOGIN
  Scenario: TC01_Validate Inbox Removal and User Greeting Removal for PayG child user
    Given I am MVA user and logged in using full login with user name and password
    And  I navigate to PayG child
    Then Validate User Greeting is removed from the top of the dashboard
    Then Validate that Inbox does not exist at the top of the dashboard





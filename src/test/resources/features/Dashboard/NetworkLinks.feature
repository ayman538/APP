#@3G @CONSUMER @SMB @SOLETRADER @PREPAY @SoftLogin @RedHybrid @ACTIVE_PLAN @Card_Added
Feature: Network links

  Background: Init Network links - For RedHybrid user the user should have active plan and card added
    Given I am MVA user and logged in using Soft Login


  @SANITY @REGRESSION @MPS @TC_91692 @TC_601801 @TC_595394 @3G
  Scenario: P1 - Check Assistance and network section ordering _Functional
    Given Dashboard loaded and Network links retrieved successfully
    Then Check Network title text
    Then Check Network links ordering and texts

  @SANITY @REGRESSION @MPS @TC_91750 @TC_601803 @TC_225868 @TC_138066 @TC_226009 @TC_601871 @TC_595395 @3G
  Scenario: P1 - Check when tap on each item, it redirect the user to the correct screen _Functional
    Given Dashboard loaded and Network links retrieved successfully
    Then Check Network links CTAs

  @TC_602018 @REGRESSION @BB @LOGIN @Special @SubswitchToHBB
  Scenario:Check HBB Service Test CTA should open diagnostic test URL in app web view
    When I am MVA user and logged in using full login with user name and password
    And  I navigate to sub switch to "BB" Subscription
    When I Scroll Down and click on Broad Band Service Test
    Then I should see the login screen displayed in custom tab

  @945249 @REGRESSION @BB @LOGIN @Special @SubswitchToHBB
  Scenario:Check the links of "Your Network" section for HBB user
    When I am MVA user and logged in using full login with user name and password
    And I navigate to sub switch to SubscriptionType "BB" and Segment "CONSUMER"
    Given Dashboard loaded and Network links retrieved successfully
    Then Check Network links CTAs



  ###

  #Scenario: TC03_Validate Data WIFI is Displayed
   # Then Validate Data WIFI is Displayed

  #Scenario: TC04_Validate Data WIFI is opened successfully
   # Then Validate Data WIFI is opened successfully




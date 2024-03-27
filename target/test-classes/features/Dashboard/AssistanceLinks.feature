@3G @CONSUMER
Feature: Assistance links

  Background:
    Given I am MVA user and logged in using Soft Login
    When Dashboard loaded and assistance links retrieved successfully

  @SANITY @TC_91692 @TC_601801 @TC_651923 @TC_651925 @TC_651927 @TC_651950 @TC_651953 @MPS @REGRESSION @PAYG @TC_651924
  Scenario: P1 - Check Assistance and network section ordering _Functional
    Then Check Assistance title text
    Then Check Assistance links ordering and texts

  @SANITY @TC_91728 @TC_601802 @TC_225867 @REGRESSION @MPS @3G
  Scenario:P1 - Check app behavior when there are more than five items _Functional
    Then Check only 5 links are displayed
    Then Check Assistance links ordering and texts

#ToDo: tha validation of opened pages need to be added
  @SANITY @TC_91750 @TC_601803 @TC_225868 @TC_138066 @TC_226009 @TC_601876 @TC_602016 @REGRESSION @SMB @MPS @TC_1077227 @PAYG
  Scenario: P1 - Check when tap on each item, it redirect the user to the correct screen _Functional
    Then Check Assistance links CTAs

  @REGRESSION @MPS @TC_651923
  Scenario: P1 - Check the Notification is removed from assistance links _Functional
    Then Check Notifications is removed from Assistance links

    # @TC_651950 require user with UFL and has FLN subscription ans also TC_651953 requires oneNumber
    @TC_651925 @TC_651927 @TC_651950 @TC_651953 @SMB @MPS
  Scenario: P1 - Check Assistance Links section ordering After Notification is removed _Functional
    Then Check Assistance title text
    Then Check Assistance links ordering After Notification is removed

  @TC_1038686 @SOLETRADER
  Scenario: P1 - Check TradeIn Link and Connect another device is removed from assistance link _Functional
    Then Validate Trade in and Connect another device links is removed from assistance link


  @RedHybrid
  @TC_595391
  Scenario: P1 - Check Assistance Links section there are less than three items
    Then Check Assistance title text
    Then Check Assistance links ordering and texts
    Then Check only 4 links are displayed

  @TC_634657 @REGRESSION @LOGIN @Special @SubswitchToConsumer
  Scenario: Check Battery refresh for Child in assistance links_FUN
    When I am MVA user and logged in using full login with user name and password
    And  I navigate to sub switch to SubscriptionType "MPS" and Segment "CONSUMER"
    And I Scroll Down to Assistance links
    Then I should see the Assistance Links for Child User

     @TC_602017 @3G @SMB @LOGIN
      Scenario: Check V Hub Advisory Journey open successfully with SMB User has child
      Given I am MVA user and logged in using full login with user name and password
       When I navigate to my account from dashboard tray
      Then I navigate to sub switch to SubscriptionType "MPS" and Segment "SMB"
      Then I Scroll Down to Assistance links
      Then I click on Free Business Support

      @TC_634656 @REGRESSION @3G @PAYG
        Scenario: Check Battery refresh for PayG in assistance links
        When I Scroll Down to Assistance links
        Then I should NOT see Battery Refresh for PayG user

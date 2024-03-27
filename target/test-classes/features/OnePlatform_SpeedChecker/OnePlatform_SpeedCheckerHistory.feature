Feature: Speed Checker History

  Background:
    Given I am MVA user and logged in using Soft Login
    And Click on Check data and WiFi Speed

  @3G @TC_634293 @SpeedChecker
  Scenario: Check Speed history screen hasn't any speed test done
    Given I click on speedHistory tab
    When I check speed history screen I shouldn't find any test history
    Then I shouldn't see any speed test result

  @TC_634290 @TC_634282 @TC_634294 @3G @SpeedChecker
  Scenario: Check speed History screen when user has previous speed test
    Given I click on Test network speed CTA
    And  I see the test done successfully
    When  I click on speedHistory tab
    Then I should see speed test result card


  @TC_722056 @TC_722081 @TC_722083
  Scenario: Check Delete Functionality when user Cancel delete all the previous speed checker Tests
    Given Speed History Card should be displayed
    When Click on Delete CTA button
    And Validate deleted appeared overlay
    Then Click on Cancel CTA on the appeared deleted overlay

  @TC_722056 @TC_722081 @TC_722082
  Scenario: Check Delete Functionality when user Confirm delete all previous speed checker Tests
    Given Speed History Card should be displayed
    When Click on Delete CTA button
    And Validate deleted appeared overlay
    Then Click on Confirm CTA on the appeared deleted overlay








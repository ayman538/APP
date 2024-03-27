@Yara
Feature: speedChecker onePlatform

  Background:
   Given  I am MVA user and logged in using Soft Login

  @SANITY @REGRESSION @3G @TC_611361 @SpeedChecker @MPS
  Scenario: Check speedchecker screen and functionality
    Given Click on Check data and WiFi Speed
    And user is in speed test tab in speed checker screen
    Then In speedTest Tab Network or WIFI ,MSISDN ,why this network? and icon Should be displayed
    Given I click on speedHistory tab
    Then I shouldn't see any speed test result
    Given I click on Test network speed CTA
    Then validate network speedchecker test results value
    And validate check again CTA is displayed
    When  I click on speedHistory tab
    Then I should see speed test result card

  @TC_612914 @REGRESSION @3G @MPS
  Scenario: Check Speed Checker Screen when Network Optimization toggle is OFF
    Given user is on privacy setting
    And Network Optimization toggle is OFF
    And I navigate back to the main dashboard
    When user navigate to speed checker and click on OK Proceed
    And I navigate back to the main dashboard
    And user is on privacy setting
    Then Network Optimization toggle is ON
    And I navigate back to the main dashboard
    Then click on test network speed button

      @3G @TC_610947 @TC_611378 @SpeedChecker
      Scenario: Check when click on Check data and wifi speed tab in dashboard_Functional
      Given Click on Check data and WiFi Speed
      Then   speedchecker screen title should be displayed

      @TC_611391 @WIFI @SpeedChecker
      Scenario: Check when test network speed when connected to WIFI_FUNC
      Given Click on Check data and WiFi Speed
      Given    user clicks on test network speed button
      Then     validate that network speed test ends successfully

      @TC_611392 @3G @SpeedChecker
      Scenario: Check when test network speed when connected to mobile data_FUNC
      Given Click on Check data and WiFi Speed
      Given user clicks on test network speed button
      Then  validate that network speed test ends successfully

      @TC_611466 @TC_611467 @TC_611468 @3G @SpeedChecker
      Scenario: Check speed test results screen_functional
      Given Click on Check data and WiFi Speed
      Given user clicks on test network speed button
      Then validate network speedchecker test results value
      And validate check again CTA is displayed

      @WIFI
      @TC_611530 @TC_682998
      Scenario: check More on data and wi-fi speed hyperlink in speed test results screen
      Given Click on Check data and WiFi Speed
      Given user clicks on test network speed button
      When Scroll to More on data and wifi Link
      And Validate More Data And Wifi Speed Page
      Then Close More Data And Wifi Speed Page

      @3G
      @TC_682997 @TC_682999
      Scenario: check More on data and wi-fi speed hyperlink in speed test results screen
      Given Click on Check data and WiFi Speed
      Given user clicks on test network speed button
      When Scroll to More on data and wifi Link
      And Validate More Data And Wifi Speed Page
      Then Close More Data And Wifi Speed Page

       @TC_611647 @3G
        Scenario: check the behavior when user clicks on why this network
        Given Click on Check data and WiFi Speed
        Given user is in speed test tab in speed checker screen
        And user should see why this network button
        When user should click on why this network button
        Then Validate network button tray

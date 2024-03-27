Feature: Previous Bills Card

  Background: Initialize The Billing Dashboard
    Given I am MVA user and logged in using Soft Login
    And I close the tutorial if displayed
    And I should be navigated to dashboard
    When I navigate to the new billing dashboard
    And I close the billing tutorial if displayed
    Then I should see the new billing dashboard
    And I Scroll Down To Previous Bill Card


  @TC920135 @SoftLogin @PreviousBillCard @Consumer @BillingRegression
  Scenario: Verify that the Previous Bill Card Is Displayed
    Then I Should Validate Previous Bill Card Content

  @TC920173 @SoftLogin @PreviousBillCard @Consumer @BillingRegression
  Scenario: I Should check the functionality of Load More CTA
    Then I Check Load More CTA Functionality

  @TC920176 @SoftLogin @PreviousBillCard @Consumer @BillingRegression
  Scenario: Validate Previous Bill Card Redirection to Reinvent Journey
    When I Click On Arrow Icon
    And click on accept it in The Cookie permission message
    And Enter Username And Password
    And Chose Login Preference And Click Ok All Done
    Then I Validate the Previous Bill Reinvent Journey is open

  @TC_610401 @PreviousBillCard @WIFI @MPS @LOGIN
  Scenario: Check the app behavior when returning UFL Consumer User access the PREVIOUS_EBILL journey
    Given I am MVA user and upfront logged in using PIN
    Then I should be navigated to dashboard
    Then I close the app and relaunch it again
    And I close the tutorial if displayed
    Then I should be navigated to dashboard
    And I navigate to the new billing dashboard
    And I close the billing tutorial if displayed
    And I should see the new billing dashboard
    And I Scroll Down To Previous Bill Card
    Then I Click On Arrow Icon
    Then PIN Screen Displayed
    Then Enter Valid PIN and Click on Continue
    Then I Validate the Previous Bill Reinvent Journey is open

  @TC_610402 @PreviousBillCard @REGRESSION @3G @SubswitchToHBB @LOGIN
  Scenario: Check the app behavior when FL Consumer Subscription user access the PREVIOUS_EBILL
    Given I am MVA user and logged in using full login with user name and password
    Then I should be navigated to dashboard
    And The user switch to subscription HBB
    And I should be navigated to dashboard
    Then I navigate to the new billing dashboard
    And I close the billing tutorial if displayed
    And I should see the new billing dashboard
    And I Scroll Down To Previous Bill Card
    Then I Click On Arrow Icon
    Then I Validate the Previous Bill Reinvent Journey is open

  @TC_610400 @PreviousBillCard @3G @MPS @LOGIN @iOSLoginMPS
    Scenario: Check the app behavior when returning Consumer User access the PREVIOUS_EBILL journey
    Given I am MVA user and logged in using Soft Login
    And I should be navigated to dashboard
    And I close the app and relaunch it again
    And I close the tutorial if displayed
    When  I navigate to the new billing dashboard
    And I close the billing tutorial if displayed
    And I should see the new billing dashboard
    And I Scroll Down To Previous Bill Card
    And I Click On Arrow Icon
    Then I am MVA user and logged in using full login with user name and password
    And I Validate the Previous Bill Reinvent Journey is open


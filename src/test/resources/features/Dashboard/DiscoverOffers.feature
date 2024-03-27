
Feature: Discover Offers
  Background: Init Discover offer
    Given I am MVA user and logged in using Soft Login

    #precondition user has less than 3 offers or not eligible for offers (Asserting default offer is displayed )
  @SANITY @TC_601804 @REGRESSION @MPS @3G
  Scenario: Validate Discover Offers Displayed
    Then Validate Discover Offers Displayed

    # has cordiant offer or not
  @SANITY @TC_601805 @REGRESSION @MPS @3G
  Scenario: Validate Discover Offers Is Opened in custom tab
    Then Open Default Discover offer
    Then Validate Default Discover Offers is Opened in the external browser successfully
  @TC_567569 @TC_567568
  Scenario: Check the availability of "View All" CTA on the dashboard  when the user has Less than or equal to 3 offers_FUN
    Then Validate Discover Offers View All CTA

  Scenario: Validate View All screen After tapping on View All CTA is Displayed
    Then Validate Discover Offers View All CTA is Working Fine

    # User has more than 3 AOM offers
  @SANITY @REGRESSION @TC_593234 @TC_602067 @3G @MPS
  Scenario: Check View All offers screen when the user accept or view the offer _FUN
    Then Validate Discover Offers Accept CTA

  @REGRESSION @TC_580883 @TC_602069 @3G @MPS
  Scenario: Check "Discover offers" at the dashboard  when the user declined an offer from "View All offers screen" _FUN
    Then Validate Discover Offers declined an offer

  @CONSUMER @SOLETRADER @SMB @594201
  Scenario: Test Case 594201: Check the AoM offers will be displayed for Paym MBB subscription_Fun
    Given I should be navigated to dashboard
    Then AOM Offers Is Displayed

  @PREPAY @594200
  Scenario: Test Case 594200: Check when the user is not eligible for AoM offers no offers will be returned_Functional
    Given I should be navigated to dashboard
    Then Default Offer Is Displayed

  @TC_678402 @TC_678398 @TC_678400 @TC_595397 @REGRESSION @PREPAY @3G
  Scenario: Test Case 594201: Check the Chordiant offers will be displayed for PAYG and SOHO subscription_Fun
    Given I should be navigated to dashboard
    Then Chordiant Offers Is Displayed

  @TC_595960 @TC_595961 @REGRESSION @MPS
  Scenario: Check the availability of "View All" CTA on the dashboard
    Then Validate Discover AOM Offers View All CTA


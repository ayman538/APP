##covered these scenarios in discover feature
#@3G @CONSUMER @PREPAY @SOLETRADER @SMB
#Feature: Discover Offers V2
#  Background:
#    Given I am MVA user and logged in using Soft Login
#
#  @CONSUMER @SOLETRADER @SMB @594201
#    Scenario: Test Case 594201: Check the AoM offers will be displayed for Paym MBB subscription_Fun
#      Given I should be navigated to dashboard
#      Then AOM Offers Is Displayed
#
#    @PREPAY @594200
#    Scenario: Test Case 594200: Check when the user is not eligible for AoM offers no offers will be returned_Functional
#      Given I should be navigated to dashboard
#      Then Default Offer Is Displayed
#
#
#
#  @TC_678402 @TC_678398 @TC_678400
#  Scenario: Test Case 594201: Check the Chordiant offers will be displayed for PAYG and SOHO subscription_Fun
#    Given I should be navigated to dashboard
#    Then Chordiant Offers Is Displayed
#
#

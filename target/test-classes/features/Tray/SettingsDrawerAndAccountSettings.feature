@3G @REGRESSION
Feature: Setting Drawer and Account Settings
  Background: Initialize Setting Drawer and Account Settings
#   Given Init Setting Drawer and Account Settings

  @SANITY @TC_601928 @TC_601929 @CONSUMER @PAYG @SMB @SOLETRADER @MPS
  Scenario: TC01_ValidateSettingsDrawerItems
    Given I am MVA user and logged in using Soft Login
    Then Validate Setting Drawer Items

  @TC_601850 @FLN @REGRESSION
  Scenario: TC04_ValidateSettingsDrawerForFLNUsers
    Given I am MVA user and logged in using Soft Login
    Then Validate Account Settings Items for FLN

#  @CONSUMER @PREPAY @SMB @SOLETRADER
#  Scenario: TC02_ValidateAccountSettingsItems
#    Then Validate Account Settings Items

#  @MBB
#  Scenario:  TC03_ValidateAccountSettingsItemsMBB
#    Then Validate Account Settings Items for MBB


  @REGRESSION @TC_601850 @LOGIN @SubswitchToHBB @Special
  Scenario: TC05_ValidateSettingsDrawerForHBBUsers
    Given I am MVA user and logged in using full login with user name and password
    Given Click on My account tray
    And I navigate to sub switch to SubscriptionType "BB" and Segment "CONSUMER"
    Then Validate Account Settings Items for BB

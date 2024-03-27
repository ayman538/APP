@3G @try
Feature: Plan Details

  Background: Initialize Plan Details
    Given I am MVA user and logged in using Soft Login

#  @CONSUMER @SMB @SOLETRADER @BVB
#  Scenario: TC01_ValidatePlanMainTitle
#    Then Validate Plan Details Main Title

  @SANITY @REGRESSION @MPS @CONSUMER @SMB @BVB @TC_601905 @TC_601906 @TC_601911 @PAYG
  Scenario: Test Case 601911: P1_Check plan screen for BVB user_Functional
    Given Navigate to SubsOverlay
    Then I validate plan tab is opened and titles of each sections

  @SANITY @REGRESSION @MPS @CONSUMER @TC_601908
  Scenario: Test Case 601908: P1_Check when user is eligible for upgrade_FUN
    Given Navigate to SubsOverlay
    Then Validate upgrade value in contract section

  @SANITY @REGRESSION @TC_601926 @BINGO
  Scenario: Test Case 601926: P1 Check inclusive extras in plan tab when there are more than 5 products_Functional
    Given I Dismiss The First Tip
    Then Navigate to SubsOverlay
    Then Validate Includes more than 5 items

  @SANITY @REGRESSION @MPS @CONSUMER @SMB @SOLETRADER @TC_601927
  Scenario: Test Case 601927: P1 Check inclusive extras in plan tab when there are less than or equal to 5 products_Functional
    Given Navigate to SubsOverlay
    Then Validate Includes less than 5 items

  @REGRESSION @CONSUMER @TC_601907 @SubswitchToFLN
  Scenario: Test Case 601907: P1_Check plan tab for FLN_FUN
    When Click on My account tray
    Given Proceed in login flow
    Then I navigate to sub switch to "FLN" Subscription
    Given Navigate to SubsOverlay
    Then I validate plan tab is opened and titles of each sections

  @HBB @TC_1071947
  Scenario: Check for the content of Extras tab for a PayM user with HBB subscription has "Vodafone together" discount_FUN
    Given I close the tutorial if displayed
    When I am MVA user and logged in using full login with user name and password
    And The user switch to subscription HBB
    And user clicks on Your Plan control tile
    Then User should see his Vodafone together Discount

#  @CONSUMER @SMB @SOLETRADER @BVB
#  Scenario: TC03_ValidateIncludes
#    Then Validate Plan Details Includes Items



#  @CONSUMER @SMB @SOLETRADER @BVB
#  Scenario: TC04_ValidateIncludesCTA
#    Then Validate Plan Details Includes Items Opening detailed screen
#
##  @CONSUMER @SMB @SOLETRADER @BVB
##  Scenario: TC05_ValidateNewPlanDetailsAllowances
##    Then Validate Plan Details Allowance Items
#
#  @BVB
#  Scenario: TC06_ValidatePlanDetailsCTATextForBVB
#    Then Validate Plan Details CTA text for BVB users
#
#  @BVB
#  Scenario: TC07_ValidatePlanDetailsCTAForBVB
#    Then Validate Plan Details CTA open for BVB users



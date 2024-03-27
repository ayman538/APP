@3G
Feature: Plan Cards for PAYG Users

  Background: Initialize Plan for PAYG Users
#    Given Init Plan for PAYG Users
#    Given Navigate to SubsOverlay
#
#  @BVB
#  Scenario: TC01_ValidateNewPlanPageOffersCardForBVB
#    Then Validate Plan Offers Card for BVB users
#
#  @BVB
#  Scenario: TC02_ValidateNewPlanPageOffersCardCTAForBVB
#    Then Validate Plan Offers Card CTA for BVB users
#
#  @SIMPLY @ONE
#  Scenario: TC03_ValidateNewPlanPageForPAYG
#    Then Validate Plan Tab for PAYG simply or PAYG1 users
#
#  @SIMPLY @ONE
#  Scenario: TC04_ValidateNewPlanPageForPAYGCTA
#    Then Validate Plan Tab CTA for PAYG simply or PAYG1 users

  @REGRESSION @PAYG1 @ONE @TC_601910
  Scenario: Check Plan screen for Payg1 user_FUN
    Then I should navigate to plan tab for PayG user
    Then Validate Plan Tab for PAYG1 users






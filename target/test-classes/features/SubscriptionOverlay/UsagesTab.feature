@3G
Feature: Usages tab

  Background:
    Given I am MVA user and logged in using Soft Login

  @SANITY @REGRESSION @MPS @TC_95669 @TC_225888 @TC_601813 @TC_601817 @CONSUMER @BVB @PAYG
    #to be maintain for BVB scenario
  Scenario: P1 - Check plan card for PAYM user in usage screen has plan data , mins and calls and expiry/renewal date_Functional
    Given Navigate to SubsOverlay
    When Navigate to Usages
    Then I validate usage tab is opened and plan card
    And Check View plan CTA in plan card in Usage tab

  @SANITY @REGRESSION @MPS @TC_95754 @TC_225892 @TC_601816 @CONSUMER
  Scenario: P1 - Check Add extras CTA is displayed for all users_Functional
    Given Navigate to SubsOverlay
    When Navigate to Usages
    Then Check Add extras CTA in Usage tab

    #This TC is blocked on DXL bug Bug 1524428:
  # MVA || DXL || thresholdQuantity attribute returns null in GetBalance api
  @TC_1538094 @3G @MPS @CONSUMER
  Scenario: Check clicking on "Add extra" CTA in usage tab using a softlogged in Red leader user
    When I click on the Data tile
    Then I should be navigated to Usage tab
    And Check Add extras CTA in Usage tab

  @TC_1538118 @3G @MPS @BINGO @CONSUMER
  Scenario: Check clicking on "Add extra" CTA in usage tab using a FL Bingo user
    And I Dismiss The First Tip
    And I am MVA user and logged in using full login with user name and password
    And I click on X CTA
    When I click on the Data tile
    Then I should be navigated to Usage tab
    And Check Add extras CTA in Usage tab

  @TC_1538167 @3G @MPS @CONSUMER
  Scenario: Check the existence of "Manage extras, caps and bars" CTA in usage tab using a softlogged in Consumer MPS user
    When I click on the Data tile
    Then I should be navigated to Usage tab
    And Check Manage extras, caps and bars CTA in Usage tab


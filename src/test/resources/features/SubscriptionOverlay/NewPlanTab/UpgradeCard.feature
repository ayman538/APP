@3G @CONSUMER @SMB @SOLETRADER
Feature: Upgrade Card Card

  Background: The user navigated to the Dashboard
  Given I am MVA user and logged in using Soft Login

  Scenario: TC01_ValidateEligibleForUpgradeCard
    Given I navigate to plan tab from Dashboard
    Then Validate Eligible For Upgrade Plan Card

  Scenario: TC02_ValidateEligibleForUpgradeCardCTA
    Given I navigate to plan tab from Dashboard
    Then Validate Eligible For Upgrade Plan Card CTA

  Scenario: TC03_ValidateNotEligibleForUpgradeCard
    Given I navigate to plan tab from Dashboard
    Then Validate Not Eligible For Upgrade Plan Card

  Scenario: TC04_ValidateFancyCard
    Given I navigate to plan tab from Dashboard
    Then Validate Fancy Plan Card

  Scenario: TC05_ValidateFancyCardCTA
    Given I navigate to plan tab from Dashboard
    Then Validate Fancy Plan Card CTA

  Scenario: TC06_ValidateChangePlanCard
    Given I navigate to plan tab from Dashboard
    Then Validate Change Plan Card

  Scenario: TC07_ValidateChangePlanCardCTA
    Given I navigate to plan tab from Dashboard
    Then Validate Change Plan Card CTA


  Scenario: TC08_Check the behavior when user click on "Upgrade now" CTA
    Given I navigate to plan tab from Dashboard
    When click on upgrade now CTA
    Then upgrade PoP up is displayed


  Scenario: TC09_Check the behavior when user click on "Choose a phone plan" CTA _FUN
    Given I navigate to plan tab from Dashboard
    When click on Choose a phone plan CTA
    Then upgrade PoP up is displayed


  Scenario: TC10_Check the UI of the new pop up of trade-in when user is eligible for handset upgrade_UI
    Given I navigate to plan tab from Dashboard
    When click on upgrade now CTA
    Then I validate on upgrade and trade-in popup

  Scenario: TC11_Check the functionality of X close in the new popup of trade in_FUN
    Given I navigate to plan tab from Dashboard
    When click on upgrade now CTA
    And  click on x button
    Then X close should dismiss the new overlay and user will still in plan tab screen

  Scenario: TC12_Check the functionality of 1st CTA "Yes, Please" in the new popup of trade in_FUN
    Given I navigate to plan tab from Dashboard
    When click on upgrade now CTA
    And  click on Yes ,Please CTA
    Then user will be redirected to trade-in SDK to run the diagnostic

  @MBB
  Scenario: TC 519606: Check The PAYM MBB user have the new Upgrade Eligibility Message _FUN
    Given I navigate to plan tab from Dashboard
    Then Validate Call Us CTA Call CTA

  @TC_1375183 @MPS  @Eligible_Upgrade_Handset_SIMO   @Eligibility_Type_Normal
  Scenario: Check upgrade card for PayM MPS has SIMO and handset upgrades
    Given I navigate to plan tab from Dashboard
    Then I validate upgrade card with two CTAs

  @CONSUMER @AoM @Normal @Simo @Flexi @TC_2060186 @TC_2060125 @TC_2060185 @TC_2060187 @TC_2060188 @TC_2177834 @TC_2140974 @TC_2177840
  Scenario: TC 1458341: 1263538.01_P1_Check Plan tab UI for AOM offer upgrade for consumer & normal eligibility upgrade user
    Given I am MVA user and logged in using full login with user name and password
    Given I navigate to plan tab from Dashboard
    Then Validate Plan Upgrade Card for different user types
    Then Validate the discount card on the phone plan appearance
    Then Validate the AoM recommendation reason
    Then Validate the discount card on the phone plan content
    Then Validate the brands icons carousel
    Then Validate View full offer CTA
    Then Validate ASA regularity copy
    Then Validate See more device plans CTA
    Then upgrade PoP up is displayed
    Then I validate on upgrade and trade-in popup
    Then I click on Upgrade only CTA in popup
    Then user will be redirected to eShop in internal web view
    Then I click on x icon in webview
    Then click on Exit
    Then Validate See more device plans CTA
    And  click on Yes ,Please CTA
    Then user will be redirected to trade-in SDK to run the diagnostic

  @SMB @SoleTrader @simo @flexi @normal @TC_2020015
  Scenario: TC :Validate Trade-in tray on the upgrade CTA for SMB and SoleTrader
    Given I am MVA user and logged in using full login with user name and password
    Given I navigate to plan tab from Dashboard
    When click on upgrade now CTA
    Then upgrade PoP up is displayed
    Then I validate on upgrade and trade-in popup
    And  click on x button
    Then X close should dismiss the new overlay and user will still in plan tab screen
    When click on upgrade now CTA
    Then I click on Upgrade only CTA in popup
    Then user will be redirected to eShop in internal web view
    Then I click on x icon in webview
    Then click on Exit
    When click on upgrade now CTA
    And  click on Yes ,Please CTA
    Then user will be redirected to trade-in SDK to run the diagnostic













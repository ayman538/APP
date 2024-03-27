@3G @WIFI @CONSUMER @SMB @SOLETRADER
Feature: Charges Card
  Background:
    Given I am MVA user and logged in using Soft Login

  @TC_86688
  Scenario: Test Case 86688: P1 - Check current charges tile UI is displayed as UI reference (Current charges , CTN , Amount ,Footer , Dates)_UI
    Then Validate charges card

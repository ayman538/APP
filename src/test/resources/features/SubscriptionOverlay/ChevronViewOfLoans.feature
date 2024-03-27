@3G
Feature: ChevronViewOfLoans

  Background: Initialize Bingo User
    Given I am MVA user and logged in using Soft Login

  @TC_817268  @Bingo_User  @Has_Multiple_loans   @Loans_Has_Extras
  Scenario: Check the chevron/accordion view of multiple paid/Unpaid loans with extras in the device plan over-lay screen
    Given Navigate to Device plan tab
    Then Validate the chevron icon functionality of first loan
    And Validate the chevron icon functionality of second loan

  @TC_817270 @TC_817271 @Bingo_User  @Has_One_loan
  Scenario: Check that there is no chevron icon if user has only one loan in the device plan over-lay screen
    Given Navigate to Device plan tab
    Then check that the chevron icon not exist
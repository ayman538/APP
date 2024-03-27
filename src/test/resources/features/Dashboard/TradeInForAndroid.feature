#TODO: should be merged with assistance links feature and put TC ID in regression and tag for the running users
@3G @WIFI @ANDROID
Feature: TradeIn For Android

  Background: Initialize TradeIn Android Class
    Given Init TradeIn for Android

  Scenario: TC01_ValidateOrdering
    When Click on See More CTA
    Then Assert on TradeIn Title

  Scenario: TC02_ValidateTradeInLinkIsDisplayed
    Then Validate TradeIn link displayed

  Scenario: TC03_ValidateTradeInLinkFunctionality
    Then Check TradeIn CTA and X-Icon



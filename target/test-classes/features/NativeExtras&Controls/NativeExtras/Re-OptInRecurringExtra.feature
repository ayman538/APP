Feature: Re-opting In An Extra

  @TC_1203769 @TC_TC_1203767 @3G @CONSUMER @MPS
  Scenario: Check the existence of the confirmation tray when clicking on the "Re-Opt in" CTA
    Given I am MVA user and logged in using Soft Login
    And I should be navigated to dashboard
    And I close the tutorial if displayed
    And I click on the Native Add Extras tile
    When I should be navigated to the Native Extras tab
    And I should see "Re-Opt In" CTA for recurring extra
    And I click on "Re-Opt In" for CTA for recurring extra
    Then I should be navigated to "Re-Opt In" Confirmation Tray

  @TC_1203770 @3G @Soletrader @MPS
  Scenario: Check the behavior when clicking on 'X' CTA for Re-opt in confirmation tray
    Given I am MVA user and logged in using Soft Login
    And I close the tutorial if displayed
    And I should be navigated to dashboard
    And I click on the Native Add Extras tile
    When I should be navigated to the Native Extras tab
    And I should see "Re-Opt In" CTA for recurring extra
    And I click on "Re-Opt In" for CTA for recurring extra
    And I should be navigated to "Re-Opt In" Confirmation Tray
    And I click on X CTA for Opting Confirmation Tray
    Then I should be navigated to the Native Extras tab

  @TC_1203773 @3G @CONSUMER @MPS
  Scenario: Check the behavior when clicking on "Re-Opt in" CTA on the confirmation tray
    Given I am MVA user and logged in using Soft Login
    And I close the tutorial if displayed
    And I should be navigated to dashboard
    And I click on the Native Add Extras tile
    When I should be navigated to the Native Extras tab
    And I should see "Re-Opt In" CTA for recurring extra
    And I click on "Re-Opt In" for CTA for recurring extra
    And I should be navigated to "Re-Opt In" Confirmation Tray
    And I click on Opt CTA on the Opting Confirmation Tray
    And I am MVA user and logged in using full login with user name and password
    Then  I should see Re-Opt In Thank You Tray Content

  @TC_1203775 @Login @CONSUMER @MPS @3g
  Scenario: Check the content of the "Your Recurring Extra will be added" tray
    Given I am MVA user and logged in using full login with user name and password
    And I close the tutorial if displayed
    And I should be navigated to dashboard
    And I click on the Native Add Extras tile
    When I should be navigated to the Native Extras tab
    And I should see "Re-Opt In" CTA for recurring extra
    And I click on "Re-Opt In" for CTA for recurring extra
    And I should be navigated to "Re-Opt In" Confirmation Tray
    And I click on Opt CTA on the Opting Confirmation Tray
    Then I should see Re-Opt In Thank You Tray Content

  @TC_1203784 @Login @Soletrader @MPS
  Scenario: Check the behavior when clicking 'Continue' CTA on the "Your Recurring Extra will be added" tray
    Given I am MVA user and logged in using full login with user name and password
    And I close the tutorial if displayed
    And I should be navigated to dashboard
    And I click on the Native Add Extras tile
    When I should be navigated to the Native Extras tab
    And I should see "Re-Opt In" CTA for recurring extra
    And I click on "Re-Opt In" for CTA for recurring extra
    And I should be navigated to "Re-Opt In" Confirmation Tray
    And I click on Opt CTA on the Opting Confirmation Tray
    And I should see Re-Opt In Thank You Tray Content
    And I clicks on Continue CTA
    Then I should be navigated to the Native Extras tab
    And I should see "Re-Opt In" CTA disabled

  @TC_1203808 @Login @Soletrader @MPS
  Scenario: Check the behavior when clicking on 'X' CTA on "Your extra has been removed" tray
    Given I am MVA user and logged in using full login with user name and password
    And I close the tutorial if displayed
    And I should be navigated to dashboard
    And I click on the Native Add Extras tile
    When I should be navigated to the Native Extras tab
    And I should see "Re-Opt In" CTA for recurring extra
    And I click on "Re-Opt In" for CTA for recurring extra
    And I should be navigated to "Re-Opt In" Confirmation Tray
    And I click on Opt CTA on the Opting Confirmation Tray
    And I should see Re-Opt In Thank You Tray Content
    And I click on X CTA for Opting Thank You Tray
    Then I should be navigated to the Native Extras tab
    And I should see "Re-Opt In" CTA disabled

Feature: Opting Out An Extra

  @TC_1165925 @TC_TC_1165917 @LOGIN @Soletrader @MPS
  Scenario: Check the existence of the Opt out confirmation tray when clicking on the  "Remove" CTA
    Given I am MVA user and logged in using full login with user name and password
    And I should be navigated to dashboard
    And I close the tutorial if displayed
    And I click on the Native Add Extras tile
    When I should be navigated to the Native Extras tab
    And I should see "Opt out" CTA for recurring extra
    And I click on "Opt out" for CTA for recurring extra
    Then I should be navigated to "Opt out" Confirmation Tray


  @TC_1165925 @3G @CONSUMER @MPS
  Scenario: Check the behavior when clicking on 'X' CTA for Opt out confirmation tray
    Given I am MVA user and logged in using Soft Login
    And I close the tutorial if displayed
    And I should be navigated to dashboard
    And I click on the Native Add Extras tile
    When I should be navigated to the Native Extras tab
    And I should see "Opt out" CTA for recurring extra
    And I click on "Opt out" for CTA for recurring extra
    And I should be navigated to "Opt out" Confirmation Tray
    And I click on X CTA for Opting Confirmation Tray
    Then I should be navigated to the Native Extras tab


  @TC_1165934 @TC_1165933 @Login @CONSUMER @MPS @3g
  Scenario: Check the content of the "Your extra has been removed" tray
    Given I am MVA user and logged in using full login with user name and password
    And I close the tutorial if displayed
    And I should be navigated to dashboard
    And I click on the Native Add Extras tile
    When I should be navigated to the Native Extras tab
    And I should see "Opt out" CTA for recurring extra
    And I click on "Opt out" for CTA for recurring extra
    And I should be navigated to "Opt out" Confirmation Tray
    And I click on Opt CTA on the Opting Confirmation Tray
    Then I should see Opt Out Thank You Tray Content


  @TC_1165948 @Login @Soletrader @MPS
  Scenario: Check the behavior when clicking on 'X' CTA on "Your extra has been removed" tray
    Given I am MVA user and logged in using full login with user name and password
    And I close the tutorial if displayed
    And I should be navigated to dashboard
    And I click on the Native Add Extras tile
    When I should be navigated to the Native Extras tab
    And I should see "Opt out" CTA for recurring extra
    And I click on "Opt out" for CTA for recurring extra
    And I should be navigated to "Opt out" Confirmation Tray
    And I click on Opt CTA on the Opting Confirmation Tray
    And I click on X CTA for Opting Thank You Tray
    Then I should be navigated to the Native Extras tab
    And I should see "Opt out" CTA disabled

  @TC_1169397 @Login @Soletrader @MPS
  Scenario: Check the behavior when clicking on 'Continue' CTA on the "Your extra has been removed" tray
    Given I am MVA user and logged in using full login with user name and password
    And I close the tutorial if displayed
    And I should be navigated to dashboard
    And I click on the Native Add Extras tile
    When I should be navigated to the Native Extras tab
    And I should see "Opt out" CTA for recurring extra
    And I click on "Opt out" for CTA for recurring extra
    And I should be navigated to "Opt out" Confirmation Tray
    And I click on Opt CTA on the Opting Confirmation Tray
    And I clicks on Continue CTA
    Then I should be navigated to the Native Extras tab
    And I should see "Opt out" CTA disabled
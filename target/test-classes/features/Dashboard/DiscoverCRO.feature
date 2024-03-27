
Feature: Discover CRO

      @MPS @3G @TC_1918646
    Scenario: Check that discover tile is clickable for PAYM users has AOM offers
    Given I am MVA user and logged in using full login with PIN
    Then I should be navigated to dashboard
    Then I should validate Discover AOM Offers

       @SMB @SOLETRADER @3G @TC_1912466
    Scenario: Check that discover tile is clickable for Sole trader/SMB has Chordiant offers
      Given I am MVA user and logged in using Soft Login
      Then I should be navigated to dashboard
      Then I should validate Discover Chordiant offers



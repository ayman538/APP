@DVT_PAYG @WIFI @PAYG
Feature: DVT Scenarios for PAYG root

  Background:
    Given I am prod user and logged in using UFL
    And Validate Dashboard displayed

  Scenario: Validate Discover offers and Very me
    Then Validate Discover Offers Displayed
    Then Dashboard loaded and scroll to VeryMe offers
    Then Check VeryMe title

  Scenario: Validate Tray Items
    Then Validate MyAccount item in dashboard tray
    Then Validate Rewards and very me item in dashboard tray
    Then Validate Settings item in dashboard tray
    Then Validate Billing and top up item in dashboard tray
    Then I navigate to TOBi and validate it is opened then close it

  Scenario: Check ACTIVATE_VOUCHER journey from topup
    Given Dashboard loaded and Topup is displayed
    Then I navigate to Topup screen
    Then User click on Activate voucher
    Then Validate Activate voucher content

  Scenario: Check Plan and Usage tab
    Given I navigate to plan tab for payg
    Then I validate plan tab for payg is opened
    Then I navigate to usage tab from subscriptions overlay
    Then I validate usage tab for payg is opened

  Scenario: Check Bug a Big Value Bundle
    Given I navigate to Bug a Big Value Bundle
    Then I validate Bug a Big Value Bundle screen

  Scenario: Check Extra bars and caps card from extras
    Given Navigate to SubsOverlay
    And I navigate to extras tab from subscriptions overlay
    Then Validate Extras Bars and Caps Card

  Scenario: Check subscription overlay header
    Given Navigate to SubsOverlay
    Then Validate SubsOverlay header

  Scenario: Validate Privacy Settings Items
    Then I navigate to Privacy Settings
    Then Validate Privacy Settings Items

  Scenario: Validate low credit card
    Then Validate credit card header
    Then Validate low credit card title
    Then Validate credit card amount is less than 5 Pounds
    Then Validate credit card footer

  Scenario: Check speed test results screen
    And Click on Check data and WiFi Speed
    Then user clicks on test network speed button
    Then validate network speedchecker test results value
    And validate check again CTA is displayed

  Scenario: P1 - Check network section _Functional
    Given Dashboard loaded and Network links retrieved successfully
    Then Check Network title text
    Then Check Network links ordering and texts
    Then Check Network links CTAs

  Scenario: Validate Connnected Apps Titles
    Then Scroll down and check Connected apps Images
    Then Check Connected apps Titles

  Scenario:P1 - Check eshop links
    When I Scroll Down to Eshop Links
    And I Check only 5 links are displayed in Eshop Links

  Scenario:P1 - Check assistance links
    Then Check only 5 links are displayed
    Then Check Assistance links ordering and texts


 @WIFI @MPS @paymDVT @LOGIN
Feature: DVT Scenarios for PAYM root


  Scenario: Validate Tiles Cards for PAYM root in soft login
    Given I am prod user and logged in using UFL
    And Validate Dashboard displayed
    Then Validate Allowance Tile
    Then Validate charges card
    Then Validate First Control Tile Text for PAYM SMB SOLETRADER REDHYBRID
    And Validate Second Control Tile Text  for PAYM SMB SOLETRADER REDHYBRID


  Scenario: Validate Discover offers and Very me is Displayed for PAYM root in soft login
    Then Validate Discover Offers Displayed
    Then Dashboard loaded and scroll to VeryMe offers
    Then Check VeryMe title

  Scenario: Validate Privacy Settings Items for PAYM root in soft login
    Then I navigate to Privacy Settings
    Then Validate Privacy Settings Items

  Scenario: P1 - Check network section _Functional
    Given Dashboard loaded and Network links retrieved successfully
    Then Check Network title text
    Then Check Network links ordering and texts

  Scenario: Validate Account Settings Items for PAYM root in soft login
    And Account settings screen is displayed
    Then I should validate Account Settings Items

  Scenario: Validate App Settings Items for PAYM root in soft login
    And I navigate to App settings screen
    Then Assert on items displayed


  Scenario: Validate order of assistance links for PAYM root in soft login
    Then Check Assistance title text
    Then Check Assistance links ordering and texts

  Scenario:P1 - Check eshop links
    When I Scroll Down to Eshop Links
    And I Check only 5 links are displayed in Eshop Links

  Scenario: Validate Connected Apps Titles for PAYM root in soft login
    Then Scroll down and check Connected apps Images
    Then Check Connected apps Titles

  Scenario: Validate Tray Items for PAYM root in soft login
    Then Validate MyAccount item in dashboard tray
    Then Validate Rewards and very me item in dashboard tray
    Then Validate Settings item in dashboard tray
    Then I navigate to TOBi and validate it is opened then close it

  Scenario: Validate the First , Second Control Tiles Opens the right Tab
    Then Validate First Control Tile Text for PAYM SMB SOLETRADER REDHYBRID
    And Validate Plan tab appears after clicking primary control tile
    And Validate Second Control Tile Text  for PAYM SMB SOLETRADER REDHYBRID
    And Validate Extras or Group data tab appears after clicking secondary control tile


  Scenario: Validate Billing opens Successfully
    And Validate Dashboard displayed
    Then InitBillingLogicObject
    Then navigateToBilling
    Then I should see the new billing dashboard

  Scenario: Validate upgrade now is opened successfully
    When I navigate to plan tab from Dashboard
    And I click on see plans button
    When the user selects a specific plan
    Then the user redirected to the new plan page
    When Scroll Down till the end of the page
#    When the user toggles terms and conditions confirmation
    And the user clicks on Continue CTA
    Then the user redirected to Checkout modal

  Scenario: Validate manage and extras opens successfully
    Then I should be navigated to dashboard
    Then I navigate to subscriptions overlay
    Then I navigate to extras tab from subscriptions overlay
    Then I validate manage bars and extras SSO




#
#  Scenario: Check speed test results screen_functional
#    And Click on Check data and WiFi Speed
#    Then user clicks on test network speed button
#    Then validate network speedchecker test results value
#    And validate check again CTA is displayed
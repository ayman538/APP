Feature: DVT Scenarios for Child User

  Background: Switching to a child user
    Given I am MVA user and logged in using full login with user name and password
    When I navigate to sub switch to SubscriptionType "MPS" and Segment "Consumer"

  Scenario: Check that dashboard is displayed normally for child user
    Then user is on dashboard

  Scenario: Check that very me section doesn't appear for child user
    Then Scroll down and check VeryMe does not appear for child users

  Scenario: Check that child user can access latest bill
    When The user navigated to billing screen
    Then Validate latest bill SSO is opened

  Scenario: Check manage bars and extras for child user
    When I navigate to subscriptions overlay
    And I navigate to extras tab from subscriptions overlay
    Then I validate manage bars and extras SSO

  Scenario: Check data cap for child user
    When I navigate to subscriptions overlay
    And I navigate to extras tab from subscriptions overlay
    And Click on Data Cap journey
    Then Validate Data Cap SSO is opened

  Scenario: Check upgrade now for child user
    When I navigate to plan tab from Dashboard
    And click on upgrade now CTA
    And I click on Upgrade only CTA in popup
    And click on accept it in The Cookie permission message
    Then Validate Upgrade now SSO is opened

  Scenario: Check view details in charges tab for child user
    When I navigate to charges tab from subscriptions overlay
    And Click on View Details CTA
    Then Validate view charges SSO is opened

  Scenario: Check assistance links for child user
    When I Scroll Down to Assistance links
    Then I should see the Assistance Links for Child User

  Scenario: Check network links for child user
    When Dashboard loaded and Network links retrieved successfully
    Then Check Network links CTAs

  Scenario: Check speed checker for child user
    When Click on Check data and WiFi Speed
    And Network optimization grant permission screen is displayed
    Then speedchecker screen title should be displayed
    When user clicks on test network speed button
    Then validate that network speed test ends successfully

  Scenario: Check reset app for child user
    When user clicks on Settings in Dashboard tray
    And user clicks on App in settings drawer
    And user clicks on reset the app link
    Then reset the app screen appeared successfully
    And Assert on Reset app card CTA and description

  Scenario: Check privacy settings for child user
    When user clicks on Settings in Dashboard tray
    And user clicks on Privacy in settings drawer
    Then click on app privacy and validate screen the screen content

  Scenario: Check login options for child user
    When user clicks on Settings in Dashboard tray
    And user clicks on App in settings drawer
    And user clicks on Login options link
    Then Login options screen appeared successfully
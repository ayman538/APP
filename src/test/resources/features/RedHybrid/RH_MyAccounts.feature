@REDHYBRID @SIT_CYCLE2 @3G

Feature: RedHybrid My Accounts

  Background:
    Given I am MVA user and logged in using Soft Login
    And  I close the tutorial if displayed
    And I should be navigated to dashboard

  @TC_861913
  Scenario:  Check the updated product name of the subscription in MyAccount tray icon
    Given I click on my account without login
    When  I am MVA user and logged in using full login with user name and password
    Then RedHybrid user susbcription appears in My account


  @TC_598895
  Scenario: Viewing list of Subscriptions and accounts of RedHyprid multiple accounts user
    When click on my account
    Then The logged In user see my accounts dropdown and list of subscriptions
     #SwitchingToRedHybridAccount
    And Click on my Accounts dropdown and choose "7001098352" account
    Then The Flexi user should see my accounts dropdown and 1 Flexi subscription


  @TC_598898  @returningUser
  Scenario: Switching between accounts for redHybrid user has multiple accounts
    When I close the app and relaunch it again
    And  I close the tutorial if displayed
    And click on my account
    Then The logged In user see my accounts dropdown and list of subscriptions
      #SwitchingToRedHybridAccount
    When Click on my Accounts dropdown and choose "7001098352" account
    And  Click on Flexi subscription
    And user dismiss the add payment method overlay
    Then Flexi account Dashboard Displayed
    When I navigate to my account from dashboard tray
      #SwitchingToRootAccount
    And Click on my Accounts dropdown and choose "7001119519" account
    And Click on subscription
    Then Root account Dashboard displayed




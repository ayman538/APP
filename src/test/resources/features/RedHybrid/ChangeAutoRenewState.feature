@3G @RedHybrid
Feature: Red Hybrid - Subscriptions Overlay - Plan tab - Manage your plan card - Toggle Auto-renew off

  Background:
    Given I am MVA user and logged in using Soft Login
    When  I should be navigated to dashboard
    And   I navigate to subscriptions overlay
    Then  I scroll down to the manage your plan card


  @TC_595978
  Scenario: Check The App behavior when the user has the auto-renew toggle off in "manage your plan " card
    Then  I should be able to see manage your plan card for RedHybrid user

  @TC_595665 @TC_1327172 @LOGIN
  Scenario: Check manage your plan card after changing the status of toggle to off the hard close the app
    When  I click on auto renew plan toggle
    And   I am MVA user and logged in using full login with user name and password
    And   I Should see the mask over Manage your plan card
    And   hard close the app
    And   I navigate to subscriptions overlay
    Then  I Should see the mask over Manage your plan card



  @TC_1015973  @TC_1015977  @LOGIN
  Scenario: Check app behavior while trying to Change plan for next month through Deep Link and quick links while request is being processed
    When  I click on auto renew plan toggle
    And   I am MVA user and logged in using full login with user name and password
    Then  I should be able to see disclaimer Mask card
    When  user closes the subsoverlay
    Then  I should be navigated to dashboard
    When  scroll to quick links
    And   User clicked on change next plan in quick links menu
    Then  I should see the screen that notify the user that a request is being processed
    When  I click on X icon
    And   I Open Deep Link for Change plan for next Month
    Then  I should see the screen that notify the user that a request is being processed


    @TC_1327169 @TC_1338264 @PaymentWithPassword @Toggle_OFF
    Scenario: Check the App behavior when trying to turn ON the auto renew toggle
      When I click on auto renew plan toggle
      And  I am MVA user and logged in using full login with user name and password
      Then I should be navigated to Payment Method screen with title "Auto-Renew"
      Then I inserts '963' cvv number of the payment card
      Then I clicks on Continue CTA in Payment Method screen
      And I should be navigated to Payment Card PWD screen
      Then I inserts "Pa55w0rd" password of the card
      When I clicks on submit CTA in Payment Card PWD screen
      Then I should be able to see Processing screen
      Then I should validate the UI of confirmation screen of "Auto-Renew"
      Then I click on continue CTA
      Then I Should see the mask over Manage your plan card



  @TC_1346827  @TC_1346829 @UserWithToggle_OFF
  Scenario: Check manage your plan card after changing the status of toggle to off the hard close the app
    When  I click on auto renew plan toggle
    Then  I should be navigated to an overlay to 'Add a new payment method' while trying to 'auto-renew'

@3G @RedHybrid
Feature: 642895: Red Hybrid - Add Extras - Confirm Extra's purchase - Cancelled/Failed status

  Background:Launch the app using Red Hybrid user that has Active plan and has Payment card already added, and landing on "Payment method"overlay
    Given I am MVA user and logged in using Soft Login
    When  user is on dashboard
    And   I navigate to add extras overlay
    And   user clicks on Around_The_World_Roaming_Extra "Around the World Roaming Extra"
    And   Around_The_World_Roaming_Extra overlay appear to the user
    And   Choose a Roaming Extra and click continue
    And   User full login
    And   User Navigated to Barcalys Screen
    And   user inserts "234" cvv
    And   user clicks on Pay now CTA
    And   password screen appears
    And   user inserts invalid "pa" password of the card
    And   user clicks on submit
    And   invalid password text appears
    And   user inserts invalid "pa" password of the card
    And   user clicks on submit
    And   invalid password text appears
    And   user inserts invalid "pa" password of the card
    Then  user clicks on submit

  ##@TC_789893 to be updated on vsts
  @TC_789923
  Scenario: Check the UI of the "Payment error" overlay in case of authorization failed_UI
    Given Payment error overlay should appear to the user with try again CTA
    Then  Payment error overlay for add extra journey should be visible and compatible with the response of the API

  @TC_789917
  Scenario: Check App behavior in case the user clicks on "Try again" CTA in the "Payment Error" Overlay_Functional
    Given  Payment error overlay should appear to the user with try again CTA
    When   User clicks on Try Again CTA
    Then   I should be navigated to addExtras overlay


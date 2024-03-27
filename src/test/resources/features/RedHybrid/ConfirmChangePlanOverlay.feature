@3G @RedHybrid
Feature: 544777 : Red Hybrid - Change Next Plan - Confirm Plan Change Overlay - Payment Method already added

  Background: Launch the app using Red Hybrid user that has active plan, has payment method already added - User soft logged in
    Given I am MVA user and logged in using Soft Login

  @TC_678310 @TC_1077208  @LOGIN
  Scenario: Check UI of "Confirm Plan Change" overlay after tapping on Continue CTA  in "Change Next Plan" overlay_UI
    Given  I should be navigated to dashboard
    When   RedHybrid Navigated to Plantab
    And    user clicks on Change Plan CTA
    And    user selects a plan
    And    I click on continue CTA
    And   I am MVA user and logged in using full login with user name and password
    And    Change Plan Overlay should appear
   Then   Change Plan Overlay should comply with UI on Figma


  @TC_1077207 @LOGIN
  Scenario: E to E TC1_ Change plan from quick links with Payment added
    And   I should be navigated to dashboard
    When  scroll to quick links
    And   User clicked on change next plan in quick links menu
    Then  user should be directed to Change_Next_Plan_overlay
    And Change_Next_Plan_overlay UI should be respected
    When   user selects a plan
    And   I click on continue CTA
    And I am MVA user and logged in using full login with user name and password
    Then  Change Plan Overlay should appear
    And  Change Plan Overlay should comply with UI on Figma
    When   I Click on Confirm next plan CTA
    Then I should validate processing icon displayed successfully
    And I should validate the UI of confirmation screen of "Change plan"
    When I click on X icon
    Then I should be navigated to dashboard
    When  scroll to quick links
    And   User clicked on change next plan in quick links menu
    Then  I should see the screen that notify the user that a request is being processed
    When  I click on X icon
    And   I Open Deep Link for Change plan for next Month
    Then  I should see the screen that notify the user that a request is being processed




  @TC_1356859
  Scenario: P1_ Check that the Auto-Renew overlay will appear for user has Auto Renew toggle off _ FUN
    And   I should be navigated to dashboard
    When  scroll to quick links
    And   User clicked on change next plan in quick links menu
    Then  I should be navigated to an overlay to 'Turn on Auto-Renew Toggle' while trying to 'change-next'
    And  I should be click on Turn on Auto-Renew Toggle
    Then I am MVA user and logged in using full login with user name and password
    Then I should be navigated to Payment Method screen with title "Auto-Renew"
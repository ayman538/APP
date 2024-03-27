@REDHYBRID @Regression_Active_NO_Payment


Feature: Automation First || Red Hybrid - MVA - Plan Management - Change Plan and Opting In/Opting Out
  Background:
   Given I am MVA user and logged in using Soft Login

  @TC_678290 @TC_1350708  @BETA
  Scenario: Check the behavior when RedHybrid user who has no/expired payment card added is trying to add a new plan from the plan tab in subscription overlay
    When RedHybrid Navigated to Plantab
    And user clicks on Change Plan CTA
    Then I should be navigated to an overlay to 'Add a new payment method' while trying to 'change-next'

  @TC_678291 @TC_1356858
  Scenario: Check the behavior when RedHybrid user who has no/expired payment card added is trying to change next plan in quick links menu items
    When I click on change plan from quick links without click on Payment overlay skip CTA
    Then I should be navigated to an overlay to 'Add a new payment method' while trying to 'change-next'

  @TC_678298 @TC_1356858 @BETA
  Scenario: Check the behavior when clicking on skip button on the overlay informing user to add a payment card
    And I should be navigated to dashboard
    When RedHybrid Navigated to Plantab
    And user clicks on Change Plan CTA
    Then I should be navigated to an overlay to 'Add a new payment method' while trying to 'change-next'
    And I should not see the Skip CTA

  @TC_678294  @LOGIN @BETA
  Scenario: Check the behavior when clicking on "Add a new card" CTA
    And I should be navigated to dashboard
    When RedHybrid Navigated to Plantab
    And user clicks on Change Plan CTA
    And Clicked on a add new card CTA
    And I am MVA user and logged in using full login with user name and password
    Then user should redirected to Payment full flow

  @1572846 @POST_BETA
  Scenario: Check the behavior when RedHybrid user who has no/expired payment card added is trying to add a new plan from the plan tab in subscription overlay PostBeta
    When RedHybrid Navigated to Plantab
    And user clicks on Change Plan CTA
    Then I Should Validate Change plan overlay UI
    And  I Select Change plan for next month Card and click continue CTA
    Then I should be navigated to an overlay to 'Add a new payment method' while trying to 'change-next'
    And I should not see the Skip CTA

  @TC_1574745 @POST_BETA
  Scenario: Check the behavior when clicking on "Add a new card" CTA PostBeta
    And I should be navigated to dashboard
    When RedHybrid Navigated to Plantab
    And user clicks on Change Plan CTA
    And  I Select Change plan for next month Card and click continue CTA
    And Clicked on a add new card CTA
    And I am MVA user and logged in using full login with user name and password
    Then user should redirected to Payment full flow
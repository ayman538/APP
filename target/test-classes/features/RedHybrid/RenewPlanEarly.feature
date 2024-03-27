@RedHybrid @4G @REDHYBRID  @ActivePlan @POST_BETA

Feature: Feature 568177: Red Hybrid - MVA - Renew Early

  Background: Launch the app using redHybrid user that has active plan
    Given  I am MVA user and logged in using Soft Login
    Then I should be navigated to dashboard


  @TC_1030360 @TC_1030363
  Scenario:Check the Content of Renew Early bundles and UI is retrieved correctly After clicking on "Renew plan early" at quick links menu_Func
    When scroll to quick links
    When I click on Renew Early from quick links
    Then I should be directed to Renew_plan_early_overlay
    And  I Should Validate Renew plan early overlay UI


  @TC_1072764 @POST_BETA
  Scenario:Check continue CTA in payment Method overlay while "Renew plan early" from quick links menu_Func
    When scroll to quick links
    When I click on Renew Early from quick links
    Then I should be directed to Renew_plan_early_overlay
    When user selects a plan
    And I clicks on Continue CTA
    And I am MVA user and logged in using full login with user name and password
    Then I should be navigated to Payment Method screen with title "Renew early"
    Then I enter "258" CVV and payment passcode if needed


  @TC_1089312 @POST_BETA
  Scenario:Check physical Back in payment Method overlay while "Renew plan early" from quick links menu_Func
    When scroll to quick links
    When I click on Renew Early from quick links
    Then I should be directed to Renew_plan_early_overlay
    When user selects a plan
    And I clicks on Continue CTA
    And I am MVA user and logged in using full login with user name and password
    Then I should be navigated to Payment Method screen with title "Renew early"
    When Tap on back icon
    Then I should be directed to Renew_plan_early_overlay

  @TC_1107823 @TC_1107824 @POST_BETA
  Scenario:Check UI & back CTA of Confirm your purchase overlay while "Renew plan early" from quick links menu_Func
    When scroll to quick links
    And I click on Renew Early from quick links
    Then I should be directed to Renew_plan_early_overlay
    When user selects a plan
    And I clicks on Continue CTA
    And I am MVA user and logged in using full login with user name and password
    Then I should be navigated to Payment Method screen with title "Renew early"
    When I enter "258" CVV and payment passcode if needed
    Then  I should be navigated to Confirm Purchase Screen With "change-now" orderType
    And  Assert that PAY Securely CTA should be displayed
    When Tap on back icon
    Then I should be navigated to Payment Method screen with title "Renew early"

  @TC_1638757 @TC_1638806 @POST_BETA
  Scenario:Check "Payment Processing" and "Order confirmation" overlay while Renew plan early_UI
    When scroll to quick links
    And I click on Renew Early from quick links
    Then I should be directed to Renew_plan_early_overlay
    When user selects a plan
    And I clicks on Continue CTA
    And I am MVA user and logged in using full login with user name and password
    Then I should be navigated to Payment Method screen with title "Renew early"
    When I enter "258" CVV and payment passcode if needed
    Then  I should be navigated to Confirm Purchase Screen With "change-now" orderType
    When I clicks on Pay Securely CTA
    Then I should be able to see Processing screen
    And I should validate the UI of confirmation screen of "Renew early"

    @TC_1639092 @POST_BETA
  Scenario:Check the behavior when click on "Continue" in "order confirmation" overlay
    When RedHybrid Navigated to Plantab
    And  user clicks on Change Plan CTA
    Then I should navigate to Change plan overlay
    When I Select Renew plan early Card and click continue CTA
    Then I should be directed to Renew_plan_early_overlay
    When user selects a plan
    And  I clicks on Continue CTA
    And  I am MVA user and logged in using full login with user name and password
    Then I should be navigated to Payment Method screen with title "Renew early"
    When I enter "258" CVV and payment passcode if needed
    Then I should be navigated to Confirm Purchase Screen With "change-now" orderType
    When I clicks on Pay Securely CTA
    And  I should validate the UI of confirmation screen of "Renew early"
    When I click on continue CTA
    Then  I should see Plan tab







# renew early while has NO payment method added

  @TC_1225991 @NO-Payment-Method
  Scenario: Check behavior when RH user with expired / no Payment method added try to renew the plan from quick links
    When scroll to quick links
    When I click on Renew Early from quick links
    Then I should be navigated to an overlay to 'Add a new payment method' while trying to 'change-now'



  @TC_1225992 @TC_1225993 @NO-Payment-Method
  Scenario: Check behavior when RH user with expired / no Payment method added try to renew the plan from plan tab
    When RedHybrid Navigated to Plantab
    And  user clicks on Change Plan CTA
    And  I should navigate to Change plan overlay
    Then I Select Renew plan early Card and click continue CTA
    Then I should be navigated to an overlay to 'Add a new payment method' while trying to 'change-now'


  @TC_1225994 @NO-Payment-Method
  Scenario: Check behavior of "Add a new card" CTA in "Add a payment method" overlay
    When scroll to quick links
    When I click on Renew Early from quick links
    Then I should be navigated to an overlay to 'Add a new payment method' while trying to 'change-now'
    And Clicked on a add new card CTA
    And I am MVA user and logged in using full login with user name and password
    Then user should redirected to Payment full flow


  @TC_12259926 @NO-Payment-Method
  Scenario: Check behavior of back arrow in "Add a payment method" overlay
    When RedHybrid Navigated to Plantab
    And  user clicks on Change Plan CTA
    And  I should navigate to Change plan overlay
    Then I Select Renew plan early Card and click continue CTA
    Then I should be navigated to an overlay to 'Add a new payment method' while trying to 'change-now'
    And  Tap on back icon
    And  I should navigate to Change plan overlay
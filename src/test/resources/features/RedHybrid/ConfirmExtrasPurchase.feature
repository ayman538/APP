#@3G @RedHybrid
Feature: Red Hybrid - Add Extras - Confirm Extra's purchase

  Background: Launch the app using Red Hybrid user that has active plan, has payment method already added - User soft logged in
    Given  I am MVA user and logged in using Soft Login


  @TC_754348 @LOGIN
  Scenario: Check UI of Confirm your purchase overlay after tapping on "Pay Now" CTA in Barclays Webview
    Then I should be navigated to dashboard
    When I navigate to add extras overlay
    Then I should be navigated to addExtras overlay
    When I click on "Data Extra" extra
    And I Select "1GB Data Extra" from Extras List
    And I scroll Down to continue CTA
    And I click on continue CTA
    And I am MVA user and logged in using full login with user name and password
    And  I enter "258" CVV and payment passcode if needed
    Then Assert that PAY Securely CTA should be displayed
    And  Assert that Confirm your purchase overlay displayed Successfully For Extra Category "Data Extra" and extra name "1GB Data Extra" and order type "add-data"

  @TC_1019878  @LOGIN @Regression_Active_Payment
  Scenario Outline:Check the behavior when click on"Continue" CTA at Confirmation overlay E2E from add extras_Functional.
    Then I should be navigated to dashboard
    When I navigate to add extras overlay
    Then I should be navigated to addExtras overlay
    When I click on "<ExtraCategory>" extra
    And I Select "<ExtraName>" from Extras List
    And I scroll Down to continue CTA
    And I click on continue CTA
    And I am MVA user and logged in using full login with user name and password
    And  I enter "258" CVV and payment passcode if needed
    Then Assert that PAY Securely CTA should be displayed
    And  Assert that Confirm your purchase overlay displayed Successfully For Extra Category "<ExtraCategory>" and extra name "<ExtraName>" and order type "<OrderType>"
    When I clicks on Pay Securely CTA
    Then I should validate processing icon displayed successfully
    And I should validate the UI of confirmation screen of "<JourneyType>"
    When I click on continue CTA
    Then I should be navigated to dashboard
    Examples:
      | ExtraCategory                    | ExtraName                                        | OrderType  | JourneyType |
      | Data Extra                       | 1GB Data Extra                                   |  add-data  | Add Data    |
      | International Extra              | 200 International Minutes 200 destinations       |  add-extra | Add Extras  |
      | Premium Rate Credit Extra        | £5 Premium Rate Extra                            |  add-extra | Add Extras  |
      | Europe Roaming Extra             | 8-day Europe Extra 3GB                           |  add-extra | Add Extras  |
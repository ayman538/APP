Feature: View Billing FAQs Card

  Background: Start the billing dashboard
    Given I close the tutorial if displayed
    Then I should be navigated to dashboard
    When I navigate to the new billing dashboard
    And I close the billing tutorial if displayed
    Then I should see the new billing dashboard

  @TC_1292951 @Consumer @MSISDN_ending_with_even_numbers
  Scenario:  Check FAQs from Billing dashboard
    And I should see the new View Billing FAQs Card
    When I tab on View Billing FAQs Card
    Then I should be directed to Billing FAQs Webview
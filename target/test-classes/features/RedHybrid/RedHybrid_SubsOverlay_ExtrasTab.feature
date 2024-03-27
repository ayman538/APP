@3G @RedHybrid
Feature:  546216: Red Hybrid - Subscriptions Overlay - Extras tab

  Background: RedHybrid user with active plan navigated to extras tab
    Given I am MVA user and logged in using Soft Login
    And   I should be navigated to dashboard
    And   I navigate to subscriptions overlay
    When  I navigate to extras tab from subscriptions overlay

  @TC_651491 @Regression_Active_Payment
  Scenario: P1_Check the UI of extras tab in the subs overlay screen
    Then  I should be in Extras tab

  @TC_652120  @Regression_Active_Payment
  Scenario: P3_Check that pay as you go extras card is removed
    Then  I should not see Pay as You Go Card

  @TC_675600
  Scenario: Check My Extra allowances card if the user has active Extras
    Then  I should see added extras
#@3G @RedHybrid
Feature: Add Billing Address

  Background:
    Given I am MVA user and logged in using Soft Login
    And   I should be navigated to dashboard
    Given I click on payment on dashboard tray
    Given I am MVA user and logged in using full login with user name and password
    And   I remove the added payment card if exist
    And   User on Enter Valid UK Postcode screen


  @TC_469066 #1
    Scenario: Check UI of Billing address search screen
    Then Validate Add Billing Screen

  @TC_469067  @Regression_Active_NO_Payment #2
  Scenario: P1_Check app behavior when user search for his Billing Address_Functional
    Given I search for post code "BT41 1EG"
    Then I should see dropdown list with addresses

  @TC_469069 #4
  Scenario: P1_Check app behavior when selecting address from dropdown menu_Functional
    Given I search for post code "BT41 1EG"
    Then I should see dropdown list with addresses
    When I select the first address
    Then Check Address details appeared

  @TC_469073 #7
  Scenario: P1_Check App behavior when Click on X button in searching Address screen_Functional
    Given I search for post code "BT41 1EG"
    When Click On Physical Back Button
    When I click on X icon
    Then I should Validate X icon is not displayed

  @TC_469079 #12
  Scenario: P1_Check App behavior when selecting X button in Address fields screen_Functional
    Given I search for post code "BT41 1EG"
    Then I should see dropdown list with addresses
    When I select the first address
    When I click on X icon
    Then I should Validate X icon is not displayed

  @TC_469083 #16
  Scenario: P1_Check if the user tapped on Add address manually_Functional
    Given Enter address manually
    Then Check any address field -like house no- is Empty
    Then Check Continue button is dimmed when info are incomplete

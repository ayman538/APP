@3G @DXIDM
Feature: DX IDM Full Login With Phone number feature

  @3G @LoginWithPhoneNumber @single_contact  @TC_1379727
  Scenario: Validate Full Login with phone number and password with account has single contact
    Given I navigate to Username or Phone number login screen
    Then I validate username or phone number screen and Insert phone number
    And Validate Password screen and Insert Password
    Then Press All done CTA and Validate Dashboard
    When hard close the app
    And I close the tutorial if displayed
    And I navigate to Username or Phone number login screen
    Then Validate username is Auto Populated

  @3G @LoginWithPhoneNumber @multiple_contacts_different_DOB  @TC_1406460
  Scenario: Validate Full Login with phone number and password with account has multiple contacts with different DOB
    Given I navigate to Username or Phone number login screen
    Then I validate username or phone number screen and Insert phone number
    And I validate DOB screen and Insert DOB
    And Validate Password screen and Insert Password
    Then Press All done CTA and Validate Dashboard


  @3G @LoginWithPhoneNumber @multiple_contacts_same_DOB  @TC_1406536
  Scenario: Validate Full Login with phone number and password with account has multiple contacts with same DOB
    Given I navigate to Username or Phone number login screen
    Then I validate username or phone number screen and Insert phone number
    And I validate DOB screen and Insert DOB
    And I validate first and last name screen and Insert first and last name
    And Validate Password screen and Insert Password
    Then Press All done CTA and Validate Dashboard


  @3G @LoginWithPhoneNumber @single_contact @TC_1563588
  Scenario: Validate Full Login with invalid phone number or password with account has single contact
    Given I navigate to Username or Phone number login screen
    Then I validate username or phone number screen and Insert invalid phone number
    And Validate Password screen and Insert Password
    Then I validate invalid phone number or password error massage is displayed


  @3G @LoginWithPhoneNumber @multiple_contacts_different_DOB  @TC_1464456
  Scenario: Validate DOB error massage when a contact entered invalid DOB during login flow
    Given I navigate to Username or Phone number login screen
    Then I validate username or phone number screen and Insert phone number
    And I validate DOB screen and Insert invalid DOB
    Then I validate invalid DOB instant error massage is displayed

  @3G @LoginWithPhoneNumber @multiple_contacts_same_DOB  @TC_1563592
  Scenario: Validate first and last name error massage when a contact entered invalid first or last name during login flow
    Given I navigate to Username or Phone number login screen
    Then I validate username or phone number screen and Insert phone number
    And I validate DOB screen and Insert DOB
    And I validate first and last name screen and Insert invalid first and last name
    Then I validate incorrect personal details error massage is displayed
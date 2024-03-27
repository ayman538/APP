Feature: CRO simx plan change
  Background:

  Scenario: verify that the recommended Plan contains simx plan with black banner
    Given I am MVA user and logged in using Soft Login
    When Navigate to Airtime plan tab
    And I Click on See all SIMO plans CTA
    And scroll to find simx plan
    Then Validate the black banner UI

  Scenario: Validate the functionality of find out more CTA & simx tray
    Given I am MVA user and logged in using Soft Login
    When Navigate to Airtime plan tab
    And I Click on See all SIMO plans CTA
    And scroll to find simx plan
    And Validate the black banner UI
    Then I click on Find out more banner
    Then Validate simx tray

  Scenario: Validate the functionality of find out more tray CTA
    Given I am MVA user and logged in using Soft Login
    When Navigate to Airtime plan tab
    And I Click on See all SIMO plans CTA
    And scroll to find simx plan
    And Validate the black banner UI
    Then I click on Find out more banner
    Then Validate simx tray
    And Click on Find out more CTA


  Scenario: Validate the functionality of X close CTA
    Given I am MVA user and logged in using Soft Login
    When Navigate to Airtime plan tab
    And I Click on See all SIMO plans CTA
    And scroll to find simx plan
    And Validate the black banner UI
    Then I click on Find out more banner
    Then Validate simx tray
    And I click on Dismissal X CTA

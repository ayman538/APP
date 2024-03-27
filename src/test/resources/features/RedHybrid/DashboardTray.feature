 @3G @RedHybrid  @SIT_CYCLE2  @Regression_Active_Payment
Feature: Automation First || Red Hybrid - MVA - Card Management - Adding new Card
  Background:

    Given I am MVA user and logged in using Soft Login

  @TC_594219
  Scenario: Check the components of the dashboard tray
    Then Validate All Tray Components

  @TC_594222
  Scenario: Check Veryme Target
    Then Validate Veryme

  @TC_594223
  Scenario: Check TOBi
    Then I navigate to TOBi and validate it is opened then close it

  @TC_594225
  Scenario: Check Settings
    Then Validate Settings in Tray

  @TC_594221
  Scenario: Check My Account Target
    Then Validate My Account

  @TC_594224
  Scenario: Check Payment Method
    When I navigate to payment tray from Dashboard
    Then Validate Payment

@TC_806539
  Scenario: the dashboard tray hidden under My account
    Then Validate My Account
    Then Validate that the dashboard tray hidden under My account

  Scenario: the dashboard tray hidden under payments
    When click on Payments on dashboard tray
    Then Validate that the dashboard tray hidden under Payments

  Scenario: the dashboard tray hidden under settings
    When click on my Settings on dashboard tray
    Then Validate that the dashboard tray hidden under Settings




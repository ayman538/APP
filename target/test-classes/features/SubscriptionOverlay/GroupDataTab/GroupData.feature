@3G @RED
Feature: Group data for Red Leaders users

  Background:
    Given I am MVA user and logged in using Soft Login

  @REGRESSION @TC_601825 @TC_99764
  Scenario: Test Case 601825: P1 - Check Dashboard tiles for Red leader_Functional
    Then Check Dashboard tiles for Red Leader user

  @REGRESSION @TC_601826 @TC_99809
  Scenario: Test Case 601826: P1 - Check group data section_functional
    Given Navigate to Group Data tab in subsoverlay
    Then Check Group Data card in Group Data tab

  @REGRESSION @TC_601827 @TC_99820 @Android
  Scenario: Test Case 601827: P1 - Check Red leader can change limit for sharer when limit is Off and button will be dimmed until changing the limit_Functional
    Given Navigate to Group Data tab in subsoverlay
    When Navigate to Manage Group data for sharer
    Then Check Send SMS CTA is dimmed when limit is off and enabled after changing the limit
    Then Check Send SMS CTA redirects to SMS screen

  @TC_601827 @TC_99820 @IOS
  Scenario: Test Case 601827: P1 - Check Red leader can change limit for sharer when limit is Off and button will be dimmed until changing the limit_Functional in IOS
    Given Navigate to Group Data tab in subsoverlay
    When Navigate to Manage Group data for sharer
    Then Check Send SMS CTA is dimmed when limit is off and enabled after changing the limit

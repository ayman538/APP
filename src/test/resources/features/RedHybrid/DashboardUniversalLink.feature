@4G @WIFI
Feature: Dashboard Universal Link

  @TC_634510 @HasActivePlan
  Scenario: User has  The App Installed with active plan
    Given Soft Close App
    And User Has Accessed The Universal Link
    Then User Should Navigate To Dashboard and has active plan

  @TC_634515 @HasNoActivePlan
  Scenario: User has  The App Installed with no active plan
    Given Soft Close App
    And User Has Accessed The Universal Link
    Then User Should Navigate To Dashboard and has no active plan



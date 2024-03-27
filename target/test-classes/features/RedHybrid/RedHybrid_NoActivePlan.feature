@REDHYBRID @SIT_CYCLE2 @3G

Feature: RedHybrid No Active Plan Feature

  Background: RedHybrid No Active Plan
    Given I am MVA user and logged in using Soft Login

    @TC_580896
    Scenario: 540026.01_P1_check the dashboard items for Red Hybrid user that has no active plan _FUNC
      When User Lands On Dashboard
      Then Validate Dashboard Cards
      And Validate Dashboard Tray Icons
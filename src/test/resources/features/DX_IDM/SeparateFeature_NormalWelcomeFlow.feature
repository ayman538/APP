@WIFI @3G @DXIDM
Feature: Normal DX IDM welcome flow feature

  @SeparateFeatureWelcomeFlowTests
  Scenario: Validate Welcome screen content
    Given Welcome to My vodafone screen is displayed
    Then Validate Welcome screen content

  Scenario: Validate Privacy screen content and functionality
    Given Privacy screen is displayed
    Then Validate Privacy screen content
    And Validate Privacy screen Func

  Scenario: Validate Permission screen content
    Given Permission screen is displayed
    Then Validate Permission screen content

  @TC_1079458 @SeparateFeatureWelcomeFlowTests
  Scenario: Validate Usage Access popup content
    Given Click Continue in Welcome screen
    And Click Continue in privacy screen
    And Click Continue in permission screen without dismissing usage popup
    When Usage access popup is displayed
    Then Validate Usage access popup content

  Scenario: Validate Login screen content
    Given Login screen is displayed
    Then Validate Login screen content


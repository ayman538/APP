Feature: Connected Apps
  Background:
    Given I am MVA user and logged in using Soft Login

  @SANITY @REGRESSION @MPS @TC_601790 @TC_86703 @3G
  Scenario: Test Case 601790: P1 - Check UI of connected apps section (icon - title - button)_UI
    Given Scroll down and check Connected apps Images
    Then Check Connected apps Titles
    And Check Connected apps text and order


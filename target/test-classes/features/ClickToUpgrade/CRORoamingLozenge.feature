Feature: Roaming lozenge

  Scenario: Check variant UI for 51 & 83 roaming includes plans

    Given I am MVA user and logged in using Soft Login
    When Navigate to SubsOverlay
    And I Click on View Recommended plans CTA
    And compare roaming details

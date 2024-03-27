Feature: Recommended Plan Card


  @TC_632540 @REGRESSION @MPS
  Scenario: verify that the recommended Plan contains the correct details
    Given the user navigates to the recommended plans page using deep link
    Then the recommended plan card contains the correct details


    @TC_1204769 @REGRESSION @MPS
    Scenario: Validate The functionality of Check Upgrade Eligibility in Error screen for not eligible upgrade for SIMO/FLEX upgrade
      Given I am MVA user and logged in using Soft Login
      Then The User is not eligible To upgrade
      Then I Click on Back to Dashboard
      And Validate Dashboard displayed
      Then The User is not eligible To upgrade
      Then I close the error screen
      And Validate Dashboard displayed
      Then The User is not eligible To upgrade
      Then Validate Clicking On Check Upgrade Eligibility Redirect To Subsoverlay


  @TC_1204769
  Scenario: Validate The functionality of Back to Dashboard in Error screen for not eligible upgrade for SIMO/FLEX upgrade
    Given I am MVA user and logged in using Soft Login
    Then The User is not eligible To upgrade
    Then I Click on Back to Dashboard
    And Validate Dashboard displayed

  @TC_1204769
  Scenario: Validate The functionality of X CTA in Error screen for not eligible upgrade for SIMO/FLEX upgrade
    Given I am MVA user and logged in using Soft Login
    Then The User is not eligible To upgrade
    Then I close the error screen
    And Validate Dashboard displayed

  @1843968
  Scenario: Validate for the price increase copies in the Recommended plans screen
    Given I am MVA user and logged in using Soft Login
    When the user navigates to the recommended plans page using deep link
    And I click on show more plans CTA
    Then I should see the price increase copies for the recommended plans & more plans sections


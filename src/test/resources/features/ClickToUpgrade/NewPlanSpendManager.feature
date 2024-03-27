Feature: C2U New plan Spend Manager

  Background:
    Given I am MVA user and logged in using full login with user name and password
    When the user navigates to the recommended plans page
    And the user selects a specific plan
    And the user redirected to the new plan page
    And Scroll Down till the end of the page


    @TC_790055
  Scenario: Verify the Title is Displayed Correctly and There's a Descriptive Text below
    Then Verify The Title
    And Verify The Descriptive Text Exist


      @TC_790060
  Scenario: Verify The Price
    Then Verify The Price Label Is Correct
    And Verify The Plan Price Exist
    And Verify The Plan Price Cycle Per Month


        @TC_790063
  Scenario: Verify The Spend Limit
    Then Verify The Spend Limit Label Exist
    And Validate The Default Value For Spend Limit Menu




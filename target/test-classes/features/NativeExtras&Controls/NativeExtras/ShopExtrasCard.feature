Feature: Shop Extras Card

  @TC_1030925 @3G @CONSUMER @MPS
  Scenario: 990743.01_P1_Check the existence of the "Shop Extras" card in the "Extras" tab using softlogged MPS consumer user_UI
    Given I am MVA user and logged in using Soft Login
    And I close the tutorial if displayed
    And I should be navigated to dashboard
    And I click on the Native Add Extras tile
    When I should be navigated to the Native Extras tab
    Then I should see the shop extras card

    @TC_1030926 @UFL @CONSUMER @MPS @LOGIN
    Scenario: 990743.02_P1_ Check the content of the "Shop Extras" card in the "Extras" tab using UFL MPS soletrader user_UI
      Given I am MVA user and upfront logged in using user name and password
      And  I should be navigated to dashboard
      And I click on the Native Add Extras tile
      When I should be navigated to the Native Extras tab
      Then I should the shop Extras Card Details

    @TC_1030927 @3G @CONSUMER @MPS @LOGIN
    Scenario: 990743.03_P1_ Check the categories available under "Shop Extras" card in the "Extras" tab using FL MPS consumer user_UI
      Given I am MVA user and logged in using full login with user name and password
      And I close the tutorial if displayed
      And I should be navigated to dashboard
      And I click on the Native Add Extras tile
      When I should be navigated to the Native Extras tab
      Then I should shop extras categories








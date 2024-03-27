@3G @RedHybrid
Feature: Add Billing Address

  Background:
    Given I am MVA user and logged in using Soft Login
    And I add a valid payment method to RH User With address details "10,Downing Street" "LONDON" "United Kingdom" "3" "HouseName" "3" "SW1A 2AA" "Downing Street" and payment details "ayman" "4819000000000250" "1" "23" "258"
    When Click on add data tile from dashboard

    @TC_721994
    Scenario: Check the calling of MVAX APi listExtra when tapping on "Add Data" tile from Dashboard tiles_Functional
      Then Assert that Add Data overlay should be displayed

      @TC_722007  @Regression_Active_Payment
      Scenario: Check UI of "Add Data" overlay after tapping on "Add Data" tile from Dashboard tiles
        Then Assert that Add Data overlay UI should be displayed correctly
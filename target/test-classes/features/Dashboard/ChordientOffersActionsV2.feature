#TODO: this feature and logic need to revisit as we need to check first if the user has offers returned or not and merge this file wil discover feature
Feature: Discover Offers V2 actions

  Background: Initialize Discover Offers V2

  Given I am MVA user and logged in using Soft Login

  @TC_675448
  Scenario: TC01_Check app behavior when Chordiant offer is accepted from Discover section_Functional
    When user has a chordiant offer
    And  scroll down to discover section then accept the first offer
    Then offer is displayed successfully


  @TC_675449
  Scenario: TC02_Check app behavior when a Chordiant offer is declined in Discover section_Functional
    When user has a chordiant offer
    And  scroll down to discover section then dismiss the first offer
    Then offer is disappeared

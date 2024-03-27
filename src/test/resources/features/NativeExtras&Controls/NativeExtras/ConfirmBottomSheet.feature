Feature: Confirm Bottom Sheet for Native Extras

  @TC_1050160 @3G @CONSUMER @MPS @LOGIN
  Scenario: Check the behavior when clicking on "Continue" CTA of the category bottom sheet
    Given I am MVA user and logged in using full login with user name and password
    And I close the tutorial if displayed
    And I should be navigated to dashboard
    And I click on the Native Add Extras tile
    When I should be navigated to the Native Extras tab
    And I click on the "Roaming"
    And I should be navigated to "Roaming" Category Bottom Screen
    And I select one of the extras on Category Bottom Sheet
    And I clicks on Continue CTA
    Then I should be navigated to the "Roaming" Confirm Bottom Sheet

  @TC_1050161 @3G @CONSUMER @MPS
  Scenario: Check the content of the confirm bottom sheet
    Given I am MVA user and logged in using Soft Login
    And I close the tutorial if displayed
    And I should be navigated to dashboard
    And I click on the Native Add Extras tile
    When I should be navigated to the Native Extras tab
    And I click on the "Roaming"
    And I should be navigated to "Roaming" Category Bottom Screen
    And I select one of the extras on Category Bottom Sheet
    And I clicks on Continue CTA
    And I should be navigated to the "Roaming" Confirm Bottom Sheet
    Then I should see "Roaming" Confirm Bottom Content

  @TC_1050162 @3G @Soletrader @MPS @LOGIN
  Scenario: Check the behavior when clicking on <- back CTA on the Confirm bottom sheet
    Given I am MVA user and logged in using full login with user name and password
    And I close the tutorial if displayed
    And I should be navigated to dashboard
    And I click on the Native Add Extras tile
    When I should be navigated to the Native Extras tab
    And I click on the "Roaming"
    And I should be navigated to "Roaming" Category Bottom Screen
    And I select one of the extras on Category Bottom Sheet
    And I clicks on Continue CTA
    And I should be navigated to the "Roaming" Confirm Bottom Sheet
    And I click on the back arrow icon on the Confirm Bottom Sheet
    Then I should be navigated to "Roaming" Category Bottom Screen

  @TC_1050164 @3G @CONSUMER @MPS @LOGIN
  Scenario: Check the behavior when clicking on X CTA on the Confirm bottom sheet
    Given I am MVA user and upfront logged in using user name and password
    And I close the tutorial if displayed
    And I should be navigated to dashboard
    And I click on the Native Add Extras tile
    When I should be navigated to the Native Extras tab
    And I click on the "Roaming"
    And I should be navigated to "Roaming" Category Bottom Screen
    And I select one of the extras on Category Bottom Sheet
    And I clicks on Continue CTA
    And I should be navigated to the "Roaming" Confirm Bottom Sheet
    When I click on X CTA
    Then I should be navigated to the Native Extras tab


  @TC_1327027 @MPS @LOGIN @CONSUMER
  Scenario: Check the behavior when clicking on any of the categories that has only one sub category using a FL MPS soletrader user
    Given I am MVA user and logged in using Soft Login
    And I close the tutorial if displayed
    And I should be navigated to dashboard
    And I click on the Native Add Extras tile
    When I should be navigated to the Native Extras tab
    And I click on the "Roaming"
    Then I should be navigated to the "Roaming" Confirm Bottom Sheet
    And I should see "Roaming" Confirm Bottom Content


  @TC_1327028 @CONSUMER @MPS @WIFI @LOGIN
  Scenario: Check the behavior when clicking on "Secure Net" category using a UFL MPS consumer user_Functional
    Given I am MVA user and logged in using full login with user name and password
    And I close the tutorial if displayed
    And I should be navigated to dashboard
    And I click on the Native Add Extras tile
    When I should be navigated to the Native Extras tab
    And I click on the "Secure Net"
    Then I should see "Secure Net" Confirm Bottom Content

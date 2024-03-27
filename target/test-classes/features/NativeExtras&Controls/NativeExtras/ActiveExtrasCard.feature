Feature: Active Extra Card

  @TC_976783 @3G @CONSUMER @MPS
  Scenario: 866551.02_P1_Check the content of the "Active extras" card in the "Extras" tab, when clicking on "Add Extras" tile from the subsoverlay using softlogged Soletrader user_UI
    Given I am MVA user and logged in using Soft Login
    And I close the tutorial if displayed
    And I click on the Native Add Extras tile
    When I should be navigated to the Native Extras tab
    Then I should see active extras Details


  @TC_976849 @3G @CONSUMER @MPS @LOGIN
  Scenario: 866551.03_P1_Check the behavior when clicking on "Find out more" CTA of the "Active extras" card in the "Extras" tab using FL consumer user_Functional
    Given I am MVA user and logged in using full login with user name and password
    And I close the tutorial if displayed
    And I should be navigated to dashboard
    And I click on the Native Add Extras tile
    When I should be navigated to the Native Extras tab
    Then I should see description of active extra after clicking Find Out CTA

  @TC_1886044 @3G @CONSUMER @MPS
  Scenario: 1883470_01_P1.Check the existence of "Manage in the Secure Net App" CTA for "Vodafone Secure Net" extra on the Extras subsoverlay tab using a FL MPS soletrader user
    Given I am MVA user and logged in using Soft Login
    #The user used should have no extras other than Secure Net (E7: 447879915305)
    And I close the tutorial if displayed
    And I click on the Native Add Extras tile
    When I should be navigated to the Native Extras tab
    And I scroll down to Secure Net extra
    Then I should see Secure Net updated CTA and details

  @TC_1886071 @3G @CONSUMER @MPS
  Scenario: 1883470_04_P1.Check the "Find out more" description copy change under the "Vodafone Secure Net" extra using a softlogged Red leader user
    Given I am MVA user and logged in using Soft Login
    #The user used should have no extras other than Secure Net (E7: 447879915305)
    And I close the tutorial if displayed
    And I click on the Native Add Extras tile
    When I should be navigated to the Native Extras tab
    And I scroll down to Secure Net extra
    Then I should see Secure Net updated description

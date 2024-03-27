Feature: Thank you bottom sheet

  @TC_1050171 @TC_TC_1050170 @3G @CONSUMER @MPS @LOGIN
    Scenario: 990761.02_P1_Check the behavior when clicking on "Buy" CTA of the confirm bottom sheet using a FL MPS child consumer user_Functional
      Given I am MVA user and logged in using full login with user name and password
      And I close the tutorial if displayed
      And  I should be navigated to dashboard
      And click on my account
    And I navigate to sub switch to SubscriptionType "MPS" and Segment "Consumer"
      And I click on the Native Add Extras tile
      And I should be navigated to the Native Extras tab
      And I click on the "Data"
      And I should be navigated to "Data" Category Bottom Screen
      And I select one of the extras on Category Bottom Sheet
      And I clicks on Continue CTA
      And I should be navigated to the "Data" Confirm Bottom Sheet
      When I click on Buy CTA
      Then I should see the Thank you bottom sheet details

  @TC_1050173 @3G @CONSUMER @MPS @LOGIN
    Scenario: 990761.04_P1_ Check the content of the Thank you bottom sheet when clicking on Buy CTA after selecting the required extra from the category bottom sheet using a FL MPS consumer user_UI
      Given I am MVA user and logged in using full login with user name and password
      And I close the tutorial if displayed
      And I should be navigated to dashboard
      And I click on the Native Add Extras tile
      And I should be navigated to the Native Extras tab
      And I click on the "Calling"
      And I should be navigated to "Calling" Category Bottom Screen
      And I select one of the extras on Category Bottom Sheet
      And I clicks on Continue CTA
      And I should be navigated to the "Calling" Confirm Bottom Sheet
      When I click on Buy CTA
      Then I should see the Thank you bottom sheet details

  @TC_1050176 @CONSUMER @MPS @UFL
    Scenario: 990761.06_P1_ Check the behavior when clicking on "Continue" CTA on the Thank you bottom sheet using a UFL MPS consumer user_Functional
      Given I am MVA user and logged in using full login with user name and password
      And I close the tutorial if displayed
      And I should be navigated to dashboard
      And I click on the Native Add Extras tile
      And I should be navigated to the Native Extras tab
      And I click on the "Calling"
      And I should be navigated to "Calling" Category Bottom Screen
      And I select one of the extras on Category Bottom Sheet
      And I clicks on Continue CTA
      And I should be navigated to the "Calling" Confirm Bottom Sheet
      And I click on Buy CTA
      And I should see the Thank you bottom sheet details
      When I clicks on Continue CTA
      Then I should see added extra under Active Extras with pending status


  @TC_1050174 @3G @Soletrader @MPS @LOGIN
    Scenario: 990761.05_P2_ Check the behavior when clicking on X CTA on the Thank you bottom sheet using FL MPS soletrader user_Functional
      Given I am MVA user and logged in using full login with user name and password
      And I close the tutorial if displayed
      And  I should be navigated to dashboard
      And I click on the Native Add Extras tile
      And I should be navigated to the Native Extras tab
      And I click on the "Business Extras"
      And I should be navigated to "Business Extras" Category Bottom Screen
      And I select one of the extras on Category Bottom Sheet
      And I clicks on Continue CTA
      And I should be navigated to the "Business Extras" Confirm Bottom Sheet
      And I click on Buy CTA
      And I should see the Thank you bottom sheet details
      When I Click on X CTA on Thank you bottom sheet
      Then I should see added extra under Active Extras with pending status





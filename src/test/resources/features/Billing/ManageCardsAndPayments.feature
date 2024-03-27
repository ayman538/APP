Feature: Manage Cards and Payments

Background: Initialize The Billing Dashboard
Given I close the tutorial if displayed
And I am MVA user and logged in using full login with user name and password
Then I should be navigated to dashboard
When I navigate to the new billing dashboard
And I close the billing tutorial if displayed
Then I should see the new billing dashboard

@1327130
Scenario: Validate "Manage cards and payments" chevron
  Given I should see Manage cards and payments card
  When I click on Manage cards and payments chevron
  Then I should be navigated to manage payments webview

@TC_1932221 @Service_User
Scenario: Test Case 1932221: 1876220.01.P1_Check the existence of "Manage cards & payments" card while opening Native Billing screen using a Softlogged in Service User
  Then I should NOT see Manage cards & payments card as a service user


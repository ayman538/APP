Feature: Strategic Trade in -VF Customers-

  As a VF customer on 10.22 and above and on any mobile device,
  I want to be able to run the trade in diagnostics journey starting from the VF customers dashboard,
  so that I can find out if my device is eligible for the Strategic trade in promotion.

  Background:
    Given Skip Login

  @TC_418787
  Scenario: verify that the user can access strategic trade in from assistance link
    When the user clicks on trade in tool assistance link
    Then the user redirected to strategic diagnostic page


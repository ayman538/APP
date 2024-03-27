Feature: Strategic Trade in -NON VF Customers-

  As a NON VF customer on 10.22 and above and on any mobile device,
  I want to be able to start the trade in diagnostics journey starting from the non VF customers dashboard,
  so that I can find out if my device is eligible for the strategic trade in promotion.

  Background:
    Given non VF user at acquisition dashboard

  @TC_419009
  Scenario: verify that the user can start strategic trade in from acquisition dashboard discover tile
    When the user clicks on strategic trade in at discover tile
    Then the user redirected to strategic diagnostic page

  @TC_419114
  Scenario: Verify that the trade in icon navigates to the strategic diagnostic page
    When the user clicks on Trade in Icon
    Then the user redirected to strategic diagnostic page

   
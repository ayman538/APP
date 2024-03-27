#@3G @RedHybrid
Feature:  546193: Red Hybrid - Dashboard - Extras list overlay
  Background: Launching App using Red Hybrid User that has active plan
    Given I am MVA user and logged in using Soft Login


  @TC_716296
  Scenario: Check App behavior in case of tapping on "Add extras" tile from Dashboard tiles_Functional
    Given  user is on dashboard
    When   I navigate to add extras overlay
    Then   I should be navigated to addExtras overlay

  @TC_719215
  Scenario: Check UI of  "Add extras" overlay after tapping on "Add extras" tile from Dashboard tiles_UI
    Given  user is on dashboard
    When   I navigate to add extras overlay
    Then   addExtras UI should comply with the response of the MVAX API listExtras


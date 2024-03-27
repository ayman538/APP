#@3G @RedHybrid
Feature:  Red Hybrid - Subscriptions Overlay - Extras tab - Extras list overlay

  Background: Launching App using Red Hybrid User that has active plan
    Given I am MVA user and logged in using Soft Login


  @TC_720193
  Scenario: Check App behavior in case of tapping on "Buy extras" CTA from Extras tab_Functional
    Given  user is on dashboard
    When   RedHybrid Navigated to Plantab
    And    user click on Extras Tab from subsOverlay
    And    validate that Extras Tab opens
    And    click on Buy Extras
    Then   I should be navigated to addExtras overlay

  @TC_720219 @Regression_Active_Payment
  Scenario: Check UI of "Add extras" overlay after tapping on "Buy extras" CTA from Extras tab_UI
    Given  user is on dashboard
    When   RedHybrid Navigated to Plantab
    And    user click on Extras Tab from subsOverlay
    And    validate that Extras Tab opens
    And    click on Buy Extras
    And    I should be navigated to addExtras overlay
    Then   addExtras UI should comply with the response of the MVAX API listExtras



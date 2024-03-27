Feature: Deep link

  @TC_601992  @3G  @REGRESSION  @MPS
  Scenario: Check deeplink while app in foreground/background/terminated _Functional
   Given I am MVA user and logged in using Soft Login
    When I should be navigated to dashboard
    Then I should tap on speed checker Deeplink
    When I put the app in background
   Then I should tap on speed checker Deeplink
    When HardClose the App
   Then I should tap on speed checker Deeplink


@tut
Feature: Tutorial Screen

  @OnePlatfrom_Tutorial
  @TC_611168 @TC_611280
  Scenario: Check tutorial UI
    Given I am MVA user and logged in using Soft Login
    When Go to Dashboard
    And HardClose the App and Relaunch
    Then Validate tutorial first screen
    Then Click on Close tutorial CTA

  @OnePlatfrom_Tutorial
  @TC_611122 @TC_611280
  Scenario: Check tutorial appearance after Full login
    Given I am MVA user and logged in using full login with user name and password
    And HardClose the App and Relaunch
    Then Validate tutorial first screen
    Then Validate tutorial second screen
    Then Click on Close tutorial CTA

  @OnePlatfrom_Tutorial
  @PAYM
  @SANITY @TC_611214 @TC_618989 @TC_611052 @TC_630439 @3G @REGRESSION @MPS
  Scenario: Check Ordering for PAYM users
    When Go to Dashboard
    And HardClose the App and Relaunch
    Then Validate tutorial first screen
    Then Validate tutorial second screen
    Then Validate tutorial third screen
    Then Validate tutorial forth screen
    Then Click on Go to Dashboard CTA

  @OnePlatfrom_Tutorial @PAYG @SANITY @TC_611191 @TC_618989 @TC_611052 @TC_630450 @3G @REGRESSION
  Scenario: Check Ordering for PAYG users
    Given Go to Dashboard
    When HardClose the App and Relaunch
    Then Validate tutorial first screen
    Then Validate tutorial second screen
    Then Validate tutorial third screen
    Then Click on Go to Dashboard CTA

  @OnePlatfrom_Tutorial
  @RedHybrid @TC_556930 @TC_556935
  Scenario: Check RedHybrdid Tutorials
    Given Go to Dashboard
    When HardClose the App and Relaunch
    Then Check RedHybrid Tutorial Screens
    Then Close Tutorial and Validate Dashboard will be displayed

## For regression scenarios only
#  @OnePlatfrom_Tutorial
#  @PAYM
#  @TC_611052 @TC_611214 @TC_618989 @TC_611168 @TC_611122 @TC_611280
#  Scenario: Check Ordering for PAYM users
#    Given I am MVA user and logged in using full login with user name and password
#    When Go to Dashboard
#    And HardClose the App and Relaunch
#    Then Validate tutorial first screen
#    Then Validate tutorial second screen
#    Then Validate tutorial third screen
#    Then Validate tutorial forth screen
#    Then Click on Go to Dashboard CTA
#
#  @OnePlatfrom_Tutorial
#  @PAYG
#  @TC_611052 @TC_611191 @TC_618989
#  Scenario: Check Ordering for PAYG users
#    Given Go to Dashboard
#    When HardClose the App and Relaunch
#    Then Validate tutorial first screen
#    Then Validate tutorial second screen
#    Then Validate tutorial third screen
#    Then Click on Go to Dashboard CTA

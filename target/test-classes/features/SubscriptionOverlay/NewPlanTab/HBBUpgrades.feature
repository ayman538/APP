@MPS
Feature: HBB Upgrades

  Background: Initialize HBB Upgrades
    Given User full login

  @TC_817075 @TC_817093 @TC_983662 @TC_983663 @SubswitchToHBB @LOGIN @Special @REGRESSION
  Scenario: Check HBB Upgrades eligibility card UI and CTA behavior
    Given Click on My account tray
    And I navigate to sub switch to SubscriptionType "BB" and Segment "CONSUMER"
    When user clicks on Your Plan control tile
    Then Validate HBB Upgrade Eligibility Card
    When I Click on Check Upgrade Eligibility CTA
    Then I should be directed to the Upgrade Eligibility Check journey

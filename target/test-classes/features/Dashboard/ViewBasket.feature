@3G  @CONSUMER @SOLETRADER @SMB @LOGIN
Feature: ViewBasket
Background: Check user is fully logged in and close tutorial if existing
  Given I close the tutorial if displayed
  Given I am MVA user and logged in using full login with user name and password

  @TC_1036289   @userHasNoItemsInBasket
  Scenario: TC01_Validate E-shop Journey for PayM/SMB/SoleTrader/Bingo users
    When I should view a Basket icon With No Counter is at the top of the dashboard
    And I Click on Basket at the top of the dashboard
    Then I should navigate to the Shop custom tab Screen

  @TC_1036140   @userHasItemsInBasket
  Scenario: TC01_Validate Basket Journey for PayM/SMB/SoleTrader/Bingo users
    When I should view a Basket icon With Counter is at the top of the dashboard
    And I Click on Basket at the top of the dashboard
    Then I should navigate to the User's Basket Webpage

  @925083
  Scenario: TC03_Validate Basket View for PayM child user
    Given Click on my account
    And  I navigate to PayM child
    Then I should not view a Basket icon at the top of the dashboard

  @921707 @921708
  Scenario: TC04_Validate Basket View for for FLN/HBB child user
    Given Click on my account
     And  SwitchToSubscriptionFLN
     Then I should not view a Basket icon at the top of the dashboard
     And Click on my account
     When The user switch to subscription HBB
     Then I should not view a Basket icon at the top of the dashboard






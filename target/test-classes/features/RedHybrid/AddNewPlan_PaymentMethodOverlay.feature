@3G @RedHybrid
Feature: 544558 - Red Hybrid - Add new plan - Payment Method overlay

  Background: Launch the app using Red Hybrid user that has no plan purchased, has payment method already added and user landed on "Add a new plan" overlay with a plan selected  - User soft logged in
    Given I am MVA user and logged in using Soft Login

  @TC_634430 @No_Plan_User
  Scenario: Check App behavior in case of tapping on Continue CTA in "Add new plan" overlay _Functional
    Given user is on dashboard
    When  I should see the no plan added card
    And   I click on tap here to select a plan
    And   I should be navigated to Add New Plan screen with default plan selected
    And   I clicks on Add New Plan screen Continue CTA
    And   User full login
    Then  I should be navigated to Payment Method screen

  @TC_634451
  Scenario: P1_Check App behavior in case of tapping on Continue CTA in "Add new plan" overlay with Full logged in user_Functional.
    Given user is on dashboard
    When  I should see the no plan added card
    And   I click on tap here to select a plan
    And   I should be navigated to Add New Plan screen with default plan selected
    And   I clicks on Add New Plan screen Continue CTA
    Then  I should be navigated to Payment Method screen

  @TC_1004712
  Scenario: P1_Check the UI of cell when user has one promoted plan or more
    Given I should be navigated to dashboard
    When  I should see the no plan added card
    And   I click on tap here to select a plan
    And   I should be navigated to Add New Plan screen with default plan selected
    Then Check the UI of cell when user has one promoted plan or more

  @TC_1038645  @TC_1038647  @TC_1038672
  Scenario: P1_Check the Extras tab, usage tab and usage card are reflected adds a plan that has promotion _FUN
    Given I should be navigated to dashboard
    When I Should see usage card
    And I navigate to plan tab from Dashboard
    And I navigate to usage tab from subscriptions overlay
    Then I should see added extras
    And I navigate to extras tab from subscriptions overlay
    Then I should see added extras


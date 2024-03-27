@3G
Feature: OneNumber Card

  Scenario: TC01_Validate_OneCardImage
    Given I am a Red Hybrid user And Skip Login
    And Click on Your Plan and Navigate to OneNumber Card
    Then Validate OneNumber card image

  Scenario: TC02_Validate_OneCardTitle
    Given I am a Red Hybrid user And Skip Login
    And Click on Your Plan and Navigate to OneNumber Card
    Then Validate OneNumber card title

  Scenario: TC03_Validate_OneCardDescription
    Given I am a Red Hybrid user And Skip Login
    And Click on Your Plan and Navigate to OneNumber Card
    Then Validate OneNumber card description

  Scenario: TC04_Validate_OneCardCTAsDisplayed
    Given I am a Red Hybrid user And Skip Login
    And Click on Your Plan and Navigate to OneNumber Card
    Then Validate OneNumber card button is displayed


  @TC_601878 @REGRESSION @MPS
  Scenario: Check "Get Connected" and "Find out more" CTAs in One Number card opens in Custom tab
    Given I am MVA user and logged in using Soft Login
    And Click on Your Plan and Navigate to OneNumber Card
    When Click on Get Connected CTA
    Then Assert that Get Connected WebView is Displayed Successfully

  @TC_601878  @REGRESSION @ONENUMBER
  Scenario: Check Find out more CTA in One Number card opens in Custom tab
    Given I am MVA user and logged in using Soft Login
    And Click on Your Plan and Navigate to OneNumber Card
    When Click on Find out more CTA
    Then Assert that Find Out More WebView is Displayed Successfully

  @TC_1920233 @TC_1922794 @MPS
  Scenario: Check the new One Number card title & body
    Given I am MVA user and logged in using Soft Login
    And Click on Your Plan and Navigate to the new OneNumber Card
    Then I should see title, body & number of connections for this user
    When I click on Add a connection CTA if the user has less than 3 connections
    And I should be redirected to OneNumber Portal
    Then Closing the portal should redirect to plan tab with subscription state tray

  @Paym @TC_1984026 @TC_1984063 @TC_1984066 @TC_1984072 @TC_1984069
  Scenario: Check the content of agreement section in one number subscription details tray
    Given I am MVA user and logged in using Soft Login
    And Click on Your Plan and Navigate to the new OneNumber Card
    When I click on View details CTA for first subscription card
    Then I should be navigated to Manage subscription bottom sheet
    And I should see agreement section and Manage connection CTA
    When I click on tooltip icon
    Then Validate tooltip content
    When I click on toolTip thanks CTA
    And I click on Manage connection CTA
    Then I should be redirected to OneNumber Portal
    And Closing the portal should redirect to plan tab with subscription state tray
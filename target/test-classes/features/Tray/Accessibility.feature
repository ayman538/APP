@@CONSUMER @SOLETRADER @LOGIN
Feature:Accessibility Options

  Background: Initialize Setting Drawer and Account Setting
    Given I am MVA user and logged in using Soft Login
    And I should be navigated to dashboard
    And I navigate to settings from dashboard tray
    And Click on Account Setting

    @TC_726312
    Scenario: validate Accessibility item on account setting screen
      Then Validate Accessibility Options item

  @TC_726318
  Scenario: Validate that Accessibility Open reinvent eCare link
    When click on Accessibility
    And click on accept it in The Cookie permission message
    And Enter Username And Password
    And Chose Login Preference And Click Ok All Done
    Then Validate Accessibility SSO is opened
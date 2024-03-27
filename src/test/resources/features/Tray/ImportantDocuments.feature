Feature: Important Documents item

  Background: Initialize Setting Drawer and Account Setting
    Given I am MVA user and logged in using Soft Login
    And I should be navigated to dashboard
    And I navigate to settings from dashboard tray
    And Click on Account Setting

  @TC_696236
  Scenario: validate Important Document item on account setting screen
    Then Validate Important Documents

    @TC_696237
    Scenario: Validate that Important Documents Open reinvent eCare link
      When click on important documents
      And click on accept it in The Cookie permission message
      And Enter Username And Password
      And Chose Login Preference And Click Ok All Done
      Then Validate Important Documents SSO is opened
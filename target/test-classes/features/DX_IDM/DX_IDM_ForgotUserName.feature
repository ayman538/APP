@3G @DXIDM
Feature: DX IDM Full Login feature

  @TC_530031 @TC_519672 @TC_567955 @TC_630908 @REGRESSION @MPS
  Scenario: Test Case 519672: 310590.01_P1_Check "Forgotten username" Link behavior for softlogged PayM Simple User on the "Enter user name" Screen_FUNC
    Given soft login
    And Tap on My Account
    When Accept cookies
    And Tap on forgot username
    And Enter pin screen is displayed and enter the four fields then click on continue
    Then Validate thanks for Verifying Screen
    Then Validate username is Auto Populated


  @TC_519673 @TC_567956 @TC_630909 @MPS @Special @ComplexUser
  Scenario: Test Case 519673: 310590.02_P1_Check "Forgotten username" Link behavior for softlogged PayM Complex User on the "Enter user name" Screen_FUNC
    Given soft login
    And Tap on My Account
    When Accept cookies
    And Tap on forgot username
    And enter first and second name
    And Enter pin screen is displayed and enter the four fields then click on continue
    Then Validate thanks for verifying screen
    Then Validate username is Auto Populated

  @TC_519690 @TC_567959 @TC_567960
  Scenario: Test Case 519690: 310590.07_P1_Check the behavior for using a Forgotten username Deep link when using a PayM softlogged user_FUNC
    Given Tap on universal link
    Then Enter pin screen is displayed and enter the four fields then click on continue


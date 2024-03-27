@DX_IDM @CONSUMER
Feature: DX IDM change pin feature

  Scenario: Validate Change pin option is displayed
    Given Account settings screen is displayed
    Then Validate Change pin option is displayed

  Scenario: Validate change pin link functionality
    Given Change pin is displayed in account settings
    Then Validate Enter pin screen is displayed

  @TC_530851
  Scenario: Validate Enter pin functionality
    Given Enter pin screen is displayed
    Then Validate Enter pin screen four fields

  @TC_530852
  Scenario: Validate Re-Enter pin functionality
    Given Re-Enter pin screen is displayed
    Then Validate Re-Enter pin screen four fields

  @TC_530853
  Scenario: Validate pin successfully updated
    Given pin successfully updated screen is displayed
    Then Validate pin successfully updated screen Content

  @LoginWithPIN @TC_530857 @TC_530858
  Scenario: 485354 - Validate change pin when user set preference as PIN
    Given user logged with PIN and HardClose the app
    When Click on setting from tray then click on account settings then click on change pin
    Then PIN Screen Displayed
    When Enter Valid PIN and Click on Continue
    Then Enter pin screen is displayed and enter the four fields then click on continue
    Then Re-Enter pin screen is displayed and enter the four fields then click on continue
    Then pin successfully updated screen is displayed
    Then Validate pin successfully updated screen Content

  @LoginWithPIN
  @TC_485523 @TC_530879 @TC_530881 @TC_530025 @TC_530024
  Scenario: 485523 - Verify User can login successfully with the new pin after pin change
    Given user logged with PIN and HardClose the app
    When Click on My Account
    Then PIN Screen Displayed
    When Enter Valid PIN and Click on Continue
    Then User should see my account tray

  @LoginWithUsername/Password
  @TC_485390 @TC_530880 @TC_530881
  Scenario: 485390 - Validate change pin when user set preference as username/password when hardClose the app
    Given HardClose the app after set preference as username and password
    When Click on setting from tray then click on account settings then click on change pin
    Then Password screen is display and insert valid password then click on continue
    Then Enter pin screen is displayed and enter the four fields then click on continue
    Then Re-Enter pin screen is displayed and enter the four fields then click on continue
    Then pin successfully updated screen is displayed
    Then Validate pin successfully updated screen Content

  @LoginWithUsername/Password
  @TC_486368
  Scenario: 486368 - Validate change pin when user set preference as username/password
    Given Change pin is displayed in account settings
    Then Password screen is display and insert valid password then click on continue
    Then Enter pin screen is displayed and enter the four fields then click on continue
    Then Re-Enter pin screen is displayed and enter the four fields then click on continue
    Then pin successfully updated screen is displayed
    Then Validate pin successfully updated screen Content

  @TC_485525
  Scenario: 485525 - Validate X icon on change pin screen
    Given Change pin is displayed in account settings
    When Enter Valid PIN and Click on Continue
    Then Click on X icon on Enter pin screen









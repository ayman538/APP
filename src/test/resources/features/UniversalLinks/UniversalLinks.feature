@3G
Feature: Universal Link

  Background:

    Given I am MVA user and logged in using Soft Login
    When Init Universal Links

  @BINGO
  Scenario: TC01_ValidateBingoUniversalLinkwhileAppInForeground
    Then Validate Device Plan To be Opened

  @BINGO
  Scenario: TC02_ValidateBingoUniversalLinkwhileAppInBackground
    Then Validate Device Plan To be Opened While in Background

  @TC_601932
  Scenario: TC03_ValidateNotBingoUniversalLink
    Given I click on Return to my vodafone CTA
    Then Validate Device Plan To be Opened for Non Bingo

  @CONSUMER @PREPAY @SMB @SOLETRADER
  Scenario: TC01_ValidateUsageUniversalLink
    Given App Soft Close
    Then Validate Usage Universal Link

  @CONSUMER @PREPAY @SMB @SOLETRADER
  Scenario: TC02_ValidateFAQSUniversalLink
    Given App Soft Close
    Then Validate FAQs Universal Link

  @universallink
  @PAYG @REGRESSION @TC_601835
  Scenario: TC03_ValidateTopUpUniversalLink
    Given App Soft Close
    Then Validate TopUp Universal Link

  @PREPAY @SMB  @MPS @3G @MBB
  Scenario: TC04_ValidateExtrasUniversalLink
    Given App Soft Close
    Then Validate Extras Universal Link

  @universallink
  @CONSUMER @PREPAY @SMB @SOLETRADER @MPS  @TC_601895
  Scenario: TC04_493624: P1_Check that the Universal Link on App 10.22_FUN
    Given App Soft Close
    Then Validate TradeIn is open while the app in foreground

  @universallink
  @CONSUMER @PREPAY @SMB @SOLETRADER
  Scenario: TC04_493632: Check that the Universal Link for strategic trade in journey will navigate to strategic trade in journey when the app is Hard closed
    When I close the app and relaunch it again
    Then Validate TradeIn is open after hard close


  @CONSUMER @PREPAY @SMB @SOLETRADER
  Scenario: TC04_493636: Check that the Universal Link for strategic trade in journey will navigate to strategic trade in journey when the app is in the background
    Then Validate TradeIn is open while app in background

  #TODO
  @RedHybrid @LOGIN
  Scenario: 496423.01_P1- Check the app behavior when click on the notification deeplink when user logged in and App in background (SoftClose)
    Given App Soft Close
    And Navigate to Payments
    Then Validate payments is open after pressing deeplink

  #TODO
  @RedHybrid @LOGIN
  Scenario: 496423.02_P1- Check the app behavior when click on the notification deeplink when user is logged in and hard close the App
    Given Hardclose app
    And Navigate to Payments
    Then Login with PIN for RedHybrid universal link
    Then Validate payments is open after pressing deeplink

  #TODO
  @RedHybrid
  Scenario: 496423.03_P1- Check the app behavior when click on the notification deeplink when app in background and user not logged in (SoftClose)
    Given App Soft Close
    When Navigate to Payments
    And Login for RedHybrid universal link
    Then Validate payments is open after pressing deeplink

  #TODO
  @RedHybrid
  Scenario: 496423.04_P1- Check the app behavior when click on the notification deeplink when the user hardClose the App and being not logged in
    Given Hardclose app
    When Navigate to Payments
    And Login for RedHybrid universal link
    Then Validate payments is open after pressing deeplink

  @TC_675609 @REGRESSION @3G @MPS @LOGIN @SubswitchToConsumer @Special
  Scenario: Check the content of the billing dashboard using a FL consumer child user on 10.27 app when accessing it through a universal link
    When I am MVA user and logged in using full login with user name and password
    Then I navigate to my account from dashboard tray
    Then Sub Switch to consumer or smb Subscription
    Then I should be navigated to dashboard
    Then App Soft Close
    Then Validate Billing is displayed after tapping on universal link
    Then I should see the new billing dashboard
    Then I should see bar chart
    Then I should NOT see View All CTA
    Then I should see bills


  @TC_1049048 @MPS @3G
  Scenario: Check that very me offer will open from universal link
    Given HardClose the App
    And I close the tutorial if displayed
    Then Validate VeryMe universal link

  @TC_1501084 @TC_1501086 @TC_1514265 @3G @PAYM @PAYG @TC_1524340
  Scenario: Validate Your Plan Universal Link Navigate to plan subsoverlay screen
    When App Soft Close
    And Click on Your plan Universal Link
    Then Plan tab Is Displayed
    When HardClose the App
    And Click on Your plan Universal Link
    Then Plan tab Is Displayed

  @TC_1540358 @TC_1540302 @TC_1540257 @TC_1540303 @TC_1540305 @3G
  Scenario: Validate the Trade in universal link open SDK successfully for Non Vodafone Users
    When App Soft Close
    Then Validate TradeIn is open while the app in foreground
    Then Validate TradeIn is open after hard close

  @TC_1564476 @TC_1564477
  Scenario: Validate Broad band Service Universal Link for HBB user
    And I navigate to my account from dashboard tray
    When I am MVA user and logged in using full login with user name and password
    And The user switch to subscription HBB
    When App Soft Close
    And Click on Broad band service Universal Link
    Then I validate The Broad Band Service Test Screen

  @TC_1564478
  Scenario: Validate Broad band Service Universal Link for Consumer user
    When App Soft Close
    And Click on Broad band service Universal Link
    Then The user should land on the dashboard

  @TC_1564480
  Scenario: Validate Device plan Universal Link for EVO user
    When App Soft Close
    When Click on Device plan Universal Link

  @TC_1564481
  Scenario: Validate Device plan Universal Link for Consumer user
    When App Soft Close
    When Click on Device plan Universal Link
    Then The user should land on the dashboard

  @TC_1564483
  Scenario: Validate Spend Manager Universal Link
    Given User full login
    When App Soft Close
    Then Click on Spend Manager Universal Link
    Then I should be directed to Spend Manager Webview

  @TC_1502960 @TC_1502959 @PAYM  @SOLETRADER
  Scenario: Validate AccountSettings Universal Link navigate to account settings screen
    Given App Soft Close
    Then Click on Account Settings Universal link
    When I should validate Account Settings Items
    Given HardClose the App
    Then Click on Account Settings Universal link
    When Check Account setting ordering and texts

  @TC_1502967
  Scenario: Validate Cards and Payment Universal Link navigate to cards and payments screen
    Given User full login
    When Init Universal Links
    Given App Soft Close
    Then Click on Cards And Payments Universal Link
    Then I should be directed to Manage Cards & Payments Webview
    Given HardClose the App
    Then Click on Cards And Payments Universal Link
    When Password screen is display and insert valid password then click on continue
    Then I should be directed to Manage Cards & Payments Webview

  @TC_1632661 @PAYM @CONSUMER @MPS
  Scenario: Validate Active Controls and Limits Universal link while the app is in background (soft close) using softlogged MPS Consumer user
    Given I am MVA user and logged in using Soft Login
    When App Soft Close
    And Click on Controls and Limits Universal link
    Then validate Native Controls tab is opened

  @TC_1639338 @SOLETRADER @MBB
  Scenario: Validate Active Controls and Limits Universal link when hard close the app using FL MBB Soletrader user
    Given I am MVA user and logged in using full login with user name and password
    When HardClose the App
    And Click on Controls and Limits Universal link
    Then validate Extras tab is opened with old experience

  @TC_1675351  @CONSUMER @SOLETRADER @MPS @3G
  Scenario: Validate Extras Universal link navigate to new extras tab
    Given I am MVA user and logged in using Soft Login
    When soft close the app
    And Click on Extras Universal link
    Then Validate new Native Extras tab is opened












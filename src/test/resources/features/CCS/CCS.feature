Feature: CCS


  @TC_653439 @TC_653425 @3G @DONE @LOGIN @CCS @MPS
  Scenario: Check that forget username is working successfully
    Given Login Till Reach Username Screen
    And Tap on forgot username
    And Enter pin screen is displayed and enter the four fields then click on continue
    Then Validate thanks for Verifying Screen
    Then Validate username is Auto Populated
    Given User full login

  @TC_653418 @CONSUMER @PREPAY @SMB @MPS @CCS
  Scenario: Validate VeryMe Title And CTA is opened successfully
    Given I am MVA user and logged in using Soft Login
    Given Dashboard loaded and scroll to VeryMe offers
    When Check VeryMe title
    Then Check VeryMe View All CTA

  @TC_653419 @CONSUMER @MPS @CCS
  Scenario: Test Case 601797: P1 - Check Each Very Me Rewards displayed as UID_UI
    Given I am MVA user and logged in using Soft Login
    Given Dashboard loaded and scroll to VeryMe offers
    Then Check VeryMe UI

  @TC_653438 @CONSUMER @PREPAY @FAIL @MPS @CCS
  Scenario: Validate TOBi
    Given I am MVA user and logged in using Soft Login
    When Open Tobi and Send "Hello" Message
    Then TOBi should respond With "I’m here to answer questions about Vodafone"
    Then I Close TOBi

  @TC_653420 @CONSUMER @PREPAY @SMB @MPS @CCS
  Scenario: Validate Discover Offers Is Opened in custom tab
    Given I am MVA user and logged in using Soft Login
    Then Open Default Discover offer
    Then accept cookies
    Then Validate Default Discover Offers is Opened in the external browser successfully

  @UFL @DONE
  Scenario: Select Login Preferences As Username and Password
    Given Login Till Reach Login Preference Screen
    When Select Username and Password
    Then Press All done CTA and Validate Dashboard

  @TC_653429 @TC_634251 @LOGIN @DONE @CCS @MPS
  Scenario: Check latest bill SSO for root user is working fine
    Given I am MVA user and logged in using Soft Login
    Given Proceed in full login
    Given The user navigated to billing screen
    Then Validate latest bill SSO is opened

  @TC_610400 @LOGIN @MPS @REGRESSION @Done
  Scenario: Check previous bill SSO for root user is working fine
    Given Click on Login CTA
    Given Preform FL Using Login Preference Method "un"
    When The user navigated to billing screen
    Then Validate latest bill SSO is opened

  @TC_610400 @LOGIN @MPS @REGRESSION @Done
  Scenario: Check previous bill SSO for UFL user is working fine
    Given Click on Login CTA
    Given Preform FL Using Login Preference Method "un"
    When The user navigated to billing screen
    Then Validate latest bill SSO is opened

  @TC_650993 @WIFI @Special @SubswitchToConsumer @LOGIN @REGRESSION
  Scenario: Check the app behavior when switching to Consumer MPS UFL User and access the Direct debit journey
    Given Click on Login CTA
    Given Preform UFL Using Login Preference Method "un"
    Then I should be navigated to dashboard
    Then I navigate to my account from dashboard tray
    Then I navigate to sub switch to SubscriptionType "MPS" and Segment "CONSUMER"
    Then I should be navigated to dashboard
    Then The user navigated to billing screen
    Then Click on Direct Debit CTA
    Then Validate Direct Debit SSO screen is displayed
    Then I click on x icon in webview
    Then I close the app and relaunch it again
    Then I close the tutorial if displayed

  @TC_653433 @LOGIN @DONE @MPS @CCS
  Scenario: Check that manage bars and extras SSO screen opens successfully for root user
    Given I am MVA user and logged in using Soft Login
    Given Proceed in full login
    Given I navigate to subscriptions overlay
    Given I navigate to extras tab from subscriptions overlay
    Then I validate manage bars and extras SSO

 @TC_653435 @LOGIN @DONE @MPS @CCS @REGRESSION @SMB
  Scenario: Check that view details SSO screen in current charges is working successfully for root user
   Given I am MVA user and logged in using Soft Login
   Given Proceed in full login
   Given I navigate to charges tab from subscriptions overlay
   When Click on View Details CTA
   Then Validate view charges SSO is opened

  @TC_653437 @TC_634267 @LOGIN @DONE @REGRESSION @SMB @3G @CCS @MPS @Done
  Scenario: Check that Data cap SSO is working fine for root user
   Given Click on Login CTA
   Given Preform FL Using Login Preference Method "un"
   Given I navigate to subscriptions overlay
   Given I navigate to extras tab from subscriptions overlay
   Then Click on Data Cap journey
   Then Validate Data Cap SSO is opened

  @TC_539943 @TC_653448 @TC_634266 @WIFI @LOGIN @CCS @MPS @REGRESSION @Done
  Scenario: Check the app behavior when an UFL consumer user access "Marketing preferences" journey
    Given Click on Login CTA
    Given Preform FL Using Login Preference Method "un"
    Then I navigate to Privacy Settings
    Then I navigate to Marketing preferences
    Then Validate Marketing preferences screen

 @TC_653443 @TC_634249 @MPS @MBB @LOGIN @DONE @CCS
  Scenario: Check that spend manager SSO journey is working fine for root user
   Given I am MVA user and logged in using Soft Login
   Given Proceed in full login
    Given I navigate to account settings from settings
    Then Validate Spend Manager SSO is opened

  @SANITY @TC_653431 @LOGIN @REGRESSION @MPS @3G @iOSLoginMPS @CCS
  Scenario: Check that upgrade SSO journey is working fine for root users who are eligible for upgrade
   Given Click on Login CTA
   Given Preform FL Using Login Preference Method "un"
   Given I navigate to plan tab from Dashboard
   And I click on Browse Phones CTA
   And click on upgrade now CTA
   Then Validate Upgrade now SSO is opened

 @TC_1050961 @FlexiUpgrade @SimoUpgrade @NormalUpgrade @LOGIN @MPS @3G @REGRESSION
  Scenario: Check exit web confirmation message in upgrade journey for PayM eligible for Normal/SIMO/FlexUpgrade
   Given Click on Login CTA
   Given Preform FL Using Login Preference Method "un"
   Given I navigate to plan tab from Dashboard
   Then I validate upgrade card with two CTAs
   And I click on Browse Phones CTA
   And click on upgrade now CTA
   Then I click on x icon in webview
   Then validate on exit webview confirmation message "Are you sure you want to exit?"
   Then click on Cancel button
   Then I click on x icon in webview
   Then click on Exit

  @LOGIN @REGRESSION @MPS @TC_634258 @CCS
  Scenario: Test Case 653449: P1_Check that SSO Discover Journeys are working fine
    Given Click on Login CTA
    Given Preform FL Using Login Preference Method "un"
    Then Validate DISCOVER_NBA_SIMO is opened
    Then Close WebView
    Then Validate DISCOVER_FLBB is opened

  @TC_653442 @LOGIN @MPS @TC_631506 @CCS @EX
  Scenario: Check that change PIN journey is working fine
    Given I am MVA user and logged in using full login with user name and password
    When Click on setting from tray then click on account settings then click on change pin
    When Enter Valid PIN and Click on Continue
    Then Re-Enter pin screen is displayed and enter the four fields then click on continue
    Then pin successfully updated screen is displayed
    Then Validate pin successfully updated screen Content

  # Account settings
  # marketing settings
  # Direct debit
  

  @TC_653422 @SME @PARTNER_MANAGER @HERITAGE @UNKNOWN @CCS
  Scenario: Test Case 506745: Check that blocked users cannot use the app_Functional
    When  wait for one second and half
    Then Validate Hello friend overlay content For SME users
    When  I click on Return to my vodafone CTA
    Then Validate Acquisition Header

  @TC_653423 @VOXI @CCS
  Scenario: Test Case 506745: Check VOXi users are redirected to the correct overlay_Functional
    When  wait for one second and half
    Then Validate Hello friend overlay content
    When  I click on Return to my vodafone CTA
    Then Validate Acquisition Header

  @TC_653444 @PAYG @CCS
  Scenario: Validate low credit card for PayG
    Then Validate credit card header
    Then Validate low credit card title
    Then Validate credit card amount is less than 5 Pounds
    Then Validate credit card footer
    Then Validate charges API response

#  @TC_653455 @BINGO
#  Scenario: TC01_ValidateTabMenuVariation
#    Given Init tabs variation
#    Then Validate Tab Menu Variation

  @TC_653432 @LOGIN @CCS @MPS
  Scenario: Check that upgrade SSO journey is working fine for child users who are eligible for upgrade
    Given Click on Login CTA
    Given Preform FL Using Login Preference Method "un"
    And I navigate to my account from dashboard tray
    Then Sub Switch to consumer or smb Subscription
    Given I navigate to plan tab from Dashboard
    When click on upgrade now CTA
    And I click on Upgrade only CTA in popup
    And click on accept it in The Cookie permission message
    Then Validate Upgrade now SSO is opened

  @TC_653434 @LOGIN @REGRESSION @TC_634268 @MPS @SubswitchToConsumer @CCS
  Scenario: Check that manage bars and extras SSO screen opens successfully for child user
    Given Click on Login CTA
    Given Preform FL Using Login Preference Method "un"
    Given I navigate to my account from dashboard tray
    Then I navigate to sub switch to SubscriptionType "MPS" and Segment "CONSUMER"
    Given I navigate to subscriptions overlay
    Given I navigate to extras tab from subscriptions overlay
    Then I click manage bars and extras SSO
    Then I validate manage bars and extras SSO
    Then accept cookies
    Then I click on x icon in webview
    Then I close the app and relaunch it again
    Then I close the tutorial if displayed
    And Click on My Account
    Then Preform Returning User Using UN and Password

  @TC_653436 @LOGIN @MPS @CCS
  Scenario: Check that view details SSO screen in current charges is working successfully for child user
    Given I am MVA user and logged in using Soft Login
    Given Proceed in full login
    Given I navigate to my account from dashboard tray
    Then Sub Switch to consumer or smb Subscription
    Given I navigate to subscriptions overlay
    When Click on View Details CTA
    Then Validate view charges SSO is opened

  @TC_653452 @TC_683958 @REGRESSION @MPS @3G @CCS
  Scenario: Check that Track an Order link is Assistance Menu is working fine
    Given I am MVA user and logged in using Soft Login
    Given Dashboard loaded and assistance links retrieved successfully
    When User click on Track an order
    Then Validate Track an order screen is opened
    Then Validate Track an order content

  @TC_653460 @LOGIN @REGRESSION @TC_601844 @MPS @3G @Special @CCS
  Scenario: Check that "Tariff migration" journey title is displayed with "Change your Plan" instead of "My Vodafone" when executed
    Given Preform FL Using Login Preference Method "un"
    Given I navigate to plan tab from Dashboard
    Then user clicks on Change your Plan
    Then Change your Plan is opened

  @TC_653456 @LOGIN @BINGO @CCS
  Scenario: Check app behavior for PAYM user has one device loan after clicking on Make a payment CTA_Functional
    Given I am MVA user and logged in using Soft Login
    When I Dismiss The First Tip
    Given Proceed in full login
    Given Navigate to Device plan tab
    Then Click on Make a payment
    Then Validate Make a payment is opened

  @TC_653457 @LOGIN @BINGO @CCS
  Scenario: Check app behavior for PAYM user has one device loan after clicking on Payment history CTA_Functional
    Given I am MVA user and logged in using Soft Login
    When I Dismiss The First Tip
    Given Proceed in full login
    Given Navigate to Device plan tab
    Then Click on Payment history
    Then Validate Payment history is opened

  @TC_653458 @LOGIN @BINGO @CCS
  Scenario: Check app behavior for PAYM user has one device loan after clicking on View more details CTA_Functional
    Given I am MVA user and logged in using Soft Login
    When I Dismiss The First Tip
    Given Proceed in full login
    Given Navigate to Device plan tab
    Then Click on View more details
    Then Validate View more details is opened

  @TC_653446 @WIFI @FLN @CCS
  Scenario: Check that PAYM has FLN subscription are able to login to app through UFL_Functional
    Given Login Till Reach Login Preference Screen and choose FLN
    Then Select PIN
    Then Press All done CTA and Validate Dashboard
    Then Validate FLN icon in Dashboard

  @TC_825289 @WIFI @BB
  Scenario: Check that PAYM has BB subscription are able to login to app through UFL_Functional
    Given Login Till Reach Login Preference Screen and choose BB
    Then Select PIN
    Then Press All done CTA and Validate Dashboard
    Then Validate BB icon in Dashboard

  @SANITY @TC_683960 @REGRESSION @3G @PAYG
  Scenario: Check header of internal webview when user navigate to  ACTIVATE_VOUCHER journey
    Given Dashboard loaded and Topup is displayed
    Then I navigate to Topup screen
    Then User click on Activate voucher
    Then Validate Activate voucher content

   @SANITY @TC_683957 @REGRESSION @3G @SMB @LOGIN @MPS
  Scenario: Check header of internal webview when user navigate to MANAGE_BARS journey
     Given Click on Login CTA
     Given Preform FL Using Login Preference Method "un"
    Then I navigate to subscriptions overlay
    Then I navigate to extras tab from subscriptions overlay
     Then I click manage bars and extras SSO
    Then I validate manage bars and extras SSO
     Then accept cookies
    Then Validate Manage extras content
    Then Validate second level content

  @TC_653427 @3G @LOGIN @CCS @MPS
  Scenario: Check that login with PIN is working successfully
    Given Preform FL Using Login Preference Method "un"
    And I navigate to settings from dashboard tray
    And I navigate to App settings screen
    And User clicks on Login Options element
    And I choose PIN as my Login Options
    Then HardClose the App and Relaunch
    And I close the tutorial if displayed
    Then I click on my account without login
    When Enter Valid PIN and Click on Continue
    Then Validate Dashboard displayed

  @TC_653450 @3G @LOGIN @CCS @MPS
  Scenario: Check Direct Debit SSO journey
    Given I am MVA user and logged in using full login with user name and password
    And I should be navigated to dashboard
    And I navigate to settings from dashboard tray
    And Click on Account Setting
    And Click on Direct Debit CTA
    Then Validate Direct Debit Card UI

  @TC_653447 @3G @LOGIN @CCS @MPS
  Scenario: Check that My Account Controls in the Account Settings page opens SSO in an internal webview
    Given I am MVA user and logged in using full login with user name and password
    And I should be navigated to dashboard
    And I navigate to settings from dashboard tray
    And Click on Account Setting
    And Click on Data Notifications CTA
    Then I should be directed to Data Notifications

  @TC_653455 @3G @CCS @BINGO
  Scenario: Check that airtime plan tab opens for bingo users
    Given I am MVA user and logged in using Soft Login
    And I Dismiss The First Tip
    And Navigate to Airtime plan tab

  @TC_653445 @3G @PAYG @CCS
  Scenario: Check different vesta variations for users
    Given Dashboard loaded and Topup is displayed
    Then I navigate to Topup screen
    Then I Validate Vesta Journeys for PayG users

  @TC_653445 @3G @PAYG @SPECIAL @PAYMComplex @CCS
  Scenario: Check different vesta variations for PayM Complex users
    Given Dashboard loaded and Topup is displayed
    Then I navigate to Topup screen
    Then I Validate Vesta Journeys for PayG child
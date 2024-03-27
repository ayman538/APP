@3G
Feature: Control Tiles

  Background: Init Control tiles
    Given I close the tutorial if displayed
    Given I am MVA user and logged in using Soft Login

 @SANITY @REGRESSION @TC_601879 @TC_601880 @TC_601881 @TC_601930 @TC_601931 @MPS @MBB @SMB @SOLETRADER @BINGO @RED @RedHybrid @TC_138115 @TC_138126 @TC_138146 @TC_567355 @TC_567356 @TC_1051289 @TC_1051311
  Scenario: 126839.01_P1_Check control tiles on dashboard screen and app behaviour when click on control tiles for PAYM,SMB,SOLETRADER,Red+Leader,PAYM MBB user_functional
    When I Dismiss The First Tip
    Then Validate First Control Tile Text for PAYM SMB SOLETRADER REDHYBRID
    And Validate Plan tab appears after clicking primary control tile
    And Validate Second Control Tile Text  for PAYM SMB SOLETRADER REDHYBRID
    And Validate Extras or Group data tab appears after clicking secondary control tile

  @SANITY @REGRESSION @PAYG @TC_650671 @TC_650720 @TC_650721
  Scenario: Validate low credit card for PayG
    Then Validate credit card header
    Then Validate low credit card title
    Then Validate credit card amount is less than 5 Pounds
    Then Validate credit card footer
    Then Validate charges API response

  @PAYG @PREPAY @TC_650751 @TC_650750
  Scenario: Validate Yellow Lozenge credit when a PayG user have a credit greater than or equal 5 pounds
    Then Validate credit card header
    Then Validate credit card title
    Then Validate credit card amount is greater than or equal five pounds
    Then Validate credit card footer
    Then Validate charges API response

  # @RED
  #Scenario: Validate First Control Tile Text
    #Then Validate First Control Tile Text for Red Leader

  #@MBB
  #Scenario: Validate First Control Tile Text
   # Then Validate First Control Tile Text for MBB

  #@BVB
  #Scenario: Validate First Control Tile Text
   # Then Validate First Control Tile Text for BVB

  #@CONSUMER @SMB @SOLETRADER @PREPAY
  #Scenario: Validate Second Control Tile Text
   # Then Validate Second Control TileText

  #@CONSUMER @SMB @SOLETRADER @PREPAY
  #Scenario: Validate First Control Tile Entry point
   # Then Validate Entry Point For First Control Tile

  #@CONSUMER @SMB @SOLETRADER @PREPAY
  #Scenario: Validate Second Control Tile Entry point
  #  Then Validate Entry Point For Second Control Tile

  @TC_650698 @REGRESSION @LOGIN @Special @SubswitchToPAYG @MPS
  Scenario: Check the UI of the credit tile when a PayG child user landed on the main dashboard
    When I am MVA user and logged in using full login with user name and password
    And I navigate to sub switch to SubscriptionType "MPS" and Segment "PREPAY"
    Then Validate Charges Credit Tile
    Then I close the app and relaunch it again
    Then I close the tutorial if displayed


  @945251 @REGRESSION @BB @LOGIN @Special @SubswitchToHBB
  Scenario:Check the Dashboard Tiles for HBB user
    When I am MVA user and logged in using full login with user name and password
    And I navigate to sub switch to SubscriptionType "BB" and Segment "CONSUMER"
    Then I Validate Dashboard Tiles For Hbb User
    When I Scroll Down and click on Broad Band Service Test
    Then I should see the login screen displayed in custom tab


  @TC_836695 @REGRESSION @MPS
  Scenario: Check "Your Plan" tile when a PayM consumer user is eligible for SIMOFLEX upgrade_Functional
    Then I validate on Eligibility Text in plan tile
    Then I navigate to plan tab from Dashboard
    Then Validate SubsOverlay header

  @TC_1051312 @1051313 @BINGO @REGRESSION
  Scenario: Check the Airtime current charges Tiles for Bingo user
    When I Dismiss The First Tip
    And I validate Charges tile is displayed
    And I navigate to charges tab from subscriptions overlay
    Then Validate Total Estimated Charges
    Then  Validate Additional Charges


  @TC_1344620 @Bingo
  Scenario: Check "Manage Controls & Extras" tile in Bingo Dashboard
    And I validate dashboard tiles For Bingo User
    And I click on Manage Controls & Extras tile
    Then I should be navigated to the Extras tab
#@3G @RedHybrid
Feature: Add New Payment Method

  Background:
    Given Initialize Validate Card Method

  @Continue
  Scenario: TC_507229: P1_Check app behavior after clicking on Pay Now button in "Enter your card details"_Functional
    When Click on Continue CTA
    Then Validate Verified Card Screen

  Scenario: TC 507233: P1_ Check app behavior when clicking on "X" icon in "Verified" screen_Functional
    When Click on X icon on Verified Card screen
    Then Validate Dashboard should be displayed

  @Android
  Scenario: Test Case 507234: P1_Check app behavior when clicking on Physical back in Android in "Processing"and "Verified" screens_Functional
    When Tap on payment on dashboard tray
    Then Tap on Add a new card CTA
    When Turn on the toggles
    Then Validate Continue CTA is clickable
     # When Take steps from Andrew (2 screens)
     # Then Take steps from Andrew
    When Barclays card details screen is displayed
     # Then Enter all text fields
    When Click on Continue CTA
    Then Click on physical back on processing screen
    When Barclays card details screen is displayed
     # Then Enter all text fields
    When Click on Continue CTA
    When Click on physical back on success screen
    Then Validate Dashboard should be displayed

      ###################
  Scenario: Test Case 507987: P1- Check UI of failed screen when click on PayNow CTA in card details Screen _ UI
    When Click on Continue CTA
    Then Validate Failed Card Screen

  Scenario: Test Case 507988: P1- Check try again CTA in failed screen _Functional
    When Click on try again CTA in failed screen
    Then Validate Add new payment method is displayed successfully

        ####################
  @Cancel
  Scenario: Test Case 507243: P1-Check App behavior when tapping on Cancel CTA_Functional
    When Click on Cancel CTA
    Then Validate Add new payment method is displayed successfully


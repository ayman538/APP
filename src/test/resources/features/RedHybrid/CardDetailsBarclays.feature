#@3G @RedHybrid
Feature: Add New Payment Method

  Background:
    Given Initialize Barclays card details

  Scenario: TC_494591: P2_Check the Card fields displayed in Barclays webview_UI
    When Barclays card details screen is displayed
    Then Validate card fields are displayed successfully

  Scenario: TC_494593: P1_Check the App behavior when user click on the Name on card field_Functional
    When Barclays card details screen is displayed
    Then Validate card name field can enter name

  Scenario: TC_494594: P1_Check the App behavior when user click on Card number field _Functional
    When Barclays card details screen is displayed
    Then Validate card number field can enter name

  Scenario: TC_494595: P1_Check the App behavior when user click on the Expiry date/Security code fields_Functional
    When Barclays card details screen is displayed
    Then Validate card Expiry date/Security field can enter name

#  Scenario: TC_494596: P1_Check the App behavior when entering invalid CVV and click on Continue button_Functional
#    When Barclays card details screen is displayed
#    Then Validate when entering invalid CVV
#
#  Scenario: TC_494597: P1_Check the App behavior when entering invalid Card Name and click on continue button_Functional
#    When Barclays card details screen is displayed
#    Then Validate when entering invalid Card Name
#
#  Scenario: TC_494598: P1_Check the App behavior when entering invalid Card Number and click on continue button_Functional
#    When Barclays card details screen is displayed
#    Then Validate when entering invalid Card Number
#
#  Scenario: TC_494599: P1_Check the App behavior when entering invalid Expiration date and click on continue button _Functional
#    When Barclays card details screen is displayed
#    Then Validate when entering invalid Expiration date



  #this scenario to be confirmed when Auth is true or false
  Scenario: TC_494600: P1_Check the App behavior when entering Valid card data and click on continue button when Auth= True_Functional
    When Barclays card details screen is displayed
    Then Validate when entering Valid card data and Auth equal true

  Scenario: TC_494601: P1_Check the App behavior when entering Valid card data and click on continue button when Auth= False_Functional
    When Barclays card details screen is displayed
    Then Validate when entering Valid card data and Auth equal false















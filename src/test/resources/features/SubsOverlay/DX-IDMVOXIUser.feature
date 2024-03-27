@3G @WIFI @AUTOMATIC @FAIL @TC_630449 @REGRESSION
Feature:DX-IDM VOXI SubsOverlay


  Scenario: VOXI Users Overlay Displayed
    Then  A Specific Overlay should be displayed for VOXI users

  Scenario: visit VOXI CTA Displayed on VOXI SubsOverlay
    Then  visit VOXI CTA should be displayed
    When  Click on VOXI CTA
    Then  Directs me to the VOXI users web portal
    When  Click on back button on web portal
    Then  visit VOXI CTA should be displayed

  Scenario: Return to my vodafone CTA Displayed on VOXI SubsOverlay
    Then  Return to my vodafone CTA should be displayed
    When  I click on Return to my vodafone CTA
    Then  Return to acquisition dashboard

#  Scenario: Close ICon Displayed on VOXI SubsOverlay
#    Then  Close ICon should be displayed
#    When  Click on Close Icon
#    Then  Return to acquisition dashboard
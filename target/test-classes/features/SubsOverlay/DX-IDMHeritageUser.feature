@3G @WIFI @AUTOMATIC @FAIL @TC_630447
Feature:DX-IDM Heritage User SubsOverlay

  Scenario: Heritage Users Overlay Displayed
    Then  A Specific Overlay should be displayed for Heritage users

  Scenario: Close ICon Displayed on Heritage SubsOverlay
    Then  Close ICon should be displayed
    When  Click on Close Icon
    Then  Return to acquisition dashboard

  Scenario: Return to my vodafone CTA Displayed on Heritage SubsOverlay
    Then  Return to my vodafone CTA should be displayed
    When  I click on Return to my vodafone CTA
    Then  Return to acquisition dashboard





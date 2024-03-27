@3G @WIFI @AUTOMATIC @FAIL
Feature:DX-IDM Unknown User SubsOverlay


  Scenario: Unknown Users Overlay Displayed
    Then  A Specific Overlay should be displayed for Unknown users

  Scenario: Close ICon Displayed on Unknown SubsOverlay
    Then  Close ICon should be displayed
    When  Click on Close Icon
    Then  Return to acquisition dashboard

  Scenario: Return to my vodafone CTA Displayed on Unknown SubsOverlay
    Then  Return to my vodafone CTA should be displayed
    When  I click on Return to my vodafone CTA
    Then  Return to acquisition dashboard

  Scenario: Login CTA Displayed on Unknown SubsOverlay
    Then  Login CTA should be displayed
    When  Click on Login CTA for Unknown SubsOverlay
    And   accept cookies
    Then  takes me back to Login Screen




@3G
Feature: Push Notification

  Scenario: TC_555894_Check when sending UrbanAirship Push Notification after hardclosing the app_functional
    Given Send a push notification
    When Tap on it from Notification center
    Then Validate My vodafone app is opened

    Scenario: TC_555892_Check the app when sending UrbanAirship Push Notification to a Heritage user that opens an external link_functional
      Given Send a push notification with  external link
      When Tap on it from Notification center
      Then redirect to the external link in an external browser

   Scenario: TC_556640_Check the app when sending UrbanAirship Deeplink to a Heritage user that opens an app journey (Trade In)_functional
    Given Send a push notification with  deep link
    When Tap on it from Notification center
    Then  redirected to the journey sent on the deep link


  Scenario: Check message center notification
    When Send a MessageCenter notification With alert "App in foreground" and title "This week's offer" and body "Foreground App body"
    And Open "App in foreground" Notification from Notification Center
    Then Validate Message Body "Foreground App body"
    When Put App In Background
    And Send a MessageCenter notification With alert "App in background" and title "This week's offer" and body "Background App body"
    And Open "App in background" Notification from Notification Center
    Then Validate Message Body "Background App body"
    When Close App from Background
    And Send a MessageCenter notification With alert "App is closed" and title "This week's offer" and body "Close App body"
    And Open "App is closed" Notification from Notification Center
    Then Validate Message Body "Close App body"









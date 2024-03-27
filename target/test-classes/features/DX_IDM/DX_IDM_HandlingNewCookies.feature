@3G @WIFI @DXIDM
Feature:Handling New Cookies Behavior For SSO

  @TC_574029
  Scenario:Check app behavior when user open any DXIDM webview for the first Time  when open app with soft login
    Given soft login
    When Click on my account
    And  click on accept it in The Cookie permission message
    Then assert that enter user name screen  is display without the cookie permission

  @TC_581980
  Scenario:Check app behavior after user accepting the Cookie permission for the first time then open the webview again or any other different webview when open app with soft login
    Given soft login
    When Click on my account
    And  click on accept it in The Cookie permission message
    And click on X icon on user name screen
    And Click on my account
    Then assert that enter user name screen  is display without the cookie permission

  @TC_574034
  Scenario:Check app behavior after user accepting the Cookie permission for the first time then Hard Close the app and open the webview again or any other different webview when open app with soft login
    Given soft login
    When Click on my account
    And  click on accept it in The Cookie permission message
    And  hard close the app
    And  Click on my account
    Then assert that enter user name screen  is display without the cookie permission

  @TC_574035
  Scenario:Check app behavior when user open any DXIDM webview after accepting it before when open app with UFL Fun
    Given login Till Reach Username Screen
    When  click on accept it in The Cookie permission message
    And   login Till Reach Password Screen
    Then assert that enter password screen is display without the cookie permission


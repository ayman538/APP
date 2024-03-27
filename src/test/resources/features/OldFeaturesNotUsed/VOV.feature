#@3G @WIFI @CONSUMER
## VOV not exist on the app any more
#Feature: VOVs
#
#  @TC_87002 @TC_601791
#  Scenario: P1 - Check app behavior after the user accept or dismiss the VOV _Functional
#    Given Dashboard loaded and checking VOV items
#    When Accept VOV
#    Then Press back button to find VOV not dismissed
#    When Dismiss VOV
#    And App Soft Close
#    Then VOV should not be displayed

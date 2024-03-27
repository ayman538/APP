##merge this file wil control tile feature
#@3G @PREPAY
#Feature: Converged App - Credit Tile Content Change
#
#  Background: Init Converged App - Credit Tile Content Change
#    Given Dashboard is initialized
#
#  @TC_650671 @TC_650720  @TC_650721
#  Scenario: Validate low credit card for PayG
#    Then Validate credit card header
#    Then Validate low credit card title
#    Then Validate credit card amount is less than 5 Pounds
#    Then Validate credit card footer
#    Then Validate charges API response
#
#
#  @TC_650751 @TC_650750
#  Scenario: Validate Yellow Lozenge credit when a PayG user have a credit greater than or equal 5 pounds
#    Then Validate credit card header
#    Then Validate credit card title
#    Then Validate credit card amount is greater than or equal five pounds
#    Then Validate credit card footer
#    Then Validate charges API response
#

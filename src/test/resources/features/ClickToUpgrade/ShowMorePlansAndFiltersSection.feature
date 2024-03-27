Feature: Show more plans and filters section
  Background:
    Given I am MVA user and logged in using Soft Login
    When I navigate to plan tab from Dashboard
    And I click on see plans button
    And I click on show more plans CTA
    And I click on Filters CTA


  @C2U @1515853 @1516209 @1515849 @IOS
  Scenario Outline: Check app behavior for each CTA in the filter
    When After I click on "<CTA>" filter the results should be matching the desired filter
    Examples:
      | CTA |
      |12 Months|
      |24 Months|
      |All plans|
      |Unlimited|
      |5G Ready |
      |Roaming  |

  @C2U @1516226 @CONSUMER @IOS
  Scenario Outline: Check app behavior in case filtering using price filter
    When I set "<first value>" as a min price
    And I set "<second value>" as a max price
    Then The results should be in the range of min and max price
    Examples:
    | first value | second value |
    | 20 | 25 |

  @C2U @1346808 @1346810 @1346809 @1346973 @1346984 @1346956 @IOS
  Scenario Outline: Check filter counter and clear all CTA behavior
    Given I do not change any filter the filter counter and the clear all CTA not exist
    When I change "<Plan length>" and "<Min price>" and "<Max price>" and "<Data>" and "<Features>" filters
    Then The filter counter and clear all CTA should displayed and filter counter should be equal to the number of changed filters
    When I click on clear all CTA
    Then The filter counter and clear all CTA not displayed and the filters back to default
    Examples:
      | Plan length | Min price | Max price | Data      | Features |
      | 12 Months   | 20        | 25        | Unlimited | Roaming  |

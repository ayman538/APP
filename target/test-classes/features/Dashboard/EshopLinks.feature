@3G @CONSUMER @SOLETRADER @SMB
Feature: Eshop links

  Background:
    Given I close the tutorial if displayed


  @TC_1077224 @TC_1077225 @TC_1077225 @TC_1077228 @TC_TC_1077229 @REGRESSION @PAYG @TC_1077227
  Scenario:P1 - Check app behavior when there are more than four items and functionality of show more and show less buttons for PayG user_Functional
    Given I am MVA user and logged in using Soft Login
    When I Scroll Down to Eshop Links
    And I Check only 5 links are displayed in Eshop Links
    And I Click on show more button from Eshop Links section
    And I Check Eshop links ordering and texts of paym user
    And I Click on show less button from Eshop Links section
    Then I Check only 5 links are displayed in Eshop Links


  @TC_1038684  @TC_1038685  @TC_1038686  @TC_1038688 @TC_1038689 @REGRESSION @MPS @LOGIN
  Scenario:P1 - Check app behavior when there are more than five items and functionality of show more and show less buttons for PayM user_Functional
    Given Click on Login CTA
    Given Preform FL Using Login Preference Method "un"
    When I Scroll Down to Eshop Links
    And I Check only 5 links are displayed in Eshop Links
    And I Click on show more button from Eshop Links section
    And I Check Eshop links ordering and texts of paym user
    And I Click on show less button from Eshop Links section
    Then I Check only 5 links are displayed in Eshop Links



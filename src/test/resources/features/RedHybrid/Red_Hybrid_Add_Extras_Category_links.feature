@3G @RedHybrid
Feature: Red Hybrid Add Extras Category links

  Background: Launching App using Red Hybrid User that has active plan and payment method added
    Given  I am MVA user and logged in using Soft Login
    And    I should be navigated to dashboard
    When   I navigate to add extras overlay

  @848026 @848037 @848046 #@848096
  Scenario Outline:Check functionality of link "What destinations are included?" in "Extra" overlay
    When I should be navigated to addExtras overlay
    And  I click on "<ExtraName>" extra
    And  I click on extras Description Link
    Then I should be redirect to the correct "<WebViewTitle>" and "<URL>"
    Examples:
      | ExtraName                        | WebViewTitle                     | URL                                                                                                             |
      | Europe Roaming Extra             | International Roaming            | https://www.vodafone.co.uk/mobile/global-roaming/destinations#paygplus                                          |
      | Around the World Roaming Extra   | International Roaming            | https://www.vodafone.co.uk/mobile/global-roaming/destinations#paygplus                                          |
      | International Extra              | International Extras             | https://www.vodafone.co.uk/terms-and-conditions/consumer/mobile/pay-as-you-go-plus/pay-as-you-go-plus-extras/   |
      | Premium Rate Credit Extra        | Premium Rate Credit              | https://www.vodafone.co.uk/terms-and-conditions/consumer/mobile/pay-as-you-go-plus/pay-as-you-go-plus-extras/   |
      | Rest of the World Roaming Extra  | International Roaming            | https://www.vodafone.co.uk/mobile/global-roaming/destinations#paygplus                                          |


  @TC_724377   @Regression_Active_Payment
  Scenario Outline: Check UI of Extras overlay after tapping on "Extra" tile from "Add Extras" screen_UI
    When   I click on "<ExtraName>" extra
    And    I navigate to Extra overlay
    Then   I should be navigated to Extra overlay
    Examples:
      | ExtraName                        |
      | Europe Roaming Extra             |
      | Around the World Roaming Extra   |
      | International Extra              |
      | Premium Rate Credit Extra        |
      | Rest of the World Roaming Extra  |
  @TC_1048344 @POST_BETA
  Scenario: Check that Renew plan early overlay is displayed in Add Data overlay
    When I click on "Data Extra" extra
    And  I navigate to Extra overlay
    Then I should see Renew Plan Early CTA is Displayed
    When I click on Renew Plan Early CTA
    Then  I should be directed to Renew_plan_early_overlay
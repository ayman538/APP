@3G @CONSUMER @SOLETRADER @SMB

Feature: Tobi Login Prompt

  Background: Close Tutorial or Click on Login or Click on My account
    Given I am MVA user and logged in using full login with Biometrics
    Then I close the app and relaunch it again
    And I close the tutorial if displayed


  @FullLogin @BiometricsPref @UI @TC_838742 @TC_838743 @3G
  Scenario: TC01_Validate Prompt displayed when Returning PAYM user with Biometrics clicks on Tobi
    Then I should see the TOBI prompt when I click on Tobi using returning user with Biometrics preference


  @TC_838746
  Scenario: TC02_Validate behavior when user clicks on Skip login on the Tobi Prompt
    Given I should see the TOBI prompt when I click on Tobi using returning user with Biometrics preference
    When I click on Skip Login CTA on Tobi Prompt
    Then I should see the tobi chat

  @TC_838748
  Scenario: TC03_Validate behavior when user clicks on Skip login on the Tobi Prompt
    Given  I should see the TOBI prompt when I click on Tobi using returning user with Biometrics preference
    Then I click on X icon for the tobi prompt
    Then I should be navigated to dashboard


#TODO: revisit this feature when the running user not has the child that switch to, it should throw skip exception to ignore this scenario

Feature: NewVOVs

  Background: Initialize Remove VOV

  @TC_651983 @TC_651995 @TC_651997 @3G @CONSUMER @MPS
  Scenario: TC01_ValidateRemoveVOVFromParentUser
    Then Validate VOV is not exist anymore from UI

  @TC_652018 @Special @SubswitchToConsumer @LOGIN
  Scenario: TC02_ValidateRemoveVOVFromPayMChildUserOver3G
    Given I am MVA user and logged in using full login with user name and password
    And  I navigate to PayM child
    Then Validate VOV is not exist anymore from UI

  @TC_652009
  Scenario: TC03_ValidateRemoveVOVFromFLN/HBBChildUSerOver3G
    Given I am MVA user and logged in using full login with user name and password
    And  SwitchToSubscriptionFLN
    Then Validate VOV is not exist anymore from UI
    When The user switch to subscription HBB
    Then Validate VOV is not exist anymore from UI

  @TC_652020
  Scenario: TC04_ValidateRemoveVOVFromPayGChildUserOver3G
    Given I am MVA user and logged in using full login with user name and password
    And  I navigate to PayG child
    Then Validate VOV is not exist anymore from UI
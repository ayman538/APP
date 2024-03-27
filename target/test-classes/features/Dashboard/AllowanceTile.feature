Feature: Allowance Tile

  Background: check allowance tile
    Given I am MVA user and logged in using Soft Login

  @SANITY @TC_91591 @TC_601798 @REGRESSION @MBB @3G @MPS
  Scenario: P1 - Check view all allowances card using user has one allowance card _Functional
    Then Validate Allowance Tile

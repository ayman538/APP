@3G
Feature: Usages tab CRO

  Background:
    Given I am MVA user and logged in using Soft Login

  @TC_2029294 @TC_2029296 @TC_2029308 @MPS @EVO @BINGO
  @TC_1458322 @TC_1498337 @BINGO @MPS @TC_1643780 @TC_1635104 @TC_1635077  @TC_1635076 @TC_1635075
  Scenario: P1 -Check that the tiles experience appear on Usage tab
    Given Navigate to SubsOverlay
    When Navigate to Usages
    Then I should see Tiles title
    Then I should see the Tile List and validate their functionality
    And Validate Extras CTA

@SMB-MPS @TC_2020111 @TC_2020112
Scenario: P1_Check Tiles navigation with SMB MPS user_FUNC
  Given Navigate to SubsOverlay
  Then Navigate to Usages
  And Validate SMB Tiles navigation



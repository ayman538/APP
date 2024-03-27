#@3G @RedHybrid
Feature: Automation First Red Hybrid - MVA - Dashboard Top Tiles

  Background: Initialize Allowance Tile
    Given Init Allowance Card

  Scenario: TC01_checkAllowanceTileHeader
    Then Validate Allowances Card

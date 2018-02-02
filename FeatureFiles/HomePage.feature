Feature: Home page functionality

  Background:
    Given Home page is loaded

  Scenario: Click on recruiting unfolds recruiters panel
    When I click on recruiting
    Then Unfolds recruiters panel

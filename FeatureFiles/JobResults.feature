Feature: Job Results functionality

  Background:
    Given Home page is loaded

  Scenario: Search jobs returns results
    When I search for job
    Then I get job results
Feature: Home page functionality

  Background:
    Given Home page is loaded

  Scenario: Click on register opens form
    Given I click on advertise button
    And Goes to recruiter's page
    When I click on register button
    Then Goes to Advertise page
    And Register panel is shown

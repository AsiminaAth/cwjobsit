Feature: Recruiters page functionality

  Background:
    Given Home page is loaded

  Scenario: Click on register opens form
    Given I click on advertise button
    And Goes to recruiter's page
    When I click on register button
    Then Register panel is shown
    And Sign in panel is shown

  Scenario: Click on 'BuyNow' text link goes to recruiter bin page
    Given I click on 'Advertise now' button
    And Goes to recruiter's page
    And I click on 'BUY JOB ADS'
    And I click on 'BUY NOW'
    Then Page title contains "Shopping Basket"

   
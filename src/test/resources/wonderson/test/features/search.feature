Feature: Search for multiple items on search engine

  Background:
    Given I am on the google search page

  Scenario Outline:
    And I search for "<SearchString>"
    Then I should see "<SearchString>" text
    Examples:
      | SearchString |
      | bbc          |
      | itv          |
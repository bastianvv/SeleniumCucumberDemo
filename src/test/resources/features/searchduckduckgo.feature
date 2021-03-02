@search
Feature: Search with DuckDuckGo
  Different types of search with DuckDuckGo

  Scenario: Common search
    Given I go to DuckDuckGo start page
    When I search for something
    Then DuckDuckGo shows the results first page
@search
Feature: Search with DuckDuckGo
  Different types of search with DuckDuckGo

  Scenario: Common search
    Given I go to DuckDuckGo start page
    When I search for something
    Then DuckDuckGo shows the results first page

  Scenario: Empty search
    Given I go to DuckDuckGo start page
    When I search for nothing
    Then DuckDuckGo redirects to the main page

  Scenario Outline: Bang search
    Given I go to DuckDuckGo start page
    When I search <search> using the <bang> bang
    Then DuckDuckGo shows the results for <search> in <website>
    Examples: Bangs
    | search   | bang  | website                      |
    | 42       | !wa   | https://www.wolframalpha.com |
    | Junit    | !r    | https://www.reddit           |
    | Selenium | !gh   | https://github               |
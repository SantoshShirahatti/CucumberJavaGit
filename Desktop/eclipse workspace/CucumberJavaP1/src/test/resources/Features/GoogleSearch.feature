Feature: Feature to test google search page

  Scenario: validate Google search is working
    Given browser is open
    When user enters a text in search box
    And hits enter
    Then user is navigated to search results page

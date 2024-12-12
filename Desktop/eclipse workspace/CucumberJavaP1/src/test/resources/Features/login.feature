Feature: Feature to test login functionality

  Scenario: Check login is successfull with valid credentials
    Given user is on login page
    When : user enters credentials like username and password
    And : clicks on login button
    Then : user is navigated to home page
 
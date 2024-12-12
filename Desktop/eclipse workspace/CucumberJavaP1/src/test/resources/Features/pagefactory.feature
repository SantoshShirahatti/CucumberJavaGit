Feature: Login to Practice Test Automation

  @abcd
  Scenario: Successful login with valid credentials
    Given the user is on the login page done
    When the user enters respective username "student" and password "Password123" done
    And the user clicks the login button done
    Then the user should be navigated to the dashboard done

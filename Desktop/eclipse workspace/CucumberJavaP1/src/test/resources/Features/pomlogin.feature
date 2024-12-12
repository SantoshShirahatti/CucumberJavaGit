Feature: OrangeHRM Login

  Scenario: Successful Login to OrangeHRM
    Given the user opens the browser and navigates to the login page
    When the user enters username "Admin" and password "admin123"
    And the user clicks on login button
    Then the user should be navigated to the dashboard

Feature: Verify functionality of Admin and PIM after login

  Background: 
    Given the user is on the OrangeHRM login page
    When the user enters valid credentials "Admin" and "admin123"
    And the user clicks the login button
    Then the user should be directed to the dashboard

  
  Scenario: Verify Admin status dropdown has enabled button
    When the user clicks on the "Admin" icon
    Then the user should see the status dropdown with "Enabled" option

  Scenario: Verify PIM page has Reports button visible
    When the user clicks on the "PIM" button
    Then the "Reports" button should be visible on the PIM page

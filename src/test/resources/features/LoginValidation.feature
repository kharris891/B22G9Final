Feature: Test the Login Functionality of HRMS Application

  @Test
  Scenario: valid admin login with username and password
    Given the admin is on the HRMS login page
    When the user logs in with valid ESS credentials
    Then the user should be redirected to the dashboard
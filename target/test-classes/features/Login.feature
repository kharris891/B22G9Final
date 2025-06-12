Feature: Login Validation

  @e_user @login
  Scenario: Empty username
    Given I am on the login page
    When I enter empty username and valid password
    And I click the login button
    Then  I should see an error message "Username cannot be empty"

  @e_pass @login
  Scenario: Empty password
    Given I am on the login page
    When I enter valid username and empty password
    And I click the login button
    Then I should see an error message "Password is Empty"

  @invalid @login
  Scenario: Incorrect login
    Given I am on the login page
    When I enter invalid username and invalid password
    And I click the login button
    Then I should see an error message "Invalid credentials"
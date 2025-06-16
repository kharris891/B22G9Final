@api
Feature: User Creation API
# I want to validate that the API for creating a new user account functions correctly,
#  So that users can register successfully and receive appropriate error messages for invalid inputs.

Background:
  #When the user logs in with valid credentials

  @smokeAPI @apicreate
  Scenario: Successfully create a new user
    Given a request is prepared to make a POST call for creation of an Employee
    And the user provides name "Peter Parker" email "peter.parker92@example.com" password "PassPass123"
    When the user sends a POST request to create User
    Then the status code is 201 for this call
    And the response body should contain message "User Created"

  @regression @apicreate
  Scenario: Handle validation errors during user registration
    When the user attempts to register with an already registered email:
      | name        | email              | password  |
      | Peter Parker  | peter.parker@example.com  | PassPass123 |
    Then the API response status should be 200
    And the response should contain message "The email address you have entered is already registered"

    When the user attempts to register with an invalid email format:
      | name        | email        | password  |
      | Parker Pet  | invalidEmail | Pass123 |
    Then the API response should contain:
      | condition | data         |
      | error      | Invalid Email |

    When the user attempts to register without a password:
      | name        | email              | password |
      | Peter Parker | peter.parker22@example.com |          |
    Then the API response should contain:
      | condition | data               |
      | error      | Please fill all inputs |

    When the user attempts to register without a name:
      | name | email             | password  |
      |      | david@example.com | Pass@1234 |
    Then the API response should contain:
      | condition | data               |
      | error      | Please fill all inputs |
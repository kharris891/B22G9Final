@api
Feature: API Token Generation

  @generateToken
  Scenario: Generate API token
    Given a JWT token is generated with a response that contains the key "token" with a valid token value

  @invalidTokenGeneration
  Scenario: The email format is not correct
    Given a POST call is made to generate the API token with an invalid email format
    Then the response contains the key "Error" with a message indicating invalid email format

  @invalidCredentials
  Scenario: The email or password combination is incorrect
    Given a POST call is made to generate the API token with an incorrect email or password combination
    Then the response contains the key "Error" with a message indicating invalid credentials

  @missingFields
  Scenario: If any required field is missing
    Given a POST call is made to generate the API token with missing required fields
    Then the response contains the key "Error" with a message indicating missing required fields
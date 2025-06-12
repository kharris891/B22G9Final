Feature: Change my contact details as an employee

  Background:
    Given the user is on the HRMS login page
    When the user logs in with valid credentials
    Then the user should be redirected to the dashboard

  Scenario: Access and view contact information fields
    When the employee navigates to the Contact Information section
    Then the following fields should be displayed and editable:
      | Field            | Type     |
      | Address Street 1 | Textbox  |
      | Address Street 2 | Textbox  |
      | City             | Textbox  |
      | State            | Textbox  |
      | Zip Code         | Textbox  |
      | Country          | Dropdown |
      | Home Phone       | Textbox  |
      | Mobile Phone     | Textbox  |
      | Work Phone       | Textbox  |
      | Work Email       | Textbox  |
      | Other Email      | Textbox  |

  Scenario: Edit and save contact information
    Given the employee is on the Contact Information section
    When the employee updates one or more of the contact information fields
    And clicks the "Save" button
    Then the system should validate the input
    And the system should save the updated contact information
    And the updated fields should be reflected in the employee's profile

  Scenario: Attempt to save with invalid input (e.g., incorrect email or phone format)
    Given the employee enters invalid data in contact fields
    When the employee clicks the "Save" button
    Then the system should display appropriate validation messages
    And the information should not be saved until valid

  Scenario: View saved contact information
    Given the employee has previously saved contact information
    When the employee navigates to the Contact Information section
    Then all saved details should be displayed in the respective fields

  Scenario: Verify updated contact information in database
    Given the employee has saved updated contact information
    Then the changes should be shown in the database correctly

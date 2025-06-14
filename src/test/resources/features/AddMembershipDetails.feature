@ess
Feature: Change my contact details as an employee

  #Background:
    #Given the user is on the HRMS login page
    #When the ess user logs in with valid credentials
    #Then the user should be directed to the dashboard

  @Membership1
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

  @Membership2
  Scenario: Edit and save contact information
    Given the employee is on the Contact Information section
    When the employee updates one or more of the contact information fields
    And clicks the "Save" button
    Then the system should save the updated contact information

  @Membership3
  Scenario: Attempt to save with invalid input (e.g., incorrect email or phone format)
    Given the employee enters invalid data in contact fields
    When the employee clicks the "Save" button
    Then the system should display appropriate validation messages
    And the information should not be saved until valid

  @Membership4
  Scenario: View saved contact information
    Given the employee has previously saved contact information
    When the employee navigates to the Contact Information section
    Then all saved details should be displayed in the respective fields

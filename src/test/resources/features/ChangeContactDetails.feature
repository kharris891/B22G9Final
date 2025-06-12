Feature: Change membership details as an employee

  Background:
    Given the user is on the HRMS login page
    When the user logs in with valid credentials
    Then the user should be redirected to the dashboard

  Scenario: Access and view the membership section
    When the employee navigates to the Membership section
    Then the following editable fields should be displayed:
      | Field                     | Type       |
      | Membership               | Dropdown   |
      | Subscription Paid By     | Dropdown   |
      | Subscription Amount      | Textbox    |
      | Currency                 | Dropdown   |
      | Subscription Commence Date | Calendar |
      | Subscription Renewal Date  | Calendar |

  Scenario: Save membership details with all mandatory fields filled
    Given the employee is on the Membership section
    When the employee selects a value for "Membership"
    And selects a value for "Subscription Paid By"
    And enters a value for "Subscription Amount"
    And selects a date for "Subscription Commence Date"
    And optionally selects a currency and renewal date
    And clicks the "Save" button
    Then the system should validate the mandatory fields are filled
    And the system should save the membership details
    And the details should be stored in the employee's profile

  Scenario: Attempt to save membership details with missing mandatory fields
    Given the employee is on the Membership section
    When the employee leaves one or more mandatory fields empty
    And clicks the "Save" button
    Then the system should show a validation error
    And the details should not be saved

  Scenario: Edit existing membership details
    Given the employee has previously saved membership details
    When the employee navigates to the Membership section
    And updates the membership fields
    And clicks "Save"
    Then the updated details should be saved
    And updated details shown in the employee's profile

  Scenario: Delete existing membership details
    Given the employee has previously saved membership details
    When the employee clicks the "Delete" button
    Then the membership details should be removed
    And the membership section should be reset or empty

  Scenario: Display membership details clearly in profile
    Given the employee has saved membership details
    When they view their profile
    Then the membership details should be shown in a clear and organized format

  Scenario: Verify membership details in database
    Given the employee has saved or updated their membership details
    And the database should reflect the same membership information
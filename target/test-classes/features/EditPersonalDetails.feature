Feature: Edit Personal Details as an ESS User

  Background:
    Given the ESS user is on the HRMS login page
    When the user logs in with valid credentials
    Then the user should be redirected to the dashboard

  @smoke
  Scenario: Verify that personal detail fields are editable and selectable
    Given the user navigates to the My Info section and clicks
    Then the user clicks Edit update personal information
    Then the First Name field should be editable
    Then the Middle Name field should be editable
    Then the Last Name field should be editable
    Then the Gender radio buttons should be selectable to update Gender
    Then the Nationality dropdown should be selectable where user can update Nationality
    And the Marital Status dropdown should be selectable to update Marital Status
    And the user clicks on Save to save the changes
    Then the system should be displaying the updated personal details
    And the changes should be saved and visible successfully in the database

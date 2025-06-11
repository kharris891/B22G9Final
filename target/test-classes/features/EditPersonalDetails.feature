Feature: Edit Personal Details as an ESS User

  Background:
    Given the ESS user is on the HRMS login page
    When the user logs in with valid credentials
    Then the user should be redirected to the dashboard
  @smoke
  Scenario: Verify that personal detail fields are editable and selectable
    Given the user navigates to the PIM section
    Then user click on Employee name and search for ESS user
    When the user clicks on search button
    Then the user should  see ESS user and click on it
    When the user clicks on Edit
    Then the First Name field should be editable
    Then the First Name field should be editable
    And the Middle Name field should be editable
    And the Last Name field should be editable
    And the Gender radio buttons should be selectable
    And the Nationality dropdown should be selectable
    And the Marital Status dropdown should be selectable

  @smoke
  Scenario: Edit and save personal details
    Given  the user clicks Edit update personal information
    And   the user enters "Nadia" in the first name field
    And the user enters "Ms" in the Middle Name field
    And the user enters "Bilal" in the Last Name field
    And the user selects "Female" as Gender
    And the user selects "Pakistani" from the Nationality dropdown
    And the user selects "Married" from the Marital Status dropdown
    And the user clicks on "Save" to save the changes
    Then the system should be displaying the updated personal details
    And the changes should be saved and visible successfully in the database

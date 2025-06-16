@ess @java
Feature: Add Dependents to Employee Profile

  Background:
    #Given the ESS user is on the HRMS login page
    #And the user logs in with valid ESS credentials
    #And the user should be redirected to the dashboard
    And the employee opens the Dependents section

  @depends @depends1
  Scenario: Add a single valid dependent
    When the employee clicks on Add Dependent
    And the employee enters "John Doe" in the Name field
    And the employee selects "Child" from the Relationship dropdown
    And the employee selects "2015-04-22" from the Date of Birth field
    And the employee clicks the Save button
    Then the new dependent "John Doe" should appear in the dependents list

  @depends @depends2
  Scenario: Display error messages for incomplete input
    When the employee clicks on Add Dependent
    And the employee enters "" in the Name field
    And the employee selects "Child" from the Relationship dropdown
    And the employee selects "1950-09-30" from the Date of Birth field
    And the employee clicks the Save button
    Then an error message "Required" should be displayed near the Name field

  @depends @depends3
  Scenario: Remove a dependent
    When the employee click on the checkbox next to "John Doe"
    And the employee clicks Remove next to "John Doe"
    Then "John Doe" should no longer appear in the dependents list

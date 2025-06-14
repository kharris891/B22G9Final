@admin
Feature: Employee Search

  As an HRMS application administrator,
  I want to search for employees by their name or employee ID,
  So that I can quickly locate and access their records in the HRMS system.

  Background:
    #Given the admin user is logged into the HRMS system
    And the admin navigates to the Employee List

  @emp @emp1
  Scenario: Search by full name
    And the admin enters full name "Amir ms Abbass"
    And the admin clicks the Search button
    Then the employee search results should include "Amir ms Abbass"

  @emp @emp2
  Scenario: Search by partial last name and lowercase
    And the admin clicks the Reset button
    And the admin enters full name "ass"
    And the admin clicks the Search button
    Then the employee search results should include "Amir ms Abbass"

  @emp @emp3
  Scenario: Search by camel case first name
    And the admin clicks the Reset button
    And the admin enters full name "Amir"
    And the admin clicks the Search button
    Then the employee search results should include "Amir ms Abbass"

  #Scenario: Search for a non-existing employee
    #And the admin clicks the Reset button
    #And the admin enters full name "No One Exists"
    #And the admin clicks the Search button
    #Then the system should display "No Records Found"

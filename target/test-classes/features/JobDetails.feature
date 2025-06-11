Feature: Add Current Job Details for Employees

  Background:
    # Given user is able to access HRMS application
    When user enters valid login username and password
    And user clicks on the login button
    When user clicks on PIM option

  @validJobDetails
  Scenario: Adding current job details for an employee
    When user clicks on Employee List option
    And user searches for an employee with <employeeId>
    And user clicks on search button
    And user clicks on the employee name
    And user clicks on the Job tab
    And user clicks on the Edit button
    And user enters <jobTitle>
    And user enters <employmentStatus>
    #And user enters <jobCategory>
    And user enters <joinedDate>
    And user enters <subUnit>
    And user enters <location>
    And user enters <startDate>
    And user enters <endDate>
    And user uploads a file with path <filePath>
    And user clicks on the Save button
    Then user can see the success message Successfully Updated
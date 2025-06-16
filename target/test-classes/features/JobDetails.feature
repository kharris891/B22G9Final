@java @admin
Feature: Add Current Job Details for Employees

  #Background:
    #Given the admin is on the HRMS login page
    #When the user logs in with valid ESS credentials
    #Then the user should be redirected to the dashboard
    #When user clicks on PIM option

  @job @job1
  Scenario: Adding current job details for an employee
    When user clicks on Employee List option
    And user searches for an employee with <employeeId>
    And user clicks on search button
    And user clicks on the employee name
    And user clicks on the Job tab
    And user clicks on the Edit button
    And user enters <jobTitle>
    And user enters <employmentStatus>
    And user enters <jobCategory>
    And user enters <joinedDate>
    And user enters <subUnit>
    And user enters <location>
    And user enters <startDate>
    And user enters <endDate>
    And user uploads a file with path "\src\test\resources\testdata\Contract Details.pdf"
    And user clicks on the Save button
    Then user can see the success message Successfully Updated


  @job @job2
  Scenario: Uploading a file that is too large
    When user clicks on Employee List option
    And user searches for an employee with <employeeId>
    And user clicks on search button
    And user clicks on the employee name
    And user clicks on the Job tab
    And user clicks on the Edit button
    And user uploads a file with path "\src\test\resources\testdata\bigfile.txt"
    And user clicks on the Save button
    Then user can see the error message File size exceeds the limit
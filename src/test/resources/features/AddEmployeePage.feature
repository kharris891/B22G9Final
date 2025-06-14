@admin
Feature: Adding an Employee to the HRMS Application

    #Background:
        #Given the HRMS user is on the HRMS login page
        #When the user logs in with valid HRMS credentials
        #Then the user should be redirected to the dashboard

  @user @user1
  Scenario: Adding the employee by firstname middle name and lastname
  without employee ID
    #Given user is able to access HRMS application
    #When user enters valid username and password
    #And user clicks on login button
    #Then user is able to see dashboard page
    When user clicks on PIM option
    And user clicks on Add employee option
    And user enters firstname middle name and lastname
    And user clicks on save button
    And user generates a unique employee ID
    Then employee added successfully

  @user @user2
  Scenario: Adding the employee by firstname middle name and lastname
  with employee ID
    #Given user is able to access HRMS application
    #When user enters valid username and password
    #And user clicks on login button
    #Then user is able to see dashboard page
    When user clicks on PIM option
    And user clicks on Add employee option
    And user enters firstname middle name and lastname
    And user enters employee ID
    And user clicks on save button
    Then employee added successfully with the provided employee ID

  @user @user3
  Scenario: Adding employee without mandatory fields
    #Given user is able to access HRMS application
    #When user enters valid username and password
    #And user clicks on login button
    #Then user is able to see dashboard page
    When user clicks on PIM option
    And user clicks on Add employee option
    And user leaves firstname or lastname empty
    And user clicks on save button
    Then user should see an error message indicating mandatory fields are required

  @user @user4
  Scenario: Adding employee with duplicate details
    #Given user is able to access HRMS application
    #When user enters valid username and password
    #And user clicks on login button
    #Then user is able to see dashboard page
    When user clicks on PIM option
    And user clicks on Add employee option
    And user enters details of an existing employee
    And user clicks on save button
    Then user should see an error message indicating the employee already exists


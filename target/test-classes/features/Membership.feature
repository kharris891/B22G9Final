@java @admin
Feature:Membership Management in HRMS

  #Background:
    #Given the user is on the HRMS login page
    #When the user logs in with valid credentials

  @Membership1  @Membership
  Scenario: Access and view contact information fields
    When navigates to the employee list
    When searches for employee "Amir ms Abbass"
    And clicks on Add Membership
    And enters the following membership details:
      | Membership   | Subscription Paid By | Subscription Amount | Currency             | Subscription Commence Date | Subscription Renewal Date |
      | Brain Buster | Company              | 200                 | United States Dollar | 2025-06-14                 | 2026-06-14                |
    When saves the membership
    Then the membership should be successfully added

    #Edit the membership details
  @Membership2  @Membership
  Scenario: Edit and save membership details
    When navigates to the employee list
    When searches for employee "Amir ms Abbass"
    When I update the membership with new details:
      | Membership  | Subscription Paid By | Subscription Amount | Currency     | Subscription Commence Date | Subscription Renewal Date |
      | Membership1 | Individual           | 30000               | Indian Rupee | 2025-06-15                 | 2026-06-15                |
    When saves the membership
    Then the membership should be updated successfully

    #Delete the membership
  @Membership @Membership
  Scenario: Delete membership
    When navigates to the employee list
    When searches for employee "Amir ms Abbass"
    When I delete the membership
    Then the membership should be deleted successfully

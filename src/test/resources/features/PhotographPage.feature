@ess
Feature: Profile Picture Upload for ESS Users
  As an ESS user
  I want to upload a profile picture
  So that my profile looks more personalized and complete

  Background:
    #Given I am logged in as an ESS user with valid credentials
    And I navigate to the My Info tab
    And I click on the profile picture section

  @photo @photo1
  Scenario: Successful upload of JPG profile picture
    When I upload a valid image "profile_200x200.jpg" (200x200px, <1MB)
    Then the system should accept the upload
    And I should see the success message "Profile picture uploaded successfully"
    And my profile should display the updated picture

  @photo @photo2
  Scenario: Successful upload of PNG profile picture
    When I upload a valid PNG image "profile_200x200.png" (200x200px, <1MB)
    Then the system should accept the upload
    And I should see the success message "Profile picture uploaded successfully"
    And my profile should display the updated picture

  @photo @photo3
  Scenario: Successful upload of GIF profile picture
    When I upload a valid GIF image "profile_200x200.gif" (200x200px, <1MB)
    Then the system should accept the upload
    And I should see the success message "Profile picture uploaded successfully"
    And my profile should display the updated picture






Feature: elearning login
@signin
  Scenario: singup elearning with details
    Given User navigates to elearning application
    When user enters clicks on sign up button
    And fill the user details
    And click the register button
    Then user is signed up successfully
    And user is able to log out
    And user is able to login with created user account
    And user is able to send the email
   
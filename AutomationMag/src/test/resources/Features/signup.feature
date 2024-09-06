Feature: User Signup

  Scenario: Create a new account
    Given User is on the Signup page
    When User enters valid details
    And User submits the signup form
    Then User should be redirected to the dashboard

  Scenario: Sign in with created account
    Given User is on the Login page
    When User enters valid credentials
    And User submits the login form
    Then User should be logged in successfully

  Scenario: Duplicate Account Creation Error
    Given User is on the Signup page
    When User enters details with an already registered email
    And User submits the signup form
    Then An error message should be displayed indicating the email is already in use

  Scenario: Weak Password Error
    Given User is on the Signup page
    When User enters valid details but with a weak password
    And User submits the signup form
    Then An error message should be displayed indicating the password is too weak

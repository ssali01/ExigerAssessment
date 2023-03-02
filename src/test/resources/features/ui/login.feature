@smoke
Feature: Login Functionality
  1. As a user I should be able to log in to the website successfully.
  2. "Invalid credentials" should be displayed when user enters invalid credentials

  Background:
    Given the user is on the login page

  Scenario: Valid credentials
    When user enters valid username and password
    And clicks on the login button
    Then user should be logged in successfully
    And user should see the dashboard page


  Scenario: Invalid credentials
    When user enters invalid username and password
    And clicks on the login button
    Then I should see an error message


  Scenario: User enters invalid credentials
    When user enters invalid data
      | username         | password |
      | mike@example.com | 45635qiq |
      | luk@example.com  | 123456   |
    Then an error message should be displayed


  Scenario Outline: User can log in with invalid credentials
    When user enters  "<username>" and "<password>"
    And user clicks on the login button
    Then I should see an error message
    Examples:
      | username         | password |
      | alice            | p@ssw0rd |
      | bob              | secret   |
      | mike@example.com | 45635qiq |
      | luk@example.com  | 123456   |





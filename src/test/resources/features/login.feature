
Feature: Login Functionality
  1. As a user I should be able to log in to the website successfully.
  2. "Invalid credentials" should be displayed when user enters invalid credentials

  Background:
    Given the user is on the login page

  @ui
  Scenario: Valid credentials
    When user enters valid username and password
    And clicks on the login button
    Then user should be logged in successfully
    And user should see the dashboard page

  @ui
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


  @api
  Scenario: positive login
    Given user loggs in with valid credentials
    When user sends get request to "this" endpoint
    Then status code should be 200
    And content type is "application/json"

  Scenario: negative login
    Given user loggs in with invalid credentials
    When user sends get request to "this" endpoint
    Then status code should be 401
    And content type is "application/json"



# UI vs API --> Three point verification
  Scenario: two point verification
    When user enters valid username and password
    And clicks on the login button
    And user in dashboard page
    And user logged "application" api
    When user sends get request to "/api/users/me" endpoint
    Then UI,API, DB muct match with user information



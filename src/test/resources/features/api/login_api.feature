#Possible API scenario
@api
Feature: Login Functionality
  1. As a user I should be able to log in to the website successfully.
  2. "Invalid credentials" should be displayed when user enters invalid credentials

  Background:
    Given the user is on the login page
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

Feature: Login

  In order to consume ESPN content
  As a valid user
  I want to login successfully

  Scenario: Login successful
    Given navigation to login page
    When enter valid credentials "<email>" "<password>"
    Then should be taken to main page

Feature: ESPN workflow
  In order to consume ESPN content
  As a valid user
  The sign up process must be successfully, then is possible to interact through the page

  Background:
    Given Browser has home ESPN page open

  @WebTestAutomation
  Scenario Outline: As a valid user, it can interact in ESPN home page and watch page
    Given User is successful sign up and is logged in "<name>" "<lastname>" "<password>"
    When User goes to the watch page
    Then The watch page elements should be displayed
    And User should be able to return to home page "<name>"
    And User can logout from ESPN session

    Examples:
      | name      | lastname       | password       |
      | test-name | test-last-name | test-TO-delete |
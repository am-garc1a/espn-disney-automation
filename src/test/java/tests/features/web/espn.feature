Feature: ESPN workflow
  In order to consume ESPN content
  As a valid user
  The sign up process must be successfully, then is possible to interact through the page

  @WebTestAutomation
  Scenario Outline: As a valid user, it can interact in ESPN home page and watch page
    Given Browser is open on ESPN page
    When User is successful signed up and is logged in "<name>" "<lastname>" "<password>"
    Then User goes to watch page and its elements must be displayed
    And User should be able to return to home page "<name>"
    And User can logout from ESPN session

    Examples:
      | name      | lastname       | password       |
      | test-name | test-last-name | test-TO-delete |
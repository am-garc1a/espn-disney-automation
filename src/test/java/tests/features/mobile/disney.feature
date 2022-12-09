Feature: Disney workflow
  In order to consume Disney app content
  As a Disney app user
  User can navigate through different sections in the app

  Background:
    Given User is in Dashboard screen

  Scenario: User can interact in map screen and its category list
    Given User is in map screen
    When User clicks category list button
    Then Categories, including hotels option should be displayed
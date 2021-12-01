Feature: Tags Filter under Fleet-Vehicles Page

  Background:
    Given the user is on the login page
    And the user logged in as "store manager"
    And the user click on the "Fleet" tab "Vehicles" module as user "store manager"

  Scenario: User can select tags filter
    Given the user click on the filters button
    Then the user can select the "Tags" under manage filters


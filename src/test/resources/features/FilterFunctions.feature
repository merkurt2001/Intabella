Feature: Filter Functions

  Background:
    Given the user is on the login page
    And the user logged in as "sales manager"
    And the user click on the "Fleet" tab "Vehicles" module as user "sales manager"
#    Then the user is on the General Information page


  Scenario: "Manage Filter" button should be hidden by default
    Given the user clicks on the Filters button
    Then "Manage Filter" button is hidden by default

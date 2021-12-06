#Store Manager should be able to "Create Car" with valid credentials and Form data structure should be as below ("Entity Saved" message should be displayed ONLY after successful saving with valid credentials.
Feature: As a user (store manager) I should be able to create a vehicle

  @createCar
  Scenario Outline:
    Given the user goes to the login page
    When the user logged in as <username> and <password>
    Then the user hover over Fleet
    Then the user clicks on Vehicles menu item
    Then the user click on Create car button
    Then the user lands on Create Car Form
    And All form elements should be filled according to their types
    Examples:
      | username         | password      |
      | storemanager85 | UserUser123 |

##Examples:
##  | userType      | username        | password    | land            |
##  | store manager | storemanager85  | UserUser123 | Dashboard       |
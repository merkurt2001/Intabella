@dgn
Feature: Vehicle Table Arrangements

  Background:
    Given the user is on the login page
    And the user logged in as "driver"
    And the user click on the "Fleet" tab "Vehicles" module as user "driver"
   @INN-1058
    Scenario: 1-User can arrange rows/vehicle numbers to be displayed by clicking on 'View Per Page' button under Fleet-Vehicles module
    * User click to View per page button
      * user verify if the value of View per page is 25
  @INN-1059
    Scenario: 2-The value of 'View Per Page' should be '25' by default
    * user verify if the value of View per page is 25
  @INN-1060
  Scenario: 3- 'View Per Page' includes the values shown as below and user can select each of them:10, 25,50,100
    * User click to View per page button
      * User select each of the options
  @INN-1061
    Scenario: 4-User can sort a column in ascending or descending order by clicking the column name
    * user should click on the model year module
    * user verify if the model year  colum is on decending
  @INN-1062
    Scenario: 5-User can remove all sortings and filterings on the page by using the reset button
      * User click to View per page button
      * user choose the 50 options from the View per page dropdown
      * user should click the reset button
      * user verify if the value of View per page is 25
Feature: Vehicle Table Arrangements

  Background:
    Given the user is on the login page
    And the user logged in as "driver"
    And the user clicks on the Fleet tab Vehicles module

    Scenario: 1-User can arrange rows/vehicle numbers to be displayed by clicking on 'View Per Page' button under Fleet-Vehicles module
    * User click to View per page button

    Scenario: 2-The value of 'View Per Page' should be '25' by default
    * user verify if the value of View per page is 25
    Scenario: 3- 'View Per Page' includes the values shown as below and user can select each of them:10, 25,50,100
    * user should click on view per page icon
      * User select  one of the options
    Scenario: 4-User can sort a column in ascending or descending order by clicking the column name
    * user should click on the model year module
    * user verify if the model year  colum is on decending
    Scenario: 5-User can remove all sortings and filterings on the page by using the reset button
    * user should click on the model year module
    * user should click the reset button
    * user vefiry if model year module is back on default
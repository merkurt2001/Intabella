@INN-1071
Feature:

  Background:
		#@INN-1066
    Given the user is on the login page


  @INN-1064
  Scenario Outline: Verify that all users can see the delete button by hovering over the three dots at the end of each row
    Given the "<userType>" enters the username "<username>" and password "<password>" information
    And the user click on the "Fleet" tab "Vehicles" module as user "<userType>"
    Then the "<userType>" should see delete button by hovering over end of the page
    Examples:

      | userType      | username        | password    |
      | driver        | user1           | UserUser123 |
      | sales manager | salesmanager103 | UserUser123 |
      | store manager | storemanager85  | UserUser123 |


  @INN-1065
  Scenario: Verify that  "Delete Confirmation" pop up should be displayed when the user clicks on the delete button
    And the user logged in as "driver"
    And the user click on the "Fleet" tab "Vehicles" module as user "driver"
    And the "driver" should see delete button by hovering over end of the page
    When the driver clicks on the delete button
    Then the user should see "Delete Confirmation" pop up

  @INN-1067
  Scenario: Verify that "You do not have permission to perform this action." message should be displayed if the driver clicks on the "Yes, Delete" button
    And the user logged in as "driver"
    And the user click on the "Fleet" tab "Vehicles" module as user "driver"
    And the driver clicks on the delete button
    And the user click "Yes, Delete" button.
    Then "You do not have permission to perform this action." message should be displayed


  @INN-1068
  Scenario Outline: Verify that 'Sales Manager' and 'Store Manager' can delete any car by clicking on the delete button at the end of each row and the "Item deleted" message should be displayed
    Given the "<userType>" enters the username "<username>" and password "<password>" information
    And the user click on the "Fleet" tab "Vehicles" module as user "<userType>"
    And the manager clicks on the delete button
    When the user click "Yes, Delete" button.
    Then the user should see  "Item deleted" message
    Examples:
      | userType      | username        | password    |
      | sales manager | salesmanager103 | UserUser123 |
      | store manager | storemanager85  | UserUser123 |


  @INN-1069
  Scenario Outline: Verify that when 'Sales Manager' and 'Store Manager' go to the 'General Information' page by clicking on any vehicle/row, they can delete any vehicle by clicking on the 'Delete' button and the "Car deleted" message should be displayed
    Given the "<userType>" enters the username "<username>" and password "<password>" information
    And the user click on the "Fleet" tab "Vehicles" module as user "<userType>"
    When the user click row and click the delete button
    Then the "Car deleted" message should be displayed.
    Examples:
      | userType      | username        | password    |
      | sales manager | salesmanager103 | UserUser123 |
      | store manager | storemanager85  | UserUser123 |


  @INN-1070
  Scenario Outline: Verify that when 'Sales Manager' and 'Store Manager' delete a car, the corresponding car should also be removed from the Fleet-Vehicle page.
    Given the "<userType>" enters the username "<username>" and password "<password>" information
    And the user click on the "Fleet" tab "Vehicles" module as user "<userType>"
    And the user chooses the row
    When the user click row and click the delete button
    Then Deleted item should not be in vehicles page
    Examples:
      | userType      | username        | password    |
      | sales manager | salesmanager103 | UserUser123 |
      | store manager | storemanager85  | UserUser123 |
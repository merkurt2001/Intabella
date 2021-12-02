Feature: Delete Car

  Background:
    Given the user is on the login page


@delete
Scenario Outline: All users can see the delete button by hovering over the three dots at the end of each row

  When the "<userType>" enters the username "<username>" and password "<password>" information
  And the user clicks on the "Fleet" "Vehicles" module
  Then the user should see delete button by hovering over end of the page
  Examples:
    | userType      | username        | password    |
    | driver        | user1           | UserUser123 |
    | sales manager | salesmanager103 | UserUser123 |
    | store manager | storemanager85  | UserUser123 |

  @deleteCon
  Scenario: "Delete Confirmation" pop up should be displayed when the user clicks on the delete button
    Given the user enters the username "user1" and password "UserUser123" information
    And the user clicks on the "Fleet" "Vehicles" module
    When the user clicks on the delete button
    Then the user should see "Delete Confirmation" pop up

  @deleteYes
  Scenario:"You do not have permission to perform this action." message should be displayed if the driver clicks on the "Yes, Delete" button
    Given the user enters the username "user1" and password "UserUser123" information
    And the user clicks on the "Fleet" "Vehicles" module
    And the user clicks on the delete button
    And the user click "Yes, Delete" button.
    Then "You do not have permission to perform this action." message should be displayed

   @deleteItem
    Scenario Outline: Sales Manager and Store Manager can delete any car by clicking on the delete button at the end of each row and the "Item deleted" message should be displayed
      Given the "<userType>" enters the username "<username>" and password "<password>" information
      And the user clicks on the "Fleet" "Vehicles" module
      And the user clicks on the delete button
      When the user click "Yes, Delete" button.
      Then the user should see  "Item deleted" message
      Examples:
        | userType      | username        | password    |
        | sales manager | salesmanager103 | UserUser123 |
        | store manager | storemanager85  | UserUser123 |







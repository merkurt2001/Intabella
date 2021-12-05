@wip
Feature: Add Event-1

  Background:
    Given the user is on the login page

  Scenario: User can access the "Add Event" page from the "General Information" page

    When the user logged in as "sales manager"
    And the user navigates to "Fleet" "Vehicles"
    And the user clicks on the first row in the list
    Then the user should be able to see Add Event button displayed on the top right corner next to Delete button

  Scenario Outline: Sales Manager and Store manager can click "Add Event" button

    When the user logged in as "<userType>"
    And the user navigates to "Fleet" "Vehicles"
    And the user clicks on the first row in the list
    Then the "<userType>" should be able to see Add Event button displayed on the top right corner next to Delete button

    Examples:
      | userType      |
      | sales manager |
      | driver        |

  Scenario: Driver cannot see Add Event Button

    When the user logged in as "driver"
    And the user navigates to "Fleet" "Vehicles"
    And the user clicks on the first row in the list
    Then the "driver" should not be able to see Add Event Button

  Scenario: After clicking on "Add event" button, "Add Event" page should pop up

    When the user logged in as "sales manager"
    And the user navigates to "Fleet" "Vehicles"
    And the user clicks on the first row in the list
    And the user clicks on the Add Event button
    Then Add Event page should pop up

  Scenario:Compulsory fields are shown in pop-up page

    When the user logged in as "sales manager"
    And the user navigates to "Fleet" "Vehicles"
    And the user clicks on the first row in the list
    And the user clicks on the Add Event button
    Then the compulsory fields should be displayed as follows
      | Title*                  |
      | Owner*                  |
      | Organizer display name* |
      | Organizer email*        |
      | Start*                  |
      | End*                    |

    Scenario:  If any compulsory field is not filled, "This value should not be blank." message
               should be displayed after clicking on save button.
      When the user logged in as "sales manager"
      And the user navigates to "Fleet" "Vehicles"
      And the user clicks on the first row in the list
      And the user clicks on the Add Event button
      And the user fills in the compulsory fields with some inputs and and leave some fields empty
      And the user clicks on the Save button
      Then This value should not be blank message should be displayed after clicking on save button












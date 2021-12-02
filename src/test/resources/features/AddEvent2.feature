@morning
Feature: Add Event 2

  Background:
    Given the user is on the login page
    Then the user logged in as "sales manager"
    And the user click on the "Fleet" tab "Vehicles" module as user "sales manager"
    Then the user is on the General Information page


  Scenario:1- User can access the "Add Event" page from the "General Information" page
            (by clicking on any vehicle/row under Fleet-Vehicle module)
    Given the user see the Add Event button at the upper right most corner

  Scenario:2- After clicking on "Add event" button, "Add Event" page should pop up.
    Given the user clicks on the Add Event button and Add Event pop up

  Scenario:3- User can mark the event with any colour
    Given the user clicks any desired colour in the Color selection
  @rrapi
  Scenario:  4- User can mark it as an "All-day event"
    Given the user clicks the All-day event box

  @MAY
  Scenario Outline: 5A- User can repeat the action by specifying occurrence periods
    Given the user clicks on the Repeat box
    Then the user clicks the Repeats dropdown menu
    Then the user checks "<Repeat options>"

    Examples:
      | Repeat options |
      | Daily          |
      | Weekly         |
      | Monthly        |
      | Yearly         |

  Scenario Outline: 5B- User can repeat the action by specifying ending time
    Given the user clicks on the Repeat box
    And the user clicks on Ends button
    Then the user checks if "<Ending options>" are clickable

    Examples:
      | Ending options |
      | Never          |
      | After          |
      | By             |

    Scenario: 6- All Users can see all events in the General information page
      Given the user enters the desired event in the "Title" box
      Then the user fills in the Description box with a brief explanation regarding the event
      Then the user clicks on the Repeat box
      Then the user clicks on Ends button
      And the user clicks on the Save icon

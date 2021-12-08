@morning
Feature: Add Event 2

#  @INN-1091
  Background:
    Given the user is on the login page
    Then the user logged in as "sales manager"
    And the user click on the "Fleet" tab "Vehicles" module as user "sales manager"
    Then the user is on the General Information page

  @INN-1092
  Scenario:1- User can access the "Add Event" page from the "General Information" page
  (by clicking on any vehicle/row under Fleet-Vehicle module)
    Given the user see the Add Event button at the upper right most corner

  @INN-1094
  Scenario:2- After clicking on "Add event" button, "Add Event" page should pop up.
    Given the user clicks on the Add Event button and Add Event pop up

  @INN-1095
  Scenario:3- User can mark the event with any colour
    Given the user clicks any desired colour in the Color selection

  @INN-1096
  Scenario:  4- User can mark it as an "All-day event"
    Given the user clicks the All-day event box

  @INN-1097
  Scenario: 5A- User can repeat the action by specifying occurrence periods
    Given the user clicks on the Add Event button and Add Event pop up
    Given the user clicks on the Repeat box
    Then the user clicks the Repeats dropdown menu
    And the user should be able to see "Daily" "Weekly" "Monthly" "Yearly"

  @INN-1098
  Scenario: 5B- User can repeat the action by specifying ending time
    Given the user clicks on the Add Event button and Add Event pop up
    Given the user clicks on the Repeat box
    And the user should be able to click "End" radio button
    Then the user should be able to see "Never" "After" "By"


  @INN-1099
  Scenario: 6- All Users can see all events/activities in the General information page
    Given the user clicks on the Add Event button and Add Event pop up
    Given the user fills the form
    Then the user sees all events_activities in the General information page
#    Given the user fills in only Title* input box and leaves the rest empty
#    Then the user fills in the Description box with a brief explanation regarding the event
#    And the user clicks on the Save button
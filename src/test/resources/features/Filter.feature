Feature: Filter Functions

  Background:
    Given the user is on the login page
    And the user logged in as "sales manager"
    And the user click on the "Fleet" tab "Vehicles" module as user "sales manager"

  @INN-1044
  Scenario: Manage Filter button should be hidden by default
    Then Manage Filter button is hidden by default

  @INN-1045
  Scenario:  When a user clicks on the filter icon, the "Manage Filter" button should be visible
    When the user clicks on the Filters button
    Then Manage Filter button should be visible

  @INN-1046
  Scenario Outline: User can apply filters by clicking on the filter name, from the 'Manage Filters' menu
    When the user clicks on the Filters button
    And the user clicks on Manage filters dropdown menu
    Then the user can select the "<filterName>" under manage filters dropdown
    Then the user can apply filters for "<filterName>" user
    Examples:
      | filterName        |
      | License Plate  |
      | Tags           |
      | Driver         |
      | Location       |
      | Chassis Number |
      | Model Year     |

    #not done, I cant get class atr text to compare in last step
  @INN-1047
  Scenario Outline: User can find a filter by typing the filter name, from the 'Manage Filters' menu.
    When the user clicks on the Filters button
    And the user clicks on Manage filters dropdown menu
    Then User can find a filter by typing the filter name "<filterName>"
    Examples:
      | filterName |
      | Location   |

    #not very best solution???
  @INN-1048
  Scenario:  User can apply multiple filters at the same time

    When the user clicks on the Filters button
    And the user clicks on Manage filters dropdown menu
    And the user clicks on several filter name from Manage filters menu
    Then the user can apply filters

  @INN-1049 # last step not complete
  Scenario: User can remove all filters by clicking on the reset icon, under the 'Fleet-Vehicles' module
    When the user clicks on the Filters button
    And the user clicks on Manage filters dropdown menu
    And the user clicks on several filter name from Manage filters menu
    Then the user can apply filters
    Then user clicks on reset icon
    Then the user can remove all filters
Feature: Tags Filter under Fleet-Vehicles Page

  Background:
    Given the user is on the login page
    And the user logged in as "store manager"
    And the user click on the "Fleet" tab "Vehicles" module as user "store manager"

  Scenario: User can select tags filter
    Given the user click on the filters button
    Then the user can select the "Tags" under manage filters

  Scenario: tags filter should provide "Is Any Of" and "Is Not Any Of" methods
    Given the user click on the filters button
    Then the user can select the "Tags" under manage filters
    When the user click "Tags":All button
    Then the user click default button under "Tags" filter
    Then the user should see following methods under "Tags" filter
      | Is Any Of     |
      | Is Not Any Of |

  Scenario: the user selects "Is any Of" method with "Compact" option, the table should include the corresponding value
    Given the user click on the filters button
    Then the user can select the "Tags" under manage filters
    And the user click "Tags":All button
    Then the user click default button under "Tags" filter
    Then the user click "Is Any Of" method under "Tags" filter
    And the user click choose values button and select "Compact"
    Then the user click update under "Tags" filter
    Then verify the table should include corresponding "Compact" under "Tags" column




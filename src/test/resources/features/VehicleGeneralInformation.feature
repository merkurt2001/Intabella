Feature: Vehicle General Information

  Background:
    Given the user is on the login page
    And the user logged in as "driver"
    And the user clicks on the "Fleet" "Vehicle" module
  @wip
  Scenario: User can see the General Information page by clicking on any vehicle (row)
    And the user should see the General Information page on any vehcle
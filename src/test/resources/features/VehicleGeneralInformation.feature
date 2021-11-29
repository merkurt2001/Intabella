Feature: Vehicle General Information

  Background:
    Given the user is on the login page
    And the user logged in as "sales manager"
    And the user click on the "Fleet" tab "Vehicles" module as user "sales manager"

  Scenario: User can see the General Information page by clicking on any vehicle (row)
    And the user should see the General Information by clicking on any vehicle row


    Scenario: User can see the General Information Page by clicking on the Eye icon
      And the user can see the General Information page by clicking the Eye icon

  @wip
    Scenario: Manager's should see Delete Edit and Add Event on the General Information page
    When the "sales manager" clicks on any vehicle row and he lands to the General Information page he should see the Delete Edit and Add Event buttons


    Scenario: Driver should not see Add Event Edit Delete buttons
      When the user by clicking on any vehicle row navigates to General Information page
      Then the user should not have any Add Event Edit Delete buttons


    Scenario: information should be the same as on General Information and Fleet-Vehicle page
      And information should be the same

@Reg
Feature: Vehicle General Information

  Background:
    Given the user is on the login page
#    And the user logged in as "driver"
#    And the user click on the "Fleet" tab "Vehicles" module as user "userType"
#    Then the user is on the General Information page

  @alisBiu
  Scenario Outline: User can see the General Information page by clicking on any vehicle (row) <userType>
    When the "<userType>" enters the username "<username>" and password "<password>" information
    And the user click on the "Fleet" tab "Vehicles" module as user "<userType>"
    Then the user should see the General Information by clicking on any vehicle row
    Examples:
      | userType      | username        | password    |
      | driver        | user1           | UserUser123 |
      | sales manager | salesmanager103 | UserUser123 |
      | store manager | storemanager85  | UserUser123 |



  @llau
    Scenario Outline: User can see the General Information Page by clicking on the Eye icon <userType>
      When the "<userType>" enters the username "<username>" and password "<password>" information
      And the user click on the "Fleet" tab "Vehicles" module as user "<userType>"
      Then the user can see the General Information page by clicking the Eye icon "<userType>"
      Examples:
        | userType      | username        | password    |
        | driver        | user1           | UserUser123 |
        | sales manager | salesmanager103 | UserUser123 |
        | store manager | storemanager85  | UserUser123 |



  @rrushi
    Scenario Outline: Manager's should see Delete Edit and Add Event on the General Information page <userType>
      When the "<userType>" enters the username "<username>" and password "<password>" information
      And the user click on the "Fleet" tab "Vehicles" module as user "<userType>"
      Then the "<userType>" clicks on any vehicle row and he lands to the General Information page he should see the Delete Edit and Add Event buttons
      Examples:
        | userType      | username        | password    |
        | sales manager | salesmanager103 | UserUser123 |
        | store manager | storemanager85  | UserUser123 |




    Scenario Outline: Driver should not see Add Event Edit Delete buttons
      When the "<userType>" enters the username "<username>" and password "<password>" information
      And the user click on the "Fleet" tab "Vehicles" module as user "<userType>"
      Then driver navigates to GIP he should not see Add Event, Edit, Delete buttons
      Examples:
        | userType      | username        | password    |
        | driver        | user1           | UserUser123 |





    Scenario Outline: Information should be the same as on General Information and Fleet-Vehicle page <userType>
      When the "<userType>" enters the username "<username>" and password "<password>" information
      And the user click on the "Fleet" tab "Vehicles" module as user "<userType>"
      Then information should be the same
      Examples:
        | userType      | username        | password    |
        | driver        | user1           | UserUser123 |
        | sales manager | salesmanager103 | UserUser123 |
        | store manager | storemanager85  | UserUser123 |
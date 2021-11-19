Feature: Alisbiu


  Scenario Outline: The system shouldn't allow users to login without valid credentials
    Given the user is on the login page
    And the user enters the username "<username>" and password "<password>" information
    When the user copy the url after log in
    And the user log out
    Then the user can not login with paste the url to browser

    Examples:
      | username        | password    |
      | user1           | UserUser123 |
      | salesmanager103 | UserUser123 |
      | storemanager85  | UserUser123 |

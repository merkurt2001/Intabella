Feature: As a user I should be able to log out

  Scenario Outline: User can log out <userType>
    Given the user is on the login page
    And the "<userType>" enters the username "<username>" and password "<password>" information
    When the user log out
    Then the user should land at login page

    Examples:
      | userType      | username        | password    |
      | driver        | user1           | UserUser123 |
      | sales manager | salesmanager103 | UserUser123 |
      | store manager | storemanager85  | UserUser123 |


    Scenario Outline: user can not go to home page by clicking step back button <userType>
      Given the user is on the login page
      And the "<userType>" enters the username "<username>" and password "<password>" information
      When the user log out
      Then the user can go back to home page by clicking the step back arrow button

      Examples:
        | userType      | username        | password    |
        | driver        | user1           | UserUser123 |
        | sales manager | salesmanager103 | UserUser123 |
        | store manager | storemanager85  | UserUser123 |

  @wip
    Scenario Outline: user should log out if cole the open tab <userType>
      Given the user is on the login page
      And the "<userType>" enters the username "<username>" and password "<password>" information
      When the user close the current tab or all the others
      Then user should loged out

      Examples:
        | userType      | username        | password    |
        | driver        | user1           | UserUser123 |
        | sales manager | salesmanager103 | UserUser123 |
        | store manager | storemanager85  | UserUser123 |


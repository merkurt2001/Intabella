Feature: All users can log in with valid credentials


  Scenario Outline: Login with different accounts <userType>
    Given the user is on the login page
    When the "<userType>" enters the username "<username>" and password "<password>" information
    Then the "<userType>" should land on "<land>"

    Examples:
      | userType      | username        | password    | land            |
      | driver        | user1           | UserUser123 | Quick Launchpad |
      | sales manager | salesmanager103 | UserUser123 | Dashboard       |
      | store manager | storemanager85   | UserUser123 | Dashboard       |


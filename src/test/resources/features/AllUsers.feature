Feature: All users can see their own usernames in profile menu, after successful login


  Scenario Outline: user log in as agiven <userType>
    Given the user is on the login page
    Then the user enters the username "<username>" and password "<password>" information
    And the user "<userType>" can see own username "<UserName>" after successful login

    Examples:
      | userType      | username        | password    | UserName |
      | driver        | user1           | UserUser123 | John Doe |
      | sales manager | salesmanager103 | UserUser123 | John Doe |
      | store manager | storemanager85  | UserUser123 | John Doe |


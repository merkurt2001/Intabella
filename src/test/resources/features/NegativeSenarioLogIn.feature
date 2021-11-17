Feature: Negative Log in senario

  Scenario Outline: Login functions with invalid info for different user
    When the user logs in using following credentials "<username>" and "<password>"
    Then the following "<message>" should be displayed

    Examples:
      | username        | password    | message                        |
      | user            | wrong       | Invalid user name or password. |
      | user1           | 123         | Invalid user name or password. |
      | user            | UserUser123 | Invalid user name or password. |
      |                 |             | Please fill out this field.    |
      |                 | UserUser123 | Please fill out this field.    |
      | user1           |             | Please fill out this field.    |
      | salesmanager101 | 123         | Invalid user name or password. |
      | user            | UserUser123 | Invalid user name or password. |
      |                 | UserUser123 | Please fill out this field.    |
      | salesmanager101 |             | Please fill out this field.    |
      | storemanager51  | 123         | Invalid user name or password. |
      | user            | UserUser123 | Invalid user name or password. |
      |                 | UserUser123 | Please fill out this field.    |
      | storemanager51  |             | Please fill out this field.    |

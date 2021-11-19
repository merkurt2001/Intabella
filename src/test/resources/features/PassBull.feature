Feature: User should see the password in bullet signs by default


  Scenario Outline: user should not see the password
    Given the user is on the login page
    When typing anything "<typing>" in the password input box
    Then the user should see the input box field in bullet sings by default

    Examples:
      | typing     |
      | asdcadsfsd |
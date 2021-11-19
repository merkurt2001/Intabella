Feature: Verify that user can use "Enter" key from their keyboard on the login page

  Scenario: verify that user can use Enter key from keyboard
    Given the user is on the login page
    When the user clicks the username input box hits the Enter key from keyboard
    Then the user coursor should land on the password input box hits Enter again Login button should cklicked

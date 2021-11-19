Feature: User land on the "Forgot Password" page after clicking on the "Forgot your password?" link

  Scenario: user land on the "Forgot Password" page
    Given the user is on the login page
    When the user click on the Forgot Passord
    Then the user should land on the Forgot Password page
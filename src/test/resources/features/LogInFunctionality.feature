@INN-904
Feature: All users can log in with valid credentials
	@INN-896
	Scenario Outline: Login with different accounts <userType>
		Given the user is on the login page
		When the "<userType>" enters the username "<username>" and password "<password>" information
		Then the "<userType>" should land on "<land>"

		Examples:
			| userType      | username        | password    | land            |
			| driver        | user1           | UserUser123 | Quick Launchpad |
			| sales manager | salesmanager103 | UserUser123 | Dashboard       |
			| store manager | storemanager85  | UserUser123 | Dashboard       |

	@INN-897
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

	@INN-898
	Scenario Outline: user log in as a given <userType>
		Given the user is on the login page
		Then the user enters the username "<username>" and password "<password>" information
		And the user "<userType>" can see own username "<UserName>" after successful login

		Examples:
			| userType      | username        | password    | UserName |
			| driver        | user1           | UserUser123 | John Doe |
			| sales manager | salesmanager103 | UserUser123 | John Doe |
			| store manager | storemanager85  | UserUser123 | John Doe |

	@INN-899
	Scenario Outline: Login functions with invalid info for different user
		When the user logs in using following credentials "<username>" and "<password>"
		Then the following "<message>" should be displayed

		Examples:
			| username        | password    | message                        |
			| user            | wrong       | Invalid user name or password. |
			| user1           | 123         | Invalid user name or password. |
			| user            | UserUser123 | Invalid user name or password. |
			|                 |             | Please fill in this field.     |
			|                 | UserUser123 | Please fill in this field.     |
			| user1           |             | Please fill in this field.     |
			| salesmanager101 | 123         | Invalid user name or password. |
			| user            | UserUser123 | Invalid user name or password. |
			|                 | UserUser123 | Please fill in this field.     |
			| salesmanager101 |             | Please fill in this field.     |
			| storemanager51  | 123         | Invalid user name or password. |
			| user            | UserUser123 | Invalid user name or password. |
			|                 | UserUser123 | Please fill in this field.     |
			| storemanager51  |             | Please fill in this field.     |

	@INN-900
	Scenario Outline: user should not see the password
		Given the user is on the login page
		When typing anything "<typing>" in the password input box
		Then the user should see the input box field in bullet sings by default

		Examples:
			| typing     |
			| asdcadsfsd |

	@INN-901
	Scenario: user land on the "Forgot Password" page
		Given the user is on the login page
		When the user click on the Forgot Passord
		Then the user should land on the Forgot Password page
	@INN-902
	Scenario: user can see Remember me and it should be clickable
		Given the user is on the login page
		And the user should see the Remember me and should be able to clcik
	@INN-903
	Scenario: verify that user can use Enter key from keyboard
		Given the user is on the login page
		When the user clicks the username input box hits the Enter key from keyboard
		Then the user coursor should land on the password input box hits Enter again Login button should cklicked
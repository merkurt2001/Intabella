@INN-1033
Feature: Vehicle Table View

	Background:
		Given the user is on the login page
		And the user logged in as "driver"
		And the user clicks on the Fleet tab Vehicles module


	@INN-1027
	Scenario: the user can see all vehicle information under the Fleet-Vehicles module
		Given the user can see the vehicle information page
	@INN-1029
	Scenario: Users can see the total number of pages
		Given the user can see the total number of pages
	@INN-1030
	Scenario:  User can navigate back and forth clicking ">" and "<" signs
		Given that users can navigate back and forth
	@INN-1031
	Scenario: User can see total recordings of vehicles
		Given that Users can see total recordings of vehicles	
	@INN-1032
	Scenario: User can download table data in XLS or CSV format from "Export Grid" (a confirmation message is enough to validate)
		Given that users can download table data in XLS or CSV format
Feature: Guest explores Ports of Departure

Scenario: Search Honolulu Port
		Given a Guest
		And I am on Homepage
		Given I navigated to Ports page
		When I search for Honolulu port
		Then Map zoomed to show selected port
		And Port is on the middle of the map
		And Port displayed as Port Of Departure
	  	 

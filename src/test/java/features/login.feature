
Feature: Dashboard feature

  Background: Login with valid credentials
    Given user is on login page 
    When user hover to signin button
    And user enters username
    And user enters password 
    And user clicks on login 
    Then user is redirected to dashbord
    
		@Smoke
    Scenario: navigate to search hotel screen
    Given user is on dashboard page 
    When user click on book tab
    And user clicks on hotels
    Then user is redirected to search hotel page
    
        
 		@smoke
    Scenario: navigate to search hotel screen
    Given user is on dashboard page 
    When user click on book tab
    
 
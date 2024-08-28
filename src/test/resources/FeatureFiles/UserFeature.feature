Feature: User

  Background: 
    Given I enter skillrary login page
    And I login to the skillrary

  Scenario: Add User
    When I click on Users
    And I create new user
    Then New User should be added to the Users list
    When I delete newly added user
    Then User should be deleted from the Users list
    And I logout of skillrary

@category
Feature: Category

  Background: 
    Given I enter skillrary login page
    And I login to the skillrary

  Scenario Outline: Add Category
    When I click on Courses tab and choose Category
    And I create a new category with <name>
    Then New category should be added to the category list
    When I delete the newly added category
    Then Newly added category should be removed from the list
    And I logout of skillrary

    Examples: 
      | name              |
      | MEAN Stack        |
      | Python Full Stack |

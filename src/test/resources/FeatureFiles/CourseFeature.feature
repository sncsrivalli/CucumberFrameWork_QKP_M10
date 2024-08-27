Feature: Course

  Scenario: Add Course
    Given I enter skillrary login page
    And I login to the skillrary
    When I click on Courses tab and choose Course List
    And I create a new course
      | UiPath                                                      |
      | Testing                                                     |
      |                                                        1500 |
      | C:\\Users\\sncsr\\Downloads\\Screenshot_20220810-174027.png |
      | Automation Testing Tool                                     |
    Then New course should be added to the course list
    When I delete the newly added course
    Then Newly added course should be removed from the list
    And I logout of skillrary
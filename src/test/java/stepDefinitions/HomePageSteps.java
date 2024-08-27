package stepDefinitions;

import genericUtilities.TestContextSetUp;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import objectRepository.HomePage;

public class HomePageSteps {

	TestContextSetUp testContextSetUp;
	HomePage home;

	public HomePageSteps(TestContextSetUp testContextSetUp) {
		this.testContextSetUp = testContextSetUp;
	}

	@When("I click on Users")
	public void i_click_on_users() {
		home = testContextSetUp.pageObject.getHomePage();
		home.clickUsersTab();
	}

	@When("I click on Courses tab and choose Category")
	public void i_click_on_courses_tab_and_choose_category() {
		home = testContextSetUp.pageObject.getHomePage();
		home.navigateToCategoryPage();
	}

	@When("I click on Courses tab and choose Course List")
	public void i_click_on_courses_tab_and_choose_course_list() {
		home = testContextSetUp.pageObject.getHomePage();
		home.navigateToCourseListPage();
	}

	@And("I logout of skillrary")
	public void i_logout_of_skillrary() {
		home.signoutOfApp();
	}
}

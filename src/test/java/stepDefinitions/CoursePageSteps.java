package stepDefinitions;

import java.util.List;

import genericUtilities.TestContextSetUp;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import objectRepository.AddNewCoursePage;
import objectRepository.CourseListPage;

public class CoursePageSteps {

	TestContextSetUp testContextSetUp;
	CourseListPage course;
	AddNewCoursePage addCourse;
	String courseName;

	public CoursePageSteps(TestContextSetUp testContextSetUp) {
		this.testContextSetUp = testContextSetUp;
	}

	@And("I create a new course")
	public void i_create_a_new_course(List<Object> list) {
		course = testContextSetUp.pageObject.getCourseListPage();
		addCourse = testContextSetUp.pageObject.getAddNewCoursePage();

		course.clickNewButton();

		courseName = (String) list.get(0);
		addCourse.setName(courseName);
		addCourse.selectCategory(testContextSetUp.web, (String) list.get(1));
		addCourse.setPrice((String) list.get(2));
		addCourse.uploadPhoto((String) list.get(3));
		addCourse.addDescription(testContextSetUp.web, (String) list.get(4));
		addCourse.clickSave();
	}

	@Then("New course should be added to the course list")
	public void new_course_should_be_added_to_the_course_list() {
		System.out.println(course.getSuccessAlert());
	}

	@When("I delete the newly added course")
	public void i_delete_the_newly_added_course() {
		course.deleteCourse(testContextSetUp.web, courseName);
	}

	@Then("Newly added course should be removed from the list")
	public void newly_added_course_should_be_removed_from_the_list() {
		System.out.println(course.getSuccessAlert());
	}
}

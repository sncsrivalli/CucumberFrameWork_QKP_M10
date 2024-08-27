package stepDefinitions;

import genericUtilities.TestContextSetUp;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import objectRepository.AddNewCategoryPage;
import objectRepository.CategoryPage;

public class CategoryPageSteps {

	TestContextSetUp testContextSetUp;
	CategoryPage category;
	AddNewCategoryPage addCategory;
	String categoryName;
	
	public CategoryPageSteps(TestContextSetUp testContextSetUp) {
		this.testContextSetUp = testContextSetUp;
	}
	
	@And("^I create a new category with (.*)$")
	public void i_create_a_new_category_with_name(String name) {
		addCategory = testContextSetUp.pageObject.getAddNewCategoryPage();
		categoryName = name;
		addCategory.setNameTF(categoryName);
		addCategory.clickSaveButton();
	}

	@Then("New category should be added to the category list")
	public void new_category_should_be_added_to_the_category_list() {
		System.out.println(category.getSuccessAlert());
	}

	@When("I delete the newly added category")
	public void i_delete_the_newly_added_course() {
		category.deleteCategory(testContextSetUp.web, categoryName);
	}

	@Then("Newly added category should be removed from the list")
	public void newly_added_course_should_be_removed_from_the_list() {
		System.out.println(category.getSuccessAlert());
	}
}

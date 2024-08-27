package stepDefinitions;

import java.util.Map;

import genericUtilities.ExcelUtility;
import genericUtilities.IConstantPath;
import genericUtilities.TestContextSetUp;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import objectRepository.AddNewUserPage;
import objectRepository.UsersPage;

public class UsersPageSteps {

	TestContextSetUp testContextSetUp;

	public UsersPageSteps(TestContextSetUp testContextSetUp) {
		this.testContextSetUp = testContextSetUp;
	}
	
	@And("I create new user")
	public void i_create_new_user() {
		UsersPage user = testContextSetUp.pageObject.getUsersPage();
		AddNewUserPage addUser = testContextSetUp.pageObject.getAddNewUsersPage();
		
		user.clickNewButton();
		
		ExcelUtility excel = new ExcelUtility();
		excel.excelInit(IConstantPath.EXCEL_PATH);
		
		Map<String, String> map = excel.readFromExcel("Sheet1", "Add User");
		addUser.setEmail(map.get("Email"));
		addUser.setPwd(map.get("Password"));
		addUser.setFirstName(map.get("Firstname"));
		addUser.setLastName(map.get("Lastname"));
		addUser.setAddress(map.get("Address"));
		addUser.setContact(map.get("Contact Info"));
		addUser.uploadPhoto(map.get("Photo"));
		addUser.clickSave();
		
		excel.closeExcel();
	}

	@Then("New User should be added to the Users list")
	public void new_user_should_be_added_to_the_users_list() {
		
	}

	@When("I delete newly added user")
	public void i_delete_newly_added_user() {
		
	}

	@Then("User should be deleted from the Users list")
	public void user_should_be_deleted_from_the_users_list() {
		
	}
}

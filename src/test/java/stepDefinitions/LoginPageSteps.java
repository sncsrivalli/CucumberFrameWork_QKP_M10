package stepDefinitions;

import genericUtilities.TestContextSetUp;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import objectRepository.LoginPage;

public class LoginPageSteps {

	TestContextSetUp testContextSetUp;

	public LoginPageSteps(TestContextSetUp testContextSetUp) {
		this.testContextSetUp = testContextSetUp;
	}
	
	@Given("I enter skillrary login page")
	public void i_enter_skillrary_login_page() {
		testContextSetUp.web.navigateToApp(testContextSetUp.property.readFromProperties("url"));
	}

	@And("I login to the skillrary")
	public void i_login_to_the_skillrary() {
		LoginPage login = testContextSetUp.pageObject.getLoginPage();
		login.loginToApp(testContextSetUp.property.readFromProperties("username"), 
				testContextSetUp.property.readFromProperties("password"));
	}

}

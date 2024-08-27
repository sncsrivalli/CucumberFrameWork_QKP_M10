package stepDefinitions;

import genericUtilities.DataType;
import genericUtilities.TestContextSetUp;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class HooksSteps {

	TestContextSetUp testContextSetUp;

	public HooksSteps(TestContextSetUp testContextSetUp) {
		this.testContextSetUp = testContextSetUp;
	}

	@Before
	public void beforeScenario() {
		testContextSetUp.web.maximizeBrowser();
		long time = (Long) testContextSetUp.jutil
				.convertStringToAnyDataType(testContextSetUp.property
									.readFromProperties("timeouts"), DataType.LONG);
		testContextSetUp.web.waitTillElementFound(time);
	}

	@After
	public void afterScenario() {
		testContextSetUp.web.quitAllWindows();
	}
}

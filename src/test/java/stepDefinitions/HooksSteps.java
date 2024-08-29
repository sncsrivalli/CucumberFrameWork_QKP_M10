package stepDefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import genericUtilities.DataType;
import genericUtilities.TestContextSetUp;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

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

	@AfterStep
	public void afterStep(Scenario scenario) {
		if(scenario.isFailed()) {
			File src = testContextSetUp.web.getScreenshot(testContextSetUp.driver, 
															scenario.getName(), 
															testContextSetUp.jutil);
			byte[] byteArray = null;
			
			try {
				byteArray = FileUtils.readFileToByteArray(src);
			} catch (IOException e) {
				e.printStackTrace();
			}			
			scenario.attach(byteArray, "image/png", "failed-test");
		}
	}
	
	@After
	public void afterScenario() {
		testContextSetUp.web.quitAllWindows();
	}
}

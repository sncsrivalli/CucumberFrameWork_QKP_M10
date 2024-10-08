package testRunnerClasses;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"./src/test/resources/FeatureFiles"},
				glue = "stepDefinitions", monochrome = true,
				plugin = {"pretty",
						"html:target/HTML/report.html",
						"json:target/JSON/report.json",
						"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
						"rerun:target/failed_scenarios.txt"},
				tags = "@course or @category")

public class SkillraryTests extends AbstractTestNGCucumberTests {

	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios(){
		return super.scenarios();
	}
}

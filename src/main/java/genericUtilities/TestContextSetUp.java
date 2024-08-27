package genericUtilities;

import org.openqa.selenium.WebDriver;

import objectRepository.PageObjectManager;

public class TestContextSetUp {

	public WebDriver driver;
	public JavaUtility jutil;
	public PropertiesUtility property;
	public WebDriverUtility web;

	public PageObjectManager pageObject;
	
	public TestContextSetUp() {
		property = new PropertiesUtility();
		web = new WebDriverUtility();
		jutil = new JavaUtility();

		property.propertiesInit(IConstantPath.PROPERTIES_FILE_PATH);

		driver = web.launchBrowser(property.readFromProperties("browser"));
		
		pageObject = new PageObjectManager(driver);
	}
		
}

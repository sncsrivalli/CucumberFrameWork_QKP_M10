package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtility;

public class AddNewCoursePage {

	// Declaration
	
	@FindBy(xpath = "//b[text()='Add New Course']")
	private WebElement pageHeader;
	
	@FindBy(id = "name")
	private WebElement nameTF;
	
	@FindBy(id = "category")
	private WebElement categoryDropdown;
	
	@FindBy(id = "price")
	private WebElement priceTF;
	
	@FindBy(xpath = "(//input[@id='photo'])[2]")
	private WebElement chooseFileButton;
	
	@FindBy(xpath = "//iframe[contains(@title,'editor1')]")
	private WebElement descriptionFrame;
	
	@FindBy(xpath = "//html/body/p")
	private WebElement descriptionBox;
	
	@FindBy(name = "add")
	private WebElement saveButton;
	
	//Initialization
	
	public AddNewCoursePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	
	public boolean pageHeaderIsDisplayed() {
		if(pageHeader.isDisplayed())
			return true;
		else
			return false;
	}
	
	public void setName(String name) {
		nameTF.sendKeys(name);
	}
	
	public void selectCategory(WebDriverUtility web, String text) {
		web.handleDropdown(text, categoryDropdown);
	}
	
	public void uploadPhoto(String filePath) {
		chooseFileButton.sendKeys(filePath);
	}
	
	public void setPrice(String price) {
		priceTF.sendKeys(price);
	}
	
	public void addDescription(WebDriverUtility web, String description) {
		web.switchToFrame(descriptionFrame);
		descriptionBox.sendKeys(description);
		web.switchBackFromFrame();
	}
	
	public void clickSave() {
		saveButton.click();
	}
}

package pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePkg.BaseClass;

public class HomePage extends BaseClass{
	
	// Creating page factory:
		// 1. @FindBy annotation to create webElements
		// 2. constructor to initialize elements to driver
		// 3. define functionality/interaction to be performed in the element/s
	
	@FindBy(id="gh-ac")
	WebElement searchTxtBox; // WebElement searchTxtBox = driver.findElement(By.id("gh-ac"));
	@FindBy(id="gh-btn")
	WebElement searchBtn;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public void enterProductInSearchTxtBox(String product) {
		searchTxtBox.sendKeys(product);
	}
	
	public void clickSearchBtn() {
		searchBtn.click();
	}
	
	public void homePageMenuLinkClick(String link) {
		driver.findElement(By.linkText(link)).click();
	}
	
	public boolean homePageMenuLinkQuickPageTitleValidation(String link) {
		return driver.getTitle().contains(link);
	}
	
	public boolean homePageMenuLinkQuickPageURLValidation(String link) {
		return driver.getCurrentUrl().contains(link);
	}

}

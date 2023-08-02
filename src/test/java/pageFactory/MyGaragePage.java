package pageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePkg.BaseClass;

public class MyGaragePage extends BaseClass{
	
	@FindBy(xpath="//h2[text()='My Garage']")
	WebElement myGaragePageHeader;

	public MyGaragePage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateMyGaragePageHeader() {
		return myGaragePageHeader.isDisplayed();
	}
	
	public boolean validateMyGaragePageTitle() {
		return driver.getTitle().equals(prop.getProperty("expectedMyGaragePageTitle"));
	}

}

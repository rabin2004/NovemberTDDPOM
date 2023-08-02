package pageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePkg.BaseClass;

public class LoginPage extends BaseClass{

	@FindBy(id="userid")
	WebElement usernameTxtBox;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateUsernameTxtBoxDisplayed() {
		return usernameTxtBox.isDisplayed();
	}
	
	public boolean validateLoginPageTitle() {
		return driver.getTitle().equals(prop.getProperty("expectedLoginPageTitle"));
	}
}

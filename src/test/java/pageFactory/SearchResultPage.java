package pageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePkg.BaseClass;

public class SearchResultPage extends BaseClass{
	
	@FindBy(xpath="//*[text()='No exact matches found']")
	WebElement noResultErrorMsg;
	@FindBy(className="srp-controls__count-heading")
	WebElement searchResultHeader;
	
	public SearchResultPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateNoResultErrorMsg() {
		return noResultErrorMsg.isDisplayed();
	}
	
	public boolean validateSearchResultHeader() {
		return searchResultHeader.isDisplayed();
	}

}

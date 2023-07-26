package testPkg;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import basePkg.BaseClass;
import pageFactory.HomePage;
import pageFactory.SearchResultPage;

public class SearchFuntionalityTest extends BaseClass{
	HomePage hp;
	SearchResultPage srp;
	
	@BeforeClass
	public void loadApp() {
		initialization();
		hp = new HomePage();
		srp = new SearchResultPage();

	}

	@AfterClass
	public void closeApp() {
		tearDown();
	}

	@AfterMethod
	public void backToHomePage() {
		backToLastPage();
	}
	
	@Test(dataProviderClass = dataPkg.SearchFunctionalityTestData.class, dataProvider = "positiveSearchFunctionalityData", priority = 1)
	public void positiveSearchFunctionalityTestByClickingSearchBtn(String product) {
		hp.enterProductInSearchTxtBox(product);
		hp.clickSearchBtn();
		Assert.assertTrue(srp.validateSearchResultHeader());
	}

	@Test(enabled = true, dataProviderClass = dataPkg.SearchFunctionalityTestData.class, dataProvider = "negativeSearchFunctionalityData", priority = 3)
	public void negativeSearchFunctionalityTestByClickingSearchBtn(String invalidProduct) {
		hp.enterProductInSearchTxtBox(invalidProduct);
		hp.clickSearchBtn();
		Assert.assertTrue(srp.validateNoResultErrorMsg());
	}

}

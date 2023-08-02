package testPkg;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import basePkg.BaseClass;
import pageFactory.HomePage;
import pageFactory.SearchResultPage;

public class SearchFunctionalityTest extends BaseClass{
	HomePage hp;
	SearchResultPage srp;
	
	@BeforeClass(alwaysRun=true)
	public void loadApp() {
		initialization();
		hp = new HomePage();
		srp = new SearchResultPage();

	}

	@AfterClass(alwaysRun=true)
	public void closeApp() {
		tearDown();
	}

	@AfterMethod(alwaysRun=true)
	public void backToHomePage() {
		backToLastPage();
	}
	
	@Test(dataProviderClass = dataPkg.SearchFunctionalityTestData.class, 
			dataProvider = "positiveSearchFunctionalityData", priority = 1,
			groups= {"E2E_Test","Regression_Test","Data_Driven_Test"})
	public void positiveSearchFunctionalityTestByClickingSearchBtn(String product) {
		hp.enterProductInSearchTxtBox(product);
		hp.clickSearchBtn();
		Assert.assertTrue(srp.validateSearchResultHeader());
	}

	@Test(enabled = true, dataProviderClass = dataPkg.SearchFunctionalityTestData.class, 
			dataProvider = "negativeSearchFunctionalityData", priority = 3,
			groups= {"Integration_Test","Regression_Test","Data_Driven_Test"})
	public void negativeSearchFunctionalityTestByClickingSearchBtn(String invalidProduct) {
		hp.enterProductInSearchTxtBox(invalidProduct);
		hp.clickSearchBtn();
		Assert.assertTrue(srp.validateNoResultErrorMsg());
	}

}

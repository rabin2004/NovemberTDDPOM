package testPkg;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import basePkg.BaseClass;
import pageFactory.HomePage;
import pageFactory.LoginPage;
import pageFactory.MyGaragePage;

public class HomePageMenuLinksTest extends BaseClass{
	
	HomePage hp;
	LoginPage lp;
	MyGaragePage mgp;

	
	@BeforeClass(alwaysRun=true)
	public void loadApp() {
		initialization();
		hp = new HomePage();
		lp = new LoginPage();
		mgp = new MyGaragePage();
	}

	@AfterClass(alwaysRun=true)
	public void closeApp() {
		tearDown();
	}

	@AfterMethod(alwaysRun=true)
	public void backToHomePage() {
		backToLastPage();
	}
	
	@Test(groups="Smoke_Test")
	public void savedMenuLinkTest() {
		hp.homePageMenuLinkClick(prop.getProperty("savedLinkInHomePage"));
		Assert.assertTrue(lp.validateUsernameTxtBoxDisplayed());
		Assert.assertTrue(lp.validateLoginPageTitle());
	}
	
	@Test(dataProviderClass = dataPkg.HomePageMenuLinkData.class, 
			dataProvider = "homePageMenuLinks",
			groups= {"Smoke_Test","Regression_Test","Data_Driven_Test"})
	public void restMenuLinkTest(String link) {
		hp.homePageMenuLinkClick(link);
		Assert.assertTrue(hp.homePageMenuLinkQuickPageTitleValidation(link));
		Assert.assertTrue(hp.homePageMenuLinkQuickPageURLValidation(link));
	}
	
	// Parameterized XML:
		// 1. Define parameter in XML -> <parameter name="link" value="Saved"/>
		// 2. Method using parameter from XML -> single parameter - @Parameters("parameterName") | multiple parameter - @Parameters({"parameterName_1","parameterName_2"})
		// 3. Define method parameter
		// 4. Use method parameter in the code
		
	@Parameters("link")
	@Test(groups="Smoke_Test")
	public void menuLinkTestFromXMLparameter(String link) {
		hp.homePageMenuLinkClick(link);
		Assert.assertTrue(lp.validateUsernameTxtBoxDisplayed());
		Assert.assertTrue(lp.validateLoginPageTitle());
	}

}

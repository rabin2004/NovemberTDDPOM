package dataPkg;

import org.testng.annotations.DataProvider;

public class HomePageMenuLinkData {

	@DataProvider
	public String[] homePageMenuLinks() {
		String[] data = {	"Motors",
							"Electronics",
							"Collectibles"};
		return data;
	}
}

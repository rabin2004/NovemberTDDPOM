package dataPkg;

import org.testng.annotations.DataProvider;

public class SearchFunctionalityTestData {
	
	@DataProvider
	public String[] positiveSearchFunctionalityData() {
		String[] data = {	"apple",
							"samsung",
							"microsoft",
							"pixel",
							"nokia"};
		return data;
	}

	@DataProvider
	public String[] negativeSearchFunctionalityData() {
		String[] data = {	"329805723097590ujskdjflksdfjvnlksdvnlksdnvlksdvn",
							"329805723097591ujskdjflksdfjvnlksdvnlksdnvlksdvn",
							"329805723097592ujskdjflksdfjvnlksdvnlksdnvlksdvn"
							};
		return data;
	}
}

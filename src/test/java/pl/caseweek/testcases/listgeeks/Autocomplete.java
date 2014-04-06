package pl.caseweek.testcases.listgeeks;

import junit.framework.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.caseweek.pageobjects.listgeeks.HomePage;
import pl.caseweek.pageobjects.listgeeks.SingleListPage;
import pl.caseweek.templates.TestTemplate;

/**
 * Created by Ludwik on 05.04.14.
 */
public class Autocomplete extends TestTemplate {

	private SingleListPage singleListPage;

	private HomePage homePage;

	private static final String TITLE = "Test";
	private static final String EXPECTED_TO_SEE_IN_AUTOCOMPLETE = "Test everything";

	@BeforeMethod
	public void init(){
		homePage = new HomePage(driver);
	}

	@Test
	public void autocomplete() throws Exception {

		SingleListPage singleListPage = homePage //
				.get() //
				.mainMenu //
				.goToLatestListsPage() //
				.openList(1);

		singleListPage //
				.getListItem(0) //
				.typeTitle(TITLE);

		Assert.assertTrue(singleListPage.getListItem(0).autocompleteContains(EXPECTED_TO_SEE_IN_AUTOCOMPLETE));
	}

}

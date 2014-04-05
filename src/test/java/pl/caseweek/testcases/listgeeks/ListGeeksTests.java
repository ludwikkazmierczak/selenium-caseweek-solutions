package pl.caseweek.testcases.listgeeks;

import org.testng.annotations.Test;

import pl.caseweek.pageobjects.listgeeks.HomePage;
import pl.caseweek.templates.TestTemplate;

public class ListGeeksTests extends TestTemplate{


	@Test
	public void testNavigation() {
		HomePage homePage = new HomePage(driver);

		homePage
				.get() //
				.mainMenu //
				.goToLatestListsPage();

	}

	@Test
	public void openList() {
		HomePage homePage = new HomePage(driver);

		homePage
				.get() //
				.mainMenu //
				.goToLatestListsPage();
	}

	@Test
	public void autocomplete() throws Exception {
		String title = "Test";
		String expectedToSeeInAutocomplete = "Test everything";

		HomePage homePage = new HomePage(driver);
//		SingleListPage listPage = homePage.get().mainMenu.goToLatestListsPage();
//				.openList(1);
//		ListGeeks listElement = listPage.getListItem(3);
//		listElement.typeTitle(title);
//		boolean passed = listPage.autocompleteContains(expectedToSeeInAutocomplete);

//		Assert.assertTrue(passed, "Expected string ("+expectedToSeeInAutocomplete+") did not appear in autocomplete.");
	}

}

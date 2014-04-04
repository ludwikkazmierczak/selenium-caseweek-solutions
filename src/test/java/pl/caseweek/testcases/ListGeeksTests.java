package pl.caseweek.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pl.caseweek.pageobjects.LGListElement;
import pl.caseweek.pageobjects.LGSingleListPage;
import pl.caseweek.pageobjects.ListGeeks;
import pl.caseweek.templates.TestTemplate;

public class ListGeeksTests extends TestTemplate{


	@Test
	public void testNavigation() {
		ListGeeks listGeeks = new ListGeeks(driver);

		listGeeks.get().goToBrowseLists().goToHomePage();

	}

	@Test
	public void openList() {
		ListGeeks listGeeks = new ListGeeks(driver);

		listGeeks.get().goToBrowseLists().openList(1);
	}



	@Test
	public void autocomplete() throws Exception {
		String title = "Test";
		String expectedToSeeInAutocomplete = "Test everything";

		ListGeeks listGeeks = new ListGeeks(driver);
		LGSingleListPage listPage = listGeeks.get().goToBrowseLists().openList(1);
		LGListElement listElement = listPage.getListItem(3);
		listElement.typeTitle(title);
		boolean passed = listPage.autocompleteContains(expectedToSeeInAutocomplete);

		Assert.assertTrue(passed, "Expected string ("+expectedToSeeInAutocomplete+") did not appear in autocomplete.");
	}

}

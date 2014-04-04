package pl.caseweek.testcases;

import org.testng.annotations.Test;

import pl.caseweek.pageobjects.ListGeeks;
import pl.caseweek.templates.TestTemplate;

public class ListGeeksTests extends TestTemplate{


	@Test
	public void testNavigation() {
		ListGeeks listGeeks = new ListGeeks(driver);

		listGeeks.get().goToBrowseLists().goToHomePage();

	}

}

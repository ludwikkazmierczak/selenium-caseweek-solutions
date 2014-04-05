package pl.caseweek.testcases.listgeeks;

import org.testng.annotations.Test;
import pl.caseweek.pageobjects.listgeeks.HomePage;
import pl.caseweek.templates.TestTemplate;

/**
 * Created by Ludwik on 05.04.14.
 */
public class AddItems  extends TestTemplate {

	@Test
	public void openList() {
		HomePage homePage = new HomePage(driver);

		homePage.get().mainMenu.goToLatestListsPage().openList(1).getListItem(0).typeTitle("ZUO");

	}
}

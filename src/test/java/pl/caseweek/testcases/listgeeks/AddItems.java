package pl.caseweek.testcases.listgeeks;

import junit.framework.Assert;
import org.testng.annotations.Test;
import pl.caseweek.pageobjects.listgeeks.HomePage;
import pl.caseweek.pageobjects.listgeeks.SingleListPage;
import pl.caseweek.templates.TestTemplate;

/**
 * Created by Ludwik on 05.04.14.
 */
public class AddItems  extends TestTemplate {

	private SingleListPage singleListPage;

	@Test
	public void addList() {
		HomePage homePage = new HomePage(driver);

		singleListPage = homePage.get().mainMenu.goToLatestListsPage().openList(1);

		singleListPage.getListItem(0).typeTitle("First");

		Assert.assertTrue(singleListPage.getListItem(0).getTitle().equals("First"));

		singleListPage.getListItem(1).typeTitle("Second");

		Assert.assertTrue(singleListPage.getListItem(1).getTitle().equals("Second"));

		singleListPage.getListItem(0).typeTitle("Edited");

		Assert.assertTrue(singleListPage.getListItem(0).getTitle().equals("FirstEdited"));

		singleListPage.getListItem(1).remove();

		Assert.assertTrue(singleListPage.getListItem(1).getTitle().isEmpty());
	}
}

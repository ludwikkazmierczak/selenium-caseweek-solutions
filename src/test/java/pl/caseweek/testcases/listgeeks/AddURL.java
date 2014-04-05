package pl.caseweek.testcases.listgeeks;

import junit.framework.Assert;
import org.testng.annotations.Test;
import pl.caseweek.pageobjects.listgeeks.HomePage;
import pl.caseweek.pageobjects.listgeeks.SingleListPage;
import pl.caseweek.templates.TestTemplate;

/**
 * Created by Ludwik on 05.04.14.
 */
public class AddURL extends TestTemplate{

private SingleListPage singleListPage;

	@Test
	public void addURL() {
		HomePage homePage = new HomePage(driver);

		singleListPage = homePage.get().mainMenu.goToLatestListsPage().openList(1);

		singleListPage.getListItem(0).typeTitle("First");
		singleListPage.getListItem(0).typeLink("FirstLink");

		Assert.assertTrue(singleListPage.getListItem(0).getUrl().equals("FirstLink"));
		Assert.assertTrue(singleListPage.getListItem(0).isLinkVisible());

		singleListPage.getListItem(1).typeTitle("Second");
		singleListPage.getListItem(1).typeLink("SecondLink");

		Assert.assertTrue(singleListPage.getListItem(1).getUrl().equals("SecondLink"));
		Assert.assertTrue(singleListPage.getListItem(1).isLinkVisible());

		singleListPage.getListItem(0).typeLink("Edited");

		Assert.assertTrue(singleListPage.getListItem(0).getUrl().equals("FirstLinkEdited"));

		singleListPage.getListItem(1).toggleLinks();

		Assert.assertFalse(singleListPage.getListItem(1).isLinkVisible());
	}
}
